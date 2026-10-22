package com.google.android.material.transition;

/* JADX INFO: loaded from: classes2.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int r5, int r10, boolean r11) {
        this.startAlpha = r5;
        this.endAlpha = r10;
        this.endOnTop = r11;
    }

    public static FadeModeResult endOnTop(int r5, int r10) {
        return new FadeModeResult(r5, r10, true);
    }

    public static FadeModeResult startOnTop(int r5, int r10) {
        return new FadeModeResult(r5, r10, false);
    }
}
