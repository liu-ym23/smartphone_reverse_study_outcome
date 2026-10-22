package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/config/t41;", "", "", "othersVolume", "I", "g", "()I", "setOthersVolume", "(I)V", "maxOthersVolume", "e", "setMaxOthersVolume", "", "defaultOthersVolumeRatio", "F", "b", "()F", "setDefaultOthersVolumeRatio", "(F)V", "voiceVolume", "getVoiceVolume", "setVoiceVolume", "maxVoiceVolume", "f", "setMaxVoiceVolume", "defaultVoiceVolumeRatio", "c", "setDefaultVoiceVolumeRatio", "maxEarVolume", "d", "setMaxEarVolume", "defaultEarVolumeRatio", "a", "setDefaultEarVolumeRatio", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t41 {

    @SerializedName("default_ear_volume_ratio")
    private float defaultEarVolumeRatio;

    @SerializedName("default_others_volume_ratio")
    private float defaultOthersVolumeRatio;

    @SerializedName("default_voice_volume_ratio")
    private float defaultVoiceVolumeRatio;

    @SerializedName("max_ear_volume")
    private int maxEarVolume;

    @SerializedName("max_others_volume")
    private int maxOthersVolume;

    @SerializedName("max_voice_volume")
    private int maxVoiceVolume;

    @SerializedName("others_volume")
    private int othersVolume;

    @SerializedName("voice_volume")
    private int voiceVolume;

    public t41() {
        this.othersVolume = 100;
        this.maxOthersVolume = 200;
        this.defaultOthersVolumeRatio = 0.7f;
        this.voiceVolume = 80;
        this.maxVoiceVolume = 200;
        this.defaultVoiceVolumeRatio = 0.4f;
        this.maxEarVolume = 100;
        this.defaultEarVolumeRatio = 0.5f;
    }

    public final float a() {
        return this.defaultEarVolumeRatio;
    }

    public final float b() {
        return this.defaultOthersVolumeRatio;
    }

    public final float c() {
        return this.defaultVoiceVolumeRatio;
    }

    public final int d() {
        return this.maxEarVolume;
    }

    public final int e() {
        return this.maxOthersVolume;
    }

    public final int f() {
        return this.maxVoiceVolume;
    }

    public final int g() {
        return this.othersVolume;
    }
}
