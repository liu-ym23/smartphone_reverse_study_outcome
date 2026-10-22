package com.obric.cae.userAware.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
final class PoiArrivalNotificationHelper {
    static final int NOTIFICATION_ID = 20260616;

    private PoiArrivalNotificationHelper() {
    }

    public static void cancel(Context r8) {
        NotificationManager r10 = (NotificationManager) r8.getSystemService("notification");
        if (r10 != null) goto L5;
        return;
    L5:
        r10.cancel(NOTIFICATION_ID);
    }

    public static void createChannel(Context r8, String r10, String r11, String r12) {
        NotificationManager r13 = (NotificationManager) r8.getSystemService("notification");
        if (r13 != null) goto L5;
        return;
    L5:
        NotificationChannel r14 = new NotificationChannel(r10, r11, 4);
        r14.setDescription(r12);
        r13.createNotificationChannel(r14);
    }

    public static void show(Context r8, String r10, String r11, Class<?> r12, String r13, String r14) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
    L8:
        NotificationManager r15 = (NotificationManager) r8.getSystemService("notification");
        if (r15 != null) goto L11;
        return;
    L11:
        Intent r16 = new Intent(r8, r12);
        r16.addFlags(872415232);
        PendingIntent r17 = PendingIntent.getActivity(r8, 0, r16, 201326592);
        Notification.Builder r18 = new Notification.Builder(r8, r11);
        r18.setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle(r13).setContentText(r14).setStyle(new Notification.BigTextStyle().bigText(r14)).setContentIntent(r17).setAutoCancel(true).setPriority(1);
        r15.notify(NOTIFICATION_ID, r18.build());
        return;
    L5:
        if (r8.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) goto L8;
        CaeLog.w(r10, "skip notification without POST_NOTIFICATIONS");
    }
}
