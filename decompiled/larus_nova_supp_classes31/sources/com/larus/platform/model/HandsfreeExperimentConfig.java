package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b \b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J[\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015¨\u0006+"}, d2 = {"Lcom/larus/platform/model/HandsfreeExperimentConfig;", "", "micClickBehavior", "", "handsfreeAsrEndBehavior", "", "longPressLockEnabled", "", "voiceInputClickEnabled", "cancelIconStyle", "maxAudioDurationMs", "", "foregroundServiceEnabled", "handsfreeLayerDisableGesture", "<init>", "(ILjava/lang/String;ZZIJZZ)V", "getMicClickBehavior", "()I", "getHandsfreeAsrEndBehavior", "()Ljava/lang/String;", "getLongPressLockEnabled", "()Z", "getVoiceInputClickEnabled", "getCancelIconStyle", "getMaxAudioDurationMs", "()J", "getForegroundServiceEnabled", "getHandsfreeLayerDisableGesture", "isHandsfreeSupported", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class HandsfreeExperimentConfig {
    public static final String ASR_END_BACKFILL = "backfill";
    public static final String ASR_END_SEND = "send";
    public static final int CANCEL_ICON_CROSS = 1;
    public static final int CANCEL_ICON_TRASH = 0;
    public static final a Companion = null;
    public static final int MIC_CLICK_ENTER_HANDSFREE = 1;
    public static final int MIC_CLICK_SWITCH_VOICE_INPUT = 0;

    @SerializedName("cancel_icon_style")
    private final int cancelIconStyle;

    @SerializedName("foreground_service_enabled")
    private final boolean foregroundServiceEnabled;

    @SerializedName("handsfree_asr_end_behavior")
    private final String handsfreeAsrEndBehavior;

    @SerializedName("handsfree_layer_disable_gesture")
    private final boolean handsfreeLayerDisableGesture;

    @SerializedName("long_press_lock_enabled")
    private final boolean longPressLockEnabled;

    @SerializedName("max_audio_duration_ms")
    private final long maxAudioDurationMs;

    @SerializedName("mic_click_behavior")
    private final int micClickBehavior;

    @SerializedName("voice_input_click_enabled")
    private final boolean voiceInputClickEnabled;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public HandsfreeExperimentConfig() {
        this(0, null, false, false, 0, 0, false, false, 255, null);
    }

    public static /* synthetic */ HandsfreeExperimentConfig copy$default(HandsfreeExperimentConfig r10, int r11, String r12, boolean r13, boolean r14, int r15, long r16, boolean r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.micClickBehavior;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.handsfreeAsrEndBehavior;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.longPressLockEnabled;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r5 = r10.voiceInputClickEnabled;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r6 = r10.cancelIconStyle;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r7 = r10.maxAudioDurationMs;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r9 = r10.foregroundServiceEnabled;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r1 = r10.handsfreeLayerDisableGesture;
    L35:
        return r10.copy(r2, r3, r4, r5, r6, r7, r9, r1);
    L33:
        r1 = r19;
        goto L35
    L29:
        r9 = r18;
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
        return this.micClickBehavior;
    }

    public final String component2() {
        return this.handsfreeAsrEndBehavior;
    }

    public final boolean component3() {
        return this.longPressLockEnabled;
    }

    public final boolean component4() {
        return this.voiceInputClickEnabled;
    }

    public final int component5() {
        return this.cancelIconStyle;
    }

    public final long component6() {
        return this.maxAudioDurationMs;
    }

    public final boolean component7() {
        return this.foregroundServiceEnabled;
    }

    public final boolean component8() {
        return this.handsfreeLayerDisableGesture;
    }

    public final HandsfreeExperimentConfig copy(int r12, String r13, boolean r14, boolean r15, int r16, long r17, boolean r19, boolean r20) {
        return new HandsfreeExperimentConfig(r12, r13, r14, r15, r16, r17, r19, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof HandsfreeExperimentConfig) == true) goto L8;
        return false;
    L8:
        HandsfreeExperimentConfig r9 = (HandsfreeExperimentConfig) r8;
        if (this.micClickBehavior == r9.micClickBehavior) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.handsfreeAsrEndBehavior, r9.handsfreeAsrEndBehavior) == true) goto L15;
        return false;
    L15:
        if (this.longPressLockEnabled == r9.longPressLockEnabled) goto L18;
        return false;
    L18:
        if (this.voiceInputClickEnabled == r9.voiceInputClickEnabled) goto L21;
        return false;
    L21:
        if (this.cancelIconStyle == r9.cancelIconStyle) goto L24;
        return false;
    L24:
        if (this.maxAudioDurationMs == r9.maxAudioDurationMs) goto L27;
        return false;
    L27:
        if (this.foregroundServiceEnabled == r9.foregroundServiceEnabled) goto L30;
        return false;
    L30:
        if (this.handsfreeLayerDisableGesture == r9.handsfreeLayerDisableGesture) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.micClickBehavior * 31;
        String r1 = this.handsfreeAsrEndBehavior;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        int r4 = 1231;
        if (this.longPressLockEnabled == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.voiceInputClickEnabled == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (((r6 + r7) * 31) + this.cancelIconStyle) * 31;
        long r9 = this.maxAudioDurationMs;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        if (this.foregroundServiceEnabled == false) goto L17;
        int r11 = 1231;
    L18:
        int r12 = (r10 + r11) * 31;
        if (this.handsfreeLayerDisableGesture == true) goto L23;
        r4 = 1237;
    L23:
        return r12 + r4;
    L17:
        r11 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "HandsfreeExperimentConfig(micClickBehavior=" + this.micClickBehavior + ", handsfreeAsrEndBehavior=" + this.handsfreeAsrEndBehavior + ", longPressLockEnabled=" + this.longPressLockEnabled + ", voiceInputClickEnabled=" + this.voiceInputClickEnabled + ", cancelIconStyle=" + this.cancelIconStyle + ", maxAudioDurationMs=" + this.maxAudioDurationMs + ", foregroundServiceEnabled=" + this.foregroundServiceEnabled + ", handsfreeLayerDisableGesture=" + this.handsfreeLayerDisableGesture + ')';
    }

    public final boolean isHandsfreeSupported() {
        if (this.micClickBehavior != 1) goto L5;
        return true;
    L5:
        if (this.longPressLockEnabled == false) goto L7;
        return true;
    L7:
        if (this.voiceInputClickEnabled == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int getCancelIconStyle() {
        return this.cancelIconStyle;
    }

    public final boolean getForegroundServiceEnabled() {
        return this.foregroundServiceEnabled;
    }

    public final String getHandsfreeAsrEndBehavior() {
        return this.handsfreeAsrEndBehavior;
    }

    public final boolean getHandsfreeLayerDisableGesture() {
        return this.handsfreeLayerDisableGesture;
    }

    public final boolean getLongPressLockEnabled() {
        return this.longPressLockEnabled;
    }

    public final long getMaxAudioDurationMs() {
        return this.maxAudioDurationMs;
    }

    public final int getMicClickBehavior() {
        return this.micClickBehavior;
    }

    public final boolean getVoiceInputClickEnabled() {
        return this.voiceInputClickEnabled;
    }

    public HandsfreeExperimentConfig(int r1, String r2, boolean r3, boolean r4, int r5, long r6, boolean r8, boolean r9) {
        this.micClickBehavior = r1;
        this.handsfreeAsrEndBehavior = r2;
        this.longPressLockEnabled = r3;
        this.voiceInputClickEnabled = r4;
        this.cancelIconStyle = r5;
        this.maxAudioDurationMs = r6;
        this.foregroundServiceEnabled = r8;
        this.handsfreeLayerDisableGesture = r9;
    }

    public /* synthetic */ HandsfreeExperimentConfig(int r11, String r12, boolean r13, boolean r14, int r15, long r16, boolean r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        boolean r2 = false;
        if ((r20 & 1) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = ASR_END_SEND;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r6 = 0;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r7 = 300000;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r9 = true;
    L31:
        if ((r20 & 128) != 0) goto L34;
        r2 = r19;
    L34:
        this(r1, r3, r4, r5, r6, r7, r9, r2);
        return;
    L29:
        r9 = r18;
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
        r1 = r11;
        goto L7
    }
}
