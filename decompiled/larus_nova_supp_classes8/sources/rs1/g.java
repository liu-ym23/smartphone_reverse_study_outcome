package rs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\"\u0010#\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u0006+"}, d2 = {"Lrs1/g;", "", "", "timelineOpenOriginTrack", "Z", "h", "()Z", "setTimelineOpenOriginTrack", "(Z)V", "enableFakeMusicSound", "e", "setEnableFakeMusicSound", "", "fakeMusicSoundUrl", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setFakeMusicSoundUrl", "(Ljava/lang/String;)V", "forceCloseAEC", "g", "setForceCloseAEC", "", "aecLevel", "I", "c", "()I", "setAecLevel", "(I)V", "aecBgmLevel", "a", "setAecBgmLevel", "ansLevel", "d", "setAnsLevel", "aecHeadsetLevel", "b", "setAecHeadsetLevel", "vocalTargetLoudness", "i", "setVocalTargetLoudness", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g {

    @SerializedName("aec_bgm_level")
    private int aecBgmLevel;

    @SerializedName("aec_headset_level")
    private int aecHeadsetLevel;

    @SerializedName("aec_level")
    private int aecLevel;

    @SerializedName("ans_level")
    private int ansLevel;

    @SerializedName("enable_fake_music_sound")
    private boolean enableFakeMusicSound;

    @SerializedName("fake_music_sound_url")
    private String fakeMusicSoundUrl;

    @SerializedName("force_close_aec")
    private boolean forceCloseAEC;

    @SerializedName("teimeline_open_origin_track")
    private boolean timelineOpenOriginTrack;

    @SerializedName("vocal_target_loudness")
    private int vocalTargetLoudness;

    public g() {
        this.fakeMusicSoundUrl = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/solo_ktv_test_voice.mp3";
        this.aecLevel = -1;
        this.aecBgmLevel = -1;
        this.ansLevel = -1;
        this.aecHeadsetLevel = -1;
    }

    public final int a() {
        return this.aecBgmLevel;
    }

    public final int b() {
        return this.aecHeadsetLevel;
    }

    public final int c() {
        return this.aecLevel;
    }

    public final int d() {
        return this.ansLevel;
    }

    public final boolean e() {
        return this.enableFakeMusicSound;
    }

    public final String f() {
        return this.fakeMusicSoundUrl;
    }

    public final boolean g() {
        return this.forceCloseAEC;
    }

    public final boolean h() {
        return this.timelineOpenOriginTrack;
    }

    public final int i() {
        return this.vocalTargetLoudness;
    }
}
