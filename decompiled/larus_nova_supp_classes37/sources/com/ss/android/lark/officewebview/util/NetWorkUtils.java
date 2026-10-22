package com.ss.android.lark.officewebview.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NetWorkUtils {

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
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
            a = new NetworkType[]{r0, r1, r3, r5, r7, r9};
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
            r0[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[NetworkType.MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static boolean a() {
        int r0 = com.ss.android.lark.officesdk.utils.di.g.a;
        boolean r1 = com.ss.android.lark.officesdk.utils.di.g.a.a("openflatform.web.allow.report.network.status");
        com.ss.android.lark.officesdk.utils.di.j.e("NetWorkUtils", "allow Report web network status:" + r1);
        return r1;
    }

    public static String c() {
        if (a() == true) goto L45;
        return "";
    L45:
        NetworkInfo r2 = ((ConnectivityManager) com.ss.android.lark.officesdk.utils.di.d.a().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r2 != null) goto L9;
    L22:
        NetworkType r3 = NetworkType.NONE;     // Catch: Throwable -> L24
    L44:
    L47:
        int r4 = a.a[r3.ordinal()];     // Catch: Exception -> L43
        if (r4 != 1) goto L28;
        String r0 = "wifi";
    L42:
        return r0;
    L28:
        if (r4 != 2) goto L30;
        r0 = "2g";
        goto L42
    L30:
        if (r4 != 3) goto L32;
        r0 = "3g";
        goto L42
    L32:
        if (r4 != 4) goto L34;
        r0 = "4g";
        goto L42
    L34:
        if (r4 != 5) goto L49;
        r0 = "mobile";
        goto L42
    L49:
        return "";
    L50:
        return "";
    L9:
        if (r2.isAvailable() == false) goto L22;
        int r5 = r2.getType();     // Catch: Throwable -> L24
        if (1 != r5) goto L14;
        r3 = NetworkType.WIFI;     // Catch: Throwable -> L24
        goto L44
    L14:
        if (r5 == 0) goto L16;
        r3 = NetworkType.MOBILE;     // Catch: Throwable -> L24
        goto L44
    L16:
        switch(((TelephonyManager) com.ss.android.lark.officesdk.utils.di.d.a().getSystemService("phone")).getNetworkType()) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L17;
        };     // Catch: Throwable -> L24
    L17:
        r3 = NetworkType.MOBILE;     // Catch: Throwable -> L24
        goto L44
    L18:
        r3 = NetworkType.MOBILE_4G;     // Catch: Throwable -> L24
        goto L44
    L19:
        r3 = NetworkType.MOBILE_3G;     // Catch: Throwable -> L24
        goto L44
    L20:
        r3 = NetworkType.MOBILE_2G;     // Catch: Throwable -> L24
    L24:
        r3 = NetworkType.MOBILE;
        goto L47
    }

    public static Process b(Runtime r12, String r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(102900, "java/lang/Runtime", "exec", r12, r9, "java.lang.Process", r10);
        if (r11.a == false) goto L6;
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, null, r10, false);
        return (Process) r11.b;
    L6:
        Process r14 = r12.exec(r13);
        r8.a(102900, "java/lang/Runtime", "exec", r12, r9, r14, r10, true);
        return r14;
    }
}
