package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
final class ProxyBroadcastReceiver extends BroadcastReceiver {
    private final ProxyChangeListener mListener;

    public ProxyBroadcastReceiver(ProxyChangeListener r8) {
        this.mListener = r8;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r8, Intent r10) {
        if (r10.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
        this.mListener.updateProxyConfigFromConnectivityManager();
        return;
    }
}
