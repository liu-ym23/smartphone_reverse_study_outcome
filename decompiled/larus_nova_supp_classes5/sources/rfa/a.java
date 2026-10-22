package rfa;

import android.content.Intent;
import kotlin.Result;
import kotlin.ResultKt;
import p9a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Intent r5) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        String r2 = r5.getDataString();     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        String r3 = r2.substring(8);     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = Result.exceptionOrNull-impl(r4);
        if (r6 == null) goto L15;
        e r7 = p9a.b.a;
        p9a.b.c("AppChangeHandler", "getDataPackageName failed: " + r5.getDataString(), r6);
    L15:
        if (Result.isFailure-impl(r4) == true) goto L19;
        r0 = r4;
    L19:
        return (String) r0;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
