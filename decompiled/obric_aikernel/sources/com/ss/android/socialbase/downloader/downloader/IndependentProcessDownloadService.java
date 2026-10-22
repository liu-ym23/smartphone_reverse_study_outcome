package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;
import jb.o;

/* JADX INFO: loaded from: classes2.dex */
public class IndependentProcessDownloadService extends DownloadService {
    public IndependentProcessDownloadService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        a.l0(this);
        if (a.J() != null) goto L5;
        a.A0(new c());
    L5:
        o r10 = a.I();
        this.f7886c = r10;
        r10.c(new WeakReference(this));
    }
}
