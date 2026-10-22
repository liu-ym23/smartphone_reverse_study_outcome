package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "passport_logout_config")
public class PassportLogoutConfig implements Serializable {

    @SerializedName("enable_force_logout")
    public boolean enableForceLogout;

    public PassportLogoutConfig() {
        this.enableForceLogout = true;
    }
}
