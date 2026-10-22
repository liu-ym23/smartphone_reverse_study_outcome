package com.ss.android.socialbase.downloader.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNotificationService extends Service {
    public DownloadNotificationService() {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r5) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        DownloadComponentManager.a(this);
        DownloadNotificationServiceImpl.a().b();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        DownloadNotificationServiceImpl r5 = DownloadNotificationServiceImpl.a();
        r5.getClass();
        if (DownloadSetting.f.a("enable_target_34", 0) <= 0) goto L6;
        return;
    L6:
        if (r5.d == null) goto L15;
        r5.d.a();     // Catch: Throwable -> L11
    L9:
        r5.d = null;
        return;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r5, int r10, int r11) {
        DownloadNotificationServiceImpl.a().a(r5);
        return 2;
    }
}
