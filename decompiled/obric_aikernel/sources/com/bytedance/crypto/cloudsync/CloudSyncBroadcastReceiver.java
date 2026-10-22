package com.bytedance.crypto.cloudsync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class CloudSyncBroadcastReceiver extends BroadcastReceiver {
    public static final String PERMISSION = "slardaros.intent.permission";
    private static final String TAG = "CloudSyncBroadcastReceiver";
    public static final String WHITELIST_ACTION = "com.bytedance.security.CLOUD_SYNC_APP_WHITELIST";

    public CloudSyncBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L12;
        String r12 = r11.getAction();
        LogUtils.i(TAG, "Receive broadcast action:" + r12);
        if (TextUtils.isEmpty(r12) == false) goto L9;
        return;
    L9:
        if (r12.equals(WHITELIST_ACTION) == false) goto L15;
        String r13 = r11.getStringExtra("data");
        LogUtils.d(TAG, "WHITELIST_ACTION data:" + r13);
        String r14 = r10.getFilesDir().getAbsolutePath() + "/" + CloudConfig.WHITE_LIST_FILE_NAME;
        LogUtils.d(TAG, "WHITELIST_ACTION filePath:" + r14);
        CloudConfig.getInstance().updateWhiteListApps(r14, r13);
        return;
    L15:
        return;
    L12:
        LogUtils.e(TAG, "context or intent is null");
    }
}
