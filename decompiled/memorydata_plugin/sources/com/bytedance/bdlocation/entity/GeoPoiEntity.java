package com.bytedance.bdlocation.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;

/* JADX INFO: loaded from: classes.dex */
public class GeoPoiEntity {

    @SerializedName(MemoryKeyInfoEntity.KEY_ADDRESS)
    public String address;

    @SerializedName("area")
    public String area;

    @SerializedName("aweme_id")
    public String awemeId;

    @SerializedName("businessarea")
    public String businessArea;

    @SerializedName("distance")
    public Double distance;

    @SerializedName(OaidModel.KEY_ID)
    public String id;

    @SerializedName("location")
    public String location;

    @SerializedName(ActivityLifecycle.NAME)
    public String name;

    @SerializedName("poiweight")
    public String poiWeight;

    @SerializedName("sid")
    public String sId;

    @SerializedName(AILabCheckPermissionTask.KEY_SOURCE)
    public String source;

    @SerializedName("tel")
    public String tel;

    @SerializedName("typecode")
    public String typeCode;

    public GeoPoiEntity() {
    }
}
