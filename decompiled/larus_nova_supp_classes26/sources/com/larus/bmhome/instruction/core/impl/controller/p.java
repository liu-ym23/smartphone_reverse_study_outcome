package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.m0;
import cq8.n0;
import cq8.o0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p extends com.larus.bmhome.instruction.core.impl.base.b {
    public d0 p;
    public bq8.a q;
    public boolean r;
    public boolean s;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 10;
    }

    public p() {
        super("MusicTemplateSelectorController");
        this.s = true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        d0 r0 = this.p;
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
        String r2 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r3 = this.o;
        d0 r4 = this.p;
        boolean r7 = this.r;
        com.larus.bmhome.actionbar.model.u r1 = this.b;
        if (r1 == null) goto L5;
        boolean r6 = Intrinsics.areEqual(r1.f, Boolean.TRUE);
    L6:
        com.larus.bmhome.actionbar.model.u r5 = this.b;
        String r8 = null;
        if (r5 == null) goto L13;
        String r9 = r5.c;
        if (r9 == null) goto L13;
        if ((!StringsKt.isBlank(r9)) == false) goto L13;
        String r10 = r9;
    L14:
        bq8.a r11 = this.q;
        com.larus.bmhome.instruction.core.impl.base.c r12 = this.c;
        if (r12 == null) goto L21;
        aq8.d r13 = r12.a;
        if (r13 == null) goto L21;
        dq8.h r14 = r13.a;
        if (r14 == null) goto L21;
        String r15 = r14.getBotId();
    L22:
        com.larus.bmhome.instruction.core.impl.base.c r16 = this.c;
        if (r16 == null) goto L29;
        aq8.d r17 = r16.a;
        if (r17 == null) goto L29;
        dq8.h r18 = r17.a;
        if (r18 == null) goto L29;
        String r19 = r18.getChatType();
    L30:
        com.larus.bmhome.instruction.core.impl.base.c r20 = this.c;
        if (r20 == null) goto L37;
        aq8.d r21 = r20.a;
        if (r21 == null) goto L37;
        dq8.h r22 = r21.a;
        if (r22 == null) goto L37;
        String r110 = r22.getTemplateType();
    L38:
        com.larus.bmhome.instruction.core.impl.base.c r23 = this.c;
        if (r23 == null) goto L47;
        aq8.d r24 = r23.a;
        if (r24 == null) goto L47;
        dq8.h r25 = r24.a;
        if (r25 == null) goto L47;
        Integer r26 = r25.getInstructionType();
        if (r26 == null) goto L47;
        String r111 = r26.toString();
    L48:
        com.larus.bmhome.instruction.core.impl.base.c r27 = this.c;
        if (r27 == null) goto L55;
        aq8.d r28 = r27.a;
        if (r28 == null) goto L55;
        dq8.h r29 = r28.a;
        if (r29 == null) goto L55;
        String r112 = r29.a();
    L56:
        com.larus.bmhome.instruction.core.impl.base.c r30 = this.c;
        if (r30 == null) goto L63;
        aq8.d r31 = r30.a;
        if (r31 == null) goto L63;
        dq8.h r32 = r31.a;
        if (r32 == null) goto L63;
        String r113 = r32.b();
    L64:
        com.larus.bmhome.instruction.core.impl.base.c r33 = this.c;
        if (r33 == null) goto L71;
        aq8.d r34 = r33.a;
        if (r34 == null) goto L71;
        dq8.h r35 = r34.a;
        if (r35 == null) goto L71;
        Boolean r114 = r35.isCreationActionBar();
    L72:
        com.larus.bmhome.actionbar.model.u r36 = this.b;
        if (r36 == null) goto L79;
        String r37 = r36.c;
        if (r37 == null) goto L79;
        if ((!StringsKt.isBlank(r37)) == false) goto L79;
        String r115 = r37;
    L80:
        com.larus.bmhome.instruction.core.impl.base.c r38 = this.c;
        if (r38 == null) goto L88;
        aq8.d r39 = r38.a;
        if (r39 == null) goto L88;
        dq8.h r40 = r39.a;
        if (r40 == null) goto L88;
        r8 = r40.c();
    L88:
        return new o0(r2, r3, r4, r10, r6, r7, r11, new z0(r15, r19, r110, r8, r111, r112, r113, r114, r115, 2), this.s);
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
        r19 = null;
    L21:
        r15 = null;
    L13:
        r10 = null;
        goto L14
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        d0 r0 = this.p;
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
        d0 r9 = this.p;
        if (r9 == null) goto L29;
        d0 r10 = d0.d(r9, r4, this.q, 14);
    L40:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
        Object r12 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(d0.Companion.serializer()), r10));     // Catch: Throwable -> L32
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

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r8) {
        Intrinsics.checkNotNullParameter(r8, "instructionDefaultParams");
        Object r9 = r8.get(String.valueOf(getType()));
        bq8.a r1 = null;
        if ((r9 instanceof Map) == false) goto L5;
        Map r10 = (Map) r9;
    L6:
        if (r10 == null) goto L9;
        Object r0 = r10.get(null);
        if (r0 == null) goto L9;
    L13:
        if ((r0 instanceof Map) == false) goto L15;
        Map r2 = (Map) r0;
    L16:
        if (r2 == null) goto L47;
        Object r11 = r2.get("default_select_id");
        if (r11 == null) goto L48;
        String r12 = r11.toString();
        if (r12 == null) goto L49;
        c0.b.d("MusicTemplateSelectorController", "onRestoreComponentStateByDefaultParams: select:".concat(r12));
        d0 r3 = this.p;
        if (r3 == null) goto L38;
        List r4 = r3.a;
        if (r4 == null) goto L38;
        Iterator r5 = r4.iterator();
        int r6 = 0;
    L27:
        if (r5.hasNext() == false) goto L38;
        Object r7 = r5.next();
        int r13 = r6 + 1;
        if (r6 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        w r14 = (w) r7;
        if (Intrinsics.areEqual(String.valueOf(r14.a), r12) == false) goto L36;
        r14.s = 1;
        d0 r15 = this.p;
        if (r15 == null) goto L37;
        r15.b = Integer.valueOf(r6);
    L37:
        r6 = r13;
        goto L27
    L36:
        r14.s = 0;
    L38:
        d0 r16 = this.p;
        if (r16 == null) goto L41;
        r1 = r16.e;
    L41:
        this.q = r1;
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L15:
        r2 = null;
    L9:
        if (r10 == null) goto L11;
        r0 = r10.get("match_all_id");
        goto L13
    L11:
        r0 = null;
        goto L13
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r14) {
        Intrinsics.checkNotNullParameter(r14, "action");
        if ((r14 instanceof m0) == false) goto L34;
        m0 r15 = (m0) r14;
        d0 r0 = this.p;
        if (r0 == null) goto L32;
        List r1 = r0.a;
        if (r1 == null) goto L32;
        boolean r2 = Intrinsics.areEqual(r0.c, Boolean.TRUE);
        List r3 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L10:
        int r6 = 0;
        if (r5.hasNext() == false) goto L28;
        w r7 = (w) r5.next();
        Long r8 = r7.a;
        long r9 = r15.c;
        if (r8 != null) goto L16;
    L21:
        Long r10 = r7.a;
        long r11 = r15.c;
        if (r10 == null) goto L27;
        if (r10.longValue() != r11) goto L27;
        r6 = 1;
    L27:
        r4.add(w.a(r7, null, null, Integer.valueOf(r6), null, null, null, 8126463));
        goto L10
    L16:
        if (r8.longValue() != r9) goto L21;
        if (r15.d == false) goto L21;
        if (r2 == true) goto L21;
    L28:
        List r16 = CollectionsKt.toMutableList(r4);
        d0 r12 = this.p;
        if (r12 == null) goto L31;
        r12.a = r16;
    L31:
        this.s = false;
    L32:
        j();
        return;
    L34:
        if ((r14 instanceof n0) == false) goto L43;
        n0 r17 = (n0) r14;
        p(r17.c);
        o(new com.larus.bmhome.instruction.core.impl.base.k.i(r17.c));
        e(new com.larus.bmhome.instruction.core.impl.base.j(getWidgetId(), r17.c));
        j();
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl((d0) xt7.d.b.c(d0.Companion.serializer(), r5));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r6);
        if (r4 != null) goto L28;
        d0 r7 = (d0) r6;
        List r8 = r7.d;
        if (r8 == null) goto L25;
        w r9 = (w) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L25;
        if (r9.j != true) goto L25;
        r0 = true;
    L25:
        this.r = r0;
        this.p = r7;
        this.q = r7.e;
        return new wa8.a0(Boolean.TRUE, "");
    L28:
        return new wa8.a0(Boolean.FALSE, r4.getMessage());
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "music template selector is empty template");
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public void onEvent(com.larus.bmhome.instruction.core.impl.base.d r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof com.larus.bmhome.instruction.core.impl.base.j) == true) goto L5;
        return;
    L5:
        p(((com.larus.bmhome.instruction.core.impl.base.j) r2).c);
        j();
    }

    public final void p(bq8.a r13) {
        boolean r0 = true;
        this.s = true;
        this.q = r13;
        bq8.e r14 = r13.b().c;
        d0 r1 = null;
        if (r14 == null) goto L5;
        Long r15 = Long.valueOf(r14.a);
    L6:
        d0 r2 = this.p;
        if (r2 == null) goto L41;
        List r3 = r2.a;
        if (r3 == null) goto L43;
        if (r15 != null) goto L13;
        return;
    L13:
        if (r15.longValue() == 0) goto L44;
        List r4 = r3;
        if ((r4 instanceof Collection) == true) goto L18;
    L20:
        Iterator r5 = r4.iterator();
    L22:
        if (r5.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((w) r5.next()).a, r15) == false) goto L22;
        r0 = false;
    L26:
        if (r0 == false) goto L28;
        return;
    L28:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r7 = r4.iterator();
    L30:
        if (r7.hasNext() == false) goto L32;
        w r8 = (w) r7.next();
        r6.add(w.a(r8, null, null, Integer.valueOf(Intrinsics.areEqual(r8.a, r15) ? 1 : 0), null, null, null, 8126463));
        goto L30
    L32:
        List r16 = CollectionsKt.toMutableList(r6);
        d0 r9 = this.p;
        if (r9 == null) goto L35;
        r1 = d0.d(r9, r16, null, 30);
    L35:
        this.p = r1;
        return;
    L18:
        if (r4.isEmpty() == false) goto L20;
    L44:
        return;
    L43:
        return;
    L41:
        return;
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "defaultStateTemplate");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl((d0) xt7.d.b.c(d0.Companion.serializer(), r9));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r12) == false) goto L10;
        r12 = null;
    L10:
        d0 r13 = (d0) r12;
        if (r13 != null) goto L13;
        return;
    L13:
        List r14 = r13.a;
        if (r14 == null) goto L35;
        Iterator r15 = r14.iterator();
    L17:
        if (r15.hasNext() == false) goto L35;
        w r0 = (w) r15.next();
        d0 r1 = this.p;
        if (r1 == null) goto L17;
        List r2 = r1.a;
        if (r2 == null) goto L17;
        Iterator r3 = r2.iterator();
        int r4 = 0;
    L24:
        if (r3.hasNext() == false) goto L17;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        w r7 = (w) r5;
        if (Intrinsics.areEqual(r7.a, r0.a) == false) goto L33;
        r7.s = 1;
        d0 r8 = this.p;
        if (r8 == null) goto L34;
        r8.b = Integer.valueOf(r4);
    L34:
        r4 = r6;
        goto L24
    L33:
        r7.s = 0;
    L35:
        bq8.a r16 = r13.e;
        if (r16 == null) goto L51;
        this.q = r16;
        return;
    L51:
        return;
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
