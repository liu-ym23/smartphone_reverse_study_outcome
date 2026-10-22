package com.google.android.material.transition;

/* JADX INFO: loaded from: classes2.dex */
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    public FitModeResult(float r5, float r10, float r11, float r12, float r13, float r14) {
        this.startScale = r5;
        this.endScale = r10;
        this.currentStartWidth = r11;
        this.currentStartHeight = r12;
        this.currentEndWidth = r13;
        this.currentEndHeight = r14;
    }
}
