package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/f11;", "", "", "enable", "Z", "d", "()Z", "setEnable", "(Z)V", "traceEnable", "e", "setTraceEnable", "", "audienceBlockBackgroundUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setAudienceBlockBackgroundUrl", "(Ljava/lang/String;)V", "audienceBlockLandBackgroundUrl", "b", "setAudienceBlockLandBackgroundUrl", "audienceBlockWarningUrl", "c", "setAudienceBlockWarningUrl", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f11 {

    @SerializedName("audience_block_background_url")
    private String audienceBlockBackgroundUrl;

    @SerializedName("audience_block_land_background_url")
    private String audienceBlockLandBackgroundUrl;

    @SerializedName("audience_block_warning_url")
    private String audienceBlockWarningUrl;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("trace_enable")
    private boolean traceEnable;

    public f11() {
        this.traceEnable = true;
        this.audienceBlockBackgroundUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/live_audience_block_warning.png";
        this.audienceBlockLandBackgroundUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/live_audience_land_block_background.png";
        this.audienceBlockWarningUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/live_audience_block_background.png";
    }

    public final String a() {
        return this.audienceBlockBackgroundUrl;
    }

    public final String b() {
        return this.audienceBlockLandBackgroundUrl;
    }

    public final String c() {
        return this.audienceBlockWarningUrl;
    }

    public final boolean d() {
        return this.enable;
    }

    public final boolean e() {
        return this.traceEnable;
    }
}
