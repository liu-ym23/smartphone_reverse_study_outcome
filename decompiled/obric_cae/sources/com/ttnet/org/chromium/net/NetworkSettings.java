package com.ttnet.org.chromium.net;

import android.util.Log;
import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes2.dex */
class NetworkSettings {
    private static final String TAG = "NetworkSettings";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static volatile boolean sPrivateApiAccessEnabled;

    public NetworkSettings() {
    }

    public static boolean isPrivateApiAccessEnabled() {
        if (sPrivateApiAccessEnabled == false) goto L10;
        return true;
    L10:
        String r8 = TTNetInit.DOMAIN_HTTPDNS_KEY;     // Catch: Throwable -> L7
        sPrivateApiAccessEnabled = ((Boolean) TTNetInit.class.getMethod("isPrivateApiAccessEnabled", new Class[0]).invoke(null, new Object[0])).booleanValue();     // Catch: Throwable -> L7
        Log.i(TAG, "Private Api access enabled: " + sPrivateApiAccessEnabled);     // Catch: Throwable -> L7
        return sPrivateApiAccessEnabled;
    L7:
        th = move-exception;
        th.printStackTrace();
        return true;
    }
}
