package com.ss.android.account;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e {
    public static xqa.b a() {
        com.larus.account.saas.core.internal.init.d r0 = k.d().b();
        if (r0 == null) goto L7;
        k.d().getApplicationContext();
        return r0;
    L7:
        throw new RuntimeException("please provide IBdTruing implementation");
    }
}
