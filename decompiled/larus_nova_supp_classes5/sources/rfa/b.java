package rfa;

import android.content.pm.PackageInfo;
import androidx.core.content.pm.PackageInfoCompat;
import com.larus.common.apphost.AppHost;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final ConcurrentHashMap<String, c> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static c a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "pkgName");
        c r0 = a.get(r7);
        if (r0 == null) goto L18;
        return r0;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        PackageInfo r2 = AppHost.a.getApplication().getPackageManager().getPackageInfo(r7, 0);     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(new c(PackageInfoCompat.getLongVersionCode(r2), r2.lastUpdateTime));     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r3) == false) goto L13;
        ConcurrentHashMap<String, c> r4 = a;
        r4.put(r7, (c) r3);
    L13:
        c r8 = new c(0);
        if (Result.isFailure-impl(r3) == false) goto L17;
        r3 = r8;
    L17:
        return (c) r3;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
