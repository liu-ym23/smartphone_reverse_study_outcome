package s4;

import com.bytedance.common.utility.NetworkUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkUtils.NetworkType.values().length];
            r0[NetworkUtils.NetworkType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r0[NetworkUtils.NetworkType.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r0[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[NetworkUtils.NetworkType.MOBILE_3G_H.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r0[NetworkUtils.NetworkType.MOBILE_3G_HP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r0[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[NetworkUtils.NetworkType.MOBILE_5G.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[NetworkUtils.NetworkType.WIFI.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[NetworkUtils.NetworkType.WIFI_24GHZ.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r0[NetworkUtils.NetworkType.WIFI_5GHZ.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            a = r0;
        }
    }

    static {
    }

    public static String a(NetworkUtils.NetworkType r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
        switch(a.a[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return "unknown";
    L5:
        return "wifi";
    L6:
        return "5g";
    L7:
        return "4g";
    L8:
        return "3g";
    L9:
        return "2g";
    L10:
        return "mobile";
    L11:
        return "none";
    }
}
