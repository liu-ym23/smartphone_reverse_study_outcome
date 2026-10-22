package com.bytedance.common.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f1959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static NetworkType f1960b;
    private static boolean c;
    private static long d;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            $VALUES = new CompressType[]{r0, r1, r3};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static CompressType valueOf(String r2) {
            return (CompressType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CompressType.class, r2), CompressType.class, "com.obric.memorydata.plugin");
        }

        public static CompressType[] values() {
            return (CompressType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CompressType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_3G_H = null;
        public static final NetworkType MOBILE_3G_HP = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        public static final NetworkType WIFI_24GHZ = null;
        public static final NetworkType WIFI_5GHZ = null;
        final int nativeInt;

        static {
            NetworkType r0 = new NetworkType("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            NetworkType r1 = new NetworkType("NONE", 1, 0);
            NONE = r1;
            NetworkType r3 = new NetworkType("MOBILE", 2, 1);
            MOBILE = r3;
            NetworkType r5 = new NetworkType("MOBILE_2G", 3, 2);
            MOBILE_2G = r5;
            NetworkType r7 = new NetworkType("MOBILE_3G", 4, 3);
            MOBILE_3G = r7;
            NetworkType r9 = new NetworkType("WIFI", 5, 4);
            WIFI = r9;
            NetworkType r11 = new NetworkType("MOBILE_4G", 6, 5);
            MOBILE_4G = r11;
            NetworkType r13 = new NetworkType("MOBILE_5G", 7, 6);
            MOBILE_5G = r13;
            NetworkType r15 = new NetworkType("WIFI_24GHZ", 8, 7);
            WIFI_24GHZ = r15;
            NetworkType r14 = new NetworkType("WIFI_5GHZ", 9, 8);
            WIFI_5GHZ = r14;
            NetworkType r12 = new NetworkType("MOBILE_3G_H", 10, 9);
            MOBILE_3G_H = r12;
            NetworkType r10 = new NetworkType("MOBILE_3G_HP", 11, 10);
            MOBILE_3G_HP = r10;
            $VALUES = new NetworkType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
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

        public boolean is2G() {
            if (this != MOBILE) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_2G) goto L8;
            return false;
        }

        public boolean is3GOrHigher() {
            if (this != MOBILE_3G) goto L5;
        L14:
            return true;
        L5:
            if (this == MOBILE_3G_H) goto L14;
            if (this == MOBILE_3G_HP) goto L14;
            if (this == MOBILE_4G) goto L14;
            if (this == MOBILE_5G) goto L14;
            return false;
        }

        public boolean is4GOrHigher() {
            if (this != MOBILE_4G) goto L5;
        L8:
            return true;
        L5:
            if (this == MOBILE_5G) goto L8;
            return false;
        }

        public boolean isAvailable() {
            if (this != UNKNOWN) goto L5;
        L7:
            return false;
        L5:
            if (this == NONE) goto L7;
            return true;
        }

        public boolean isWifi() {
            if (this != WIFI) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public interface a {
        NetworkType a();
    }

    static {
        f1960b = NetworkType.UNKNOWN;
        c = false;
        d = 0;
    }

    private static String a(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String a(List<Pair<String, String>> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L14;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin");
        String r3 = a((String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.memorydata.plugin"), r6);
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.second, String.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        String r9 = a(r4, r6);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append("&");
    L12:
        r0.append(r3);
        r0.append("=");
        r0.append(r9);
        goto L4
    L8:
        r9 = "";
        goto L10
    L14:
        return r0.toString();
    }

    static void a(NetworkType r0) {
        f1960b = r0;
    }

    public static boolean a(Context r4) {
        NetworkInfo r5 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.isAvailable() == false) goto L24;
        a r1 = f1959a;     // Catch: Exception -> L20
        if (r1 == null) goto L17;
        if (r1.a() == NetworkType.NONE) goto L17;
        if (f1959a.a() == NetworkType.WIFI) goto L15;
        return false;
    L15:
        return true;
    L17:
        if (1 == r5.getType()) goto L19;
        return false;
    L19:
        return true;
    L24:
        return false;
    L26:
        return false;
    }

    public static String b(NetworkType r1) {
        if (r1 != NetworkType.WIFI) goto L6;
        return LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI;
    L6:
        if (r1 != NetworkType.WIFI_24GHZ) goto L9;
        return "wifi24ghz";
    L9:
        if (r1 != NetworkType.WIFI_5GHZ) goto L12;
        return "wifi5ghz";
    L12:
        if (r1 != NetworkType.MOBILE_2G) goto L15;
        return "2g";
    L15:
        if (r1 != NetworkType.MOBILE_3G) goto L18;
        return "3g";
    L18:
        if (r1 != NetworkType.MOBILE_3G_H) goto L21;
        return "3gh";
    L21:
        if (r1 != NetworkType.MOBILE_3G_HP) goto L24;
        return "3ghp";
    L24:
        if (r1 != NetworkType.MOBILE_4G) goto L27;
        return "4g";
    L27:
        if (r1 != NetworkType.MOBILE_5G) goto L30;
        return "5g";
    L30:
        if (r1 != NetworkType.MOBILE) goto L32;
        return "mobile";
    L32:
        return "";
    }

    public static boolean b(Context r3) {
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

    public static NetworkType c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        g(r3);
        h(r3);
        return f1960b;
    }

    public static boolean d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        g(r3);
        h(r3);
        return f1960b.isAvailable();
    }

    public static NetworkType e(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        NetworkInfo r0 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Throwable -> L35
        if (r0 == null) goto L34;
        if (r0.isAvailable() == false) goto L34;
        int r1 = r0.getType();     // Catch: Throwable -> L35
        if (1 == r1) goto L11;
        if (r1 != 0) goto L32;
        int r5 = ((TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin")).getNetworkType();     // Catch: Throwable -> L35
        if (r5 == 3) goto L30;
        if (r5 == 20) goto L28;
        if (r5 == 5) goto L30;
        if (r5 == 6) goto L30;
        switch(r5) {
            case 8: goto L30;
            case 9: goto L30;
            case 10: goto L30;
            default: goto L22;
        };     // Catch: Throwable -> L35
    L22:
        switch(r5) {
            case 12: goto L30;
            case 13: goto L26;
            case 14: goto L30;
            case 15: goto L30;
            default: goto L24;
        };     // Catch: Throwable -> L35
    L24:
        return NetworkType.MOBILE;
    L26:
        return NetworkType.MOBILE_4G;
    L28:
        return NetworkType.MOBILE_5G;
    L30:
        return NetworkType.MOBILE_3G;
    L32:
        return NetworkType.MOBILE;
    L11:
        return NetworkType.WIFI;
    L34:
        return NetworkType.NONE;
    L36:
        return NetworkType.MOBILE;
    }

    public static String f(Context r2) {
        return b(e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")));
    }

    private static void g(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        a r0 = f1959a;
        if (r0 != null) goto L5;
    L8:
        registerReceiver(r3);
        if (f1960b != NetworkType.UNKNOWN) goto L12;
        f1960b = e(r3);
        return;
    L12:
        return;
    L5:
        if (r0.a() == NetworkType.NONE) goto L8;
        f1960b = f1959a.a();
    }

    private static void h(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if ((System.currentTimeMillis() - d) <= 2000) goto L6;
        f1960b = e(r5);
        d = System.currentTimeMillis();
        return;
    }

    private static void registerReceiver(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (c == true) goto L7;
        if (r4 == null) goto L8;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), new g(), r0, "com.obric.memorydata.plugin");
        c = true;
        return;
    L8:
        return;
    }
}
