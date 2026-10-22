package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.NotBlank;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class DownloadFileFromCloudPluginModel$DownloadFileFromCloudRequestModel extends LKBaseRequestModel {

    @JSONField(name = "extra")
    public JSONObject extra;

    @JSONField(name = "filePath")
    public String filePath;

    @JSONField(name = "fileToken")
    @LKRequiredParam
    public String fileToken;

    @JSONField(name = "mountNodePoint")
    @LKRequiredParam
    public String mountNodePoint;

    @NotBlank
    @JSONField(name = "mountPoint")
    @LKRequiredParam
    public String mountPoint;

    @JSONField(name = "taskID")
    @LKRequiredParam
    public String taskID;

    public DownloadFileFromCloudPluginModel$DownloadFileFromCloudRequestModel() {
    }
}
