package com.bytedance.sdk.xbridge.cn.protocol.auth;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthUrlSourceType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AuthUrlSourceType extends Enum<AuthUrlSourceType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthUrlSourceType f7445b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AuthUrlSourceType f7446c = null;
    public static final AuthUrlSourceType d = null;
    public static final AuthUrlSourceType e = null;
    public static final AuthUrlSourceType f = null;
    public static final AuthUrlSourceType g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AuthUrlSourceType f7447h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AuthUrlSourceType[] f7448i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7449a;

    static {
        AuthUrlSourceType r5 = new AuthUrlSourceType("DisableSafeAuthInXBridge2", 0, -2);
        f7445b = r5;
        AuthUrlSourceType r10 = new AuthUrlSourceType("DisableSafeAuthInXBridge3", 1, -1);
        f7446c = r10;
        AuthUrlSourceType r11 = new AuthUrlSourceType("Unset", 2, 0);
        d = r11;
        AuthUrlSourceType r12 = new AuthUrlSourceType("PageStartedUrl", 3, 2);
        e = r12;
        AuthUrlSourceType r13 = new AuthUrlSourceType("PageCommitVisibleUrl", 4, 3);
        f = r13;
        AuthUrlSourceType r14 = new AuthUrlSourceType("WebViewUrl", 5, 4);
        g = r14;
        AuthUrlSourceType r15 = new AuthUrlSourceType("AbnormalUrl", 6, 101);
        f7447h = r15;
        f7448i = new AuthUrlSourceType[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public AuthUrlSourceType(String r5, int r10, int r11) {
        super(r5, r10);
        this.f7449a = r11;
    }

    public static AuthUrlSourceType valueOf(String r5) {
        return (AuthUrlSourceType) Enum.valueOf(AuthUrlSourceType.class, r5);
    }

    public static AuthUrlSourceType[] values() {
        return (AuthUrlSourceType[]) f7448i.clone();
    }
}
