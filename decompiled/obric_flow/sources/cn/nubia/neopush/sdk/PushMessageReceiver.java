package cn.nubia.neopush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PushMessageReceiver extends BroadcastReceiver {
    Context context;

    public PushMessageReceiver() {
    }

    public final void doNubiaCode(Context r5) {
    }

    public final Context getContext() {
        return this.context;
    }

    public void onCommandResult(NeoPushCommandMessage r5) {
    }

    public void onNotificationMessageClick(NeoPushMessage r5) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r5, Intent r10) {
        this.context = r5;
        NeoLog.i("zpy", "PushMessageReceiver onReceive=" + r5.getPackageName());     // Catch: Exception -> L9
        if (r10 != null) goto L6;
        return;
    L6:
        if (Constant.RECEIVE_MESSAGE_ACTION.equals(r10.getAction()) == false) goto L15;
        NeoLog.i("zpy", "PushMessageReceiver onReceive=" + r10.getAction());     // Catch: Exception -> L9
        MessageHandleService.addJob(new MessageHandleService.MessageHandleJob(this, r10));     // Catch: Exception -> L9
        r5.startService(new Intent(r5, MessageHandleService.class));     // Catch: Exception -> L9
        return;
    L15:
        return;
    L9:
        e = move-exception;
        NeoLog.i("PushMessageReceiver onReceive=" + e.getMessage());
    }

    public void onReceivePassThroughMessage(List<NeoPushMessage> r5) {
    }

    public void onReceiveRegisterResult(NeoPushCommandMessage r5) {
    }

    public void onReceiveTopicsResult(List<String> r5) {
    }
}
