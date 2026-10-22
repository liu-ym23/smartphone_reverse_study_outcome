package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IDownloadServiceHandler f15547a;

    public DownloadService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        if (Logger.b() == false) goto L9;
        StringBuilder r10 = new StringBuilder("DownloadServiceHandler != null:");
        if (this.f15547a == null) goto L7;
        boolean r11 = true;
    L8:
        r10.append(r11);
        Logger.b("DownloadService", "onBind", r10.toString());
        goto L9
    L7:
        r11 = false;
    L9:
        IDownloadServiceHandler r12 = this.f15547a;
        if (r12 != null) goto L12;
        return null;
    L12:
        return r12.b();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.a(this);
        IDownloadServiceHandler r5 = DownloadComponentManager.l();
        this.f15547a = r5;
        new WeakReference(this);
        r5.getClass();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        if (Logger.b() == false) goto L5;
        Logger.b("DownloadService", "onDestroy", "Run");
    L5:
        IDownloadServiceHandler r5 = this.f15547a;
        if (r5 == null) goto L8;
        ((AbsDownloadServiceHandler) r5).f15509b = false;
        this.f15547a = null;
    L8:
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent r5, final int r10, final int r11) {
        if (Logger.b() == false) goto L16;
        Logger.b("DownloadService", "onStartCommand", "Run");
    L16:
        IDownloadServiceHandler r12 = this.f15547a;     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        r12.d();     // Catch: Throwable -> L9
    L11:
        ExecutorService r13 = DownloadComponentManager.c();
        if (r13 == null) goto L18;
        ThreadPoolExecutor r14 = (ThreadPoolExecutor) r13;
        r14.execute(new AnonymousClass1(this, r5, r10, r11));
        return 2;
    L18:
        return 2;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }
}
