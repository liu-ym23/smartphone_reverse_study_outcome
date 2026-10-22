package com.bytedance.bdlocation.entity.gis;

import com.bytedance.bdlocation.network.model.BaseResp;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class BdGisResult {

    @SerializedName("BaseResp")
    public BaseResp baseResp;

    @SerializedName("IsDisputed")
    public boolean isDisputed;

    @SerializedName("location")
    public LocationResult location;

    public BdGisResult() {
    }

    public String toString() {
        return "BdGisResult{location=" + this.location + ", isDisputed=" + this.isDisputed + ", baseResp=" + this.baseResp + '}';
    }
}
