package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class SearchPOIPluginModel$PoiListItemModel implements Serializable {

    @JSONField(name = "latitude")
    @LKRequiredParam
    public double latitude;

    @JSONField(name = "locationAddress")
    @LKRequiredParam
    public String locationAddress;

    @JSONField(name = "locationName")
    @LKRequiredParam
    public String locationName;

    @JSONField(name = "longitude")
    @LKRequiredParam
    public double longitude;

    public SearchPOIPluginModel$PoiListItemModel() {
    }
}
