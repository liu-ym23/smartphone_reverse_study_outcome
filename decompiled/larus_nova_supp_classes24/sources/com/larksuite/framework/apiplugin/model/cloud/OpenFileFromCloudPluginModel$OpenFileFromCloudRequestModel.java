package com.larksuite.framework.apiplugin.model.cloud;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.NotBlank;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class OpenFileFromCloudPluginModel$OpenFileFromCloudRequestModel extends LKBaseRequestModel {

    @JSONField(name = "extra")
    public JSONObject extra;

    @JSONField(name = "fileToken")
    public String fileToken;

    @JSONField(name = "files")
    public ArrayList<OpenFileFromCloudPluginModel$FilesItemModel> files;

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

    public OpenFileFromCloudPluginModel$OpenFileFromCloudRequestModel() {
    }
}
