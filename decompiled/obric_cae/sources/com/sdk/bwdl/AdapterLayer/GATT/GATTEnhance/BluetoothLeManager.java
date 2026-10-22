package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.ParcelUuid;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothLeManager {
    public static final ParcelUuid CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID = null;
    private static final String TAG = "BluetoothLeManager";
    private static BluetoothGattCentral sGattCentral;
    private static BluetoothGattPeripheral sGattPeripheral;
    private static volatile BluetoothLeManager sLeManager;
    private Context mContext;

    static {
        CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID = ParcelUuid.fromString("00002902-0000-1000-8000-00805f9b34fb");
    }

    private BluetoothLeManager(Context r8) {
        this.mContext = r8;
        getGattCentral();
        getGattPeripheral();
    }

    private AdvertiseSettings buildAdvertiseSettings(int r8, int r10) {
        AdvertiseSettings.Builder r11 = new AdvertiseSettings.Builder();
        r11.setAdvertiseMode(r8).setTxPowerLevel(r10);
        return r11.build();
    }

    private ScanSettings buildScanSettings(int r8, int r10) {
        return new ScanSettings.Builder().setScanMode(r8).setCallbackType(r10).build();
    }

    private BluetoothGattCentral getGattCentral() {
        if (sGattCentral != null) goto L6;
        sGattCentral = new BluetoothGattCentral(this.mContext);
    L6:
        return sGattCentral;
    }

    private BluetoothGattPeripheral getGattPeripheral() {
        if (sGattPeripheral != null) goto L6;
        sGattPeripheral = new BluetoothGattPeripheral(this.mContext);
    L6:
        return sGattPeripheral;
    }

    public static BluetoothLeManager getInstance(Context r8) {
        if (sLeManager != null) goto L15;
        monitor-enter(BluetoothLeManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sLeManager != null) goto L9;
        sLeManager = new BluetoothLeManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(BluetoothLeManager.class);     // Catch: Throwable -> L11
    L15:
        return sLeManager;
    }

    public AdvertiseData buildAdvertiseData(ParcelUuid r8) {
        AdvertiseData.Builder r10 = new AdvertiseData.Builder();
        r10.addServiceUuid(r8).setIncludeDeviceName(true);
        return r10.build();
    }

    public BluetoothGattService buildGattService(ParcelUuid r8, ParcelUuid r10) {
        BluetoothGattService r11 = new BluetoothGattService(r8.getUuid(), 0);
        r11.addCharacteristic(new BluetoothGattCharacteristic(r10.getUuid(), 8, 16));
        return r11;
    }

    public boolean centralConnect(BluetoothDevice r8) {
        BluetoothGattCentral r10 = sGattCentral;
        if (r10 != null) goto L5;
        return true;
    L5:
        return r10.centralConnect(r8);
    }

    public boolean centralDisconnect(BluetoothDevice r8) {
        BluetoothGattCentral r10 = sGattCentral;
        if (r10 != null) goto L5;
        return true;
    L5:
        return r10.centralDisconnect(r8);
    }

    public boolean centralReadCharacteristic(BluetoothDevice r8, ParcelUuid r10) {
        BluetoothGattCentral r11 = sGattCentral;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.centralReadCharacteristic(r8, r10);
    }

    public boolean centralWriteCharacteristic(BluetoothDevice r8, ParcelUuid r10, byte[] r11) {
        BluetoothGattCentral r12 = sGattCentral;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.centralWriteCharacteristic(r8, r10, r11);
    }

    public void cleanup() {
        BluetoothGattCentral r8 = sGattCentral;
        if (r8 == null) goto L5;
        r8.cleanup();
        sGattCentral = null;
    L5:
        BluetoothGattPeripheral r10 = sGattPeripheral;
        if (r10 == null) goto L9;
        r10.cleanup();
        sGattPeripheral = null;
        return;
    }

    public boolean closeGattServer() {
        BluetoothGattPeripheral r8 = sGattPeripheral;
        if (r8 == null) goto L6;
        r8.closeGattServer();
        return true;
    L6:
        return false;
    }

    public boolean enableNotification(BluetoothDevice r8, ParcelUuid r10) {
        BluetoothGattCentral r11 = sGattCentral;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.enableNotification(r8, r10);
    }

    public boolean openGattServer(BluetoothGattService... r8) {
        BluetoothGattPeripheral r10 = sGattPeripheral;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.openGattServer(r8);
    }

    public boolean peripheralCancelOpen(BluetoothDevice r8) {
        BluetoothGattPeripheral r10 = sGattPeripheral;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.peripheralCancelOpen(r8);
    }

    public boolean peripheralCharacteristicNotify(BluetoothDevice r8, ParcelUuid r10, byte[] r11, boolean r12) {
        BluetoothGattPeripheral r13 = sGattPeripheral;
        if (r13 != null) goto L5;
        return false;
    L5:
        return r13.peripheralCharacteristicNotify(r8, r10, r11, r12);
    }

    public boolean registerGattCentralCallback(BluetoothGattCentralCallback r8) {
        BluetoothGattCentral r10 = sGattCentral;
        if (r10 == null) goto L6;
        r10.registerGattCentralCallback(r8);
        return true;
    L6:
        return false;
    }

    public boolean registerGattPeripheralCallback(BluetoothGattPeripheralCallback r8) {
        BluetoothGattPeripheral r10 = sGattPeripheral;
        if (r10 == null) goto L6;
        r10.registerGattPeripheralCallback(r8);
        return true;
    L6:
        return false;
    }

    public boolean startAdvertising(AdvertiseData r8) {
        return startAdvertising(buildAdvertiseSettings(0, 3), r8, null);
    }

    public boolean startScan() {
        return startScan(buildScanSettings(1, 1));
    }

    public boolean stopAdvertising() {
        BluetoothGattPeripheral r8 = sGattPeripheral;
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.stopAdvertising();
    }

    public boolean stopScan() {
        BluetoothGattCentral r8 = sGattCentral;
        if (r8 != null) goto L5;
        return false;
    L5:
        return r8.stopScan();
    }

    public boolean unregisterGattCentralCallback(BluetoothGattCentralCallback r8) {
        BluetoothGattCentral r10 = sGattCentral;
        if (r10 == null) goto L6;
        r10.unregisterGattCentralCallback(r8);
        return true;
    L6:
        return false;
    }

    public boolean unregisterGattPeripheralCallback(BluetoothGattPeripheralCallback r8) {
        BluetoothGattPeripheral r10 = sGattPeripheral;
        if (r10 == null) goto L6;
        r10.unregisterGattPeripheralCallback(r8);
        return true;
    L6:
        return false;
    }

    public AdvertiseData buildAdvertiseData(ParcelUuid r8, ParcelUuid r10, byte[] r11) {
        AdvertiseData.Builder r12 = new AdvertiseData.Builder();
        r12.addServiceUuid(r8).addServiceData(r10, r11).setIncludeDeviceName(true);
        return r12.build();
    }

    public BluetoothGattService buildGattService(ParcelUuid r8, ParcelUuid r10, ParcelUuid r11, ParcelUuid r12, ParcelUuid r13) {
        BluetoothGattService r14 = new BluetoothGattService(r8.getUuid(), 0);
        if (r10 == null) goto L6;
        r14.addCharacteristic(new BluetoothGattCharacteristic(r10.getUuid(), 2, 1));
    L6:
        if (r11 == null) goto L8;
        r14.addCharacteristic(new BluetoothGattCharacteristic(r11.getUuid(), 10, 17));
    L8:
        if (r12 == null) goto L10;
        BluetoothGattCharacteristic r15 = new BluetoothGattCharacteristic(r12.getUuid(), 18, 1);
        BluetoothGattDescriptor r16 = new BluetoothGattDescriptor(CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID.getUuid(), 17);
        r16.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        r15.addDescriptor(r16);
        r14.addCharacteristic(r15);
    L10:
        if (r13 == null) goto L12;
        BluetoothGattCharacteristic r17 = new BluetoothGattCharacteristic(r13.getUuid(), 34, 1);
        BluetoothGattDescriptor r18 = new BluetoothGattDescriptor(CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID.getUuid(), 17);
        r18.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        r17.addDescriptor(r18);
        r14.addCharacteristic(r17);
    L12:
        return r14;
    }

    public boolean centralConnect(BluetoothDevice r8, boolean r10, int r11, int r12) {
        BluetoothGattCentral r13 = sGattCentral;
        if (r13 != null) goto L5;
        return false;
    L5:
        return r13.centralConnect(r8, r10, r11, r12);
    }

    public boolean startAdvertising(AdvertiseSettings r8, AdvertiseData r10, AdvertiseData r11) {
        BluetoothGattPeripheral r12 = sGattPeripheral;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.startAdvertising(r8, r10, r11);
    }

    public boolean startScan(ScanSettings r8) {
        BluetoothGattCentral r10 = sGattCentral;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.startScan(r8);
    }

    public AdvertiseData buildAdvertiseData(ParcelUuid r8, ParcelUuid r10, byte[] r11, int r12, byte[] r13, boolean r14, boolean r15) {
        AdvertiseData.Builder r16 = new AdvertiseData.Builder();
        r16.addServiceUuid(r8).addServiceData(r10, r11).addManufacturerData(r12, r13).setIncludeDeviceName(r14).setIncludeTxPowerLevel(r15);
        return r16.build();
    }
}
