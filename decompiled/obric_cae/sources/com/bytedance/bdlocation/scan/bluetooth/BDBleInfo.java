package com.bytedance.bdlocation.scan.bluetooth;

import android.text.TextUtils;
import com.obric.cae.wifi.WiFiDBHelper;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BDBleInfo implements Comparable<BDBleInfo> {

    @ia.b("beacon_uuid")
    public String beaconUuid;

    @ia.b("ble_mac")
    public String bleMac;

    @ia.b("ble_name")
    public String bleName;

    @ia.b("is_beacon")
    public boolean isBeacon;

    @ia.b("major")
    public int major;

    @ia.b("minor")
    public int minor;

    @ia.b("beacon_data")
    public String rawData;

    @ia.b(WiFiDBHelper.COL_RSSI)
    public int rssi;

    @ia.b("timestamp")
    public long timeStamp;

    public BDBleInfo() {
        this.bleName = "";
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BDBleInfo r8) {
        if (Boolean.compare(r8.isBeacon, this.isBeacon) != 0) goto L15;
        if (Boolean.compare(!TextUtils.isEmpty(r8.rawData), !TextUtils.isEmpty(this.rawData)) != 0) goto L13;
        int r10 = r8.rssi;
        int r11 = this.rssi;
        if (r10 != r11) goto L11;
        return Boolean.compare(!TextUtils.isEmpty(r8.bleName), !TextUtils.isEmpty(this.bleName));
    L11:
        return Long.compare(r10, r11);
    L13:
        return Boolean.compare(!TextUtils.isEmpty(r8.rawData), !TextUtils.isEmpty(this.rawData));
    L15:
        return Boolean.compare(r8.isBeacon, this.isBeacon);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L18;
        String r10 = this.bleMac;
        String r11 = ((BDBleInfo) r8).bleMac;
        if (r10 == r11) goto L19;
        if (r10 == null) goto L17;
        if (r10.equals(r11) == false) goto L17;
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

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BDBleInfo r8) {
        return compareTo2(r8);
    }
}
