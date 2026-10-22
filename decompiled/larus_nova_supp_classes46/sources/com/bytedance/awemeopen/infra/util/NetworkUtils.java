package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class NetworkUtils {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/awemeopen/infra/util/NetworkUtils$NetworkType;", "", "", "value", "I", "getValue", "()I", "NONE", "MOBILE", "MOBILE_2G", "MOBILE_3G", "WIFI", "MOBILE_4G", "MOBILE_5G", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType MOBILE_5G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        public static final /* synthetic */ NetworkType[] a = null;
        private final int value;

        public static NetworkType valueOf(String r1) {
            return (NetworkType) r27.a.a(NetworkType.class, r1);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) a.clone();
        }

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

        public final int getValue() {
            return this.value;
        }

        public NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
    }

    @JvmStatic
    public static final NetworkType a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((r2 instanceof Activity) == false) goto L27;
        r2 = ((Activity) r2).getApplicationContext();
    L27:
        Object r0 = r2.getSystemService("connectivity");     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Throwable -> L25
        NetworkInfo r1 = ((ConnectivityManager) r0).getActiveNetworkInfo();     // Catch: Throwable -> L25
        if (r1 == null) goto L24;
        if (r1.isAvailable() == false) goto L24;
        int r3 = r1.getType();     // Catch: Throwable -> L25
        if (1 == r3) goto L28;
        if (r3 != 0) goto L34;
        Object r4 = r2.getSystemService("phone");     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: Throwable -> L25
        int r5 = ((TelephonyManager) r4).getNetworkType();     // Catch: Throwable -> L25
        if (r5 == 20) goto L33;
        switch(r5) {
            case 1: goto L32;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L32;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L31;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            case 14: goto L31;
            case 15: goto L31;
            default: goto L29;
        };     // Catch: Throwable -> L25
    L29:
        return NetworkType.MOBILE;
    L30:
        return NetworkType.MOBILE_4G;
    L31:
        return NetworkType.MOBILE_3G;
    L32:
        return NetworkType.MOBILE_2G;
    L33:
        return NetworkType.MOBILE_5G;
    L34:
        return NetworkType.MOBILE;
    L28:
        return NetworkType.WIFI;
    L24:
        return NetworkType.NONE;
    L26:
        return NetworkType.MOBILE;
    }

    @JvmStatic
    public static final boolean b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((r2 instanceof Activity) == false) goto L13;
        r2 = ((Activity) r2).getApplicationContext();
    L13:
        Object r3 = r2.getSystemService("connectivity");     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L12
        NetworkInfo r4 = ((ConnectivityManager) r3).getActiveNetworkInfo();     // Catch: Exception -> L12
        if (r4 == null) goto L15;
        if (r4.isAvailable() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L17:
        return false;
    }
}
