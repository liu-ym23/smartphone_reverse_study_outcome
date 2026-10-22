package com.ss.android.socialbase.downloader.core.module;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadMimeTypeInterceptModule extends AbsDownloadModule {
    public DownloadMimeTypeInterceptModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        if (r5.f15310c.b1 == true) goto L7;
        Context r10 = DownloadComponentManager.f15515a;
        return null;
    L7:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L6;
        Logger.a("DownloadMimeTypeInterceptModule", this.f15290c, "proceed", "Run");
    L6:
        if (TextUtils.isEmpty(this.f15290c.f15839u) == true) goto L8;
        a(this.f15290c);
    L8:
        r5.c();
    }

    public static boolean a(DownloadInfo r5) {
        if (r5.b1 == true) goto L7;
        Context r10 = DownloadComponentManager.f15515a;
        return false;
    L7:
        return false;
    }
}
