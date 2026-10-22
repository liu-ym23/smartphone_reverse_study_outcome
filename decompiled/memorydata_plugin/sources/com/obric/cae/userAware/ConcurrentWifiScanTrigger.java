package com.obric.cae.userAware;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
final class ConcurrentWifiScanTrigger implements WifiScanTrigger {
    private final ScannerProvider mScannerProvider;

    public interface ScannerProvider {
        ConcurrentWifiScanner getScanner();
    }

    public ConcurrentWifiScanTrigger(ScannerProvider r3) {
        this.mScannerProvider = (ScannerProvider) ZeusTransformUtils.wrapperContextForParams(r3, ScannerProvider.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.cae.userAware.WifiScanTrigger
    public ConcurrentWifiScanner.RequestHandle start(WifiScanRequestSpec r2) {
        ScannerProvider r1 = this.mScannerProvider;
        if (r1 == null) goto L5;
        ConcurrentWifiScanner r3 = r1.getScanner();
    L6:
        if (r3 == null) goto L11;
        if (r2 == null) goto L11;
        return r3.startScan(r2);
    L11:
        return null;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.obric.cae.userAware.WifiScanTrigger
    public boolean stop(ConcurrentWifiScanner.RequestHandle r1) {
        ScannerProvider r0 = this.mScannerProvider;
        if (r0 == null) goto L5;
        ConcurrentWifiScanner r2 = r0.getScanner();
    L6:
        if (r2 != null) goto L8;
    L10:
        return false;
    L8:
        if (r2.stopScan(r1) == false) goto L10;
        return true;
    L5:
        r2 = null;
        goto L6
    }
}
