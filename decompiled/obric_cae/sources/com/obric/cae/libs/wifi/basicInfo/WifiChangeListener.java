package com.obric.cae.libs.wifi.basicInfo;

import android.net.wifi.ScanResult;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface WifiChangeListener {
    void onScanInfoChanged(List<ScanResult> r8);

    void onWifiInfoChanged(boolean r8);

    void onWifiStateChanged(int r8);
}
