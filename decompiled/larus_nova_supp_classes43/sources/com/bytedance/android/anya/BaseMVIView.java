package com.bytedance.android.anya;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.DelegatingMVIBindingImpl;
import com.bytedance.android.anya.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseMVIView<STATE extends MVIState<?>, ACTION extends p> {
    public boolean a;
    public com.bytedance.android.anya.internal.m<?, ACTION> b;
    public STATE c;
    public final i0<STATE> d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public abstract void b(k<STATE> r1, STATE r10);

    public boolean d(a0 r1) {
        return false;
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void i() {
    }

    public void k(com.bytedance.android.anya.dsl.a<STATE, ACTION> r1) {
    }

    public void l(com.bytedance.android.anya.dsl.c<STATE, ACTION> r1) {
    }

    public final com.bytedance.android.anya.internal.m<?, ACTION> m() {
        com.bytedance.android.anya.internal.m<?, ACTION> r0 = this.b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final STATE n() {
        STATE r0 = this.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("State not available".toString());
    }

    public BaseMVIView() {
        this.d = new i0();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.e = LazyKt.lazy(r0, new BaseMVIView$reflexComponents$2(this));
        this.f = LazyKt.lazy(r0, new BaseMVIView$listAdapters$2(this));
        this.g = LazyKt.lazy(new BaseMVIView$pagerAdapters$2(this));
    }

    public final void j() {
        i();
        f();
        this.a = false;
        com.bytedance.android.anya.internal.m<?, ACTION> r0 = this.b;
        if (r0 == null) goto L5;
        r0.e((Map) this.e.getValue());
    L5:
        this.b = null;
        this.c = null;
    }

    public final void c(k<STATE> r20) {
        Iterator r10 = ((Map) this.f.getValue()).entrySet().iterator();
    L3:
        boolean r11 = false;
        if (r10.hasNext() == false) goto L107;
        Map.Entry r12 = (Map.Entry) r10.next();
        String r13 = (String) r12.getKey();
        final MVIRecyclerViewAdapter r14 = (MVIRecyclerViewAdapter) r12.getValue();
        com.bytedance.android.anya.internal.s<STATE> r15 = r20.c;
        STATE r16 = this.c;
        if (r16 == null) goto L10;
        LinkedHashMap<String, com.bytedance.android.anya.internal.c<?, ?>> r17 = r16.properties;
        if (r17 == null) goto L10;
        com.bytedance.android.anya.internal.c<?, ?> r18 = r17.get(r13);
    L11:
        if (r18 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        Object r19 = r15.a(r18);
        if (r19 == null) goto L105;
        if (r14 == null) goto L104;
        final com.bytedance.android.anya.internal.t r21 = (com.bytedance.android.anya.internal.t) r19;
        final boolean r110 = r20.c.d;
        List<com.bytedance.android.anya.internal.t.b> r22 = r21.c;     // Catch: Throwable -> L100
        if (r110 == false) goto L20;
    L88:
        Iterator r111 = r10;
        r14.a = CollectionsKt.toList(r21);     // Catch: Throwable -> L100
        RecyclerView r23 = r14.b;     // Catch: Throwable -> L100
        if (r23 != null) goto L91;
    L97:
        r14.notifyDataSetChanged();     // Catch: Throwable -> L100
    L98:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L100
        r21.c.clear();
    L106:
        r10 = r111;
        goto L3
    L91:
        if (r23.isComputingLayout() != true) goto L97;
        if (q0.e == false) goto L97;
        RecyclerView r25 = r14.b;     // Catch: Throwable -> L100
        if (r25 == null) goto L98;
        r25.post(new w(r14));     // Catch: Throwable -> L100
        goto L98
    L20:
        if (Intrinsics.areEqual((com.bytedance.android.anya.internal.t.b) CollectionsKt.firstOrNull(r22), com.bytedance.android.anya.internal.t.b.a.c) == true) goto L88;
        int r26 = r14.a.size();     // Catch: Throwable -> L100
        ArrayList r112 = new ArrayList(r26);     // Catch: Throwable -> L100
        int r113 = 0;
    L23:
        if (r113 >= r26) goto L25;
        r112.add(TuplesKt.to(Integer.valueOf(r113), Boolean.FALSE));     // Catch: Throwable -> L100
        r113 = r113 + 1;     // Catch: Throwable -> L100
        goto L23
    L25:
        Iterator<T> r27 = r22.iterator();     // Catch: Throwable -> L100
    L27:
        if (r27.hasNext() == false) goto L55;
        com.bytedance.android.anya.internal.t.b r114 = (com.bytedance.android.anya.internal.t.b) r27.next();     // Catch: Throwable -> L100
        if ((r114 instanceof com.bytedance.android.anya.internal.t.b.d) == true) goto L30;
        if ((r114 instanceof com.bytedance.android.anya.internal.t.b.c) == true) goto L33;
        if ((r114 instanceof com.bytedance.android.anya.internal.t.b.C0102b) == false) goto L47;
        int r115 = r114.b;     // Catch: Throwable -> L100
        int r116 = 0;
    L40:
        if (r116 >= r115) goto L46;
        Pair r117 = (Pair) r112.get(r114.a + r116);     // Catch: Throwable -> L100
        if (r117 == null) goto L45;
        r112.set(r114.a + r116, Pair.copy$default(r117, null, Boolean.TRUE, 1, null));     // Catch: Throwable -> L100
    L45:
        r116 = r116 + 1;     // Catch: Throwable -> L100
        r10 = r10;
        goto L40
    L46:
        Iterator r118 = r10;
    L52:
        r10 = r118;
        goto L27
    L47:
        r118 = r10;
        if ((r114 instanceof com.bytedance.android.anya.internal.t.b.e) == false) goto L54;
        int r28 = r114.b;     // Catch: Throwable -> L100
        int r29 = 0;
    L50:
        if (r29 >= r28) goto L52;
        r112.set(r114.a + r29, null);     // Catch: Throwable -> L100
        r29 = r29 + 1;     // Catch: Throwable -> L100
        goto L50
    L54:
        throw new IllegalStateException(("bad type of journal: " + r114).toString());     // Catch: Throwable -> L100
    L33:
        int r119 = r114.a;     // Catch: Throwable -> L100
        int r120 = r114.b;     // Catch: Throwable -> L100
        ArrayList r121 = new ArrayList(r120);     // Catch: Throwable -> L100
        int r122 = 0;
    L34:
        if (r122 >= r120) goto L36;
        r121.add(null);     // Catch: Throwable -> L100
        r122 = r122 + 1;     // Catch: Throwable -> L100
        goto L34
    L36:
        r112.addAll(r119, r121);     // Catch: Throwable -> L100
        goto L27
    L30:
        int r123 = r114.a;     // Catch: Throwable -> L100
        r112.subList(r123, r114.b + r123).clear();     // Catch: Throwable -> L100
        goto L27
    L55:
        r111 = r10;
        final LinkedHashMap r30 = new LinkedHashMap();     // Catch: Throwable -> L100
        ArrayList r31 = new ArrayList();     // Catch: Throwable -> L100
        Iterator r32 = r112.iterator();     // Catch: Throwable -> L100
        int r33 = 0;
    L57:
        if (r32.hasNext() == false) goto L71;
        Object r124 = r32.next();     // Catch: Throwable -> L100
        int r125 = r33 + 1;     // Catch: Throwable -> L100
        if (r33 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L100
    L61:
        Pair r126 = (Pair) r124;     // Catch: Throwable -> L100
        if (r126 != null) goto L65;
        r31.add(r21.a(r33));     // Catch: Throwable -> L100
    L64:
        Iterator r127 = r32;
        int r128 = r125;
    L70:
        r32 = r127;
        r33 = r128;
        goto L57
    L65:
        int r129 = ((Number) r126.component1()).intValue();     // Catch: Throwable -> L100
        boolean r130 = ((Boolean) r126.component2()).booleanValue();     // Catch: Throwable -> L100
        r31.add(r14.a.get(r129));     // Catch: Throwable -> L100
        if (r130 == false) goto L64;
        MVIState r131 = r21.a(r33);     // Catch: Throwable -> L100
        STATE r132 = r14.a.get(r129);     // Catch: Throwable -> L100
        r127 = r32;
        r128 = r125;
        r30.put(Integer.valueOf(r33), new k(r132, r14.c.m().f(), new com.bytedance.android.anya.internal.s(r132, false, true, r131)));     // Catch: Throwable -> L100
        if (q0.a == false) goto L70;
        r132.clearModifyState$runtime_release();     // Catch: Throwable -> L100
        goto L70
    L71:
        r14.a = r31;     // Catch: Throwable -> L100
        Iterator<T> r34 = r22.iterator();     // Catch: Throwable -> L100
    L73:
        if (r34.hasNext() == false) goto L98;
        final com.bytedance.android.anya.internal.t.b r35 = (com.bytedance.android.anya.internal.t.b) r34.next();     // Catch: Throwable -> L100
        if ((r35 instanceof com.bytedance.android.anya.internal.t.b.C0102b) == true) goto L79;
        if ((r35 instanceof com.bytedance.android.anya.internal.t.b.e) == true) goto L79;
        if ((r35 instanceof com.bytedance.android.anya.internal.t.b.d) == true) goto L82;
        if ((r35 instanceof com.bytedance.android.anya.internal.t.b.c) == false) goto L87;
        r14.z2(new MVIRecyclerViewAdapter$updateList$$inlined$consumeJournalList$runtime_release$lambda$4(r35, r30, r14, r110, r21));     // Catch: Throwable -> L100
        goto L73
    L87:
        throw new IllegalStateException(("Failed to recognize journal: " + r35).toString());     // Catch: Throwable -> L100
    L82:
        r14.z2(new MVIRecyclerViewAdapter$updateList$$inlined$consumeJournalList$runtime_release$lambda$3(r35, r30, r14, r110, r21));     // Catch: Throwable -> L100
    L79:
        r14.z2(new MVIRecyclerViewAdapter$updateList$$inlined$consumeJournalList$runtime_release$lambda$2(r35, r30, r14, r110, r21));     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        r21.c.clear();
        throw th;
    L104:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIRecyclerViewAdapter<com.bytedance.android.anya.MVIState<*>>");
    L105:
        r111 = r10;
    L10:
        r18 = null;
        goto L11
    L107:
        Iterator r36 = ((Map) this.g.getValue()).entrySet().iterator();
    L109:
        if (r36.hasNext() == false) goto L189;
        Map.Entry r37 = (Map.Entry) r36.next();
        com.bytedance.android.anya.internal.u r38 = (com.bytedance.android.anya.internal.u) r37.getKey();
        final MVIViewPagerAdapter r39 = (MVIViewPagerAdapter) r37.getValue();
        s0 r40 = (s0) r20.c.a(r38);
        if (r40 == null) goto L109;
        if (r39 == null) goto L188;
        final com.bytedance.android.anya.internal.t r41 = (com.bytedance.android.anya.internal.t) r40;
        final boolean r42 = r20.c.d;
        List<com.bytedance.android.anya.internal.t.b> r43 = r41.c;     // Catch: Throwable -> L184
        if (r42 == false) goto L117;
    L171:
        Set r44 = CollectionsKt.toSet(r41);     // Catch: Throwable -> L184
        Iterator<T> r45 = r39.a.iterator();     // Catch: Throwable -> L184
    L173:
        if (r45.hasNext() == false) goto L181;
        MVIState r46 = (MVIState) r45.next();     // Catch: Throwable -> L184
        if (r44.contains(r46) == false) goto L173;
        DelegatingMVIBindingImpl r47 = (DelegatingMVIBindingImpl) ((LinkedHashMap) r39.b).get(r46);     // Catch: Throwable -> L184
        if (r47 == null) goto L173;
        c r48 = (c) r47.d;     // Catch: Throwable -> L184
        if (r48 == null) goto L173;
        r48.q(false);     // Catch: Throwable -> L184
        goto L173
    L181:
        r39.a = CollectionsKt.toList(r41);     // Catch: Throwable -> L184
        r39.notifyDataSetChanged();     // Catch: Throwable -> L184
    L182:
        Unit r49 = Unit.INSTANCE;     // Catch: Throwable -> L184
        r41.c.clear();
        r11 = false;
        goto L109
    L117:
        if (Intrinsics.areEqual((com.bytedance.android.anya.internal.t.b) CollectionsKt.firstOrNull(r43), com.bytedance.android.anya.internal.t.b.a.c) == true) goto L171;
        int r50 = r39.a.size();     // Catch: Throwable -> L184
        ArrayList r133 = new ArrayList(r50);     // Catch: Throwable -> L184
        int r134 = 0;
    L120:
        if (r134 >= r50) goto L122;
        r133.add(Integer.valueOf(r134));     // Catch: Throwable -> L184
        r134 = r134 + 1;     // Catch: Throwable -> L184
        goto L120
    L122:
        Iterator<T> r51 = r43.iterator();     // Catch: Throwable -> L184
    L124:
        if (r51.hasNext() == false) goto L139;
        com.bytedance.android.anya.internal.t.b r52 = (com.bytedance.android.anya.internal.t.b) r51.next();     // Catch: Throwable -> L184
        if ((r52 instanceof com.bytedance.android.anya.internal.t.b.d) == true) goto L127;
        if ((r52 instanceof com.bytedance.android.anya.internal.t.b.c) == true) goto L130;
        if ((r52 instanceof com.bytedance.android.anya.internal.t.b.e) == false) goto L124;
        int r135 = r52.b;     // Catch: Throwable -> L184
        int r136 = 0;
    L137:
        if (r136 >= r135) goto L124;
        r133.set(r52.a + r136, r11);     // Catch: Throwable -> L184
        r136 = r136 + 1;     // Catch: Throwable -> L184
        goto L137
    L130:
        int r137 = r52.a;     // Catch: Throwable -> L184
        int r53 = r52.b;     // Catch: Throwable -> L184
        ArrayList r138 = new ArrayList(r53);     // Catch: Throwable -> L184
        int r139 = 0;
    L131:
        if (r139 >= r53) goto L133;
        r138.add(r11);     // Catch: Throwable -> L184
        r139 = r139 + 1;     // Catch: Throwable -> L184
        goto L131
    L133:
        r133.addAll(r137, r138);     // Catch: Throwable -> L184
        goto L124
    L127:
        int r140 = r52.a;     // Catch: Throwable -> L184
        r133.subList(r140, r52.b + r140).clear();     // Catch: Throwable -> L184
        goto L124
    L139:
        final LinkedHashMap r54 = new LinkedHashMap();     // Catch: Throwable -> L184
        LinkedHashMap r55 = new LinkedHashMap();     // Catch: Throwable -> L184
        Iterator r141 = r133.iterator();     // Catch: Throwable -> L184
        int r142 = 0;
    L141:
        if (r141.hasNext() == false) goto L149;
        Object r143 = r141.next();     // Catch: Throwable -> L184
        int r144 = r142 + 1;     // Catch: Throwable -> L184
        if (r142 >= 0) goto L145;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L184
    L145:
        Integer r145 = (Integer) r143;     // Catch: Throwable -> L184
        r54.put(Integer.valueOf(r142), r145);     // Catch: Throwable -> L184
        if (r145 == null) goto L148;
        r55.put(r145, Integer.valueOf(r142));     // Catch: Throwable -> L184
    L148:
        r142 = r144;
        goto L141
    L149:
        Iterator<T> r146 = r39.a.iterator();     // Catch: Throwable -> L184
        int r147 = 0;
    L151:
        if (r146.hasNext() == false) goto L170;
        Object r148 = r146.next();     // Catch: Throwable -> L184
        int r149 = r147 + 1;     // Catch: Throwable -> L184
        if (r147 >= 0) goto L155;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L184
    L155:
        MVIState r150 = (MVIState) r148;     // Catch: Throwable -> L184
        DelegatingMVIBindingImpl r151 = (DelegatingMVIBindingImpl) ((LinkedHashMap) r39.b).get(r150);     // Catch: Throwable -> L184
        if (r151 == null) goto L169;
        Integer r152 = (Integer) r55.get(Integer.valueOf(r147));     // Catch: Throwable -> L184
        if (r152 == null) goto L169;
        int r153 = r152.intValue();     // Catch: Throwable -> L184
        if (r153 < 0) goto L169;
        if (r41.a(r153) != r150) goto L164;
        boolean r56 = true;
    L165:
        if (r56 == false) goto L168;
        ((c) r151.d).q(false);     // Catch: Throwable -> L184
        goto L169
    L168:
        throw new IllegalStateException(("list item should be exactly same, original: " + r150 + '@' + r147 + ", new index: " + r41.a(r153) + '@' + r153).toString());     // Catch: Throwable -> L184
    L164:
        r56 = false;
    L169:
        r147 = r149;
        goto L151
    L170:
        r39.a = SequencesKt.toList(SequencesKt.mapIndexed(CollectionsKt.asSequence(r41), new MVIViewPagerAdapter$updateList$$inlined$consumeJournalList$runtime_release$lambda$1(r54, r39, r42, r41)));     // Catch: Throwable -> L184
        r39.notifyDataSetChanged();     // Catch: Throwable -> L184
    L184:
        th = move-exception;
        r41.c.clear();
        throw th;
    L188:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIViewPagerAdapter<com.bytedance.android.anya.MVIState<*>, com.bytedance.android.anya.MVIAction>");
    L189:
        b(r20, r20.a);
        if (r20.c.e == true) goto L268;
        r20.a.clearModifyState$runtime_release();
        return;
    }

    /* JADX WARN: Incorrect types in method signature: <T::TACTION;>(TT;)V */
    public final void o(p r10) {
        com.bytedance.android.anya.internal.m<?, ACTION> r0 = this.b;
        if (r0 == null) goto L6;
        r0.b(r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(STATE r1, com.bytedance.android.anya.internal.m<STATE, ACTION> r10) {
        this.c = r1;
        r10.c((Map) this.e.getValue());
        this.b = r10;
        this.a = true;
        e();
        g();
    }
}
