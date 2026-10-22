package h5;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public static Object a(String r10, Class r11) {
        if (r10 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L20;
        return null;
    L20:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r12 = Result.constructor-impl(com.bytedance.ai.applet.base.gson.e.a(r10, r11));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r12) == false) goto L19;
        return null;
    L19:
        return r12;
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L4:
        if (StringsKt.isBlank(r10) == true) goto L7;
        r0 = false;
        goto L9
    }
}
