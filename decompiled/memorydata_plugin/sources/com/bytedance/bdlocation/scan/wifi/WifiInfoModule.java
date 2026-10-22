package com.bytedance.bdlocation.scan.wifi;

import com.bytedance.bdlocation.network.model.WifiInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WifiInfoModule {
    public final long cacheWifiTime;
    public final WifiInfo connectWifi;
    public final List<WifiInfo> wifiInfoList;

    public WifiInfoModule(List<WifiInfo> r3, WifiInfo r4, long r5) {
        this.wifiInfoList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.connectWifi = r4;
        this.cacheWifiTime = r5;
    }
}
