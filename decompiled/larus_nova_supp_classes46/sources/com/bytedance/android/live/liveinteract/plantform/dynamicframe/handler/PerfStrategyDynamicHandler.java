package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PerfStrategyDynamicHandler extends lh0.b {
    public final Function1<Map<String, com.bytedance.android.live.liveinteract.plantform.performance.d0>, Unit> d;
    public final ih0.b e;

    @Override // lh0.b
    public final void d() {
        ALogger.i("MultiLinkDynamicWidget", "MultiLinkAtomicAbility onDestroy unRegisterPerfAbilityCBForAllAbility");
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.plantform.performance.a r1 = r0.getMultiLinkPerfAbilityManager(false);
        if (r1 == null) goto L7;
        r1.d(this.d);
    L7:
        super.d();
    }

    public final void f(JsonElement r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("strategy_biz", PbRequest.SwitchType.MULTI_LINK);
        r0.add("strategy_config", r5);
        this.e.Dk("root", "performance_strategy", r0, false);
    }

    public PerfStrategyDynamicHandler(Context r2, DataCenter r3, ih0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "service");
        super(r2, r3);
        this.e = r4;
        this.d = new PerfStrategyDynamicHandler$registerCallBack$1(this);
    }
}
