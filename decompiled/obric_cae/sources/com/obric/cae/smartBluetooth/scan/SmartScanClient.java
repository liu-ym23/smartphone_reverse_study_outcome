package com.obric.cae.smartBluetooth.scan;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.Binder;
import com.obric.cae.smartBluetooth.callback.SmartBluetoothScanListener;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SmartScanClient {
    private static final ScanSettings DEFAULT_SCAN_SETTINGS = null;
    private static final String TAG = "SmartScanClient";
    final int mAppUid;
    final SmartBluetoothScanListener mCallback;
    final List<ScanFilter> mFilters;
    int mScanModeApp;
    final int mScannerId;
    ScanSettings mSettings;

    static {
        DEFAULT_SCAN_SETTINGS = new ScanSettings.Builder().setScanMode(2).build();
    }

    public SmartScanClient(int r8, ScanSettings r10, List<ScanFilter> r11, int r12, SmartBluetoothScanListener r13) {
        this.mScannerId = r8;
        this.mSettings = r10;
        this.mScanModeApp = r10.getScanMode();
        this.mFilters = r11;
        this.mAppUid = r12;
        this.mCallback = r13;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L15;
        if (this.mScannerId != ((SmartScanClient) r8).mScannerId) goto L14;
        return true;
    L14:
        return false;
    }

    public int getAppUid() {
        return this.mAppUid;
    }

    public SmartBluetoothScanListener getCallback() {
        return this.mCallback;
    }

    public List<ScanFilter> getFilters() {
        return this.mFilters;
    }

    public int getScanModeApp() {
        return this.mScanModeApp;
    }

    public int getScannerId() {
        return this.mScannerId;
    }

    public ScanSettings getSettings() {
        return this.mSettings;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mScannerId)});
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder(" [ScanClient scanModeApp ");
        r8.append(this.mScanModeApp);
        r8.append(" scanModeUsed ");
        r8.append(this.mSettings.getScanMode());
        r8.append(" scannerId ");
        return android.aimedia.a.h(r8, this.mScannerId, " ]");
    }

    public SmartScanClient(int r8, ScanSettings r10, List<ScanFilter> r11, SmartBluetoothScanListener r12) {
        this(r8, r10, r11, Binder.getCallingUid(), r12);
    }

    public SmartScanClient(int r8, SmartBluetoothScanListener r10) {
        this(r8, DEFAULT_SCAN_SETTINGS, null, r10);
    }
}
