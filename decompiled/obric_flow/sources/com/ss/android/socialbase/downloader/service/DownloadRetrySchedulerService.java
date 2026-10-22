package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.impls.RetrySchedulerImpl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadRetrySchedulerService implements IDownloadRetrySchedulerService {
    public DownloadRetrySchedulerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public final void a(DownloadInfo r5) {
        RetrySchedulerImpl r10 = RetrySchedulerImpl.c();
        r10.getClass();
        if (r5 == null) goto L18;
        String r11 = DownloadConstants.f15275a;
        if (TextUtils.isEmpty("") == false) goto L7;
        return;
    L7:
        if ("".equals(r5.f15839u) == true) goto L10;
        return;
    L10:
        if (r5.g == false) goto L12;
    L15:
        boolean r12 = true;
    L16:
        r10.a(r5, r12, r10.d());
        return;
    L12:
        if (r5.x() == true) goto L15;
        r12 = false;
        goto L16
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public final void b() {
        RetrySchedulerImpl.c().a(2, true);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public final void a() {
        RetrySchedulerImpl.c().a(5, false);
    }
}
