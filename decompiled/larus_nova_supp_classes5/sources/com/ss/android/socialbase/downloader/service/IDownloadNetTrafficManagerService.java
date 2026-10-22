package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.network.NetworkQuality;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadNetTrafficManagerService {
    void addBandwidth(long r1, long r3);

    NetworkQuality getCurrentNetworkQuality();

    double getDownloadKBitsPerSecond();

    double getRealTimeSpeed();

    long getTaskRunningTime();

    NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r1);

    void remove(NetTrafficManager.NetworkStateChangeListener r1);

    void reset();
}
