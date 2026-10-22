package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService;

/* JADX INFO: loaded from: classes3.dex */
public class RetryScheduler implements IDownloadRetrySchedulerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile RetryScheduler f15770b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDownloadRetrySchedulerService f15771a;

    public RetryScheduler() {
        this.f15771a = (IDownloadRetrySchedulerService) DownloadServiceManager.a(IDownloadRetrySchedulerService.class);
    }

    public static RetryScheduler c() {
        if (f15770b != null) goto L16;
        monitor-enter(RetryScheduler.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15770b != null) goto L11;
        f15770b = new RetryScheduler();     // Catch: Throwable -> L9
    L11:
        monitor-exit(RetryScheduler.class);     // Catch: Throwable -> L9
    L16:
        return f15770b;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public final void a(DownloadInfo r5) {
        this.f15771a.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public final void b() {
        this.f15771a.b();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public final void a() {
        this.f15771a.a();
    }
}
