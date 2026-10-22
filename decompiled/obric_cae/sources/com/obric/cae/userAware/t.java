package com.obric.cae.userAware;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t implements ConcurrentWifiScanner.ScanCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5903b;

    public /* synthetic */ t(Object r8, int r10) {
        this.f5902a = r10;
        this.f5903b = r8;
    }

    @Override // com.obric.cae.userAware.ConcurrentWifiScanner.ScanCallback
    public final void onScanResults(List r8) {
        int r10 = this.f5902a;
        Object r11 = this.f5903b;
        switch(r10) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        WifiAwareInfoManager.i((WifiAwareInfoManager) r11, r8);
        return;
    L7:
        WifiAwareInfoManager.c((WifiAwareInfoManager) r11, r8);
        return;
    L9:
        WifiScanStateMachine.WifiFenceState.a((WifiScanStateMachine.WifiFenceState) r11, r8);
    }
}
