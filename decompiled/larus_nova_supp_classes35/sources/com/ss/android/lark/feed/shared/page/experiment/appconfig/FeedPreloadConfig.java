package com.ss.android.lark.feed.shared.page.experiment.appconfig;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "npth_optimization")
public class FeedPreloadConfig {

    @SerializedName("min_enable_preload_app_score")
    public double minEnablePreloadAppScore;

    @SerializedName("min_enable_preload_doc_score")
    public double minEnablePreloadDocScore;

    public final String toString() {
        return "FeedPreloadConfig{minEnablePreloadDocScore=" + this.minEnablePreloadDocScore + ", minEnablePreloadAppScore=" + this.minEnablePreloadAppScore + '}';
    }

    public FeedPreloadConfig() {
        this.minEnablePreloadDocScore = 8.0d;
        this.minEnablePreloadAppScore = 8.0d;
    }
}
