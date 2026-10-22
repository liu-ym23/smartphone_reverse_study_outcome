package com.larus.bmhome.utils;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b4 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r4) {
        if (r4 == null) goto L4;
        Object r5 = r4.getSystemService("vibrator");
    L5:
        Vibrator r6 = (Vibrator) r5;
        if (r6 != null) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r6.vibrate(VibrationEffect.createOneShot(100, -1));
        return;
    L10:
        r6.vibrate(100);
        return;
    L4:
        r5 = null;
        goto L5
    }
}
