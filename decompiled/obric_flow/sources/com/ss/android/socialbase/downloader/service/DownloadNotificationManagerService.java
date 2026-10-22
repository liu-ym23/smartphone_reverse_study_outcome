package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManagerImpl;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationServiceImpl;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNotificationManagerService implements IDownloadNotificationManagerService {
    public DownloadNotificationManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public final void a(int r5) {
        DownloadNotificationManagerImpl r10 = DownloadNotificationManagerImpl.a();
        if (r5 != 0) goto L5;
        r10.getClass();
    L10:
        if (r5 == 0) goto L20;
        DownloadNotificationManager.a().f15994a.e(r5);
        return;
    L20:
        return;
    L5:
        SparseArray r11 = r10.f15996a;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (r10.f15996a.get(r5) != null) goto L16;
        monitor-exit(r11);     // Catch: Throwable -> L13
        goto L10
    L16:
        throw new ClassCastException();     // Catch: Throwable -> L13
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public final void e(int r5) {
        DownloadNotificationManagerImpl.a().getClass();
        monitor-enter(DownloadComponentManager.class);
        Context r10 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L22
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L22
        if (r10 == null) goto L28;
        if (r5 == 0) goto L30;
        Intent r11 = new Intent(r10, DownloadNotificationService.class);
        r11.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");     // Catch: Throwable -> L14
        r11.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", r5);     // Catch: Throwable -> L14
        if (DownloadSetting.f.a("enable_target_34", 0) <= 0) goto L16;
        DownloadNotificationServiceImpl.a().a(r11);     // Catch: Throwable -> L14
        return;
    L16:
        r10.startService(r11);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Logger.a("DownloadNotificationManagerImpl", r5, "cancel", "Error:" + th);
        th.printStackTrace();
        if (DownloadSetting.f.b("fix_background_notification") == false) goto L29;
        DownloadNotificationServiceImpl.a().a(r11);
        return;
    L29:
        return;
    L30:
        return;
    L28:
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
