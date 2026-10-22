package com.obric.aikernel.service.res;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.service.foreground.DelayedForegroundServiceRunState;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class DownloadForegroundService extends Service {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f5459g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile Context f5460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile DownloadForegroundService f5461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final DelayedForegroundServiceRunState f5462j = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5463c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final void a(Context r10) {
            if (r10 == null) goto L8;
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L9;
            DownloadForegroundService.d(r11);
            DownloadForegroundService.c().b();
            return;
        L9:
            return;
        }

        public final void b(Context r10) {
            if (r10 == null) goto L8;
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L9;
            DownloadForegroundService.d(r11);
            DownloadForegroundService.c().d();
            return;
        L9:
            return;
        }
    }

    static {
        f5459g = new a(null);
        f5462j = new DelayedForegroundServiceRunState(300000, null, DownloadForegroundService$Companion$runState$1.INSTANCE, DownloadForegroundService$Companion$runState$2.INSTANCE, DownloadForegroundService$Companion$runState$3.INSTANCE, 2, null);
    }

    public DownloadForegroundService() {
    }

    public static final /* synthetic */ Context a() {
        return f5460h;
    }

    public static final /* synthetic */ DownloadForegroundService b() {
        return f5461i;
    }

    public static final /* synthetic */ DelayedForegroundServiceRunState c() {
        return f5462j;
    }

    public static final /* synthetic */ void d(Context r10) {
        f5460h = r10;
    }

    public static final /* synthetic */ void e(DownloadForegroundService r10) {
        r10.h();
    }

    private final Notification f() {
        Notification r10 = new NotificationCompat.Builder(this, "aikernel_download_fgs").setSmallIcon(R.drawable.stat_sys_download).setContentTitle("AIKernel").setContentText("Model resources are downloading").setPriority(-1).setCategory("service").setOngoing(true).setOnlyAlertOnce(true).setSilent(true).build();
        Intrinsics.checkNotNullExpressionValue(r10, "Builder(this, CHANNEL_ID…rue)\n            .build()");
        return r10;
    }

    private final void g() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        Object r10 = getSystemService("notification");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel r11 = new NotificationChannel("aikernel_download_fgs", "AIKernel Download", 2);
        r11.setDescription("Foreground service for AIKernel downloads");
        r11.setSound(null, null);
        r11.enableVibration(false);
        r11.setShowBadge(false);
        r11.setLockscreenVisibility(-1);
        ((NotificationManager) r10).createNotificationChannel(r11);
    }

    private final void h() {
        if (f5462j.f() == false) goto L5;
        return;
    L5:
        AIKLog.INSTANCE.i("DownloadForegroundService", "download idle delay elapsed, stop self");
        stopSelf();
    }

    private final void i() {
        if (this.f5463c == false) goto L11;
        return;
    L11:
        com.obric.aikernel.service.foreground.d.a(this, 2578, f());     // Catch: Exception -> L8
        this.f5463c = true;     // Catch: Exception -> L8
        AIKLog.INSTANCE.i("DownloadForegroundService", "startForeground success");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        AIKLog.INSTANCE.e("DownloadForegroundService", "startForeground failed: " + e);
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f5461i = this;
        g();
        i();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (f5461i != this) goto L6;
        f5461i = null;
    L6:
        if (this.f5463c == false) goto L8;
        stopForeground(1);
        this.f5463c = false;
    L8:
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (this.f5463c == true) goto L6;
        i();
    L6:
        if (f5462j.f() == true) goto L10;
        AIKLog.INSTANCE.i("DownloadForegroundService", "no active download demand after sync, stop self");
        stopSelfResult(r12);
        return 2;
    L10:
        return 2;
    }
}
