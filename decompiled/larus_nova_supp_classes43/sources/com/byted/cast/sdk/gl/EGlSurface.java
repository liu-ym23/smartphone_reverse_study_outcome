package com.byted.cast.sdk.gl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class EGlSurface {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final String TAG = "EglSurface";
    private EGLConfig[] configs;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private int height;
    private Surface surface;
    private int width;

    private void createEGLSurface() {
        this.eglSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.configs[0], this.surface, new int[]{12344}, 0);
        GlUtils.checkEglError("eglCreateWindowSurface");
    }

    private void eglSetup() {
        EGLDisplay r1 = EGL14.eglGetDisplay(0);
        this.eglDisplay = r1;
        if (r1 == EGL14.EGL_NO_DISPLAY) goto L15;
        int[] r10 = new int[2];
        if (EGL14.eglInitialize(r1, r10, 0, r10, 1) == false) goto L13;
        EGLDisplay r11 = this.eglDisplay;
        EGLConfig[] r12 = this.configs;
        int r13 = r12.length;
        if (EGL14.eglChooseConfig(r11, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344}, 0, r12, 0, r13, new int[1], 0) == false) goto L11;
        EGLDisplay r14 = this.eglDisplay;
        EGLConfig r15 = this.configs[0];
        EGLContext r16 = EGL14.EGL_NO_CONTEXT;
        this.eglContext = EGL14.eglCreateContext(r14, r15, r16, new int[]{12440, 2, 12344}, 0);
        GlUtils.checkEglError("eglCreateContext");
        createEGLSurface();
        this.width = getWidth();
        this.height = getHeight();
        return;
    L11:
        throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    L13:
        throw new RuntimeException("unable to initialize EGL14");
    L15:
        throw new RuntimeException("unable to get EGL14 display");
    }

    public int getHeight() {
        int[] r0 = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, r0, 0);
        return r0[0];
    }

    public int getWidth() {
        int[] r0 = new int[1];
        EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, r0, 0);
        return r0[0];
    }

    public void makeCurrent() {
        EGLDisplay r0 = this.eglDisplay;
        EGLSurface r1 = this.eglSurface;
        if (EGL14.eglMakeCurrent(r0, r1, r1, this.eglContext) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public void makeUnCurrent() {
        EGLDisplay r0 = this.eglDisplay;
        EGLSurface r1 = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(r0, r1, r1, EGL14.EGL_NO_CONTEXT) == false) goto L6;
        return;
    L6:
        throw new RuntimeException("eglMakeCurrent failed");
    }

    public void release() {
        EGLDisplay r0 = this.eglDisplay;
        if (r0 == EGL14.EGL_NO_DISPLAY) goto L5;
        EGL14.eglDestroySurface(r0, this.eglSurface);
        EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.eglDisplay);
    L5:
        this.surface.release();
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglSurface = EGL14.EGL_NO_SURFACE;
    }

    public boolean swapBuffers() {
        return EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
    }

    public EGlSurface(Surface r10) {
        this.eglDisplay = EGL14.EGL_NO_DISPLAY;
        this.eglContext = EGL14.EGL_NO_CONTEXT;
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.configs = new EGLConfig[1];
        this.width = 0;
        this.height = 0;
        this.surface = r10;
        eglSetup();
    }

    public void setPresentationTime(long r10) {
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, r10);
    }
}
