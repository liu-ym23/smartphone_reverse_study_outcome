package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class q41 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("max_retry_count")
    public int maxRetryCount;

    @SerializedName("retry_inerval")
    public long retryInterval;

    public q41() {
        this.enable = false;
        this.maxRetryCount = 10;
        this.retryInterval = 5000;
    }
}
