package com.bytedance.framwork.core.sdklib.util;

/* JADX INFO: loaded from: classes2.dex */
public final enum NetUtils$CompressType extends Enum<NetUtils$CompressType> {
    public static final NetUtils$CompressType DEFLATER = null;
    public static final NetUtils$CompressType GZIP = null;
    public static final NetUtils$CompressType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetUtils$CompressType[] f4697a = null;
    final int nativeInt;

    static {
        NetUtils$CompressType r5 = new NetUtils$CompressType("NONE", 0, 0);
        NONE = r5;
        NetUtils$CompressType r10 = new NetUtils$CompressType("GZIP", 1, 1);
        GZIP = r10;
        NetUtils$CompressType r11 = new NetUtils$CompressType("DEFLATER", 2, 2);
        DEFLATER = r11;
        f4697a = new NetUtils$CompressType[]{r5, r10, r11};
    }

    public NetUtils$CompressType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static NetUtils$CompressType valueOf(String r5) {
        return (NetUtils$CompressType) Enum.valueOf(NetUtils$CompressType.class, r5);
    }

    public static NetUtils$CompressType[] values() {
        return (NetUtils$CompressType[]) f4697a.clone();
    }
}
