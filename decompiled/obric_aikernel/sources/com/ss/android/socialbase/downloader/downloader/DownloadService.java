package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import jb.o;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadService extends Service {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f7885g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected o f7886c;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f7887c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7888g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f7889h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ DownloadService f7890i;

        a(DownloadService r10, Intent r11, int r12, int r13) {
            this.f7890i = r10;
            this.f7887c = r11;
            this.f7888g = r12;
            this.f7889h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            o r10 = this.f7890i.f7886c;     // Catch: Throwable -> L6
            if (r10 == null) goto L11;
            r10.e(this.f7887c, this.f7888g, this.f7889h);     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }
    }

    static {
        f7885g = DownloadService.class.getSimpleName();
    }

    public DownloadService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        if (lb.a.a() == false) goto L9;
        String r11 = f7885g;
        StringBuilder r12 = new StringBuilder();
        r12.append("DownloadServiceHandler != null:");
        if (this.f7886c == null) goto L7;
        boolean r13 = true;
    L8:
        r12.append(r13);
        lb.a.b(r11, "onBind", r12.toString());
        goto L9
    L7:
        r13 = false;
    L9:
        o r14 = this.f7886c;
        if (r14 != null) goto L12;
        return null;
    L12:
        return r14.onBind(r10);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.a.l0(this);
        o r10 = com.ss.android.socialbase.downloader.downloader.a.z();
        this.f7886c = r10;
        r10.c(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (lb.a.a() == false) goto L5;
        lb.a.b(f7885g, "onDestroy", "Run");
    L5:
        o r10 = this.f7886c;
        if (r10 == null) goto L8;
        r10.b();
        this.f7886c = null;
    L8:
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (lb.a.a() == false) goto L16;
        lb.a.b(f7885g, "onStartCommand", "Run");
    L16:
        o r13 = this.f7886c;     // Catch: Throwable -> L9
        if (r13 == null) goto L11;
        r13.d();     // Catch: Throwable -> L9
    L11:
        ExecutorService r14 = com.ss.android.socialbase.downloader.downloader.a.i();
        if (r14 == null) goto L18;
        r14.execute(new a(this, r10, r11, r12));
        return 2;
    L18:
        return 2;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }
}
