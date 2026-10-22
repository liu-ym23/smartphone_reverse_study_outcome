package com.google.android.material.transition.platform;

import ai.j0;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = null;
    private static final FadeModeEvaluator IN = null;
    private static final FadeModeEvaluator OUT = null;
    private static final FadeModeEvaluator THROUGH = null;

    static {
        IN = new AnonymousClass1();
        OUT = new AnonymousClass2();
        CROSS = new AnonymousClass3();
        THROUGH = new AnonymousClass4();
    }

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int r5, boolean r10) {
        if (r5 != 0) goto L4;
        if (r10 == false) goto L22;
        return IN;
    L22:
        return OUT;
    L4:
        if (r5 != 1) goto L6;
        if (r10 == false) goto L18;
        return OUT;
    L18:
        return IN;
    L6:
        if (r5 == 2) goto L14;
        if (r5 != 3) goto L12;
        return THROUGH;
    L12:
        throw new IllegalArgumentException(j0.g(r5, "Invalid fade mode: "));
    L14:
        return CROSS;
    }
}
