package com.larus.account.saas.runtime.internal.util;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class GsonHolder {
    public static final Lazy a = null;

    public GsonHolder() {
    }

    static {
        a = LazyKt.lazy(GsonHolder$gson$2.INSTANCE);
    }

    public static String c(Object r3) {
        if ((r3 instanceof String) == true) goto L21;
        Object r0 = null;
        if (r3 == null) goto L22;
        Gson r1 = (Gson) a.getValue();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl(r1.toJson(r3));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == true) goto L18;
        r0 = r4;
    L18:
        return (String) r0;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    L21:
        return (String) r3;
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
        Gson r1 = (Gson) a.getValue();
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

    public static Object b(String r3, Type r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return null;
    L12:
        Gson r1 = (Gson) a.getValue();
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
