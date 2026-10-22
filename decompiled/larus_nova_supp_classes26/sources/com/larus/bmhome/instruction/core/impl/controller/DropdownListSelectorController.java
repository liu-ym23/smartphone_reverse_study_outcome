package com.larus.bmhome.instruction.core.impl.controller;

import com.larus.bmhome.actionbar.model.f1;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import cq8.a0;
import cq8.y;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public final class DropdownListSelectorController extends com.larus.bmhome.instruction.core.impl.base.b {
    public final Lazy p;
    public com.larus.bmhome.actionbar.model.i q;
    public List<com.larus.bmhome.actionbar.model.h> r;
    public boolean s;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 2;
    }

    public DropdownListSelectorController() {
        super("DropdownListSelectorController");
        this.p = LazyKt.lazy(new f());
        this.r = new ArrayList();
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        String r2 = getWidgetId();
        com.larus.bmhome.instruction.core.impl.base.b.C0015b r3 = this.o;
        com.larus.bmhome.actionbar.model.i r4 = this.q;
        List<com.larus.bmhome.actionbar.model.h> r5 = this.r;
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
        Integer r10 = r9.h;
    L14:
        if (r9 == null) goto L16;
        boolean r11 = Intrinsics.areEqual(r9.f, Boolean.TRUE);
    L17:
        com.larus.bmhome.instruction.core.impl.base.c r12 = this.c;
        if (r12 == null) goto L24;
        aq8.d r13 = r12.a;
        if (r13 == null) goto L24;
        dq8.h r14 = r13.a;
        if (r14 == null) goto L24;
        String r15 = r14.getBotId();
    L25:
        com.larus.bmhome.instruction.core.impl.base.c r16 = this.c;
        if (r16 == null) goto L32;
        aq8.d r17 = r16.a;
        if (r17 == null) goto L32;
        dq8.h r18 = r17.a;
        if (r18 == null) goto L32;
        String r19 = r18.getChatType();
    L33:
        com.larus.bmhome.instruction.core.impl.base.c r20 = this.c;
        if (r20 == null) goto L40;
        aq8.d r21 = r20.a;
        if (r21 == null) goto L40;
        dq8.h r22 = r21.a;
        if (r22 == null) goto L40;
        String r110 = r22.getTemplateType();
    L41:
        com.larus.bmhome.instruction.core.impl.base.c r23 = this.c;
        if (r23 == null) goto L50;
        aq8.d r24 = r23.a;
        if (r24 == null) goto L50;
        dq8.h r25 = r24.a;
        if (r25 == null) goto L50;
        Integer r26 = r25.getInstructionType();
        if (r26 == null) goto L50;
        String r111 = r26.toString();
    L51:
        com.larus.bmhome.instruction.core.impl.base.c r27 = this.c;
        if (r27 == null) goto L58;
        aq8.d r28 = r27.a;
        if (r28 == null) goto L58;
        dq8.h r29 = r28.a;
        if (r29 == null) goto L58;
        String r112 = r29.a();
    L59:
        com.larus.bmhome.instruction.core.impl.base.c r30 = this.c;
        if (r30 == null) goto L66;
        aq8.d r31 = r30.a;
        if (r31 == null) goto L66;
        dq8.h r32 = r31.a;
        if (r32 == null) goto L66;
        String r113 = r32.b();
    L67:
        com.larus.bmhome.instruction.core.impl.base.c r33 = this.c;
        if (r33 == null) goto L74;
        aq8.d r34 = r33.a;
        if (r34 == null) goto L74;
        dq8.h r35 = r34.a;
        if (r35 == null) goto L74;
        Boolean r114 = r35.isCreationActionBar();
    L75:
        com.larus.bmhome.actionbar.model.u r36 = this.b;
        if (r36 == null) goto L82;
        String r37 = r36.c;
        if (r37 == null) goto L82;
        if ((!StringsKt.isBlank(r37)) == false) goto L82;
        String r115 = r37;
    L83:
        com.larus.bmhome.instruction.core.impl.base.c r38 = this.c;
        if (r38 == null) goto L91;
        aq8.d r39 = r38.a;
        if (r39 == null) goto L91;
        dq8.h r40 = r39.a;
        if (r40 == null) goto L91;
        r6 = r40.c();
    L91:
        return new cq8.m(r2, r3, r4, r5, r10, r8, r11, new z0(r15, r19, r110, r6, r111, r112, r113, r114, r115, 2), this.s);
    L82:
        r115 = null;
    L74:
        r114 = null;
    L66:
        r113 = null;
    L58:
        r112 = null;
    L50:
        r111 = null;
    L40:
        r110 = null;
    L32:
        r19 = null;
    L24:
        r15 = null;
        goto L25
    L16:
        r11 = false;
        goto L17
    L13:
        r10 = null;
    L9:
        r8 = null;
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r1 = null;
        if (this.q != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        com.larus.bmhome.actionbar.model.i r2 = this.q;
        if (r2 == null) goto L35;
        List r3 = r2.a;
        if (r3 == null) goto L35;
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L35;
        com.larus.bmhome.actionbar.model.h r5 = (com.larus.bmhome.actionbar.model.h) r4.next();
        List r6 = r5.e;
        boolean r7 = false;
        if (r6 == null) goto L27;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L16:
        if (r9.hasNext() == false) goto L26;
        Object r10 = r9.next();
        Integer r11 = ((w) r10).s;
        if (r11 != null) goto L21;
    L23:
        boolean r12 = false;
    L24:
        if (r12 == false) goto L16;
        r8.add(r10);
        goto L16
    L21:
        if (r11.intValue() != 1) goto L23;
        r12 = true;
        goto L24
    L26:
        ArrayList r13 = r8;
    L28:
        if (r13 != null) goto L30;
    L32:
        if (r7 == false) goto L11;
        r0.add(com.larus.bmhome.actionbar.model.h.a(r5, null, null, null, r13, null, null, 4079));
        goto L11
    L30:
        if ((!r13.isEmpty()) != true) goto L32;
        r7 = true;
        goto L32
    L27:
        r13 = null;
    L35:
        if (r0.isEmpty() == false) goto L38;
        return null;
    L38:
        if (this.q == null) goto L40;
        com.larus.bmhome.actionbar.model.i r14 = new com.larus.bmhome.actionbar.model.i(r0);
    L51:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L43
        Object r16 = Result.constructor-impl(xt7.d.b.a(kuc.a.d(com.larus.bmhome.actionbar.model.i.Companion.serializer()), r14));     // Catch: Throwable -> L43
    L46:
        if (Result.isFailure-impl(r16) == true) goto L50;
        r1 = r16;
    L50:
        return (String) r1;
    L43:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L40:
        r14 = null;
        goto L51
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void l(Map<String, ?> r9) {
        Intrinsics.checkNotNullParameter(r9, "instructionDefaultParams");
        Object r10 = r9.get(String.valueOf(getType()));
        if ((r10 instanceof Map) == false) goto L5;
        Map r11 = (Map) r10;
    L6:
        com.larus.bmhome.actionbar.model.i r0 = this.q;
        if (r0 == null) goto L46;
        List r1 = r0.a;
        if (r1 == null) goto L59;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L60;
        com.larus.bmhome.actionbar.model.h r3 = (com.larus.bmhome.actionbar.model.h) r2.next();
        if (r11 == null) goto L17;
        Object r4 = r11.get(String.valueOf(r3.b));
        if (r4 == null) goto L17;
    L21:
        if ((r4 instanceof Map) == false) goto L23;
        Map r5 = (Map) r4;
    L24:
        if (r5 == null) goto L28;
        Object r6 = r5.get("default_select_id");
        if (r6 == null) goto L28;
        String r7 = r6.toString();
    L30:
        if (r7 != null) goto L32;
    L35:
        boolean r8 = true;
    L36:
        if (r8 == true) goto L12;
        List r12 = r3.e;
        if (r12 == null) goto L12;
        Iterator r13 = r12.iterator();
    L41:
        if (r13.hasNext() == false) goto L12;
        w r14 = (w) r13.next();
        if (Intrinsics.areEqual(String.valueOf(r14.a), r7) == true) goto L44;
        r14.s = 0;
        goto L41
    L44:
        r14.s = 1;
        goto L41
    L32:
        if (r7.length() == 0) goto L35;
        r8 = false;
    L28:
        r7 = null;
        goto L30
    L23:
        r5 = null;
    L17:
        if (r11 == null) goto L19;
        r4 = r11.get("match_all_id");
        goto L21
    L19:
        r4 = null;
        goto L21
    L60:
        return;
    L59:
        return;
    L46:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        if ((r4 instanceof cq8.l) == false) goto L5;
        this.s = false;
        cq8.l r5 = (cq8.l) r4;
        int r0 = r5.c;
        q(r0, r5.d, r0);
        j();
        return;
    L5:
        boolean r6 = r4 instanceof cq8.n;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r11) {
        boolean r0 = true;
        if (r11 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r12 = Result.constructor-impl((com.larus.bmhome.actionbar.model.i) xt7.d.b.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r11));     // Catch: Throwable -> L14
    L16:
        Throwable r5 = Result.exceptionOrNull-impl(r12);
        if (r5 != null) goto L115;
        com.larus.bmhome.actionbar.model.i r13 = (com.larus.bmhome.actionbar.model.i) r12;
        List<com.larus.bmhome.actionbar.model.h> r6 = null;
        if (r13 == null) goto L21;
        List r7 = r13.a;
    L22:
        List r8 = r7;
        if (r8 != null) goto L25;
    L28:
        if (r0 == true) goto L30;
        this.q = r13;
        if (r13 == null) goto L109;
        List r14 = r13.a;
        if (r14 == null) goto L109;
        Iterator r15 = r14.iterator();
    L37:
        if (r15.hasNext() == false) goto L109;
        com.larus.bmhome.actionbar.model.h r1 = (com.larus.bmhome.actionbar.model.h) r15.next();
        if (com.flow.kmp.common.thread.a.a() == true) goto L41;
        Object r9 = BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DropdownListSelectorController$parseTemplate$lambda$9$$inlined$runOnMainThreadIfNeed$1(null, r1, this));
    L61:
        Long r10 = (Long) r9;
        if (r10 != null) goto L65;
    L66:
        List r2 = r1.e;
        if (r2 == null) goto L78;
        Iterator r16 = r2.iterator();
    L70:
        if (r16.hasNext() == false) goto L74;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((w) r17).a, r10) == false) goto L70;
    L75:
        w r18 = (w) r17;
        if (r18 == null) goto L78;
        r18.s = 1;
    L79:
        if (r18 == null) goto L81;
    L94:
        w r19 = null;
    L95:
        if (r19 != null) goto L37;
        if (r18 != null) goto L37;
        if (Intrinsics.areEqual(r1.h, Boolean.TRUE) == true) goto L102;
        Integer r20 = r1.f;
        if (r20 == null) goto L102;
        int r21 = r20.intValue();
    L103:
        if (r21 < 0) goto L37;
        List r22 = r1.e;
        if (r22 == null) goto L37;
        w r23 = (w) CollectionsKt.getOrNull(r22, r21);
        if (r23 == null) goto L37;
        r23.s = 1;
    L102:
        r21 = -1;
        goto L103
    L81:
        if (Intrinsics.areEqual(r1.h, Boolean.TRUE) == true) goto L94;
        List r24 = r1.e;
        if (r24 == null) goto L94;
        Iterator r25 = r24.iterator();
    L86:
        if (r25.hasNext() == false) goto L90;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((w) r26).a, r1.g) == false) goto L86;
    L91:
        r19 = (w) r26;
        if (r19 == null) goto L94;
        r19.s = 1;
        goto L95
    L90:
        r26 = null;
        goto L91
    L74:
        r17 = null;
    L78:
        r18 = null;
        goto L79
    L65:
        if (r10.longValue() == (-1)) goto L78;
    L41:
        if (Intrinsics.areEqual(r1.i, Boolean.TRUE) == false) goto L59;
        StringBuilder r27 = new StringBuilder("dropbox_");
        com.larus.bmhome.instruction.core.impl.base.c r28 = this.c;
        if (r28 == null) goto L49;
        aq8.d r29 = r28.a;
        if (r29 == null) goto L49;
        dq8.h r30 = r29.a;
        if (r30 == null) goto L49;
        Integer r31 = r30.getInstructionType();
    L50:
        r27.append(r31);
        r27.append('_');
        com.larus.bmhome.actionbar.model.u r32 = this.b;
        if (r32 == null) goto L53;
        Integer r33 = r32.a;
    L54:
        r27.append(r33);
        r27.append('_');
        r27.append(r1.b);
        String r34 = r27.toString();
        gb6.c r35 = (gb6.c) this.p.getValue();
        if (r35 == null) goto L57;
        r9 = Long.valueOf(r35.getLong(r34, -1));
    L58:
        c0.b.i("DropdownListSelectorController", "key is " + r34 + ' ' + r9 + " is " + r9);
        goto L61
    L57:
        r9 = null;
        goto L58
    L53:
        r33 = null;
    L49:
        r31 = null;
        goto L50
    L59:
        r9 = -1L;
    L109:
        com.larus.bmhome.actionbar.model.i r110 = this.q;
        if (r110 == null) goto L112;
        r6 = new com.larus.bmhome.actionbar.model.i(r110.a).a;
    L112:
        this.r = r6;
        return new wa8.a0(Boolean.TRUE, "");
    L30:
        return new wa8.a0(Boolean.FALSE, "drop down box parse empty");
    L25:
        if (r8.isEmpty() == true) goto L28;
        r0 = false;
        goto L28
    L21:
        r7 = null;
        goto L22
    L115:
        return new wa8.a0(Boolean.FALSE, r5.getMessage());
    L14:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "drop down box is empty template");
    L5:
        if (r11.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.util.ArrayList] */
    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public void onEvent(com.larus.bmhome.instruction.core.impl.base.d r25) {
        Intrinsics.checkNotNullParameter(r25, "event");
        boolean r3 = true;
        if ((r25 instanceof com.larus.bmhome.instruction.core.impl.base.l) == false) goto L176;
        c0 r2 = c0.b;
        StringBuilder r9 = new StringBuilder("[onEvent] ParamFilterConfChangedEvent: ");
        com.larus.bmhome.instruction.core.impl.base.l r1 = (com.larus.bmhome.instruction.core.impl.base.l) r25;
        r9.append(r1.c);
        r2.i("DropdownListSelectorController", r9.toString());
        this.s = false;
        com.larus.bmhome.actionbar.model.i r4 = this.q;
        if (r4 == null) goto L7;
        List r5 = r4.a;
    L8:
        if (r5 != null) goto L10;
        r5 = CollectionsKt.emptyList();
    L10:
        List<com.larus.bmhome.actionbar.model.h> r8 = this.r;
        if (r8 != null) goto L14;
        r8 = CollectionsKt.emptyList();
    L14:
        if (r5.isEmpty() == false) goto L16;
    L84:
        com.larus.bmhome.actionbar.model.i r6 = this.q;
        if (r6 == null) goto L174;
        t1 r7 = r1.c;
        boolean r10 = r1.d;
        List r11 = r7.a;
        if (r11 != null) goto L89;
        List r12 = r6.a;
    L173:
        r6.a = r12;
        goto L174
    L89:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r11.iterator();
    L91:
        if (r14.hasNext() == false) goto L172;
        f1 r15 = (f1) r14.next();
        List<com.larus.bmhome.actionbar.model.h> r16 = this.r;
        if (r16 == null) goto L91;
        Iterator r17 = r16.iterator();
    L96:
        if (r17.hasNext() == false) goto L100;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r18).a, r15.a) == false) goto L96;
    L101:
        com.larus.bmhome.actionbar.model.h r19 = (com.larus.bmhome.actionbar.model.h) r18;
        if (r19 == null) goto L91;
        List r110 = r15.b;
        if (r110 == null) goto L125;
        ?? r111 = new ArrayList();
        Iterator r112 = r110.iterator();
    L107:
        if (r112.hasNext() == false) goto L126;
        Long r113 = (Long) r112.next();
        List r114 = r19.e;
        if (r114 == null) goto L121;
        Iterator r115 = r114.iterator();
    L112:
        if (r115.hasNext() == false) goto L117;
        Object r116 = r115.next();
        if (Intrinsics.areEqual(((w) r116).a, r113) == false) goto L112;
    L118:
        w r117 = (w) r116;
        if (r117 == null) goto L121;
        w r20 = w.a(r117, null, null, null, null, null, null, 8388607);
    L122:
        if (r20 == null) goto L107;
        r111.add(r20);
        goto L107
    L117:
        r116 = null;
    L121:
        r20 = null;
    L126:
        if (r111 != 0) goto L128;
        r111 = CollectionsKt.emptyList();
    L128:
        if (r10 == true) goto L130;
        Long r21 = r15.c;
    L161:
        Iterable r118 = (Iterable) r111;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r119 = r118.iterator();
    L163:
        if (r119.hasNext() == false) goto L171;
        w r120 = (w) r119.next();
        Long r121 = r120.a;
        if (r121 != null) goto L167;
    L169:
        Integer r122 = 0;
    L170:
        r120.s = r122;
        r22.add(r120);
        goto L163
    L167:
        if (Intrinsics.areEqual(r121, r21) == false) goto L169;
        r122 = 1;
        goto L170
    L171:
        r13.add(com.larus.bmhome.actionbar.model.h.a(r19, null, null, null, r22, null, null, 4079));
        goto L91
    L130:
        List r23 = r19.e;
        if (r23 == null) goto L148;
        Iterator r24 = r23.iterator();
    L134:
        if (r24.hasNext() == false) goto L144;
        Object r123 = r24.next();
        Integer r124 = ((w) r123).s;
        if (r124 != null) goto L139;
    L141:
        boolean r125 = false;
    L142:
        if (r125 == false) goto L134;
    L145:
        w r126 = (w) r123;
        if (r126 == null) goto L148;
        r21 = r126.a;
    L149:
        ArrayList r127 = new ArrayList();
        Iterator r128 = ((Iterable) r111).iterator();
    L151:
        if (r128.hasNext() == false) goto L155;
        Long r129 = ((w) r128.next()).a;
        if (r129 == null) goto L151;
        r127.add(r129);
        goto L151
    L155:
        Set r130 = CollectionsKt.toSet(r127);
        if (r21 != null) goto L158;
    L160:
        r21 = r15.c;
        goto L161
    L158:
        if (r130.contains(r21) == false) goto L160;
    L139:
        if (r124.intValue() != 1) goto L141;
        r125 = true;
        goto L142
    L144:
        r123 = null;
    L148:
        r21 = null;
        goto L149
    L125:
        r111 = 0;
        goto L126
    L100:
        r18 = null;
        goto L101
    L172:
        r12 = r13;
    L174:
        j();
        return;
    L16:
        if (r8.isEmpty() == true) goto L84;
        Iterator r26 = r5.iterator();
    L20:
        if (r26.hasNext() == false) goto L84;
        com.larus.bmhome.actionbar.model.h r27 = (com.larus.bmhome.actionbar.model.h) r26.next();
        List r131 = r27.e;
        if (r131 == null) goto L20;
        Iterator r132 = r131.iterator();
    L25:
        if (r132.hasNext() == false) goto L35;
        Object r133 = r132.next();
        Integer r134 = ((w) r133).s;
        if (r134 != null) goto L30;
    L32:
        boolean r135 = false;
    L33:
        if (r135 == false) goto L25;
    L36:
        w r136 = (w) r133;
        if (r136 == null) goto L20;
        Long r137 = r136.a;
        if (r137 == null) goto L20;
        long r138 = r137.longValue();
        Iterator r139 = r8.iterator();
    L42:
        if (r139.hasNext() == false) goto L67;
        Object r140 = r139.next();
        com.larus.bmhome.actionbar.model.h r141 = (com.larus.bmhome.actionbar.model.h) r140;
        String r142 = r27.a;
        if (r142 != null) goto L46;
    L49:
        boolean r143 = true;
    L50:
        if (r143 == false) goto L52;
    L53:
        String r28 = r27.a;
        if (r28 != null) goto L56;
    L59:
        boolean r29 = true;
    L60:
        if (r29 == true) goto L62;
    L64:
        boolean r30 = false;
    L65:
        if (r30 == false) goto L42;
    L68:
        com.larus.bmhome.actionbar.model.h r144 = (com.larus.bmhome.actionbar.model.h) r140;
        if (r144 == null) goto L20;
        List r31 = r144.e;
        if (r31 == null) goto L20;
        Iterator r32 = r31.iterator();
    L75:
        if (r32.hasNext() == false) goto L20;
        w r33 = (w) r32.next();
        Long r145 = r33.a;
        if (r145 != null) goto L80;
    L82:
        Integer r146 = 0;
    L83:
        r33.s = r146;
        goto L75
    L80:
        if (r145.longValue() != r138) goto L82;
        r146 = 1;
        goto L83
    L62:
        if (Intrinsics.areEqual(r141.b, r27.b) == false) goto L64;
    L63:
        r30 = true;
        goto L65
    L56:
        if (r28.length() == 0) goto L59;
        r29 = false;
        goto L60
    L52:
        if (Intrinsics.areEqual(r141.a, r27.a) == true) goto L63;
    L46:
        if (r142.length() == 0) goto L49;
        r143 = false;
        goto L50
    L67:
        r140 = null;
        goto L68
    L30:
        if (r134.intValue() != 1) goto L32;
        r135 = true;
        goto L33
    L35:
        r133 = null;
        goto L36
    L7:
        r5 = null;
        goto L8
    L176:
        if ((r25 instanceof com.larus.bmhome.instruction.core.impl.base.j) == false) goto L267;
        c0 r34 = c0.b;
        StringBuilder r35 = new StringBuilder("[onEvent] InstructionMusicTemplatePromptEvent: ");
        com.larus.bmhome.instruction.core.impl.base.j r36 = (com.larus.bmhome.instruction.core.impl.base.j) r25;
        r35.append(r36.c);
        r34.i("DropdownListSelectorController", r35.toString());
        this.s = false;
        bq8.d r37 = r36.c.b();
        bq8.e r38 = r37.b;
        bq8.e r39 = r37.a;
        bq8.e r40 = r37.c;
        if (r38 == null) goto L185;
        Integer r41 = Integer.valueOf(r38.d);
        if (r41.intValue() != 0) goto L183;
        r3 = false;
    L183:
        if (r3 == false) goto L185;
        Integer r42 = r41;
    L187:
        if (r38 == null) goto L193;
        int r43 = r38.d;
        if (r43 == 0) goto L193;
        long r44 = r38.a;
        if (r44 == 0) goto L193;
        q(r43, r44, r43);
    L193:
        if (r39 == null) goto L202;
        int r45 = r39.d;
        if (r45 == 0) goto L202;
        long r46 = r39.a;
        if (r46 == 0) goto L202;
        if (r42 == null) goto L200;
        int r47 = r42.intValue();
    L201:
        q(r45, r46, r47);
        goto L202
    L200:
        r47 = r45;
    L202:
        if (r40 == null) goto L211;
        int r48 = r40.d;
        if (r48 == 0) goto L211;
        long r49 = r40.a;
        if (r49 == 0) goto L211;
        if (r42 == null) goto L209;
        int r50 = r42.intValue();
    L210:
        q(r48, r49, r50);
        goto L211
    L209:
        r50 = r48;
    L211:
        j();
        return;
    L185:
        r42 = null;
        goto L187
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "defaultStateTemplate");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl((com.larus.bmhome.actionbar.model.i) xt7.d.b.c(com.larus.bmhome.actionbar.model.i.Companion.serializer(), r8));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r10) == false) goto L10;
        r10 = null;
    L10:
        com.larus.bmhome.actionbar.model.i r11 = (com.larus.bmhome.actionbar.model.i) r10;
        if (r11 != null) goto L14;
        return;
    L14:
        if (r9 == false) goto L16;
        this.s = true;
    L16:
        List r12 = r11.a;
        if (r12 == null) goto L89;
        Iterator r13 = r12.iterator();
    L20:
        if (r13.hasNext() == false) goto L128;
        com.larus.bmhome.actionbar.model.h r14 = (com.larus.bmhome.actionbar.model.h) r13.next();
        String r2 = r14.a;
        if (r2 != null) goto L24;
    L27:
        boolean r3 = true;
    L28:
        if (r3 == false) goto L29;
        com.larus.bmhome.actionbar.model.i r4 = this.q;
        if (r4 == null) goto L20;
        List r5 = r4.a;
        if (r5 == null) goto L20;
        Iterator r6 = r5.iterator();
    L65:
        if (r6.hasNext() == false) goto L69;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r7).b, r14.b) == false) goto L65;
    L70:
        com.larus.bmhome.actionbar.model.h r15 = (com.larus.bmhome.actionbar.model.h) r7;
        if (r15 == null) goto L20;
        List r16 = r14.e;
        if (r16 == null) goto L77;
        w r17 = (w) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L77;
        Long r18 = r17.a;
    L78:
        if (r18 == null) goto L20;
        List r19 = r15.e;
        if (r19 == null) goto L20;
        Iterator r20 = r19.iterator();
    L83:
        if (r20.hasNext() == false) goto L20;
        w r21 = (w) r20.next();
        if (Intrinsics.areEqual(r21.a, r18) == false) goto L87;
        int r22 = 1;
    L88:
        r21.s = r22;
        goto L83
    L87:
        r22 = 0;
    L77:
        r18 = null;
        goto L78
    L69:
        r7 = null;
        goto L70
    L29:
        com.larus.bmhome.actionbar.model.i r23 = this.q;
        if (r23 == null) goto L20;
        List r24 = r23.a;
        if (r24 == null) goto L20;
        Iterator r25 = r24.iterator();
    L35:
        if (r25.hasNext() == false) goto L39;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.h) r26).a, r14.a) == false) goto L35;
    L40:
        com.larus.bmhome.actionbar.model.h r27 = (com.larus.bmhome.actionbar.model.h) r26;
        if (r27 == null) goto L20;
        List r28 = r14.e;
        if (r28 == null) goto L47;
        w r29 = (w) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L47;
        Long r30 = r29.a;
    L48:
        if (r30 == null) goto L20;
        List r31 = r27.e;
        if (r31 == null) goto L20;
        Iterator r32 = r31.iterator();
    L53:
        if (r32.hasNext() == false) goto L20;
        w r33 = (w) r32.next();
        if (Intrinsics.areEqual(r33.a, r30) == false) goto L57;
        int r34 = 1;
    L58:
        r33.s = r34;
        goto L53
    L57:
        r34 = 0;
    L47:
        r30 = null;
        goto L48
    L39:
        r26 = null;
        goto L40
    L24:
        if (r2.length() == 0) goto L27;
        r3 = false;
        goto L28
    L128:
        return;
    L89:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void p(com.larus.bmhome.actionbar.model.h r10, int r11, long r12) {
        if (com.flow.kmp.common.thread.a.a() == true) goto L5;
        BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new DropdownListSelectorController$persistIfNeedSave$$inlined$runOnMainThreadIfNeed$1(null, r10, this, r11, r12));
        return;
    L5:
        if (Intrinsics.areEqual(r10.i, Boolean.TRUE) == false) goto L22;
        StringBuilder r13 = new StringBuilder("dropbox_");
        com.larus.bmhome.instruction.core.impl.base.c r0 = this.c;
        Integer r1 = null;
        if (r0 == null) goto L13;
        aq8.d r2 = r0.a;
        if (r2 == null) goto L13;
        dq8.h r3 = r2.a;
        if (r3 == null) goto L13;
        Integer r4 = r3.getInstructionType();
    L14:
        r13.append(r4);
        r13.append('_');
        com.larus.bmhome.actionbar.model.u r5 = this.b;
        if (r5 == null) goto L17;
        r1 = r5.a;
    L17:
        r13.append(r1);
        r13.append('_');
        r13.append(r11);
        String r14 = r13.toString();
        gb6.c r15 = (gb6.c) this.p.getValue();
        if (r15 == null) goto L23;
        r15.storeLong(r14, r12);
        return;
    L23:
        return;
    L13:
        r4 = null;
        goto L14
    }

    public final void q(int r12, long r13, int r15) {
        com.larus.bmhome.actionbar.model.i r0 = this.q;
        Object r1 = null;
        if (r0 == null) goto L35;
        List r2 = r0.a;
        if (r2 == null) goto L35;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        Object r6 = r3.next();
        Integer r7 = ((com.larus.bmhome.actionbar.model.h) r6).b;
        if (r7 != null) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L8;
    L19:
        com.larus.bmhome.actionbar.model.h r9 = (com.larus.bmhome.actionbar.model.h) r6;
        if (r9 == null) goto L35;
        List r4 = r9.e;
        if (r4 == null) goto L34;
        Iterator r5 = r4.iterator();
    L25:
        if (r5.hasNext() == false) goto L34;
        w r10 = (w) r5.next();
        Long r11 = r10.a;
        if (r11 != null) goto L30;
    L32:
        Integer r14 = 0;
    L33:
        r10.s = r14;
        goto L25
    L30:
        if (r11.longValue() != r13) goto L32;
        r14 = 1;
    L34:
        p(r9, r15, r13);
        goto L35
    L13:
        if (r7.intValue() != r12) goto L15;
        r8 = true;
        goto L16
    L18:
        r6 = null;
    L35:
        List<com.larus.bmhome.actionbar.model.h> r16 = this.r;
        if (r16 == null) goto L82;
        Iterator<T> r17 = r16.iterator();
    L39:
        if (r17.hasNext() == false) goto L49;
        Object r18 = r17.next();
        Integer r19 = ((com.larus.bmhome.actionbar.model.h) r18).b;
        if (r19 != null) goto L44;
    L46:
        boolean r20 = false;
    L47:
        if (r20 == false) goto L39;
        r1 = r18;
        goto L49
    L44:
        if (r19.intValue() != r12) goto L46;
        r20 = true;
    L49:
        com.larus.bmhome.actionbar.model.h r21 = (com.larus.bmhome.actionbar.model.h) r1;
        if (r21 == null) goto L83;
        List r110 = r21.e;
        if (r110 == null) goto L64;
        Iterator r111 = r110.iterator();
    L55:
        if (r111.hasNext() == false) goto L64;
        w r22 = (w) r111.next();
        Long r23 = r22.a;
        if (r23 != null) goto L60;
    L62:
        Integer r24 = 0;
    L63:
        r22.s = r24;
        goto L55
    L60:
        if (r23.longValue() != r13) goto L62;
        r24 = 1;
    L64:
        p(r21, r15, r13);
        return;
    L83:
        return;
    }
}
