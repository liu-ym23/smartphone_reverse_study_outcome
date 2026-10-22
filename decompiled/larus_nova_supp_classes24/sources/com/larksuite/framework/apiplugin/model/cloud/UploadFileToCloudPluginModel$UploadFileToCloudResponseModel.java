package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UploadFileToCloudPluginModel$UploadFileToCloudResponseModel extends LKBaseResponseModel {

    @JSONField(name = "fileName")
    @LKRequiredParam
    public String fileName;

    @JSONField(name = "fileToken")
    @LKRequiredParam
    public String fileToken;

    public UploadFileToCloudPluginModel$UploadFileToCloudResponseModel() {
    }
}
