package ha8;

import com.google.gson.Gson;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final Gson a = null;

    static {
        a = new Gson();
    }

    public static Object a(String r3, Class r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return null;
    L12:
        Gson r1 = a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        Object r5 = Result.constructor-impl(r1.fromJson(r3, r4));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r5) == false) goto L21;
        return null;
    L21:
        return r5;
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L10
    }
}
