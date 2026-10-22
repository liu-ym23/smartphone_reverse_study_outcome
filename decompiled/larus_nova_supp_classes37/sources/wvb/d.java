package wvb;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static long a;
    public static final /* synthetic */ int b = 0;

    static {
    }

    public static void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        b(r2, 100);
    }

    public static void b(Context r4, long r5) {
        Object r6 = r4.getSystemService("vibrator");     // Catch: Exception -> L18
        if ((r6 instanceof Vibrator) == false) goto L6;
        Vibrator r7 = (Vibrator) r6;     // Catch: Exception -> L18
    L7:
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.hasVibrator() == true) goto L14;
        int r8 = bwb.b.a;     // Catch: Exception -> L18
        bwb.b.b(MmUiLogScene.FOUNDATION, "vibrate", "vibrate skipped: device has no vibrator", null, 8);     // Catch: Exception -> L18
        return;
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L16;
        r7.vibrate(VibrationEffect.createOneShot(r5, -1));     // Catch: Exception -> L18
        return;
    L16:
        r7.vibrate(r5);     // Catch: Exception -> L18
        return;
    L6:
        r7 = null;
    L18:
        e = move-exception;
        int r9 = bwb.b.a;
        bwb.b.h(MmUiLogScene.FOUNDATION, "vibrate", "vibrate e=" + e, null);
    }
}
