package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BluetoothGattPeripheralCallback {
    public BluetoothGattPeripheralCallback() {
    }

    public void onCharacteristicRead(BluetoothDevice r8, BluetoothGattCharacteristic r10) {
    }

    public void onCharacteristicWrite(BluetoothDevice r8, BluetoothGattCharacteristic r10, byte[] r11) {
    }

    public void onConnectionStateChange(BluetoothDevice r8, int r10, int r11) {
    }

    public void onNotificationSent(BluetoothDevice r8, int r10) {
    }

    public void onOpenFailed(int r8, BluetoothGattService r10) {
    }

    public void onOpenSuccess(BluetoothGattService r8) {
    }

    public void onStartFailed(int r8) {
    }

    public void onStartSuccess() {
    }
}
