package com.ss.android.lark.http.netstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    public static NetworkBroadcastReceiver a;

    public NetworkBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        if (r3 == null) goto L16;
        if (r4 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r4.getAction()) == false) goto L10;
        return;
    L10:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r4.getAction()) == false) goto L17;
        NetworkUtils.NetworkType r5 = NetworkUtils.a(r3);     // Catch: Exception -> L13
        Log.i("NetworkBroadcastReceiver", "network change: " + r5.toString());     // Catch: Exception -> L13
        c.a.a.b(r5);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L17:
        return;
    }
}
