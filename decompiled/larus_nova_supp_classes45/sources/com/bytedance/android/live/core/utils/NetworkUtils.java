package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class NetworkUtils {
    public static final TokenCert a = null;

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        public static final /* synthetic */ NetworkType[] a = null;
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
            NetworkType r11 = new NetworkType("MOBILE_5G", 6, 6);
            MOBILE_5G = r11;
            a = new NetworkType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) a.clone();
        }

        public static NetworkType valueOf(String r1) {
            return (NetworkType) r27.a.a(NetworkType.class, r1);
        }

        public NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkType.values().length];
            a = r0;
            r0[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[NetworkType.MOBILE_5G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[NetworkType.MOBILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        a = TokenCert.with("bpea-live_networkutils_get_network_type");
        TokenCert.with("bpea-live_networkutils_get_network_operator");
    }

    public static boolean c(Context r1) {
        NetworkType r2 = b(r1, a);
        if (NetworkType.MOBILE_2G != r2) goto L5;
    L14:
        return true;
    L5:
        if (NetworkType.MOBILE_3G == r2) goto L14;
        if (NetworkType.MOBILE_4G == r2) goto L14;
        if (NetworkType.MOBILE_5G == r2) goto L14;
        if (NetworkType.MOBILE == r2) goto L14;
        return false;
    }

    public static boolean e(Context r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        ConnectivityManager r7 = (ConnectivityManager) r6.getSystemService("connectivity");
        if (r7 != null) goto L9;
        return false;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L22;
        Network[] r1 = r7.getAllNetworks();
        if (r1 != null) goto L13;
        return false;
    L13:
        int r2 = r1.length;
        int r4 = 0;
    L14:
        if (r4 >= r2) goto L33;
        NetworkCapabilities r5 = r7.getNetworkCapabilities(r1[r4]);
        if (r5 == null) goto L21;
        if (r5.hasTransport(0) == false) goto L21;
        return true;
    L21:
        r4 = r4 + 1;
    L33:
        return false;
    L22:
        NetworkInfo[] r8 = r7.getAllNetworkInfo();
        if (r8 != null) goto L25;
        return false;
    L25:
        int r3 = r8.length;
        int r9 = 0;
    L26:
        if (r9 >= r3) goto L33;
        NetworkInfo r11 = r8[r9];
        if (r11.getType() != 0) goto L32;
        if (r11.isConnected() == false) goto L32;
        return true;
    L32:
        r9 = r9 + 1;
        goto L26
    }

    public static boolean f(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static boolean g(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAvailable() == false) goto L17;
        if (1 != r3.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static String a(Context r0, Cert r1) {
        NetworkType r2 = b(r0, r1);
        switch(a.a[r2.ordinal()]) {
            case 1: goto L11;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L13;
        };     // Catch: Exception -> L15
    L11:
        return "wifi";
    L18:
        return "mobile";
    L19:
        return "5g";
    L20:
        return "4g";
    L21:
        return "3g";
    L22:
        return "2g";
    L13:
        return "";
    }

    public static NetworkType b(Context r1, Cert r2) {
        NetworkInfo r3 = ((ConnectivityManager) r1.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L33
        if (r3 == null) goto L32;
        if (r3.isAvailable() == false) goto L32;
        int r4 = r3.getType();     // Catch: Throwable -> L33
        if (1 == r4) goto L10;
        if (r4 != 0) goto L30;
        Integer r5 = g80.g.a(r2);     // Catch: Throwable -> L33
        if (r5 == null) goto L15;
        int r6 = r5.intValue();     // Catch: Throwable -> L33
        if (r6 == 20) goto L28;
        switch(r6) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L24;
            case 7: goto L26;
            case 8: goto L24;
            case 9: goto L24;
            case 10: goto L24;
            case 11: goto L26;
            case 12: goto L24;
            case 13: goto L22;
            case 14: goto L24;
            case 15: goto L24;
            default: goto L20;
        };     // Catch: Throwable -> L33
    L20:
        return NetworkType.MOBILE;
    L22:
        return NetworkType.MOBILE_4G;
    L24:
        return NetworkType.MOBILE_3G;
    L26:
        return NetworkType.MOBILE_2G;
    L28:
        return NetworkType.MOBILE_5G;
    L15:
        return NetworkType.MOBILE;
    L30:
        return NetworkType.MOBILE;
    L10:
        return NetworkType.WIFI;
    L32:
        return NetworkType.NONE;
    L34:
        return NetworkType.MOBILE;
    }

    public static boolean d(Context r0, Cert r1) {
        NetworkType r2 = b(r0, r1);
        if (NetworkType.MOBILE_2G != r2) goto L5;
    L14:
        return true;
    L5:
        if (NetworkType.MOBILE_3G == r2) goto L14;
        if (NetworkType.MOBILE_4G == r2) goto L14;
        if (NetworkType.MOBILE_5G == r2) goto L14;
        if (NetworkType.MOBILE == r2) goto L14;
        return false;
    }
}
