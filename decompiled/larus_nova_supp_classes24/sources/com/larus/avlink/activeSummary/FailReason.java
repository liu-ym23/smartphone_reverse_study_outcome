package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/larus/avlink/activeSummary/FailReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "SUMMARY_REQUEST_FAIL", "ON_NOT_DISTURB", "TIMEOUT", "OVERWRITTEN", "RESPONSE_INVALID", "EXPERIMENT_OR_SWITCH_OFF", "AUDIO_CONFLICTS", "PRIORITY_SWITCH_OFF", "PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED", "PHONE_SPEAKER", "AUDIO_OUTPUT_NOT_DORA", "OTHER_DEVICE_A2DP_OCCUPIED", "DEVICE_UNLOCKED", "HFP_OCCUPIED", "VUI_DISABLED", "WAKE_MODE_SINGLE_ROUND_ON", "WAKE_MODE_MULTI_ROUND_ON", "IM_TTS_IS_PLAYING", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum FailReason extends Enum<FailReason> {
    public static final FailReason AUDIO_CONFLICTS = null;
    public static final FailReason AUDIO_OUTPUT_NOT_DORA = null;
    public static final FailReason DEVICE_UNLOCKED = null;
    public static final FailReason EXPERIMENT_OR_SWITCH_OFF = null;
    public static final FailReason HFP_OCCUPIED = null;
    public static final FailReason IM_TTS_IS_PLAYING = null;
    public static final FailReason ON_NOT_DISTURB = null;
    public static final FailReason OTHER_DEVICE_A2DP_OCCUPIED = null;
    public static final FailReason OVERWRITTEN = null;
    public static final FailReason PHONE_SPEAKER = null;
    public static final FailReason PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED = null;
    public static final FailReason PRIORITY_SWITCH_OFF = null;
    public static final FailReason RESPONSE_INVALID = null;
    public static final FailReason SUMMARY_REQUEST_FAIL = null;
    public static final FailReason TIMEOUT = null;
    public static final FailReason UNKNOWN = null;
    public static final FailReason VUI_DISABLED = null;
    public static final FailReason WAKE_MODE_MULTI_ROUND_ON = null;
    public static final FailReason WAKE_MODE_SINGLE_ROUND_ON = null;
    public static final /* synthetic */ FailReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<FailReason> getEntries() {
        return b;
    }

    static {
        FailReason r0 = new FailReason("UNKNOWN", 0, "unknown");
        UNKNOWN = r0;
        FailReason r1 = new FailReason("SUMMARY_REQUEST_FAIL", 1, "summary_request_fail");
        SUMMARY_REQUEST_FAIL = r1;
        FailReason r2 = new FailReason("ON_NOT_DISTURB", 2, "on_not_disturb");
        ON_NOT_DISTURB = r2;
        FailReason r4 = new FailReason("TIMEOUT", 3, "timeout");
        TIMEOUT = r4;
        FailReason r6 = new FailReason("OVERWRITTEN", 4, "overwritten");
        OVERWRITTEN = r6;
        FailReason r8 = new FailReason("RESPONSE_INVALID", 5, "response_invalid");
        RESPONSE_INVALID = r8;
        FailReason r10 = new FailReason("EXPERIMENT_OR_SWITCH_OFF", 6, "experiment_or_switch_off");
        EXPERIMENT_OR_SWITCH_OFF = r10;
        FailReason r12 = new FailReason("AUDIO_CONFLICTS", 7, "audio_conflicts");
        AUDIO_CONFLICTS = r12;
        FailReason r14 = new FailReason("PRIORITY_SWITCH_OFF", 8, "priority_switch_off");
        PRIORITY_SWITCH_OFF = r14;
        FailReason r13 = new FailReason("PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED", 9, "priority_other_device_a2dp_occupied");
        PRIORITY_OTHER_DEVICE_A2DP_OCCUPIED = r13;
        FailReason r11 = new FailReason("PHONE_SPEAKER", 10, "phone_speaker");
        PHONE_SPEAKER = r11;
        FailReason r9 = new FailReason("AUDIO_OUTPUT_NOT_DORA", 11, "audio_output_not_dora");
        AUDIO_OUTPUT_NOT_DORA = r9;
        FailReason r7 = new FailReason("OTHER_DEVICE_A2DP_OCCUPIED", 12, "other_device_a2dp_occupied");
        OTHER_DEVICE_A2DP_OCCUPIED = r7;
        FailReason r5 = new FailReason("DEVICE_UNLOCKED", 13, "device_unlocked");
        DEVICE_UNLOCKED = r5;
        FailReason r3 = new FailReason("HFP_OCCUPIED", 14, "hfp_occupied");
        HFP_OCCUPIED = r3;
        FailReason r15 = new FailReason("VUI_DISABLED", 15, "vui_disabled");
        VUI_DISABLED = r15;
        FailReason r16 = new FailReason("WAKE_MODE_SINGLE_ROUND_ON", 16, "wake_mode_single_round_on");
        WAKE_MODE_SINGLE_ROUND_ON = r16;
        FailReason r17 = new FailReason("WAKE_MODE_MULTI_ROUND_ON", 17, "wake_mode_multi_round_on");
        WAKE_MODE_MULTI_ROUND_ON = r17;
        FailReason r19 = new FailReason("IM_TTS_IS_PLAYING", 18, "im_tts_is_playing");
        IM_TTS_IS_PLAYING = r19;
        FailReason[] r20 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r19};
        a = r20;
        b = EnumEntriesKt.enumEntries(r20);
    }

    public static FailReason[] values() {
        return (FailReason[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static FailReason valueOf(String r1) {
        return (FailReason) r27.a.a(FailReason.class, r1);
    }

    public FailReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
