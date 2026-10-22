package com.larus.bmhome.instruction.core.impl.controller;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.actionbar.model.b0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.FlowRuntime;
import cq8.a0;
import cq8.l0;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import ouc.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o extends com.larus.bmhome.instruction.core.impl.base.b {
    public b0 p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public o() {
        super("MultiSelectorController");
        ((ArrayList) this.f).clear();
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
    public final a0 d() {
        List<com.larus.bmhome.instruction.core.impl.base.e> r0 = this.f;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = ((ArrayList) r0).iterator();
    L3:
        Unit r4 = null;
        if (r2.hasNext() == false) goto L9;
        com.larus.bmhome.instruction.core.impl.base.e r3 = (com.larus.bmhome.instruction.core.impl.base.e) r2.next();
        if (r3 == null) goto L8;
        r3.j();
        r4 = Unit.INSTANCE;
    L8:
        r1.add(r4);
        goto L3
    L9:
        String r6 = getWidgetId();
        com.larus.bmhome.actionbar.model.u r5 = this.b;
        if (r5 == null) goto L14;
        Integer r7 = r5.h;
        if (r7 == null) goto L14;
        int r8 = r7.intValue();
    L15:
        com.larus.bmhome.actionbar.model.u r9 = this.b;
        if (r9 == null) goto L22;
        String r10 = r9.c;
        if (r10 == null) goto L22;
        if (com.flow.kmp.common.util.f.a(r10) == false) goto L22;
        String r11 = r10;
    L23:
        com.larus.bmhome.actionbar.model.u r12 = this.b;
        if (r12 == null) goto L26;
        boolean r13 = Intrinsics.areEqual(r12.f, Boolean.TRUE);
    L27:
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r14 = this.o;
        b0 r15 = this.p;
        com.larus.bmhome.actionbar.model.u r16 = this.b;
        if (r16 == null) goto L32;
        Integer r17 = r16.b;
        if (r17 == null) goto L32;
        int r18 = r17.intValue();
    L33:
        List<com.larus.bmhome.instruction.core.impl.base.e> r19 = this.f;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r20 = ((ArrayList) r19).iterator();
    L35:
        if (r20.hasNext() == false) goto L45;
        com.larus.bmhome.instruction.core.impl.base.e r21 = (com.larus.bmhome.instruction.core.impl.base.e) r20.next();
        if ((r21 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L39;
        com.larus.bmhome.instruction.core.impl.base.b r22 = (com.larus.bmhome.instruction.core.impl.base.b) r21;
    L40:
        if (r22 == null) goto L42;
        y0 r23 = new y0(r22.getWidgetId(), this.g, r22.j);
    L43:
        r110.add(r23);
        goto L35
    L42:
        r23 = null;
        goto L43
    L39:
        r22 = null;
        goto L40
    L45:
        return new l0(r6, r14, r11, Integer.valueOf(r8), r13, r15, r18, r110);
    L32:
        r18 = 0;
        goto L33
    L26:
        r13 = false;
    L22:
        r11 = null;
    L14:
        r8 = 0;
        goto L15
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r1 = null;
        if (this.p != null) goto L5;
        return null;
    L5:
        Iterator r0 = ((ArrayList) this.f).iterator();
        int r2 = 0;
    L7:
        if (r0.hasNext() == false) goto L31;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        com.larus.bmhome.instruction.core.impl.base.e r5 = (com.larus.bmhome.instruction.core.impl.base.e) r3;
        if (r5 == null) goto L20;
        b0 r6 = this.p;
        if (r6 == null) goto L20;
        List r7 = r6.a;
        if (r7 == null) goto L20;
        c0 r8 = (c0) ListProtector.get(r7, r2);
        if (r8 == null) goto L20;
        r8.c = r5.g();
    L20:
        r2 = r4;
        goto L7
    L31:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        Object r10 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(b0.Companion.serializer()), this.p));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r10) == true) goto L30;
        r1 = r10;
    L30:
        return (String) r1;
    L23:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.larus.bmhome.instruction.core.impl.base.e r1 = (com.larus.bmhome.instruction.core.impl.base.e) r0.next();
        if (r1 == null) goto L4;
        r1.m(r3);
        goto L4
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r17) {
        if (r17 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r0 = Result.constructor-impl((b0) xt7.d.b.c(b0.Companion.serializer(), r17));     // Catch: Throwable -> L14
    L16:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 != null) goto L88;
        b0 r4 = (b0) r0;
        if (r4 == null) goto L21;
        List r5 = r4.a;
    L22:
        List r6 = r5;
        if (r6 != null) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == true) goto L31;
        this.p = r4;
        if (r4 == null) goto L86;
        List r8 = r4.a;
        if (r8 == null) goto L86;
        Iterator r9 = r8.iterator();
        int r10 = 0;
    L38:
        if (r9.hasNext() == false) goto L86;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        c0 r13 = (c0) r11;
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        Lazy r16 = xp8.h.a;
        int r18 = r13.b;
        Iterator r19 = ((Set) xp8.h.b.getValue()).iterator();
    L44:
        if (r19.hasNext() == false) goto L51;
        Object r20 = r19.next();
        if (r18 != ((com.larus.bmhome.instruction.core.impl.base.g) r20).getMultiItemType()) goto L48;
        boolean r21 = true;
    L49:
        if (r21 == false) goto L44;
    L52:
        com.larus.bmhome.instruction.core.impl.base.g r22 = (com.larus.bmhome.instruction.core.impl.base.g) r20;
        if (r22 == null) goto L64;
        com.larus.bmhome.instruction.core.impl.base.e r110 = r22.d();
        if ((r110 instanceof com.larus.bmhome.instruction.core.impl.base.b) == false) goto L57;
        com.larus.bmhome.instruction.core.impl.base.b r23 = (com.larus.bmhome.instruction.core.impl.base.b) r110;
        CoroutineScope r24 = this.g;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r23.g = r24;
        r23.h = this.h;
    L57:
        r110.h(r13.a);
        String r25 = r13.c;
        if (r25 == null) goto L62;
        com.larus.bmhome.instruction.core.impl.base.c r26 = this.c;
        if (r26 == null) goto L62;
        wa8.a0 r27 = r110.k(this.b, r26, this.e, this, r25);
    L63:
        r15.element = r27;
        r14.element = r110;
    L62:
        r27 = null;
    L64:
        wa8.a0 r28 = (wa8.a0) r15.element;
        if (r28 == null) goto L67;
        boolean r29 = Intrinsics.areEqual(r28.a, Boolean.TRUE);
    L68:
        if (r29 == false) goto L72;
        com.larus.bmhome.instruction.core.impl.base.e r30 = (com.larus.bmhome.instruction.core.impl.base.e) r14.element;
        if (r30 == null) goto L73;
        ((ArrayList) this.f).add(r30);
    L73:
        e0 r31 = new e0();
        wa8.a0 r32 = (wa8.a0) r15.element;
        if (r32 == null) goto L76;
        boolean r33 = Intrinsics.areEqual(r32.a, Boolean.TRUE);
    L77:
        if (r33 == false) goto L79;
        String r34 = "1";
    L80:
        ouc.j.c(r31, "is_success", r34);
        wa8.a0 r35 = (wa8.a0) r15.element;
        if (r35 == null) goto L83;
        String r36 = r35.b;
    L84:
        ouc.j.c(r31, "fail_reason", r36);
        ouc.j.c(r31, "instruction_type", String.valueOf(r13.b));
        FlowRuntime.b().d().a("flow_instruction_decode_template", r31.a());
        r10 = r12;
        goto L38
    L83:
        r36 = null;
        goto L84
    L79:
        r34 = TriggerSendLoading.NO_LOADING;
        goto L80
    L76:
        r33 = false;
        goto L77
    L72:
        ((ArrayList) this.f).add(null);
        goto L73
    L67:
        r29 = false;
        goto L68
    L48:
        r21 = false;
        goto L49
    L51:
        r20 = null;
    L86:
        return new wa8.a0(Boolean.TRUE, "");
    L31:
        return new wa8.a0(Boolean.FALSE, "multi option is empty");
    L25:
        if (r6.isEmpty() == true) goto L28;
        r7 = false;
        goto L29
    L21:
        r5 = null;
        goto L22
    L88:
        return new wa8.a0(Boolean.FALSE, r3.getMessage());
    L14:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "feature selector is empty template");
    L5:
        if (r17.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "defaultStateTemplate");
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl((b0) xt7.d.b.c(b0.Companion.serializer(), r7));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r10) == false) goto L10;
        r10 = null;
    L10:
        b0 r11 = (b0) r10;
        if (r11 != null) goto L13;
        return;
    L13:
        List r12 = r11.a;
        if (r12 == null) goto L42;
        Iterator r13 = r12.iterator();
    L17:
        if (r13.hasNext() == false) goto L60;
        c0 r14 = (c0) r13.next();
        b0 r0 = this.p;
        if (r0 == null) goto L17;
        List r1 = r0.a;
        if (r1 == null) goto L17;
        Iterator r2 = r1.iterator();
        int r3 = 0;
    L24:
        if (r2.hasNext() == false) goto L34;
        c0 r4 = (c0) r2.next();
        if (r4.b == r14.b) goto L28;
    L30:
        boolean r5 = false;
    L31:
        if (r5 == true) goto L35;
        r3 = r3 + 1;
    L35:
        String r15 = r14.c;
        if (r15 == null) goto L17;
        List<com.larus.bmhome.instruction.core.impl.base.e> r6 = this.f;
        if (r6 == null) goto L17;
        com.larus.bmhome.instruction.core.impl.base.e r16 = (com.larus.bmhome.instruction.core.impl.base.e) CollectionsKt.getOrNull(r6, r3);
        if (r16 == null) goto L17;
        r16.i(r15, false);
        goto L17
    L28:
        if (Intrinsics.areEqual(r4.a, r14.a) == false) goto L30;
        r5 = true;
        goto L31
    L34:
        r3 = -1;
        goto L35
    L60:
        return;
    L42:
        return;
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
