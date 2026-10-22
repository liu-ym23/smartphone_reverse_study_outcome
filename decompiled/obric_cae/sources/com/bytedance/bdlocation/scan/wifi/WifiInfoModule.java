package com.bytedance.bdlocation.scan.wifi;

import com.bytedance.bdlocation.network.model.WifiInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WifiInfoModule {
    public final long cacheWifiTime;
    public final WifiInfo connectWifi;
    public final List<WifiInfo> wifiInfoList;

    public WifiInfoModule(List<WifiInfo> r8, WifiInfo r10, long r11) {
        this.wifiInfoList = r8;
        this.connectWifi = r10;
        this.cacheWifiTime = r11;
    }
}
