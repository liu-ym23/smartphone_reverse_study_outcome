package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public class NoOpPoolStatsTracker implements PoolStatsTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static NoOpPoolStatsTracker f8235a;

    public NoOpPoolStatsTracker() {
    }

    public static synchronized NoOpPoolStatsTracker a() {
        monitor-enter(NoOpPoolStatsTracker.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f8235a != null) goto L9;
        f8235a = new NoOpPoolStatsTracker();     // Catch: Throwable -> L7
    L9:
        NoOpPoolStatsTracker r5 = f8235a;     // Catch: Throwable -> L7
        monitor-exit(NoOpPoolStatsTracker.class);
        return r5;
    }
}
