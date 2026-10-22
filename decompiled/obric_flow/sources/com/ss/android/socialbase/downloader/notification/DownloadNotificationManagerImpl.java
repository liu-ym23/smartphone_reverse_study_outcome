package com.ss.android.socialbase.downloader.notification;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNotificationManagerImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile DownloadNotificationManagerImpl f15995b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f15996a;

    public DownloadNotificationManagerImpl() {
        new SparseArray();
        this.f15996a = new SparseArray();
    }

    public static DownloadNotificationManagerImpl a() {
        if (f15995b != null) goto L16;
        monitor-enter(DownloadNotificationManagerImpl.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15995b != null) goto L11;
        f15995b = new DownloadNotificationManagerImpl();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadNotificationManagerImpl.class);     // Catch: Throwable -> L9
    L16:
        return f15995b;
    }
}
