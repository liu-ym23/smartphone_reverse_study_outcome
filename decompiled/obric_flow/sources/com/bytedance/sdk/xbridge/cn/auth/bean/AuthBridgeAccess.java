package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "", "com/bytedance/apm/util/a", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AuthBridgeAccess extends Enum<AuthBridgeAccess> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthBridgeAccess f7301b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AuthBridgeAccess f7302c = null;
    public static final AuthBridgeAccess d = null;
    public static final AuthBridgeAccess e = null;
    public static final /* synthetic */ AuthBridgeAccess[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7303a;

    static {
        AuthBridgeAccess r5 = new AuthBridgeAccess("UNKNOWN", 0, "unknown");
        f7301b = r5;
        AuthBridgeAccess r10 = new AuthBridgeAccess("PUBLIC", 1, "public");
        f7302c = r10;
        AuthBridgeAccess r11 = new AuthBridgeAccess("PRIVATE", 2, "private");
        d = r11;
        AuthBridgeAccess r12 = new AuthBridgeAccess("SECURE", 3, "secure");
        e = r12;
        f = new AuthBridgeAccess[]{r5, r10, r11, r12};
    }

    public AuthBridgeAccess(String r5, int r10, String r11) {
        super(r5, r10);
        this.f7303a = r11;
    }

    public static AuthBridgeAccess valueOf(String r5) {
        return (AuthBridgeAccess) Enum.valueOf(AuthBridgeAccess.class, r5);
    }

    public static AuthBridgeAccess[] values() {
        return (AuthBridgeAccess[]) f.clone();
    }
}
