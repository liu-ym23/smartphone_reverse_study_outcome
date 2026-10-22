package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.frontier.IObricFrontierStatusMonitorService;
import com.obric.assistant.network.api.INetworkInterceptorService;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricNetworkKeepAliveLockState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hm9.j;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricPowerManager$powerLockStatusChangedCallback$1 implements cha.b {
    public ObricPowerManager$powerLockStatusChangedCallback$1() {
    }

    public final void a(ObricAssistantAliveLockState r8) {
        Intrinsics.checkNotNullParameter(r8, "state");
        BuildersKt.launch$default(ObricPowerManager.a, null, null, new onAssistantAliveStateChanged.1(r8, null), 3, null);
    }

    public final void d(ObricNetworkKeepAliveLockState r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger r0 = FLogger.a;
        CoroutineScope r1 = ObricPowerManager.a;
        r0.i("[ObricPowerManager]", "lock=network action=state_changed state=" + r4.getCurrentState());
        if (a.a[r4.getCurrentState().ordinal()] != 1) goto L10;
        j.a.d();
        IObricFrontierStatusMonitorService r5 = (IObricFrontierStatusMonitorService) ServiceManager.get().getService(IObricFrontierStatusMonitorService.class);
        if (r5 == null) goto L7;
        r5.a(false);
    L7:
        INetworkInterceptorService r6 = (INetworkInterceptorService) ServiceManager.get().getService(INetworkInterceptorService.class);
        if (r6 == null) goto L17;
        r6.a(false);
        return;
    L17:
        return;
    L10:
        j.a.b();
        IObricFrontierStatusMonitorService r7 = (IObricFrontierStatusMonitorService) ServiceManager.get().getService(IObricFrontierStatusMonitorService.class);
        if (r7 == null) goto L13;
        r7.a(true);
    L13:
        INetworkInterceptorService r8 = (INetworkInterceptorService) ServiceManager.get().getService(INetworkInterceptorService.class);
        if (r8 == null) goto L19;
        r8.a(true);
        return;
    }
}
