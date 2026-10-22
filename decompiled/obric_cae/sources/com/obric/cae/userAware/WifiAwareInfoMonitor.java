package com.obric.cae.userAware;

import com.obric.cae.libs.useraware.WifiStandardData;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiAwareInfoMonitor {
    void onWifiConnectInfoChanged(WifiStandardData r8);

    void onWifiNetworkAvailable(boolean r8);

    void onWifiScanInfoChanged(List<WifiStandardData> r8);

    void onWifiScanNeighborApChanged(List<WifiStandardData> r8);
}
