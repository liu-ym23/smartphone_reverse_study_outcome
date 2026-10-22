package com.ss.android.account;

import go2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h {
    public static volatile h b;
    public final a a;

    public class a extends com.bytedance.sdk.account.utils.i<Object> {
        public final Object b() {
            g r0 = k.d().c();
            if (r0 == null) goto L7;
            k.d().getApplicationContext();
            int r1 = com.larus.account.saas.core.internal.init.a.e;
            return r0;
        L7:
            throw new RuntimeException("please provide IAccountSec implementation");
        }

        public a() {
        }
    }

    public static h a() {
        if (b != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public h() {
        this.a = new a();
    }
}
