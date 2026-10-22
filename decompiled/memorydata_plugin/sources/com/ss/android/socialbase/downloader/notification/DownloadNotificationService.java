package com.ss.android.socialbase.downloader.notification;

import android.content.Intent;
import android.os.IBinder;
import com.volcengine.zeus.service.PluginService;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadNotificationService extends PluginService {
    public DownloadNotificationService() {
    }

    public IBinder onBind(Intent r1) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        com.ss.android.socialbase.downloader.downloader.b.a(this);
        d.a().b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Service*/.onDestroy();
        d.a().c();
    }

    public int onStartCommand(Intent r1, int r2, int r3) {
        d.a().a(r1);
        return 2;
    }
}
