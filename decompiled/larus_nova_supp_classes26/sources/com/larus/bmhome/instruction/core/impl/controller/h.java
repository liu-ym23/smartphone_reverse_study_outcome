package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h extends com.larus.bmhome.instruction.core.impl.base.b {
    public com.larus.bmhome.actionbar.model.k p;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 4;
    }

    public h() {
        super("FeatureSelectorController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new cq8.p(getWidgetId(), this.o, this.p);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r1 = null;
        if (this.p != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        com.larus.bmhome.actionbar.model.k r2 = this.p;
        if (r2 == null) goto L35;
        List r3 = r2.c;
        if (r3 == null) goto L35;
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L35;
        com.larus.bmhome.actionbar.model.h r6 = (com.larus.bmhome.actionbar.model.h) r4.next();
        List r5 = r6.e;
        if (r5 == null) goto L27;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L16:
        if (r8.hasNext() == false) goto L26;
        Object r9 = r8.next();
        Integer r10 = ((w) r9).s;
        if (r10 != null) goto L21;
    L23:
        boolean r11 = false;
    L24:
        if (r11 == false) goto L16;
        r7.add(r9);
        goto L16
    L21:
        if (r10.intValue() != 1) goto L23;
        r11 = true;
        goto L24
    L26:
        ArrayList r12 = r7;
    L28:
        if (r12 != null) goto L30;
    L32:
        boolean r13 = false;
    L33:
        if (r13 == false) goto L11;
        r0.add(com.larus.bmhome.actionbar.model.h.a(r6, null, null, null, r12, null, null, 4079));
        goto L11
    L30:
        if ((!r12.isEmpty()) != true) goto L32;
        r13 = true;
        goto L33
    L27:
        r12 = null;
    L35:
        ArrayList r14 = new ArrayList();
        com.larus.bmhome.actionbar.model.k r15 = this.p;
        if (r15 == null) goto L65;
        List r16 = r15.b;
        if (r16 == null) goto L65;
        Iterator r17 = r16.iterator();
    L41:
        if (r17.hasNext() == false) goto L65;
        com.larus.bmhome.actionbar.model.t r18 = (com.larus.bmhome.actionbar.model.t) r17.next();
        List r19 = r18.c;
        if (r19 == null) goto L56;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L46:
        if (r21.hasNext() == false) goto L57;
        Object r22 = r21.next();
        Integer r110 = ((w) r22).s;
        if (r110 != null) goto L51;
    L53:
        boolean r111 = false;
    L54:
        if (r111 == false) goto L46;
        r20.add(r22);
        goto L46
    L51:
        if (r110.intValue() != 1) goto L53;
        r111 = true;
    L57:
        if (r20 != null) goto L59;
    L61:
        boolean r23 = false;
    L62:
        if (r23 == false) goto L41;
        r14.add(com.larus.bmhome.actionbar.model.t.a(r18, r20));
        goto L41
    L59:
        if ((!r20.isEmpty()) != true) goto L61;
        r23 = true;
        goto L62
    L56:
        r20 = null;
    L65:
        if (r0.isEmpty() == true) goto L67;
    L69:
        com.larus.bmhome.actionbar.model.k r24 = this.p;
        if (r24 == null) goto L72;
        com.larus.bmhome.actionbar.model.k r25 = com.larus.bmhome.actionbar.model.k.d(r24, r14, r0, 1);
    L83:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L75
        Object r27 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.k.Companion.serializer()), r25));     // Catch: Throwable -> L75
    L78:
        if (Result.isFailure-impl(r27) == true) goto L82;
        r1 = r27;
    L82:
        return (String) r1;
    L75:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L78
    L72:
        r25 = null;
        goto L83
    L67:
        if (r14.isEmpty() == false) goto L69;
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r9) {
        boolean r0 = true;
        if (r9 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r10 = Result.constructor-impl((com.larus.bmhome.actionbar.model.k) xt7.d.b.c(com.larus.bmhome.actionbar.model.k.Companion.serializer(), r9));     // Catch: Throwable -> L14
    L16:
        Throwable r5 = Result.exceptionOrNull-impl(r10);
        if (r5 != null) goto L67;
        com.larus.bmhome.actionbar.model.k r11 = (com.larus.bmhome.actionbar.model.k) r10;
        if (r11 == null) goto L21;
        List r6 = r11.b;
    L22:
        List r7 = r6;
        if (r7 != null) goto L25;
    L28:
        if (r0 == true) goto L30;
        this.p = r11;
        if (r11 == null) goto L65;
        List r12 = r11.c;
        if (r12 == null) goto L65;
        Iterator r13 = r12.iterator();
    L37:
        if (r13.hasNext() == false) goto L65;
        com.larus.bmhome.actionbar.model.h r1 = (com.larus.bmhome.actionbar.model.h) r13.next();
        if (Intrinsics.areEqual(r1.h, Boolean.TRUE) == true) goto L37;
        Integer r2 = r1.f;
        if (r2 == null) goto L43;
        int r8 = r2.intValue();
    L44:
        List r14 = r1.e;
        if (r14 == null) goto L56;
        Iterator r15 = r14.iterator();
    L48:
        if (r15.hasNext() == false) goto L52;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((w) r16).a, r1.g) == false) goto L48;
    L53:
        w r17 = (w) r16;
        if (r17 == null) goto L56;
        r17.s = 1;
    L57:
        if (r17 != null) goto L37;
        if (r8 < 0) goto L37;
        List r18 = r1.e;
        if (r18 == null) goto L37;
        w r19 = (w) CollectionsKt.getOrNull(r18, r8);
        if (r19 == null) goto L37;
        r19.s = 1;
        goto L37
    L52:
        r16 = null;
    L56:
        r17 = null;
        goto L57
    L43:
        r8 = -1;
    L65:
        return new wa8.a0(Boolean.TRUE, "");
    L30:
        return new wa8.a0(Boolean.FALSE, "feature option is empty");
    L25:
        if (r7.isEmpty() == true) goto L28;
        r0 = false;
        goto L28
    L21:
        r6 = null;
        goto L22
    L67:
        return new wa8.a0(Boolean.FALSE, r5.getMessage());
    L14:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "feature selector is empty template");
    L5:
        if (r9.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "defaultStateTemplate");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl((com.larus.bmhome.actionbar.model.k) xt7.d.b.c(com.larus.bmhome.actionbar.model.k.Companion.serializer(), r9));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r12) == false) goto L10;
        r12 = null;
    L10:
        com.larus.bmhome.actionbar.model.k r13 = (com.larus.bmhome.actionbar.model.k) r12;
        if (r13 != null) goto L13;
        return;
    L13:
        List r14 = r13.c;
        if (r14 == null) goto L48;
        Iterator r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L48;
        com.larus.bmhome.actionbar.model.h r3 = (com.larus.bmhome.actionbar.model.h) r15.next();
        com.larus.bmhome.actionbar.model.k r4 = this.p;
        if (r4 == null) goto L17;
        List r5 = r4.c;
        if (r5 == null) goto L17;
        Iterator r6 = r5.iterator();
    L24:
        if (r6.hasNext() == false) goto L28;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r7).b, r3.b) == false) goto L24;
    L29:
        com.larus.bmhome.actionbar.model.h r8 = (com.larus.bmhome.actionbar.model.h) r7;
        if (r8 == null) goto L17;
        List r16 = r3.e;
        if (r16 == null) goto L36;
        w r17 = (w) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L36;
        Long r18 = r17.a;
    L37:
        if (r18 == null) goto L17;
        List r19 = r8.e;
        if (r19 == null) goto L17;
        Iterator r20 = r19.iterator();
    L42:
        if (r20.hasNext() == false) goto L17;
        w r21 = (w) r20.next();
        if (Intrinsics.areEqual(r21.a, r18) == false) goto L46;
        int r22 = 1;
    L47:
        r21.s = r22;
        goto L42
    L46:
        r22 = 0;
    L36:
        r18 = null;
        goto L37
    L28:
        r7 = null;
    L48:
        List r23 = r13.b;
        if (r23 == null) goto L83;
        Iterator r24 = r23.iterator();
    L52:
        if (r24.hasNext() == false) goto L122;
        com.larus.bmhome.actionbar.model.t r110 = (com.larus.bmhome.actionbar.model.t) r24.next();
        com.larus.bmhome.actionbar.model.k r25 = this.p;
        if (r25 == null) goto L52;
        List r26 = r25.b;
        if (r26 == null) goto L52;
        Iterator r27 = r26.iterator();
    L59:
        if (r27.hasNext() == false) goto L63;
        Object r28 = r27.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.t) r28).a, r110.a) == false) goto L59;
    L64:
        com.larus.bmhome.actionbar.model.t r29 = (com.larus.bmhome.actionbar.model.t) r28;
        if (r29 == null) goto L52;
        List r111 = r110.c;
        if (r111 == null) goto L71;
        w r112 = (w) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L71;
        Long r113 = r112.a;
    L72:
        if (r113 == null) goto L52;
        List r30 = r29.c;
        if (r30 == null) goto L52;
        Iterator r31 = r30.iterator();
    L77:
        if (r31.hasNext() == false) goto L52;
        w r32 = (w) r31.next();
        if (Intrinsics.areEqual(r32.a, r113) == false) goto L81;
        int r33 = 1;
    L82:
        r32.s = r33;
        goto L77
    L81:
        r33 = 0;
    L71:
        r113 = null;
        goto L72
    L63:
        r28 = null;
        goto L64
    L122:
        return;
    L83:
        return;
    L5:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
