package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/y61;", "", "", "defaultMusicVolumeRatio", "F", "getDefaultMusicVolumeRatio", "()F", "setDefaultMusicVolumeRatio", "(F)V", "defaultEchoVolumeRatio", "getDefaultEchoVolumeRatio", "setDefaultEchoVolumeRatio", "defaultOtherVolumeRatio", "getDefaultOtherVolumeRatio", "setDefaultOtherVolumeRatio", "", "maxMusicVolume", "I", "getMaxMusicVolume", "()I", "setMaxMusicVolume", "(I)V", "maxOtherVolume", "getMaxOtherVolume", "setMaxOtherVolume", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class y61 {

    @SerializedName("default_ear_volume_ratio")
    private float defaultEchoVolumeRatio;

    @SerializedName("default_music_volume_ratio")
    private float defaultMusicVolumeRatio;

    @SerializedName("default_others_volume_ratio")
    private float defaultOtherVolumeRatio;

    @SerializedName("max_music_volume")
    private int maxMusicVolume;

    @SerializedName("max_others_volume")
    private int maxOtherVolume;

    public y61() {
        this.defaultMusicVolumeRatio = 0.5f;
        this.defaultEchoVolumeRatio = 0.5f;
        this.defaultOtherVolumeRatio = 0.2f;
        this.maxMusicVolume = 100;
        this.maxOtherVolume = 100;
    }
}
