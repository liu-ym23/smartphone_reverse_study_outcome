package v20;

import com.lynx.react.bridge.PiperData;
import d8.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements e {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final Object a(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(new PiperData(r3, false));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == false) goto L13;
        return null;
    L13:
        return r4;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
