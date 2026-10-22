package com.bytedance.crash.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.Global;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class Net {
    private static final int NETWORK_TYPE_2G = 3;
    private static final int NETWORK_TYPE_3G = 4;
    private static final int NETWORK_TYPE_4G = 5;
    private static final int NETWORK_TYPE_5G = 6;
    private static final int NETWORK_TYPE_MAX = 7;
    private static final int NETWORK_TYPE_MOBILE = 2;
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = 1;
    private static final String[] TYPE_NAMES = null;

    static {
        TYPE_NAMES = new String[]{"unknown", LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI, "mobile", "2g", "3g", "4g", "5g"};
    }

    public Net() {
    }

    private static ConnectivityManager getConnectivityManager(Context r2) {
        return (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");
    }

    public static String getNetworkAccessTypeName() {
        int r0 = getNetworkType();
        if (r0 < 7) goto L6;
        r0 = 0;
    L6:
        return TYPE_NAMES[r0];
    }

    private static int getNetworkType() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r0 != null) goto L6;
        return 0;
    L6:
        ConnectivityManager r2 = getConnectivityManager(r0);     // Catch: Throwable -> L32
        if (r2 != null) goto L9;
        return 0;
    L9:
        NetworkInfo r3 = r2.getActiveNetworkInfo();     // Catch: Throwable -> L32
        if (r3 == null) goto L31;
        if (r3.isAvailable() == false) goto L31;
        int r4 = r3.getType();     // Catch: Throwable -> L32
        if (1 != r4) goto L18;
        return 1;
    L18:
        if (r4 != 0) goto L30;
        switch(getTelephonyManager(r0).getNetworkType()) {
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L21;
            case 8: goto L26;
            case 9: goto L26;
            case 10: goto L26;
            case 11: goto L21;
            case 12: goto L26;
            case 13: goto L24;
            case 14: goto L26;
            case 15: goto L26;
            case 16: goto L21;
            case 17: goto L21;
            case 18: goto L21;
            case 19: goto L21;
            case 20: goto L22;
            default: goto L21;
        };
    L21:
        return 2;
    L22:
        return 6;
    L24:
        return 5;
    L26:
        return 4;
    L28:
        return 3;
    L30:
        return 2;
    L31:
        return 0;
    }

    private static TelephonyManager getTelephonyManager(Context r2) {
        return (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
    }

    public static boolean isNetworkAvailable() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L16;
        return false;
    L16:
        ConnectivityManager r1 = getConnectivityManager(r0);     // Catch: Exception -> L13
        if (r1 == null) goto L15;
        NetworkInfo r2 = r1.getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r2 == null) goto L18;
        if (r2.isAvailable() == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L15:
        return false;
    L13:
        e = move-exception;
        NpthMonitor.reportInnerException(e);
        goto L15
    }
}
