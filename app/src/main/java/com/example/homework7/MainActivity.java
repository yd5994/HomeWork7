package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private final String FILENAME = "rawtest.txt";

    TextView tV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tV=findViewById(R.id.textView3);


    }

    public void save(View view) {
        String fileName = FILENAME.substring(0, FILENAME.length() - 4);
        int resourceId = this.getResources().getIdentifier(fileName, "raw", this.getPackageName());
        InputStream iS = this.getResources().openRawResource(resourceId);
        InputStreamReader iSR = new InputStreamReader(iS);
        BufferedReader bR = new BufferedReader(iSR);
        StringBuilder sB = new StringBuilder();
        String line = null;
        try {
            line = bR.readLine();
        } catch (IOException e) {
            Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
        }
        while (line != null) {
            sB.append(line+'\n');
            try {
                line = bR.readLine();
            } catch (IOException e) {
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
            }
        }
        try {
            bR.close();
            iSR.close();
            iS.close();
        } catch (IOException e) {
            Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
        }
        tV.setText(sB.toString());
    }

    public void show(View view) {
    }
}