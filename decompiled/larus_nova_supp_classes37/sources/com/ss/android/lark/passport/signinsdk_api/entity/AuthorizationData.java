package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class AuthorizationData implements Serializable {

    @JSONField(name = "configAuth")
    public ConfigAuth configAuth;

    @JSONField(name = "flowType")
    public String flowType;

    public static class ConfigAuth implements Serializable {

        @JSONField(name = "accessToken")
        public String accessToken;

        @JSONField(name = "appId")
        public String appId;

        @JSONField(name = "openId")
        public String openId;

        @JSONField(name = "url")
        public String url;

        @JSONField(name = "userId")
        public String userId;

        public ConfigAuth() {
        }
    }

    public AuthorizationData() {
    }
}
