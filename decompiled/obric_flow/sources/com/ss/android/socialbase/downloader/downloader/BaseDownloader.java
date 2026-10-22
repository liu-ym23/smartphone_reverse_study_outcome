package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;

/* JADX INFO: loaded from: classes3.dex */
abstract class BaseDownloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDownloadProcessDispatcherService f15513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDownloadComponentManagerService f15514b;

    static {
        IDownloadGlobalThrottleService r5 = (IDownloadGlobalThrottleService) DownloadServiceManager.a(IDownloadGlobalThrottleService.class);
    }

    public BaseDownloader() {
        this.f15513a = (IDownloadProcessDispatcherService) DownloadServiceManager.a(IDownloadProcessDispatcherService.class);
        this.f15514b = (IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class);
    }
}
