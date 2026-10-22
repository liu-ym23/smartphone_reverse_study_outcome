package com.sdk.bwdl.AdapterLayer.BleAdv;

import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertisingSetCallback;
import android.bluetooth.le.AdvertisingSetParameters;
import android.bluetooth.le.PeriodicAdvertisingParameters;
import android.os.ParcelUuid;

/* JADX INFO: loaded from: classes2.dex */
public interface BleExtendAdvHelper {
    void setInterval(int r8);

    void setTxPowerLevel(int r8);

    void startAdvertisingSet(AdvertisingSetCallback r8);

    void startAdvertisingSet(AdvertisingSetParameters r8, AdvertiseData r10, AdvertiseData r11, PeriodicAdvertisingParameters r12, AdvertiseData r13, AdvertisingSetCallback r14);

    void stopAdvertisingSet(AdvertisingSetCallback r8);

    void updateAdvertisingSetServiceData(ParcelUuid r8, byte[] r10);

    void updateAdvertisingSetServiceData(byte[] r8);
}
