package com.obric.cae.userAware.datacollection;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.widget.Toast;
import androidx.core.app.j;
import androidx.core.app.n;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.OemHarInfoManager;
import com.obric.cae.userAware.utils.UserAwareUtil;
import defpackage.a;

/* JADX INFO: loaded from: classes2.dex */
public class HARNotification {
    private static final String ACTION_ANSWER_FALSE = "ACTION_FALSE";
    private static final String ACTION_ANSWER_TRUE = "ACTION_TRUE";
    private static final String CHANNEL_ID = "HAR_STATE_CHANNEL";
    private static final int DEFAULT_CURRENT_STATE = -1;
    private static final int DELAY_FOR_UPLOAD_RAW_DATA_FILE = 30000;
    private static final int DURATION_100_MS = 100;
    private static final int NOTIFICATION_ID = 1;
    private static final String TAG = "HARNotification";

    @SuppressLint({"StaticFieldLeak"})
    private static HARNotification instance;
    private final BroadcastReceiver answerReceiver;
    private final Context mContext;
    private int mCurrentState;
    private Toast mToast;
    private n notificationManager;

    public HARNotification(Context r8) {
        this.mCurrentState = -1;
        this.answerReceiver = new AnonymousClass1(this);
        this.mContext = r8;
        initHARNotification();
    }

    private void VibrateDevice(int r8) {
        Vibrator r10 = (Vibrator) this.mContext.getSystemService("vibrator");
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.hasVibrator() == false) goto L9;
        r10.vibrate(VibrationEffect.createOneShot(r8, -1));
        return;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ String access$100(HARNotification r8, int r10) {
        return r8.getStringFromXML(r10);
    }

    public static /* synthetic */ Context access$200(HARNotification r8) {
        return r8.mContext;
    }

    public static /* synthetic */ void access$300(HARNotification r8, int r10) {
        r8.VibrateDevice(r10);
    }

    public static /* synthetic */ void access$400(HARNotification r8, String r10) {
        r8.showToast(r10);
    }

    private void createNotificationChannel() {
        CaeLog.d(TAG, "createNotificationChannel");
        NotificationChannel r8 = new NotificationChannel(CHANNEL_ID, "HAR_state", 4);
        r8.setDescription("HAR state notification");
        r8.setLockscreenVisibility(1);
        ((NotificationManager) this.mContext.getSystemService(NotificationManager.class)).createNotificationChannel(r8);
    }

