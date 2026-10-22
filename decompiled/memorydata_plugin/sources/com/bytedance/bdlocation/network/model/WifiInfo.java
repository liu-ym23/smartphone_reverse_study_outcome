package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class WifiInfo implements Comparable<WifiInfo> {

    @SerializedName("frequency")
    public long frequency;

    @SerializedName("is_current")
    public int isCurrent;

    @SerializedName("rssi")
    public long rssi;

    @SerializedName("Timestamp")
    public long timeStamp;

    @SerializedName("wifi_mac")
    public String wifiMac;

    @SerializedName("wifi_name")
    public String wifiName;

    public WifiInfo() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(WifiInfo r3) {
        return Long.compare(r3.rssi, this.rssi);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(WifiInfo r3) {
        return compareTo2((WifiInfo) ZeusTransformUtils.preCheckCast(r3, WifiInfo.class, "com.obric.memorydata.plugin"));
    }
}
