package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class SqlDownloadCacheService extends Service {
    public SqlDownloadCacheService() {
    }

    public static void a(Context r5, ServiceConnection r10) {
        if (r5 == null) goto L10;
        Intent r11 = new Intent(r5, SqlDownloadCacheService.class);     // Catch: Throwable -> L5
        r5.bindService(r11, r10, 1);     // Catch: Throwable -> L5
        r5.startService(r11);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.c("SqlDownloadCacheService", "startServiceAndBind", "Exception:" + th.toString());
        return;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        IDownloadCache r10 = DownloadComponentManager.h();
        if ((r10 instanceof DefaultDownloadCache) == false) goto L6;
        ISqlDownloadCache r11 = ((DefaultDownloadCache) r10).f15675b;
    L10:
        if ((r11 instanceof IBinder) == false) goto L14;
        return (IBinder) r11;
    L14:
        return new Binder();
    L6:
        if ((r10 instanceof ISqlDownloadCache) == false) goto L8;
        r11 = (ISqlDownloadCache) r10;
        goto L10
    L8:
        r11 = null;
        goto L10
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        DownloadComponentManager.a(getApplicationContext());
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r5, int r10, int r11) {
        return 2;
    }
}
