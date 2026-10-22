package com.larksuite.framework.apiplugin.model.media;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.Min;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class GetVideoInfoPluginModel$GetVideoInfoRequestModel extends LKBaseRequestModel {

    @JSONField(name = "isSupportNetworkURL")
    public boolean isSupportNetworkURL;

    @Min(include = false, value = 0.0d)
    @JSONField(name = "src")
    @LKRequiredParam
    public String src;

    public GetVideoInfoPluginModel$GetVideoInfoRequestModel() {
    }
}
