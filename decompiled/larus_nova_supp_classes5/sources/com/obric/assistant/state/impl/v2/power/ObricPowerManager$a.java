package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricPowerManager$a implements pba.b {
    public ObricPowerManager$a() {
    }

    public final void a(boolean r4) {
        FLogger r0 = FLogger.a;
        CoroutineScope r1 = ObricPowerManager.a;
        r0.i("[ObricPowerManager]", "onObricIntentStatusChanged, " + r4);
        if (r4 == false) goto L5;
        CoroutineScope r5 = ObricPowerManager.a;
        AssistantAliveReason r6 = AssistantAliveReason.INTENT_IN_PROGRESS;
        ObricPowerManager.d(r6);
        ObricPowerManager.c(r6);
        return;
    L5:
        CoroutineScope r7 = ObricPowerManager.a;
        AssistantAliveReason r8 = AssistantAliveReason.INTENT_IN_PROGRESS;
        ObricPowerManager.g(r8);
        ObricPowerManager.f(r8);
    }
}
