package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/y;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "a", "()Z", "setEnable", "(Z)V", BuildConfig.FLAVOR, "searchDelayDuration", "I", "getSearchDelayDuration", "()I", "setSearchDelayDuration", "(I)V", BuildConfig.FLAVOR, "searchSchema", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setSearchSchema", "(Ljava/lang/String;)V", "enableAnnieX", "b", "setEnableAnnieX", "enableNewEntrance", "c", "setEnableNewEntrance", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_anniex")
    private boolean enableAnnieX;

    @SerializedName("enable_search_optimize")
    private boolean enableNewEntrance;

    @SerializedName("search_delay_duration")
    private int searchDelayDuration;

    @SerializedName("search_schema")
    private String searchSchema;

    public y() {
        this.searchDelayDuration = 300;
        this.searchSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_gift_panel_douyin%2Fpages%2Fgift_search%2Ftemplate.js&enable_canvas=1&enable_canvas_optmize=1";
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.enableAnnieX;
    }

    public final boolean c() {
        return this.enableNewEntrance;
    }

    public final String d() {
        return this.searchSchema;
    }
}
