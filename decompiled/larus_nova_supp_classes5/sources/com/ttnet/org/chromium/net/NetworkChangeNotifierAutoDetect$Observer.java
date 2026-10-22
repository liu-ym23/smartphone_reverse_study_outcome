package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface NetworkChangeNotifierAutoDetect$Observer {
    void onConnectionCostChanged(int r1);

    void onConnectionSubtypeChanged(int r1);

    void onConnectionTypeChanged(int r1);

    void onNetworkConnect(long r1, int r3, boolean r4);

    void onNetworkDisconnect(long r1, boolean r3);

    void onNetworkSoonToDisconnect(long r1);

    void purgeActiveNetworkList(long[] r1);
}
