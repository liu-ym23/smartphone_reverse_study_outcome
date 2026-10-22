package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class IndependentProcessDownloadService extends DownloadService {
    public IndependentProcessDownloadService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        DownloadComponentManager.a(this);
        if (DownloadComponentManager.f != null) goto L11;
        MultiProcCreater r5 = new MultiProcCreater();
        if (DownloadUtils.b() == true) goto L11;
        if (Logger.b() == false) goto L10;
        Logger.b("DownloadComponentManager", "setIndependentServiceCreator", "Creator: " + r5);
    L10:
        DownloadComponentManager.f = r5;
    L11:
        IDownloadServiceHandler r10 = DownloadComponentManager.p();
        this.f15547a = r10;
        new WeakReference(this);
        r10.getClass();
    }
}
