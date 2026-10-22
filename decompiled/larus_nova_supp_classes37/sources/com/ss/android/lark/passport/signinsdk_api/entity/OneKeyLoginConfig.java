package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "passport_onekey_login")
public class OneKeyLoginConfig implements Serializable {

    @SerializedName("channel")
    public String channel;

    @SerializedName("cm")
    public OneKeyLoginConfigBean cm;

    @SerializedName("ct")
    public OneKeyLoginConfigBean ct;

    @SerializedName("cu")
    public OneKeyLoginConfigBean cu;

    public static class OneKeyLoginConfigBean implements Serializable {

        @SerializedName(AppbrandHostConstants.Schema_RESERVED_FIELD.APP_ID)
        public String appId;

        @SerializedName("app_key")
        public String appKey;

        public OneKeyLoginConfigBean() {
        }
    }

    public OneKeyLoginConfig() {
    }
}
