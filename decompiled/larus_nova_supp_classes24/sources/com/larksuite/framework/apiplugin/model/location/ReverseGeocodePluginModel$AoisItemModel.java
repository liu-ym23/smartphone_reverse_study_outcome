package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ReverseGeocodePluginModel$AoisItemModel implements Serializable {

    @JSONField(name = "adCode")
    @LKRequiredParam
    public String adCode;

    @JSONField(name = "aioId")
    @LKRequiredParam
    public String aioId;

    @JSONField(name = "aoiArea")
    @LKRequiredParam
    public double aoiArea;

    @JSONField(name = "aoiName")
    @LKRequiredParam
    public String aoiName;

    @JSONField(name = "latitude")
    @LKRequiredParam
    public double latitude;

    @JSONField(name = "longitude")
    @LKRequiredParam
    public double longitude;

    public ReverseGeocodePluginModel$AoisItemModel() {
    }
}
