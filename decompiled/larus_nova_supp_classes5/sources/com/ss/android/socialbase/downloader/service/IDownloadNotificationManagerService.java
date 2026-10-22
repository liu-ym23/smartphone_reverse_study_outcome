package com.ss.android.socialbase.downloader.service;

import android.app.Notification;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadNotificationManagerService {
    void addNotification(AbsNotificationItem r1);

    void cancel(int r1);

    void cancelNotification(int r1);

    void clearNotification();

    SparseArray<AbsNotificationItem> getAllNotificationItems();

    AbsNotificationItem getNotificationItem(int r1);

    void hideNotification(int r1);

    void notifyByService(int r1, int r2, Notification r3);

    AbsNotificationItem removeNotification(int r1);
}
