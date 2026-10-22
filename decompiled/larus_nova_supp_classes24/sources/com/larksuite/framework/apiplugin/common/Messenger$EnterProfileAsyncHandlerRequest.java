package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$EnterProfileAsyncHandlerRequest extends LKBaseRequestModel {

    @JSONField(name = "openid")
    @LKRequiredParam
    public String mOpenId;

    public Messenger$EnterProfileAsyncHandlerRequest() {
    }
}
