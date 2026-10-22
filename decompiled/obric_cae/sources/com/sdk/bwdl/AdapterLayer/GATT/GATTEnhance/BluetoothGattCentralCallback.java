package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BluetoothGattCentralCallback {
    public BluetoothGattCentralCallback() {
    }

    public void onCharacteristicChanged(BluetoothGatt r8, BluetoothGattCharacteristic r10) {
    }

    public void onCharacteristicRead(BluetoothGatt r8, BluetoothGattCharacteristic r10, int r11) {
    }

    public void onCharacteristicWrite(BluetoothGatt r8, BluetoothGattCharacteristic r10, int r11) {
    }

    public void onConnectionStateChange(BluetoothGatt r8, int r10, int r11) {
    }

    public void onDescriptorWrite(BluetoothGatt r8, BluetoothGattDescriptor r10, int r11) {
    }

    public void onDeviceFound(BluetoothDevice r8) {
    }

    public void onScanFailed(int r8) {
    }

    public void onServiceDiscovered(BluetoothGatt r8, int r10) {
    }
}
