package com.obric.miniapp.utils;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.v2.core.IObricDeviceStateService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l0 implements IObricDeviceStateService.a {
    public l0() {
    }

    public final void onScreenOff() {
        FLogger.a.d("DevicePowerManager", "onScreenOff");
        k0.d("screenOff");
    }

    public final void onScreenOn() {
        FLogger.a.d("DevicePowerManager", "onScreenOn");
        k0.d("screenOn");
    }

    public final void onUserPresent() {
        FLogger.a.d("DevicePowerManager", "onUserPresent");
        k0.d("userPresent");
    }
}
