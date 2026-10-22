package com.sdk.bwdl.AdapterLayer.BleAdv;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertisingSetCallback;
import android.bluetooth.le.AdvertisingSetParameters;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.PeriodicAdvertisingParameters;
import android.content.Context;
import android.os.ParcelUuid;
import androidx.core.content.a;
import com.sdk.bwdl.NearFieldSwap.BwdlAdvStructure.BwdlAdvConstants;
import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import com.sdk.bwdl.Utils.BWDLLog;

/* JADX INFO: loaded from: classes2.dex */
public class BleExternalAdv implements BleExtendAdvHelper {
    private static byte[] MANUFACTURER_DATA = null;
    private static final String TAG = "BleExternalAdv";
    private static boolean mConnectable = true;
    private static boolean mIncludeDeviceName = true;
    private static boolean mIncludeTxPower = true;
    private static int mInterval = 400;
    private static boolean mLegacyMode = false;
    private static int mManufacturerId = 0;
    private static ParcelUuid mServiceUuid = null;
    private static int mTxPowerLevel = 1;
    private AdvertiseData.Builder mAdvDataBuilder;
    private AdvertisingSetParameters.Builder mAdvSetParamsBuilder;
    private AdvertiseData mAdvertiseData;
    private AdvertisingSetParameters mAdvertisingSetParameters;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    private Context mContext;
    private byte[] serviceData;

    static {
        mServiceUuid = new ParcelUuid(BwdlAdvConstants.SERVICE_UUID);
        mManufacturerId = BwdlAdvConstants.MANUFACTURER_ID;
        MANUFACTURER_DATA = new byte[]{BWDLDataStructure.DataLinkParamStructure.SOCKET, 34};
    }

    public BleExternalAdv(Context r8, BluetoothAdapter r10) {
        this.serviceData = new byte[0];
        this.mContext = r8;
        this.mBluetoothAdapter = r10;
        String r11 = TAG;
        BWDLLog.d(r11, "BleExternalAdv  mBluetoothAdapter=" + this.mBluetoothAdapter);
        this.mBluetoothLeAdvertiser = this.mBluetoothAdapter.getBluetoothLeAdvertiser();
        this.mAdvSetParamsBuilder = new AdvertisingSetParameters.Builder();
        this.mAdvDataBuilder = new AdvertiseData.Builder();
        initDefaultAdvParameters();
        BWDLLog.d(r11, "BleExternalAdv");
    }

    private boolean checkSelfPermission() {
        if (a.a(this.mContext, "android.permission.BLUETOOTH_ADVERTISE") == 0) goto L6;
        return false;
    L6:
        return true;
    }

    private void initDefaultAdvParameters() {
        BWDLLog.d(TAG, "initDefaultAdvParameters");
        buildAdvertisingSetParameters();
        buildAdvertiseData();
    }

    public void buildAdvertiseData() {
        this.mAdvertiseData = new AdvertiseData.Builder().setIncludeDeviceName(mIncludeDeviceName).setIncludeTxPowerLevel(mIncludeTxPower).build();
    }

    public void buildAdvertisingSetParameters() {
        this.mAdvertisingSetParameters = this.mAdvSetParamsBuilder.setLegacyMode(mLegacyMode).setIncludeTxPower(mIncludeTxPower).setTxPowerLevel(mTxPowerLevel).setInterval(mInterval).setConnectable(mConnectable).build();
    }

    public void rebuildAdvertiseData(byte[] r8) {
        this.mAdvertiseData = this.mAdvDataBuilder.setIncludeDeviceName(mIncludeDeviceName).setIncludeTxPowerLevel(mIncludeTxPower).build();
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void setInterval(int r8) {
        mInterval = r8;
        buildAdvertisingSetParameters();
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void setTxPowerLevel(int r8) {
        mTxPowerLevel = r8;
        buildAdvertisingSetParameters();
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void startAdvertisingSet(AdvertisingSetCallback r10) {
        if (checkSelfPermission() == false) goto L9;
        BluetoothLeAdvertiser r8 = this.mBluetoothLeAdvertiser;
        if (r8 != null) goto L7;
        return;
    L7:
        r8.startAdvertisingSet(this.mAdvertisingSetParameters, this.mAdvertiseData, null, null, null, r10);
        BWDLLog.d(TAG, "startAdvertisingSet");
        return;
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void stopAdvertisingSet(AdvertisingSetCallback r8) {
        if (checkSelfPermission() == false) goto L9;
        BluetoothLeAdvertiser r10 = this.mBluetoothLeAdvertiser;
        if (r10 != null) goto L7;
        return;
    L7:
        r10.stopAdvertisingSet(r8);
        BWDLLog.d(TAG, "stopAdvertisingSet");
        return;
    }

    public void updateAdvertisingSetManufacturerData(int r8, byte[] r10) {
        this.mAdvertiseData = this.mAdvDataBuilder.addManufacturerData(r8, r10).setIncludeDeviceName(mIncludeDeviceName).setIncludeTxPowerLevel(mIncludeTxPower).build();
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void updateAdvertisingSetServiceData(ParcelUuid r8, byte[] r10) {
        this.mAdvertiseData = this.mAdvDataBuilder.addServiceUuid(r8).addServiceData(r8, r10).build();
    }

    private boolean checkSelfPermission(String r8) {
        if (a.a(this.mContext, r8) == 0) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void startAdvertisingSet(AdvertisingSetParameters r10, AdvertiseData r11, AdvertiseData r12, PeriodicAdvertisingParameters r13, AdvertiseData r14, AdvertisingSetCallback r15) {
        if (checkSelfPermission() == false) goto L6;
        this.mBluetoothLeAdvertiser.startAdvertisingSet(r10, r11, r12, r13, r14, r15);
        BWDLLog.d(TAG, "startAdvertisingSet");
        return;
    }

    public void updateAdvertisingSetManufacturerData(byte[] r8) {
        this.mAdvertiseData = this.mAdvDataBuilder.addManufacturerData(mManufacturerId, r8).setIncludeDeviceName(mIncludeDeviceName).setIncludeTxPowerLevel(mIncludeTxPower).build();
    }

    @Override // com.sdk.bwdl.AdapterLayer.BleAdv.BleExtendAdvHelper
    public void updateAdvertisingSetServiceData(byte[] r8) {
        this.mAdvertiseData = this.mAdvDataBuilder.addServiceUuid(mServiceUuid).addServiceData(mServiceUuid, r8).build();
    }
}
