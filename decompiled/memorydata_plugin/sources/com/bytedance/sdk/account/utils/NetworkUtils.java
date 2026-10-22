package com.bytedance.sdk.account.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.ss.android.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

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

    public static g a(int r2, String r3, List<com.ss.android.f> r4) {
        List<com.ss.android.f> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        com.bytedance.sdk.account.d r0 = com.ss.android.account.d.a().c();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r2, r3, r5);
    }

    public static g a(int r9, String r10, Map<String, String> r11, String r12, String r13, List<com.ss.android.f> r14) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        List<com.ss.android.f> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        com.bytedance.sdk.account.d r2 = com.ss.android.account.d.a().c();
        if (r2 != null) goto L5;
        return null;
    L5:
        return r2.a(r9, r10, r5, r12, r13, r8);
    }

    public static g a(int r2, String r3, Map<String, String> r4, List<com.ss.android.f> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        List<com.ss.android.f> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        com.bytedance.sdk.account.d r0 = com.ss.android.account.d.a().c();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r2, r3, r6, r7);
    }

    public static boolean a(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r4 == null) goto L12;
        if (r4.isConnected() == false) goto L13;
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
        NetworkInfo r0 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r0 == null) goto L23;
        if (r0.isAvailable() == false) goto L23;
        int r1 = r0.getType();     // Catch: Throwable -> L24
        if (1 == r1) goto L11;
        if (r1 != 0) goto L21;
        switch(((TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin")).getNetworkType()) {
            case 3: goto L19;
            case 4: goto L27;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L27;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L27;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L27;
        };     // Catch: Throwable -> L24
    L27:
        return NetworkType.MOBILE;
    L17:
        return NetworkType.MOBILE_4G;
    L19:
        return NetworkType.MOBILE_3G;
    L21:
        return NetworkType.MOBILE;
    L11:
        return NetworkType.WIFI;
    L23:
        return NetworkType.NONE;
    L25:
        return NetworkType.MOBILE;
    }
}
