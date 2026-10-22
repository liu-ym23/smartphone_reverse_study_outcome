package com.larksuite.framework.apiplugin.model.web.container;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class RemoveCookieFromURLPluginModel$RemoveCookieFromURLRequestModel extends LKBaseRequestModel {

    @JSONField(name = "url")
    @LKRequiredParam
    public String url;

    public RemoveCookieFromURLPluginModel$RemoveCookieFromURLRequestModel() {
    }
}
