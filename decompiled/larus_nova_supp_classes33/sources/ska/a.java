package ska;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final a a = null;
    public static volatile Context b;

    static {
        a = new a();
    }

    public a() {
    }

    public static boolean a() {
        Context r0 = b;
        if (r0 != null) goto L22;
        return false;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        PackageInfo r1 = r0.getPackageManager().getPackageInfo(r0.getPackageName(), 0);     // Catch: Throwable -> L11
        if (Build.VERSION.SDK_INT < 28) goto L8;
        long r3 = r1.getLongVersionCode();     // Catch: Throwable -> L11
    L9:
        Object r4 = Result.constructor-impl(Long.valueOf(r3));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == false) goto L16;
        r4 = null;
    L16:
        Long r5 = (Long) r4;
        if (r5 != null) goto L19;
        return false;
    L19:
        if (r5.longValue() < 1130200201) goto L25;
        return true;
    L25:
        return false;
    L8:
        r3 = r1.versionCode;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
