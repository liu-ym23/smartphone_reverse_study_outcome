package com.sdk.bwdl.AdapterLayer.BleScanner;

import android.bluetooth.le.ScanCallback;

/* JADX INFO: loaded from: classes2.dex */
public interface BleScanHelper {
    boolean isScanning();

    void setScanMode(int r8);

    void startScan(ScanCallback r8);

    void stopScan(ScanCallback r8);
}
