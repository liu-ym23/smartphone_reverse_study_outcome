package com.ss.android.socialbase.downloader.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.downloader.a;
import pb.d;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadNotificationService extends Service {
    public DownloadNotificationService() {
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.l0(this);
        d.f().i();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d.f().k();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        d.f().g(r10);
        return 2;
    }
}
