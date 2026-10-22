package com.bytedance.ttnet.utils;

/* JADX INFO: loaded from: classes2.dex */
public final enum RetrofitUtils$CompressType extends Enum<RetrofitUtils$CompressType> {
    public static final RetrofitUtils$CompressType DEFLATER = null;
    public static final RetrofitUtils$CompressType GZIP = null;
    public static final RetrofitUtils$CompressType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RetrofitUtils$CompressType[] f7535a = null;
    final int nativeInt;

    static {
        RetrofitUtils$CompressType r5 = new RetrofitUtils$CompressType("NONE", 0, 0);
        NONE = r5;
        RetrofitUtils$CompressType r10 = new RetrofitUtils$CompressType("GZIP", 1, 1);
        GZIP = r10;
        RetrofitUtils$CompressType r11 = new RetrofitUtils$CompressType("DEFLATER", 2, 2);
        DEFLATER = r11;
        f7535a = new RetrofitUtils$CompressType[]{r5, r10, r11};
    }

    public RetrofitUtils$CompressType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static RetrofitUtils$CompressType valueOf(String r5) {
        return (RetrofitUtils$CompressType) Enum.valueOf(RetrofitUtils$CompressType.class, r5);
    }

    public static RetrofitUtils$CompressType[] values() {
        return (RetrofitUtils$CompressType[]) f7535a.clone();
    }
}
