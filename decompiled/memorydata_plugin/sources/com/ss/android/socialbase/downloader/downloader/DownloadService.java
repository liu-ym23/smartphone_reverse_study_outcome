package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.IBinder;
import com.volcengine.zeus.service.PluginService;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadService extends PluginService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f15392b = "DownloadService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected n f15393a;

    static {
    }

    public DownloadService() {
    }

    public IBinder onBind(Intent r4) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        String r0 = f15392b;
        StringBuilder r1 = new StringBuilder().append("DownloadServiceHandler != null:");
        if (this.f15393a == null) goto L7;
        boolean r2 = true;
    L8:
        com.ss.android.socialbase.downloader.e.a.a(r0, "onBind", r1.append(r2).toString());
        goto L9
    L7:
        r2 = false;
    L9:
        n r3 = this.f15393a;
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.a(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        b.a(this);
        n r0 = b.D();
        this.f15393a = r0;
        r0.a(new WeakReference(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a(f15392b, "onDestroy", "Run");
    L5:
        n r0 = this.f15393a;
        if (r0 == null) goto L8;
        r0.d();
        this.f15393a = null;
    L8:
        super/*android.app.Service*/.onDestroy();
    }

    public int onStartCommand(final Intent r4, final int r5, final int r6) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a(f15392b, "onStartCommand", "Run");
    L16:
        n r0 = this.f15393a;     // Catch: Throwable -> L9
        if (r0 == null) goto L11;
        r0.c();     // Catch: Throwable -> L9
    L11:
        ExecutorService r1 = b.i();
        if (r1 == null) goto L18;
        r1.execute(new AnonymousClass1(this, r4, r5, r6));
        return 2;
    L18:
        return 2;
    L9:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }
}
