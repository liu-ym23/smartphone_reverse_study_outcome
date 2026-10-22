package com.larus.audio.record;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/record/AudioRecordType;", "", "<init>", "(Ljava/lang/String;I)V", "AudioRecord", "BackTraceRecord", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AudioRecordType extends Enum<AudioRecordType> {
    public static final AudioRecordType AudioRecord = null;
    public static final AudioRecordType BackTraceRecord = null;
    public static final /* synthetic */ AudioRecordType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AudioRecordType> getEntries() {
        return b;
    }

    static {
        AudioRecordType r0 = new AudioRecordType("AudioRecord", 0);
        AudioRecord = r0;
        AudioRecordType r1 = new AudioRecordType("BackTraceRecord", 1);
        BackTraceRecord = r1;
        AudioRecordType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AudioRecordType[] values() {
        return (AudioRecordType[]) a.clone();
    }

    public static AudioRecordType valueOf(String r1) {
        return (AudioRecordType) a.a(AudioRecordType.class, r1);
    }

    public AudioRecordType(String r1, int r2) {
        super(r1, r2);
    }
}
