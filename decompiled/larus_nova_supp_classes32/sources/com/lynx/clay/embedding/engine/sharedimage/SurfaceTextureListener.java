package com.lynx.clay.embedding.engine.sharedimage;

import android.graphics.SurfaceTexture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class SurfaceTextureListener implements SurfaceTexture.OnFrameAvailableListener {
    public final long a;

    private native void nativeDestroy(long r1, SurfaceTextureListener r3);

    private native void nativeFrameAvailable(long r1, SurfaceTextureListener r3);

    public final void finalize() throws Throwable {
        nativeDestroy(this.a, this);     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    static {
    }

    public SurfaceTextureListener(long r1) {
        this.a = r1;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r3) {
        nativeFrameAvailable(this.a, this);
    }
}
