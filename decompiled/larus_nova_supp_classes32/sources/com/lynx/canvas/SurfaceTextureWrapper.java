package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SurfaceTextureWrapper {
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    public Surface getSurface() {
        if (this.mSurface != null) goto L6;
        this.mSurface = new Surface(this.mSurfaceTexture);
    L6:
        return this.mSurface;
    }

    public double getTimestamp() {
        SurfaceTexture r0 = this.mSurfaceTexture;
        if (r0 == null) goto L6;
        long r1 = r0.getTimestamp();
        long r2 = System.nanoTime();
        long r4 = Math.abs(r2 - r1);
        long r6 = Math.abs(SystemClock.elapsedRealtimeNanos() - r1);
        return r2 - Math.min(Math.min(r4, r6), Math.abs((SystemClock.uptimeMillis() * 1000000) - r1));
    L6:
        return 0.0d;
    }

    public void release() {
        SurfaceTexture r0 = this.mSurfaceTexture;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        Surface r1 = this.mSurface;
        if (r1 == null) goto L9;
        r1.release();
        return;
    }

    public float[] updateTexture() {
        SurfaceTexture r0 = this.mSurfaceTexture;
        if (r0 == null) goto L7;
        r0.updateTexImage();
        float[] r1 = new float[16];
        this.mSurfaceTexture.getTransformMatrix(r1);
        return r1;
    L7:
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public SurfaceTextureWrapper(int r2, int r3, int r4) {
        SurfaceTexture r0 = new SurfaceTexture(r2);
        this.mSurfaceTexture = r0;
        if (r3 <= 0) goto L7;
        if (r4 <= 0) goto L8;
        r0.setDefaultBufferSize(r3, r4);
        return;
    L8:
        return;
    }

    public static SurfaceTextureWrapper create(int r1, int r2, int r3) {
        return new SurfaceTextureWrapper(r1, r2, r3);
    }
}
