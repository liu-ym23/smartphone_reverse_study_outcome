package com.obric.assistant.state.impl.v2.power;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class e implements Function0 {
    public /* synthetic */ e() {
    }

    public final Object invoke() {
        ObricPowerManager.ForceReleasePowerLockReason r0 = ObricPowerManager.ForceReleasePowerLockReason.ON_TIMEOUT;
        Intrinsics.checkNotNullParameter(r0, "reason");
        BuildersKt.launch$default(ObricPowerManager.a, null, null, new ObricPowerManager.forceReleaseNetworkKeepAliveLock.1(r0, null), 3, null);
        return Unit.INSTANCE;
    }
}
