package com.bytedance.bdlocation.network.model;

import com.bytedance.common.wschannel.WsConstants;
import ha.m;
import ha.s;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class ShakeUploadInfo {

    @b("ble_info_list")
    public m bleInfo;

    @b("busi_name")
    public String busiName;

    @b(WsConstants.KEY_EXTRA)
    public s extra;

    @b("gps_info")
    public LocationInfo locationInfo;

    @b("subdivision_id")
    public long subdivisionId;

    @b("timestamp")
    public long timeStamp;

    @b("wifi_info_list")
    public m wifiInfo;

    public ShakeUploadInfo() {
    }
}
