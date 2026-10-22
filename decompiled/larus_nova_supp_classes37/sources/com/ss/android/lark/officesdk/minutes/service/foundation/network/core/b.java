package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.google.gson.Gson;
import com.ss.android.lark.utils.e0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static gvb.b a(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "body");
        if (r2 != 200) goto L24;
        if (r4 == true) goto L24;
        return null;
    L24:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        Gson r6 = e0.a;     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl((gvb.b) e0.a(r3, gvb.b.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r7) == false) goto L13;
        r7 = null;
    L13:
        gvb.b r8 = (gvb.b) r7;
        if (r2 == 200) goto L16;
        return r8;
    L16:
        if (r8 != null) goto L18;
        return null;
    L18:
        if (r8.a() == 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == true) goto L23;
        return null;
    L23:
        return r8;
    L20:
        r9 = false;
    L8:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
