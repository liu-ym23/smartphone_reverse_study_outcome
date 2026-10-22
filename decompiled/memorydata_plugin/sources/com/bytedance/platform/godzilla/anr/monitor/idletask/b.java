package com.bytedance.platform.godzilla.anr.monitor.idletask;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f2982b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.platform.godzilla.anr.monitor.a f2983a;

    private b() {
    }

    public static b a() {
        if (f2982b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2982b != null) goto L9;
        f2982b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2982b;
    }

    public com.bytedance.platform.godzilla.anr.monitor.a b() {
        return this.f2983a;
    }
}
