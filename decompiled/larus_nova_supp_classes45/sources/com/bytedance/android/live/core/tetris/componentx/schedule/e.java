package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.v;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends ComponentBatchBaseLoadState {
    public final String b;
    public final LinkedHashMap<Integer, m> c;
    public f70.b d;
    public int e;
    public final StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> f;
    public final LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> g;
    public final j h;
    public final q i;
    public final ComponentSchedulingManager.a j;

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final b b() {
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void c(BatchTogetherConditionManager.BatchLoadConditionType r1) {
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void d() {
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r0 = this.f;
        ComponentBatchBaseLoadState.a.C0152a r1 = new ComponentBatchBaseLoadState.a.C0152a();
        StateMachine.a r2 = StateMachine.c;
        r0.d(r1, null);
    }

    public final Integer e() {
        if (this.c.isEmpty() == false) goto L7;
        return null;
    L7:
        return (Integer) CollectionsKt.last(this.c.keySet());
    }

    public final void f() {
        String r0 = this.b;
        StringBuilder r1 = new StringBuilder("localCurrentLoadingLayerType = ");
        r1.append(this.d);
        r1.append(" getLoadingBatchKey = ");
        r1.append(this.e);
        r1.append(" size is ");
        LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> r2 = this.g;
        int r3 = 0;
        if (r2 == null) goto L11;
        LinkedHashMap<Integer, m> r4 = r2.get(this.d);
        if (r4 == null) goto L11;
        m r5 = r4.get(Integer.valueOf(this.e));
        if (r5 == null) goto L11;
        LayerDescriptorList r6 = r5.b;
        if (r6 == null) goto L11;
        int r7 = r6.size();
    L12:
        r1.append(r7);
        ALogger.i(r0, r1.toString());
        if (v.a() == false) goto L26;
        LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> r8 = this.g;
        if (r8 == null) goto L26;
        LinkedHashMap<Integer, m> r9 = r8.get(this.d);
        if (r9 == null) goto L26;
        m r11 = r9.get(Integer.valueOf(this.e));
        if (r11 == null) goto L26;
        LayerDescriptorList r12 = r11.b;
        if (r12 == null) goto L26;
        Iterator<j70.h<? extends h70.b>> r13 = r12.iterator();
    L24:
        if (r13.hasNext() == false) goto L26;
        ALogger.i(this.b, r13.next().toString());
    L26:
        ComponentSchedulingManager.a r14 = this.j;
        f70.b r15 = this.d;
        int r16 = this.e;
        LinkedHashMap<f70.b, LinkedHashMap<Integer, m>> r17 = this.g;
        if (r17 == null) goto L31;
        LinkedHashMap<Integer, m> r18 = r17.get(r15);
        if (r18 == null) goto L31;
        m r19 = r18.get(Integer.valueOf(this.e));
    L32:
        r14.a(r15, r16, r19);
        LinkedHashMap<Integer, m> r21 = this.g.get(this.d);
        if (r21 == null) goto L35;
        m r22 = r21.get(Integer.valueOf(this.e));
    L36:
        if (r22 == null) goto L38;
        this.c.put(Integer.valueOf(this.e), r22);
    L38:
        LinkedHashMap<Integer, m> r23 = this.g.get(this.d);
        if (r23 == null) goto L41;
        int r24 = r23.size();
    L43:
        if (r24 != this.c.size()) goto L51;
        f70.b r25 = this.d;
        if (r25 == null) goto L51;
        if (Intrinsics.areEqual(r25, (f70.b) CollectionsKt.last(this.g.keySet())) == false) goto L50;
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r26 = this.f;
        ComponentBatchBaseLoadState.a.b r27 = new ComponentBatchBaseLoadState.a.b();
        StateMachine.a r28 = StateMachine.c;
        r26.d(r27, null);
        return;
    L50:
        int r29 = d80.a.a;
        this.d = (f70.b) d80.a.a(this.g, r25);
        this.c.clear();
        this.e = 0;
    L51:
        Integer r31 = e();
        if (r31 == null) goto L60;
        int r32 = r31.intValue();
        LinkedHashMap<Integer, m> r33 = this.g.get(this.d);
        if (r33 == null) goto L57;
        r3 = r33.size();
    L57:
        if (r32 >= r3) goto L59;
        r3 = r31.intValue() + 1;
        goto L60
    L59:
        r3 = Integer.MAX_VALUE;
    L60:
        this.e = r3;
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r34 = this.f;
        ComponentBatchBaseLoadState.a.c r35 = new ComponentBatchBaseLoadState.a.c();
        StateMachine.a r36 = StateMachine.c;
        r34.d(r35, null);
        return;
    L41:
        r24 = 0;
        goto L43
    L35:
        r22 = null;
    L31:
        r19 = null;
    L11:
        r7 = 0;
        goto L12
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void a() {
        super.a();
        this.c.clear();
        this.e = 0;
    }

    public final void g(Map<Integer, Set<BatchTogetherConditionManager.BatchLoadConditionType>> r3) {
        Intrinsics.checkNotNullParameter(r3, "conditionsMap");
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r4 = this.f;
        ComponentBatchBaseLoadState.a.c r0 = new ComponentBatchBaseLoadState.a.c();
        StateMachine.a r1 = StateMachine.c;
        r4.d(r0, null);
    }

    public e(LinkedHashMap r2, j r3, q r4, p r5) {
        Intrinsics.checkNotNullParameter(r2, "componentSchedulingList");
        Intrinsics.checkNotNullParameter(r5, "componentBatchLoadListener");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.b = "ComponentLoadState";
        this.c = new LinkedHashMap();
        if (r2 == null) goto L7;
        Set r6 = r2.keySet();
        if (r6 == null) goto L7;
        f70.b r7 = (f70.b) CollectionsKt.first(r6);
    L8:
        this.d = r7;
        StateMachine.a r8 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b>, Unit> r9 = new ComponentBatchInOrderLoadState$stateMachine$1(this);
        r8.getClass();
        this.f = StateMachine.a.a(r9);
        return;
    L7:
        r7 = null;
        goto L8
    }
}
