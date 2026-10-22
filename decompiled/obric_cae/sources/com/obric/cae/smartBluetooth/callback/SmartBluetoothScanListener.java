package com.obric.cae.smartBluetooth.callback;

import android.bluetooth.le.ScanResult;

/* JADX INFO: loaded from: classes.dex */
public interface SmartBluetoothScanListener {
    default void onScanFailed(int r8) {
    }

    default void onScanResult(int r8, ScanResult r10) {
    }
}
