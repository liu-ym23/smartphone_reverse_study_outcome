package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import android.net.wifi.p2p.WifiP2pGroup;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public interface P2pCallback {
    void onP2pGroupAvailable(WifiP2pGroup r8);

    void onP2pGroupIpAvailable(InetAddress r8);
}
