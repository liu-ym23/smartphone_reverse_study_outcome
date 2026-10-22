package com.larus.doc.impl.operation.download;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;
    public final /* synthetic */ IDownloadListener c;

    public /* synthetic */ i(Context r1, int r2, IDownloadListener r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a;
        int r1 = this.b;
        IDownloadListener r2 = this.c;
        Downloader.getInstance(r0).removeMainThreadListener(r1, r2);
    }
}
