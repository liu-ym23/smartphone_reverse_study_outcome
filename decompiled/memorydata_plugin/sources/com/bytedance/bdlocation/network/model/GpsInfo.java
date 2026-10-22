package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;

/* JADX INFO: loaded from: classes.dex */
public class GpsInfo {

    @SerializedName(MemoryKeyInfoEntity.KEY_ADDRESS)
    public String address;

    @SerializedName("city")
    public String city;

    @SerializedName("coordinateSystem")
    public String coordinateSystem;

    @SerializedName("country")
    public String country;

    @SerializedName("district")
    public String district;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("loc_time")
    public long locationTime;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("provider")
    public String provider;

    @SerializedName("province")
    public String province;

    @SerializedName(AILabCheckPermissionTask.KEY_SOURCE)
    public int source;

    public GpsInfo() {
    }
}
