package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthMode;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AuthMode extends Enum<AuthMode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthMode f7317b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AuthMode f7318c = null;
    public static final AuthMode d = null;
    public static final AuthMode e = null;
    public static final /* synthetic */ AuthMode[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7319a;

    static {
        AuthMode r5 = new AuthMode("INTERNAL_H5_APPID", 0, "internal_h5_appID");
        f7317b = r5;
        AuthMode r10 = new AuthMode("INTERNAL_H5_OLD", 1, "internal_h5_old");
        f7318c = r10;
        AuthMode r11 = new AuthMode("STANDARD_H5_V3", 2, "standard_h5_v3");
        d = r11;
        AuthMode r12 = new AuthMode("STANDARD_H5_V3_FORCE_PRIVATE", 3, "standard_h5_v3_force_private");
        e = r12;
        f = new AuthMode[]{r5, r10, r11, r12};
    }

    public AuthMode(String r5, int r10, String r11) {
        super(r5, r10);
        this.f7319a = r11;
    }

    public static AuthMode valueOf(String r5) {
        return (AuthMode) Enum.valueOf(AuthMode.class, r5);
    }

    public static AuthMode[] values() {
        return (AuthMode[]) f.clone();
    }
}
