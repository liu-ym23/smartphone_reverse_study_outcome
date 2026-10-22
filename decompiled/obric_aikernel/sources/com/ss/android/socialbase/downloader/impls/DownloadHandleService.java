package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadHandleService extends Service {
    public DownloadHandleService() {
    }

    private void a(Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r11 = r10.getAction();
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return;
    L7:
        int r12 = r10.getIntExtra("extra_download_id", 0);
        if (r12 != 0) goto L11;
        return;
    L11:
        if (r11.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP") == false) goto L16;
        if (lb.a.a() == false) goto L22;
        lb.a.h("DownloadHandleService", r12, "handleIntent", "Retry delay disable");
        return;
    L22:
        return;
    L16:
        if (r11.equals("com.ss.android.downloader.action.PROCESS_NOTIFY") == false) goto L19;
        jb.c.i().n(r12);
        return;
    L19:
        if (r11.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY") == false) goto L25;
        com.ss.android.socialbase.downloader.downloader.a.s0();
        return;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.a.l0(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        super.onStartCommand(r10, r11, r12);
        a(r10);
        return 2;
    }
}
