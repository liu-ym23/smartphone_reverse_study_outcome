package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
final class ProxyBroadcastReceiver extends BroadcastReceiver {
    private final ProxyChangeListener mListener;

    public ProxyBroadcastReceiver(ProxyChangeListener r1) {
        this.mListener = r1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r2, Intent r3) {
        if (r3.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
        this.mListener.updateProxyConfigFromConnectivityManager(r3);
        return;
    }
}
