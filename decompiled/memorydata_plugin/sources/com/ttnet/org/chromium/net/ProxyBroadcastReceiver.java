package com.ttnet.org.chromium.net;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class ProxyBroadcastReceiver extends PluginBroadcastReceiver {
    private final ProxyChangeListener mListener;

    ProxyBroadcastReceiver(ProxyChangeListener r1) {
        this.mListener = r1;
    }

    public void onReceive(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
        this.mListener.updateProxyConfigFromConnectivityManager(r4);
        return;
    }
}
