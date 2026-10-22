package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.util.Log;
import com.bytedance.forest.pollyfill.g;
import com.bytedance.ies.bullet.kit.web.download.a;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Downloader extends BaseDownloader {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Downloader f15566c = null;
    public static volatile boolean d = false;

    public Downloader() {
    }

    public static void a(DownloaderBuilder r5) {
        monitor-enter(Downloader.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f15566c != null) goto L11;
        f15566c = new Downloader(r5);     // Catch: Throwable -> L9
        monitor-exit(Downloader.class);     // Catch: Throwable -> L9
        return;
    L11:
        IDownloadComponentManagerService r10 = (IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class);     // Catch: Throwable -> L9
        if (r10.b() == true) goto L16;
        r10.a(r5);     // Catch: Throwable -> L9
        monitor-exit(Downloader.class);     // Catch: Throwable -> L9
        return;
    L16:
        monitor-exit(Downloader.class);
    }

    public static Downloader b(Context r5) {
        if (f15566c == null) goto L5;
    L15:
        a(r5);
        return f15566c;
    L5:
        monitor-enter(Downloader.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15566c != null) goto L11;
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).a(r5);     // Catch: Throwable -> L9
        f15566c = new Downloader();     // Catch: Throwable -> L9
    L11:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L9
        goto L15
    }

    public final boolean c(int r5) {
        return this.f15513a.f(r5);
    }

    public final void d(int r5) {
        this.f15513a.b(r5);
    }

    public final void e(int r5) {
        this.f15513a.g(r5);
    }

    public Downloader(DownloaderBuilder r5) {
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).a(r5);
    }

    public final void b() {
        this.f15513a.b();
    }

    public final void b(ArrayList r5) {
        this.f15513a.b(r5);
    }

    public static void a(Context r10) {
        if (d == false) goto L6;
        return;
    L6:
        monitor-enter(Downloader.class);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (d == false) goto L28;
        monitor-exit(Downloader.class);     // Catch: Throwable -> L11
        return;
    L28:
        if (r10 == null) goto L18;
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).a(r10.getApplicationContext());     // Catch: Throwable -> L15
        d = true;     // Catch: Throwable -> L15
    L27:
    L22:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L11
        return;
    L18:
        if (Logger.b() == false) goto L27;
        Logger.b("Downloader", "checkContext", "Context is null " + Log.getStackTraceString(new Throwable("context_empty")));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        Logger.c("Downloader", "checkContext", "Error:" + th);     // Catch: Throwable -> L11
        goto L22
    }

    public final DownloadInfo b(int r5) {
        return this.f15513a.a(r5);
    }

    public final Map b(String r5) {
        return this.f15513a.a(r5);
    }

    public final void a(int r5) {
        this.f15513a.e(r5);
    }

    public final void a(ArrayList r5) {
        this.f15513a.a(r5);
    }

    public final DownloadInfo a(String r5, String r10) {
        return this.f15513a.a(r5, r10);
    }

    public final List a(String r5) {
        return this.f15513a.b(r5);
    }

    public final void a(int r5, a r10) {
        this.f15513a.a(r5, r10, ListenerType.f15280a);
    }

    public final void a(int r5, g r10) {
        this.f15513a.a(r5, r10, ListenerType.f15281b);
    }

    public final void a() {
        this.f15514b.d();
    }
}
