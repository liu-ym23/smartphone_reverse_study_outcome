package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class OnUploadFileToCloudUpdatePluginModel$OnUploadFileToCloudUpdateResponseModel extends LKBaseResponseModel {

    @JSONField(name = "progress")
    @LKRequiredParam
    public int progress;

    @JSONField(name = "taskID")
    @LKRequiredParam
    public String taskID;

    public OnUploadFileToCloudUpdatePluginModel$OnUploadFileToCloudUpdateResponseModel() {
    }
}
