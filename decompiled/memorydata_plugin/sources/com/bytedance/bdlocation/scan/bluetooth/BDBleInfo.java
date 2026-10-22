package com.bytedance.bdlocation.scan.bluetooth;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BDBleInfo implements Comparable<BDBleInfo> {

    @SerializedName("beacon_uuid")
    public String beaconUuid;

    @SerializedName("ble_mac")
    public String bleMac;

    @SerializedName("ble_name")
    public String bleName;

    @SerializedName("is_beacon")
    public boolean isBeacon;

    @SerializedName("major")
    public int major;

    @SerializedName("minor")
    public int minor;

    @SerializedName("beacon_data")
    public String rawData;

    @SerializedName("rssi")
    public int rssi;

    @SerializedName("timestamp")
    public long timeStamp;

    public BDBleInfo() {
        this.bleName = "";
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BDBleInfo r3) {
        if (Boolean.compare(r3.isBeacon, this.isBeacon) != 0) goto L15;
        if (Boolean.compare(!TextUtils.isEmpty(r3.rawData), !TextUtils.isEmpty(this.rawData)) != 0) goto L13;
        int r0 = r3.rssi;
        int r1 = this.rssi;
        if (r0 != r1) goto L11;
        return Boolean.compare(!TextUtils.isEmpty(r3.bleName), !TextUtils.isEmpty(this.bleName));
    L11:
        return Long.compare(r0, r1);
    L13:
        return Boolean.compare(!TextUtils.isEmpty(r3.rawData), !TextUtils.isEmpty(this.rawData));
    L15:
        return Boolean.compare(r3.isBeacon, this.isBeacon);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(BDBleInfo r3) {
        return compareTo2((BDBleInfo) ZeusTransformUtils.preCheckCast(r3, BDBleInfo.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L18;
        BDBleInfo r6 = (BDBleInfo) ZeusTransformUtils.preCheckCast(r5, BDBleInfo.class, "com.obric.memorydata.plugin");
        String r4 = this.bleMac;
        String r7 = r6.bleMac;
        if (r4 == r7) goto L19;
        if (r4 == null) goto L17;
        if (r4.equals(r7) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.bleMac});
    }

    public String toString() {
        return "BDBleInfo{bleName='" + this.bleName + "', bleMac='" + this.bleMac + "', major=" + this.major + ", minor=" + this.minor + ", beaconUuid='" + this.beaconUuid + "', rssi=" + this.rssi + ", isBeacon=" + this.isBeacon + ", rawData='" + this.rawData + "', timeStamp=" + this.timeStamp + '}';
    }
}
