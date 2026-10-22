package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.t;
import com.bytedance.android.livesdk.dynamicstrategy.impl.AbsDynamicStrategyContext;
import com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.k0;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements g, j, c {
    public final LinkedList<a> a;
    public l b;
    public h c;
    public boolean d;
    public int e;
    public boolean f;
    public final Set<g.a> g;
    public final String h;
    public final s i;
    public final String j;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final List<String> g() {
        if (this.d == true) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L27;
        a r2 = (a) r1.next();
        d r3 = r2.e;
        if (r3 == null) goto L8;
        t r4 = r3.f;
        if (r4 == null) goto L8;
        List<String> r5 = r4.b();
        if (r5 == null) goto L8;
        if (r2.f <= (-1)) goto L20;
        boolean r6 = true;
        if ((!r5.isEmpty()) == false) goto L20;
    L21:
        if (r6 == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L8;
        r0.addAll(r5);
    L20:
        r6 = false;
        goto L21
    L27:
        return CollectionsKt.toList(r0);
    L5:
        return new ArrayList();
    }

    public final List<String> h() {
        if (this.d == true) goto L5;
        List<t> r0 = this.i.b();
        if (r0 == null) goto L13;
        t r1 = (t) CollectionsKt.getOrNull(r0, 0);
        if (r1 == null) goto L13;
        List<String> r2 = r1.b();
        if (r2 == null) goto L13;
        return r2;
    L13:
        return new ArrayList();
    L5:
        return new ArrayList();
    }

    public final List<String> i() {
        if (this.d == true) goto L9;
        List<String> r0 = this.i.a();
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new ArrayList();
    L9:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final boolean b() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final String e() {
        return this.h;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.j
    public final void a(final long r10) {
        final String r6 = "Nfa Time Out";
        final long r4 = 0;
        if (r10 <= 0) goto L5;
        CollectionsKt.removeAll(this.a, new EventCepNfa$finishFollow$2(this, r10, r4, r6));
    L5:
        h r11 = this.c;
        if (r11 == null) goto L9;
        r11.b(this.h);
        r11.d(this.h);
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final void c(g.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.g.remove(r2);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.g
    public final void f(AbsDynamicStrategyContext.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.g.add(r2);
    }

    public final void l(com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        int r0 = b.a;
        String r1 = this.j;
        String r2 = this.h;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r3 = r7.boolNode;
        boolean r4 = false;
        if (r3 == null) goto L7;
        Boolean r5 = r3.value;
        if (r5 == null) goto L7;
        boolean r6 = r5.booleanValue();
    L8:
        Intrinsics.checkNotNullParameter(r1, "roomId");
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        b.b("StrategyCepNfa_result", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r1), TuplesKt.to("nfa_name", r2), TuplesKt.to("nfa_result", Boolean.valueOf(r6))}));
        if (r7.nodeType != 1) goto L15;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r8 = r7.boolNode;
        if (r8 == null) goto L15;
        Boolean r9 = r8.value;
        if (r9 == null) goto L15;
        r4 = r9.booleanValue();
    L15:
        this.f = r4;
        Iterator<T> r10 = this.g.iterator();
    L17:
        if (r10.hasNext() == false) goto L19;
        ((g.a) r10.next()).a(this.h, this.f);
        goto L17
    L19:
        return;
    L7:
        r6 = false;
        goto L8
    }

    public final void j(String r38, Map r39) {
        String r13 = "eventKey";
        Intrinsics.checkNotNullParameter(r38, "eventKey");
        String r14 = "eventParams";
        Intrinsics.checkNotNullParameter(r39, "eventParams");
        if (this.d == false) goto L5;
        return;
    L5:
        LinkedHashSet r15 = new LinkedHashSet();
        int r0 = this.a.size();
        ku1.g r1 = ku1.g.a;
        if (r0 >= ((ku1.a) r1.getValue()).c()) goto L45;
        List<t> r2 = this.i.b();
        if (r2 == null) goto L37;
        t r3 = (t) CollectionsKt.getOrNull(r2, 0);
        if (r3 == null) goto L37;
        if (r3.d() != 1) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        t r5 = r3;
    L18:
        if (r5 == null) goto L37;
        if (this.e >= ((ku1.a) r1.getValue()).b()) goto L45;
        long r27 = System.nanoTime();
        String r6 = this.h + "_#Flow" + this.e;
        if (this.i.d() <= 0) goto L28;
        long r7 = (((long) (this.i.d() * BubbleId.PadCast)) * 1000000) + r27;
        Long r8 = Long.valueOf(r7);
        m r9 = new m(r6, r7, this);
        l r10 = this.b;
        if (r10 == null) goto L27;
        r10.b(r9);
    L27:
        Unit r11 = Unit.INSTANCE;
        Pair r12 = new Pair(r8, r9);
    L29:
        a r16 = new a(r6, r27, ((Number) r12.component1()).longValue(), (m) r12.component2());
        Object r17 = "room_id";
        r16.e = new d(this.j, this.h, r5, System.nanoTime(), this.b, r16, this);
        this.a.add(r16);
        this.e++;
        int r18 = b.a;
        String r19 = this.j;
        String r110 = "roomId";
        Intrinsics.checkNotNullParameter(r19, r110);
        Intrinsics.checkNotNullParameter(r6, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r16, "wrapper");
        Pair[] r20 = new Pair[3];
        r20[0] = TuplesKt.to(r17, r19);
        r20[1] = TuplesKt.to("nfa_name", r6);
        d r21 = r16.e;
        if (r21 == null) goto L35;
        t r22 = r21.f;
        if (r22 == null) goto L35;
        String r23 = r22.e();
        if (r23 == null) goto L35;
    L36:
        Object r111 = "pattern_name";
        r20[2] = TuplesKt.to(r111, r23);
        b.b("StrategyCepNfa_flow_start", MapsKt.mutableMapOf(r20));
        String r112 = "StrategyCepNfa_error";
    L46:
        Iterator r113 = this.a.iterator();
    L48:
        if (r113.hasNext() == false) goto L169;
        a r24 = (a) r113.next();
        if (this.i.d() > 0) goto L52;
    L55:
        LinkedHashSet r25 = r15;
        d r26 = r24.e;
        if (r26 == null) goto L148;
        String r28 = r38;
        String r29 = r13;
        Intrinsics.checkNotNullParameter(r28, r29);
        String r30 = r14;
        Intrinsics.checkNotNullParameter(r39, r30);
        if (r26.c == false) goto L60;
        r14 = r30;
        LinkedHashSet r210 = r25;
        a r211 = r24;
        Iterator r32 = r113;
    L146:
        int r31 = 4;
    L147:
        int r33 = r31;
    L149:
        int r34 = b.a;
        String r35 = this.j;
        a r36 = r211;
        String r37 = r36.a;
        Intrinsics.checkNotNullParameter(r35, r110);
        Intrinsics.checkNotNullParameter(r28, "eventName");
        Intrinsics.checkNotNullParameter(r37, "flowName");
        b.b("StrategyCepNfa_flow_move", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r17, r35), TuplesKt.to("event_name", r28), TuplesKt.to("flow_name", r37), TuplesKt.to("flow_pattern_result", Integer.valueOf(r33))}));
        if (r33 != 2) goto L152;
        LinkedHashSet r40 = r210;
        r36.f++;
        List<t> r41 = this.i.b();
        if (r41 == null) goto L167;
        t r42 = (t) CollectionsKt.getOrNull(r41, r36.f);
        if (r42 == null) goto L167;
        r110 = r110;
        String r212 = r14;
        String r213 = r29;
        d r43 = new d(this.j, this.h, r42, System.nanoTime(), this.b, r36, this);
        r36.e = r43;
        t r44 = r43.f;
        if (r44 != null) goto L163;
    L166:
        LinkedHashSet r45 = r40;
    L168:
        r15 = r45;
        r14 = r212;
        r13 = r213;
        r113 = r32;
        r110 = r110;
        goto L48
    L163:
        if (r44.d() != 6) goto L166;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r46 = new com.bytedance.android.livesdk.dynamicstrategy.api.entity.a();
        r46.nodeType = 1;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r47 = new com.bytedance.android.livesdk.dynamicstrategy.api.entity.f();
        r47.value = Boolean.TRUE;
        Unit r48 = Unit.INSTANCE;
        r46.boolNode = r47;
        l(r46);
        r36.e = null;
        k(r36.b, "Nfa Move To End");
        return;
    L167:
        r213 = r29;
        r110 = r110;
        r212 = r14;
        r45 = r40;
        r45.add(Long.valueOf(r36.b));
        goto L168
    L152:
        if (r33 == 4) goto L154;
        LinkedHashSet r49 = r210;
    L155:
        r213 = r29;
        r45 = r49;
        r212 = r14;
        goto L168
    L154:
        r49 = r210;
        r49.add(Long.valueOf(r36.b));
        goto L155
    L60:
        r14 = r30;
        if (r26.f.g() <= 0) goto L66;
        r210 = r25;
        r211 = r24;
        r32 = r113;
        Object r310 = r111;
        if ((System.nanoTime() - r26.g) <= ((((long) r26.f.g()) * 1000000) * ((long) BubbleId.PadCast))) goto L67;
        int r50 = b.a;
        b.c(r26.d, r28, r26.i.a + '_' + r26.f.e(), "Pattern Time Out");
    L65:
        r111 = r310;
    L67:
        Map<String, com.bytedance.android.livesdk.dynamicstrategy.api.entity.k> r51 = r26.f.c();
        if (r51 == null) goto L173;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.k r52 = r51.get(r28);
        if (r52 == null) goto L173;
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.l> r53 = r52.a();
        if (r53 == null) goto L173;
        Iterator<T> r54 = r53.iterator();
    L75:
        if (r54.hasNext() == false) goto L173;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.l r55 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.l) r54.next();
        String r56 = r55.a();
        if (r56 == null) goto L75;
        if (r56.length() <= 0) goto L81;
        boolean r114 = true;
    L82:
        if (r114 == true) goto L85;
        r56 = null;
    L85:
        if (r56 == null) goto L75;
        Object r115 = r39.get(r56);
        if (r115 == null) goto L75;
        if ((r115 instanceof String) == false) goto L75;
        if (r55.b() != 1) goto L98;
        long r116 = CastLongProtector.parseLong((String) r115);     // Catch: NumberFormatException -> L95
    L96:
        r39.put(r56, Long.valueOf(r116));
    L95:
        r116 = 0;
        goto L96
    L98:
        if (r55.b() != 2) goto L75;
        Object r57 = Double.valueOf(CastDoubleProtector.parseDouble((String) r115));     // Catch: NumberFormatException -> L101
    L102:
        r39.put(r56, r57);
    L101:
        r57 = 0;
        goto L102
    L81:
        r114 = false;
    L173:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r58 = r26.f.a();     // Catch: Exception -> L141
        if (r58 == null) goto L108;
        Map<String, ASTRunner.b0> r59 = ASTRunner.a;     // Catch: Exception -> L141
        Object r60 = ASTRunner.b(r58, new ASTRunner.a(r39));     // Catch: Exception -> L141
    L110:
        if ((r60 instanceof Boolean) == true) goto L112;
        r60 = null;
    L112:
        Boolean r61 = (Boolean) r60;     // Catch: Exception -> L141
        if (r61 == null) goto L65;
        boolean r62 = r61.booleanValue();     // Catch: Exception -> L141
        int r63 = b.a;
        String r64 = r26.d;
        String r65 = r26.i.a + '_' + r26.f.e();
        Intrinsics.checkNotNullParameter(r64, r110);
        Intrinsics.checkNotNullParameter(r28, "eventName");
        Intrinsics.checkNotNullParameter(r65, "patternName");
        r111 = r310;
        b.b("StrategyCepNfa_pattern", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r17, r64), TuplesKt.to("event_name", r28), TuplesKt.to(r111, r65), TuplesKt.to("condition_result", Boolean.valueOf(r62))}));
        int r66 = r26.f.d();
        if (r66 == 1) goto L123;
        if (r66 == 2) goto L123;
        if (r66 != 4) goto L146;
        if (r62 == true) goto L146;
    L138:
        r31 = 2;
    L123:
        if (r62 == true) goto L125;
        r31 = 3;
        goto L147
    L125:
        if (r26.f.f() <= 0) goto L130;
        int r67 = r26.a + 1;
        r26.a = r67;
        if (r67 >= r26.f.f()) goto L130;
        boolean r68 = false;
    L131:
        if (r68 == false) goto L139;
        m r69 = r26.b;
        if (r69 == null) goto L137;
        l r70 = r26.h;
        if (r70 == null) goto L137;
        r70.c(r69);
    L137:
        r26.b = null;
        goto L138
    L139:
        r31 = 1;
    L130:
        r68 = true;
        goto L131
    L108:
        r60 = null;
    L141:
        e = move-exception;
        r111 = r310;
        int r71 = b.a;
        String r72 = r26.d;
        String r73 = r26.i.a + '_' + r26.f.e();
        String r75 = e.getMessage();
        if (r75 != null) goto L145;
        r75 = "ASTRunner Execute Error";
    L145:
        Intrinsics.checkNotNullParameter(r72, r110);
        Intrinsics.checkNotNullParameter(r28, "eventName");
        Intrinsics.checkNotNullParameter(r73, "patternName");
        Intrinsics.checkNotNullParameter(r75, "reason");
        k0.o().f(r112, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r17, r72), TuplesKt.to("event_name", r28), TuplesKt.to(r111, r73), TuplesKt.to("reason", r75)}));
        goto L146
    L66:
        r210 = r25;
        r211 = r24;
        r32 = r113;
        r310 = r111;
        goto L67
    L148:
        r28 = r38;
        r210 = r25;
        r211 = r24;
        r32 = r113;
        r29 = r13;
        r33 = 4;
        goto L149
    L52:
        if (System.nanoTime() <= r24.c) goto L55;
        LinkedHashSet r76 = r15;
        r76.add(Long.valueOf(r24.b));
        r45 = r76;
        r32 = r113;
        r213 = r13;
        r212 = r14;
        goto L168
    L169:
        final LinkedHashSet r77 = r15;
        CollectionsKt.removeAll(this.a, new EventCepNfa$onNewEvent$5(this, r77));
        return;
    L35:
        r23 = "null";
        goto L36
    L28:
        r12 = new Pair(0L, null);
        goto L29
    L17:
        r5 = null;
        goto L18
    L14:
        r4 = false;
    L37:
        this.d = true;
        int r78 = b.a;
        String r79 = this.j;
        String r80 = this.h;
        s r81 = this.i;
        Intrinsics.checkNotNullParameter(r79, "roomId");
        Intrinsics.checkNotNullParameter(r80, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r81, "nfa");
        Pair[] r82 = new Pair[3];
        r82[0] = TuplesKt.to("room_id", r79);
        r82[1] = TuplesKt.to("nfa_name", r80);
        List<t> r83 = r81.b();
        if (r83 == null) goto L42;
        t r84 = (t) CollectionsKt.getOrNull(r83, 0);
        if (r84 == null) goto L42;
        int r85 = r84.d();
    L43:
        r82[2] = TuplesKt.to("first_pattern", Integer.valueOf(r85));
        k0.o().f("StrategyCepNfa_error", MapsKt.mutableMapOf(r82));
        return;
    L42:
        r85 = -1;
    L45:
        r110 = "roomId";
        r112 = "StrategyCepNfa_error";
        r111 = "pattern_name";
        r17 = "room_id";
        goto L46
    }

    public final void k(long r9, String r11) {
        Intrinsics.checkNotNullParameter(r11, "stopReason");
        int r0 = b.a;
        String r1 = this.j;
        String r2 = this.h;
        Intrinsics.checkNotNullParameter(r1, "roomId");
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r11, "reason");
        b.b("StrategyCepNfa_nfa_stop", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r1), TuplesKt.to("nfa_name", r2), TuplesKt.to("reason", r11)}));
        Iterator<T> r3 = this.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L18;
        a r4 = (a) r3.next();
        m r5 = r4.d;
        if (r5 == null) goto L11;
        l r6 = this.b;
        if (r6 == null) goto L11;
        r6.c(r5);
    L11:
        if (r9 != 0) goto L13;
    L14:
        d r7 = r4.e;
        if (r7 == null) goto L17;
        r7.b(false, r11);
    L17:
        r4.e = null;
        r4.d = null;
        r4.f = -1;
        goto L4
    L13:
        if (r9 == r4.b) goto L17;
    L18:
        this.a.clear();
        this.b = null;
        this.d = true;
    }

    public e(String r2, s r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r3, "nfa");
        Intrinsics.checkNotNullParameter(r4, "roomId");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.a = new LinkedList();
        this.g = new LinkedHashSet();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.nfa.c
    public final void d(String r16, long r17, long r19) {
        Intrinsics.checkNotNullParameter(r16, "nfaName");
        if (this.d == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.a.iterator();
    L7:
        if (r0.hasNext() == false) goto L20;
        Object r1 = r0.next();
        a r2 = (a) r1;
        if (r17 <= 0) goto L13;
        if (r2.b != r17) goto L13;
    L16:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L7;
    L21:
        a r13 = (a) r1;
        if (r13 == null) goto L41;
        r13.f++;
        List<t> r4 = this.i.b();
        if (r4 == null) goto L32;
        t r5 = (t) CollectionsKt.getOrNull(r4, r13.f);
        if (r5 == null) goto L32;
        d r14 = new d(this.j, this.h, r5, System.nanoTime(), this.b, r13, this);
        r13.e = r14;
        t r6 = r14.f;
        if (r6 == null) goto L32;
        if (r6.d() != 6) goto L32;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r7 = new com.bytedance.android.livesdk.dynamicstrategy.api.entity.a();
        r7.nodeType = 1;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r8 = new com.bytedance.android.livesdk.dynamicstrategy.api.entity.f();
        r8.value = Boolean.TRUE;
        Unit r9 = Unit.INSTANCE;
        r7.boolNode = r8;
        l(r7);
        r13.e = null;
        k(r13.b, "Nfa Pattern TimeOut Move To End");
    L32:
        h r10 = this.c;
        if (r10 == null) goto L42;
        r10.b(r16);
        r10.d(r16);
        return;
    L42:
        return;
    L41:
        return;
    L13:
        if (r19 > 0) goto L15;
    L17:
        r3 = false;
        goto L18
    L15:
        if (r2.c != r19) goto L17;
    L20:
        r1 = null;
        goto L21
    }
}
