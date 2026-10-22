package com.obric.cae.BWDL.BwdlDrop.activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.h;
import androidx.core.app.i;
import androidx.core.app.j;
import androidx.core.app.q;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropSession;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import defpackage.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropNotification {
    private static final String CHANNEL_ID = "bwdl_drop_transferring_channel_id_2";
    private static final String CHANNEL_NAME = "bwdl drop 2";
    private static final int NOTIFICATION_ID = 12345678;
    private static final String TAG = "BwdlDropNotification";
    private boolean ActionAdd;
    private j builder;
    private CharSequence contentTitle;
    private boolean isTransferrFinish;
    private boolean isTransferring;
    private Context mContext;
    private int mDeviceId;
    private String mDeviceName;
    private boolean mDirection;
    private h mDismissAction;
    private CharSequence mDropDialogMessage;
    private String mDropReceivingMessage;
    private String mDropTransferFailedMessage;
    private String mDropTransferFileMessage;
    private int mDropTransferProcess;
    private String mDropTransferSucessMessage;
    private int mFileCount;
    private Intent mIntent;
    private NotificationChannel mNotificationChannel;
    private NotificationManager mNotificationManager;
    private BwdlDropSession mSession;
    private Handler mUiHandler;

    public BwdlDropNotification(Context r8, BwdlDropSession r10, int r11) {
        this.mDropTransferProcess = 0;
        this.mDropDialogMessage = "";
        this.ActionAdd = false;
        this.isTransferring = true;
        this.isTransferrFinish = true;
        this.mContext = r8.getApplicationContext();
        this.mSession = r10;
        this.mDeviceId = r11;
        init();
    }

    private void destroyNotificationChannel() {
        CaeLog.d(TAG, "destroyNotificationChannel:bwdl_drop_transferring_channel_id_2");
        this.mNotificationManager.cancel(NOTIFICATION_ID);
        this.mNotificationManager.deleteNotificationChannel(CHANNEL_ID);
        this.mNotificationChannel = null;
    }

    private void init() {
        this.mUiHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        NotificationChannel r8 = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 4);
        this.mNotificationChannel = r8;
        r8.setDescription("bwdl drop notification channel");
        boolean r10 = true;
        this.mNotificationChannel.enableLights(true);
        this.mNotificationChannel.setImportance(4);
        this.mNotificationManager.createNotificationChannel(this.mNotificationChannel);
        this.builder = new j(this.mContext, CHANNEL_ID);
        Intent r11 = new Intent(this.mContext, BwdlDropTransferControlActivity.class);
        this.mIntent = r11;
        r11.setAction("com.obric.ACTION_START_BWDL_DROP_TRANSFER_CONTROL");
        this.mIntent.putExtra("device_id", this.mDeviceId);
        StringBuilder r12 = new StringBuilder("mSession:");
        r12.append(this.mSession);
        r12.append("  ");
        a.j(r12, this.mDeviceId, TAG);
        BwdlDropSession r13 = this.mSession;
        if (r13 == null) goto L8;
        this.mDeviceName = r13.getRemoteDeviceName();
        this.mFileCount = this.mSession.getFileCount();
        if (this.mSession.getDirection() == 1) goto L8;
        r10 = false;
    L8:
        this.mDirection = r10;
    }

    public void cancelNotification() {
        this.mNotificationManager.cancel(NOTIFICATION_ID);
    }

    public void clearup() {
        this.mUiHandler.removeCallbacksAndMessages(null);
        destroyNotificationChannel();
        this.ActionAdd = false;
    }

    public boolean isChannelExists(String r8) {
        NotificationChannel r10 = this.mNotificationManager.getNotificationChannel(r8);
        CaeLog.d(TAG, "isChannelExists " + r10);
        if (r10 == null) goto L5;
        destroyNotificationChannel();
    L5:
        if (r10 == null) goto L7;
        return true;
    L7:
        return false;
    }

    public void notifyTransferFailed() {
        this.isTransferring = false;
        this.isTransferrFinish = false;
        showNotification();
    }

    public void notifyTransferSuccess() {
        this.isTransferring = false;
        this.isTransferrFinish = true;
        showNotification();
    }

    public void notifyTransferring() {
        this.isTransferring = true;
        showNotification();
    }

    public void showNotification() {
        this.mDropReceivingMessage = this.mContext.getResources().getString(R.string.drop_receiving);
        this.mDropTransferFailedMessage = this.mContext.getResources().getString(R.string.drop_incoming_transfer_failed_info);
        this.mDropTransferSucessMessage = this.mContext.getResources().getString(R.string.drop_incoming_transfer_success_info);
        this.mDropTransferFileMessage = this.mContext.getResources().getString(R.string.drop_incoming_transfering);
        PendingIntent r8 = PendingIntent.getActivity(this.mContext, 0, this.mIntent, 67108864);
        Bundle r10 = new Bundle();
        r10.putBoolean("status_bar_use_app_icon", false);
        r10.putBoolean("small_icon_use_app_icon", false);
        boolean r11 = BwdlDropUtils.shouldClipToCircle(this.mContext);
        CaeLog.d(TAG, "iconRound:" + r11);
        if (r11 == false) goto L5;
        int r12 = R.drawable.bwdl_drop_round;
    L6:
        h.a r13 = new h.a(r12, this.mContext.getString(R.string.drop_notification_close_button), r8);
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        if (r14.isEmpty() == false) goto L9;
        q[] r16 = null;
    L11:
        if (r15.isEmpty() == false) goto L13;
        q[] r17 = null;
    L14:
        this.mDismissAction = new h(r13.f1602a, r13.f1603b, r13.f1604c, r13.f1606e, r17, r16, r13.f1605d, 0, r13.f1607f, false, false);
        j r18 = this.builder;
        r18.f1627s.icon = r12;
        r18.f(8, true);
        j r19 = this.builder;
        r19.f1624p = -16777216;
        r19.f(2, true);
        j r20 = this.builder;
        r20.f1627s.vibrate = new long[]{200};
        r20.f1615g = 1;
        r20.f1623o = r10;
        i r21 = new i();
        r21.f1608b = j.c("");
        r20.g(r21);
        if (this.isTransferring == false) goto L31;
        if (this.mDirection != true) goto L19;
        this.builder.e(String.format(this.mDropReceivingMessage, new Object[]{Integer.valueOf(this.mDropTransferProcess)}));
    L20:
        j r22 = this.builder;
        int r23 = this.mDropTransferProcess;
        r22.f1619k = 100;
        r22.f1620l = r23;
        r22.f1621m = false;
        if (this.mDirection != true) goto L23;
        String r24 = String.format(this.mContext.getResources().getString(R.string.drop_incoming_transfer_file_info), new Object[]{this.mDeviceName, Integer.valueOf(this.mFileCount)});
    L24:
        this.builder.d(r24);
        String r25 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        j r26 = this.builder;
        r26.getClass();
        r26.f1618j = j.c(r25);
        if (this.ActionAdd == true) goto L38;
        this.ActionAdd = true;
        j r27 = this.builder;
        h r28 = this.mDismissAction;
        if (r28 == null) goto L29;
        r27.f1610b.add(r28);
        goto L38
    L29:
        r27.getClass();
    L38:
        this.mNotificationManager.notify(NOTIFICATION_ID, this.builder.b());
        return;
    L23:
        r24 = String.format(this.mContext.getResources().getString(R.string.drop_transferring_notification_file_info), new Object[]{this.mDeviceName, Integer.valueOf(this.mFileCount)});
        goto L24
    L19:
        this.builder.e(this.mDropTransferFileMessage);
        goto L20
    L31:
        if (this.isTransferrFinish != true) goto L33;
        String r29 = String.format(this.mDropTransferSucessMessage, new Object[]{this.mDeviceName, Integer.valueOf(this.mFileCount)});
        this.builder.e(this.mContext.getString(R.string.drop_transfer_success));
    L36:
        this.builder.d(r29);
    L37:
        j r30 = this.builder;
        r30.f1619k = 0;
        r30.f1620l = 0;
        r30.f1621m = false;
        r30.getClass();
        r30.f1618j = j.c(null);
        this.builder.f1610b.clear();
        goto L38
    L33:
        r29 = String.format(this.mDropTransferFailedMessage, new Object[]{this.mDeviceName, Integer.valueOf(this.mFileCount)});
        this.builder.e(this.mContext.getString(R.string.drop_transfer_failed));
        if (this.mDirection != true) goto L36;
        this.builder.d(this.mContext.getString(R.string.drop_transfer_failed_message));
        goto L37
    L13:
        r17 = (q[]) r15.toArray(new q[r15.size()]);
        goto L14
    L9:
        r16 = (q[]) r14.toArray(new q[r14.size()]);
        goto L11
    L5:
        r12 = R.drawable.bwdl_drop_square;
        goto L6
    }

    public void updateTransferProcess(int r8) {
        this.mDropTransferProcess = r8;
        showNotification();
    }
}
