package com.larksuite.framework.apiplugin.model.net;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class GetNetworkEnvPluginModel$GetNetworkEnvResponseModel extends LKBaseResponseModel {

    @JSONField(name = "networkEnv")
    @LKRequiredParam
    public String networkEnv;

    public GetNetworkEnvPluginModel$GetNetworkEnvResponseModel() {
    }
}
