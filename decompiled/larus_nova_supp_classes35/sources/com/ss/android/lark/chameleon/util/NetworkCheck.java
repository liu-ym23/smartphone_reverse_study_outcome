package com.ss.android.lark.chameleon.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.CommonCmd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class NetworkCheck {
    private static final String TAG = "NetworkCheck";

    public NetworkCheck() {
    }

    public static NetworkType getNetworkState(Context r3) {
        if (r3 != null) goto L30;
        Log.i(TAG, "getNetworkState: context == null");
        return NetworkType.NETWORK_NO;
    L30:
        NetworkInfo r1 = ((ConnectivityManager) r3.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L27
        if (r1 != null) goto L9;
    L25:
        Log.i(TAG, "getNetworkState: info is null or not available.");     // Catch: Throwable -> L27
        return NetworkType.NETWORK_NO;
    L9:
        if (r1.isAvailable() == false) goto L25;
        int r2 = r1.getType();     // Catch: Throwable -> L27
        if (1 != r2) goto L15;
        Log.i(TAG, "getNetworkState: type is wifi");     // Catch: Throwable -> L27
        return NetworkType.NETWORK_WIFI;
    L15:
        if (r2 != 0) goto L24;
        Log.i(TAG, "getNetworkState: type is mobile");     // Catch: Throwable -> L27
        switch(((TelephonyManager) r3.getSystemService(CommonCmd.AIDL_PLATFORM_TYPE_PHONE)).getNetworkType()) {
            case 3: goto L22;
            case 4: goto L31;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L31;
            case 8: goto L22;
            case 9: goto L22;
            case 10: goto L22;
            case 11: goto L31;
            case 12: goto L22;
            case 13: goto L20;
            case 14: goto L22;
            case 15: goto L22;
            default: goto L31;
        };     // Catch: Throwable -> L27
    L31:
        return NetworkType.NETWORK_MOBILE;
    L20:
        return NetworkType.NETWORK_4G;
    L22:
        return NetworkType.NETWORK_3G;
    L24:
        return NetworkType.NETWORK_MOBILE;
    L27:
        th = move-exception;
        Log.e("network", th.getMessage());
        return NetworkType.NETWORK_UNKNOWN;
    }
}
