package com.larksuite.framework.apiplugin.model.web.container;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class GetCookieFromURLPluginModel$GetCookieFromURLResponseModel extends LKBaseResponseModel {

    @JSONField(name = "data")
    @LKRequiredParam
    public ArrayList<GetCookieFromURLPluginModel$DataItemModel> data;

    @JSONField(name = "msg")
    public String msg;

    public GetCookieFromURLPluginModel$GetCookieFromURLResponseModel() {
    }
}
