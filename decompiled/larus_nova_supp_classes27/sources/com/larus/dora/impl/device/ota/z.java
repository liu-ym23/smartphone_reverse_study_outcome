package com.larus.dora.impl.device.ota;

import com.larus.dora.impl.settings.DoraSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class z implements Runnable {
    public /* synthetic */ z() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        g49.d.d("DoraOTAManagement", "onEarbudsIdle prepareToAuto checkToResumeDataTransfer");
        DoraSetting.a.getClass();
        if (DoraSetting.j().f() == true) goto L5;
        DoraOTAManagement.o.set(false);
    L5:
        DoraOTAManagement r0 = DoraOTAManagement.a;
        DoraOTAManagement.k();
    }
}
