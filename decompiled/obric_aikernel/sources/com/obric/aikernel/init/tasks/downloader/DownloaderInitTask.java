package com.obric.aikernel.init.tasks.downloader;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.ss.android.socialbase.downloader.service.DownloadServiceLoader;
import jb.f;
import jb.g;
import lb.a;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class DownloaderInitTask extends d {
    public DownloaderInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        f.x(new DownloadServiceLoader());
        AppContext r10 = AppContext.INSTANCE;
        f.v(new g(r10.getContext()));
        if (r10.isDebug() == false) goto L5;
    L8:
        int r11 = 3;
    L9:
        a.e(r11);
        return;
    L5:
        if (r10.isLocalTest() == true) goto L8;
        r11 = 4;
        goto L9
    }
}
