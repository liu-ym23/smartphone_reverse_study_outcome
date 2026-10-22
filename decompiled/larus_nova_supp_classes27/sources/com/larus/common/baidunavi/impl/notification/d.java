package com.larus.common.baidunavi.impl.notification;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final d a = null;
    public static Bitmap b;

    static {
        a = new d();
    }

    public d() {
    }

    public static void a() {
        NotificationManagerCompat r0 = NotificationManagerCompat.from(AppHost.a.getApplication());
        if (Build.VERSION.SDK_INT < 26) goto L6;
        NotificationChannel r1 = new NotificationChannel("navigation_channel", "navigation", 3);
        r1.enableVibration(false);
        r1.setLockscreenVisibility(1);
        r1.setSound(null, null);
        r0.createNotificationChannel(r1);
        return;
    }

    public static Notification b(String r7, String r8, Integer r9, Bitmap r10) {
        AppHost.Companion r1 = AppHost.a;
        Intent r0 = new Intent(r1.getApplication(), BaiduNaviNotificationActivity.class);
        Application r2 = r1.getApplication();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r3 = 201326592;
    L6:
        PendingIntent r4 = PendingIntent.getActivity(r2, 0, r0, r3);
        b = null;
        if (r10 == null) goto L9;
        b = r10;
    L11:
        Bitmap r11 = b;
        if (r11 != null) goto L14;
    L16:
        r11 = null;
    L22:
        return new NotificationCompat.Builder(r1.getApplication(), "navigation_channel").setContentIntent(r4).setShowWhen(false).setSound(null).setContentTitle(r7).setContentText(r8).setSmallIcon(r1.b()).setLargeIcon(r11).setAutoCancel(false).setOngoing(false).setPriority(0).setCategory("navigation").setVisibility(1).build();
    L19:
        e = move-exception;
        FLogger.a.e("BaiduNaviNotificationManager", "Notification build fails", e);
        g.a.ensureNotReachHere(e, "BaiduNaviNotificationManager");
        return null;
    L14:
        if (r11.isRecycled() == false) goto L22;
        FLogger.a.e("BaiduNaviNotificationManager", "mLatestLargeIcon is recycled");
        goto L16
    L9:
        if (r9 == null) goto L11;
        b = BitmapFactory.decodeResource(r1.getApplication().getResources(), r9.intValue());
        goto L11
    L5:
        r3 = 134217728;
        goto L6
    }

    public static void c(String r3, String r4, Integer r5, Bitmap r6, int r7) {
        d r0 = a;
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = null;
    L8:
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r3, "title");     // Catch: Throwable -> L25
        Notification r8 = b(r3, r4, r5, r6);     // Catch: Throwable -> L25
        BaiduNaviForegroundService r9 = BaiduNaviForegroundService.b;     // Catch: Throwable -> L25
        if (r9 != null) goto L12;
    L23:
        monitor-exit(r0);
        return;
    L12:
        if (r8 != null) goto L29;
        FLogger.a.i("BaiduNaviForegroundService", "ignore starting foreground service due to null");     // Catch: Throwable -> L25
        goto L23
    L29:
    L21:
        e = move-exception;
        FLogger.a.e("BaiduNaviForegroundService", "fail starting foreground service", e);     // Catch: Throwable -> L25
        goto L23
    L16:
        if (Build.VERSION.SDK_INT < 34) goto L18;
        r9.startForeground(106, r8, 8);     // Catch: Exception -> L21 Throwable -> L25
    L19:
        FLogger.a.i("BaiduNaviForegroundService", "succeed starting foreground service");     // Catch: Exception -> L21 Throwable -> L25
    L18:
        r9.startForeground(106, r8);     // Catch: Exception -> L21 Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
