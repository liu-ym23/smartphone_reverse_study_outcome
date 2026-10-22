package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.MultiProcCreater;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadMultiProcService implements IDownloadMultiProcService {
    public DownloadMultiProcService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMultiProcService
    public final void a() {
        MultiProcCreater r5 = new MultiProcCreater();
        Context r10 = DownloadComponentManager.f15515a;
        if (DownloadUtils.b() == false) goto L6;
        return;
    L6:
        if (Logger.b() == false) goto L8;
        Logger.b("DownloadComponentManager", "setIndependentServiceCreator", "Creator: " + r5);
    L8:
        DownloadComponentManager.f = r5;
    }
}
