package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bO\u0010PR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00106\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R\"\u00109\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010\u0012R\"\u0010<\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000e\u001a\u0004\b=\u0010\u0010\"\u0004\b>\u0010\u0012R\"\u0010?\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000e\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012R\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001a\u0010I\u001a\u00020H8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020H8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010J\u001a\u0004\bN\u0010L¨\u0006Q"}, d2 = {"Lcom/bytedance/android/livesdk/config/d21;", "", "", "disableKtvControlInVs", "Z", "a", "()Z", "setDisableKtvControlInVs", "(Z)V", "disableMultiLinkInVs", "b", "setDisableMultiLinkInVs", "", "bgmSyncThreshold", "J", "getBgmSyncThreshold", "()J", "setBgmSyncThreshold", "(J)V", "viceBgmSeekInterval", "getViceBgmSeekInterval", "setViceBgmSeekInterval", "playTimeSyncOffset", "getPlayTimeSyncOffset", "setPlayTimeSyncOffset", "bgmStreamSyncInterval", "getBgmStreamSyncInterval", "setBgmStreamSyncInterval", "midiReportCount", "getMidiReportCount", "setMidiReportCount", "continuePushOnPause", "getContinuePushOnPause", "setContinuePushOnPause", "upLinkBrandWidth", "e", "setUpLinkBrandWidth", "enableDownLinkAudioSelect", "getEnableDownLinkAudioSelect", "setEnableDownLinkAudioSelect", "downLinkAudioSelect", "getDownLinkAudioSelect", "setDownLinkAudioSelect", "muteSingerNeedSync", "getMuteSingerNeedSync", "setMuteSingerNeedSync", "roomExNeedMute", "getRoomExNeedMute", "setRoomExNeedMute", "isJoinUnPublish", "setJoinUnPublish", "networkDetect", "getNetworkDetect", "setNetworkDetect", "rtsSeekInterval", "getRtsSeekInterval", "setRtsSeekInterval", "leadSingerSeiInterval", "getLeadSingerSeiInterval", "setLeadSingerSeiInterval", "cdnBgmSyncThreshold", "getCdnBgmSyncThreshold", "setCdnBgmSyncThreshold", "cdnViceBgmSeekInterval", "getCdnViceBgmSeekInterval", "setCdnViceBgmSeekInterval", "cdnViceBgmSeekBackEnable", "getCdnViceBgmSeekBackEnable", "setCdnViceBgmSeekBackEnable", "remoteOriginDisable", "getRemoteOriginDisable", "setRemoteOriginDisable", "Lcom/bytedance/android/livesdk/config/p51;", "stageLynx", "Lcom/bytedance/android/livesdk/config/p51;", "c", "()Lcom/bytedance/android/livesdk/config/p51;", "tuningLynx", "d", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d21 {

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

    @SerializedName("disable_ktv_control_in_vs")
    private boolean disableKtvControlInVs;

    @SerializedName("disable_multi_link_in_vs")
    private boolean disableMultiLinkInVs;

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

    @SerializedName("stage_lynx")
    private final p51 stageLynx;

    @SerializedName("tuning_lynx")
    private final p51 tuningLynx;

    @SerializedName("up_link_band_width")
    private long upLinkBrandWidth;

    @SerializedName("vice_bgm_seek_interval")
    private long viceBgmSeekInterval;

    public d21() {
        this.disableKtvControlInVs = true;
        this.disableMultiLinkInVs = true;
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
        p51 r0 = new p51();
        r0.c();
        r0.d("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/ktv_chorus_plugin_douyin/pages/chorus_stage/template.js?cache_first=0&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D");
        Unit r1 = Unit.INSTANCE;
        this.stageLynx = r0;
        p51 r2 = new p51();
        r2.c();
        r2.d("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/ktv_chorus_plugin_douyin/pages/concert_tuning_panel/template.js?cache_first=0&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D");
        this.tuningLynx = r2;
    }

    public final boolean a() {
        return this.disableKtvControlInVs;
    }

    public final boolean b() {
        return this.disableMultiLinkInVs;
    }

    public final p51 c() {
        return this.stageLynx;
    }

    public final p51 d() {
        return this.tuningLynx;
    }

    public final long e() {
        return this.upLinkBrandWidth;
    }
}
