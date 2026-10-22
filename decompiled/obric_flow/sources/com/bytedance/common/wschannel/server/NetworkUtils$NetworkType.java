package com.bytedance.common.wschannel.server;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetworkUtils$NetworkType extends Enum<NetworkUtils$NetworkType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetworkUtils$NetworkType f4014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NetworkUtils$NetworkType f4015b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final NetworkUtils$NetworkType f4016c = null;
    public static final NetworkUtils$NetworkType d = null;
    public static final NetworkUtils$NetworkType e = null;
    public static final NetworkUtils$NetworkType f = null;
    public static final /* synthetic */ NetworkUtils$NetworkType[] g = null;

    static {
        NetworkUtils$NetworkType r5 = new NetworkUtils$NetworkType("NONE", 0);
        f4014a = r5;
        NetworkUtils$NetworkType r10 = new NetworkUtils$NetworkType("MOBILE", 1);
        f4015b = r10;
        NetworkUtils$NetworkType r11 = new NetworkUtils$NetworkType("MOBILE_2G", 2);
        f4016c = r11;
        NetworkUtils$NetworkType r12 = new NetworkUtils$NetworkType("MOBILE_3G", 3);
        d = r12;
        NetworkUtils$NetworkType r13 = new NetworkUtils$NetworkType("WIFI", 4);
        e = r13;
        NetworkUtils$NetworkType r14 = new NetworkUtils$NetworkType("MOBILE_4G", 5);
        f = r14;
        g = new NetworkUtils$NetworkType[]{r5, r10, r11, r12, r13, r14};
    }

    public NetworkUtils$NetworkType(String r5, int r10) {
        super(r5, r10);
    }

    public static NetworkUtils$NetworkType valueOf(String r5) {
        return (NetworkUtils$NetworkType) Enum.valueOf(NetworkUtils$NetworkType.class, r5);
    }

    public static NetworkUtils$NetworkType[] values() {
        return (NetworkUtils$NetworkType[]) g.clone();
    }
}
