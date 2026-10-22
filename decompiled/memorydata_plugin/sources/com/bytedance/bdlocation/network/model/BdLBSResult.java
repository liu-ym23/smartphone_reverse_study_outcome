package com.bytedance.bdlocation.network.model;

import com.bytedance.rpc.model.locationConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class BdLBSResult {

    @SerializedName("BaseResp")
    public BaseResp baseResp;

    @SerializedName(locationConstants.LocateMethod_Deviceid)
    public LocationResult deviceIdLocation;

    @SerializedName(locationConstants.LocateMethod_GPS)
    public LocationResult gpsLocation;

    @SerializedName(locationConstants.LocateMethod_IP)
    public LocationResult ipLocation;

    @SerializedName("Location")
    public LocationResult location;

    @SerializedName(locationConstants.LocateMethod_UserSelected)
    public LocationResult userSelectedLocation;

    public BdLBSResult() {
    }

    public String toString() {
        return "BdLBSResult{location=" + this.location + ", ipLocation=" + this.ipLocation + ", deviceIdLocation=" + this.deviceIdLocation + ", userSelectedLocation=" + this.userSelectedLocation + ", gpsLocation=" + this.gpsLocation + ", baseResp=" + this.baseResp + '}';
    }
}
