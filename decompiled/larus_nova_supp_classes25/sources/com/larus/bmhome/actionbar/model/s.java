package com.larus.bmhome.actionbar.model;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s {
    public static final void a(u r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L48
        k1 r1 = r3.e;     // Catch: Throwable -> L48
        if (r1 != null) goto L7;
        String r2 = r3.d;     // Catch: Throwable -> L48
    L46:
        Object r4 = Result.constructor-impl(r2);     // Catch: Throwable -> L48
    L51:
        if (Result.exceptionOrNull-impl(r4) == null) goto L54;
        r4 = r3.d;
    L54:
        r3.d = (String) r4;
        return;
    L7:
        if ((r1 instanceof k0) == false) goto L10;
        r2 = xt7.d.b.a(k0.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L10:
        if ((r1 instanceof i) == false) goto L13;
        r2 = xt7.d.b.a(i.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L13:
        if ((r1 instanceof p) == false) goto L16;
        r2 = xt7.d.b.a(p.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L16:
        if ((r1 instanceof k) == false) goto L19;
        r2 = xt7.d.b.a(k.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L19:
        if ((r1 instanceof l0) == false) goto L22;
        r2 = xt7.d.b.a(l0.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L22:
        if ((r1 instanceof l) == false) goto L25;
        r2 = xt7.d.b.a(l.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L25:
        if ((r1 instanceof i0) == false) goto L28;
        r2 = xt7.d.b.a(i0.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L28:
        if ((r1 instanceof b0) == false) goto L31;
        r2 = xt7.d.b.a(b0.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L31:
        if ((r1 instanceof d0) == false) goto L34;
        r2 = xt7.d.b.a(d0.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L34:
        if ((r1 instanceof m) == false) goto L37;
        r2 = xt7.d.b.a(m.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L37:
        if ((r1 instanceof n) == false) goto L40;
        r2 = xt7.d.b.a(n.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L40:
        if ((r1 instanceof e) == false) goto L43;
        r2 = xt7.d.b.a(e.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L43:
        if ((r1 instanceof c0) == false) goto L45;
        r2 = xt7.d.b.a(c0.Companion.serializer(), r1);     // Catch: Throwable -> L48
        goto L46
    L45:
        r2 = r3.d;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    }
}
