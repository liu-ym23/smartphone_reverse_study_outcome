package com.bytedance.memory.upload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
public class b extends BroadcastReceiver {
    public b() {
    }

    private void c() {
        a.j();
    }

    public void a(Context r10) {
        r10.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void b(Context r10) {
        r10.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        NetworkInfo r12 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.getType() == 1) goto L7;
        return;
    L7:
        if (r12.isConnected() == false) goto L12;
        b(o3.a.j().i());
        c();
        return;
    }
}
