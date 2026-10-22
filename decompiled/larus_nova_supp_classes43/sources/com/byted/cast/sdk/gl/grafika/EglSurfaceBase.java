package com.byted.cast.sdk.gl.grafika;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class EglSurfaceBase {
    protected static final String TAG = "Grafika";
    private EGLSurface mEGLSurface;
    protected EglCore mEglCore;
    private int mHeight;
    private int mWidth;

    public int getHeight() {
        int r0 = this.mHeight;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return this.mEglCore.querySurface(this.mEGLSurface, 12374);
    }

    public int getWidth() {
        int r0 = this.mWidth;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return this.mEglCore.querySurface(this.mEGLSurface, 12375);
    }

    public void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public boolean swapBuffers() {
        return this.mEglCore.swapBuffers(this.mEGLSurface);
    }

    public EglSurfaceBase(EglCore r10) {
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mEglCore = r10;
    }

    public void createWindowSurface(Object r10) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) goto L7;
        this.mEGLSurface = this.mEglCore.createWindowSurface(r10);
        return;
    L7:
        throw new IllegalStateException("surface already created");
    }

    public void makeCurrentReadFrom(EglSurfaceBase r10) {
        this.mEglCore.makeCurrent(this.mEGLSurface, r10.mEGLSurface);
    }

    public void saveFrame(File r11) throws IOException {
        if (this.mEglCore.isCurrent(this.mEGLSurface) == false) goto L16;
        String r12 = r11.toString();
        int r10 = getWidth();
        int r13 = getHeight();
        ByteBuffer r14 = ByteBuffer.allocateDirect((r10 * r13) * 4);
        r14.order(ByteOrder.LITTLE_ENDIAN);
        GLES20.glReadPixels(0, 0, r10, r13, 6408, 5121, r14);
        GlUtil.checkGlError("glReadPixels");
        r14.rewind();
        BufferedOutputStream r0 = null;
        BufferedOutputStream r1 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r12));     // Catch: Throwable -> L11
        Bitmap r15 = Bitmap.createBitmap(r10, r13, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L9
        r15.copyPixelsFromBuffer(r14);     // Catch: Throwable -> L9
        r15.compress(Bitmap.CompressFormat.PNG, 90, r1);     // Catch: Throwable -> L9
        r15.recycle();     // Catch: Throwable -> L9
        r1.close();
        return;
    L9:
        th = th;
        r0 = r1;
    L12:
        if (r0 == null) goto L14;
        r0.close();
    L14:
        throw th;
    L11:
        th = th;
        goto L12
    L16:
        throw new RuntimeException("Expected EGL context/surface is not current");
    }

    public void setPresentationTime(long r10) {
        this.mEglCore.setPresentationTime(this.mEGLSurface, r10);
    }

    public void createOffscreenSurface(int r10, int r11) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) goto L7;
        this.mEGLSurface = this.mEglCore.createOffscreenSurface(r10, r11);
        this.mWidth = r10;
        this.mHeight = r11;
        return;
    L7:
        throw new IllegalStateException("surface already created");
    }
}
