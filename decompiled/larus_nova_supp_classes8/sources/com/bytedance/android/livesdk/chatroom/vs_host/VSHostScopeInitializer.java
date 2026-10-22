package com.bytedance.android.livesdk.chatroom.vs_host;

import com.bytedance.android.livesdkapi.model.VSOptimizeConfig;
import com.bytedance.android.livesdkapi.strategy.StrategyConvertHelper;
import com.bytedance.android.scope.m;
import e33.l;
import ec.a;
import j40.z3;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_host/VSHostScopeInitializer;", "", "()V", "vs-host_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSHostScopeInitializer {
    public VSHostScopeInitializer() {
        VSOptimizeConfig r0 = (VSOptimizeConfig) StrategyConvertHelper.getObjectStrategyValue$default("live_vs_optimize_config_smart", (VSOptimizeConfig) z3.a.getValue(), false, false, 12, null);
        a.call("scope-modules");
        l[] r1 = z23.a.a;
        m r2 = m.e;
        z23.a r3 = z23.a.b;
        r2.getClass();
        m.e(r3);
    }
}
