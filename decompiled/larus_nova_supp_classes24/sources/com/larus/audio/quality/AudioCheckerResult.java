package com.larus.audio.quality;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/quality/AudioCheckerResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "INTERNAL_ERROR", "NETWORK_ERROR", "PASSED", "SNR_FAILED", "WER_FAILED", "INIT_CONFIG_ERROR", "INIT_METRIC_ERROR", "AUDIO_RECORD_SILENCED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AudioCheckerResult extends Enum<AudioCheckerResult> {
    public static final AudioCheckerResult AUDIO_RECORD_SILENCED = null;
    public static final AudioCheckerResult INIT_CONFIG_ERROR = null;
    public static final AudioCheckerResult INIT_METRIC_ERROR = null;
    public static final AudioCheckerResult INTERNAL_ERROR = null;
    public static final AudioCheckerResult NETWORK_ERROR = null;
    public static final AudioCheckerResult PASSED = null;
    public static final AudioCheckerResult SNR_FAILED = null;
    public static final AudioCheckerResult WER_FAILED = null;
    public static final /* synthetic */ AudioCheckerResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AudioCheckerResult> getEntries() {
        return b;
    }

    static {
        AudioCheckerResult r0 = new AudioCheckerResult("INTERNAL_ERROR", 0);
        INTERNAL_ERROR = r0;
        AudioCheckerResult r1 = new AudioCheckerResult("NETWORK_ERROR", 1);
        NETWORK_ERROR = r1;
        AudioCheckerResult r3 = new AudioCheckerResult("PASSED", 2);
        PASSED = r3;
        AudioCheckerResult r5 = new AudioCheckerResult("SNR_FAILED", 3);
        SNR_FAILED = r5;
        AudioCheckerResult r7 = new AudioCheckerResult("WER_FAILED", 4);
        WER_FAILED = r7;
        AudioCheckerResult r9 = new AudioCheckerResult("INIT_CONFIG_ERROR", 5);
        INIT_CONFIG_ERROR = r9;
        AudioCheckerResult r11 = new AudioCheckerResult("INIT_METRIC_ERROR", 6);
        INIT_METRIC_ERROR = r11;
        AudioCheckerResult r13 = new AudioCheckerResult("AUDIO_RECORD_SILENCED", 7);
        AUDIO_RECORD_SILENCED = r13;
        AudioCheckerResult[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static AudioCheckerResult[] values() {
        return (AudioCheckerResult[]) a.clone();
    }

    public static AudioCheckerResult valueOf(String r1) {
        return (AudioCheckerResult) a.a(AudioCheckerResult.class, r1);
    }

    public AudioCheckerResult(String r1, int r2) {
        super(r1, r2);
    }
}
