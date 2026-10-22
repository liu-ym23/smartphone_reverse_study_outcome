package ria;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        VibrationEffect r0 = VibrationEffect.createPredefined(1);
        Object r4 = r3.getSystemService("vibrator");
        Vibrator r2 = null;
        if ((r4 instanceof Vibrator) == false) goto L5;
        Vibrator r5 = (Vibrator) r4;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.hasVibrator() == false) goto L10;
        r2 = r5;
    L10:
        if (r2 == null) goto L14;
        r2.vibrate(r0);
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
