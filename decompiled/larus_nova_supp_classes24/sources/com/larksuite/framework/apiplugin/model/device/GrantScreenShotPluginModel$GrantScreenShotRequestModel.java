package com.larksuite.framework.apiplugin.model.device;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class GrantScreenShotPluginModel$GrantScreenShotRequestModel extends LKBaseRequestModel {

    @JSONField(name = "status")
    @LKRequiredParam
    public int status;

    public GrantScreenShotPluginModel$GrantScreenShotRequestModel() {
    }
}
