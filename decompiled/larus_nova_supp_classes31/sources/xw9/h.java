package xw9;

import android.content.Context;
import android.provider.Settings;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    static {
    }

    public static boolean a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (Settings.System.getInt(r6.getContentResolver(), "accelerometer_rotation") == 1) goto L10;
    L13:
        boolean r7 = false;
    L15:
        return !r7;
    L10:
        r7 = true;
    L6:
        e = move-exception;
        FLogger.a.e("OrientationLockUtils", "isAutoRotationEnabled error1: " + e);
        if (Settings.System.getInt(r6.getContentResolver(), "accelerometer_rotation") != 1) goto L13;
    L11:
        e = move-exception;
        FLogger.a.e("OrientationLockUtils", "isAutoRotationEnabled error2: " + e);
        goto L13
    }
}
