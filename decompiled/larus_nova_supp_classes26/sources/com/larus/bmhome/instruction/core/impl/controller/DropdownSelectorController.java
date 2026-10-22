package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class DropdownSelectorController extends com.larus.bmhome.instruction.core.impl.base.b {
    public final Lazy p;
    public com.larus.bmhome.actionbar.model.h q;
    public int r;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 2;
    }

    public DropdownSelectorController() {
        super("DropdownSelectorController");
        this.p = LazyKt.lazy(new g());
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        com.larus.bmhome.actionbar.model.h r1 = this.q;
        String r3 = null;
        if (r1 == null) goto L22;
        List r2 = r1.e;
        if (r2 == null) goto L22;
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L18;
        Object r5 = r4.next();
        Integer r6 = ((w) r5).s;
        if (r6 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L8;
    L19:
        w r8 = (w) r5;
        if (r8 == null) goto L22;
        Long r9 = r8.a;
    L23:
        String r10 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r11 = this.o;
        com.larus.bmhome.actionbar.model.h r12 = this.q;
        int r13 = this.r;
        com.larus.bmhome.instruction.core.impl.base.c r14 = this.c;
        if (r14 == null) goto L30;
        aq8.d r15 = r14.a;
        if (r15 == null) goto L30;
        dq8.h r16 = r15.a;
        if (r16 == null) goto L30;
        String r17 = r16.getBotId();
    L31:
        com.larus.bmhome.instruction.core.impl.base.c r18 = this.c;
        if (r18 == null) goto L38;
        aq8.d r19 = r18.a;
        if (r19 == null) goto L38;
        dq8.h r20 = r19.a;
        if (r20 == null) goto L38;
        String r110 = r20.getChatType();
    L39:
        com.larus.bmhome.instruction.core.impl.base.c r21 = this.c;
        if (r21 == null) goto L46;
        aq8.d r22 = r21.a;
        if (r22 == null) goto L46;
        dq8.h r23 = r22.a;
        if (r23 == null) goto L46;
        String r111 = r23.getTemplateType();
    L47:
        com.larus.bmhome.instruction.core.impl.base.c r24 = this.c;
        if (r24 == null) goto L56;
        aq8.d r25 = r24.a;
        if (r25 == null) goto L56;
        dq8.h r26 = r25.a;
        if (r26 == null) goto L56;
        Integer r27 = r26.getInstructionType();
        if (r27 == null) goto L56;
        String r112 = r27.toString();
    L57:
        com.larus.bmhome.instruction.core.impl.base.c r28 = this.c;
        if (r28 == null) goto L64;
        aq8.d r29 = r28.a;
        if (r29 == null) goto L64;
        dq8.h r30 = r29.a;
        if (r30 == null) goto L64;
        String r113 = r30.a();
    L65:
        com.larus.bmhome.instruction.core.impl.base.c r31 = this.c;
        if (r31 == null) goto L72;
        aq8.d r32 = r31.a;
        if (r32 == null) goto L72;
        dq8.h r33 = r32.a;
        if (r33 == null) goto L72;
        String r114 = r33.b();
    L73:
        com.larus.bmhome.instruction.core.impl.base.c r34 = this.c;
        if (r34 == null) goto L80;
        aq8.d r35 = r34.a;
        if (r35 == null) goto L80;
        dq8.h r36 = r35.a;
        if (r36 == null) goto L80;
        Boolean r115 = r36.isCreationActionBar();
    L81:
        com.larus.bmhome.actionbar.model.u r37 = this.b;
        if (r37 == null) goto L88;
        String r38 = r37.c;
        if (r38 == null) goto L88;
        if ((true ^ StringsKt.isBlank(r38)) == false) goto L88;
        String r116 = r38;
    L89:
        com.larus.bmhome.instruction.core.impl.base.c r39 = this.c;
        if (r39 == null) goto L97;
        aq8.d r40 = r39.a;
        if (r40 == null) goto L97;
        dq8.h r41 = r40.a;
        if (r41 == null) goto L97;
        r3 = r41.c();
    L97:
        return new cq8.o(r10, r11, r12, r13, r9, new z0(r17, r110, r111, r3, r112, r113, r114, r115, r116, 2));
    L88:
        r116 = null;
    L80:
        r115 = null;
    L72:
        r114 = null;
    L64:
        r113 = null;
    L56:
        r112 = null;
    L46:
        r111 = null;
    L38:
        r110 = null;
    L30:
        r17 = null;
        goto L31
    L13:
        if (r6.intValue() != 1) goto L15;
        r7 = true;
        goto L16
    L18:
        r5 = null;
    L22:
        r9 = null;
        goto L23
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.h r0 = this.q;
        Object r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        List r2 = r0.e;
        if (r2 == null) goto L20;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();
        Integer r6 = ((w) r5).s;
        if (r6 == null) goto L16;
        boolean r7 = true;
        if (r6.intValue() != 1) goto L16;
    L17:
        if (r7 == false) goto L9;
        r3.add(r5);
    L16:
        r7 = false;
        goto L17
    L19:
        ArrayList r10 = r3;
    L21:
        com.larus.bmhome.actionbar.model.h r8 = this.q;
        if (r8 == null) goto L24;
        com.larus.bmhome.actionbar.model.h r9 = com.larus.bmhome.actionbar.model.h.a(r8, null, null, null, r10, null, null, 4079);
    L35:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L27
        Object r12 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.h.Companion.serializer()), r9));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r12) == true) goto L34;
        r1 = r12;
    L34:
        return (String) r1;
    L27:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L24:
        r9 = null;
        goto L35
    L20:
        r10 = null;
        goto L21
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.ArrayList] */
    public final void p() {
        com.larus.bmhome.instruction.core.impl.base.c r0 = this.c;
        Boolean r1 = null;
        if (r0 == null) goto L9;
        aq8.d r2 = r0.a;
        if (r2 == null) goto L9;
        dq8.h r3 = r2.a;
        if (r3 == null) goto L9;
        Integer r4 = r3.getInstructionType();
    L10:
        boolean r5 = false;
        if (r4 != null) goto L14;
    L15:
        if (r4 != null) goto L18;
    L20:
        if (r4 != null) goto L23;
    L24:
        if (r4 != null) goto L27;
    L44:
        boolean r6 = false;
    L45:
        if (r6 == false) goto L57;
        com.larus.bmhome.actionbar.model.h r7 = this.q;
        if (r7 == null) goto L54;
        List r8 = r7.e;
        if (r8 == null) goto L54;
        List r9 = r8;
        List r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L52:
        if (r11.hasNext() == false) goto L55;
        r10.add(w.a((w) r11.next(), null, null, null, null, null, null, 8388607));
    L55:
        if (r10 != 0) goto L59;
        r10 = CollectionsKt.emptyList();
    L59:
        if (this.r != 4) goto L85;
        com.larus.bmhome.actionbar.model.h r12 = this.q;
        if (r12 == null) goto L84;
        List r13 = r12.e;
        if (r13 == null) goto L84;
        List r14 = r13;
        if ((r14 instanceof Collection) == true) goto L67;
    L69:
        Iterator r15 = r14.iterator();
    L71:
        if (r15.hasNext() == false) goto L81;
        Integer r16 = ((w) r15.next()).s;
        if (r16 != null) goto L76;
    L78:
        boolean r17 = false;
    L79:
        if (r17 == false) goto L71;
        boolean r18 = true;
    L82:
        if (r18 != true) goto L84;
        r5 = true;
        goto L84
    L76:
        if (r16.intValue() != 1) goto L78;
        r17 = true;
    L81:
        r18 = false;
        goto L82
    L67:
        if (r14.isEmpty() == false) goto L69;
    L84:
        r1 = Boolean.valueOf(r5);
    L85:
        if (r10 == 0) goto L87;
        o(new com.larus.bmhome.instruction.core.impl.base.k.o(r10));
    L87:
        if (r1 == null) goto L96;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(r1.booleanValue()));
        return;
    L96:
        return;
    L54:
        r10 = 0;
        goto L55
    L57:
        r10 = 0;
        goto L59
    L27:
        if (r4.intValue() != 24) goto L44;
    L28:
        com.larus.bmhome.actionbar.model.h r19 = this.q;
        if (r19 == null) goto L44;
        Integer r20 = r19.b;
        if (r20 == null) goto L44;
        if (r20.intValue() != 1) goto L44;
    L43:
        r6 = true;
        goto L45
    L23:
        if (r4.intValue() == 18) goto L28;
    L18:
        if (r4.intValue() != 4) goto L20;
    L36:
        com.larus.bmhome.actionbar.model.h r21 = this.q;
        if (r21 == null) goto L44;
        Integer r22 = r21.b;
        if (r22 == null) goto L44;
        if (r22.intValue() != 2) goto L44;
    L14:
        if (r4.intValue() == 16) goto L36;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void h(Integer r1) {
        if (r1 == null) goto L4;
        int r2 = r1.intValue();
    L5:
        this.r = r2;
        return;
    L4:
        r2 = 0;
        goto L5
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r9) {
        Intrinsics.checkNotNullParameter(r9, "instructionDefaultParams");
        com.larus.bmhome.actionbar.model.h r0 = this.q;
        if (r0 == null) goto L7;
        Integer r1 = r0.b;
        if (r1 == null) goto L7;
        String r2 = r1.toString();
    L8:
        Object r10 = r9.get(String.valueOf(getType()));
        if ((r10 instanceof Map) == false) goto L11;
        Map r11 = (Map) r10;
    L12:
        if (r11 == null) goto L15;
        Object r3 = r11.get(r2);
        if (r3 == null) goto L15;
    L19:
        if ((r3 instanceof Map) == false) goto L21;
        Map r4 = (Map) r3;
    L22:
        if (r4 == null) goto L73;
        Object r12 = r4.get("default_select_id");
        if (r12 == null) goto L74;
        com.larus.bmhome.actionbar.model.h r5 = this.q;
        if (r5 == null) goto L41;
        List r6 = r5.e;
        if (r6 == null) goto L41;
        Iterator r7 = r6.iterator();
    L31:
        if (r7.hasNext() == false) goto L39;
        Object r8 = r7.next();
        Long r13 = ((w) r8).a;
        if (r13 == null) goto L35;
        String r14 = r13.toString();
    L37:
        if (Intrinsics.areEqual(r14, r12.toString()) == false) goto L31;
    L40:
        w r15 = (w) r8;
    L42:
        if (r15 == null) goto L75;
        com.larus.bmhome.actionbar.model.h r16 = this.q;
        if (r16 == null) goto L64;
        List r17 = r16.e;
        if (r17 == null) goto L64;
        Iterator r18 = r17.iterator();
        int r19 = 0;
    L49:
        if (r18.hasNext() == false) goto L64;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        w r22 = (w) r20;
        Long r23 = r22.a;
        if (r23 == null) goto L56;
        String r24 = r23.toString();
    L58:
        if (Intrinsics.areEqual(r24, r12.toString()) == false) goto L62;
        r22.s = 1;
        com.larus.bmhome.actionbar.model.h r25 = this.q;
        if (r25 == null) goto L63;
        r25.f = Integer.valueOf(r19);
    L63:
        r19 = r21;
        goto L49
    L62:
        r22.s = 0;
        goto L63
    L56:
        r24 = null;
    L64:
        p();
        return;
    L75:
        return;
    L35:
        r14 = null;
        goto L37
    L39:
        r8 = null;
    L41:
        r15 = null;
        goto L42
    L74:
        return;
    L73:
        return;
    L21:
        r4 = null;
    L15:
        if (r11 == null) goto L17;
        r3 = r11.get("match_all_id");
        goto L19
    L17:
        r3 = null;
        goto L19
    L11:
        r11 = null;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        c0.b.i("DropdownSelectorController", "[handleAction] action:" + r8.a + ", widgetId:" + r8.a());
        if ((r8 instanceof cq8.n) == false) goto L44;
        long r0 = ((cq8.n) r8).c;
        com.larus.bmhome.actionbar.model.h r9 = this.q;
        boolean r2 = false;
        if (r9 == null) goto L19;
        List r10 = r9.e;
        if (r10 == null) goto L19;
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L19;
        w r3 = (w) r11.next();
        Long r4 = r3.a;
        if (r4 != null) goto L15;
    L17:
        int r5 = 0;
    L18:
        r3.s = r5;
        goto L10
    L15:
        if (r4.longValue() != r0) goto L17;
        r5 = 1;
    L19:
        Integer r6 = null;
        if (com.flow.kmp.common.thread.a.a() == false) goto L38;
        com.larus.bmhome.actionbar.model.h r12 = this.q;
        if (r12 == null) goto L24;
        r2 = Intrinsics.areEqual(r12.i, Boolean.TRUE);
    L24:
        if (r2 == true) goto L26;
    L39:
        p();
        j();
        return;
    L26:
        if (this.r != 4) goto L31;
        StringBuilder r13 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r7 = this.q;
        if (r7 == null) goto L30;
        r6 = r7.b;
    L30:
        r13.append(r6);
        String r14 = r13.toString();
    L35:
        gb6.c r15 = (gb6.c) this.p.getValue();
        if (r15 == null) goto L39;
        r15.storeLong(r14, r0);
        goto L39
    L31:
        StringBuilder r16 = new StringBuilder("dropbox_");
        r16.append(this.r);
        r16.append('_');
        com.larus.bmhome.actionbar.model.h r17 = this.q;
        if (r17 == null) goto L34;
        r6 = r17.b;
    L34:
        r16.append(r6);
        r14 = r16.toString();
        goto L35
    L38:
        BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DropdownSelectorController$handleAction$$inlined$runOnMainThreadIfNeed$1(null, this, r0));
        goto L39
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r10) {
        boolean r2 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r11 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r10));     // Catch: Throwable -> L14
    L16:
        Throwable r5 = Result.exceptionOrNull-impl(r11);
        if (r5 != null) goto L143;
        com.larus.bmhome.actionbar.model.h r12 = (com.larus.bmhome.actionbar.model.h) r11;
        List r6 = r12.e;
        if (r6 != null) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L27;
        this.q = r12;
        List r13 = r12.e;
        w r8 = null;
        if (r13 == null) goto L44;
        Iterator r14 = r13.iterator();
    L32:
        if (r14.hasNext() == false) goto L42;
        Object r9 = r14.next();
        Integer r15 = ((w) r9).s;
        if (r15 != null) goto L37;
    L39:
        boolean r16 = false;
    L40:
        if (r16 == false) goto L32;
    L43:
        w r17 = (w) r9;
    L46:
        if (r17 == null) goto L48;
        Long r18 = -1L;
    L75:
        if (r18 != null) goto L78;
    L79:
        com.larus.bmhome.actionbar.model.h r0 = this.q;
        if (r0 == null) goto L93;
        List r1 = r0.e;
        if (r1 == null) goto L93;
        Iterator r19 = r1.iterator();
    L85:
        if (r19.hasNext() == false) goto L89;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((w) r20).a, r18) == false) goto L85;
    L90:
        w r21 = (w) r20;
        if (r21 == null) goto L93;
        r21.s = 1;
    L94:
        if (r21 != null) goto L119;
        if (r17 != null) goto L119;
        com.larus.bmhome.actionbar.model.h r110 = this.q;
        if (r110 == null) goto L99;
        boolean r111 = Intrinsics.areEqual(r110.h, Boolean.TRUE);
    L100:
        if (r111 == true) goto L119;
        com.larus.bmhome.actionbar.model.h r112 = this.q;
        if (r112 == null) goto L119;
        List r113 = r112.e;
        if (r113 == null) goto L119;
        Iterator r114 = r113.iterator();
    L107:
        if (r114.hasNext() == false) goto L115;
        Object r22 = r114.next();
        Long r23 = ((w) r22).a;
        com.larus.bmhome.actionbar.model.h r24 = this.q;
        if (r24 == null) goto L111;
        Long r25 = r24.g;
    L113:
        if (Intrinsics.areEqual(r23, r25) == false) goto L107;
    L116:
        w r26 = (w) r22;
        if (r26 == null) goto L119;
        r26.s = 1;
        r8 = r26;
        goto L119
    L111:
        r25 = null;
        goto L113
    L115:
        r22 = null;
        goto L116
    L99:
        r111 = false;
    L119:
        if (r8 != null) goto L140;
        if (r21 != null) goto L140;
        if (r17 != null) goto L140;
        com.larus.bmhome.actionbar.model.h r115 = this.q;
        if (r115 == null) goto L125;
        r2 = Intrinsics.areEqual(r115.h, Boolean.TRUE);
    L125:
        if (r2 == true) goto L131;
        com.larus.bmhome.actionbar.model.h r116 = this.q;
        if (r116 == null) goto L131;
        Integer r117 = r116.f;
        if (r117 == null) goto L131;
        int r118 = r117.intValue();
    L132:
        if (r118 < 0) goto L140;
        com.larus.bmhome.actionbar.model.h r27 = this.q;
        if (r27 == null) goto L140;
        List r28 = r27.e;
        if (r28 == null) goto L140;
        w r119 = (w) CollectionsKt.getOrNull(r28, r118);
        if (r119 == null) goto L140;
        r119.s = 1;
    L131:
        r118 = -1;
    L140:
        p();
        return new wa8.a0(Boolean.TRUE, "");
    L89:
        r20 = null;
    L93:
        r21 = null;
        goto L94
    L78:
        if (r18.longValue() == (-1)) goto L93;
    L48:
        com.larus.bmhome.actionbar.model.h r120 = this.q;
        if (r120 == null) goto L51;
        boolean r121 = Intrinsics.areEqual(r120.i, Boolean.TRUE);
    L52:
        if (r121 == true) goto L54;
        r18 = -1L;
        goto L75
    L54:
        if (com.flow.kmp.common.thread.a.a() == true) goto L56;
        Object r122 = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DropdownSelectorController$parseTemplate$$inlined$runOnMainThreadIfNeed$1(null, this));
    L73:
        r18 = (Long) r122;
        goto L75
    L56:
        if (this.r != 4) goto L64;
        gb6.c r123 = (gb6.c) this.p.getValue();
        if (r123 == null) goto L71;
        StringBuilder r29 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r30 = this.q;
        if (r30 == null) goto L62;
        Integer r31 = r30.b;
    L63:
        r29.append(r31);
        r122 = Long.valueOf(r123.getLong(r29.toString(), -1));
        goto L73
    L62:
        r31 = null;
    L71:
        r122 = null;
        goto L73
    L64:
        gb6.c r124 = (gb6.c) this.p.getValue();
        if (r124 == null) goto L71;
        StringBuilder r32 = new StringBuilder("dropbox_");
        r32.append(this.r);
        r32.append('_');
        com.larus.bmhome.actionbar.model.h r33 = this.q;
        if (r33 == null) goto L69;
        Integer r34 = r33.b;
    L70:
        r32.append(r34);
        r122 = Long.valueOf(r124.getLong(r32.toString(), -1));
        goto L73
    L69:
        r34 = null;
        goto L70
    L51:
        r121 = false;
        goto L52
    L37:
        if (r15.intValue() != 1) goto L39;
        r16 = true;
        goto L40
    L42:
        r9 = null;
        goto L43
    L44:
        r17 = null;
        goto L46
    L27:
        return new wa8.a0(Boolean.FALSE, "drop down box parse empty");
    L21:
        if (r6.isEmpty() == true) goto L24;
        r7 = false;
        goto L25
    L143:
        return new wa8.a0(Boolean.FALSE, r5.getMessage());
    L14:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "drop down box is empty template");
    L5:
        if (r10.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public void onEvent(com.larus.bmhome.instruction.core.impl.base.d r25) {
        Intrinsics.checkNotNullParameter(r25, "event");
        if ((r25 instanceof com.larus.bmhome.instruction.core.impl.base.j) == true) goto L5;
        return;
    L5:
        com.larus.bmhome.instruction.core.impl.base.c r2 = this.c;
        if (r2 == null) goto L17;
        aq8.d r3 = r2.a;
        if (r3 == null) goto L17;
        dq8.h r4 = r3.a;
        if (r4 == null) goto L17;
        Integer r5 = r4.getInstructionType();
        if (r5 == null) goto L17;
        if (r5.intValue() != 1) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
        return;
    L20:
        bq8.d r1 = ((com.larus.bmhome.instruction.core.impl.base.j) r25).c.b();
        com.larus.bmhome.actionbar.model.h r7 = this.q;
        if (r7 == null) goto L96;
        Integer r8 = r7.b;
        if (r8 == null) goto L97;
        int r9 = r8.intValue();
        com.larus.bmhome.actionbar.model.h r10 = null;
        if (r9 != 1) goto L27;
        bq8.e r11 = r1.c;
        if (r11 == null) goto L35;
        Long r12 = Long.valueOf(r11.a);
    L36:
        if (r12 != null) goto L38;
        return;
    L38:
        if (r12.longValue() == 0) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == true) goto L44;
        r12 = null;
    L44:
        if (r12 == null) goto L99;
        long r14 = r12.longValue();
        com.larus.bmhome.actionbar.model.h r15 = this.q;
        if (r15 == null) goto L100;
        List r16 = r15.e;
        if (r16 == null) goto L101;
        List r17 = r16;
        if ((r17 instanceof Collection) == true) goto L53;
    L55:
        Iterator r18 = r17.iterator();
    L57:
        if (r18.hasNext() == false) goto L67;
        Long r19 = ((w) r18.next()).a;
        if (r19 != null) goto L62;
    L64:
        boolean r20 = false;
    L65:
        if (r20 == false) goto L57;
        boolean r21 = false;
    L69:
        if (r21 == false) goto L72;
        c0.b.w("DropdownSelectorController", "[onEvent] music template option not found, dropdownId=" + r9 + ", selectedOptionId=" + r14);
        return;
    L72:
        c0.b.i("DropdownSelectorController", "[onEvent] music template fill, dropdownId=" + r9 + ", selectedOptionId=" + r14);
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r22 = r17.iterator();
    L74:
        if (r22.hasNext() == false) goto L83;
        w r23 = (w) r22.next();
        Long r24 = r23.a;
        if (r24 != null) goto L79;
    L81:
        int r26 = 0;
    L82:
        r110.add(w.a(r23, null, null, Integer.valueOf(r26), null, null, null, 8126463));
        goto L74
    L79:
        if (r24.longValue() != r14) goto L81;
        r26 = 1;
        goto L82
    L83:
        com.larus.bmhome.actionbar.model.h r111 = this.q;
        if (r111 == null) goto L86;
        r10 = com.larus.bmhome.actionbar.model.h.a(r111, null, null, null, r110, null, null, 4079);
    L86:
        this.q = r10;
        p();
        j();
        return;
    L62:
        if (r19.longValue() != r14) goto L64;
        r20 = true;
    L67:
        r21 = true;
        goto L69
    L53:
        if (r17.isEmpty() == false) goto L55;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L40:
        r13 = false;
    L35:
        r12 = null;
        goto L36
    L27:
        if (r9 != 2) goto L35;
        bq8.e r27 = r1.b;
        if (r27 == null) goto L35;
        r12 = Long.valueOf(r27.a);
        goto L36
    L97:
        return;
    L96:
        return;
    L17:
        r6 = false;
        goto L18
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "defaultStateTemplate");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl((com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r4));     // Catch: Throwable -> L5
    L7:
        Object r0 = null;
        if (Result.isFailure-impl(r7) == false) goto L10;
        r7 = null;
    L10:
        com.larus.bmhome.actionbar.model.h r8 = (com.larus.bmhome.actionbar.model.h) r7;
        if (r8 != null) goto L13;
        return;
    L13:
        List r9 = r8.e;
        if (r9 == null) goto L18;
        w r10 = (w) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L18;
        Long r11 = r10.a;
    L19:
        if (r11 == null) goto L54;
        com.larus.bmhome.actionbar.model.h r12 = this.q;
        if (r12 == null) goto L31;
        List r13 = r12.e;
        if (r13 == null) goto L31;
        Iterator r14 = r13.iterator();
    L26:
        if (r14.hasNext() == false) goto L30;
        Object r1 = r14.next();
        if (Intrinsics.areEqual(((w) r1).a, r11) == false) goto L26;
        r0 = r1;
    L30:
        r0 = (w) r0;
    L31:
        if (r0 == null) goto L55;
        com.larus.bmhome.actionbar.model.h r15 = this.q;
        if (r15 == null) goto L44;
        List r16 = r15.e;
        if (r16 == null) goto L44;
        Iterator r17 = r16.iterator();
    L38:
        if (r17.hasNext() == false) goto L44;
        w r2 = (w) r17.next();
        if (Intrinsics.areEqual(r2.a, r11) == false) goto L42;
        int r3 = 1;
    L43:
        r2.s = r3;
        goto L38
    L42:
        r3 = 0;
    L44:
        p();
        return;
    L55:
        return;
    L54:
        return;
    L18:
        r11 = null;
    L5:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
