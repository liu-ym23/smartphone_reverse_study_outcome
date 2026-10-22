package com.obric.cae.smartBluetooth.callback;

import android.bluetooth.BluetoothDevice;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface SmartBluetoothEventCallback {
    default void onA2dpPlayingStateChangeEventCallback(BluetoothDevice r8, int r10) {
    }

    default void onA2dpStateChangeEventCallback(BluetoothDevice r8, int r10) {
    }

    default void onAclStateChangeEventCallback(BluetoothDevice r8, boolean r10) {
    }

    default void onAdapterStateChangeCallback(int r8) {
    }

    default void onBleAdapterStateChangeCallback(int r8, int r10) {
    }

    default void onBondStateChangeCallback(BluetoothDevice r8, int r10, int r11, int r12) {
    }

    default void onBrDeviceFoundCallback(BluetoothDevice r8, int r10, int r11) {
    }

    default void onDeviceUuidsFoundCallback(BluetoothDevice r8, Parcelable[] r10) {
    }

    default void onDiscoverStateChangeCallback(boolean r8) {
    }

    default void onHfpScoStateChangeEventCallback(BluetoothDevice r8, int r10) {
    }

    default void onHfpStateChangeEventCallback(BluetoothDevice r8, int r10) {
    }

    default void onHidStateChangeEventCallback(BluetoothDevice r8, int r10) {
    }

    default void onScreenStateChangeCallback(boolean r8) {
    }
}
