package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006("}, d2 = {"Lcom/larus/platform/model/audio/AudioFeedbackFrequencyConfig;", "", "realtimeCallDurationThreshold", "", "realtimeCallIntervalDays", "realtimeMaxDisplayTimes", "realtimeNoFeedbackTimes", "realtimeNoPopupDays", "ttsIntervalDays", "ttsMaxDisplayTimes", "ttsNoFeedbackTimes", "ttsNoPopupDays", "<init>", "(IIIIIIIII)V", "getRealtimeCallDurationThreshold", "()I", "getRealtimeCallIntervalDays", "getRealtimeMaxDisplayTimes", "getRealtimeNoFeedbackTimes", "getRealtimeNoPopupDays", "getTtsIntervalDays", "getTtsMaxDisplayTimes", "getTtsNoFeedbackTimes", "getTtsNoPopupDays", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AudioFeedbackFrequencyConfig {

    @SerializedName("realtime_call_duration_threshold")
    private final int realtimeCallDurationThreshold;

    @SerializedName("realtime_call_interval_days")
    private final int realtimeCallIntervalDays;

    @SerializedName("realtime_max_display_times")
    private final int realtimeMaxDisplayTimes;

    @SerializedName("realtime_no_feedback_times")
    private final int realtimeNoFeedbackTimes;

    @SerializedName("realtime_no_popup_days")
    private final int realtimeNoPopupDays;

    @SerializedName("tts_interval_days")
    private final int ttsIntervalDays;

    @SerializedName("tts_max_display_times")
    private final int ttsMaxDisplayTimes;

    @SerializedName("tts_no_feedback_times")
    private final int ttsNoFeedbackTimes;

    @SerializedName("tts_no_popup_days")
    private final int ttsNoPopupDays;

    public AudioFeedbackFrequencyConfig() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, null);
    }

    public static /* synthetic */ AudioFeedbackFrequencyConfig copy$default(AudioFeedbackFrequencyConfig r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.realtimeCallDurationThreshold;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r3 = r10.realtimeCallIntervalDays;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r4 = r10.realtimeMaxDisplayTimes;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r5 = r10.realtimeNoFeedbackTimes;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r6 = r10.realtimeNoPopupDays;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r7 = r10.ttsIntervalDays;
    L27:
        if ((r20 & 64) == 0) goto L29;
        int r8 = r10.ttsMaxDisplayTimes;
    L31:
        if ((r20 & 128) == 0) goto L33;
        int r9 = r10.ttsNoFeedbackTimes;
    L35:
        if ((r20 & 256) == 0) goto L37;
        int r1 = r10.ttsNoPopupDays;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final int component1() {
        return this.realtimeCallDurationThreshold;
    }

    public final int component2() {
        return this.realtimeCallIntervalDays;
    }

    public final int component3() {
        return this.realtimeMaxDisplayTimes;
    }

    public final int component4() {
        return this.realtimeNoFeedbackTimes;
    }

    public final int component5() {
        return this.realtimeNoPopupDays;
    }

    public final int component6() {
        return this.ttsIntervalDays;
    }

    public final int component7() {
        return this.ttsMaxDisplayTimes;
    }

    public final int component8() {
        return this.ttsNoFeedbackTimes;
    }

    public final int component9() {
        return this.ttsNoPopupDays;
    }

    public final AudioFeedbackFrequencyConfig copy(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        return new AudioFeedbackFrequencyConfig(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioFeedbackFrequencyConfig) == true) goto L8;
        return false;
    L8:
        AudioFeedbackFrequencyConfig r6 = (AudioFeedbackFrequencyConfig) r5;
        if (this.realtimeCallDurationThreshold == r6.realtimeCallDurationThreshold) goto L12;
        return false;
    L12:
        if (this.realtimeCallIntervalDays == r6.realtimeCallIntervalDays) goto L15;
        return false;
    L15:
        if (this.realtimeMaxDisplayTimes == r6.realtimeMaxDisplayTimes) goto L18;
        return false;
    L18:
        if (this.realtimeNoFeedbackTimes == r6.realtimeNoFeedbackTimes) goto L21;
        return false;
    L21:
        if (this.realtimeNoPopupDays == r6.realtimeNoPopupDays) goto L24;
        return false;
    L24:
        if (this.ttsIntervalDays == r6.ttsIntervalDays) goto L27;
        return false;
    L27:
        if (this.ttsMaxDisplayTimes == r6.ttsMaxDisplayTimes) goto L30;
        return false;
    L30:
        if (this.ttsNoFeedbackTimes == r6.ttsNoFeedbackTimes) goto L33;
        return false;
    L33:
        if (this.ttsNoPopupDays == r6.ttsNoPopupDays) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((this.realtimeCallDurationThreshold * 31) + this.realtimeCallIntervalDays) * 31) + this.realtimeMaxDisplayTimes) * 31) + this.realtimeNoFeedbackTimes) * 31) + this.realtimeNoPopupDays) * 31) + this.ttsIntervalDays) * 31) + this.ttsMaxDisplayTimes) * 31) + this.ttsNoFeedbackTimes) * 31) + this.ttsNoPopupDays;
    }

    public String toString() {
        return "AudioFeedbackFrequencyConfig(realtimeCallDurationThreshold=" + this.realtimeCallDurationThreshold + ", realtimeCallIntervalDays=" + this.realtimeCallIntervalDays + ", realtimeMaxDisplayTimes=" + this.realtimeMaxDisplayTimes + ", realtimeNoFeedbackTimes=" + this.realtimeNoFeedbackTimes + ", realtimeNoPopupDays=" + this.realtimeNoPopupDays + ", ttsIntervalDays=" + this.ttsIntervalDays + ", ttsMaxDisplayTimes=" + this.ttsMaxDisplayTimes + ", ttsNoFeedbackTimes=" + this.ttsNoFeedbackTimes + ", ttsNoPopupDays=" + this.ttsNoPopupDays + ')';
    }

    public final int getRealtimeCallDurationThreshold() {
        return this.realtimeCallDurationThreshold;
    }

    public final int getRealtimeCallIntervalDays() {
        return this.realtimeCallIntervalDays;
    }

    public final int getRealtimeMaxDisplayTimes() {
        return this.realtimeMaxDisplayTimes;
    }

    public final int getRealtimeNoFeedbackTimes() {
        return this.realtimeNoFeedbackTimes;
    }

    public final int getRealtimeNoPopupDays() {
        return this.realtimeNoPopupDays;
    }

    public final int getTtsIntervalDays() {
        return this.ttsIntervalDays;
    }

    public final int getTtsMaxDisplayTimes() {
        return this.ttsMaxDisplayTimes;
    }

    public final int getTtsNoFeedbackTimes() {
        return this.ttsNoFeedbackTimes;
    }

    public final int getTtsNoPopupDays() {
        return this.ttsNoPopupDays;
    }

    public AudioFeedbackFrequencyConfig(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.realtimeCallDurationThreshold = r1;
        this.realtimeCallIntervalDays = r2;
        this.realtimeMaxDisplayTimes = r3;
        this.realtimeNoFeedbackTimes = r4;
        this.realtimeNoPopupDays = r5;
        this.ttsIntervalDays = r6;
        this.ttsMaxDisplayTimes = r7;
        this.ttsNoFeedbackTimes = r8;
        this.ttsNoPopupDays = r9;
    }

    public /* synthetic */ AudioFeedbackFrequencyConfig(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, DefaultConstructorMarker r22) {
        int r2 = 30;
        if ((r21 & 1) == 0) goto L5;
        int r1 = 30;
    L6:
        int r4 = 3;
        if ((r21 & 2) == 0) goto L9;
        int r3 = 3;
    L10:
        int r6 = 1;
        if ((r21 & 4) == 0) goto L13;
        int r5 = 1;
    L15:
        if ((r21 & 8) == 0) goto L17;
        int r7 = 3;
    L19:
        if ((r21 & 16) == 0) goto L21;
        int r8 = 15;
    L23:
        if ((r21 & 32) == 0) goto L25;
        int r9 = 3;
    L27:
        if ((r21 & 64) != 0) goto L31;
        r6 = r18;
    L31:
        if ((r21 & 128) != 0) goto L35;
        r4 = r19;
    L35:
        if ((r21 & 256) != 0) goto L38;
        r2 = r20;
    L38:
        this(r1, r3, r5, r7, r8, r9, r6, r4, r2);
        return;
    L25:
        r9 = r17;
        goto L27
    L21:
        r8 = r16;
        goto L23
    L17:
        r7 = r15;
        goto L19
    L13:
        r5 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L10
    L5:
        r1 = r12;
        goto L6
    }
}
