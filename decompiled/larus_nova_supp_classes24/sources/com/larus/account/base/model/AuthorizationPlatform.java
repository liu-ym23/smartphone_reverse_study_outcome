package com.larus.account.base.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum AuthorizationPlatform extends Enum<AuthorizationPlatform> {
    public static final AuthorizationPlatform LARK = null;
    public static final /* synthetic */ AuthorizationPlatform[] a = null;

    static {
        AuthorizationPlatform r0 = new AuthorizationPlatform();
        LARK = r0;
        a = new AuthorizationPlatform[]{r0};
    }

    public AuthorizationPlatform() {
        super("LARK", 0);
    }

    public static AuthorizationPlatform[] values() {
        return (AuthorizationPlatform[]) a.clone();
    }

    public static AuthorizationPlatform valueOf(String r1) {
        return (AuthorizationPlatform) a.a(AuthorizationPlatform.class, r1);
    }
}
