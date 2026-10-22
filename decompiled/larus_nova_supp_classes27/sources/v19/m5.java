package v19;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m5 {
    public static final void a(PolarisFileWrapper r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.exists() == false) goto L10;
        r1.delete();     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    public static final void b(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        a(new PolarisFileWrapper(r1));
        return;
    L11:
        return;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static final boolean c(String r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        boolean r2 = true;
        if (r3 != null) goto L6;
    L9:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L14:
        r2 = false;
    L15:
        Object r5 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r5) == false) goto L22;
        r5 = null;
    L22:
        Boolean r6 = (Boolean) r5;
        if (r6 != null) goto L25;
        return false;
    L25:
        return r6.booleanValue();
    L12:
        if (new PolarisFileWrapper(r3).exists() == false) goto L14;
    L6:
        if (r3.length() == 0) goto L9;
        r4 = false;
    L17:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
