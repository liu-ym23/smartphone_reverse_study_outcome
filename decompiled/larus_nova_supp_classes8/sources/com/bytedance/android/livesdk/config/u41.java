package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/config/u41;", "", "", "ktvEnabled", "I", "a", "()I", "setKtvEnabled", "(I)V", "", "ktvGuideText", "Ljava/lang/String;", "getKtvGuideText", "()Ljava/lang/String;", "setKtvGuideText", "(Ljava/lang/String;)V", "ktvScoreEnabled", "b", "setKtvScoreEnabled", "", "liveKtvNewStyle", "Z", "getLiveKtvNewStyle", "()Z", "setLiveKtvNewStyle", "(Z)V", "liveKtvTuningEnable", "c", "setLiveKtvTuningEnable", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u41 {

    @SerializedName("ktv_enabled")
    private int ktvEnabled;

    @SerializedName("live_ktv_guide_text")
    private String ktvGuideText;

    @SerializedName("live_ktv_score_enabled")
    private int ktvScoreEnabled;

    @SerializedName("live_ktv_new_style")
    private boolean liveKtvNewStyle;

    @SerializedName("live_ktv_tuning_enable")
    private boolean liveKtvTuningEnable;

    public u41() {
        this.ktvEnabled = 1;
        this.ktvGuideText = "点歌让直播间high起来吧！";
        this.ktvScoreEnabled = 1;
        boolean r0 = tb1.c.a;
        this.liveKtvNewStyle = r0;
        this.liveKtvTuningEnable = r0;
    }

    public final int a() {
        return this.ktvEnabled;
    }

    public final int b() {
        return this.ktvScoreEnabled;
    }

    public final boolean c() {
        return this.liveKtvTuningEnable;
    }
}
