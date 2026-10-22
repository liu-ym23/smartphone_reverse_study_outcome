package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010#R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R0\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b$\u0010\u001d\u0012\u0004\b'\u0010#\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/v0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enableAll", "Z", "h", "()Z", "audienceEnable", "e", "setAudienceEnable", "(Z)V", "anchorEnable", "b", "setAnchorEnable", BuildConfig.FLAVOR, "audienceLevelThreshold", "I", "g", "()I", "setAudienceLevelThreshold", "(I)V", "audienceFansThreshold", "f", "setAudienceFansThreshold", "anchorFansThreshold", "c", "setAnchorFansThreshold", BuildConfig.FLAVOR, "anchorBanComponentList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setAnchorBanComponentList", "(Ljava/util/List;)V", "getAnchorBanComponentList$annotations", "()V", "audienceBanComponentList", "d", "setAudienceBanComponentList", "getAudienceBanComponentList$annotations", "<init>", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    @SerializedName("anchor_ban_component_list")
    private List<Integer> anchorBanComponentList;

    @SerializedName("anchor_enable")
    private boolean anchorEnable;

    @SerializedName("anchor_fans_threshold")
    private int anchorFansThreshold;

    @SerializedName("audience_ban_component_list")
    private List<Integer> audienceBanComponentList;

    @SerializedName("audience_enable")
    private boolean audienceEnable;

    @SerializedName("audience_fans_threshold")
    private int audienceFansThreshold;

    @SerializedName("audience_level_threshold")
    private int audienceLevelThreshold;

    @SerializedName("enable_all")
    private final boolean enableAll;

    public v0() {
        this.enableAll = true;
        this.anchorEnable = true;
    }

    public final List<Integer> a() {
        return this.anchorBanComponentList;
    }

    public final boolean b() {
        return this.anchorEnable;
    }

    public final int c() {
        return this.anchorFansThreshold;
    }

    public final List<Integer> d() {
        return this.audienceBanComponentList;
    }

    public final boolean e() {
        return this.audienceEnable;
    }

    public final int f() {
        return this.audienceFansThreshold;
    }

    public final int g() {
        return this.audienceLevelThreshold;
    }

    public final boolean h() {
        return this.enableAll;
    }
}
