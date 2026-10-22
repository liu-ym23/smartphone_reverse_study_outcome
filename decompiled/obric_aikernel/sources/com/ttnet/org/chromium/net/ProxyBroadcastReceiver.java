package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
final class ProxyBroadcastReceiver extends BroadcastReceiver {
    private final ProxyChangeListener mListener;

    ProxyBroadcastReceiver(ProxyChangeListener r10) {
        this.mListener = r10;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
        this.mListener.updateProxyConfigFromConnectivityManager(r11);
        return;
    }
}
