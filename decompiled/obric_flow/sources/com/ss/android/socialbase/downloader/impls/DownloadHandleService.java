package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadHandleService extends Service {
    public DownloadHandleService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        DownloadComponentManager.a(this);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r5, int r10, int r11) {
        super.onStartCommand(r5, r10, r11);
        if (r5 == null) goto L35;
        String r12 = r5.getAction();
        if (TextUtils.isEmpty(r12) == true) goto L36;
        int r13 = r5.getIntExtra("extra_download_id", 0);
        if (r13 != 0) goto L12;
        return 2;
    L12:
        if (r12.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP") == false) goto L17;
        if (Logger.b() == false) goto L30;
        Logger.a("DownloadHandleService", r13, "handleIntent", "Retry delay disable");
        return 2;
    L30:
        return 2;
    L17:
        if (r12.equals("com.ss.android.downloader.action.PROCESS_NOTIFY") == false) goto L26;
        DownloadProcessDispatcher r14 = DownloadProcessDispatcher.a();
        if (r13 != 0) goto L21;
        r14.getClass();
        return 2;
    L21:
        r14.a(r13, true);
        IDownloadProxy r15 = DownloadProxy.a(true);
        if (r15 == null) goto L38;
        r15.c();
        return 2;
    L38:
        return 2;
    L26:
        if (r12.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY") == false) goto L34;
        DownloadComponentManager.v();
        return 2;
    L34:
        return 2;
    L36:
        return 2;
    L35:
        return 2;
    }
}
