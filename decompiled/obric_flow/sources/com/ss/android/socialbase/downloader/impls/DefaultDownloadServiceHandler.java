package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDownloadServiceHandler extends AbsDownloadServiceHandler {
    public DefaultDownloadServiceHandler() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public final void a(Context r5, ServiceConnection r10) {
        r5.startService(new Intent(r5, DownloadService.class));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        f();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public final void d() {
        this.f15509b = true;
        this.f15510c.set(false);
        if (Logger.b() == false) goto L6;
        Logger.b("DefaultDownloadServiceHandler", "onStartCommandOnMainThread", "Run");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public final void f() {
        d();
        ExecutorService r5 = DownloadComponentManager.c();
        if (r5 == null) goto L6;
        ThreadPoolExecutor r10 = (ThreadPoolExecutor) r5;
        r10.execute(new AnonymousClass1(this));
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public final void a() {
        if (Logger.b() == false) goto L5;
        Logger.b("DefaultDownloadServiceHandler", "onStartCommand", "Run");
    L5:
        e();
    }
}
