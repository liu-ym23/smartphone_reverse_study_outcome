package com.larksuite.framework.apiplugin.model.ccm;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class PreloadWebAppContainerPluginModel$PreloadWebAppContainerRequestModel extends LKBaseRequestModel {

    @JSONField(name = "appName")
    @LKRequiredParam
    public String appName;

    public PreloadWebAppContainerPluginModel$PreloadWebAppContainerRequestModel() {
    }
}
