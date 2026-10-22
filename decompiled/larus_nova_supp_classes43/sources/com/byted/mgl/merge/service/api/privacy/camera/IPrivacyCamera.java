package com.byted.mgl.merge.service.api.privacy.camera;

import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IPrivacyCamera {
    void close(CameraDevice r1, String r10) throws IllegalAccessException;

    Camera open(int r1, String r10) throws IllegalAccessException;

    void openCamera(CameraManager r1, String r10, CameraDevice.StateCallback r11, Handler r12, String r13) throws IllegalAccessException, CameraAccessException;

    void release(Camera r1, String r10) throws IllegalAccessException;
}
