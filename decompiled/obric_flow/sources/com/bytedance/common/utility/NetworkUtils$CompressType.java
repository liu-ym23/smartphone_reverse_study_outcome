package com.bytedance.common.utility;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetworkUtils$CompressType extends Enum<NetworkUtils$CompressType> {
    public static final NetworkUtils$CompressType DEFLATER = null;
    public static final NetworkUtils$CompressType GZIP = null;
    public static final NetworkUtils$CompressType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetworkUtils$CompressType[] f3950a = null;
    final int nativeInt;

    static {
        NetworkUtils$CompressType r5 = new NetworkUtils$CompressType("NONE", 0, 0);
        NONE = r5;
        NetworkUtils$CompressType r10 = new NetworkUtils$CompressType("GZIP", 1, 1);
        GZIP = r10;
        NetworkUtils$CompressType r11 = new NetworkUtils$CompressType("DEFLATER", 2, 2);
        DEFLATER = r11;
        f3950a = new NetworkUtils$CompressType[]{r5, r10, r11};
    }

    public NetworkUtils$CompressType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static NetworkUtils$CompressType valueOf(String r5) {
        return (NetworkUtils$CompressType) Enum.valueOf(NetworkUtils$CompressType.class, r5);
    }

    public static NetworkUtils$CompressType[] values() {
        return (NetworkUtils$CompressType[]) f3950a.clone();
    }
}
