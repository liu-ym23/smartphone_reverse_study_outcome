package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadTaskInterceptModule extends AbsDownloadModule {
    public DownloadTaskInterceptModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule
    public final AbsDownloadModule a(DownloadCommonParams r5) {
        DownloadInfo r10 = r5.f15310c;
        if (r10.b1 == false) goto L5;
        return null;
    L5:
        if (r5.f15309b.f15881h != null) goto L7;
        return null;
    L7:
        if (r10.V != null) goto L13;
        r10.d();
        boolean r11 = false;
        if (r10.T0.optInt("ignore_intercept", 0) != 1) goto L11;
        r11 = true;
    L11:
        r10.V = Boolean.valueOf(r11);
    L13:
        if (r10.V.booleanValue() == false) goto L16;
        return null;
    L16:
        return super.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L13;
        Logger.a("DownloadTaskInterceptModule", this.f15290c, "proceed", "Run");
    L13:
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        r5.c();
        return;
    L6:
        if (this.f15289b.f15881h.a() == false) goto L11;
        DownloadCommonParams r10 = this.f;     // Catch: Throwable -> L9
        r10.f = RunStatus.g;     // Catch: Throwable -> L9
    }
}
