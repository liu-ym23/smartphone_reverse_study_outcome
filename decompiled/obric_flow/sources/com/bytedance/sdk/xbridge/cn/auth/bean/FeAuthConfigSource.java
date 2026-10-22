package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum FeAuthConfigSource extends Enum<FeAuthConfigSource> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FeAuthConfigSource f7327b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FeAuthConfigSource f7328c = null;
    public static final FeAuthConfigSource d = null;
    public static final FeAuthConfigSource e = null;
    public static final FeAuthConfigSource f = null;
    public static final FeAuthConfigSource g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final FeAuthConfigSource f7329h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final FeAuthConfigSource f7330i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final FeAuthConfigSource f7331j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ FeAuthConfigSource[] f7332k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7333a;

    static {
        FeAuthConfigSource r5 = new FeAuthConfigSource("LOGIC_ERROR", 0, -2);
        f7327b = r5;
        FeAuthConfigSource r10 = new FeAuthConfigSource("NOT_FOUND", 1, -1);
        f7328c = r10;
        FeAuthConfigSource r11 = new FeAuthConfigSource("UN_KNOWN", 2, 0);
        d = r11;
        FeAuthConfigSource r12 = new FeAuthConfigSource("CONTENT_V2_FROM_CACHE", 3, 1);
        e = r12;
        FeAuthConfigSource r13 = new FeAuthConfigSource("CONTENT_V2_FROM_CALL", 4, 2);
        f = r13;
        FeAuthConfigSource r14 = new FeAuthConfigSource("CONTENT_V2_FROM_AUTO_MATCH", 5, 3);
        g = r14;
        FeAuthConfigSource r15 = new FeAuthConfigSource("CONTENT_V1_FROM_MATCH", 6, 4);
        f7329h = r15;
        FeAuthConfigSource r16 = new FeAuthConfigSource("PRIVATE_DOMAINS", 7, 5);
        f7330i = r16;
        FeAuthConfigSource r17 = new FeAuthConfigSource("CONTENT_V1_FROM_CACHE", 8, 6);
        f7331j = r17;
        f7332k = new FeAuthConfigSource[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, new FeAuthConfigSource("CONTENT_V2_FROM_LYNX", 9, 7)};
    }

    public FeAuthConfigSource(String r5, int r10, int r11) {
        super(r5, r10);
        this.f7333a = r11;
    }

    public static FeAuthConfigSource valueOf(String r5) {
        return (FeAuthConfigSource) Enum.valueOf(FeAuthConfigSource.class, r5);
    }

    public static FeAuthConfigSource[] values() {
        return (FeAuthConfigSource[]) f7332k.clone();
    }
}
