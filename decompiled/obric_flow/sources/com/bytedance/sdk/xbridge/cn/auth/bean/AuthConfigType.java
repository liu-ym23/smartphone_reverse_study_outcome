package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AuthConfigType extends Enum<AuthConfigType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AuthConfigType f7304a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthConfigType f7305b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AuthConfigType f7306c = null;
    public static final /* synthetic */ AuthConfigType[] d = null;

    static {
        AuthConfigType r5 = new AuthConfigType("UNKNOWN", 0);
        f7304a = r5;
        AuthConfigType r10 = new AuthConfigType("WEB", 1);
        f7305b = r10;
        AuthConfigType r11 = new AuthConfigType("LYNX", 2);
        f7306c = r11;
        d = new AuthConfigType[]{r5, r10, r11};
    }

    public AuthConfigType(String r5, int r10) {
        super(r5, r10);
    }

    public static AuthConfigType valueOf(String r5) {
        return (AuthConfigType) Enum.valueOf(AuthConfigType.class, r5);
    }

    public static AuthConfigType[] values() {
        return (AuthConfigType[]) d.clone();
    }
}
