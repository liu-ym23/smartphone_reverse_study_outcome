package com.bytedance.bdlocation.scan.networklistener;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
public interface WifiChangeListener {
    void notifyWifiChanged(Network r8, NetworkCapabilities r10);

    void notifyWifiChangedTwo(NetworkInfo r8);
}
