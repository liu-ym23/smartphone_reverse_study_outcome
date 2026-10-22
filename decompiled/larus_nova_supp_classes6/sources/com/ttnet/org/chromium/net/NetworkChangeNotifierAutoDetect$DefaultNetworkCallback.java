package com.ttnet.org.chromium.net;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class NetworkChangeNotifierAutoDetect$DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

    private NetworkChangeNotifierAutoDetect$DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
        this.this$0 = r1;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r1) {
        if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == false) goto L6;
        NetworkChangeNotifierAutoDetect.access$400(this.this$0);
        return;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network r1) {
        onAvailable(null);
    }

    public /* synthetic */ NetworkChangeNotifierAutoDetect$DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1, NetworkChangeNotifierAutoDetect$1 r2) {
        this(r1);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
        onAvailable(null);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network r1, LinkProperties r2) {
        onAvailable(null);
    }
}
