package com.ss.android.socialbase.downloader.service;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManagerImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadNotificationManagerService implements IDownloadNotificationManagerService {
    public DownloadNotificationManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void clearNotification() {
        DownloadNotificationManagerImpl.getInstance().clearNotification();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public SparseArray<AbsNotificationItem> getAllNotificationItems() {
        return DownloadNotificationManagerImpl.getInstance().getAllNotificationItems();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void addNotification(AbsNotificationItem r2) {
        DownloadNotificationManagerImpl.getInstance().addNotification(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancel(int r2) {
        DownloadNotificationManagerImpl.getInstance().cancel(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void cancelNotification(int r2) {
        DownloadNotificationManagerImpl.getInstance().cancelNotification(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem getNotificationItem(int r2) {
        return DownloadNotificationManagerImpl.getInstance().getNotificationItem(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void hideNotification(int r2) {
        DownloadNotificationManagerImpl.getInstance().hideNotification(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public AbsNotificationItem removeNotification(int r2) {
        return DownloadNotificationManagerImpl.getInstance().removeNotification(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public void notifyByService(int r2, int r3, Notification r4) {
        DownloadNotificationManagerImpl.getInstance().notifyByService(r2, r3, r4);
    }
}
