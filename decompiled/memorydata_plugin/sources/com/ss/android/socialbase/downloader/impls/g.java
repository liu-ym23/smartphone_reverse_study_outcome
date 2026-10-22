package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.l f15497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.l f15498b;

    public g() {
    }

    public static com.ss.android.socialbase.downloader.downloader.l a(boolean r1) {
        if (r1 == false) goto L20;
        if (com.ss.android.socialbase.downloader.downloader.b.X() == false) goto L20;
        if (f15498b != null) goto L18;
        monitor-enter(g.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (f15498b != null) goto L12;
        f15498b = com.ss.android.socialbase.downloader.downloader.b.Y().b();     // Catch: Throwable -> L14
    L12:
        monitor-exit(g.class);     // Catch: Throwable -> L14
    L18:
        return f15498b;
    L20:
        if (f15497a != null) goto L31;
        monitor-enter(g.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (f15497a != null) goto L25;
        f15497a = new m();     // Catch: Throwable -> L27
    L25:
        monitor-exit(g.class);     // Catch: Throwable -> L27
    L31:
        return f15497a;
    }
}
