package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.network.NetTrafficManagerImpl;
import com.ss.android.socialbase.downloader.network.NetworkQuality;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadNetTrafficManagerService implements IDownloadNetTrafficManagerService {
    public DownloadNetTrafficManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public NetworkQuality getCurrentNetworkQuality() {
        return NetTrafficManagerImpl.getInstance().getCurrentNetworkQuality();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public double getDownloadKBitsPerSecond() {
        return NetTrafficManagerImpl.getInstance().getDownloadKBitsPerSecond();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public double getRealTimeSpeed() {
        return NetTrafficManagerImpl.getInstance().getRealTimeSpeed();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public long getTaskRunningTime() {
        return DeviceBandwidthSampler.getInstance().getTaskRunningTime();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void reset() {
        NetTrafficManagerImpl.getInstance().reset();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r2) {
        return NetTrafficManagerImpl.getInstance().register(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void remove(NetTrafficManager.NetworkStateChangeListener r2) {
        NetTrafficManagerImpl.getInstance().remove(r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public void addBandwidth(long r2, long r4) {
        NetTrafficManagerImpl.getInstance().addBandwidth(r2, r4);
    }
}
