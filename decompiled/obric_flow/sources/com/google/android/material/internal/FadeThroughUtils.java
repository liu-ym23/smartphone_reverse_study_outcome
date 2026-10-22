package com.google.android.material.internal;

import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes2.dex */
final class FadeThroughUtils {
    static final float THRESHOLD_ALPHA = 0.5f;

    private FadeThroughUtils() {
    }

    public static void calculateFadeOutAndInAlphas(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10, float[] r11) {
        if (r10 > 0.5f) goto L5;
        r11[0] = 1.0f - (r10 * 2.0f);
        r11[1] = 0.0f;
        return;
    L5:
        r11[0] = 0.0f;
        r11[1] = (r10 * 2.0f) - 1.0f;
    }
}
