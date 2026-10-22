package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.k0;
import com.larus.bmhome.actionbar.model.q1;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.y1;
import cq8.a0;
import cq8.t0;
import cq8.u0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class s extends com.larus.bmhome.instruction.core.impl.base.b implements com.larus.bmhome.instruction.core.impl.base.h {
    public k0 p;
    public boolean q;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 1;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        k0 r0 = this.p;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.e, Boolean.TRUE);
    L6:
        if (r1 == true) goto L8;
    L9:
        return true;
    L8:
        if (g() != null) goto L9;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.h
    public final List<com.larus.bmhome.instruction.core.impl.base.d> b() {
        k0 r0 = this.p;
        t1 r2 = null;
        if (r0 == null) goto L20;
        List r1 = r0.c;
        if (r1 == null) goto L20;
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        Integer r5 = ((y1) r4).g;
        if (r5 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L8;
    L19:
        y1 r7 = (y1) r4;
    L21:
        if (r7 == null) goto L23;
        r2 = r7.e;
    L28:
        if (r2 != null) goto L32;
        return CollectionsKt.emptyList();
    L32:
        return CollectionsKt.listOf(new com.larus.bmhome.instruction.core.impl.base.l(getWidgetId(), r2, true));
    L23:
        k0 r8 = this.p;
        if (r8 == null) goto L28;
        y1 r9 = r8.b;
        if (r9 == null) goto L28;
        r2 = r9.e;
        goto L28
    L13:
        if (r5.intValue() != 1) goto L15;
        r6 = true;
        goto L16
    L18:
        r4 = null;
    L20:
        r7 = null;
        goto L21
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public a0 d() {
        String r2 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r3 = this.o;
        k0 r4 = this.p;
        boolean r5 = this.q;
        com.larus.bmhome.actionbar.model.u r1 = this.b;
        String r6 = null;
        if (r1 == null) goto L9;
        String r7 = r1.c;
        if (r7 == null) goto L9;
        if ((!StringsKt.isBlank(r7)) == false) goto L9;
        String r8 = r7;
    L10:
        com.larus.bmhome.actionbar.model.u r9 = this.b;
        if (r9 == null) goto L13;
        boolean r10 = Intrinsics.areEqual(r9.f, Boolean.TRUE);
    L14:
        com.larus.bmhome.instruction.core.impl.base.c r11 = this.c;
        if (r11 == null) goto L21;
        aq8.d r12 = r11.a;
        if (r12 == null) goto L21;
        dq8.h r13 = r12.a;
        if (r13 == null) goto L21;
        String r14 = r13.getBotId();
    L22:
        com.larus.bmhome.instruction.core.impl.base.c r15 = this.c;
        if (r15 == null) goto L29;
        aq8.d r16 = r15.a;
        if (r16 == null) goto L29;
        dq8.h r17 = r16.a;
        if (r17 == null) goto L29;
        String r18 = r17.getChatType();
    L30:
        com.larus.bmhome.instruction.core.impl.base.c r19 = this.c;
        if (r19 == null) goto L37;
        aq8.d r20 = r19.a;
        if (r20 == null) goto L37;
        dq8.h r21 = r20.a;
        if (r21 == null) goto L37;
        String r110 = r21.getTemplateType();
    L38:
        com.larus.bmhome.instruction.core.impl.base.c r22 = this.c;
        if (r22 == null) goto L47;
        aq8.d r23 = r22.a;
        if (r23 == null) goto L47;
        dq8.h r24 = r23.a;
        if (r24 == null) goto L47;
        Integer r25 = r24.getInstructionType();
        if (r25 == null) goto L47;
        String r111 = r25.toString();
    L48:
        com.larus.bmhome.instruction.core.impl.base.c r26 = this.c;
        if (r26 == null) goto L55;
        aq8.d r27 = r26.a;
        if (r27 == null) goto L55;
        dq8.h r28 = r27.a;
        if (r28 == null) goto L55;
        String r112 = r28.a();
    L56:
        com.larus.bmhome.instruction.core.impl.base.c r29 = this.c;
        if (r29 == null) goto L63;
        aq8.d r30 = r29.a;
        if (r30 == null) goto L63;
        dq8.h r31 = r30.a;
        if (r31 == null) goto L63;
        String r113 = r31.b();
    L64:
        com.larus.bmhome.instruction.core.impl.base.c r32 = this.c;
        if (r32 == null) goto L71;
        aq8.d r33 = r32.a;
        if (r33 == null) goto L71;
        dq8.h r34 = r33.a;
        if (r34 == null) goto L71;
        Boolean r114 = r34.isCreationActionBar();
    L72:
        com.larus.bmhome.actionbar.model.u r35 = this.b;
        if (r35 == null) goto L79;
        String r36 = r35.c;
        if (r36 == null) goto L79;
        if ((!StringsKt.isBlank(r36)) == false) goto L79;
        String r115 = r36;
    L80:
        com.larus.bmhome.instruction.core.impl.base.c r37 = this.c;
        if (r37 == null) goto L88;
        aq8.d r38 = r37.a;
        if (r38 == null) goto L88;
        dq8.h r39 = r38.a;
        if (r39 == null) goto L88;
        r6 = r39.c();
    L88:
        return new u0(r2, r3, r4, r5, r8, r10, new z0(r14, r18, r110, r6, r111, r112, r113, r114, r115, 2));
    L79:
        r115 = null;
    L71:
        r114 = null;
    L63:
        r113 = null;
    L55:
        r112 = null;
    L47:
        r111 = null;
    L37:
        r110 = null;
    L29:
        r18 = null;
    L21:
        r14 = null;
        goto L22
    L13:
        r10 = false;
    L9:
        r8 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        k0 r0 = this.p;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.c;
        boolean r3 = false;
        if (r2 == null) goto L19;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
        Object r6 = r5.next();
        Integer r7 = ((y1) r6).g;
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L9;
        r4.add(r6);
        goto L9
    L14:
        if (r7.intValue() != 1) goto L16;
        r8 = true;
    L20:
        k0 r9 = this.p;
        if (r9 == null) goto L32;
        if (r4 != null) goto L24;
    L27:
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        ArrayList r11 = null;
    L31:
        k0 r12 = k0.d(r9, r11);
    L33:
        if (r4 != null) goto L35;
    L36:
        r3 = true;
    L37:
        if (r3 == false) goto L54;
        k0 r13 = this.p;
        if (r13 == null) goto L41;
        y1 r14 = r13.b;
    L42:
        if (r14 != null) goto L54;
        return null;
    L41:
        r14 = null;
    L54:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L46
        Object r16 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(k0.Companion.serializer()), r12));     // Catch: Throwable -> L46
    L49:
        if (Result.isFailure-impl(r16) == true) goto L53;
        r1 = r16;
    L53:
        return (String) r1;
    L46:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L35:
        if (r4.isEmpty() == false) goto L37;
    L30:
        r11 = r4;
        goto L31
    L24:
        if (r4.isEmpty() == true) goto L27;
        r10 = false;
        goto L28
    L32:
        r12 = null;
        goto L33
    L19:
        r4 = null;
        goto L20
    }

    public s(String r2) {
        Intrinsics.checkNotNullParameter(r2, "controllerLogName");
        super(r2);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r12) {
        Intrinsics.checkNotNullParameter(r12, "action");
        if ((r12 instanceof t0) == false) goto L100;
        this.q = false;
        k0 r1 = this.p;
        if (r1 != null) goto L7;
        return;
    L7:
        List r2 = r1.c;
        if (r2 != null) goto L10;
        return;
    L10:
        List r3 = r2;
        Iterator r4 = r3.iterator();
    L11:
        boolean r6 = true;
        Object r7 = null;
        if (r4.hasNext() == false) goto L22;
        Object r5 = r4.next();
        Integer r8 = ((y1) r5).a;
        int r9 = ((t0) r12).c;
        if (r8 != null) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == false) goto L11;
    L23:
        y1 r11 = (y1) r5;
        if (r11 != null) goto L26;
        return;
    L26:
        boolean r13 = Intrinsics.areEqual(r1.e, Boolean.TRUE);
        ArrayList r14 = new ArrayList();
        Iterator r15 = r3.iterator();
    L28:
        if (r15.hasNext() == false) goto L38;
        Object r16 = r15.next();
        Integer r17 = ((y1) r16).g;
        if (r17 != null) goto L33;
    L35:
        boolean r18 = false;
    L36:
        if (r18 == false) goto L28;
        r14.add(r16);
        goto L28
    L33:
        if (r17.intValue() != 1) goto L35;
        r18 = true;
        goto L36
    L38:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r14.iterator();
    L40:
        if (r20.hasNext() == false) goto L44;
        Integer r21 = ((y1) r20.next()).a;
        if (r21 == null) goto L40;
        r19.add(r21);
        goto L40
    L44:
        Set r22 = CollectionsKt.toSet(r19);
        Integer r23 = r11.g;
        if (r23 != null) goto L48;
    L50:
        r6 = false;
    L51:
        if (r13 == false) goto L53;
        Integer r110 = Integer.valueOf(((t0) r12).c);
    L56:
        if (r110 == null) goto L58;
        Set r24 = SetsKt.setOf(Integer.valueOf(r110.intValue()));
    L59:
        if (r24 != null) goto L62;
        r24 = SetsKt.emptySet();
    L62:
        if (Intrinsics.areEqual(r22, r24) == false) goto L71;
        Iterator r25 = r3.iterator();
    L65:
        if (r25.hasNext() == false) goto L69;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((y1) r26).a, r110) == false) goto L65;
        r7 = r26;
    L69:
        q((y1) r7, false);
        return;
    L71:
        p(r2, r110);
        Iterator r27 = r3.iterator();
    L73:
        if (r27.hasNext() == false) goto L77;
        Object r28 = r27.next();
        if (Intrinsics.areEqual(((y1) r28).a, r110) == false) goto L73;
        r7 = r28;
    L77:
        q((y1) r7, false);
        j();
        return;
    L58:
        r24 = null;
        goto L59
    L53:
        if (r6 == false) goto L55;
        r110 = null;
        goto L56
    L55:
        r110 = Integer.valueOf(((t0) r12).c);
        goto L56
    L48:
        if (r23.intValue() != 1) goto L50;
    L17:
        if (r8.intValue() != r9) goto L19;
        r10 = true;
        goto L20
    L22:
        r5 = null;
        goto L23
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r7) {
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        int r3 = -1;
        Object r4 = null;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
        k0 r8 = (k0) xt7.d.b.c(kuc.a.d(k0.Companion.serializer()), r7);     // Catch: Throwable -> L21
        if (r8 != null) goto L16;
        r8 = null;
    L19:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L21
    L23:
        Throwable r6 = Result.exceptionOrNull-impl(r9);
        if (r6 != null) goto L81;
        k0 r10 = (k0) r9;
        if (r10 == null) goto L28;
        List r11 = r10.c;
    L29:
        List r12 = r11;
        if (r12 != null) goto L32;
    L35:
        boolean r13 = true;
    L36:
        if (r13 == true) goto L38;
        this.p = r10;
        if (r10 == null) goto L79;
        List r14 = r10.c;
        if (r14 == null) goto L79;
        Integer r15 = r10.d;
        if (r15 == null) goto L48;
        r3 = r15.intValue();
    L48:
        if (r3 < 0) goto L52;
        y1 r16 = (y1) CollectionsKt.getOrNull(r14, r3);
        if (r16 == null) goto L52;
        Integer r17 = r16.a;
    L53:
        if (r17 != null) goto L71;
        Iterator r18 = r14.iterator();
    L56:
        if (r18.hasNext() == false) goto L66;
        Object r19 = r18.next();
        Integer r20 = ((y1) r19).g;
        if (r20 != null) goto L61;
    L63:
        boolean r21 = false;
    L64:
        if (r21 == false) goto L56;
    L67:
        y1 r22 = (y1) r19;
        if (r22 == null) goto L70;
        r17 = r22.a;
        goto L71
    L70:
        r17 = null;
        goto L71
    L61:
        if (r20.intValue() != 1) goto L63;
        r21 = true;
        goto L64
    L66:
        r19 = null;
    L71:
        p(r14, r17);
        Iterator r0 = r14.iterator();
    L73:
        if (r0.hasNext() == false) goto L77;
        Object r23 = r0.next();
        if (Intrinsics.areEqual(((y1) r23).a, r17) == false) goto L73;
        r4 = r23;
    L77:
        q((y1) r4, true);
    L52:
        r17 = null;
    L79:
        return new wa8.a0(Boolean.TRUE, "");
    L38:
        return new wa8.a0(Boolean.FALSE, "text list option list is empty");
    L32:
        if (r12.isEmpty() == true) goto L35;
        r13 = false;
        goto L36
    L28:
        r11 = null;
        goto L29
    L81:
        return new wa8.a0(Boolean.FALSE, r6.getMessage());
    L16:
        if (getType() != 13) goto L19;
        r8.d = -1;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L11:
        return new wa8.a0(Boolean.FALSE, "text list selector is empty template");
    L5:
        if (r7.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public /* synthetic */ s(int r1) {
        this("TextListSelectorController");
    }

    public static void p(List r2, Integer r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        y1 r0 = (y1) r4.next();
        if (r3 != null) goto L8;
    L10:
        int r1 = 0;
    L11:
        r0.g = r1;
        goto L4
    L8:
        if (Intrinsics.areEqual(r0.a, r3) == false) goto L10;
        r1 = 1;
        goto L11
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "defaultStateTemplate");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r9 = Result.constructor-impl((k0) xt7.d.b.c(k0.Companion.serializer(), r7));     // Catch: Throwable -> L5
    L7:
        y1 r1 = null;
        Object r2 = null;
        r1 = null;
        if (Result.isFailure-impl(r9) == false) goto L10;
        r9 = null;
    L10:
        k0 r10 = (k0) r9;
        int r3 = -1;
        if (r10 != null) goto L13;
        r10 = null;
    L16:
        if (r10 != null) goto L18;
        return;
    L18:
        List r11 = r10.c;
        if (r11 == null) goto L23;
        y1 r12 = (y1) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L23;
        Integer r13 = r12.a;
    L24:
        k0 r4 = this.p;
        if (r4 == null) goto L29;
        List r5 = r4.c;
        if (r5 == null) goto L29;
        p(r5, r13);
    L29:
        k0 r14 = this.p;
        if (r14 == null) goto L46;
        List r15 = r14.c;
        if (r15 == null) goto L46;
        Iterator r16 = r15.iterator();
        int r6 = 0;
    L35:
        if (r16.hasNext() == false) goto L46;
        Integer r17 = ((y1) r16.next()).g;
        if (r17 != null) goto L40;
    L42:
        boolean r18 = false;
    L43:
        if (r18 == true) goto L44;
        r6 = r6 + 1;
        goto L35
    L44:
        r3 = r6;
        goto L46
    L40:
        if (r17.intValue() != 1) goto L42;
        r18 = true;
    L46:
        if (r3 < 0) goto L49;
        if (r8 == false) goto L49;
        this.q = true;
    L49:
        k0 r19 = this.p;
        if (r19 == null) goto L66;
        List r20 = r19.c;
        if (r20 == null) goto L66;
        Iterator r21 = r20.iterator();
    L55:
        if (r21.hasNext() == false) goto L65;
        Object r22 = r21.next();
        Integer r23 = ((y1) r22).g;
        if (r23 != null) goto L60;
    L62:
        boolean r24 = false;
    L63:
        if (r24 == false) goto L55;
        r2 = r22;
        goto L65
    L60:
        if (r23.intValue() != 1) goto L62;
        r24 = true;
    L65:
        r1 = (y1) r2;
    L66:
        q(r1, true);
        return;
    L23:
        r13 = null;
        goto L24
    L13:
        if (getType() != 13) goto L16;
        r10.d = -1;
    L5:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void q(y1 r4, boolean r5) {
        String r0 = null;
        if (r4 == null) goto L11;
        q1 r2 = r4.d;
        if (r2 == null) goto L7;
        r0 = r2.a;
    L7:
        o(new com.larus.bmhome.instruction.core.impl.base.k.h(r0, "onItemSelected"));
        t1 r6 = r4.e;
        if (r6 == null) goto L23;
        e(new com.larus.bmhome.instruction.core.impl.base.l(getWidgetId(), r6, r5));
        o(new com.larus.bmhome.instruction.core.impl.base.k.n(r6, r5));
        return;
    L23:
        return;
    L11:
        k0 r7 = this.p;
        if (r7 == null) goto L24;
        y1 r8 = r7.b;
        if (r8 == null) goto L26;
        q1 r3 = r8.d;
        if (r3 == null) goto L19;
        r0 = r3.a;
    L19:
        o(new com.larus.bmhome.instruction.core.impl.base.k.h(r0, "resetDefaultSelection"));
        t1 r9 = r8.e;
        if (r9 == null) goto L25;
        e(new com.larus.bmhome.instruction.core.impl.base.l(getWidgetId(), r9, r5));
        o(new com.larus.bmhome.instruction.core.impl.base.k.n(r9, r5));
        return;
    L25:
        return;
    L26:
        return;
    }
}
