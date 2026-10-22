package com.larksuite.framework.apiplugin.model.location;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class GetLocationStatusPluginModel$GetLocationStatusResponseModel extends LKBaseResponseModel {

    @JSONField(name = "gpsStatus")
    @LKRequiredParam
    @StringEnum(values = {"on", "off"})
    public String gpsStatus;

    public GetLocationStatusPluginModel$GetLocationStatusResponseModel() {
    }
}
