package com.ss.android.lark.passport.flow.mfa;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i {
    public static final String a(Uri r1, String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(UriProtector.getQueryParameter(r1, r2));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        return (String) r3;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
