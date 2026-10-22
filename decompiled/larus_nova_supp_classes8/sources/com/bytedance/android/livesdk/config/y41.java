package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b0\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010DR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\"\u0010(\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\"\u0010+\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\"\u0010.\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\"\u0010=\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0017\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR\"\u0010@\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0017\u001a\u0004\bA\u0010\u0019\"\u0004\bB\u0010\u001b¨\u0006E"}, d2 = {"Lcom/bytedance/android/livesdk/config/y41;", "", "", "bgmSyncThreshold", "J", "b", "()J", "setBgmSyncThreshold", "(J)V", "viceBgmSeekInterval", "p", "setViceBgmSeekInterval", "playTimeSyncOffset", "getPlayTimeSyncOffset", "setPlayTimeSyncOffset", "bgmStreamSyncInterval", "a", "setBgmStreamSyncInterval", "midiReportCount", "j", "setMidiReportCount", "", "continuePushOnPause", "Z", "f", "()Z", "setContinuePushOnPause", "(Z)V", "upLinkBrandWidth", "o", "setUpLinkBrandWidth", "enableDownLinkAudioSelect", "h", "setEnableDownLinkAudioSelect", "downLinkAudioSelect", "g", "setDownLinkAudioSelect", "muteSingerNeedSync", "k", "setMuteSingerNeedSync", "roomExNeedMute", "m", "setRoomExNeedMute", "isJoinUnPublish", "q", "setJoinUnPublish", "networkDetect", "l", "setNetworkDetect", "rtsSeekInterval", "n", "setRtsSeekInterval", "leadSingerSeiInterval", "i", "setLeadSingerSeiInterval", "cdnBgmSyncThreshold", "c", "setCdnBgmSyncThreshold", "cdnViceBgmSeekInterval", "e", "setCdnViceBgmSeekInterval", "cdnViceBgmSeekBackEnable", "d", "setCdnViceBgmSeekBackEnable", "remoteOriginDisable", "getRemoteOriginDisable", "setRemoteOriginDisable", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class y41 {

    @SerializedName("bgm_stream_sync_interval")
    private long bgmStreamSyncInterval;

    @SerializedName("bgm_sync_threshold")
    private long bgmSyncThreshold;

    @SerializedName("cdn_bgm_sync_threshold")
    private long cdnBgmSyncThreshold;

    @SerializedName("cdn_vice_bgm_seek_back")
    private boolean cdnViceBgmSeekBackEnable;

    @SerializedName("cdn_vice_bgm_seek_interval")
    private long cdnViceBgmSeekInterval;

    @SerializedName("continue_push_on_pause")
    private boolean continuePushOnPause;

    @SerializedName("down_link_audio_select_count")
    private long downLinkAudioSelect;

    @SerializedName("enable_down_link_audio_select")
    private boolean enableDownLinkAudioSelect;

    @SerializedName("enable_start_interact_un_publish")
    private boolean isJoinUnPublish;

    @SerializedName("lead_singer_sei_interval")
    private long leadSingerSeiInterval;

    @SerializedName("midi_report_count")
    private long midiReportCount;

    @SerializedName("mute_vice_singer_is_need_sync")
    private boolean muteSingerNeedSync;

    @SerializedName("local_network_detect")
    private boolean networkDetect;

    @SerializedName("play_time_sync_offset")
    private long playTimeSyncOffset;

    @SerializedName("chorus_remote_origin_disable")
    private boolean remoteOriginDisable;

    @SerializedName("room_ex_need_mute")
    private boolean roomExNeedMute;

    @SerializedName("rts_seek_interval")
    private long rtsSeekInterval;

    @SerializedName("up_link_band_width")
    private long upLinkBrandWidth;

    @SerializedName("vice_bgm_seek_interval")
    private long viceBgmSeekInterval;

    public y41() {
        this.bgmSyncThreshold = 80;
        this.viceBgmSeekInterval = 500;
        this.playTimeSyncOffset = 250;
        this.bgmStreamSyncInterval = 100;
        this.midiReportCount = 3;
        this.continuePushOnPause = true;
        this.upLinkBrandWidth = 200;
        this.downLinkAudioSelect = 5;
        this.roomExNeedMute = true;
        this.isJoinUnPublish = true;
        this.networkDetect = true;
        this.rtsSeekInterval = 2000;
        this.leadSingerSeiInterval = 2000;
        this.cdnBgmSyncThreshold = 1200;
        this.cdnViceBgmSeekInterval = AppointmentService.SOURCE_UNDEFINED;
        this.cdnViceBgmSeekBackEnable = true;
        this.remoteOriginDisable = true;
    }

    public final long a() {
        return this.bgmStreamSyncInterval;
    }

    public final long b() {
        return this.bgmSyncThreshold;
    }

    public final long c() {
        return this.cdnBgmSyncThreshold;
    }

    public final boolean d() {
        return this.cdnViceBgmSeekBackEnable;
    }

    public final long e() {
        return this.cdnViceBgmSeekInterval;
    }

    public final boolean f() {
        return this.continuePushOnPause;
    }

    public final long g() {
        return this.downLinkAudioSelect;
    }

    public final boolean h() {
        return this.enableDownLinkAudioSelect;
    }

    public final long i() {
        return this.leadSingerSeiInterval;
    }

    public final long j() {
        return this.midiReportCount;
    }

    public final boolean k() {
        return this.muteSingerNeedSync;
    }

    public final boolean l() {
        return this.networkDetect;
    }

    public final boolean m() {
        return this.roomExNeedMute;
    }

    public final long n() {
        return this.rtsSeekInterval;
    }

    public final long o() {
        return this.upLinkBrandWidth;
    }

    public final long p() {
        return this.viceBgmSeekInterval;
    }

    public final boolean q() {
        return this.isJoinUnPublish;
    }
}
