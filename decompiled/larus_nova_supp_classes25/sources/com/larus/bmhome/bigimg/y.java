package com.larus.bmhome.bigimg;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y implements l19.f {
    public final /* synthetic */ BigImageLocalPhotoViewerDialog a;

    public final void onTransitionChanged(int r1, float r2) {
    }

    public y(BigImageLocalPhotoViewerDialog r1) {
        this.a = r1;
    }

    public final void onTransitionBegin(int r2) {
        this.a.G = true;
    }

    public final void onTransitionEnd(int r2) {
        this.a.G = false;
    }
}
