package com.obric.cae.smartBluetooth.btaware;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static final int EVENT_BLE_DISCONNECTED = 4;
    public static final int EVENT_CHARACTERISTIC_CHANGED = 2;
    public static final int EVENT_CHARACTERISTIC_WRITE_COMPLETE = 3;
    public static final int EVENT_GATT_CONNECTED = 1;
    public static final CopyOnWriteArrayList<String> sCarKeyAppName = null;

    static {
        CopyOnWriteArrayList<String> r8 = new CopyOnWriteArrayList();
        sCarKeyAppName = r8;
        r8.add("com.example.bluetoothtesttool");
        r8.add("com.chehejia.oc.m01");
    }

    public Utils() {
    }
}
