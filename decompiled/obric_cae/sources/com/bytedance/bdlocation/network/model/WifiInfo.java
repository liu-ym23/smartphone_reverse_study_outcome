package com.bytedance.bdlocation.network.model;

import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.wifi.WiFiDBHelper;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class WifiInfo implements Comparable<WifiInfo> {

    @b("frequency")
    public long frequency;

    @b("is_current")
    public int isCurrent;

    @b(WiFiDBHelper.COL_RSSI)
    public long rssi;

    @b(BwdlDropProvider.BwdlDropEntry.TIMESTAMP)
    public long timeStamp;

    @b("wifi_mac")
    public String wifiMac;

    @b("wifi_name")
    public String wifiName;

    public WifiInfo() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(WifiInfo r8) {
        return Long.compare(r8.rssi, this.rssi);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WifiInfo r8) {
        return compareTo2(r8);
    }
}
