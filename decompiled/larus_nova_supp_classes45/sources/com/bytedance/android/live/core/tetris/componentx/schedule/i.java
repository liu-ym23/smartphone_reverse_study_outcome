package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.ComponentBatchPriorityMappingConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends ComponentBatchBaseLoadState {
    public final String b;
    public final LinkedHashMap<Integer, m> c;
    public int d;
    public final StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> e;
    public final h f;
    public BatchTogetherConditionManager g;
    public final LinkedHashMap<Integer, m> h;
    public final q i;
    public final ComponentSchedulingManager.a j;
    public final f k;

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final b b() {
        if (this.g != null) goto L6;
        this.g = new BatchTogetherConditionManager(this.f, this.h);
    L6:
        return this.g;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void d() {
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r0 = this.e;
        ComponentBatchBaseLoadState.a.C0152a r1 = new ComponentBatchBaseLoadState.a.C0152a();
        StateMachine.a r2 = StateMachine.c;
        r0.d(r1, null);
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void a() {
        super.a();
        this.c.clear();
        this.d = 0;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.schedule.ComponentBatchBaseLoadState
    public final void c(BatchTogetherConditionManager.BatchLoadConditionType r4) {
        if (r4 == null) goto L22;
        f r0 = this.k;
        if (r0 != null) goto L6;
    L18:
        b r1 = b();
        if (r1 == null) goto L25;
        r1.b(1, r4);
        return;
    L25:
        return;
    L6:
        if (r0.b() != true) goto L18;
        if (r4 != BatchTogetherConditionManager.BatchLoadConditionType.END_ROOM_ENTER) goto L18;
        if (LiveInfraSettingKeys.LIVE_SUBBATCH_LOAD_FIX.getValue().booleanValue() == false) goto L18;
        b r2 = b();
        if (r2 == null) goto L23;
        ComponentBatchPriorityMappingConfig r3 = LiveInfraSettingKeys.LIVE_COMPONENT_DYNAMIC_BATCH_CONFIG.getValue().getPriorityMapping();
        if (r3 == null) goto L16;
        int r5 = r3.getP0_end();
    L17:
        r2.b(r5 + 1, r4);
        return;
    L16:
        r5 = 0;
        goto L17
    L23:
        return;
    }

    public final void e(Map<Integer, Set<BatchTogetherConditionManager.BatchLoadConditionType>> r3) {
        Intrinsics.checkNotNullParameter(r3, "conditionsMap");
        b r0 = b();
        if (r0 == null) goto L5;
        r0.a(r3);
    L5:
        StateMachine<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b> r4 = this.e;
        ComponentBatchBaseLoadState.a.c r1 = new ComponentBatchBaseLoadState.a.c();
        StateMachine.a r2 = StateMachine.c;
        r4.d(r1, null);
    }

    public i(LinkedHashMap r2, q r3, o r4, f r5) {
        Intrinsics.checkNotNullParameter(r2, "componentSchedulingList");
        Intrinsics.checkNotNullParameter(r4, "componentBatchLoadListener");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.b = "ComponentBatchTogetherLoadState";
        this.c = new LinkedHashMap();
        StateMachine.a r6 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<ComponentBatchBaseLoadState.c, ComponentBatchBaseLoadState.a, ComponentBatchBaseLoadState.b>, Unit> r7 = new ComponentBatchTogetherLoadState$stateMachine$1(this);
        r6.getClass();
        this.e = StateMachine.a.a(r7);
        this.f = new h(this);
    }
}
