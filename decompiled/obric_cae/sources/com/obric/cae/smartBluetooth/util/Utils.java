package com.obric.cae.smartBluetooth.util;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public Utils() {
    }

    public static String maskBluetoothAddress(String r8) {
        if (r8 != null) goto L4;
        return r8;
    L4:
        if (r8.length() >= 17) goto L7;
        return r8;
    L7:
        return "XX:XX:XX" + r8.substring(8);
    }
}
