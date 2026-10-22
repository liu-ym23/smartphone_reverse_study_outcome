package com.ss.android.socialbase.downloader.notification;

import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNotificationManager implements IDownloadNotificationManagerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile DownloadNotificationManager f15993b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDownloadNotificationManagerService f15994a;

    public DownloadNotificationManager() {
        this.f15994a = (IDownloadNotificationManagerService) DownloadServiceManager.a(IDownloadNotificationManagerService.class);
    }

    public static DownloadNotificationManager a() {
        if (f15993b != null) goto L16;
        monitor-enter(DownloadNotificationManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15993b != null) goto L11;
        f15993b = new DownloadNotificationManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadNotificationManager.class);     // Catch: Throwable -> L9
    L16:
        return f15993b;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public final void e(int r5) {
        this.f15994a.e(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNotificationManagerService
    public final void a(int r5) {
        this.f15994a.a(r5);
    }
}
