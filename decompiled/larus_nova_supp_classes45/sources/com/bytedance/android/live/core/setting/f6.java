package com.bytedance.android.live.core.setting;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class f6 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("enable_report_cache_rate")
    public boolean enableReportCacheRate;

    public f6() {
        this.enable = false;
        this.enableReportCacheRate = false;
    }
}
