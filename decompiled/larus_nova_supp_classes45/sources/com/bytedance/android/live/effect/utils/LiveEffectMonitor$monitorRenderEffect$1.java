package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"sendRenderEffectLog", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LiveEffectMonitor$monitorRenderEffect$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $addList;
    final /* synthetic */ String $curList;
    final /* synthetic */ String $endType;
    final /* synthetic */ String $extraLog;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $removeList;
    final /* synthetic */ RenderTriggerType $renderTriggerType;
    final /* synthetic */ int $result;
    final /* synthetic */ String $trace;

    public LiveEffectMonitor$monitorRenderEffect$1(int r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, RenderTriggerType r9) {
        this.$result = r1;
        this.$reason = r2;
        this.$trace = r3;
        this.$curList = r4;
        this.$addList = r5;
        this.$removeList = r6;
        this.$endType = r7;
        this.$extraLog = r8;
        this.$renderTriggerType = r9;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m839invoke() {
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_RENDER_EFFECT, null, null, 14);
        r0.l(this.$result);
        r0.i("reason", this.$reason);
        r0.i("trace", this.$trace);
        r0.i("curList", this.$curList);
        r0.i("addList", this.$addList);
        r0.i("removeList", this.$removeList);
        r0.i("endType", this.$endType);
        r0.i("extraLog", this.$extraLog);
        RenderTriggerType r1 = this.$renderTriggerType;
        if (r1 == null) goto L5;
        r0.i("renderTriggerType", r1.name());
    L5:
        r0.a().report();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m839invoke();
        return Unit.INSTANCE;
    }
}
