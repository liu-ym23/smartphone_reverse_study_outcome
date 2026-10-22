package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/config/n41;", "", "", "optEnable", "Z", "e", "()Z", "", "delayTimeStrategy", "I", "a", "()I", "enablePullStreamPost", "c", "enableALogPost", "getEnableALogPost", "enableRxJavaAsync", "d", "enableTeaLogPost", "getEnableTeaLogPost", "enableDoChangePageSplit", "b", "enablePopulateDelay", "getEnablePopulateDelay", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n41 {

    @SerializedName("delay_time_strategy")
    private final int delayTimeStrategy;

    @SerializedName("enable_a_log_post")
    private final boolean enableALogPost;

    @SerializedName("enable_do_change_page_split")
    private final boolean enableDoChangePageSplit;

    @SerializedName("enable_populate_delay")
    private final boolean enablePopulateDelay;

    @SerializedName("enable_pull_stream_post")
    private final boolean enablePullStreamPost;

    @SerializedName("enable_rxjava_async")
    private final boolean enableRxJavaAsync;

    @SerializedName("enable_tea_log_post")
    private final boolean enableTeaLogPost;

    @SerializedName("opt_enable")
    private final boolean optEnable;

    public n41() {
        this.delayTimeStrategy = 1;
    }

    public final int a() {
        return this.delayTimeStrategy;
    }

    public final boolean b() {
        return this.enableDoChangePageSplit;
    }

    public final boolean c() {
        return this.enablePullStreamPost;
    }

    public final boolean d() {
        return this.enableRxJavaAsync;
    }

    public final boolean e() {
        return this.optEnable;
    }
}
