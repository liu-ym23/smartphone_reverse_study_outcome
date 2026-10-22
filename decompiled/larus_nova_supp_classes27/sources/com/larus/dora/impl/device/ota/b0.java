package com.larus.dora.impl.device.ota;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class b0 implements Runnable {
    public /* synthetic */ b0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        g49.d.b("DoraOTAManagement", "startOTA send heartBeats timeout!!!");
        DoraOTAManagement.l = false;
        DoraOTAManagement.m = null;
    }
}
