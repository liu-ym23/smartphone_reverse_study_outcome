package com.bytedance.bdlocation.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class ShakeUploadInfo {

    @SerializedName("ble_info_list")
    public JsonArray bleInfo;

    @SerializedName("busi_name")
    public String busiName;

    @SerializedName(WsConstants.KEY_EXTRA)
    public JsonObject extra;

    @SerializedName("gps_info")
    public LocationInfo locationInfo;

    @SerializedName("subdivision_id")
    public long subdivisionId;

    @SerializedName("timestamp")
    public long timeStamp;

    @SerializedName("wifi_info_list")
    public JsonArray wifiInfo;

    public ShakeUploadInfo() {
    }
}
