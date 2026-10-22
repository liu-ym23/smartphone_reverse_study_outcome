package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "passport_session_invalid_opt")
public class PassportSessionInvalidOptConfig implements Serializable {

    @SerializedName("enable")
    public boolean enable;

    public PassportSessionInvalidOptConfig() {
        this.enable = false;
    }
}
