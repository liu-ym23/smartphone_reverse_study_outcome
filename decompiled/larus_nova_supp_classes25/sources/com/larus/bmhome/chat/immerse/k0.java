package com.larus.bmhome.chat.immerse;

import androidx.core.graphics.ColorUtils;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 {
    public static int a;

    static {
    }

    public static int a(int r5, float r6, float r7) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        float[] r2 = {0.0f, 0.0f, 0.0f};     // Catch: Throwable -> L5
        ColorUtils.colorToHSL(r5, r2);     // Catch: Throwable -> L5
        r2[1] = r6;     // Catch: Throwable -> L5
        r2[2] = r7;     // Catch: Throwable -> L5
        return ColorUtils.HSLToColor(r2);
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return 0;
    }
}
