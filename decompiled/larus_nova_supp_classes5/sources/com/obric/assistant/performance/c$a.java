package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockState;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c$a implements cha.b {
    public c$a() {
    }

    public final void a(ObricAssistantAliveLockState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.d("ObricPerformanceMonitor", "onAssistantAliveStateChanged &state = " + r4);
        Lazy r0 = c.a;
        r4.getCurrentState();
        ObricAssistantAliveLockStateType r5 = ObricAssistantAliveLockStateType.IDLE;
    }

    public final void d(ObricNetworkKeepAliveLockState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }
}
