package com.byted.cast.sdk.gl.grafika;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EglCore {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String TAG = "Grafika";
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private int mGlVersion;

    public EglCore() {
        this(null, 0);
    }

    public void finalize() throws Throwable {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) goto L5;
        release();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    public void makeNothingCurrent() {
        EGLDisplay r0 = this.mEGLDisplay;
        EGLSurface r1 = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(r0, r1, r1, EGL14.EGL_NO_CONTEXT) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public void release() {
        EGLDisplay r0 = this.mEGLDisplay;
        if (r0 == EGL14.EGL_NO_DISPLAY) goto L5;
        EGLSurface r1 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r0, r1, r1, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.mEGLDisplay);
    L5:
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    public int getGlVersion() {
        return this.mGlVersion;
    }

    private void checkEglError(String r10) {
        int r0 = EGL14.eglGetError();
        if (r0 != 12288) goto L6;
        return;
    L6:
        throw new RuntimeException(r10 + ": EGL error: 0x" + Integer.toHexString(r0));
    }

    public static void logCurrent(String r10) {
        EGLDisplay r11 = EGL14.eglGetCurrentDisplay();
        EGLContext r0 = EGL14.eglGetCurrentContext();
        EGLSurface r1 = EGL14.eglGetCurrentSurface(12377);
        Objects.toString(r11);
        Objects.toString(r0);
        Objects.toString(r1);
    }

    public EGLSurface createWindowSurface(Object r10) {
        if ((r10 instanceof Surface) == false) goto L5;
    L9:
        EGLSurface r11 = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, r10, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (r11 == null) goto L13;
        return r11;
    L13:
        throw new RuntimeException("surface was null");
    L5:
        if ((r10 instanceof SurfaceTexture) == true) goto L9;
        throw new RuntimeException("invalid surface: " + r10);
    }

    public boolean isCurrent(EGLSurface r10) {
        if (this.mEGLContext.equals(EGL14.eglGetCurrentContext()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(EGL14.eglGetCurrentSurface(12377)) == false) goto L7;
        return true;
    }

    public void makeCurrent(EGLSurface r10) {
        EGLDisplay r0 = this.mEGLDisplay;
        EGLDisplay r1 = EGL14.EGL_NO_DISPLAY;
        if (EGL14.eglMakeCurrent(r0, r10, r10, this.mEGLContext) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public String queryString(int r10) {
        return EGL14.eglQueryString(this.mEGLDisplay, r10);
    }

    public void releaseSurface(EGLSurface r10) {
        EGL14.eglDestroySurface(this.mEGLDisplay, r10);
    }

    public boolean swapBuffers(EGLSurface r10) {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, r10);
    }

    public EglCore(EGLContext r10, int r11) {
        EGLDisplay r0 = EGL14.EGL_NO_DISPLAY;
        this.mEGLDisplay = r0;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        if (r0 != EGL14.EGL_NO_DISPLAY) goto L31;
        if (r10 != null) goto L6;
        r10 = EGL14.EGL_NO_CONTEXT;
    L6:
        EGLDisplay r12 = EGL14.eglGetDisplay(0);
        this.mEGLDisplay = r12;
        if (r12 == EGL14.EGL_NO_DISPLAY) goto L29;
        int[] r13 = new int[2];
        if (EGL14.eglInitialize(r12, r13, 0, r13, 1) == true) goto L11;
        this.mEGLDisplay = null;
        throw new RuntimeException("unable to initialize EGL14");
    L11:
        if ((r11 & 2) == 0) goto L18;
        EGLConfig r1 = getConfig(r11, 3);
        if (r1 == null) goto L18;
        EGLDisplay r14 = this.mEGLDisplay;
        EGLContext r15 = EGL14.eglCreateContext(r14, r1, r10, new int[]{12440, 3, 12344}, 0);
        if (EGL14.eglGetError() != 12288) goto L18;
        this.mEGLConfig = r1;
        this.mEGLContext = r15;
        this.mGlVersion = 3;
    L18:
        if (this.mEGLContext != EGL14.EGL_NO_CONTEXT) goto L24;
        EGLConfig r16 = getConfig(r11, 2);
        if (r16 == null) goto L23;
        EGLDisplay r17 = this.mEGLDisplay;
        EGLContext r18 = EGL14.eglCreateContext(r17, r16, r10, new int[]{12440, 2, 12344}, 0);
        checkEglError("eglCreateContext");
        this.mEGLConfig = r16;
        this.mEGLContext = r18;
        this.mGlVersion = 2;
        goto L24
    L23:
        throw new RuntimeException("Unable to find a suitable EGLConfig");
    L24:
        EGLDisplay r19 = this.mEGLDisplay;
        EGLContext r20 = this.mEGLContext;
        EGL14.eglQueryContext(r19, r20, 12440, new int[1], 0);
        return;
    L29:
        throw new RuntimeException("unable to get EGL14 display");
    L31:
        throw new RuntimeException("EGL already set up");
    }

    private EGLConfig getConfig(int r13, int r14) {
        if (r14 < 3) goto L5;
        int r15 = 68;
    L6:
        int[] r10 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, r15, 12344, 0, 12344};
        if ((r13 & 1) == 0) goto L9;
        r10[10] = EGL_RECORDABLE_ANDROID;
        r10[11] = 1;
    L9:
        EGLConfig[] r16 = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEGLDisplay, r10, 0, r16, 0, 1, new int[1], 0) == true) goto L14;
        return null;
    L14:
        return r16[0];
    L5:
        r15 = 4;
        goto L6
    }

    public EGLSurface createOffscreenSurface(int r10, int r11) {
        EGLSurface r12 = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, r10, 12374, r11, 12344}, 0);
        checkEglError("eglCreatePbufferSurface");
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new RuntimeException("surface was null");
    }

    public void makeCurrent(EGLSurface r10, EGLSurface r11) {
        EGLDisplay r0 = this.mEGLDisplay;
        EGLDisplay r1 = EGL14.EGL_NO_DISPLAY;
        if (EGL14.eglMakeCurrent(r0, r10, r11, this.mEGLContext) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent(draw,read) failed");
    }

    public int querySurface(EGLSurface r10, int r11) {
        int[] r0 = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, r10, r11, r0, 0);
        return r0[0];
    }

    public void setPresentationTime(EGLSurface r10, long r11) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, r10, r11);
    }
}
