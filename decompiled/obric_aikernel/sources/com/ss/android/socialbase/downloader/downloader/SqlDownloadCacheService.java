package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import jb.i;
import jb.u;

/* JADX INFO: loaded from: classes2.dex */
public class SqlDownloadCacheService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f7891c = null;

    static {
        f7891c = SqlDownloadCacheService.class.getSimpleName();
    }

    public SqlDownloadCacheService() {
    }

    public static void a(Context r10, ServiceConnection r11) {
        if (r10 == null) goto L13;
        Intent r12 = new Intent(r10, SqlDownloadCacheService.class);     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        r10.bindService(r12, r11, 1);     // Catch: Throwable -> L8
    L6:
        r10.startService(r12);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        lb.a.c(f7891c, "startServiceAndBind", "Exception:" + th.toString());
        return;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        i r11 = a.o();
        if ((r11 instanceof com.ss.android.socialbase.downloader.impls.b) == false) goto L6;
        u r12 = ((com.ss.android.socialbase.downloader.impls.b) r11).r();
    L10:
        if ((r12 instanceof IBinder) == false) goto L14;
        return (IBinder) r12;
    L14:
        return new Binder();
    L6:
        if ((r11 instanceof u) == false) goto L8;
        r12 = (u) r11;
        goto L10
    L8:
        r12 = null;
        goto L10
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.l0(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        return 2;
    }
}
