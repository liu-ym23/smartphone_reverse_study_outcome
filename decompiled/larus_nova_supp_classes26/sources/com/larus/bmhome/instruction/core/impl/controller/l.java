package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.v;
import com.larus.bmhome.actionbar.model.z0;
import cq8.a0;
import cq8.f0;
import cq8.g0;
import cq8.h0;
import cq8.y;
import cq8.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l extends com.larus.bmhome.instruction.core.impl.base.b {
    public List<z0> p;
    public int q;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        return null;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return -100;
    }

    public l() {
        super("MenuTabContainerController");
        this.p = CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        List r0 = CollectionsKt.filterNotNull(this.f);
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((com.larus.bmhome.instruction.core.impl.base.e) r1.next()).a() == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final List<com.larus.bmhome.actionbar.model.u> c() {
        List<com.larus.bmhome.instruction.core.impl.base.e> r0 = this.f;
        ArrayList r2 = new ArrayList();
        Iterator r1 = ((ArrayList) r0).iterator();
    L3:
        boolean r4 = true;
        com.larus.bmhome.actionbar.model.u r5 = null;
        if (r1.hasNext() == false) goto L25;
        com.larus.bmhome.instruction.core.impl.base.e r3 = (com.larus.bmhome.instruction.core.impl.base.e) r1.next();
        if ((r3 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L8;
        com.larus.bmhome.instruction.core.impl.base.b r6 = (com.larus.bmhome.instruction.core.impl.base.b) r3;
    L9:
        if (r6 == null) goto L23;
        String r11 = r6.g();
        if (r11 != null) goto L14;
    L17:
        if (r4 == true) goto L23;
        com.larus.bmhome.actionbar.model.u r7 = r6.b;
        if (r7 == null) goto L22;
        r5 = r7.a;
    L22:
        r5 = new com.larus.bmhome.actionbar.model.u(r5, Integer.valueOf(r6.getType()), null, r11, null, null, null, 244);
        goto L23
    L14:
        if (r11.length() == 0) goto L17;
        r4 = false;
    L23:
        if (r5 == null) goto L3;
        r2.add(r5);
        goto L3
    L8:
        r6 = null;
        goto L9
    L25:
        com.larus.bmhome.actionbar.model.u r8 = CollectionsKt.toMutableList(r2);
        com.larus.bmhome.instruction.core.impl.base.c r9 = this.c;
        if (r9 == null) goto L32;
        aq8.d r10 = r9.a;
        if (r10 == null) goto L32;
        dq8.f r12 = r10.c;
        if (r12 == null) goto L32;
        List r13 = r12.a();
    L33:
        List r14 = r13;
        if (r14 != null) goto L36;
    L39:
        boolean r15 = true;
    L40:
        if (r15 == true) goto L90;
        z0 r16 = (z0) CollectionsKt.getOrNull(this.p, this.q);
        if (r16 == null) goto L90;
        com.larus.bmhome.actionbar.model.r r17 = r16.q;
        if (r17 == null) goto L90;
        List r18 = r17.b;
        if (r18 == null) goto L90;
        Iterator r19 = r18.iterator();
    L51:
        if (r19.hasNext() == false) goto L61;
        Object r20 = r19.next();
        Integer r21 = ((com.larus.bmhome.actionbar.model.u) r20).b;
        if (r21 != null) goto L56;
    L58:
        boolean r22 = false;
    L59:
        if (r22 == false) goto L51;
    L62:
        com.larus.bmhome.actionbar.model.u r23 = (com.larus.bmhome.actionbar.model.u) r20;
        if (r23 == null) goto L90;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L70
        String r25 = r23.d;     // Catch: Throwable -> L70
        if (r25 == null) goto L67;
        v r26 = (v) xt7.d.b.c(v.Companion.serializer(), r25);     // Catch: Throwable -> L70
    L68:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L70
    L73:
        if (Result.isFailure-impl(r27) == false) goto L75;
        r27 = null;
    L75:
        v r28 = (v) r27;
        if (r28 != null) goto L78;
        r28 = new v(null, null, 15);
    L78:
        r28.c = r13;
        Object r29 = Result.constructor-impl(xt7.d.b.a(v.Companion.serializer(), r28));     // Catch: Throwable -> L81
    L84:
        if (Result.isFailure-impl(r29) == false) goto L86;
        r29 = null;
    L86:
        String r110 = (String) r29;
        if (r110 == null) goto L90;
        com.larus.bmhome.actionbar.model.u r30 = new com.larus.bmhome.actionbar.model.u(r23.a, 15, null, r110, null, null, null, 244);
    L91:
        if (r30 == null) goto L93;
        r8.add(r30);
    L93:
        com.larus.bmhome.actionbar.model.u r31 = (Collection) r8;
        if (r31.isEmpty() == true) goto L98;
        r5 = r31;
    L98:
        return (List) r5;
    L81:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L84
    L67:
        r26 = null;
    L70:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L56:
        if (r21.intValue() != 15) goto L58;
        r22 = true;
        goto L59
    L61:
        r20 = null;
    L90:
        r30 = null;
        goto L91
    L36:
        if (r14.isEmpty() == true) goto L39;
        r15 = false;
    L32:
        r13 = null;
        goto L33
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        Iterator r1 = ((ArrayList) this.f).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        com.larus.bmhome.instruction.core.impl.base.e r2 = (com.larus.bmhome.instruction.core.impl.base.e) r1.next();
        if (r2 == null) goto L4;
        r2.j();
        goto L4
    L8:
        String r4 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r5 = this.o;
        com.larus.bmhome.actionbar.model.u r3 = this.b;
        if (r3 == null) goto L15;
        String r6 = r3.c;
        if (r6 == null) goto L15;
        if ((!StringsKt.isBlank(r6)) == false) goto L15;
    L16:
        String r7 = r6;
        com.larus.bmhome.actionbar.model.u r8 = this.b;
        if (r8 == null) goto L19;
        boolean r9 = Intrinsics.areEqual(r8.f, Boolean.TRUE);
    L20:
        List<z0> r10 = this.p;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
        int r13 = 0;
    L22:
        if (r12.hasNext() == false) goto L37;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        z0 r16 = (z0) r14;
        com.larus.bmhome.actionbar.model.r r17 = r16.q;
        if (r17 == null) goto L31;
        Integer r18 = r17.a;
        if (r18 == null) goto L31;
        int r19 = r18.intValue();
    L32:
        long r110 = r19;
        String r111 = r16.e;
        if (r13 != this.q) goto L35;
        boolean r20 = true;
    L36:
        r11.add(new g0(r110, r111, r20));
        r13 = r15;
        goto L22
    L35:
        r20 = false;
    L31:
        r19 = 0;
        goto L32
    L37:
        List r21 = CollectionsKt.filterNotNull(this.f);
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r23 = r21.iterator();
    L39:
        if (r23.hasNext() == false) goto L42;
        com.larus.bmhome.instruction.core.impl.base.e r24 = (com.larus.bmhome.instruction.core.impl.base.e) r23.next();
        String r112 = r24.getWidgetId();
        CoroutineScope r113 = this.g;
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.larus.bmhome.instruction.core.impl.base.AbsInstructionController");
        r22.add(new y0(r112, r113, ((com.larus.bmhome.instruction.core.impl.base.b) r24).j));
        goto L39
    L42:
        return new f0(r4, r5, r11, r7, r9, r22);
    L19:
        r9 = false;
    L15:
        r6 = null;
        goto L16
    }

    public final void p() {
        ((ArrayList) this.f).clear();
        z0 r0 = (z0) CollectionsKt.getOrNull(this.p, this.q);
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.instruction.core.impl.base.c r7 = this.c;
        if (r7 != null) goto L8;
        return;
    L8:
        com.larus.bmhome.actionbar.model.r r1 = r0.q;
        if (r1 == null) goto L11;
        Integer r9 = r1.a;
    L12:
        if (r1 == null) goto L43;
        List r2 = r1.b;
        if (r2 == null) goto L55;
        Iterator r3 = r2.iterator();
    L17:
        if (r3.hasNext() == false) goto L56;
        com.larus.bmhome.actionbar.model.u r4 = (com.larus.bmhome.actionbar.model.u) r3.next();
        Lazy r5 = xp8.h.a;
        Integer r6 = r4.b;
        if (r6 == null) goto L21;
        int r8 = r6.intValue();
    L22:
        Iterator r10 = ((Set) xp8.h.a.getValue()).iterator();
    L24:
        if (r10.hasNext() == false) goto L31;
        Object r11 = r10.next();
        if (r8 != ((com.larus.bmhome.instruction.core.impl.base.f) r11).p()) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == false) goto L24;
    L32:
        com.larus.bmhome.instruction.core.impl.base.f r13 = (com.larus.bmhome.instruction.core.impl.base.f) r11;
        if (r13 == null) goto L34;
        com.larus.bmhome.instruction.core.impl.base.e r14 = r13.d();
        if ((r14 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L38;
        com.larus.bmhome.instruction.core.impl.base.b r15 = (com.larus.bmhome.instruction.core.impl.base.b) r14;
        CoroutineScope r16 = this.g;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.g = r16;
        r15.h = r9;
    L38:
        wa8.a0 r17 = r14.k(r4, r7, this.e, this, r4.d);
        List<com.larus.bmhome.instruction.core.impl.base.e> r18 = this.f;
        if (Intrinsics.areEqual(r17.a, Boolean.TRUE) == true) goto L42;
        r14 = null;
    L42:
        ((ArrayList) r18).add(r14);
        goto L17
    L34:
        ((ArrayList) this.f).add(null);
        goto L17
    L28:
        r12 = false;
        goto L29
    L31:
        r11 = null;
        goto L32
    L21:
        r8 = 0;
        goto L22
    L56:
        return;
    L55:
        return;
    L43:
        return;
    L11:
        r9 = null;
        goto L12
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        if ((r8 instanceof h0) == false) goto L29;
        h0 r9 = (h0) r8;
        if (Intrinsics.areEqual(r9.b, getWidgetId()) == true) goto L7;
        return;
    L7:
        long r0 = r9.c;
        Iterator<z0> r10 = this.p.iterator();
        int r3 = 0;
    L9:
        if (r10.hasNext() == false) goto L23;
        com.larus.bmhome.actionbar.model.r r4 = r10.next().q;
        if (r4 == null) goto L15;
        Integer r5 = r4.a;
        if (r5 == null) goto L15;
        int r6 = r5.intValue();
    L17:
        if (r6 != r0) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == true) goto L24;
        r3 = r3 + 1;
    L24:
        if (r3 >= 0) goto L26;
        return;
    L26:
        if (r3 == this.q) goto L44;
        this.q = r3;
        p();
        o(new com.larus.bmhome.instruction.core.impl.base.k.m(this.q));
        j();
        return;
    L44:
        return;
    L19:
        r7 = false;
    L15:
        r6 = 0;
        goto L17
    L23:
        r3 = -1;
        goto L24
    L29:
        Iterator r1 = ((ArrayList) this.f).iterator();
    L31:
        if (r1.hasNext() == false) goto L45;
        com.larus.bmhome.instruction.core.impl.base.e r2 = (com.larus.bmhome.instruction.core.impl.base.e) r1.next();
        if (r2 == null) goto L31;
        r2.m(r8);
        goto L31
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r14) {
        com.larus.bmhome.instruction.core.impl.base.c r15 = this.c;
        if (r15 == null) goto L5;
        com.larus.bmhome.instruction.core.impl.base.i r16 = r15.c;
    L6:
        if (r16 == null) goto L12;
        com.larus.bmhome.actionbar.model.r r1 = r16.d;
        if (r1 == null) goto L12;
        com.larus.bmhome.actionbar.model.y r2 = r1.i;
        if (r2 == null) goto L12;
        ArrayList r3 = r2.a;
    L14:
        if (r3 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == true) goto L22;
        com.larus.bmhome.actionbar.model.r r5 = r16.b;
        com.larus.bmhome.actionbar.model.r r17 = r16.c;
        this.p = r3;
        if (r5 != null) goto L26;
        com.larus.bmhome.actionbar.model.r r6 = r17;
    L27:
        if (r6 == null) goto L56;
        com.larus.bmhome.actionbar.model.y r7 = r6.i;
        if (r7 == null) goto L56;
        ArrayList r8 = r7.a;
        if (r8 == null) goto L56;
        z0 r9 = (z0) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L56;
        com.larus.bmhome.actionbar.model.r r10 = r9.q;
        if (r10 == null) goto L56;
        Integer r11 = r10.a;
        if (r11 == null) goto L56;
        int r12 = r11.intValue();
        Iterator<z0> r13 = this.p.iterator();
        int r18 = 0;
    L40:
        if (r13.hasNext() == false) goto L53;
        com.larus.bmhome.actionbar.model.r r19 = r13.next().q;
        if (r19 == null) goto L49;
        Integer r20 = r19.a;
        if (r20 == null) goto L49;
        if (r20.intValue() != r12) goto L49;
        boolean r21 = true;
    L50:
        if (r21 == true) goto L54;
        r18 = r18 + 1;
    L54:
        if (r18 < 0) goto L56;
    L57:
        this.q = r18;
        p();
        if (r5 != null) goto L60;
        r5 = r17;
    L60:
        z0 r110 = (z0) CollectionsKt.getOrNull(this.p, this.q);
        if (r110 == null) goto L131;
        if (r5 == null) goto L131;
        com.larus.bmhome.actionbar.model.y r22 = r5.i;
        if (r22 == null) goto L131;
        ArrayList r23 = r22.a;
        if (r23 == null) goto L131;
        Iterator r24 = r23.iterator();
    L70:
        if (r24.hasNext() == false) goto L82;
        Object r25 = r24.next();
        com.larus.bmhome.actionbar.model.r r26 = ((z0) r25).q;
        if (r26 == null) goto L74;
        Integer r27 = r26.a;
    L75:
        com.larus.bmhome.actionbar.model.r r28 = r110.q;
        if (r28 == null) goto L78;
        Integer r29 = r28.a;
    L80:
        if (Intrinsics.areEqual(r27, r29) == false) goto L70;
    L83:
        z0 r30 = (z0) r25;
        if (r30 == null) goto L131;
        com.larus.bmhome.actionbar.model.r r31 = r30.q;
        if (r31 == null) goto L131;
        List r32 = r31.b;
        if (r32 == null) goto L131;
        Iterator r33 = ((ArrayList) this.f).iterator();
        int r34 = 0;
    L93:
        if (r33.hasNext() == false) goto L131;
        Object r35 = r33.next();
        int r36 = r34 + 1;
        if (r34 >= 0) goto L97;
        CollectionsKt.throwIndexOverflow();
    L97:
        com.larus.bmhome.instruction.core.impl.base.e r37 = (com.larus.bmhome.instruction.core.impl.base.e) r35;
        if (r37 == null) goto L129;
        com.larus.bmhome.actionbar.model.r r38 = r110.q;
        if (r38 == null) goto L129;
        List r39 = r38.b;
        if (r39 == null) goto L129;
        com.larus.bmhome.actionbar.model.u r40 = (com.larus.bmhome.actionbar.model.u) CollectionsKt.getOrNull(r39, r34);
        if (r40 == null) goto L129;
        Iterator r41 = r32.iterator();
    L109:
        if (r41.hasNext() == false) goto L118;
        Object r42 = r41.next();
        com.larus.bmhome.actionbar.model.u r111 = (com.larus.bmhome.actionbar.model.u) r42;
        if (Intrinsics.areEqual(r111.b, r40.b) == true) goto L113;
    L115:
        boolean r112 = false;
    L116:
        if (r112 == false) goto L109;
    L119:
        com.larus.bmhome.actionbar.model.u r43 = (com.larus.bmhome.actionbar.model.u) r42;
        if (r43 == null) goto L129;
        String r44 = r43.d;
        if (r44 == null) goto L129;
        if (r44.length() <= 0) goto L126;
        boolean r45 = true;
    L127:
        if (r45 == false) goto L129;
        r37.i(r44, false);
        goto L129
    L126:
        r45 = false;
        goto L127
    L113:
        if (Intrinsics.areEqual(r111.a, r40.a) == false) goto L115;
        r112 = true;
        goto L116
    L118:
        r42 = null;
    L129:
        r34 = r36;
        goto L93
    L78:
        r29 = null;
        goto L80
    L74:
        r27 = null;
        goto L75
    L82:
        r25 = null;
    L131:
        return new wa8.a0(Boolean.TRUE, "");
    L49:
        r21 = false;
        goto L50
    L53:
        r18 = -1;
    L56:
        r18 = 0;
        goto L57
    L26:
        r6 = r5;
        goto L27
    L22:
        return new wa8.a0(Boolean.FALSE, "menuConf actionBarItemList is empty");
    L16:
        if (r3.isEmpty() == true) goto L19;
        r4 = false;
    L12:
        r3 = null;
        goto L14
    L5:
        r16 = null;
        goto L6
    }
}
