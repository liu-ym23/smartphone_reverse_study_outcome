package z2;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o {
    public static final String a(String r10) {
        if (r10 != null) goto L15;
    L13:
        return "null";
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(UriProtector.parse(r10).buildUpon().clearQuery().toString());     // Catch: Throwable -> L5
    L7:
        Object r11 = r10;
        if (Result.isFailure-impl(r1) == true) goto L11;
        r11 = r1;
    L11:
        String r12 = (String) r11;
        if (r12 == null) goto L13;
        return r12;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
