package com.ss.android.socialbase.downloader.impls;

import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.volcengine.zeus.service.PluginService;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadHandleService extends PluginService {
    public DownloadHandleService() {
    }

    private void a(Intent r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        String r2 = r3.getAction();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        int r4 = r3.getIntExtra("extra_download_id", 0);
        if (r4 != 0) goto L11;
        return;
    L11:
        if (r2.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP") == false) goto L16;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L22;
        com.ss.android.socialbase.downloader.e.a.b("DownloadHandleService", r4, "handleIntent", "Retry delay disable");
        return;
    L22:
        return;
    L16:
        if (r2.equals("com.ss.android.downloader.action.PROCESS_NOTIFY") == false) goto L19;
        com.ss.android.socialbase.downloader.downloader.c.a().n(r4);
        return;
    L19:
        if (r2.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY") == false) goto L25;
        com.ss.android.socialbase.downloader.downloader.b.b();
        return;
    }

    public IBinder onBind(Intent r1) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        com.ss.android.socialbase.downloader.downloader.b.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent r1, int r2, int r3) {
        super/*android.app.Service*/.onStartCommand(r1, r2, r3);
        a(r1);
        return 2;
    }
}
