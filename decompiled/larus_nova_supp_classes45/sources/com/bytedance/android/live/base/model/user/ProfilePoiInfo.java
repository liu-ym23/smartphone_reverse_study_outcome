package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfilePoiInfo {

    @SerializedName("city")
    String city;

    @SerializedName("content")
    String content;

    @SerializedName("icon")
    py.k icon;

    @SerializedName("jump_schema")
    String jumpSchema;

    @SerializedName("poi_id")
    long poiId;

    @SerializedName("poi_id_str")
    String poiIdStr;

    @SerializedName("poi_name")
    String poiName;

    @SerializedName("is_poi_enabled")
    boolean poiPermission;

    public ProfilePoiInfo() {
    }

    public String getCity() {
        return this.city;
    }

    public String getContent() {
        return this.content;
    }

    public py.k getIcon() {
        return this.icon;
    }

    public String getJumpSchema() {
        return this.jumpSchema;
    }

    public long getPoiId() {
        return this.poiId;
    }

    public String getPoiIdStr() {
        return this.poiIdStr;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public boolean isPoiPermission() {
        return this.poiPermission;
    }

    public void setCity(String r1) {
        this.city = r1;
    }

    public void setContent(String r1) {
        this.content = r1;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }

    public void setJumpSchema(String r1) {
        this.jumpSchema = r1;
    }

    public void setPoiId(long r1) {
        this.poiId = r1;
    }

    public void setPoiIdStr(String r1) {
        this.poiIdStr = r1;
    }

    public void setPoiName(String r1) {
        this.poiName = r1;
    }

    public void setPoiPermission(boolean r1) {
        this.poiPermission = r1;
    }
}
