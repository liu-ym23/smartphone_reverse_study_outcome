package com.obric.cae.userAware;

import java.util.List;

/* JADX INFO: renamed from: com.obric.cae.userAware.-$$Lambda$WifiSceneScanController$QWA23ZvztiA-oV4BHahsWw47S94, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$WifiSceneScanController$QWA23ZvztiAoV4BHahsWw47S94 implements ConcurrentWifiScanner.AttributedScanCallback {
    public final /* synthetic */ WifiSceneScanController f$0;

    public /* synthetic */ $$Lambda$WifiSceneScanController$QWA23ZvztiAoV4BHahsWw47S94(WifiSceneScanController r1) {
        this.f$0 = r1;
    }

    @Override // com.obric.cae.userAware.ConcurrentWifiScanner.AttributedScanCallback
    public final void onScanResults(List r1, WifiScanAttribution r2) {
        WifiSceneScanController.m404lambda$QWA23ZvztiAoV4BHahsWw47S94(this.f$0, r1, r2);
    }
}
