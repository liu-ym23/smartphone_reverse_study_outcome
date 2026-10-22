package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ReverseGeocodePluginModel$StreetNumberInfoModel implements Serializable {

    @JSONField(name = "direction")
    @LKRequiredParam
    public String direction;

    @JSONField(name = "distance")
    @LKRequiredParam
    public double distance;

    @JSONField(name = "latitude")
    @LKRequiredParam
    public double latitude;

    @JSONField(name = "longitude")
    @LKRequiredParam
    public double longitude;

    @JSONField(name = "number")
    @LKRequiredParam
    public String number;

    @JSONField(name = "street")
    @LKRequiredParam
    public String street;

    public ReverseGeocodePluginModel$StreetNumberInfoModel() {
    }
}
