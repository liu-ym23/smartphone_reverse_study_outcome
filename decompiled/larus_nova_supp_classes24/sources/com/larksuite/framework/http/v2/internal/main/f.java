package com.larksuite.framework.http.v2.internal.main;

import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements Interceptor {
    public f() {
    }

    public final Response intercept(Interceptor.Chain r6) {
        Intrinsics.checkNotNullParameter(r6, "chian");
        Response r7 = r6.proceed(r6.request());
        if (r7.isSuccessful() == true) goto L34;
        String r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        ResponseBody r2 = r7.body();     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        String r3 = r2.string();     // Catch: Throwable -> L11
    L9:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == false) goto L16;
        r4 = null;
    L16:
        String r5 = (String) r4;
        String r8 = r7.message();
        boolean r9 = true;
        if (r5 != null) goto L19;
    L24:
        StringBuilder r10 = new StringBuilder("Response is not successful, status code: ");
        r10.append(r7.code());
        r10.append(", error message: ");
        if (r8 != null) goto L27;
    L30:
        if (r9 == false) goto L32;
        r8 = "unknown error";
    L32:
        r10.append(r8);
        r10.append('.');
        throw new IOException(r10.toString());
    L27:
        if (StringsKt.isBlank(r8) == true) goto L30;
        r9 = false;
        goto L30
    L19:
        if ((!StringsKt.isBlank(r5)) == false) goto L21;
        r0 = r5;
    L21:
        if (r0 == null) goto L24;
        r8 = r0;
        goto L24
    L8:
        r3 = null;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L34:
        Intrinsics.checkNotNull(r7);
        return r7;
    }
}
