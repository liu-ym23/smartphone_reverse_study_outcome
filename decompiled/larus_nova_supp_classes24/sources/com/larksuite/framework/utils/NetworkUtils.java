package com.larksuite.framework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class NetworkUtils {

    public static final enum CompressType extends Enum<CompressType> {
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        public static final /* synthetic */ CompressType[] a = null;
        final int nativeInt;

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            a = new CompressType[]{r0, r1, r3};
        }

        public static CompressType[] values() {
            return (CompressType[]) a.clone();
        }

        public static CompressType valueOf(String r1) {
            return (CompressType) r27.a.a(CompressType.class, r1);
        }

        public CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        public static final /* synthetic */ NetworkType[] a = null;
        final int nativeInt;
        private final String nativeName;

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0, "unvailable");
            NONE = r0;
            NetworkType r1 = new NetworkType("MOBILE", 1, 1, "mobile");
            MOBILE = r1;
            NetworkType r2 = new NetworkType("MOBILE_2G", 2, 2, "mobile_2g");
            MOBILE_2G = r2;
            NetworkType r4 = new NetworkType("MOBILE_3G", 3, 3, "mobile_3g");
            MOBILE_3G = r4;
            NetworkType r6 = new NetworkType("WIFI", 4, 4, "wifi");
            WIFI = r6;
            NetworkType r8 = new NetworkType("MOBILE_4G", 5, 5, "mobile_4g");
            MOBILE_4G = r8;
            NetworkType r10 = new NetworkType("MOBILE_5G", 6, 6, "mobile_5g");
            MOBILE_5G = r10;
            NetworkType r12 = new NetworkType("UNKNOWN", 7, 7, "unknown");
            UNKNOWN = r12;
            a = new NetworkType[]{r0, r1, r2, r4, r6, r8, r10, r12};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) a.clone();
        }

        public String getNativeName() {
            return this.nativeName;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType valueOf(String r1) {
            return (NetworkType) r27.a.a(NetworkType.class, r1);
        }

        public NetworkType(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.nativeInt = r3;
            this.nativeName = r4;
        }
    }

    public static NetworkType a(int r0) {
        switch(r0) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L8;
            case 14: goto L10;
            case 15: goto L10;
            case 16: goto L12;
            case 17: goto L4;
            case 18: goto L10;
            case 19: goto L4;
            case 20: goto L6;
            default: goto L4;
        };
    L4:
        return NetworkType.MOBILE;
    L6:
        return NetworkType.MOBILE_5G;
    L8:
        return NetworkType.MOBILE_4G;
    L10:
        return NetworkType.MOBILE_3G;
    L12:
        return NetworkType.MOBILE_2G;
    }

    public static NetworkType b(Context r7) {
        ConnectivityManager r3 = (ConnectivityManager) r7.getApplicationContext().getSystemService("connectivity");     // Catch: Throwable -> L43
        NetworkInfo r4 = r3.getActiveNetworkInfo();     // Catch: Throwable -> L43
        if (r4 != null) goto L6;
    L39:
        int r5 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L43
        Log.i("NetworkUtils", "old getNetworkType info == null || !info.isAvailable(), apinum is " + r5);     // Catch: Throwable -> L43
        NetworkType r8 = c(r7);     // Catch: Throwable -> L43
        if (r8 == NetworkType.NONE) goto L42;
        Log.e("NetworkUtils", "new getNetworkType correct nettype, apinum is " + r5, null, true);     // Catch: Throwable -> L43
    L42:
        return r8;
    L6:
        if (r4.isAvailable() == false) goto L39;
        int r0 = r4.getType();     // Catch: Throwable -> L43
        if (1 == r0) goto L11;
        if (r0 != 0) goto L38;
        if (Build.VERSION.SDK_INT <= 29) goto L36;
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L43
        Network[] r1 = r3.getAllNetworks();     // Catch: Throwable -> L43
        int r2 = r1.length;     // Catch: Throwable -> L43
        int r6 = 0;
    L16:
        if (r6 >= r2) goto L26;
        NetworkInfo r10 = r3.getNetworkInfo(r1[r6]);     // Catch: Throwable -> L43
        if (r10 == null) goto L25;
        NetworkInfo.State r11 = r10.getState();     // Catch: Throwable -> L43
        if (r11 != NetworkInfo.State.CONNECTING) goto L23;
    L24:
        r9.add(r10);     // Catch: Throwable -> L43
        goto L25
    L23:
        if (r11 == NetworkInfo.State.CONNECTED) goto L24;
    L25:
        r6 = r6 + 1;     // Catch: Throwable -> L43
        goto L16
    L26:
        Iterator r12 = r9.iterator();     // Catch: Throwable -> L43
    L28:
        if (r12.hasNext() == false) goto L34;
        NetworkInfo r13 = (NetworkInfo) r12.next();     // Catch: Throwable -> L43
        if ("MOBILE".equals(r13.getTypeName()) == false) goto L28;
        return a(r13.getSubtype());
    L34:
        return NetworkType.MOBILE;
    L36:
        return a(((TelephonyManager) r7.getSystemService("phone")).getNetworkType());
    L38:
        return NetworkType.MOBILE;
    L11:
        return NetworkType.WIFI;
    L43:
        th = move-exception;
        Log.e("network", th.getMessage());
        return NetworkType.MOBILE;
    }

    public static NetworkType c(Context r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        Log.i("NetworkUtils", "current os verion < M，cannot support this method judge network!");
        return NetworkType.NONE;
    L6:
        ConnectivityManager r4 = (ConnectivityManager) r3.getApplicationContext().getSystemService("connectivity");
        Network r0 = r4.getActiveNetwork();
        if (r0 != null) goto L10;
        Log.w("NetworkUtils", "ConnectivityManager.getActiveNetwork return null");
        return NetworkType.NONE;
    L10:
        NetworkCapabilities r5 = r4.getNetworkCapabilities(r0);
        if (r5 == null) goto L17;
        if (r5.hasTransport(0) == false) goto L17;
        return NetworkType.MOBILE_4G;
    L17:
        return NetworkType.WIFI;
    }

    public static boolean d(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
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

    public static boolean e(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
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
}
