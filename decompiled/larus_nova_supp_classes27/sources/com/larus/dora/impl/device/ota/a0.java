package com.larus.dora.impl.device.ota;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a0 implements Runnable {
    public /* synthetic */ a0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        g49.d.b("DoraOTAManagement", "isLastEndBySilenceClose: --- trigger OTA update ");
        DoraOTAManagement r0 = DoraOTAManagement.a;
        DoraOTAManagement.m(OTAUpdateFrom.AutoSwitch.getScene());
    }
}
