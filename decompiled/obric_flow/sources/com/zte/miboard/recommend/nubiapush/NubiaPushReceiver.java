package com.zte.miboard.recommend.nubiapush;

import ai.j0;
import android.text.TextUtils;
import android.util.Log;
import cn.nubia.neopush.sdk.NeoPushClient;
import cn.nubia.neopush.sdk.NeoPushCommandMessage;
import cn.nubia.neopush.sdk.NeoPushMessage;
import cn.nubia.neopush.sdk.PushMessageReceiver;
import java.util.List;
import m.h;

/* JADX INFO: loaded from: classes3.dex */
public class NubiaPushReceiver extends PushMessageReceiver {
    private static final String TAG = "Mi_R_NubiaPushReceiver";

    public NubiaPushReceiver() {
    }

    @Override // cn.nubia.neopush.sdk.PushMessageReceiver
    public void onCommandResult(NeoPushCommandMessage r5) {
        super.onCommandResult(r5);
        if (r5 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        String r11 = TAG;
        Log.d(r11, "onCommandResult success=" + r10 + " message=" + r5);
        if (r10 == true) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(PushUtils.getRegId()) == false) goto L15;
        String r12 = NeoPushClient.getRegId(h.a());
        Log.d(r11, "onCommandResult id=" + r12);
        PushUtils.setRegId(r12);
        return;
    L15:
        return;
    L5:
        if (r5.isResult() == false) goto L7;
        r10 = true;
        goto L8
    }

    @Override // cn.nubia.neopush.sdk.PushMessageReceiver
    public void onNotificationMessageClick(NeoPushMessage r5) {
        super.onNotificationMessageClick(r5);
        Log.d(TAG, "onNotificationMessageClick message=" + r5);
    }

    @Override // cn.nubia.neopush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(List<NeoPushMessage> r5) {
        super.onReceivePassThroughMessage(r5);
        new NubiaPushHelper().onReceivePassThroughMessage(r5);
    }

    @Override // cn.nubia.neopush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(NeoPushCommandMessage r5) {
        super.onReceiveRegisterResult(r5);
        if (r5 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        Log.d(TAG, "onReceiveRegisterResult success=" + r10 + " message=" + r5);
        return;
    L5:
        if (r5.isResult() == false) goto L7;
        r10 = true;
        goto L8
    }

    @Override // cn.nubia.neopush.sdk.PushMessageReceiver
    public void onReceiveTopicsResult(List<String> r5) {
        super.onReceiveTopicsResult(r5);
        String r10 = TAG;
        StringBuilder r11 = new StringBuilder("onReceiveTopicsResult topics=");
        if (r5 == null) goto L5;
        Integer r12 = Integer.valueOf(r5.size());
    L6:
        r11.append(r12);
        Log.d(r10, r11.toString());
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.isEmpty() == true) goto L16;
        int r13 = 0;
    L12:
        if (r13 >= r5.size()) goto L17;
        String r14 = TAG;
        StringBuilder r15 = j0.s(r13, "onReceivePassThroughMessage i=", " topic=");
        r15.append(r5.get(r13));
        Log.d(r14, r15.toString());
        r13 = r13 + 1;
        goto L12
    L17:
        return;
    L16:
        return;
    L5:
        r12 = null;
        goto L6
    }
}
