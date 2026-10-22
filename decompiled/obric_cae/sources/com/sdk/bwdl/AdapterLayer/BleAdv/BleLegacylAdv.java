package com.sdk.bwdl.AdapterLayer.BleAdv;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.AdvertisingSetCallback;
import android.bluetooth.le.AdvertisingSetParameters;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.PeriodicAdvertisingParameters;
import android.content.Context;
import android.os.ParcelUuid;
import androidx.core.content.a;
import com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure.BwdlAdvConstants;
import com.sdk.bwdl.Utils.BWDLLog;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class BleLegacylAdv implements BleExtendAdvHelper {
    private static final int MAX_ADV_LENGTH = 24;
    private static final int MAX_ADV_USER_LENGTH = 27;
    private static final String TAG = "BleLegacylAdv";
    private static int mAdvMode = 2;
    private static boolean mConnectable = true;
    private static boolean mIncludeDeviceName = false;
    private static boolean mIncludeTxPower = false;
    private static int mManufacturerId = 0;
    private static ParcelUuid mServiceUuid = null;
    private static int mTimeout = 0;
    private static int mTxPowerLevel = 3;
    private AdvertiseData mAdvertiseData;
    private AdvertiseSettings mAdvertiseSettings;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    private Context mContext;
    private byte[] mManufacturerData;
    private byte[] mManufacturerScanResponseData;
    private AdvertiseData mScanResponse;

    static {
        mServiceUuid = new ParcelUuid(BwdlAdvConstants.SERVICE_UUID);
        mManufacturerId = BwdlAdvConstants.MANUFACTURER_ID;
    }

    public BleLegacylAdv(Context r8, BluetoothAdapter r10) {
        this.mManufacturerData = new byte[24];
        this.mManufacturerScanResponseData = new byte[27];
        this.mContext = r8;
        this.mBluetoothAdapter = r10;
        if (r10 != null) goto L5;
    L11:
        initDefaultAdvParameters();
        BWDLLog.d(TAG, "BleExternalAdv");
        return;
    L5:
        if (r10.isEnabled() == false) goto L11;
        BluetoothLeAdvertiser r11 = r10.getBluetoothLeAdvertiser();
        this.mBluetoothLeAdvertiser = r11;
        if (r11 == null) goto L11;
        if (a.a(this.mContext, "android.permission.BLUETOOTH_ADVERTISE") == 0) goto L11;
        BWDLLog.d(TAG, "need requestPermissions: ");
        goto L11
    }

    private boolean checkSelfPermission() {
        if (a.a(this.mContext, "android.permission.BLUETOOTH_ADVERTISE") == 0) goto L6;
        return false;
    L6:
        return true;
    }

    private void initDefaultAdvParameters() {
        BWDLLog.d(TAG, "initDefaultAdvParameters");
        buildAdvertisingSettings();
        buildAdvertiseData();
    }

    public void buildAdvertiseData() {
        this.mAdvertiseData = new AdvertiseData.Builder().setIncludeDeviceName(mIncludeDeviceName).setIncludeTxPowerLevel(mIncludeTxPower).addManufacturerData(BwdlAdvConstants.MANUFACTURER_ID, this.mManufacturerData).build();
        String r8 = TAG;
        BWDLLog.d(r8, "mAdvertiseData=" + this.mAdvertiseData.toString());
        this.mScanResponse = new AdvertiseData.Builder().addManufacturerData(43981, this.mManufacturerScanResponseData).build();
        BWDLLog.d(r8, "startAdvertising." + this.mScanResponse.toString());
    }

    public void buildAdvertisingSettings() {
        this.mAdvertiseSettings = new AdvertiseSettings.Builder().setAdvertiseMode(mAdvMode).setTxPowerLevel(mTxPowerLevel).setConnectable(mConnectable).setTimeout(mTimeout).build();
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void setInterval(int r8) {
        mAdvMode = r8;
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void setTxPowerLevel(int r8) {
        mTxPowerLevel = r8;
    }

    public void startAdvertising(AdvertiseCallback r8) {
        if (checkSelfPermission() == false) goto L9;
        BluetoothLeAdvertiser r10 = this.mBluetoothLeAdvertiser;
        if (r10 != null) goto L7;
        return;
    L7:
        r10.startAdvertising(this.mAdvertiseSettings, this.mAdvertiseData, this.mScanResponse, r8);
        BWDLLog.d(TAG, "startAdvertising.");
        return;
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void startAdvertisingSet(AdvertisingSetCallback r8) {
    }

    public void stopAdvertising(AdvertiseCallback r8) {
        if (checkSelfPermission() == false) goto L9;
        BluetoothLeAdvertiser r10 = this.mBluetoothLeAdvertiser;
        if (r10 != null) goto L7;
        return;
    L7:
        r10.stopAdvertising(r8);
        BWDLLog.d(TAG, "stopAdvertising.");
        return;
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void stopAdvertisingSet(AdvertisingSetCallback r8) {
    }

    public void updateAdvertisingManufacturerData(byte[] r8) {
        String r10 = TAG;
        BWDLLog.d(r10, "manufacturerData:" + Arrays.toString(r8));
        if (r8 != null) goto L5;
    L18:
        BWDLLog.d(r10, "Invalid manufacturerData length");
        return;
    L5:
        if (r8.length == 0) goto L18;
        if (r8.length > 51) goto L18;
        if (r8.length <= 24) goto L15;
        System.arraycopy(r8, 0, this.mManufacturerData, 0, 24);
        if ((r8.length - 24) <= 0) goto L14;
        System.arraycopy(r8, 24, this.mManufacturerScanResponseData, 0, Math.min(r8.length - 24, 27));
    L16:
        buildAdvertiseData();
        return;
    L14:
        System.arraycopy(r8, 24, this.mManufacturerScanResponseData, 0, 0);
        goto L16
    L15:
        System.arraycopy(r8, 0, this.mManufacturerData, 0, r8.length);
        goto L16
    }

    public void updateAdvertisingSetManufacturerData(int r8, byte[] r10) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void updateAdvertisingSetServiceData(ParcelUuid r8, byte[] r10) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void startAdvertisingSet(AdvertisingSetParameters r8, AdvertiseData r10, AdvertiseData r11, PeriodicAdvertisingParameters r12, AdvertiseData r13, AdvertisingSetCallback r14) {
    }

    public void updateAdvertisingSetManufacturerData(byte[] r8) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void updateAdvertisingSetServiceData(byte[] r8) {
    }
}
