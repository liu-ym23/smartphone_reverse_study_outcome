package com.bytedance.common.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkConnectChangeReceiver extends BroadcastReceiver {
    public NetworkConnectChangeReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r5, Intent r10) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r10.getAction()) == false) goto L5;
    L8:
        f.f3959a = f.b(r5);
        return;
    L5:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r10.getAction()) == true) goto L8;
        if ("android.net.wifi.STATE_CHANGE".equals(r10.getAction()) == true) goto L8;
    }
}
