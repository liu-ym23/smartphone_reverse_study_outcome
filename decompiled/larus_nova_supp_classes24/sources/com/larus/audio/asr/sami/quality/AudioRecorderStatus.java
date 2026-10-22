package com.larus.audio.asr.sami.quality;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/asr/sami/quality/AudioRecorderStatus;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_IDLE", "STATE_RECORDING", "STATE_CANCEL", "STATE_STOP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AudioRecorderStatus extends Enum<AudioRecorderStatus> {
    public static final AudioRecorderStatus STATE_CANCEL = null;
    public static final AudioRecorderStatus STATE_IDLE = null;
    public static final AudioRecorderStatus STATE_RECORDING = null;
    public static final AudioRecorderStatus STATE_STOP = null;
    public static final /* synthetic */ AudioRecorderStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AudioRecorderStatus> getEntries() {
        return b;
    }

    static {
        AudioRecorderStatus r0 = new AudioRecorderStatus("STATE_IDLE", 0);
        STATE_IDLE = r0;
        AudioRecorderStatus r1 = new AudioRecorderStatus("STATE_RECORDING", 1);
        STATE_RECORDING = r1;
        AudioRecorderStatus r3 = new AudioRecorderStatus("STATE_CANCEL", 2);
        STATE_CANCEL = r3;
        AudioRecorderStatus r5 = new AudioRecorderStatus("STATE_STOP", 3);
        STATE_STOP = r5;
        AudioRecorderStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static AudioRecorderStatus[] values() {
        return (AudioRecorderStatus[]) a.clone();
    }

    public static AudioRecorderStatus valueOf(String r1) {
        return (AudioRecorderStatus) a.a(AudioRecorderStatus.class, r1);
    }

    public AudioRecorderStatus(String r1, int r2) {
        super(r1, r2);
    }
}
