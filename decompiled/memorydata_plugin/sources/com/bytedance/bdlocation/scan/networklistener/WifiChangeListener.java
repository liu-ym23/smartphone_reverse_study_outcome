package com.bytedance.bdlocation.scan.networklistener;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
public interface WifiChangeListener {
    void notifyWifiChanged(Network r1, NetworkCapabilities r2);

    void notifyWifiChangedTwo(NetworkInfo r1);
}
