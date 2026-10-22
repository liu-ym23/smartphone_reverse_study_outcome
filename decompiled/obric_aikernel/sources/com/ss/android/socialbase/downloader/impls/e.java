package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class e extends jb.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f7990l = "e";

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f7991c;

        a(e r10) {
            this.f7991c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7991c.e(null, 0, 0);
        }
    }

    static {
    }

    public e() {
    }

    @Override // jb.a, jb.o
    public void d() {
        this.f9795g = true;
        this.f9796h.set(false);
        if (lb.a.a() == false) goto L6;
        lb.a.b(f7990l, "onStartCommandOnMainThread", "Run");
        return;
    }

    @Override // jb.a, jb.o
    public void e(Intent r10, int r11, int r12) {
        if (lb.a.a() == false) goto L5;
        lb.a.b(f7990l, "onStartCommand", "Run");
    L5:
        h();
    }

    @Override // jb.a
    public void i() {
        d();
        ExecutorService r10 = com.ss.android.socialbase.downloader.downloader.a.i();
        if (r10 == null) goto L6;
        r10.execute(new a(this));
        return;
    }

    @Override // jb.a
    public void j(Context r10, ServiceConnection r11) {
        r10.startService(new Intent(r10, DownloadService.class));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        i();
    }
}
