package com.obric.cae.userAware;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v implements ConcurrentWifiScanner.ScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6067b;

    public /* synthetic */ v(Object r8, int r10) {
        this.f6066a = r10;
        this.f6067b = r8;
    }

    @Override // com.obric.cae.userAware.ConcurrentWifiScanner.ScanCallback
    public final void onScanResults(List r8) {
        int r10 = this.f6066a;
        Object r11 = this.f6067b;
        switch(r10) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        RssiFluctuationMonitor.a((RssiFluctuationMonitor) r11, r8);
        return;
    L7:
        WifiScanStateMachine.WifiFenceState.b((WifiScanStateMachine.WifiFenceState) r11, r8);
        return;
    L9:
        WifiAwareInfoManager.g((WifiAwareInfoManager) r11, r8);
    }
}
