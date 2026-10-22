package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
interface FitModeEvaluator {
    void applyMask(RectF r5, float r10, FitModeResult r11);

    FitModeResult evaluate(float r5, float r10, float r11, float r12, float r13, float r14, float r15);

    boolean shouldMaskStartBounds(FitModeResult r5);
}
