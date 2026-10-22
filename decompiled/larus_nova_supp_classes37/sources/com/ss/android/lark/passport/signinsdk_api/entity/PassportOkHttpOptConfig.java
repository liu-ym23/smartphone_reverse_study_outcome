package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "passport_okhttp_load_config")
public class PassportOkHttpOptConfig implements Serializable {

    @SerializedName("enable_replace")
    public boolean enableReplace;

    @SerializedName("enable_reset_read")
    public boolean enableResetRead;

    public PassportOkHttpOptConfig() {
        this.enableResetRead = false;
        this.enableReplace = false;
    }
}
