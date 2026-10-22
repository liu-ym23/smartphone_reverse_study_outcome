package com.ss.android.socialbase.downloader.service;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadGlobalThrottleService implements IDownloadGlobalThrottleService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f16094a;

    public DownloadGlobalThrottleService() {
        this.f16094a = new SparseArray();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public final void a(final DownloadTask r5) {
        LruCache r10 = DownloadSetting.e;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("global_throttle_enable", 0) > 0) goto L6;
        return;
    L6:
        if (Logger.a(r5.f15878a) == false) goto L9;
        Logger.a("globalThrottle", r5.f15878a, "start", "start throttle!");
    L9:
        if (DownloadUtils.a() == false) goto L12;
        DownloadComponentManager.o().submit(new AnonymousClass1(this, r5));
        return;
    L12:
        c(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public final void b(final DownloadTask r5) {
        LruCache r10 = DownloadSetting.e;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("global_throttle_enable", 0) > 0) goto L5;
        return;
    L5:
        DownloadComponentManager.o().submit(new AnonymousClass2(this, r5));
    }

    public final void c(DownloadTask r5) {
        if (Logger.a(r5.f15878a) == false) goto L5;
        Logger.a("globalThrottle", r5.f15878a, "addTaskAndThrottleSpeedReset", "add to map!");
    L5:
        SparseArray r10 = this.f16094a;
        monitor-enter(r10);
        this.f16094a.put(r5.e(), r5);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
