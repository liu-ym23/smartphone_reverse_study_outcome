package com.ss.android.lark.conditional.access.network.easynetwork;

import com.larksuite.framework.utils.NetworkUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum EasyNetworkType extends Enum<EasyNetworkType> {
    public static final EasyNetworkType CELLULAR_DATA_NETWORK = null;
    public static final EasyNetworkType NO_INTERNET_CONNECTION = null;
    public static final EasyNetworkType VPN = null;
    public static final EasyNetworkType WIFI = null;
    public static final /* synthetic */ EasyNetworkType[] a = null;
    private String typeName;
    private int value;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkUtils.NetworkType.values().length];
            a = r0;
            r0[NetworkUtils.NetworkType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[NetworkUtils.NetworkType.MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[NetworkUtils.NetworkType.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[NetworkUtils.NetworkType.WIFI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        EasyNetworkType r0 = new EasyNetworkType("NO_INTERNET_CONNECTION", 0, 1, "NO_INTERNET_CONNECTION");
        NO_INTERNET_CONNECTION = r0;
        EasyNetworkType r1 = new EasyNetworkType("CELLULAR_DATA_NETWORK", 1, 2, "CELLULAR_DATA_NETWORK");
        CELLULAR_DATA_NETWORK = r1;
        EasyNetworkType r4 = new EasyNetworkType("WIFI", 2, 3, "WIFI");
        WIFI = r4;
        EasyNetworkType r6 = new EasyNetworkType("VPN", 3, 4, "VPN");
        VPN = r6;
        a = new EasyNetworkType[]{r0, r1, r4, r6};
    }

    public static EasyNetworkType[] values() {
        return (EasyNetworkType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EasyNetworkType{value=" + this.value + ", typeName='" + this.typeName + "'}";
    }

    public int getNumber() {
        return this.value;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public static EasyNetworkType forNumber(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return WIFI;
    L9:
        return CELLULAR_DATA_NETWORK;
    L11:
        return NO_INTERNET_CONNECTION;
    }

    public static EasyNetworkType getBasicEasyType(NetworkUtils.NetworkType r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L15;
        if (r2 == 5) goto L15;
        return WIFI;
    L15:
        return CELLULAR_DATA_NETWORK;
    L17:
        return NO_INTERNET_CONNECTION;
    }

    public static EasyNetworkType valueOf(String r1) {
        return (EasyNetworkType) r27.a.a(EasyNetworkType.class, r1);
    }

    public static EasyNetworkType valueOf(int r0) {
        return forNumber(r0);
    }

    public EasyNetworkType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.typeName = r4;
    }
}
