package com.lynx.canvas.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.WindowManager;
import com.lynx.canvas.KryptonCamera;
import com.lynx.canvas.KryptonLLog;
import com.lynx.xelement.webview.LynxUIWebView;
import f06.b;
import f06.c;
import f06.d;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonDefaultCamera implements KryptonCamera {
    private static final int CAMERA_RETRY_TIMES = 3;
    private static final String TAG = "Camera default";
    private Camera mCamera;
    private int mCameraId;
    private Camera.CameraInfo mCameraInfo;
    private final Context mContext;
    private int mFacing;
    private int mHeight;
    private final Invoker mInvoker;
    private int mWidth;

    public interface Invoker {
        Camera openCamera(int r1) throws RuntimeException;

        void releaseCamera(Camera r1);
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void focus() {
        Camera r0 = this.mCamera;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.autoFocus(null);
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void pause() {
        Camera r0 = this.mCamera;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.stopPreview();
        this.mCamera.lock();
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void play() {
        Camera r0 = this.mCamera;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.startPreview();
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void release() {
        Camera r0 = this.mCamera;
        if (r0 != null) goto L5;
        return;
    L5:
        Invoker r1 = this.mInvoker;
        if (r1 == null) goto L8;
        r1.releaseCamera(r0);
    L9:
        this.mCamera = null;
        return;
    L8:
        com_lynx_canvas_camera_KryptonDefaultCamera_android_hardware_Camera_release(r0);
        goto L9
    }

    @Override // com.lynx.canvas.KryptonCamera
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public int getWidth() {
        return this.mWidth;
    }

    private boolean checkNoDefault(KryptonCamera.Config r4) {
        if (r4 != null) goto L5;
    L11:
        return false;
    L5:
        if (r4.extraJson == null) goto L11;
        return new JSONObject(r4.extraJson).optBoolean("noDefault");
    L9:
        e = move-exception;
        KryptonLLog.w(TAG, "parse extraJson failed " + e.toString());
        goto L11
    }

    private static Camera com_lynx_canvas_camera_KryptonDefaultCamera_android_hardware_Camera_open(int r12) {
        c r8 = new c();
        Object[] r9 = {Integer.valueOf(r12)};
        b r10 = new b();
        d r11 = r8.b(100100, "android/hardware/Camera", "open", Camera.class, r9, "android.hardware.Camera", r10);
        if (r11.a == false) goto L6;
        r8.a(100100, "android/hardware/Camera", "open", Camera.class, r9, null, r10, false);
        return (Camera) r11.b;
    L6:
        Camera r13 = Camera.open(r12);
        r8.a(100100, "android/hardware/Camera", "open", Camera.class, r9, r13, r10, true);
        return r13;
    }

    private static void com_lynx_canvas_camera_KryptonDefaultCamera_android_hardware_Camera_release(Camera r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        b r10 = new b();
        if (r8.b(100101, "android/hardware/Camera", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100101, "android/hardware/Camera", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100101, "android/hardware/Camera", "release", r12, r9, null, r10, true);
    }

    private int getCameraDisplayOrientation(Camera.CameraInfo r5) {
        int r0 = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int r2 = 0;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L6;
        r2 = 90;
        goto L14
    L6:
        if (r0 != 2) goto L8;
        r2 = 180;
        goto L14
    L8:
        if (r0 != 3) goto L14;
        r2 = 270;
    L14:
        if (r5.facing != 1) goto L17;
        return (360 - ((r5.orientation + r2) % 360)) % 360;
    L17:
        return ((r5.orientation - r2) + 360) % 360;
    }

    private Camera openCamera(int r7) {
        if (r7 >= 0) goto L5;
        return null;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= 3) goto L21;
        Invoker r2 = this.mInvoker;     // Catch: Exception -> L14
        if (r2 == null) goto L13;
        return r2.openCamera(r7);
    L13:
        return com_lynx_canvas_camera_KryptonDefaultCamera_android_hardware_Camera_open(r7);
    L14:
        e = move-exception;
        KryptonLLog.e(TAG, "open exception:" + e.toString());
        Thread.sleep(r1 * 100);     // Catch: InterruptedException -> L18
    L20:
        r1 = r1 + 1;
    L18:
        e = move-exception;
        KryptonLLog.e(TAG, "thread sleep exception:" + e.toString());
        goto L20
    L21:
        return null;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public boolean requestWithConfig(KryptonCamera.Config r9) {
        if (checkNoDefault(r9) == false) goto L7;
        KryptonLLog.e(TAG, "the use of default camera is not allowed when noDefault is set to true");
        return false;
    L7:
        if (r9 != null) goto L9;
    L11:
        this.mFacing = 1;
    L12:
        int r3 = 0;
    L14:
        if (r3 >= Camera.getNumberOfCameras()) goto L19;
        Camera.CameraInfo r4 = new Camera.CameraInfo();
        Camera.getCameraInfo(r3, r4);
        if (r4.facing == this.mFacing) goto L17;
        r3 = r3 + 1;
        goto L14
    L17:
        this.mCameraId = r3;
        this.mCameraInfo = r4;
    L19:
        Camera r5 = openCamera(this.mCameraId);
        this.mCamera = r5;
        if (r5 != null) goto L23;
        KryptonLLog.e(TAG, "open failed");
        return false;
    L23:
        r5.setDisplayOrientation(getCameraDisplayOrientation(this.mCameraInfo));
        Camera.Parameters r6 = this.mCamera.getParameters();
        if (r9 == null) goto L26;
        KryptonCamera.CustomSize r7 = r9.size;
    L28:
        if (r7 != null) goto L30;
    L38:
        if (r9 != null) goto L40;
    L46:
        if (r9 != null) goto L48;
    L50:
        KryptonLLog.i(TAG, LynxUIWebView.DEFAULT);
        this.mWidth = CameraSize.mediumWidth;
        this.mHeight = CameraSize.mediumHeight;
    L51:
        KryptonLLog.i(TAG, "use camera with landscape preview size (" + this.mHeight + "," + this.mWidth + ")");
        r6.setPreviewSize(this.mHeight, this.mWidth);
        r6.setPreviewFormat(17);
        if (r9.autoFocus == true) goto L54;
    L61:
        this.mCamera.setParameters(r6);     // Catch: Exception -> L58
        return true;
    L58:
        e = move-exception;
        KryptonLLog.e(TAG, "setParameters failed " + e.getMessage());
        return false;
    L54:
        if (r6.getSupportedFocusModes().contains("continuous-picture") == false) goto L61;
        r6.setFocusMode("continuous-picture");
        goto L61
    L48:
        if ("low".equals(r9.resolution) == false) goto L50;
        KryptonLLog.i(TAG, "low");
        this.mWidth = CameraSize.lowWidth;
        this.mHeight = CameraSize.lowHeight;
        goto L51
    L40:
        if ("high".equals(r9.resolution) == false) goto L46;
        KryptonCamera.CustomSize r8 = getOptimalPreviewSize(r6.getSupportedPreviewSizes(), 720.0f, 1280.0f);
        if (r8 != null) goto L45;
        KryptonLLog.e(TAG, "Get preview size failed with high resolution");
        return false;
    L45:
        this.mWidth = r8.width;
        this.mHeight = r8.height;
        goto L51
    L30:
        if (r7.width <= 0) goto L38;
        if (r7.height <= 0) goto L38;
        KryptonCamera.CustomSize r10 = getOptimalPreviewSize(r6.getSupportedPreviewSizes(), r7.width, r7.height);
        if (r10 != null) goto L37;
        KryptonLLog.e(TAG, "Get preview size failed with high resolution");
        return false;
    L37:
        this.mWidth = r10.width;
        this.mHeight = r10.height;
        goto L51
    L26:
        r7 = null;
        goto L28
    L9:
        if ("back".equals(r9.faceMode) == false) goto L11;
        this.mFacing = 0;
        goto L12
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void setupPreviewTexture(SurfaceTexture r3) {
        Camera r0 = this.mCamera;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.setPreviewTexture(r3);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        KryptonLLog.e(TAG, "setPreviewTexture exception:" + e.toString());
    }

    public KryptonDefaultCamera(Context r2, Invoker r3) {
        this.mCameraId = -1;
        this.mFacing = 0;
        this.mContext = r2;
        this.mInvoker = r3;
    }

    private KryptonCamera.CustomSize getOptimalPreviewSize(List<Camera.Size> r6, float r7, float r8) {
        Iterator<Camera.Size> r9 = r6.iterator();
        Camera.Size r0 = null;
    L4:
        if (r9.hasNext() == false) goto L12;
        Camera.Size r1 = r9.next();
        int r3 = r1.height;
        if (r3 > r7) goto L4;
        if (r0 == null) goto L11;
        if (r3 <= r0.height) goto L4;
    L11:
        KryptonLLog.i(TAG, "update max supported size to (" + r1.width + "," + r1.height + ")");
        r0 = r1;
        goto L4
    L12:
        if (r0 != null) goto L16;
        KryptonLLog.e(TAG, "find max supported preview size error");
        return null;
    L16:
        return new KryptonCamera.CustomSize(r0.height, r0.width);
    }
}
