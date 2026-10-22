package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b6\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\"\u0010:\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u000e\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\b¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/config/z41;", "", "", "musicVolume", "I", "getMusicVolume", "()I", "setMusicVolume", "(I)V", "maxMusicVolume", "i", "setMaxMusicVolume", "", "defaultMusicVolumeRatio", "F", "e", "()F", "setDefaultMusicVolumeRatio", "(F)V", "othersVolume", "getOthersVolume", "setOthersVolume", "maxOthersVolume", "j", "setMaxOthersVolume", "defaultOthersVolumeRatio", "f", "setDefaultOthersVolumeRatio", "voiceVolume", "getVoiceVolume", "setVoiceVolume", "maxVoiceVolume", "k", "setMaxVoiceVolume", "defaultVoiceVolumeRatio", "g", "setDefaultVoiceVolumeRatio", "echoVolume", "getEchoVolume", "setEchoVolume", "maxEarVolume", "h", "setMaxEarVolume", "defaultEarVolumeRatio", "d", "setDefaultEarVolumeRatio", "bgmPushVolume", "c", "setBgmPushVolume", "bgmMaxPushVolume", "b", "setBgmMaxPushVolume", "assignLeadVoiceVolume", "a", "setAssignLeadVoiceVolume", "singerVoiceVolume", "l", "setSingerVoiceVolume", "cdnSingerMusicVolume", "getCdnSingerMusicVolume", "setCdnSingerMusicVolume", "maxMusicVolumeForCNDSinger", "getMaxMusicVolumeForCNDSinger", "setMaxMusicVolumeForCNDSinger", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class z41 {

    @SerializedName("lead_singer_voice_volume")
    private int assignLeadVoiceVolume;

    @SerializedName("max_bgm_push_volume")
    private int bgmMaxPushVolume;

    @SerializedName("bgm_push_volume")
    private int bgmPushVolume;

    @SerializedName("music_volume_ratio_for_cdn_singer")
    private float cdnSingerMusicVolume;

    @SerializedName("default_ear_volume_ratio")
    private float defaultEarVolumeRatio;

    @SerializedName("default_music_volume_ratio")
    private float defaultMusicVolumeRatio;

    @SerializedName("default_others_volume_ratio")
    private float defaultOthersVolumeRatio;

    @SerializedName("default_voice_volume_ratio")
    private float defaultVoiceVolumeRatio;

    @SerializedName("echo_volume")
    private int echoVolume;

    @SerializedName("max_ear_volume")
    private int maxEarVolume;

    @SerializedName("max_music_volume")
    private int maxMusicVolume;

    @SerializedName("max_music_volume_for_cdn_singer")
    private int maxMusicVolumeForCNDSinger;

    @SerializedName("max_others_volume")
    private int maxOthersVolume;

    @SerializedName("max_voice_volume")
    private int maxVoiceVolume;

    @SerializedName("music_volume")
    private int musicVolume;

    @SerializedName("others_volume")
    private int othersVolume;

    @SerializedName("normal_singer_voice_volume")
    private int singerVoiceVolume;

    @SerializedName("voice_volume")
    private int voiceVolume;

    public z41() {
        this.musicVolume = 200;
        this.maxMusicVolume = 250;
        this.defaultMusicVolumeRatio = 0.8f;
        this.othersVolume = 30;
        this.maxOthersVolume = 200;
        this.defaultOthersVolumeRatio = 0.15f;
        this.voiceVolume = 80;
        this.maxVoiceVolume = 200;
        this.defaultVoiceVolumeRatio = 0.4f;
        this.echoVolume = 50;
        this.maxEarVolume = 100;
        this.defaultEarVolumeRatio = 0.5f;
        this.bgmPushVolume = 200;
        this.bgmMaxPushVolume = 400;
        this.assignLeadVoiceVolume = 160;
        this.singerVoiceVolume = 120;
        this.cdnSingerMusicVolume = 0.8f;
        this.maxMusicVolumeForCNDSinger = 250;
    }

    public final int a() {
        return this.assignLeadVoiceVolume;
    }

    public final int b() {
        return this.bgmMaxPushVolume;
    }

    public final int c() {
        return this.bgmPushVolume;
    }

    public final float d() {
        return this.defaultEarVolumeRatio;
    }

    public final float e() {
        return this.defaultMusicVolumeRatio;
    }

    public final float f() {
        return this.defaultOthersVolumeRatio;
    }

    public final float g() {
        return this.defaultVoiceVolumeRatio;
    }

    public final int h() {
        return this.maxEarVolume;
    }

    public final int i() {
        return this.maxMusicVolume;
    }

    public final int j() {
        return this.maxOthersVolume;
    }

    public final int k() {
        return this.maxVoiceVolume;
    }

    public final int l() {
        return this.singerVoiceVolume;
    }
}
