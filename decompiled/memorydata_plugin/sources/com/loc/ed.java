package com.loc;

import android.net.wifi.WifiInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class ed {
    public static String a(WifiInfo r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getBSSID();
    }

    public static String b(WifiInfo r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getSSID();
    }

    public static int c(WifiInfo r0) {
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getRssi();
    }
}
