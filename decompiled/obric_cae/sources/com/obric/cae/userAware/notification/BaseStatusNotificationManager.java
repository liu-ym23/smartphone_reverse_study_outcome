package com.obric.cae.userAware.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.obric.cae.R;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.log.CaeLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseStatusNotificationManager {
    protected final String CHANNEL_ID;
    protected final int[] NOTIFICATION_IDS;
    protected final String TAG;
    protected final Context mContext;

    public BaseStatusNotificationManager(Context r8, String r10, String r11, int[] r12) {
        this.mContext = r8.getApplicationContext();
        this.TAG = r10;
        this.CHANNEL_ID = r11;
        this.NOTIFICATION_IDS = r12;
        createNotificationChannel();
    }

    public void createNotificationChannel() {
        String r8 = getChannelName();
        String r10 = getChannelDescription();
        NotificationChannel r11 = new NotificationChannel(this.CHANNEL_ID, r8, 4);
        r11.setDescription(r10);
        ((NotificationManager) this.mContext.getSystemService("notification")).createNotificationChannel(r11);
    }

    public void destroy() {
        CaeLog.d(this.TAG, "Manager destroyed");
        Context r8 = this.mContext;
        if (r8 != null) goto L15;
    L13:
        onDestroy();
        return;
    L15:
        NotificationManager r10 = (NotificationManager) r8.getSystemService("notification");     // Catch: Exception -> L11
        if (r10 == null) goto L13;
        int[] r11 = this.NOTIFICATION_IDS;     // Catch: Exception -> L11
        int r12 = r11.length;     // Catch: Exception -> L11
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        r10.cancel(r11[r13]);     // Catch: Exception -> L11
        r13 = r13 + 1;     // Catch: Exception -> L11
        goto L7
    L9:
        CaeLog.d(this.TAG, "Successfully canceled all notifications");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        CaeLog.e(this.TAG, "Error canceling notifications", e);
        goto L13
    }

    public abstract String getChannelDescription();

    public abstract String getChannelName();

    public void onDestroy() {
    }

    public void showNotificationInternal(Intent r8, String r10, String r11, int r12) {
        r8.setFlags(268435456);     // Catch: Exception -> L5
        int r13 = (int) System.currentTimeMillis();     // Catch: Exception -> L5
        PendingIntent r14 = PendingIntent.getActivity(this.mContext, r13, r8, 201326592);     // Catch: Exception -> L5
        Notification.Builder r15 = new Notification.Builder(this.mContext, this.CHANNEL_ID);     // Catch: Exception -> L5
        r15.setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle(r10).setContentText(r11).setContentIntent(r14).setAutoCancel(true);     // Catch: Exception -> L5
        r15.setPriority(1);     // Catch: Exception -> L5
        CaeLog.d(this.TAG, "Created notification object");     // Catch: Exception -> L5
        ((NotificationManager) this.mContext.getSystemService("notification")).notify(r12, r15.build());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(this.TAG, "Error showing notification", e);
    }

    public void trackEvent(String r8, JSONObject r10) {
        ByteIOUtils.trackEvent(r8, r10);     // Catch: Exception -> L5
        CaeLog.d(this.TAG, "Reported event: " + r8);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(this.TAG, "Failed to track event: " + r8, e);
    }
}
