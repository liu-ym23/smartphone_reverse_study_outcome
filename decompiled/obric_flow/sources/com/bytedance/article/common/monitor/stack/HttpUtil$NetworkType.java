package com.bytedance.article.common.monitor.stack;

/* JADX INFO: loaded from: classes2.dex */
public final enum HttpUtil$NetworkType extends Enum<HttpUtil$NetworkType> {
    public static final HttpUtil$NetworkType MOBILE = null;
    public static final HttpUtil$NetworkType MOBILE_2G = null;
    public static final HttpUtil$NetworkType MOBILE_3G = null;
    public static final HttpUtil$NetworkType MOBILE_4G = null;
    public static final HttpUtil$NetworkType NONE = null;
    public static final HttpUtil$NetworkType WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpUtil$NetworkType[] f3926a = null;
    final int nativeInt;

    static {
        HttpUtil$NetworkType r5 = new HttpUtil$NetworkType("NONE", 0, 0);
        NONE = r5;
        HttpUtil$NetworkType r10 = new HttpUtil$NetworkType("MOBILE", 1, 1);
        MOBILE = r10;
        HttpUtil$NetworkType r11 = new HttpUtil$NetworkType("MOBILE_2G", 2, 2);
        MOBILE_2G = r11;
        HttpUtil$NetworkType r12 = new HttpUtil$NetworkType("MOBILE_3G", 3, 3);
        MOBILE_3G = r12;
        HttpUtil$NetworkType r13 = new HttpUtil$NetworkType("WIFI", 4, 4);
        WIFI = r13;
        HttpUtil$NetworkType r14 = new HttpUtil$NetworkType("MOBILE_4G", 5, 5);
        MOBILE_4G = r14;
        f3926a = new HttpUtil$NetworkType[]{r5, r10, r11, r12, r13, r14};
    }

    public HttpUtil$NetworkType(String r5, int r10, int r11) {
        super(r5, r10);
        this.nativeInt = r11;
    }

    public static HttpUtil$NetworkType valueOf(String r5) {
        return (HttpUtil$NetworkType) Enum.valueOf(HttpUtil$NetworkType.class, r5);
    }

    public static HttpUtil$NetworkType[] values() {
        return (HttpUtil$NetworkType[]) f3926a.clone();
    }

    public int getValue() {
        return this.nativeInt;
    }
}
