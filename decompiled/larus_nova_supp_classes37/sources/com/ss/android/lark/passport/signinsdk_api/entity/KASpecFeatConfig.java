package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "passport_ka_spec_feat_config")
public class KASpecFeatConfig implements Serializable {

    @SerializedName("passport_ka_feature_name")
    public String kaFeatureName;

    public KASpecFeatConfig() {
    }
}
