package com.lynx.canvas.camera;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonCamera;
import com.lynx.canvas.KryptonCameraService;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.SurfaceTextureWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CameraContext {
    private static final String TAG = "CameraContext";
    private KryptonCamera mCamera;

    public static native void nativeOnCameraCallback(long r0, CameraContext r2, int r3, int r4);

    public static native void nativeOnCameraErrorCallback(long r0, String r2);

    public void pause() {
        this.mCamera.pause();
    }

    public void play() {
        this.mCamera.play();
    }

    public void release() {
        KryptonLLog.i(TAG, "CameraContext release");
        this.mCamera.release();
        this.mCamera = null;
    }

    public CameraContext(KryptonCamera r1) {
        this.mCamera = r1;
    }

    public void setupPreviewTexture(SurfaceTextureWrapper r2) {
        this.mCamera.setupPreviewTexture(r2.getSurfaceTexture());
    }

    public static void errorCallback(long r1, String r3) {
        KryptonLLog.e(TAG, r3);
        nativeOnCameraErrorCallback(r1, r3);
    }

    public static void requestCamera(KryptonApp r9, long r10, String r12, String r13, String r14, boolean r15) {
        requestCameraWithCustomSize(r9, r10, r12, r13, r14, r15, 0, 0);
    }

    public static void requestCameraWithCustomSize(KryptonApp r3, long r4, String r6, String r7, String r8, boolean r9, int r10, int r11) {
        KryptonCamera.Config r0 = new KryptonCamera.Config();
        r0.faceMode = r6;
        r0.resolution = r7;
        r0.extraJson = r8;
        r0.size = new KryptonCamera.CustomSize(r10, r11);
        r0.autoFocus = r9;
        KryptonCameraService r5 = (KryptonCameraService) r3.getService(KryptonCameraService.class);
        if (r5 != null) goto L6;
        errorCallback(r4, "camera service not found");
        return;
    L6:
        KryptonCamera r12 = r5.createCamera();
        if (r12 != null) goto L11;
        errorCallback(r4, "service create camera return null");
        return;
    L11:
        if (r12.requestWithConfig(r0) == true) goto L14;
        errorCallback(r4, "camera request error with config: " + r6 + " " + r7 + " " + r8);
        return;
    L14:
        CameraContext r13 = new CameraContext(r12);
        int r14 = r12.getWidth();
        int r15 = r12.getHeight();
        if (r14 == 0) goto L17;
        if (r15 == 0) goto L17;
    L26:
        nativeOnCameraCallback(r4, r13, r14, r15);
        KryptonLLog.i(TAG, "request camera success with config: " + r6 + " " + r7 + " " + r8);
        return;
    L17:
        KryptonLLog.i(TAG, "downgrade size origin w: " + r14 + " h: " + r15 + " resolution: " + r7);
        if (r7.equals("low") == false) goto L21;
        r14 = CameraSize.lowWidth;
        r15 = CameraSize.lowHeight;
        goto L26
    L21:
        if (r7.equals(KryptonCamera.Config.RESOLUTION_MEDIUM) == false) goto L24;
    L22:
        r15 = CameraSize.mediumHeight;
        r14 = CameraSize.mediumWidth;
        goto L26
    L24:
        if (r7.equals("high") == false) goto L22;
        r14 = CameraSize.highWidth;
        r15 = CameraSize.highHeight;
        goto L26
    }
}
