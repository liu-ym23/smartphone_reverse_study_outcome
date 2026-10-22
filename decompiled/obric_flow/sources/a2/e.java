package a2;

import com.bytedance.common.utility.NetworkUtils$NetworkType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f59a = null;

    static {
        int[] r5 = new int[NetworkUtils$NetworkType.values().length];
        r5[NetworkUtils$NetworkType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
    L31:
        r5[NetworkUtils$NetworkType.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
    L47:
        r5[NetworkUtils$NetworkType.MOBILE_2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
    L35:
        r5[NetworkUtils$NetworkType.MOBILE_3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
    L39:
        r5[NetworkUtils$NetworkType.MOBILE_3G_H.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
    L27:
        r5[NetworkUtils$NetworkType.MOBILE_3G_HP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
    L41:
        r5[NetworkUtils$NetworkType.MOBILE_4G.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
    L43:
        r5[NetworkUtils$NetworkType.MOBILE_5G.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
    L33:
        r5[NetworkUtils$NetworkType.WIFI.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
    L37:
        r5[NetworkUtils$NetworkType.WIFI_24GHZ.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
    L29:
        r5[NetworkUtils$NetworkType.WIFI_5GHZ.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
    L14:
        f59a = r5;
    }
}
