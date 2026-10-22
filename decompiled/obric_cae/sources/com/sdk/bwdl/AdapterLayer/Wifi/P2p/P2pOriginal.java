package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pManager;

/* JADX INFO: loaded from: classes2.dex */
public class P2pOriginal {
    private static volatile P2pOriginal sInstance;
    private Context mContext;
    private WifiP2pManager.Channel mWifiP2pChannel;
    private WifiP2pManager mWifiP2pManager;

    public P2pOriginal(Context r8) {
        this.mContext = r8;
        WifiP2pManager r10 = (WifiP2pManager) r8.getSystemService("wifip2p");
        this.mWifiP2pManager = r10;
        this.mWifiP2pChannel = r10.initialize(r8, r8.getMainLooper(), null);
    }

    public static P2pOriginal getInstance(Context r8) {
        if (sInstance != null) goto L13;
        monitor-enter(P2pOriginal.class);
        sInstance = new P2pOriginal(r8);     // Catch: Throwable -> L9
        monitor-exit(P2pOriginal.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return sInstance;
    }

    @SuppressLint({"MissingPermission"})
    public void connect(WifiP2pConfig r8, WifiP2pManager.ActionListener r10) {
        this.mWifiP2pManager.connect(this.mWifiP2pChannel, r8, r10);
    }

    @SuppressLint({"MissingPermission"})
    public void createGroup(WifiP2pConfig r8, WifiP2pManager.ActionListener r10) {
        this.mWifiP2pManager.createGroup(this.mWifiP2pChannel, r8, r10);
    }

    @SuppressLint({"MissingPermission"})
    public void discoverPeers(WifiP2pManager.ActionListener r8) {
        this.mWifiP2pManager.discoverPeers(this.mWifiP2pChannel, r8);
    }

    public void removeGroup(WifiP2pManager.ActionListener r8) {
        this.mWifiP2pManager.removeGroup(this.mWifiP2pChannel, r8);
    }

    public void requestConnectionInfo(WifiP2pManager.ConnectionInfoListener r8) {
        this.mWifiP2pManager.requestConnectionInfo(this.mWifiP2pChannel, r8);
    }

    @SuppressLint({"MissingPermission"})
    public void requestDeviceInfo(WifiP2pManager.DeviceInfoListener r8) {
        this.mWifiP2pManager.requestDeviceInfo(this.mWifiP2pChannel, r8);
    }

    @SuppressLint({"MissingPermission"})
    public void requestGroupInfo(WifiP2pManager.GroupInfoListener r8) {
        this.mWifiP2pManager.requestGroupInfo(this.mWifiP2pChannel, r8);
    }

    public void requestNetworkInfo(WifiP2pManager.NetworkInfoListener r8) {
        this.mWifiP2pManager.requestNetworkInfo(this.mWifiP2pChannel, r8);
    }

    public void requestP2pState(WifiP2pManager.P2pStateListener r8) {
        this.mWifiP2pManager.requestP2pState(this.mWifiP2pChannel, r8);
    }

    @SuppressLint({"MissingPermission"})
    public void requestPeers(WifiP2pManager.PeerListListener r8) {
        this.mWifiP2pManager.requestPeers(this.mWifiP2pChannel, r8);
    }

    public void stopPeerDiscovery(WifiP2pManager.ActionListener r8) {
        this.mWifiP2pManager.stopPeerDiscovery(this.mWifiP2pChannel, r8);
    }
}
