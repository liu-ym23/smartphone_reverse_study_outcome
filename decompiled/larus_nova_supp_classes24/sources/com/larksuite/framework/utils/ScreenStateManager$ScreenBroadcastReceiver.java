package com.larksuite.framework.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ScreenStateManager$ScreenBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        Log.d("ScreenBroadcastReceiver", "action = " + r3.getAction());
        throw null;
    }
}
