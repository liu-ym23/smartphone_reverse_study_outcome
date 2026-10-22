package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$versionType");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r1), "version_type"));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L11;
        r2 = null;
    L11:
        return (String) r2;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
