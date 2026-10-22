package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes6.dex */
public class IndependentProcessDownloadService extends DownloadService {
    public IndependentProcessDownloadService() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService
    public void onCreate() {
        super.onCreate();
        b.a(this);
        if (b.Y() != null) goto L5;
        b.a(new u());
    L5:
        this.f15393a = b.E();
        this.f15393a.a(new WeakReference(this));
    }
}
