package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.kmp.chat.TemplateInfo;
import cq8.a0;
import cq8.v;
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
public final class j extends com.larus.bmhome.instruction.core.impl.base.b {
    public com.larus.bmhome.actionbar.model.n p;
    public TemplateInfo.TemplateInfo q;
    public int r;
    public boolean s;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 11;
    }

    public j() {
        super("ImageTemplateSelectorWithMoreController");
        this.r = -1;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        com.larus.bmhome.actionbar.model.n r0 = this.p;
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
        if (this.s == true) goto L65;
        this.s = true;
        com.larus.bmhome.actionbar.model.n r1 = this.p;
        if (r1 == null) goto L29;
        List r2 = r1.a;
        if (r2 == null) goto L29;
        List r3 = r2;
        if ((r3 instanceof Collection) == true) goto L12;
    L14:
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L26;
        Integer r5 = ((w) r4.next()).s;
        if (r5 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L16;
        boolean r7 = true;
    L27:
        if (r7 != true) goto L29;
        boolean r8 = true;
    L30:
        int r9 = -1;
        if (r8 == true) goto L46;
        com.larus.bmhome.actionbar.model.n r10 = this.p;
        if (r10 == null) goto L37;
        Integer r11 = r10.b;
        if (r11 == null) goto L37;
        int r12 = r11.intValue();
    L38:
        if (r12 < 0) goto L46;
        com.larus.bmhome.actionbar.model.n r13 = this.p;
        if (r13 == null) goto L46;
        List r14 = r13.a;
        if (r14 == null) goto L46;
        w r15 = (w) CollectionsKt.getOrNull(r14, r12);
        if (r15 == null) goto L46;
        r15.s = 1;
    L37:
        r12 = -1;
    L46:
        com.larus.bmhome.actionbar.model.n r16 = this.p;
        if (r16 == null) goto L63;
        List r17 = r16.a;
        if (r17 == null) goto L63;
        Iterator r18 = r17.iterator();
        int r19 = 0;
    L52:
        if (r18.hasNext() == false) goto L63;
        Integer r20 = ((w) r18.next()).s;
        if (r20 != null) goto L57;
    L59:
        boolean r21 = false;
    L60:
        if (r21 == true) goto L61;
        r19 = r19 + 1;
        goto L52
    L61:
        r9 = r19;
        goto L63
    L57:
        if (r20.intValue() != 1) goto L59;
        r21 = true;
    L63:
        if (r9 < 0) goto L65;
        this.r = r9;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        goto L65
    L21:
        if (r5.intValue() != 1) goto L23;
        r6 = true;
    L26:
        r7 = false;
        goto L27
    L12:
        if (r3.isEmpty() == false) goto L14;
    L29:
        r8 = false;
    L65:
        String r22 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r23 = this.o;
        com.larus.bmhome.actionbar.model.n r24 = this.p;
        com.larus.bmhome.actionbar.model.u r25 = this.b;
        String r26 = null;
        if (r25 == null) goto L72;
        String r27 = r25.c;
        if (r27 == null) goto L72;
        if ((!StringsKt.isBlank(r27)) == false) goto L72;
        String r28 = r27;
    L73:
        com.larus.bmhome.actionbar.model.u r29 = this.b;
        if (r29 == null) goto L76;
        boolean r30 = Intrinsics.areEqual(r29.f, Boolean.TRUE);
    L77:
        com.larus.bmhome.actionbar.model.u r31 = this.b;
        if (r31 == null) goto L85;
        Integer r32 = r31.a;
        if (r32 == null) goto L85;
        if (r32.intValue() != 1) goto L85;
        boolean r110 = true;
    L86:
        com.larus.bmhome.actionbar.model.n r33 = this.p;
        if (r33 == null) goto L95;
        List r34 = r33.d;
        if (r34 == null) goto L95;
        w r35 = (w) CollectionsKt.firstOrNull(r34);
        if (r35 == null) goto L95;
        if (r35.j != true) goto L95;
        boolean r111 = true;
    L96:
        TemplateInfo.TemplateInfo r112 = this.q;
        com.larus.bmhome.instruction.core.impl.base.c r36 = this.c;
        if (r36 == null) goto L103;
        aq8.d r37 = r36.a;
        if (r37 == null) goto L103;
        dq8.h r38 = r37.a;
        if (r38 == null) goto L103;
        String r113 = r38.getBotId();
    L104:
        com.larus.bmhome.instruction.core.impl.base.c r39 = this.c;
        if (r39 == null) goto L111;
        aq8.d r40 = r39.a;
        if (r40 == null) goto L111;
        dq8.h r41 = r40.a;
        if (r41 == null) goto L111;
        String r114 = r41.getChatType();
    L112:
        com.larus.bmhome.instruction.core.impl.base.c r42 = this.c;
        if (r42 == null) goto L119;
        aq8.d r43 = r42.a;
        if (r43 == null) goto L119;
        dq8.h r44 = r43.a;
        if (r44 == null) goto L119;
        String r115 = r44.getTemplateType();
    L120:
        com.larus.bmhome.instruction.core.impl.base.c r45 = this.c;
        if (r45 == null) goto L129;
        aq8.d r46 = r45.a;
        if (r46 == null) goto L129;
        dq8.h r47 = r46.a;
        if (r47 == null) goto L129;
        Integer r48 = r47.getInstructionType();
        if (r48 == null) goto L129;
        String r116 = r48.toString();
    L130:
        com.larus.bmhome.instruction.core.impl.base.c r49 = this.c;
        if (r49 == null) goto L137;
        aq8.d r50 = r49.a;
        if (r50 == null) goto L137;
        dq8.h r51 = r50.a;
        if (r51 == null) goto L137;
        String r117 = r51.a();
    L138:
        com.larus.bmhome.instruction.core.impl.base.c r52 = this.c;
        if (r52 == null) goto L145;
        aq8.d r53 = r52.a;
        if (r53 == null) goto L145;
        dq8.h r54 = r53.a;
        if (r54 == null) goto L145;
        String r210 = r54.b();
    L146:
        com.larus.bmhome.instruction.core.impl.base.c r55 = this.c;
        if (r55 == null) goto L153;
        aq8.d r56 = r55.a;
        if (r56 == null) goto L153;
        dq8.h r57 = r56.a;
        if (r57 == null) goto L153;
        Boolean r211 = r57.isCreationActionBar();
    L154:
        com.larus.bmhome.actionbar.model.u r58 = this.b;
        if (r58 == null) goto L161;
        String r59 = r58.c;
        if (r59 == null) goto L161;
        if ((!StringsKt.isBlank(r59)) == false) goto L161;
        String r212 = r59;
    L162:
        com.larus.bmhome.instruction.core.impl.base.c r60 = this.c;
        if (r60 == null) goto L170;
        aq8.d r61 = r60.a;
        if (r61 == null) goto L170;
        dq8.h r62 = r61.a;
        if (r62 == null) goto L170;
        r26 = r62.c();
    L170:
        return new cq8.w(r22, r23, r24, r28, r30, r110, r111, r112, new z0(r113, r114, r115, r26, r116, r117, r210, r211, r212, 2), this.r);
    L161:
        r212 = null;
    L153:
        r211 = null;
    L145:
        r210 = null;
    L137:
        r117 = null;
    L129:
        r116 = null;
    L119:
        r115 = null;
    L111:
        r114 = null;
    L103:
        r113 = null;
    L95:
        r111 = false;
    L85:
        r110 = false;
        goto L86
    L76:
        r30 = false;
    L72:
        r28 = null;
        goto L73
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        com.larus.bmhome.actionbar.model.n r0 = this.p;
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
        com.larus.bmhome.actionbar.model.n r9 = this.p;
        if (r9 == null) goto L29;
        com.larus.bmhome.actionbar.model.n r10 = com.larus.bmhome.actionbar.model.n.d(r9, r4, this.q);
    L40:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L32
        Object r12 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.n.Companion.serializer()), r10));     // Catch: Throwable -> L32
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

    public final void q() {
        com.larus.bmhome.actionbar.model.u r0 = this.b;
        boolean r1 = false;
        if (r0 == null) goto L10;
        Integer r2 = r0.a;
        if (r2 == null) goto L10;
        if (r2.intValue() != 1) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        return;
    L13:
        com.larus.bmhome.actionbar.model.n r4 = this.p;
        if (r4 == null) goto L37;
        List r5 = r4.a;
        if (r5 == null) goto L37;
        List r6 = r5;
        if ((r6 instanceof Collection) == true) goto L20;
    L22:
        Iterator r7 = r6.iterator();
    L24:
        if (r7.hasNext() == false) goto L34;
        Integer r8 = ((w) r7.next()).s;
        if (r8 != null) goto L29;
    L31:
        boolean r9 = false;
    L32:
        if (r9 == false) goto L24;
        boolean r10 = true;
    L35:
        if (r10 != true) goto L37;
        r1 = true;
        goto L37
    L29:
        if (r8.intValue() != 1) goto L31;
        r9 = true;
    L34:
        r10 = false;
        goto L35
    L20:
        if (r6.isEmpty() == false) goto L22;
    L37:
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(r1));
        return;
    L10:
        r3 = false;
        goto L11
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r8) {
        Intrinsics.checkNotNullParameter(r8, "instructionDefaultParams");
        Object r9 = r8.get(String.valueOf(getType()));
        if ((r9 instanceof Map) == false) goto L5;
        Map r10 = (Map) r9;
    L6:
        if (r10 == null) goto L9;
        Object r0 = r10.get(null);
        if (r0 == null) goto L9;
    L13:
        if ((r0 instanceof Map) == false) goto L15;
        Map r1 = (Map) r0;
    L16:
        if (r1 == null) goto L34;
        Object r11 = r1.get("default_select_id");
        if (r11 == null) goto L41;
        c0.b.d("ImageTemplateSelectorWithMoreController", "onReStoreComponentStateByDefaultParams: select:" + r11);
        com.larus.bmhome.actionbar.model.n r2 = this.p;
        if (r2 == null) goto L42;
        List r3 = r2.a;
        if (r3 == null) goto L43;
        Iterator r4 = r3.iterator();
    L25:
        if (r4.hasNext() == false) goto L44;
        w r5 = (w) r4.next();
        Long r6 = r5.a;
        if (r6 == null) goto L29;
        String r7 = r6.toString();
    L31:
        if (Intrinsics.areEqual(r7, r11) == true) goto L32;
        r5.s = 0;
        goto L25
    L32:
        r5.s = 1;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        c0.b.d("ImageTemplateSelectorWithMoreController", "hit restore by default params option id:" + ((String) r11) + ", option name:" + r5.b);
        goto L25
    L29:
        r7 = null;
        goto L31
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L34:
        return;
    L15:
        r1 = null;
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
    public final void m(y r18) {
        Intrinsics.checkNotNullParameter(r18, "action");
        if (Intrinsics.areEqual(r18.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r18 instanceof cq8.q) == false) goto L38;
        cq8.q r1 = (cq8.q) r18;
        com.larus.bmhome.actionbar.model.n r2 = this.p;
        if (r2 == null) goto L36;
        List r7 = r2.a;
        if (r7 == null) goto L36;
        boolean r3 = Intrinsics.areEqual(r2.c, Boolean.TRUE);
        List r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r5 = r8.iterator();
    L14:
        if (r5.hasNext() == false) goto L32;
        w r10 = (w) r5.next();
        Long r11 = r10.a;
        long r12 = r1.c;
        if (r11 != null) goto L19;
    L24:
        Long r13 = r10.a;
        long r14 = r1.c;
        if (r13 != null) goto L28;
    L30:
        int r15 = 0;
    L31:
        r9.add(w.a(r10, null, null, Integer.valueOf(r15), null, null, null, 8126463));
        goto L14
    L28:
        if (r13.longValue() != r14) goto L30;
        r15 = 1;
        goto L31
    L19:
        if (r11.longValue() != r12) goto L24;
        if (r1.d == false) goto L24;
        if (r3 == true) goto L24;
    L32:
        List r4 = CollectionsKt.toMutableList(r9);
        com.larus.bmhome.actionbar.model.n r6 = this.p;
        if (r6 == null) goto L35;
        r6.a = r4;
    L35:
        this.r = -1;
        q();
    L36:
        j();
        return;
    L38:
        if ((r18 instanceof cq8.s) == false) goto L40;
        p(((cq8.s) r18).c);
        j();
        return;
    L40:
        Object r16 = null;
        if ((r18 instanceof v) == false) goto L63;
        TemplateInfo.TemplateInfo r17 = ((v) r18).c;
        this.q = null;
        com.larus.bmhome.actionbar.model.n r19 = this.p;
        if (r19 == null) goto L58;
        List r20 = r19.a;
        if (r20 == null) goto L58;
        Iterator r21 = r20.iterator();
    L48:
        if (r21.hasNext() == false) goto L57;
        Object r22 = r21.next();
        Long r23 = ((w) r22).a;
        if (r23 != null) goto L52;
    L54:
        boolean r24 = false;
    L55:
        if (r24 == false) goto L48;
        r16 = r22;
        goto L57
    L52:
        if (r23.longValue() != r17.a) goto L54;
        r24 = true;
    L57:
        r16 = (w) r16;
    L58:
        if (r16 == null) goto L60;
        p(Long.valueOf(r17.a));
    L61:
        j();
        return;
    L60:
        this.q = r17;
        goto L61
    L63:
        if ((r18 instanceof cq8.u) == false) goto L76;
        com.larus.bmhome.actionbar.model.n r25 = this.p;
        if (r25 == null) goto L74;
        List r26 = r25.a;
        if (r26 == null) goto L74;
        List r27 = r26;
        ArrayList r28 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r29 = r27.iterator();
    L71:
        if (r29.hasNext() == false) goto L73;
        r28.add(w.a((w) r29.next(), null, null, 0, null, null, null, 8126463));
        goto L71
    L73:
        r25.a = CollectionsKt.toMutableList(r28);
        this.q = null;
        this.r = -1;
        q();
    L74:
        j();
        return;
    L76:
        if ((r18 instanceof cq8.t) == false) goto L95;
        cq8.t r30 = (cq8.t) r18;
        com.larus.bmhome.actionbar.model.n r31 = this.p;
        if (r31 == null) goto L80;
        r31.a = CollectionsKt.toMutableList(r30.c);
    L80:
        this.r = -1;
        q();
        j();
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl((com.larus.bmhome.actionbar.model.n) xt7.d.b.c(com.larus.bmhome.actionbar.model.n.Companion.serializer(), r3));     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r4);
        if (r2 != null) goto L24;
        com.larus.bmhome.actionbar.model.n r5 = (com.larus.bmhome.actionbar.model.n) r4;
        this.p = r5;
        if (r5 == null) goto L20;
        TemplateInfo.TemplateInfo r6 = r5.e;
    L21:
        this.q = r6;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        r6 = null;
        goto L21
    L24:
        return new wa8.a0(Boolean.FALSE, r2.getMessage());
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "image list selector is empty template");
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void p(Long r15) {
        com.larus.bmhome.actionbar.model.n r0 = this.p;
        if (r0 == null) goto L29;
        List r1 = r0.a;
        if (r1 == null) goto L30;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
        int r5 = 0;
        int r6 = 0;
    L9:
        if (r4.hasNext() == false) goto L21;
        Object r7 = r4.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        w r9 = (w) r7;
        Long r10 = r9.a;
        if (r10 == null) goto L16;
        Long r11 = Long.valueOf(r10.longValue());
    L17:
        boolean r12 = Intrinsics.areEqual(r11, r15);
        if (r12 == false) goto L20;
        r6 = r5;
    L20:
        r3.add(w.a(r9, null, null, Integer.valueOf(r12 ? 1 : 0), null, null, null, 8126463));
        r5 = r8;
        goto L9
    L16:
        r11 = null;
        goto L17
    L21:
        List r16 = CollectionsKt.toMutableList(r3);
        com.larus.bmhome.actionbar.model.n r13 = this.p;
        if (r13 == null) goto L24;
        r13.a = r16;
    L24:
        this.r = r6;
        q();
        return;
    L30:
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r22, "defaultStateTemplate");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl((com.larus.bmhome.actionbar.model.n) xt7.d.b.c(com.larus.bmhome.actionbar.model.n.Companion.serializer(), r22));     // Catch: Throwable -> L5
    L7:
        String r3 = null;
        if (Result.isFailure-impl(r0) == false) goto L10;
        r0 = null;
    L10:
        com.larus.bmhome.actionbar.model.n r1 = (com.larus.bmhome.actionbar.model.n) r0;
        if (r1 != null) goto L13;
        return;
    L13:
        List r4 = r1.a;
        if (r4 == null) goto L18;
        w r5 = (w) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L18;
        Long r6 = r5.a;
    L19:
        o(new com.larus.bmhome.instruction.core.impl.base.k.e(r6));
        List r7 = r1.a;
        if (r7 == null) goto L35;
        Iterator r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L35;
        w r9 = (w) r8.next();
        com.larus.bmhome.actionbar.model.n r10 = this.p;
        if (r10 == null) goto L23;
        List r11 = r10.a;
        if (r11 == null) goto L23;
        Iterator r12 = r11.iterator();
    L30:
        if (r12.hasNext() == false) goto L23;
        w r13 = (w) r12.next();
        if (Intrinsics.areEqual(r13.a, r9.a) == true) goto L33;
        r13.s = 0;
        goto L30
    L33:
        r13.s = 1;
        o(new com.larus.bmhome.instruction.core.impl.base.k.g(true));
        c0.b.d("ImageTemplateSelectorWithMoreController", "hit restore option id:" + r9.a + ", option name:" + r13.b);
    L35:
        TemplateInfo.TemplateInfo r14 = r1.e;
        if (r14 == null) goto L73;
        long r15 = r14.a;
        TemplateInfo.TemplateImage r16 = r14.e;
        if (r16 == null) goto L40;
        String r17 = r16.a;
    L41:
        long r18 = 0;
        if (r16 == null) goto L44;
        long r19 = r16.b;
    L45:
        if (r16 == null) goto L47;
        long r110 = r16.c;
    L48:
        TemplateInfo.TemplateImage r20 = new TemplateInfo.TemplateImage(r17, r19, r110);
        TemplateInfo.TemplateImage r21 = r14.d;
        if (r21 == null) goto L51;
        r3 = r21.a;
    L51:
        String r111 = r3;
        if (r21 == null) goto L54;
        long r112 = r21.b;
    L55:
        if (r21 == null) goto L57;
        r18 = r21.c;
    L57:
        this.q = new TemplateInfo.TemplateInfo(r15, null, new TemplateInfo.TemplateImage(r111, r112, r18), r20, null, 0, 0, 0, null, 998);
        return;
    L54:
        r112 = 0;
        goto L55
    L47:
        r110 = 0;
        goto L48
    L44:
        r19 = 0;
        goto L45
    L40:
        r17 = null;
        goto L41
    L73:
        return;
    L18:
        r6 = null;
    L5:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
