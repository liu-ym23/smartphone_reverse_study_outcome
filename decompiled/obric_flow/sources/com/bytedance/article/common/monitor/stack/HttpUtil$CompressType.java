package com.bytedance.article.common.monitor.stack;

/* JADX INFO: loaded from: classes2.dex */
public final enum HttpUtil$CompressType extends Enum<HttpUtil$CompressType> {
    public static final HttpUtil$CompressType DEFLATER = null;
    public static final HttpUtil$CompressType GZIP = null;
    public static final HttpUtil$CompressType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpUtil$CompressType[] f3925a = null;
    final int nativeInt;

    static {
        HttpUtil$CompressType r5 = new HttpUtil$CompressType("NONE", 0, 0);
        NONE = r5;
        HttpUtil$CompressType r10 = new HttpUtil$CompressType("GZIP", 1, 1);
        GZIP = r10;
        HttpUtil$CompressType r11 = new HttpUtil$CompressType("DEFLATER", 2, 2);
        DEFLATER = r11;
        f3925a = new HttpUtil$CompressType[]{r5, r10, r11};
    }

    public HttpUtil$CompressType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static HttpUtil$CompressType valueOf(String r5) {
        return (HttpUtil$CompressType) Enum.valueOf(HttpUtil$CompressType.class, r5);
    }

    public static HttpUtil$CompressType[] values() {
        return (HttpUtil$CompressType[]) f3925a.clone();
    }
}
