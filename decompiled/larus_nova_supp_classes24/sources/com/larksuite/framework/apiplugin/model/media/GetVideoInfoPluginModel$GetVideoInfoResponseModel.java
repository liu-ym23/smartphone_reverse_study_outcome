package com.larksuite.framework.apiplugin.model.media;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class GetVideoInfoPluginModel$GetVideoInfoResponseModel extends LKBaseResponseModel {

    @JSONField(name = "duration")
    @LKRequiredParam
    public double duration;

    @JSONField(name = "height")
    @LKRequiredParam
    public int height;

    @JSONField(name = "path")
    public String path;

    @JSONField(name = "size")
    @LKRequiredParam
    public int size;

    @JSONField(name = "type")
    @LKRequiredParam
    public String type;

    @JSONField(name = "width")
    @LKRequiredParam
    public int width;

    public GetVideoInfoPluginModel$GetVideoInfoResponseModel() {
    }
}
