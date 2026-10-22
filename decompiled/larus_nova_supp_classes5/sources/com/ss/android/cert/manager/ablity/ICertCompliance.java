package com.ss.android.cert.manager.ablity;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioRecord;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ICertCompliance {
    Sensor getDefaultSensor(SensorManager r1, int r2);

    Camera openCamera();

    Camera openCamera(int r1);

    void releaseCamera(Camera r1);

    void releaseRecord(AudioRecord r1);

    void requestPermissions(Activity r1, String[] r2, int r3);

    void startRecord(AudioRecord r1);

    void stopRecord(AudioRecord r1);
}
