package com.byted.cast.sdk.gl.grafika;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class WindowSurface extends EglSurfaceBase {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public void release() {
        releaseEglSurface();
        Surface r0 = this.mSurface;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mReleaseSurface == false) goto L7;
        r0.release();
    L7:
        this.mSurface = null;
    }

    public void recreate(EglCore r10) {
        Surface r0 = this.mSurface;
        if (r0 == null) goto L7;
        this.mEglCore = r10;
        createWindowSurface(r0);
        return;
    L7:
        throw new RuntimeException("not yet implemented for SurfaceTexture");
    }

    public WindowSurface(EglCore r1, SurfaceTexture r10) {
        super(r1);
        createWindowSurface(r10);
    }

    public WindowSurface(EglCore r1, Surface r10, boolean r11) {
        super(r1);
        createWindowSurface(r10);
        this.mSurface = r10;
        this.mReleaseSurface = r11;
    }
}
