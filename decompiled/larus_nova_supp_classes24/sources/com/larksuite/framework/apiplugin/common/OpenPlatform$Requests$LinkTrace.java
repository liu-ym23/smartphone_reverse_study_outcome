package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class OpenPlatform$Requests$LinkTrace extends LKBaseRequestModel {

    @JSONField(name = "linkTraceId")
    @LKRequiredParam
    public String mLinkTraceId;

    @JSONField(name = "originTrace")
    @LKRequiredParam
    public String mOriginTrace;

    public OpenPlatform$Requests$LinkTrace() {
    }
}
