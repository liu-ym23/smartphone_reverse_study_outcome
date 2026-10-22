package com.bytedance.common.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class f extends BroadcastReceiver {
    public f() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r11.getAction()) == false) goto L5;
    L8:
        NetworkUtils.j(NetworkUtils.e(r10));
        return;
    L5:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r11.getAction()) == true) goto L8;
        if ("android.net.wifi.STATE_CHANGE".equals(r11.getAction()) == true) goto L8;
    }
}
