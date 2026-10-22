package com.obric.assistant.processesmanager;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.larus.utils.logger.FLogger;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/processesmanager/ObricKeepAliveFgService;", "Landroid/app/Service;", "<init>", "()V", "startedInForeground", "", "onCreate", "", "onStartCommand", "", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "flags", "startId", "onDestroy", "onBind", "Landroid/os/IBinder;", "tryStartForeground", "ensureNotificationChannel", "buildNotification", "Landroid/app/Notification;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricKeepAliveFgService extends Service {
    public boolean a;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return null;
    }

    public final Notification a() {
        Notification r0 = new NotificationCompat.Builder(this, "obric_assistant_keep_alive_fgs").setSmallIcon(R.drawable.stat_sys_download).setContentTitle("assistant").setContentText("assistant is running").setPriority(-1).setCategory("service").setOngoing(true).setOnlyAlertOnce(true).setSilent(true).build();
        r0.extras.putBoolean("obric_foreground_notification_show", false);
        return r0;
    }

    public final void b() {
        if (this.a == false) goto L5;
        return;
    L5:
        FLogger.a.i("ObricKeepAliveFgService", "tryStartForeground");
        startForeground(2580, a());     // Catch: Exception -> L8
        this.a = true;     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e("ObricKeepAliveFgService", "startForeground failed: " + e);
        stopSelf();
    }

    @Override // android.app.Service
    public final void onCreate() {
        FLogger.a.i("ObricKeepAliveFgService", "onCreate");
        super.onCreate();
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Object r0 = getSystemService("notification");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel r1 = new NotificationChannel("obric_assistant_keep_alive_fgs", "Obric Keep Alive", 1);
        r1.setDescription("Foreground service for Obric keep alive");
        r1.setSound(null, null);
        r1.enableVibration(false);
        r1.setShowBadge(false);
        r1.setLockscreenVisibility(-1);
        ((NotificationManager) r0).createNotificationChannel(r1);
    L6:
        b();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        FLogger.a.i("ObricKeepAliveFgService", "onDestroy: " + this.a);
        if (this.a == false) goto L5;
        stopForeground(1);
        this.a = false;
    L5:
        super.onDestroy();
    }

    public ObricKeepAliveFgService() {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r1, int r2, int r3) {
        if (this.a == true) goto L7;
        b();
        return 2;
    L7:
        return 2;
    }
}
