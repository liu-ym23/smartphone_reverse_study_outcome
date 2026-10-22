package com.google.android.material.transition;

import ai.j0;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
class FitModeEvaluators {
    private static final FitModeEvaluator HEIGHT = null;
    private static final FitModeEvaluator WIDTH = null;

    static {
        WIDTH = new AnonymousClass1();
        HEIGHT = new AnonymousClass2();
    }

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int r5, boolean r10, RectF r11, RectF r12) {
        if (r5 == 0) goto L14;
        if (r5 == 1) goto L12;
        if (r5 != 2) goto L10;
        return HEIGHT;
    L10:
        throw new IllegalArgumentException(j0.g(r5, "Invalid fit mode: "));
    L12:
        return WIDTH;
    L14:
        if (shouldAutoFitToWidth(r10, r11, r12) == false) goto L17;
        return WIDTH;
    L17:
        return HEIGHT;
    }

    private static boolean shouldAutoFitToWidth(boolean r5, RectF r10, RectF r11) {
        float r12 = r10.width();
        float r13 = r10.height();
        float r14 = r11.width();
        float r15 = r11.height();
        float r16 = (r15 * r12) / r14;
        float r17 = (r14 * r13) / r12;
        if (r5 == false) goto L8;
        if (r16 >= r13) goto L11;
        return false;
    L11:
        return true;
    L8:
        if (r17 >= r15) goto L11;
        return false;
    }
}
