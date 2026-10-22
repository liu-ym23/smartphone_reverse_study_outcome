package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveKtvRealtimeChorusDynamicSettingConfig;", "", "()V", "accompanimentRobotPrefix", "", "getAccompanimentRobotPrefix", "()Ljava/lang/String;", "setAccompanimentRobotPrefix", "(Ljava/lang/String;)V", "dynamicCallDurationMax", "", "getDynamicCallDurationMax", "()I", "setDynamicCallDurationMax", "(I)V", "enableLocalNtpTime", "", "getEnableLocalNtpTime", "()Z", "setEnableLocalNtpTime", "(Z)V", "enableSwitchStreamOpt", "getEnableSwitchStreamOpt", "setEnableSwitchStreamOpt", "lyricSeekThresholdMs", "getLyricSeekThresholdMs", "setLyricSeekThresholdMs", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveKtvRealtimeChorusDynamicSettingConfig {

    @SerializedName("accompaniment_robot_prefix")
    private String accompanimentRobotPrefix;

    @SerializedName("dynamic_call_duration_max_ms")
    private int dynamicCallDurationMax;

    @SerializedName("enable_local_ntp_time")
    private boolean enableLocalNtpTime;

    @SerializedName("enable_switch_stream_opt")
    private boolean enableSwitchStreamOpt;

    @SerializedName("lyric_seek_threshold_ms")
    private int lyricSeekThresholdMs;

    public LiveKtvRealtimeChorusDynamicSettingConfig() {
        this.enableLocalNtpTime = true;
        this.lyricSeekThresholdMs = 200;
        this.dynamicCallDurationMax = 5000;
        this.accompanimentRobotPrefix = "linkmic_robot_accompaniment_";
        this.enableSwitchStreamOpt = true;
    }

    public final String getAccompanimentRobotPrefix() {
        return this.accompanimentRobotPrefix;
    }

    public final int getDynamicCallDurationMax() {
        return this.dynamicCallDurationMax;
    }

    public final boolean getEnableLocalNtpTime() {
        return this.enableLocalNtpTime;
    }

    public final boolean getEnableSwitchStreamOpt() {
        return this.enableSwitchStreamOpt;
    }

    public final int getLyricSeekThresholdMs() {
        return this.lyricSeekThresholdMs;
    }

    public final void setAccompanimentRobotPrefix(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.accompanimentRobotPrefix = r2;
    }

    public final void setDynamicCallDurationMax(int r1) {
        this.dynamicCallDurationMax = r1;
    }

    public final void setEnableLocalNtpTime(boolean r1) {
        this.enableLocalNtpTime = r1;
    }

    public final void setEnableSwitchStreamOpt(boolean r1) {
        this.enableSwitchStreamOpt = r1;
    }

    public final void setLyricSeekThresholdMs(int r1) {
        this.lyricSeekThresholdMs = r1;
    }
}
