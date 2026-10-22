package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile jb.m f7995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile jb.m f7996b;

    public g() {
    }

    public static jb.m a(boolean r10) {
        if (r10 == false) goto L20;
        if (com.ss.android.socialbase.downloader.downloader.a.N0() == false) goto L20;
        if (f7996b != null) goto L18;
        monitor-enter(g.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (f7996b != null) goto L12;
        f7996b = com.ss.android.socialbase.downloader.downloader.a.J().a();     // Catch: Throwable -> L14
    L12:
        monitor-exit(g.class);     // Catch: Throwable -> L14
    L18:
        return f7996b;
    L20:
        if (f7995a != null) goto L31;
        monitor-enter(g.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (f7995a != null) goto L25;
        f7995a = new l();     // Catch: Throwable -> L27
    L25:
        monitor-exit(g.class);     // Catch: Throwable -> L27
    L31:
        return f7995a;
    }
}
