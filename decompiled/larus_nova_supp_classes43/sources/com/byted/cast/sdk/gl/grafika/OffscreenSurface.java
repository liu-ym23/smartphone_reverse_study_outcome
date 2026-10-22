package com.byted.cast.sdk.gl.grafika;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class OffscreenSurface extends EglSurfaceBase {
    public void release() {
        releaseEglSurface();
    }

    public OffscreenSurface(EglCore r1, int r10, int r11) {
        super(r1);
        createOffscreenSurface(r10, r11);
    }
}
