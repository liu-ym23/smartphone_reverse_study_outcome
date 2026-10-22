package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i extends com.larus.bmhome.instruction.core.impl.base.b {
    public com.larus.bmhome.actionbar.model.l p;
    public int q;
    public boolean r;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 6;
    }

    public i() {
        super("ImageListSelectorController");
        this.q = -1;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        com.larus.bmhome.actionbar.model.l r0 = this.p;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.c, Boolean.TRUE);
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

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        if (this.r == true) goto L48;
        this.r = true;
        com.larus.bmhome.actionbar.model.l r1 = this.p;
        if (r1 == null) goto L10;
        Integer r2 = r1.b;
        if (r2 == null) goto L10;
        int r3 = r2.intValue();
    L11:
        if (r3 < 0) goto L19;
        com.larus.bmhome.actionbar.model.l r4 = this.p;
        if (r4 == null) goto L19;
        List r5 = r4.a;
        if (r5 == null) goto L19;
        w r6 = (w) CollectionsKt.getOrNull(r5, r3);
        if (r6 == null) goto L19;
        r6.s = 1;
    L19:
        com.larus.bmhome.actionbar.model.l r7 = this.p;
        if (r7 == null) goto L43;
        List r8 = r7.a;
        if (r8 == null) goto L43;
        List r9 = r8;
        if ((r9 instanceof Collection) == true) goto L26;
    L28:
        Iterator r10 = r9.iterator();
    L30:
        if (r10.hasNext() == false) goto L40;
        Integer r11 = ((w) r10.next()).s;
        if (r11 != null) goto L35;
    L37:
        boolean r12 = false;
    L38:
        if (r12 == false) goto L30;
        boolean r13 = true;
    L41:
        if (r13 != true) goto L43;
        boolean r14 = true;
    L44:
        if (r14 == false) goto L48;
        if (p() == false) goto L48;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        goto L48
    L35:
        if (r11.intValue() != 1) goto L37;
        r12 = true;
    L40:
        r13 = false;
        goto L41
    L26:
        if (r9.isEmpty() == false) goto L28;
    L43:
        r14 = false;
    L10:
        r3 = -1;
    L48:
        String r15 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r16 = this.o;
        com.larus.bmhome.actionbar.model.l r17 = this.p;
        com.larus.bmhome.actionbar.model.u r18 = this.b;
        String r19 = null;
        if (r18 == null) goto L55;
        String r20 = r18.c;
        if (r20 == null) goto L55;
        if ((!StringsKt.isBlank(r20)) == false) goto L55;
        String r21 = r20;
    L56:
        com.larus.bmhome.actionbar.model.u r22 = this.b;
        if (r22 == null) goto L59;
        boolean r23 = Intrinsics.areEqual(r22.f, Boolean.TRUE);
    L60:
        boolean r110 = p();
        com.larus.bmhome.instruction.core.impl.base.c r24 = this.c;
        if (r24 == null) goto L67;
        aq8.d r25 = r24.a;
        if (r25 == null) goto L67;
        dq8.h r26 = r25.a;
        if (r26 == null) goto L67;
        String r111 = r26.getBotId();
    L68:
        com.larus.bmhome.instruction.core.impl.base.c r27 = this.c;
        if (r27 == null) goto L75;
        aq8.d r28 = r27.a;
        if (r28 == null) goto L75;
        dq8.h r29 = r28.a;
        if (r29 == null) goto L75;
        String r112 = r29.getChatType();
    L76:
        com.larus.bmhome.instruction.core.impl.base.c r30 = this.c;
        if (r30 == null) goto L83;
        aq8.d r31 = r30.a;
        if (r31 == null) goto L83;
        dq8.h r32 = r31.a;
        if (r32 == null) goto L83;
        String r113 = r32.getTemplateType();
    L84:
        com.larus.bmhome.instruction.core.impl.base.c r33 = this.c;
        if (r33 == null) goto L93;
        aq8.d r34 = r33.a;
        if (r34 == null) goto L93;
        dq8.h r35 = r34.a;
        if (r35 == null) goto L93;
        Integer r36 = r35.getInstructionType();
        if (r36 == null) goto L93;
        String r114 = r36.toString();
    L94:
        com.larus.bmhome.instruction.core.impl.base.c r37 = this.c;
        if (r37 == null) goto L101;
        aq8.d r38 = r37.a;
        if (r38 == null) goto L101;
        dq8.h r39 = r38.a;
        if (r39 == null) goto L101;
        String r115 = r39.a();
    L102:
        com.larus.bmhome.instruction.core.impl.base.c r40 = this.c;
        if (r40 == null) goto L109;
        aq8.d r41 = r40.a;
        if (r41 == null) goto L109;
        dq8.h r42 = r41.a;
        if (r42 == null) goto L109;
        String r116 = r42.b();
    L110:
        com.larus.bmhome.instruction.core.impl.base.c r43 = this.c;
        if (r43 == null) goto L117;
        aq8.d r44 = r43.a;
        if (r44 == null) goto L117;
        dq8.h r45 = r44.a;
        if (r45 == null) goto L117;
        Boolean r117 = r45.isCreationActionBar();
    L118:
        com.larus.bmhome.actionbar.model.u r46 = this.b;
        if (r46 == null) goto L125;
        String r47 = r46.c;
        if (r47 == null) goto L125;
        if ((!StringsKt.isBlank(r47)) == false) goto L125;
        String r210 = r47;
    L126:
        com.larus.bmhome.instruction.core.impl.base.c r48 = this.c;
        if (r48 == null) goto L134;
        aq8.d r49 = r48.a;
        if (r49 == null) goto L134;
        dq8.h r50 = r49.a;
        if (r50 == null) goto L134;
        r19 = r50.c();
    L134:
        return new cq8.r(r15, r16, r17, r21, r23, r110, new z0(r111, r112, r113, r19, r114, r115, r116, r117, r210, 2), this.q);
    L125:
        r210 = null;
    L117:
        r117 = null;
    L109:
        r116 = null;
    L101:
        r115 = null;
    L93:
        r114 = null;
    L83:
        r113 = null;
    L75:
        r112 = null;
    L67:
        r111 = null;
        goto L68
    L59:
        r23 = false;
    L55:
        r21 = null;
        goto L56
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.l r0 = this.p;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.a;
        boolean r3 = false;
        if (r2 == null) goto L19;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L9:
        if (r5.hasNext() == false) goto L20;
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
    L20:
        if (r4 != null) goto L22;
    L23:
        r3 = true;
    L24:
        if (r3 == false) goto L26;
        return null;
    L26:
        com.larus.bmhome.actionbar.model.l r9 = this.p;
        if (r9 == null) goto L29;
        com.larus.bmhome.actionbar.model.l r10 = new com.larus.bmhome.actionbar.model.l(r4, r9.b, r9.c);
    L40:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
        Object r12 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.l.Companion.serializer()), r10));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r12) == true) goto L39;
        r1 = r12;
    L39:
        return (String) r1;
    L32:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L29:
        r10 = null;
        goto L40
    L22:
        if (r4.isEmpty() == false) goto L24;
    L19:
        r4 = null;
        goto L20
    }

    public final boolean p() {
        com.larus.bmhome.actionbar.model.u r0 = this.b;
        if (r0 == null) goto L11;
        Integer r1 = r0.a;
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public final void q() {
        if (p() == true) goto L5;
        return;
    L5:
        com.larus.bmhome.actionbar.model.l r0 = this.p;
        boolean r1 = false;
        if (r0 == null) goto L28;
        List r2 = r0.a;
        if (r2 == null) goto L28;
        List r3 = r2;
        if ((r3 instanceof Collection) == true) goto L12;
    L14:
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L13;
        Integer r5 = ((w) r4.next()).s;
        if (r5 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L16;
        boolean r7 = true;
    L26:
        if (r7 != true) goto L28;
        r1 = true;
        goto L28
    L21:
        if (r5.intValue() != 1) goto L23;
        r6 = true;
    L13:
        r7 = false;
        goto L26
    L12:
        if (r3.isEmpty() == false) goto L14;
    L28:
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(r1));
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r15) {
        Intrinsics.checkNotNullParameter(r15, "action");
        if (Intrinsics.areEqual(r15.a(), getWidgetId()) == true) goto L5;
        return;
    L5:
        int r1 = 0;
        if ((r15 instanceof cq8.q) == false) goto L38;
        cq8.q r16 = (cq8.q) r15;
        com.larus.bmhome.actionbar.model.l r0 = this.p;
        if (r0 == null) goto L36;
        List r3 = r0.a;
        if (r3 == null) goto L36;
        boolean r2 = Intrinsics.areEqual(r0.c, Boolean.TRUE);
        List r4 = r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L14:
        if (r6.hasNext() == false) goto L32;
        w r7 = (w) r6.next();
        Long r8 = r7.a;
        long r9 = r16.c;
        if (r8 != null) goto L19;
    L24:
        Long r10 = r7.a;
        long r11 = r16.c;
        if (r10 != null) goto L28;
    L30:
        int r12 = 0;
    L31:
        r5.add(w.a(r7, null, null, Integer.valueOf(r12), null, null, null, 8126463));
        goto L14
    L28:
        if (r10.longValue() != r11) goto L30;
        r12 = 1;
        goto L31
    L19:
        if (r8.longValue() != r9) goto L24;
        if (r16.d == false) goto L24;
        if (r2 == true) goto L24;
    L32:
        List r17 = CollectionsKt.toMutableList(r5);
        com.larus.bmhome.actionbar.model.l r13 = this.p;
        if (r13 == null) goto L35;
        r13.a = r17;
    L35:
        this.q = -1;
        q();
    L36:
        j();
        return;
    L38:
        if ((r15 instanceof cq8.s) == false) goto L67;
        cq8.s r18 = (cq8.s) r15;
        com.larus.bmhome.actionbar.model.l r14 = this.p;
        if (r14 == null) goto L58;
        List r19 = r14.a;
        if (r19 == null) goto L58;
        Long r110 = r18.c;
        List r20 = r19;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
        int r23 = 0;
    L46:
        if (r22.hasNext() == false) goto L54;
        Object r24 = r22.next();
        int r25 = r1 + 1;
        if (r1 >= 0) goto L50;
        CollectionsKt.throwIndexOverflow();
    L50:
        w r26 = (w) r24;
        boolean r27 = Intrinsics.areEqual(r26.a, r110);
        if (r27 == false) goto L53;
        r23 = r1;
    L53:
        r21.add(w.a(r26, null, null, Integer.valueOf(r27 ? 1 : 0), null, null, null, 8126463));
        r1 = r25;
        goto L46
    L54:
        List r111 = CollectionsKt.toMutableList(r21);
        com.larus.bmhome.actionbar.model.l r28 = this.p;
        if (r28 == null) goto L57;
        r28.a = r111;
    L57:
        this.q = r23;
        q();
    L58:
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
        Object r6 = Result.constructor-impl((com.larus.bmhome.actionbar.model.l) xt7.d.b.c(com.larus.bmhome.actionbar.model.l.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L30;
        com.larus.bmhome.actionbar.model.l r7 = (com.larus.bmhome.actionbar.model.l) r6;
        List r8 = r7.a;
        if (r8 != null) goto L21;
    L24:
        if (r0 == true) goto L26;
        this.p = r7;
        return new wa8.a0(Boolean.TRUE, "");
    L26:
        return new wa8.a0(Boolean.FALSE, "imageList is empty");
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
        return new wa8.a0(Boolean.FALSE, "image list selector is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "defaultStateTemplate");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((com.larus.bmhome.actionbar.model.l) xt7.d.b.c(com.larus.bmhome.actionbar.model.l.Companion.serializer(), r5));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        com.larus.bmhome.actionbar.model.l r9 = (com.larus.bmhome.actionbar.model.l) r8;
        if (r9 != null) goto L13;
        return;
    L13:
        List r10 = r9.a;
        if (r10 == null) goto L29;
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L44;
        w r12 = (w) r11.next();
        com.larus.bmhome.actionbar.model.l r0 = this.p;
        if (r0 == null) goto L17;
        List r1 = r0.a;
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
