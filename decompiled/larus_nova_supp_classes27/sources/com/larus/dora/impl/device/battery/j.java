package com.larus.dora.impl.device.battery;

import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.guide.DoraBatteryGuide;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Runnable {
    public /* synthetic */ j() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = DoraBatteryGuide.d;
        DoraBatteryGuide.Companion.a(AppHost.a.a().getCurrentActivity());
    }
}
