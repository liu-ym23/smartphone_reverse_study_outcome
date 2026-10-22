package com.obric.memorydata.awareness.cae;

import com.obric.cae.libs.useraware.WifiStandardData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/cae/WifiInfoChangeCallback;", "", "onWifiScanInfoChanged", "", "results", "", "Lcom/obric/cae/libs/useraware/WifiStandardData;", "onWifiConnectInfoChanged", "info", "onWifiRomingChanged", "aps", "onWifiNetworkAvailable", "available", "", "onWifiSignalSuddenChangeEvent", "event", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface j {
    void a(WifiStandardData r1);

    void a(List<? extends WifiStandardData> r1);

    void a(boolean r1);
}
