package com.facebook.common.memory;

/* JADX INFO: loaded from: classes2.dex */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NoOpMemoryTrimmableRegistry f7662a;

    public NoOpMemoryTrimmableRegistry() {
    }

    public static synchronized NoOpMemoryTrimmableRegistry a() {
        monitor-enter(NoOpMemoryTrimmableRegistry.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f7662a != null) goto L9;
        f7662a = new NoOpMemoryTrimmableRegistry();     // Catch: Throwable -> L7
    L9:
        NoOpMemoryTrimmableRegistry r5 = f7662a;     // Catch: Throwable -> L7
        monitor-exit(NoOpMemoryTrimmableRegistry.class);
        return r5;
    }
}
