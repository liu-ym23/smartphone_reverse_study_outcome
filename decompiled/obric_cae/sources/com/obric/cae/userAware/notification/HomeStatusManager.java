package com.obric.cae.userAware.notification;

import android.content.Context;
import android.content.Intent;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.ui.UserFeedbackActivity;
import com.obric.cae.userAware.utils.UserAwareUtil;

/* JADX INFO: loaded from: classes2.dex */
public class HomeStatusManager extends BaseStatusNotificationManager {
    private static final String CHANNEL_ID = "home_arrival_departure_channel";
    private static final int NOTIFICATION_ID = 2001;
    private static final String TAG = "HomeStatusManager";
    private static volatile HomeStatusManager sInstance;

    private HomeStatusManager(Context r8) {
        super(r8, TAG, CHANNEL_ID, new int[]{NOTIFICATION_ID});
    }

    public static HomeStatusManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(HomeStatusManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new HomeStatusManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(HomeStatusManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.obric.cae.userAware.notification.BaseStatusNotificationManager
    public String getChannelDescription() {
        return "Notifications for home arrival and departure events";
    }

    @Override // com.obric.cae.userAware.notification.BaseStatusNotificationManager
    public String getChannelName() {
        return "Home Arrival/Departure Reminders";
    }

    @Override // com.obric.cae.userAware.notification.BaseStatusNotificationManager
    public void onDestroy() {
        sInstance = null;
    }

    public void showNotification(String r8) {
        Intent r10 = new Intent(this.mContext, UserFeedbackActivity.class);     // Catch: Exception -> L4
        r10.putExtra("state", r8);     // Catch: Exception -> L4
        r10.putExtra("type", "home");     // Catch: Exception -> L4
        showNotificationInternal(r10, String.format(this.mContext.getString(R.string.user_aware_notification_prompt), new Object[]{UserAwareUtil.getStateChangeString(this.mContext, r8)}), this.mContext.getString(R.string.user_aware_notification_content), NOTIFICATION_ID);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "Error showing notification for location value: " + r8, e);
    }
}
