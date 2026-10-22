package com.ss.android.lark.officesdk.demo.dependency;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f {
    public static final Uri a(String r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(UriProtector.parse(r3));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r4) == false) goto L9;
        r4 = null;
    L9:
        Uri r5 = (Uri) r4;
        if (r5 == null) goto L24;
        String r1 = r5.getScheme();
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L19:
        if ((!r2) == true) goto L21;
        return null;
    L21:
        return r5;
    L14:
        if (StringsKt.isBlank(r1) == true) goto L17;
        r2 = false;
        goto L19
    L24:
        return null;
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
