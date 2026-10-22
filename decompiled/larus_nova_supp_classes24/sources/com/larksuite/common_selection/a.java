package com.larksuite.common_selection;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static void a(Context r2) {
        if (r2 != null) goto L16;
        return;
    L16:
        Vibrator r3 = (Vibrator) r2.getSystemService("vibrator");     // Catch: Exception -> L14
        if (r3 != null) goto L7;
    L15:
        return;
    L7:
        if (r3.hasVibrator() == false) goto L15;
        if (Build.VERSION.SDK_INT < 29) goto L12;
        r3.vibrate(VibrationEffect.createPredefined(0));     // Catch: Exception -> L14
        goto L15
    L12:
        r3.vibrate(70);     // Catch: Exception -> L14
    }
}
