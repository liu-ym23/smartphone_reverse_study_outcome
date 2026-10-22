package com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothLeAnnotations {
    public static final int ADVERTISE_MODE_BALANCED = 1;
    public static final int ADVERTISE_MODE_LOW_LATENCY = 2;
    public static final int ADVERTISE_MODE_LOW_POWER = 0;
    public static final int ADVERTISE_TX_POWER_HIGH = 3;
    public static final int ADVERTISE_TX_POWER_LOW = 1;
    public static final int ADVERTISE_TX_POWER_MEDIUM = 2;
    public static final int ADVERTISE_TX_POWER_ULTRA_LOW = 0;
    public static final int CALLBACK_TYPE_ALL_MATCHES = 1;
    public static final int CALLBACK_TYPE_FIRST_MATCH = 2;
    public static final int CALLBACK_TYPE_MATCH_LOST = 4;
    public static final int CALLBACK_TYPE_SENSOR_ROUTING = 8;
    public static final int SCAN_MODE_BALANCED = 1;
    public static final int SCAN_MODE_LOW_LATENCY = 2;
    public static final int SCAN_MODE_LOW_POWER = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdvertiseMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdvertiseTxPowerLevel {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CallbackType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScanMode {
    }

    private BluetoothLeAnnotations() {
    }
}
