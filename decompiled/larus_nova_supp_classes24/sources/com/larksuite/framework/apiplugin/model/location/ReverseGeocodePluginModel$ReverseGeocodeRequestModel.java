package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.Max;
import com.larksuite.framework.apiplugin.validator.format.Min;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class ReverseGeocodePluginModel$ReverseGeocodeRequestModel extends LKBaseRequestModel {

    @LKRequiredParam
    @Max(include = true, value = 90.0d)
    @Min(include = true, value = -90.0d)
    @JSONField(name = "latitude")
    public double latitude;

    @LKRequiredParam
    @Max(include = true, value = 180.0d)
    @Min(include = true, value = -180.0d)
    @JSONField(name = "longitude")
    public double longitude;

    @JSONField(name = "needExtendedInfo")
    public boolean needExtendedInfo;

    public ReverseGeocodePluginModel$ReverseGeocodeRequestModel() {
    }
}
