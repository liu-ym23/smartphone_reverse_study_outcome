package com.larus.audio.call.util;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m {
    public static boolean a(d0 r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter("flushed", "key");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        ouc.i r4 = (ouc.i) r3.get("flushed");     // Catch: Throwable -> L13
        if (r4 == null) goto L10;
        String r5 = ouc.k.o(r4).a();     // Catch: Throwable -> L13
        if (r5 == null) goto L10;
        Boolean r6 = StringsKt.toBooleanStrictOrNull(r5);     // Catch: Throwable -> L13
        if (r6 == null) goto L10;
        boolean r7 = r6.booleanValue();     // Catch: Throwable -> L13
    L11:
        Object r8 = Result.constructor-impl(Boolean.valueOf(r7));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r8) == false) goto L18;
        r8 = null;
    L18:
        Boolean r9 = (Boolean) r8;
        if (r9 != null) goto L21;
        return false;
    L21:
        return r9.booleanValue();
    L10:
        r7 = false;
    L13:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static String b(d0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter("", "default");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        ouc.i r4 = (ouc.i) r2.get(r3);     // Catch: Throwable -> L10
        if (r4 == null) goto L7;
        String r5 = ouc.k.o(r4).a();     // Catch: Throwable -> L10
        if (r5 == null) goto L7;
    L8:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r6) == false) goto L15;
        r6 = null;
    L15:
        String r7 = (String) r6;
        if (r7 != null) goto L19;
        return "";
    L19:
        return r7;
    L7:
        r5 = "";
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
