package com.ss.android.lark.chat.chatwindow.chat.model.preload;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@AppConfig(key = "npth_optimization")
public class MessageResourceLoadConfig {
    public boolean a;
    public final boolean b;

    @SerializedName("min_enable_preload_app_score")
    public double minEnablePreloadAppScore;

    @SerializedName("min_enable_preload_doc_score")
    public double minEnablePreloadDocScore;

    public final String toString() {
        return "FeedPreloadConfig{minEnablePreloadDocScore=" + this.minEnablePreloadDocScore + ", minEnablePreloadAppScore=" + this.minEnablePreloadAppScore + '}';
    }

    public MessageResourceLoadConfig() {
        this.minEnablePreloadDocScore = 8.0d;
        this.minEnablePreloadAppScore = 8.0d;
        this.a = true;
        this.b = true;
    }

    public static MessageResourceLoadConfig a() {
        MessageResourceLoadConfig r0 = (MessageResourceLoadConfig) SettingManager.getInstance().get(MessageResourceLoadConfig.class);
        DevicePerfUtils.a r1 = DevicePerfUtils.e();
        if (r1 == null) goto L13;
        double r2 = r1.e;
        double r3 = r0.minEnablePreloadDocScore;
        boolean r5 = true;
        if (r2 <= r3) goto L7;
        boolean r7 = true;
    L8:
        r0.a = r7;
        if (r2 > r3) goto L12;
        r5 = false;
    L12:
        r0.a = r5;
        goto L13
    L7:
        r7 = false;
    L13:
        return r0;
    }
}
