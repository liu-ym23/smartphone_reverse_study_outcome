package com.bytedance.bdlocation.network.model;

import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class BdLBSResult {

    @b("BaseResp")
    public BaseResp baseResp;

    @b("DeviceIdLocation")
    public LocationResult deviceIdLocation;

    @b("GPSLocation")
    public LocationResult gpsLocation;

    @b("IPLocation")
    public LocationResult ipLocation;

    @b("Location")
    public LocationResult location;

    @b("UserSelectedLocation")
    public LocationResult userSelectedLocation;

    public BdLBSResult() {
    }

    public String toString() {
        return "BdLBSResult{location=" + this.location + ", ipLocation=" + this.ipLocation + ", deviceIdLocation=" + this.deviceIdLocation + ", userSelectedLocation=" + this.userSelectedLocation + ", gpsLocation=" + this.gpsLocation + ", baseResp=" + this.baseResp + '}';
    }
}
