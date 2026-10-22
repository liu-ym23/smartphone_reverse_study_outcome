package com.obric.cae.userAware.notification;

import android.content.Context;
import android.content.Intent;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.db.SubwayRecordDatabase;
import com.obric.cae.userAware.ui.UserFeedbackActivity;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayStatusManager extends BaseStatusNotificationManager {
    private static final String CHANNEL_ID = "subway_arrival_departure_channel";
    private static final int NOTIFICATION_ID_ENTER = 3001;
    private static final int NOTIFICATION_ID_EXIT = 3002;
    private static final String TAG = "SubwayStatusManager";
    private static volatile SubwayStatusManager sInstance;

    private SubwayStatusManager(Context r8) {
        super(r8, TAG, CHANNEL_ID, new int[]{NOTIFICATION_ID_ENTER, NOTIFICATION_ID_EXIT});
    }

    private String buildNotificationTitle(int r8, String r10) {
        if (r8 != 1) goto L5;
        Context r11 = this.mContext;
        int r12 = R.string.user_aware_subway_action_enter;
    L6:
        String r13 = r11.getString(r12);
        if (r10 == null) goto L13;
        if (r10.equals("NULL") == true) goto L13;
        return String.format(this.mContext.getString(R.string.user_aware_subway_prompt_with_station), new Object[]{r13, r10});
    L13:
        return String.format(this.mContext.getString(R.string.user_aware_subway_prompt_without_station), new Object[]{r13});
    L5:
        r11 = this.mContext;
        r12 = R.string.user_aware_subway_action_exit;
        goto L6
    }

    public static SubwayStatusManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(SubwayStatusManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SubwayStatusManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SubwayStatusManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.obric.cae.userAware.notification.BaseStatusNotificationManager
    public String getChannelDescription() {
        return "Notifications for subway arrival and departure events";
    }

    @Override // com.obric.cae.userAware.notification.BaseStatusNotificationManager
    public String getChannelName() {
        return "Subway Arrival/Departure Reminders";
    }

    @Override // com.obric.cae.userAware.notification.BaseStatusNotificationManager
    public void onDestroy() {
        sInstance = null;
    }

    public void showNotification(int r8, String r10) {
        Intent r11 = new Intent(this.mContext, UserFeedbackActivity.class);     // Catch: Exception -> L8
        r11.putExtra("type", "subway");     // Catch: Exception -> L8
        r11.putExtra("subway_type", r8);     // Catch: Exception -> L8
        r11.putExtra(SubwayRecordDatabase.COLUMN_STATION_NAME, r10);     // Catch: Exception -> L8
        String r12 = buildNotificationTitle(r8, r10);     // Catch: Exception -> L8
        String r13 = this.mContext.getString(R.string.user_aware_notification_content);     // Catch: Exception -> L8
        if (r8 != 1) goto L5;
        int r14 = NOTIFICATION_ID_ENTER;
    L6:
        showNotificationInternal(r11, r12, r13, r14);     // Catch: Exception -> L8
        return;
    L5:
        r14 = NOTIFICATION_ID_EXIT;
    L8:
        e = move-exception;
        CaeLog.e(TAG, "Error showing subway notification", e);
    }
}
