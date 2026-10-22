package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ProcessDownloadHandler f15695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile IndependentProcessDownloadHandler f15696b;

    public static IDownloadProxy a() {
        if (f15695a != null) goto L16;
        monitor-enter(DownloadProxy.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15695a != null) goto L11;
        f15695a = new ProcessDownloadHandler(false);     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadProxy.class);     // Catch: Throwable -> L9
    L16:
        return f15695a;
    }

    public static IDownloadProxy a(boolean r5) {
        if (r5 == false) goto L25;
        if (DownloadComponentManager.f == null) goto L25;
        if (f15696b != null) goto L21;
        monitor-enter(DownloadProxy.class);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (f15696b == null) goto L12;
    L16:
        monitor-exit(DownloadProxy.class);     // Catch: Throwable -> L14
        goto L21
    L12:
        if (DownloadComponentManager.f == null) goto L16;
        f15696b = new IndependentProcessDownloadHandler();     // Catch: Throwable -> L14
    L21:
        if (f15696b == null) goto L25;
        return f15696b;
    L25:
        return a();
    }
}
