package com.ss.android.socialbase.downloader.service;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadServiceLoader implements com.ss.android.socialbase.downloader.downloader.o {
    private static final String TAG = "DownloadServiceLoader";
    private static boolean isLoaded = false;

    static {
    }

    public DownloadServiceLoader() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void defaultLoadCallback(boolean r3, String r4) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(TAG, "defaultLoadCallback", "Load status:" + r3 + " errorMsg:" + r4);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void load() {
        monitor-enter(k.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (isLoaded == false) goto L8;
        monitor-exit(k.class);     // Catch: Throwable -> L17
        return;
    L8:
        isLoaded = true;     // Catch: Throwable -> L17
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a(TAG, "load", "Load download service start");     // Catch: Throwable -> L17
    L11:
        k.a(o.class, new d());     // Catch: Throwable -> L17
        k.a(n.class, new c());     // Catch: Throwable -> L17
        k.a(l.class, new a());     // Catch: Throwable -> L17
        k.a(t.class, new i());     // Catch: Throwable -> L17
        k.a(q.class, new f());     // Catch: Throwable -> L17
        k.a(s.class, new h());     // Catch: Throwable -> L17
        k.a(r.class, new g());     // Catch: Throwable -> L17
        k.a(u.class, new j());     // Catch: Throwable -> L17
        k.a(p.class, new e());     // Catch: Throwable -> L17
        k.a(m.class, new b());     // Catch: Throwable -> L17
        k.a();     // Catch: Throwable -> L17
        monitor-exit(k.class);     // Catch: Throwable -> L17
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L21;
        com.ss.android.socialbase.downloader.e.a.a(TAG, "load", "Load download service end");
        return;
    }
}
