package com.obric.cae.userAware;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements ConcurrentWifiScanner.ScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5862b;

    public /* synthetic */ e(Object r8, int r10) {
        this.f5861a = r10;
        this.f5862b = r8;
    }

    @Override // com.obric.cae.userAware.ConcurrentWifiScanner.ScanCallback
    public final void onScanResults(List r8) {
        int r10 = this.f5861a;
        Object r11 = this.f5862b;
        switch(r10) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        RssiFluctuationMonitor.b((RssiFluctuationMonitor) r11, r8);
        return;
    L7:
        ConcurrentWifiScanner.ScanRequest.c((ConcurrentWifiScanner.ScanRequest) r11, r8);
        return;
    L9:
        WifiAwareInfoManager.a((WifiAwareInfoManager) r11, r8);
    }
}