    public static synchronized HARNotification getInstance(Context r8) {
        monitor-enter(HARNotification.class);
        if (r8 == null) goto L14;
        if (instance != null) goto L8;
        instance = new HARNotification(r8);     // Catch: Throwable -> L11
    L8:
        HARNotification r10 = instance;     // Catch: Throwable -> L11
        monitor-exit(HARNotification.class);
        return r10;
    L14:
        throw new IllegalArgumentException("Context cannot be null");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private String getStringFromXML(int r8) {
        return UserAwareUtil.getStringValueFromXML(this.mContext, r8);
    }

    private void initHARNotification() {
        CaeLog.d(TAG, "initHARNotification");
        createNotificationChannel();
        this.notificationManager = new n(this.mContext);
        IntentFilter r8 = a.c(ACTION_ANSWER_TRUE, ACTION_ANSWER_FALSE);
        Context r10 = this.mContext;
        BroadcastReceiver r11 = this.answerReceiver;
        Object r12 = androidx.core.content.a.f1674a;
        if (f0.a.a() == false) goto L5;
        androidx.core.content.a.e.a(r10, r11, r8, null, null, 4);
    L6:
        sendNotification(Settings.Global.getInt(this.mContext.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_STATE, -1));
        return;
    L5:
        androidx.core.content.a.d.a(r10, r11, r8, null, null, 4);
        goto L6
    }

    public static synchronized void release() {
        monitor-enter(HARNotification.class);
        HARNotification r8 = instance;     // Catch: Throwable -> L6 IllegalArgumentException -> L8
        r8.mContext.unregisterReceiver(r8.answerReceiver);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
    L10:
        n r10 = instance.notificationManager;     // Catch: Throwable -> L6
        if (r10 == null) goto L13;
        r10.f1640b.cancel(null, 1);     // Catch: Throwable -> L6
    L13:
        Toast r11 = instance.mToast;     // Catch: Throwable -> L6
        if (r11 == null) goto L16;
        r11.cancel();     // Catch: Throwable -> L6
        instance.mToast = null;     // Catch: Throwable -> L6
    L16:
        instance = null;     // Catch: Throwable -> L6
        CaeLog.d(TAG, "HARNotification resources released");     // Catch: Throwable -> L6
        monitor-exit(HARNotification.class);
        return;
    L8:
        e = move-exception;
        CaeLog.w(TAG, "Receiver not registered: " + e.getMessage());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void sendNotification(int r10) {
        CaeLog.d(TAG, "sendNotification: " + r10);
        String r8 = getStringFromXML(R.string.user_aware_har_notification_content) + UserAwareUtil.getHarStateString(this.mContext, r10);
        Intent r11 = new Intent(ACTION_ANSWER_TRUE);
        r11.putExtra("EXTRA_CURRENT_STATE", r10);
        PendingIntent r12 = PendingIntent.getBroadcast(this.mContext, 0, r11, 201326592);
        Intent r13 = new Intent(ACTION_ANSWER_FALSE);
        r13.putExtra("EXTRA_CURRENT_STATE", r10);
        PendingIntent r14 = PendingIntent.getBroadcast(this.mContext, 1, r13, 201326592);
        j r15 = new j(this.mContext, CHANNEL_ID);
        r15.f1627s.icon = R.drawable.ic_launcher_foreground;
        r15.e(getStringFromXML(R.string.user_aware_har_notification_title));
        r15.d(r8);
        r15.f1615g = 1;
        r15.f1622n = "msg";
        r15.f(16, false);
        r15.f(2, true);
        r15.f(8, true);
        Notification r16 = r15.f1627s;
        r16.sound = null;
        r16.audioStreamType = -1;
        r16.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
        r15.a(getStringFromXML(R.string.user_aware_har_select_true), r12);
        r15.a(getStringFromXML(R.string.user_aware_har_select_false), r14);
        if (androidx.core.content.a.a(this.mContext, "android.permission.POST_NOTIFICATIONS") != 0) goto L27;
        n r17 = this.notificationManager;
        Notification r18 = r15.b();
        r17.getClass();
        Bundle r19 = r18.extras;
        if (r19 != null) goto L7;
    L9:
        boolean r20 = false;
    L10:
        NotificationManager r21 = r17.f1640b;
        if (r20 == false) goto L23;
        n.a r22 = new n.a(r17.f1639a.getPackageName(), r18);
        Object r23 = n.f1637f;
        monitor-enter(r23);
    L20:
        th = move-exception;
        throw th;
    L15:
        if (n.f1638g != null) goto L17;
        n.f1638g = new n.c(r17.f1639a.getApplicationContext());     // Catch: Throwable -> L20
    L17:
        n.f1638g.f1648b.obtainMessage(0, r22).sendToTarget();     // Catch: Throwable -> L20
        monitor-exit(r23);     // Catch: Throwable -> L20
        r21.cancel(null, 1);
        return;
    L23:
        r21.notify(null, 1, r18);
        return;
    L7:
        if (r19.getBoolean("android.support.useSideChannel") == false) goto L9;
        r20 = true;
        goto L10
    }

    private void showToast(String r8) {
        Toast r10 = this.mToast;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        Toast r11 = Toast.makeText(this.mContext, r8, 0);
        this.mToast = r11;
        r11.show();
    }

    public void updateNotification(int r8) {
        if (OemHarInfoManager.getInstance(null).isHarEnableNotification() == true) goto L6;
        return;
    L6:
        if (this.mCurrentState != r8) goto L8;
        return;
    L8:
        this.mCurrentState = r8;
        sendNotification(r8);
    }
}
