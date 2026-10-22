package com.larus.dora.impl.device.settings.lab.env;

import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.impl.device.settings.lab.env.override.EnvObserveOverrideChangeReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Function2 {
    public /* synthetic */ c() {
    }

    public final Object invoke(Object r3, Object r4) {
        EnvObserveOverrideChangeReason r5 = (EnvObserveOverrideChangeReason) r4;
        Intrinsics.checkNotNullParameter((String) r3, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "reason");
        DoraEnvObserveManager.a.getClass();
        if (r5 != EnvObserveOverrideChangeReason.ACTIVATED) goto L5;
        int r6 = 187;
    L6:
        g49.d.d("DoraEnvObserveManager", "temporary override changed, reason=" + r5);
        DoraEnvObserveManager.h(EnvObserveChangeReason.TIMER_CHANGE, r6);
        return Unit.INSTANCE;
    L5:
        r6 = 186;
        goto L6
    }
}
