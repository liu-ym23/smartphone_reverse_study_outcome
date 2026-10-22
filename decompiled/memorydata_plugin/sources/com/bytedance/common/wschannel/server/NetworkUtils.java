package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkUtils {

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0);
            NONE = r0;
            NetworkType r1 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r1;
            NetworkType r3 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r3;
            NetworkType r5 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r5;
            NetworkType r7 = new NetworkType("WIFI", 4, 4);
            WIFI = r7;
            NetworkType r9 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r9;
            $VALUES = new NetworkType[]{r0, r1, r3, r5, r7, r9};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static NetworkType valueOf(String r2) {
            return (NetworkType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NetworkType.class, r2), NetworkType.class, "com.obric.memorydata.plugin");
        }

        public static NetworkType[] values() {
            return (NetworkType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NetworkType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.nativeInt;
        }
    }

    public static boolean a(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        if (r4.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static NetworkType b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        NetworkInfo r0 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Throwable -> L48
        if (r0 == null) goto L47;
        if (r0.isAvailable() == false) goto L47;
        int r1 = r0.getType();     // Catch: Throwable -> L48
        if (1 == r1) goto L11;
        if (r1 != 0) goto L45;
        TelephonyManager r5 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        if (r5 != null) goto L18;
        return NetworkType.MOBILE;
    L18:
        if (r5.getNetworkType() == 3) goto L43;
        if (r5.getNetworkType() == 5) goto L43;
        if (r5.getNetworkType() == 6) goto L43;
        if (r5.getNetworkType() == 8) goto L43;
        if (r5.getNetworkType() == 9) goto L43;
        if (r5.getNetworkType() == 10) goto L43;
        if (r5.getNetworkType() == 12) goto L43;
        if (r5.getNetworkType() == 14) goto L43;
        if (r5.getNetworkType() == 15) goto L43;
        if (r5.getNetworkType() != 13) goto L41;
        return NetworkType.MOBILE_4G;
    L41:
        return NetworkType.MOBILE;
    L43:
        return NetworkType.MOBILE_3G;
    L45:
        return NetworkType.MOBILE;
    L11:
        return NetworkType.WIFI;
    L47:
        return NetworkType.NONE;
    L49:
        return NetworkType.MOBILE;
    }

    static int c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        boolean r0 = a(r3);
        NetworkType r4 = b(r3);
        if (r0 == true) goto L6;
        return 2;
    L6:
        if (NetworkType.WIFI != r4) goto L9;
        return 3;
    L9:
        if (NetworkType.NONE == r4) goto L11;
        return 4;
    L11:
        return 1;
    }
}
