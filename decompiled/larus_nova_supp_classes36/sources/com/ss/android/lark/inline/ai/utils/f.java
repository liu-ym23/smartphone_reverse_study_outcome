package com.ss.android.lark.inline.ai.utils;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Object r5 = r4.getSystemService("vibrator");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator r6 = (Vibrator) r5;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r6.vibrate(VibrationEffect.createOneShot(30, -1));
        return;
    L5:
        r6.vibrate(30);
    }
}
