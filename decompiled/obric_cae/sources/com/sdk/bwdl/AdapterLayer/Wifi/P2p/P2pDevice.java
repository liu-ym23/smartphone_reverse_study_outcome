package com.sdk.bwdl.AdapterLayer.Wifi.P2p;

import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public class P2pDevice {
    public InetAddress localAddress;
    public InetAddress peerAddress;
    public WifiP2pDevice peerWifiP2pDevice;
    public int role;
    public WifiP2pConfig wifiP2pConfig;
    public WifiP2pGroup wifiP2pGroup;
    public WifiP2pInfo wifiP2pInfo;

    public static final class Builder {
        public InetAddress mLocalAddress;
        public InetAddress mPeerAddress;
        public WifiP2pDevice mPeerWifiP2pDevice;
        public int mRole;
        public WifiP2pConfig mWifiP2pConfig;
        public WifiP2pGroup mWifiP2pGroup;
        public WifiP2pInfo mWifiP2pInfo;

        public Builder() {
            this.mRole = 0;
        }

        public P2pDevice build() {
            P2pDevice r8 = new P2pDevice();
            r8.role = this.mRole;
            r8.localAddress = this.mLocalAddress;
            r8.peerAddress = this.mPeerAddress;
            r8.peerWifiP2pDevice = this.mPeerWifiP2pDevice;
            r8.wifiP2pConfig = this.mWifiP2pConfig;
            r8.wifiP2pGroup = this.mWifiP2pGroup;
            r8.wifiP2pInfo = this.mWifiP2pInfo;
            return r8;
        }

        public Builder setLocalAddress(InetAddress r8) {
            if (r8 != null) goto L4;
            return this;
        L4:
            this.mLocalAddress = r8;
            return this;
        }

        public Builder setPeerAddress(InetAddress r8) {
            if (r8 != null) goto L4;
            return this;
        L4:
            this.mPeerAddress = r8;
            return this;
        }

        public Builder setPeerWifiP2pDevice(WifiP2pDevice r8) {
            if (r8 != null) goto L4;
            return this;
        L4:
            this.mPeerWifiP2pDevice = r8;
            return this;
        }

        public Builder setRole(int r8) {
            this.mRole = r8;
            return this;
        }

        public Builder setWifiP2pConfig(WifiP2pConfig r8) {
            if (r8 != null) goto L4;
            return this;
        L4:
            this.mWifiP2pConfig = r8;
            return this;
        }

        public Builder setWifiP2pGroup(WifiP2pGroup r8) {
            if (r8 != null) goto L4;
            return this;
        L4:
            this.mWifiP2pGroup = r8;
            return this;
        }

        public Builder setWifiP2pInfo(WifiP2pInfo r8) {
            if (r8 != null) goto L4;
            return this;
        L4:
            this.mWifiP2pInfo = r8;
            return this;
        }
    }

    public P2pDevice() {
        this.role = 0;
    }
}
