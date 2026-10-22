package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$EnterProfileByUserRequest extends LKBaseRequestModel {

    @JSONField(name = "userId")
    @LKRequiredParam
    public String mUserId;

    public Messenger$EnterProfileByUserRequest() {
    }
}
