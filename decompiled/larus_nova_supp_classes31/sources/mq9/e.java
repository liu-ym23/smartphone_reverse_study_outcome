package mq9;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final String a(String r7) {
        if (r7 == null) goto L35;
        String r1 = StringsKt.trim(r7).toString();
        boolean r3 = true;
        if (r1.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return r7;
    L12:
        if (StringsKt.startsWith$default(r1, "larus_", false, 2, null) == true) goto L33;
        r1 = "larus_".concat(r1);
    L33:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L26
        Application r4 = AppHost.a.getApplication();     // Catch: Throwable -> L26
        int r5 = r4.getResources().getIdentifier(r1, "string", r4.getPackageName());     // Catch: Throwable -> L26
        if (r5 == 0) goto L23;
        String r6 = r4.getString(r5);     // Catch: Throwable -> L26
        if (r6.length() == 0) goto L22;
        r3 = false;
    L22:
        if (r3 == true) goto L23;
    L24:
        Object r8 = Result.constructor-impl(r6);     // Catch: Throwable -> L26
    L28:
        Object r9 = r7;
        if (Result.exceptionOrNull-impl(r8) != null) goto L32;
        r9 = r8;
    L32:
        return (String) r9;
    L23:
        r6 = r7;
    L26:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L8:
        r2 = false;
        goto L9
    L35:
        return null;
    }
}
