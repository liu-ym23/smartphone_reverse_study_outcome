package com.sdk.bwdl.AdapterLayer.BleScanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import androidx.core.content.a;
import com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure.BwdlAdvConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BleExternalScanner implements BleScanHelper {
    private static final String TAG = "BleExternalScanner";
    private List<ScanFilter> filters;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;
    private Context mContext;
    private Handler mHandler;
    private final boolean mLegacy;
    private int mScanMode;
    private ScanSettings mScanSettings;
    private ScanSettings.Builder mScanSettingsBuilder;

    public BleExternalScanner(Context r8, BluetoothAdapter r10) {
        this.mScanMode = 2;
        this.mLegacy = false;
        this.mHandler = new Handler();
        this.mContext = r8;
        this.mBluetoothAdapter = r10;
        this.mBluetoothLeScanner = r10.getBluetoothLeScanner();
        this.mScanSettingsBuilder = new ScanSettings.Builder();
        initDefaultScanSettings();
    }

    private boolean checkSelfPermission(String r8) {
        if (a.a(this.mContext, r8) == 0) goto L6;
        return false;
    L6:
        return true;
    }

    private void initDefaultScanSettings() {
        this.mScanSettings = this.mScanSettingsBuilder.setScanMode(this.mScanMode).setLegacy(false).build();
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleScanner.BleScanHelper
    public boolean isScanning() {
        return true;
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleScanner.BleScanHelper
    public void setScanMode(int r8) {
        this.mScanMode = r8;
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleScanner.BleScanHelper
    public void startScan(ScanCallback r8) {
        ScanFilter.Builder r10 = new ScanFilter.Builder();
        r10.setManufacturerData(BwdlAdvConstants.MANUFACTURER_ID, null, null);
        ScanFilter r11 = r10.build();
        new ArrayList().add(r11);
        if (checkSelfPermission("android.permission.BLUETOOTH_SCAN") == false) goto L6;
        this.mBluetoothLeScanner.startScan(null, this.mScanSettings, r8);
        return;
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleScanner.BleScanHelper
    public void stopScan(ScanCallback r8) {
        if (checkSelfPermission("android.permission.BLUETOOTH_SCAN") == false) goto L6;
        this.mBluetoothLeScanner.stopScan(r8);
        return;
    }

    public void startScan(List<ScanFilter> r8, ScanCallback r10) {
        if (checkSelfPermission("android.permission.BLUETOOTH_SCAN") == false) goto L6;
        this.mBluetoothLeScanner.startScan(r8, this.mScanSettings, r10);
        return;
    }
}
