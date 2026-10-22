package com.larus.settings.tutor;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u0012\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\bHÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\u0013\u0010L\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aHÆ\u0003J\u0013\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aHÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003Jû\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u0003HÆ\u0001J\u0013\u0010P\u001a\u00020\b2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0005HÖ\u0001J\t\u0010S\u001a\u00020THÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010&R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010&R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0016\u0010\u0016\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0016\u0010\u0018\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R \u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R \u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010!¨\u0006U"}, d2 = {"Lcom/larus/settings/tutor/LiveTutorConfig;", "", "feedbackTime", "", "feedbackDayLimit", "", "feedbackCloseCd", "voiceCheckSkipDayLimit", "", "defaultSubtitleState", "isSupportCopyDebugInfo", "uploadALogConfig", "Lcom/larus/settings/tutor/UploadALogConfig;", "backLeaveRoomTimeout", "longWaitingTimeout", "isShowLimitTimeFree", "shortPressTimeout", "longPressTimeout", "longAsrSubmitTimeout", "longBoardGenerateTimeout", "connectingTimeoutMs", "rtcHeartRateIntervalMs", "enableSubtitleFlush", "lottiePlayLevel", "maxBitmapSize", "ttsPitchList", "", "Lcom/larus/settings/tutor/VoiceConfig;", "ttsSpeedList", "liveTutorHeartRateIntervalMs", "<init>", "(JIJZZZLcom/larus/settings/tutor/UploadALogConfig;JJZJJJJJJZIILjava/util/List;Ljava/util/List;J)V", "getFeedbackTime", "()J", "getFeedbackDayLimit", "()I", "getFeedbackCloseCd", "getVoiceCheckSkipDayLimit", "()Z", "getDefaultSubtitleState", "getUploadALogConfig", "()Lcom/larus/settings/tutor/UploadALogConfig;", "getBackLeaveRoomTimeout", "getLongWaitingTimeout", "getShortPressTimeout", "getLongPressTimeout", "getLongAsrSubmitTimeout", "getLongBoardGenerateTimeout", "getConnectingTimeoutMs", "getRtcHeartRateIntervalMs", "getEnableSubtitleFlush", "getLottiePlayLevel", "getMaxBitmapSize", "getTtsPitchList", "()Ljava/util/List;", "getTtsSpeedList", "getLiveTutorHeartRateIntervalMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LiveTutorConfig {

    @SerializedName("back_leave_room_timeout")
    private final long backLeaveRoomTimeout;

    @SerializedName("connecting_timeout_ms")
    private final long connectingTimeoutMs;

    @SerializedName("default_subtitle_state")
    private final boolean defaultSubtitleState;

    @SerializedName("render_subtitle_no_flush")
    private final boolean enableSubtitleFlush;

    @SerializedName("feedback_close_cd")
    private final long feedbackCloseCd;

    @SerializedName("feedback_day_limit")
    private final int feedbackDayLimit;

    @SerializedName("feedback_time")
    private final long feedbackTime;

    @SerializedName("is_show_limit_time_free")
    private final boolean isShowLimitTimeFree;

    @SerializedName("is_support_copy_debug_info")
    private final boolean isSupportCopyDebugInfo;

    @SerializedName("stay_page_heart_rate_interval_ms")
    private final long liveTutorHeartRateIntervalMs;

    @SerializedName("long_asr_submit_timeout")
    private final long longAsrSubmitTimeout;

    @SerializedName("long_board_generate_timeout")
    private final long longBoardGenerateTimeout;

    @SerializedName("long_press_timeout")
    private final long longPressTimeout;

    @SerializedName("long_waiting_timeout")
    private final long longWaitingTimeout;

    @SerializedName("lottie_play_level")
    private final int lottiePlayLevel;

    @SerializedName("max_bitmap_size")
    private final int maxBitmapSize;

    @SerializedName("rtc_heart_rate_interval_ms")
    private final long rtcHeartRateIntervalMs;

    @SerializedName("short_press_timeout_ms")
    private final long shortPressTimeout;

    @SerializedName("tts_pitch_list")
    private final List<VoiceConfig> ttsPitchList;

    @SerializedName("tts_speed_list")
    private final List<VoiceConfig> ttsSpeedList;

    @SerializedName("upload_alog_config")
    private final UploadALogConfig uploadALogConfig;

    @SerializedName("voice_check_skip_day_limit")
    private final boolean voiceCheckSkipDayLimit;

    public LiveTutorConfig() {
        this(0, 0, 0, false, false, false, null, 0, 0, false, 0, 0, 0, 0, 0, 0, false, 0, 0, null, null, 0, 4194303, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveTutorConfig copy$default(LiveTutorConfig r17, long r18, int r20, long r21, boolean r23, boolean r24, boolean r25, UploadALogConfig r26, long r27, long r29, boolean r31, long r32, long r34, long r36, long r38, long r40, long r42, boolean r44, int r45, int r46, List r47, List r48, long r49, int r51, Object r52) {
        if ((r51 & 1) == 0) goto L5;
        long r2 = r17.feedbackTime;
    L7:
        if ((r51 & 2) == 0) goto L9;
        int r4 = r17.feedbackDayLimit;
    L11:
        if ((r51 & 4) == 0) goto L13;
        long r5 = r17.feedbackCloseCd;
    L15:
        if ((r51 & 8) == 0) goto L17;
        boolean r7 = r17.voiceCheckSkipDayLimit;
    L19:
        if ((r51 & 16) == 0) goto L21;
        boolean r8 = r17.defaultSubtitleState;
    L23:
        if ((r51 & 32) == 0) goto L25;
        boolean r9 = r17.isSupportCopyDebugInfo;
    L27:
        if ((r51 & 64) == 0) goto L29;
        UploadALogConfig r10 = r17.uploadALogConfig;
    L31:
        if ((r51 & 128) == 0) goto L33;
        long r11 = r17.backLeaveRoomTimeout;
    L35:
        if ((r51 & 256) == 0) goto L37;
        long r13 = r17.longWaitingTimeout;
    L39:
        if ((r51 & 512) == 0) goto L41;
        boolean r15 = r17.isShowLimitTimeFree;
    L42:
        boolean r33 = r15;
        long r210 = r13;
        if ((r51 & 1024) == 0) goto L45;
        long r14 = r17.shortPressTimeout;
    L46:
        long r35 = r14;
        if ((r51 & 2048) == 0) goto L49;
        long r16 = r17.longPressTimeout;
    L50:
        long r37 = r16;
        if ((r51 & 4096) == 0) goto L53;
        long r19 = r17.longAsrSubmitTimeout;
    L54:
        long r39 = r19;
        if ((r51 & 8192) == 0) goto L57;
        long r110 = r17.longBoardGenerateTimeout;
    L58:
        long r310 = r110;
        if ((r51 & 16384) == 0) goto L61;
        long r111 = r17.connectingTimeoutMs;
    L62:
        long r41 = r111;
        if ((32768 & r51) == 0) goto L65;
        long r112 = r17.rtcHeartRateIntervalMs;
    L67:
        if ((65536 & r51) == 0) goto L69;
        boolean r113 = r17.enableSubtitleFlush;
    L70:
        boolean r410 = r113;
        if ((r51 & 131072) == 0) goto L73;
        int r114 = r17.lottiePlayLevel;
    L74:
        int r411 = r114;
        if ((r51 & 262144) == 0) goto L77;
        int r115 = r17.maxBitmapSize;
    L78:
        int r412 = r115;
        if ((r51 & 524288) == 0) goto L81;
        List r116 = r17.ttsPitchList;
    L82:
        List r413 = r116;
        if ((r51 & 1048576) == 0) goto L85;
        List r117 = r17.ttsSpeedList;
    L86:
        long r43 = r112;
        if ((r51 & 2097152) == 0) goto L89;
        long r118 = r17.liveTutorHeartRateIntervalMs;
    L91:
        return r17.copy(r2, r4, r5, r7, r8, r9, r10, r11, r210, r33, r35, r37, r39, r310, r41, r43, r410, r411, r412, r413, r117, r118);
    L89:
        r118 = r49;
        goto L91
    L85:
        r117 = r48;
        goto L86
    L81:
        r116 = r47;
        goto L82
    L77:
        r115 = r46;
        goto L78
    L73:
        r114 = r45;
        goto L74
    L69:
        r113 = r44;
        goto L70
    L65:
        r112 = r42;
        goto L67
    L61:
        r111 = r40;
        goto L62
    L57:
        r110 = r38;
        goto L58
    L53:
        r19 = r36;
        goto L54
    L49:
        r16 = r34;
        goto L50
    L45:
        r14 = r32;
        goto L46
    L41:
        r15 = r31;
        goto L42
    L37:
        r13 = r29;
        goto L39
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long component1() {
        return this.feedbackTime;
    }

    public final boolean component10() {
        return this.isShowLimitTimeFree;
    }

    public final long component11() {
        return this.shortPressTimeout;
    }

    public final long component12() {
        return this.longPressTimeout;
    }

    public final long component13() {
        return this.longAsrSubmitTimeout;
    }

    public final long component14() {
        return this.longBoardGenerateTimeout;
    }

    public final long component15() {
        return this.connectingTimeoutMs;
    }

    public final long component16() {
        return this.rtcHeartRateIntervalMs;
    }

    public final boolean component17() {
        return this.enableSubtitleFlush;
    }

    public final int component18() {
        return this.lottiePlayLevel;
    }

    public final int component19() {
        return this.maxBitmapSize;
    }

    public final int component2() {
        return this.feedbackDayLimit;
    }

    public final List<VoiceConfig> component20() {
        return this.ttsPitchList;
    }

    public final List<VoiceConfig> component21() {
        return this.ttsSpeedList;
    }

    public final long component22() {
        return this.liveTutorHeartRateIntervalMs;
    }

    public final long component3() {
        return this.feedbackCloseCd;
    }

    public final boolean component4() {
        return this.voiceCheckSkipDayLimit;
    }

    public final boolean component5() {
        return this.defaultSubtitleState;
    }

    public final boolean component6() {
        return this.isSupportCopyDebugInfo;
    }

    public final UploadALogConfig component7() {
        return this.uploadALogConfig;
    }

    public final long component8() {
        return this.backLeaveRoomTimeout;
    }

    public final long component9() {
        return this.longWaitingTimeout;
    }

    public final LiveTutorConfig copy(long r36, int r38, long r39, boolean r41, boolean r42, boolean r43, UploadALogConfig r44, long r45, long r47, boolean r49, long r50, long r52, long r54, long r56, long r58, long r60, boolean r62, int r63, int r64, List<VoiceConfig> r65, List<VoiceConfig> r66, long r67) {
        return new LiveTutorConfig(r36, r38, r39, r41, r42, r43, r44, r45, r47, r49, r50, r52, r54, r56, r58, r60, r62, r63, r64, r65, r66, r67);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LiveTutorConfig) == true) goto L8;
        return false;
    L8:
        LiveTutorConfig r9 = (LiveTutorConfig) r8;
        if (this.feedbackTime == r9.feedbackTime) goto L12;
        return false;
    L12:
        if (this.feedbackDayLimit == r9.feedbackDayLimit) goto L15;
        return false;
    L15:
        if (this.feedbackCloseCd == r9.feedbackCloseCd) goto L18;
        return false;
    L18:
        if (this.voiceCheckSkipDayLimit == r9.voiceCheckSkipDayLimit) goto L21;
        return false;
    L21:
        if (this.defaultSubtitleState == r9.defaultSubtitleState) goto L24;
        return false;
    L24:
        if (this.isSupportCopyDebugInfo == r9.isSupportCopyDebugInfo) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.uploadALogConfig, r9.uploadALogConfig) == true) goto L30;
        return false;
    L30:
        if (this.backLeaveRoomTimeout == r9.backLeaveRoomTimeout) goto L33;
        return false;
    L33:
        if (this.longWaitingTimeout == r9.longWaitingTimeout) goto L36;
        return false;
    L36:
        if (this.isShowLimitTimeFree == r9.isShowLimitTimeFree) goto L39;
        return false;
    L39:
        if (this.shortPressTimeout == r9.shortPressTimeout) goto L42;
        return false;
    L42:
        if (this.longPressTimeout == r9.longPressTimeout) goto L45;
        return false;
    L45:
        if (this.longAsrSubmitTimeout == r9.longAsrSubmitTimeout) goto L48;
        return false;
    L48:
        if (this.longBoardGenerateTimeout == r9.longBoardGenerateTimeout) goto L51;
        return false;
    L51:
        if (this.connectingTimeoutMs == r9.connectingTimeoutMs) goto L54;
        return false;
    L54:
        if (this.rtcHeartRateIntervalMs == r9.rtcHeartRateIntervalMs) goto L57;
        return false;
    L57:
        if (this.enableSubtitleFlush == r9.enableSubtitleFlush) goto L60;
        return false;
    L60:
        if (this.lottiePlayLevel == r9.lottiePlayLevel) goto L63;
        return false;
    L63:
        if (this.maxBitmapSize == r9.maxBitmapSize) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.ttsPitchList, r9.ttsPitchList) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.ttsSpeedList, r9.ttsSpeedList) == true) goto L72;
        return false;
    L72:
        if (this.liveTutorHeartRateIntervalMs == r9.liveTutorHeartRateIntervalMs) goto L74;
        return false;
    L74:
        return true;
    }

    public int hashCode() {
        long r0 = this.feedbackTime;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.feedbackDayLimit) * 31;
        long r3 = this.feedbackCloseCd;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        int r4 = 1231;
        if (this.voiceCheckSkipDayLimit == false) goto L5;
        int r5 = 1231;
    L6:
        int r6 = (r2 + r5) * 31;
        if (this.defaultSubtitleState == false) goto L9;
        int r7 = 1231;
    L10:
        int r8 = (r6 + r7) * 31;
        if (this.isSupportCopyDebugInfo == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r8 + r9) * 31;
        UploadALogConfig r11 = this.uploadALogConfig;
        int r12 = 0;
        if (r11 != null) goto L17;
        int r13 = 0;
    L18:
        long r14 = this.backLeaveRoomTimeout;
        int r15 = (((r10 + r13) * 31) + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        long r16 = this.longWaitingTimeout;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        if (this.isShowLimitTimeFree == false) goto L21;
        int r18 = 1231;
    L22:
        long r19 = this.shortPressTimeout;
        int r20 = (((r17 + r18) * 31) + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        long r21 = this.longPressTimeout;
        int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        long r23 = this.longAsrSubmitTimeout;
        int r24 = (r22 + ((int) (r23 ^ (r23 >>> 32)))) * 31;
        long r25 = this.longBoardGenerateTimeout;
        int r26 = (r24 + ((int) (r25 ^ (r25 >>> 32)))) * 31;
        long r27 = this.connectingTimeoutMs;
        int r28 = (r26 + ((int) (r27 ^ (r27 >>> 32)))) * 31;
        long r29 = this.rtcHeartRateIntervalMs;
        int r30 = (r28 + ((int) (r29 ^ (r29 >>> 32)))) * 31;
        if (this.enableSubtitleFlush == true) goto L26;
        r4 = 1237;
    L26:
        int r31 = (((((r30 + r4) * 31) + this.lottiePlayLevel) * 31) + this.maxBitmapSize) * 31;
        List<VoiceConfig> r32 = this.ttsPitchList;
        if (r32 != null) goto L29;
        int r33 = 0;
    L30:
        int r34 = (r31 + r33) * 31;
        List<VoiceConfig> r35 = this.ttsSpeedList;
        if (r35 == null) goto L34;
        r12 = r35.hashCode();
    L34:
        long r36 = this.liveTutorHeartRateIntervalMs;
        return ((r34 + r12) * 31) + ((int) (r36 ^ (r36 >>> 32)));
    L29:
        r33 = r32.hashCode();
        goto L30
    L21:
        r18 = 1237;
        goto L22
    L17:
        r13 = r11.hashCode();
        goto L18
    L13:
        r9 = 1237;
        goto L14
    L9:
        r7 = 1237;
        goto L10
    L5:
        r5 = 1237;
        goto L6
    }

    public String toString() {
        return "LiveTutorConfig(feedbackTime=" + this.feedbackTime + ", feedbackDayLimit=" + this.feedbackDayLimit + ", feedbackCloseCd=" + this.feedbackCloseCd + ", voiceCheckSkipDayLimit=" + this.voiceCheckSkipDayLimit + ", defaultSubtitleState=" + this.defaultSubtitleState + ", isSupportCopyDebugInfo=" + this.isSupportCopyDebugInfo + ", uploadALogConfig=" + this.uploadALogConfig + ", backLeaveRoomTimeout=" + this.backLeaveRoomTimeout + ", longWaitingTimeout=" + this.longWaitingTimeout + ", isShowLimitTimeFree=" + this.isShowLimitTimeFree + ", shortPressTimeout=" + this.shortPressTimeout + ", longPressTimeout=" + this.longPressTimeout + ", longAsrSubmitTimeout=" + this.longAsrSubmitTimeout + ", longBoardGenerateTimeout=" + this.longBoardGenerateTimeout + ", connectingTimeoutMs=" + this.connectingTimeoutMs + ", rtcHeartRateIntervalMs=" + this.rtcHeartRateIntervalMs + ", enableSubtitleFlush=" + this.enableSubtitleFlush + ", lottiePlayLevel=" + this.lottiePlayLevel + ", maxBitmapSize=" + this.maxBitmapSize + ", ttsPitchList=" + this.ttsPitchList + ", ttsSpeedList=" + this.ttsSpeedList + ", liveTutorHeartRateIntervalMs=" + this.liveTutorHeartRateIntervalMs + ')';
    }

    public final long getBackLeaveRoomTimeout() {
        return this.backLeaveRoomTimeout;
    }

    public final long getConnectingTimeoutMs() {
        return this.connectingTimeoutMs;
    }

    public final boolean getDefaultSubtitleState() {
        return this.defaultSubtitleState;
    }

    public final boolean getEnableSubtitleFlush() {
        return this.enableSubtitleFlush;
    }

    public final long getFeedbackCloseCd() {
        return this.feedbackCloseCd;
    }

    public final int getFeedbackDayLimit() {
        return this.feedbackDayLimit;
    }

    public final long getFeedbackTime() {
        return this.feedbackTime;
    }

    public final long getLiveTutorHeartRateIntervalMs() {
        return this.liveTutorHeartRateIntervalMs;
    }

    public final long getLongAsrSubmitTimeout() {
        return this.longAsrSubmitTimeout;
    }

    public final long getLongBoardGenerateTimeout() {
        return this.longBoardGenerateTimeout;
    }

    public final long getLongPressTimeout() {
        return this.longPressTimeout;
    }

    public final long getLongWaitingTimeout() {
        return this.longWaitingTimeout;
    }

    public final int getLottiePlayLevel() {
        return this.lottiePlayLevel;
    }

    public final int getMaxBitmapSize() {
        return this.maxBitmapSize;
    }

    public final long getRtcHeartRateIntervalMs() {
        return this.rtcHeartRateIntervalMs;
    }

    public final long getShortPressTimeout() {
        return this.shortPressTimeout;
    }

    public final List<VoiceConfig> getTtsPitchList() {
        return this.ttsPitchList;
    }

    public final List<VoiceConfig> getTtsSpeedList() {
        return this.ttsSpeedList;
    }

    public final UploadALogConfig getUploadALogConfig() {
        return this.uploadALogConfig;
    }

    public final boolean getVoiceCheckSkipDayLimit() {
        return this.voiceCheckSkipDayLimit;
    }

    public final boolean isShowLimitTimeFree() {
        return this.isShowLimitTimeFree;
    }

    public final boolean isSupportCopyDebugInfo() {
        return this.isSupportCopyDebugInfo;
    }

    public LiveTutorConfig(long r4, int r6, long r7, boolean r9, boolean r10, boolean r11, UploadALogConfig r12, long r13, long r15, boolean r17, long r18, long r20, long r22, long r24, long r26, long r28, boolean r30, int r31, int r32, List<VoiceConfig> r33, List<VoiceConfig> r34, long r35) {
        this.feedbackTime = r4;
        this.feedbackDayLimit = r6;
        this.feedbackCloseCd = r7;
        this.voiceCheckSkipDayLimit = r9;
        this.defaultSubtitleState = r10;
        this.isSupportCopyDebugInfo = r11;
        this.uploadALogConfig = r12;
        this.backLeaveRoomTimeout = r13;
        this.longWaitingTimeout = r15;
        this.isShowLimitTimeFree = r17;
        this.shortPressTimeout = r18;
        this.longPressTimeout = r20;
        this.longAsrSubmitTimeout = r22;
        this.longBoardGenerateTimeout = r24;
        this.connectingTimeoutMs = r26;
        this.rtcHeartRateIntervalMs = r28;
        this.enableSubtitleFlush = r30;
        this.lottiePlayLevel = r31;
        this.maxBitmapSize = r32;
        this.ttsPitchList = r33;
        this.ttsSpeedList = r34;
        this.liveTutorHeartRateIntervalMs = r35;
    }

    public LiveTutorConfig(long r36, int r38, long r39, boolean r41, boolean r42, boolean r43, UploadALogConfig r44, long r45, long r47, boolean r49, long r50, long r52, long r54, long r56, long r58, long r60, boolean r62, int r63, int r64, List r65, List r66, long r67, int r69, DefaultConstructorMarker r70) {
        if ((r69 & 1) == 0) goto L5;
        long r1 = 60;
    L7:
        if ((r69 & 2) == 0) goto L9;
        int r3 = 1;
    L11:
        if ((r69 & 4) == 0) goto L13;
        long r5 = 172800;
    L14:
        int r8 = 0;
        if ((r69 & 8) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r69 & 16) == 0) goto L21;
        boolean r9 = true;
    L23:
        if ((r69 & 32) == 0) goto L25;
        boolean r10 = true;
    L27:
        if ((r69 & 64) == 0) goto L29;
        UploadALogConfig r11 = null;
    L31:
        if ((r69 & 128) == 0) goto L33;
        long r12 = 18000;
    L34:
        long r15 = 15000;
        if ((r69 & 256) == 0) goto L37;
        long r17 = 15000;
    L39:
        if ((r69 & 512) == 0) goto L41;
        boolean r14 = true;
    L43:
        if ((r69 & 1024) == 0) goto L45;
        long r19 = 500;
    L47:
        if ((r69 & 2048) == 0) goto L49;
        long r21 = 120000;
    L51:
        if ((r69 & 4096) == 0) goto L53;
        long r23 = 3000;
    L54:
        long r25 = 10000;
        if ((r69 & 8192) == 0) goto L57;
        long r27 = 10000;
    L59:
        if ((r69 & 16384) != 0) goto L63;
        r15 = r58;
    L63:
        if ((32768 & r69) == 0) goto L65;
        long r29 = 1000;
    L67:
        if ((65536 & r69) == 0) goto L69;
        boolean r4 = true;
    L71:
        if ((r69 & 131072) != 0) goto L75;
        r8 = r63;
    L75:
        if ((r69 & 262144) == 0) goto L77;
        int r31 = 4096;
    L79:
        if ((r69 & 524288) == 0) goto L81;
        List r32 = b.a;
    L83:
        if ((r69 & 1048576) == 0) goto L85;
        List r33 = b.b;
    L87:
        if ((r69 & 2097152) != 0) goto L90;
        r25 = r67;
    L90:
        this(r1, r3, r5, r7, r9, r10, r11, r12, r17, r14, r19, r21, r23, r27, r15, r29, r4, r8, r31, r32, r33, r25);
        return;
    L85:
        r33 = r66;
        goto L87
    L81:
        r32 = r65;
        goto L83
    L77:
        r31 = r64;
        goto L79
    L69:
        r4 = r62;
        goto L71
    L65:
        r29 = r60;
        goto L67
    L57:
        r27 = r56;
        goto L59
    L53:
        r23 = r54;
        goto L54
    L49:
        r21 = r52;
        goto L51
    L45:
        r19 = r50;
        goto L47
    L41:
        r14 = r49;
        goto L43
    L37:
        r17 = r47;
        goto L39
    L33:
        r12 = r45;
        goto L34
    L29:
        r11 = r44;
        goto L31
    L25:
        r10 = r43;
        goto L27
    L21:
        r9 = r42;
        goto L23
    L17:
        r7 = r41;
        goto L19
    L13:
        r5 = r39;
        goto L14
    L9:
        r3 = r38;
        goto L11
    L5:
        r1 = r36;
        goto L7
    }
}
