package com.facebook.common.disk;

/* JADX INFO: loaded from: classes2.dex */
public class NoOpDiskTrimmableRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NoOpDiskTrimmableRegistry f7643a;

    public NoOpDiskTrimmableRegistry() {
    }

    public static synchronized NoOpDiskTrimmableRegistry a() {
        monitor-enter(NoOpDiskTrimmableRegistry.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f7643a != null) goto L9;
        f7643a = new NoOpDiskTrimmableRegistry();     // Catch: Throwable -> L7
    L9:
        NoOpDiskTrimmableRegistry r5 = f7643a;     // Catch: Throwable -> L7
        monitor-exit(NoOpDiskTrimmableRegistry.class);
        return r5;
    }
}
