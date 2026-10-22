package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends com.larus.bmhome.instruction.core.impl.base.b {
    public com.larus.bmhome.actionbar.model.h p;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public e() {
        super("DropFeatureSelectorController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r2 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r3 = this.o;
        com.larus.bmhome.actionbar.model.h r4 = this.p;
        com.larus.bmhome.actionbar.model.u r1 = this.b;
        String r6 = null;
        if (r1 == null) goto L9;
        String r5 = r1.c;
        if (r5 == null) goto L9;
        if ((!StringsKt.isBlank(r5)) == false) goto L9;
        String r7 = r5;
    L10:
        com.larus.bmhome.actionbar.model.u r8 = this.b;
        if (r8 == null) goto L18;
        Integer r9 = r8.a;
        if (r9 == null) goto L18;
        if (r9.intValue() != 1) goto L18;
        boolean r10 = true;
    L19:
        Integer r11 = this.h;
        com.larus.bmhome.instruction.core.impl.base.c r12 = this.c;
        if (r12 == null) goto L26;
        aq8.d r13 = r12.a;
        if (r13 == null) goto L26;
        dq8.h r14 = r13.a;
        if (r14 == null) goto L26;
        String r15 = r14.getBotId();
    L27:
        com.larus.bmhome.instruction.core.impl.base.c r16 = this.c;
        if (r16 == null) goto L34;
        aq8.d r17 = r16.a;
        if (r17 == null) goto L34;
        dq8.h r18 = r17.a;
        if (r18 == null) goto L34;
        String r19 = r18.getChatType();
    L35:
        com.larus.bmhome.instruction.core.impl.base.c r20 = this.c;
        if (r20 == null) goto L42;
        aq8.d r21 = r20.a;
        if (r21 == null) goto L42;
        dq8.h r22 = r21.a;
        if (r22 == null) goto L42;
        String r110 = r22.getTemplateType();
    L43:
        com.larus.bmhome.instruction.core.impl.base.c r23 = this.c;
        if (r23 == null) goto L52;
        aq8.d r24 = r23.a;
        if (r24 == null) goto L52;
        dq8.h r25 = r24.a;
        if (r25 == null) goto L52;
        Integer r26 = r25.getInstructionType();
        if (r26 == null) goto L52;
        String r111 = r26.toString();
    L53:
        com.larus.bmhome.instruction.core.impl.base.c r27 = this.c;
        if (r27 == null) goto L60;
        aq8.d r28 = r27.a;
        if (r28 == null) goto L60;
        dq8.h r29 = r28.a;
        if (r29 == null) goto L60;
        String r112 = r29.a();
    L61:
        com.larus.bmhome.instruction.core.impl.base.c r30 = this.c;
        if (r30 == null) goto L68;
        aq8.d r31 = r30.a;
        if (r31 == null) goto L68;
        dq8.h r32 = r31.a;
        if (r32 == null) goto L68;
        String r113 = r32.b();
    L69:
        com.larus.bmhome.instruction.core.impl.base.c r33 = this.c;
        if (r33 == null) goto L76;
        aq8.d r34 = r33.a;
        if (r34 == null) goto L76;
        dq8.h r35 = r34.a;
        if (r35 == null) goto L76;
        Boolean r114 = r35.isCreationActionBar();
    L77:
        com.larus.bmhome.actionbar.model.u r36 = this.b;
        if (r36 == null) goto L84;
        String r37 = r36.c;
        if (r37 == null) goto L84;
        if ((true ^ StringsKt.isBlank(r37)) == false) goto L84;
        String r115 = r37;
    L85:
        com.larus.bmhome.instruction.core.impl.base.c r38 = this.c;
        if (r38 == null) goto L93;
        aq8.d r39 = r38.a;
        if (r39 == null) goto L93;
        dq8.h r40 = r39.a;
        if (r40 == null) goto L93;
        r6 = r40.c();
    L93:
        return new cq8.k(r2, r3, r4, r7, r10, r11, new z0(r15, r19, r110, r6, r111, r112, r113, r114, r115, 2));
    L84:
        r115 = null;
    L76:
        r114 = null;
    L68:
        r113 = null;
    L60:
        r112 = null;
    L52:
        r111 = null;
    L42:
        r110 = null;
    L34:
        r19 = null;
    L26:
        r15 = null;
    L18:
        r10 = false;
    L9:
        r7 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.h r0 = this.p;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.e;
        boolean r3 = false;
        if (r2 == null) goto L20;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        Integer r7 = ((w) r6).s;
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
        goto L17
    L19:
        ArrayList r11 = r4;
    L21:
        if (r11 != null) goto L23;
    L24:
        r3 = true;
    L25:
        if (r3 == false) goto L27;
        return null;
    L27:
        com.larus.bmhome.actionbar.model.h r9 = this.p;
        if (r9 == null) goto L30;
        com.larus.bmhome.actionbar.model.h r10 = com.larus.bmhome.actionbar.model.h.a(r9, null, null, null, r11, null, null, 4079);
    L41:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L33
        Object r13 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.h.Companion.serializer()), r10));     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r13) == true) goto L40;
        r1 = r13;
    L40:
        return (String) r1;
    L33:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L30:
        r10 = null;
        goto L41
    L23:
        if (r11.isEmpty() == false) goto L25;
    L20:
        r11 = null;
        goto L21
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r6) {
        Intrinsics.checkNotNullParameter(r6, "instructionDefaultParams");
        Object r7 = r6.get(String.valueOf(getType()));
        if ((r7 instanceof Map) == false) goto L5;
        Map r8 = (Map) r7;
    L6:
        if (r8 == null) goto L8;
        Object r9 = r8.get(String.valueOf(6));
    L10:
        if ((r9 instanceof Map) == false) goto L12;
        Map r10 = (Map) r9;
    L13:
        if (r10 == null) goto L16;
        Object r0 = r10.get(null);
        if (r0 == null) goto L16;
    L20:
        if ((r0 instanceof Map) == false) goto L22;
        Map r1 = (Map) r0;
    L23:
        if (r1 == null) goto L41;
        Object r11 = r1.get("default_select_id");
        if (r11 == null) goto L48;
        com.larus.bmhome.actionbar.model.h r2 = this.p;
        if (r2 == null) goto L49;
        List r3 = r2.e;
        if (r3 == null) goto L50;
        Iterator r4 = r3.iterator();
    L32:
        if (r4.hasNext() == false) goto L51;
        w r5 = (w) r4.next();
        Long r12 = r5.a;
        if (r12 == null) goto L36;
        String r13 = r12.toString();
    L38:
        if (Intrinsics.areEqual(r13, r11) == true) goto L39;
        r5.s = 0;
        goto L32
    L39:
        r5.s = 1;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        goto L32
    L36:
        r13 = null;
        goto L38
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L41:
        return;
    L22:
        r1 = null;
    L16:
        if (r10 == null) goto L18;
        r0 = r10.get("match_all_id");
        goto L20
    L18:
        r0 = null;
        goto L20
    L12:
        r10 = null;
        goto L13
    L8:
        r9 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (Intrinsics.areEqual(r3.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r3 instanceof cq8.j) == false) goto L12;
        com.larus.bmhome.actionbar.model.h r0 = this.p;
        if (r0 == null) goto L10;
        r0.e = ((cq8.j) r3).c;
    L10:
        j();
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L30;
        com.larus.bmhome.actionbar.model.h r7 = (com.larus.bmhome.actionbar.model.h) r6;
        List r8 = r7.e;
        if (r8 != null) goto L21;
    L24:
        if (r0 == true) goto L26;
        this.p = r7;
        return new wa8.a0(Boolean.TRUE, "");
    L26:
        return new wa8.a0(Boolean.FALSE, "drop down box parse empty");
    L21:
        if (r8.isEmpty() == true) goto L24;
        r0 = false;
        goto L24
    L30:
        return new wa8.a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "style feature selector box is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "defaultStateTemplate");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r5));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        com.larus.bmhome.actionbar.model.h r9 = (com.larus.bmhome.actionbar.model.h) r8;
        if (r9 != null) goto L13;
        return;
    L13:
        List r10 = r9.e;
        if (r10 == null) goto L29;
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L44;
        w r12 = (w) r11.next();
        com.larus.bmhome.actionbar.model.h r0 = this.p;
        if (r0 == null) goto L17;
        List r1 = r0.e;
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
    L24:
        if (r2.hasNext() == false) goto L17;
        w r3 = (w) r2.next();
        if (Intrinsics.areEqual(r3.a, r12.a) == true) goto L27;
        r3.s = 0;
        goto L24
    L27:
        r3.s = 1;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        goto L24
    L44:
        return;
    L29:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
