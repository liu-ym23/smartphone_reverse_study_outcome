package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class DownloadFileFromCloudAbortPluginModel$DownloadFileFromCloudAbortRequestModel extends LKBaseRequestModel {

    @JSONField(name = "taskID")
    @LKRequiredParam
    public String taskID;

    public DownloadFileFromCloudAbortPluginModel$DownloadFileFromCloudAbortRequestModel() {
    }
}
