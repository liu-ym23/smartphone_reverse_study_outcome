package com.larus.bmhome.actionbar.util;

import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.i;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.k;
import com.larus.bmhome.actionbar.model.k0;
import com.larus.bmhome.actionbar.model.k1;
import com.larus.bmhome.actionbar.model.l;
import com.larus.bmhome.actionbar.model.l0;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.actionbar.model.p;
import com.larus.bmhome.actionbar.model.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public static k1 a(u r4) {
        Intrinsics.checkNotNullParameter(r4, "instructionItem");
        String r0 = r4.d;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        Integer r5 = r4.b;
        if (r5 != null) goto L9;
    L19:
        if (r5 != null) goto L22;
    L32:
        if (r5 != null) goto L35;
    L45:
        if (r5 != null) goto L48;
    L58:
        if (r5 != null) goto L61;
    L71:
        if (r5 != null) goto L74;
    L84:
        if (r5 != null) goto L87;
    L97:
        if (r5 != null) goto L100;
    L110:
        if (r5 != null) goto L113;
    L123:
        if (r5 != null) goto L126;
    L136:
        if (r5 != null) goto L139;
        return null;
    L139:
        if (r5.intValue() != 13) goto L183;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L142
        Object r7 = Result.constructor-impl((k0) xt7.d.b.c(k0.Companion.serializer(), r0));     // Catch: Throwable -> L142
    L145:
        if (Result.isFailure-impl(r7) == false) goto L147;
        r7 = null;
    L147:
        k0 r8 = (k0) r7;
        if (r8 == null) goto L184;
        r8.d = -1;
        return r8;
    L184:
        return null;
    L142:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L145
    L183:
        return null;
    L126:
        if (r5.intValue() != 11) goto L136;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L129
        Object r10 = Result.constructor-impl((n) xt7.d.b.c(n.Companion.serializer(), r0));     // Catch: Throwable -> L129
    L132:
        if (Result.isFailure-impl(r10) == true) goto L182;
        r1 = r10;
    L182:
        return (k1) r1;
    L129:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L132
    L113:
        if (r5.intValue() != 10) goto L123;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L116
        Object r12 = Result.constructor-impl((d0) xt7.d.b.c(d0.Companion.serializer(), r0));     // Catch: Throwable -> L116
    L119:
        if (Result.isFailure-impl(r12) == true) goto L181;
        r1 = r12;
    L181:
        return (k1) r1;
    L116:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L119
    L100:
        if (r5.intValue() != 8) goto L110;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L103
        Object r15 = Result.constructor-impl((b0) xt7.d.b.c(b0.Companion.serializer(), r0));     // Catch: Throwable -> L103
    L106:
        if (Result.isFailure-impl(r15) == true) goto L180;
        r1 = r15;
    L180:
        return (k1) r1;
    L103:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L106
    L87:
        if (r5.intValue() != 7) goto L97;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L90
        Object r18 = Result.constructor-impl((i0) xt7.d.b.c(i0.Companion.serializer(), r0));     // Catch: Throwable -> L90
    L93:
        if (Result.isFailure-impl(r18) == true) goto L179;
        r1 = r18;
    L179:
        return (k1) r1;
    L90:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L93
    L74:
        if (r5.intValue() != 6) goto L84;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L77
        Object r21 = Result.constructor-impl((l) xt7.d.b.c(l.Companion.serializer(), r0));     // Catch: Throwable -> L77
    L80:
        if (Result.isFailure-impl(r21) == true) goto L178;
        r1 = r21;
    L178:
        return (k1) r1;
    L77:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    L61:
        if (r5.intValue() != 5) goto L71;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L64
        Object r24 = Result.constructor-impl((l0) xt7.d.b.c(l0.Companion.serializer(), r0));     // Catch: Throwable -> L64
    L67:
        if (Result.isFailure-impl(r24) == true) goto L177;
        r1 = r24;
    L177:
        return (k1) r1;
    L64:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L67
    L48:
        if (r5.intValue() != 4) goto L58;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L51
        Object r27 = Result.constructor-impl((k) xt7.d.b.c(k.Companion.serializer(), r0));     // Catch: Throwable -> L51
    L54:
        if (Result.isFailure-impl(r27) == true) goto L176;
        r1 = r27;
    L176:
        return (k1) r1;
    L51:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    L35:
        if (r5.intValue() != 3) goto L45;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L38
        Object r30 = Result.constructor-impl((p) xt7.d.b.c(p.Companion.serializer(), r0));     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r30) == true) goto L175;
        r1 = r30;
    L175:
        return (k1) r1;
    L38:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L22:
        if (r5.intValue() != 2) goto L32;
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L25
        Object r33 = Result.constructor-impl((i) xt7.d.b.c(i.Companion.serializer(), r0));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r33) == true) goto L174;
        r1 = r33;
    L174:
        return (k1) r1;
    L25:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L9:
        if (r5.intValue() != 1) goto L19;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L12
        Object r36 = Result.constructor-impl((k0) xt7.d.b.c(k0.Companion.serializer(), r0));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r36) == true) goto L173;
        r1 = r36;
    L173:
        return (k1) r1;
    L12:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static List b(List r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        u r1 = (u) r4.next();
        a.getClass();
        k1 r2 = a(r1);
        if (r2 == null) goto L7;
        r0.add(r2);
        goto L7
    L11:
        return r0;
    }
}
