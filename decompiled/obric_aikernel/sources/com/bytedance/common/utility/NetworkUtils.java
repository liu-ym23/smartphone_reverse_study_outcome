package com.bytedance.common.utility;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f1254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static NetworkType f1255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f1256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f1257d;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r10 = new CompressType("NONE", 0, 0);
            NONE = r10;
            CompressType r11 = new CompressType("GZIP", 1, 1);
            GZIP = r11;
            CompressType r12 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r12;
            $VALUES = new CompressType[]{r10, r11, r12};
        }

        private CompressType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static CompressType valueOf(String r10) {
            return (CompressType) Enum.valueOf(CompressType.class, r10);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
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
            NetworkType r10 = new NetworkType("UNKNOWN", 0, -1);
            UNKNOWN = r10;
            NetworkType r11 = new NetworkType("NONE", 1, 0);
            NONE = r11;
            NetworkType r12 = new NetworkType("MOBILE", 2, 1);
            MOBILE = r12;
            NetworkType r13 = new NetworkType("MOBILE_2G", 3, 2);
            MOBILE_2G = r13;
            NetworkType r14 = new NetworkType("MOBILE_3G", 4, 3);
            MOBILE_3G = r14;
            NetworkType r15 = new NetworkType("WIFI", 5, 4);
            WIFI = r15;
            NetworkType r16 = new NetworkType("MOBILE_4G", 6, 5);
            MOBILE_4G = r16;
            NetworkType r17 = new NetworkType("MOBILE_5G", 7, 6);
            MOBILE_5G = r17;
            NetworkType r18 = new NetworkType("WIFI_24GHZ", 8, 7);
            WIFI_24GHZ = r18;
            NetworkType r19 = new NetworkType("WIFI_5GHZ", 9, 8);
            WIFI_5GHZ = r19;
            NetworkType r110 = new NetworkType("MOBILE_3G_H", 10, 9);
            MOBILE_3G_H = r110;
            NetworkType r111 = new NetworkType("MOBILE_3G_HP", 11, 10);
            MOBILE_3G_HP = r111;
            $VALUES = new NetworkType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
        }

        private NetworkType(String r10, int r11, int r12) {
            super(r10, r11);
            this.nativeInt = r12;
        }

        public static NetworkType valueOf(String r10) {
            return (NetworkType) Enum.valueOf(NetworkType.class, r10);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
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
        f1255b = NetworkType.UNKNOWN;
        f1256c = false;
        f1257d = 0;
    }

    private static void a(Context r10) {
        if ((System.currentTimeMillis() - f1257d) <= 2000) goto L6;
        f1255b = e(r10);
        f1257d = System.currentTimeMillis();
        return;
    }

    private static void b(Context r10) {
        a r11 = f1254a;
        if (r11 != null) goto L5;
    L8:
        i(r10);
        if (f1255b != NetworkType.UNKNOWN) goto L12;
        f1255b = e(r10);
        return;
    L12:
        return;
    L5:
        if (r11.a() == NetworkType.NONE) goto L8;
        f1255b = f1254a.a();
    }

    public static String c(Context r10) {
        return d(e(r10));
    }

    public static String d(NetworkType r10) {
        if (r10 != NetworkType.WIFI) goto L6;
        return "wifi";
    L6:
        if (r10 != NetworkType.WIFI_24GHZ) goto L9;
        return "wifi24ghz";
    L9:
        if (r10 != NetworkType.WIFI_5GHZ) goto L12;
        return "wifi5ghz";
    L12:
        if (r10 != NetworkType.MOBILE_2G) goto L15;
        return "2g";
    L15:
        if (r10 != NetworkType.MOBILE_3G) goto L18;
        return "3g";
    L18:
        if (r10 != NetworkType.MOBILE_3G_H) goto L21;
        return "3gh";
    L21:
        if (r10 != NetworkType.MOBILE_3G_HP) goto L24;
        return "3ghp";
    L24:
        if (r10 != NetworkType.MOBILE_4G) goto L27;
        return "4g";
    L27:
        if (r10 != NetworkType.MOBILE_5G) goto L30;
        return "5g";
    L30:
        if (r10 != NetworkType.MOBILE) goto L32;
        return "mobile";
    L32:
        return "";
    }

    public static NetworkType e(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L34
        if (r11 == null) goto L33;
        if (r11.isAvailable() == false) goto L33;
        int r12 = r11.getType();     // Catch: Throwable -> L34
        if (1 == r12) goto L10;
        if (r12 != 0) goto L31;
        int r13 = ((TelephonyManager) r10.getSystemService("phone")).getNetworkType();     // Catch: Throwable -> L34
        if (r13 == 3) goto L29;
        if (r13 == 20) goto L27;
        if (r13 == 5) goto L29;
        if (r13 == 6) goto L29;
        switch(r13) {
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            default: goto L21;
        };     // Catch: Throwable -> L34
    L21:
        switch(r13) {
            case 12: goto L29;
            case 13: goto L25;
            case 14: goto L29;
            case 15: goto L29;
            default: goto L23;
        };     // Catch: Throwable -> L34
    L23:
        return NetworkType.MOBILE;
    L25:
        return NetworkType.MOBILE_4G;
    L27:
        return NetworkType.MOBILE_5G;
    L29:
        return NetworkType.MOBILE_3G;
    L31:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L33:
        return NetworkType.NONE;
    L35:
        return NetworkType.MOBILE;
    }

    public static NetworkType f(Context r10) {
        b(r10);
        a(r10);
        return f1255b;
    }

    public static boolean g(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r11 == null) goto L12;
        if (r11.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean h(Context r10) {
        b(r10);
        a(r10);
        return f1255b.isAvailable();
    }

    private static void i(Context r10) {
        if (f1256c == true) goto L7;
        if (r10 == null) goto L8;
        IntentFilter r11 = new IntentFilter();
        r11.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r11.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r11.addAction("android.net.wifi.STATE_CHANGE");
        r10.getApplicationContext().registerReceiver(new f(), r11);
        f1256c = true;
        return;
    L8:
        return;
    }

    static void j(NetworkType r10) {
        f1255b = r10;
    }
}
