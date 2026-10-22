package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ConfigResponseData implements Serializable {

    @JSONField(name = "errMsg")
    public String errMsg;

    @JSONField(name = "jssdk_session")
    public String h5Session;

    public ConfigResponseData() {
    }
}
