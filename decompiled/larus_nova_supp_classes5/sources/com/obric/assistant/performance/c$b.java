package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.IObricDeviceStateService;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c$b implements IObricDeviceStateService.a {
    public c$b() {
    }

    public final void onUserPresent() {
    }

    public final void onScreenOff() {
        Lazy r0 = c.a;
        FLogger.a.d("ObricPerformanceMonitor", "onScreenOff");
    }

    public final void onScreenOn() {
        Lazy r0 = c.a;
        FLogger.a.d("ObricPerformanceMonitor", "onScreenOn");
    }
}
