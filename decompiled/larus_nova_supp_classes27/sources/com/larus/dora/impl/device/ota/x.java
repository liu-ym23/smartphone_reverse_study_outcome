package com.larus.dora.impl.device.ota;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ int[] a;

    public /* synthetic */ x(int[] r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int[] r0 = this.a;
        g49.d.b("DoraOTAManagement", "isLastEndByNotReady: " + DoraOTAManagement.T + ",status:" + r0 + " --- trigger OTA update ");
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        DoraOTAManagement r2 = DoraOTAManagement.a;
        DoraOTAManagement.m(OTAUpdateFrom.BudsChanged.getScene());
        return;
    L11:
        return;
    L5:
        if (r0[2] != 3) goto L7;
        r1 = true;
        goto L8
    }
}
