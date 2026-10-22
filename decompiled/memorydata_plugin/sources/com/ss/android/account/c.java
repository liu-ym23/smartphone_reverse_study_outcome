package com.ss.android.account;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f14990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.account.a.a f14991b;

    private c() {
    }

    public static c a() {
        if (f14990a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14990a != null) goto L9;
        f14990a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f14990a;
    }

    public com.ss.android.account.a.a b() {
        return this.f14991b;
    }
}
