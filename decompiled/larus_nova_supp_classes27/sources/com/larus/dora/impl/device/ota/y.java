package com.larus.dora.impl.device.ota;

import com.larus.dora.impl.settings.DoraSetting;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ long a;

    public /* synthetic */ y(long r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long r0 = this.a;
        g49.d.d("DoraOTAManagement", "onEarbudsIdle prepareToAuto checkUpdates");
        DoraOTAManagement.A = false;
        DoraSetting.a.getClass();
        if (DoraSetting.j().f() == true) goto L5;
        DoraOTAManagement.o.set(false);
    L5:
        DoraOTAManagement.J = 0;
        DoraOTAManagement.L = 0;
        String r2 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.k("ota_buds_active", MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - r0))));
        DoraOTAManagement r1 = DoraOTAManagement.a;
        DoraOTAManagement.m(OTAUpdateFrom.StartAutoOta.getScene());
    }
}
