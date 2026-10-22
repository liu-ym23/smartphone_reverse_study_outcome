package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "passport_foreground_user_sync_retry_config")
public class PassportForegroundUserSyncRetryConfig {

    @SerializedName("base_delay")
    public int baseDelay;

    @SerializedName("jitter")
    public int jitter;

    @SerializedName("max_backoff")
    public int maxBackoff;

    @SerializedName("max_retry_count")
    public int maxRetryCount;

    public PassportForegroundUserSyncRetryConfig() {
        this.jitter = 100;
        this.baseDelay = 300;
        this.maxBackoff = 5000;
        this.maxRetryCount = 1000;
    }
}
