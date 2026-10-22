package com.obric.cae.userAware;

import com.obric.cae.libs.useraware.WifiStandardData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface WifiAwareInfoMonitor {
    void onWifiConnectInfoChanged(WifiStandardData r1);

    void onWifiNetworkAvailable(boolean r1);

    void onWifiScanInfoChanged(List<WifiStandardData> r1);

    default void onWifiScanInfoChanged(List<WifiStandardData> r2, WifiScanAttribution r3) {
        onWifiScanInfoChanged((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }

    void onWifiScanNeighborApChanged(List<WifiStandardData> r1);
}
