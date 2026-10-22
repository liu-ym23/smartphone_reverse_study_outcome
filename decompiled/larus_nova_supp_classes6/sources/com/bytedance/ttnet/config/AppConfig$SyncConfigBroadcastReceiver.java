package com.bytedance.ttnet.config;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class AppConfig$SyncConfigBroadcastReceiver extends BroadcastReceiver {
    public AppConfig$SyncConfigBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ("com.bytedance.ttnet.config.appconfig.SYNC_MAIN_PROCESS_CONFIG".equals(r2.getAction()) == false) goto L8;
        final String r3 = "SyncMainProcessConfig";
        new AnonymousClass1(this, r3).start();
        return;
    }
}
