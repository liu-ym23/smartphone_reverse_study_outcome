package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SurfaceHolder implements FirstFrameAwareSurfaceTexture.FirstFrameAvailableListener, INativeSurfaceProvider {
    private static final String TAG = "KryptonSurfaceHolder";
    private FirstFrameListener mFirstFrameListener;
    private int mHeight;
    private long mNativeSurfacePtr;
    private final Surface mSurface;
    private final FirstFrameAwareSurfaceTexture mSurfaceTexture;
    private int mWidth;

    public interface FirstFrameListener {
        void onFirstFrame();
    }

    private static native long nativeCreateSurface(Surface r0, SurfaceTexture r1);

    private static native void nativeDestroySurface(long r0);

    @Override // com.lynx.canvas.INativeSurfaceProvider
    public synchronized long acquireNativeSurfacePtr() {
        monitor-enter(this);
        long r0 = this.mNativeSurfacePtr;     // Catch: Throwable -> L6
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void dispose() {
        KryptonLLog.i(TAG, "dispose surface texture with " + this.mSurfaceTexture);
        this.mSurface.release();
        this.mFirstFrameListener = null;
        monitor-enter(this);
        long r0 = this.mNativeSurfacePtr;     // Catch: Throwable -> L9
        if (r0 == 0) goto L7;
        nativeDestroySurface(r0);     // Catch: Throwable -> L9
        this.mNativeSurfacePtr = 0;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.FirstFrameAwareSurfaceTexture.FirstFrameAvailableListener
    public void onFirstFrameAvailable() {
        KryptonLLog.i(TAG, "onFirstFrameAvailable mFirstFrameListener " + this.mFirstFrameListener);
        FirstFrameListener r0 = this.mFirstFrameListener;
        if (r0 == null) goto L6;
        r0.onFirstFrame();
        return;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public SurfaceHolder(FirstFrameListener r4) {
        FirstFrameAwareSurfaceTexture r0 = new FirstFrameAwareSurfaceTexture(0);
        this.mSurfaceTexture = r0;
        r0.detachFromGLContext();
        r0.setFirstFrameListener(this);
        Surface r1 = new Surface(r0);
        this.mSurface = r1;
        this.mFirstFrameListener = r4;
        this.mWidth = 1;
        this.mHeight = 1;
        this.mNativeSurfacePtr = nativeCreateSurface(r1, r0);
        KryptonLLog.i(TAG, "Created with surface texture " + r0);
    }

    public static void destroyOrphanSurface(long r3) {
        if (r3 == 0) goto L6;
        nativeDestroySurface(r3);
        return;
    }

    public void initTextureView(TextureView r4) {
        KryptonLLog.i(TAG, "initTextureView with " + r4);
        SurfaceTexture r0 = r4.getSurfaceTexture();
        if (this.mSurfaceTexture.equals(r0) == false) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        KryptonLLog.i(TAG, "Init TextureView but it has already another st.");
    L7:
        r4.setSurfaceTexture(this.mSurfaceTexture);
    }

    public void onSurfaceTextureSizeChanged(int r3, int r4) {
        if (this.mWidth == r3) goto L5;
    L7:
        if (r3 == 0) goto L12;
        if (r4 == 0) goto L12;
        this.mWidth = r3;
        this.mHeight = r4;
        return;
    L12:
        KryptonLLog.w(TAG, "onSurfaceTextureSizeChanged with invalid size " + r3 + " / " + r4);
        return;
    L5:
        if (this.mHeight != r4) goto L7;
    }
}
