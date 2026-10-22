package com.bytedance.sdk.xbridge.cn.protocol.auth;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthPriority;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AuthPriority extends Enum<AuthPriority> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AuthPriority f7442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AuthPriority f7443b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AuthPriority[] f7444c = null;

    static {
        AuthPriority r5 = new AuthPriority("HIGH", 0);
        f7442a = r5;
        AuthPriority r10 = new AuthPriority("LOW", 1);
        f7443b = r10;
        f7444c = new AuthPriority[]{r5, r10};
    }

    public AuthPriority(String r5, int r10) {
        super(r5, r10);
    }

    public static AuthPriority valueOf(String r5) {
        return (AuthPriority) Enum.valueOf(AuthPriority.class, r5);
    }

    public static AuthPriority[] values() {
        return (AuthPriority[]) f7444c.clone();
    }
}
