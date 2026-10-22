package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class SqlDownloadCacheService extends Service {
    private static final String TAG = null;

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        return 2;
    }

    static {
        TAG = "SqlDownloadCacheService";
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(getApplicationContext());
    }

    public SqlDownloadCacheService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        IDownloadCache r3 = DownloadComponentManager.getDownloadCache();
        if ((r3 instanceof DefaultDownloadCache) == false) goto L6;
        ISqlDownloadCache r4 = ((DefaultDownloadCache) r3).getSqlDownloadCache();
    L10:
        if ((r4 instanceof IBinder) == false) goto L14;
        return (IBinder) r4;
    L14:
        return new Binder();
    L6:
        if ((r3 instanceof ISqlDownloadCache) == false) goto L8;
        r4 = (ISqlDownloadCache) r3;
        goto L10
    L8:
        r4 = null;
        goto L10
    }

    public static void startServiceAndBind(Context r2, ServiceConnection r3) {
        if (r2 == null) goto L13;
        Intent r0 = new Intent(r2, SqlDownloadCacheService.class);     // Catch: Throwable -> L8
        if (r3 == null) goto L6;
        r2.bindService(r0, r3, 1);     // Catch: Throwable -> L8
    L6:
        r2.startService(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Logger.globalError(TAG, "startServiceAndBind", "Exception:" + th.toString());
        return;
    }
}
