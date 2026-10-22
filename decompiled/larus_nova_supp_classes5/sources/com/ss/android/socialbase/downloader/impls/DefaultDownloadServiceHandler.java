package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DefaultDownloadServiceHandler extends AbsDownloadServiceHandler {
    private static final String TAG = null;

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
        this.isServiceAlive = true;
        this.isInvokeStartService.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onStartCommandOnMainThread", "Run");
        return;
    }

    static {
        TAG = "DefaultDownloadServiceHandler";
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startFakeService() {
        onStartCommandOnMainThread();
        ExecutorService r0 = DownloadComponentManager.getCPUThreadExecutor();
        if (r0 == null) goto L6;
        r0.execute(new 1(this));
        return;
    }

    public DefaultDownloadServiceHandler() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context r2, ServiceConnection r3) {
        if (DownloadSetting.obtainGlobal().optInt("disable_download_service") <= 0) goto L11;
        startFakeService();
        return;
    L11:
        r2.startService(new Intent(r2, DownloadService.class));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        startFakeService();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context r2, ServiceConnection r3) {
        r2.stopService(new Intent(r2, DownloadService.class));
        this.isServiceAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent r1, int r2, int r3) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "onStartCommand", "Run");
    L5:
        resumePendingTask();
    }
}
