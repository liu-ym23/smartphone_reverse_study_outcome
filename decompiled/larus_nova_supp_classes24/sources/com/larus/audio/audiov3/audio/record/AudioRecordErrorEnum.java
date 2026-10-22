package com.larus.audio.audiov3.audio.record;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/audio/audiov3/audio/record/AudioRecordErrorEnum;", "", "code", "", "massage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMassage", "()Ljava/lang/String;", "PREPARE_ERROR", "START_ERROR", "RELEASE_ERROR", "UNKNOWN_ERROR", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AudioRecordErrorEnum extends Enum<AudioRecordErrorEnum> {
    public static final AudioRecordErrorEnum PREPARE_ERROR = null;
    public static final AudioRecordErrorEnum RELEASE_ERROR = null;
    public static final AudioRecordErrorEnum START_ERROR = null;
    public static final AudioRecordErrorEnum UNKNOWN_ERROR = null;
    public static final /* synthetic */ AudioRecordErrorEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;
    private final String massage;

    public static EnumEntries<AudioRecordErrorEnum> getEntries() {
        return b;
    }

    static {
        AudioRecordErrorEnum r0 = new AudioRecordErrorEnum("PREPARE_ERROR", 0, 500, "AudioRecord prepare error");
        PREPARE_ERROR = r0;
        AudioRecordErrorEnum r1 = new AudioRecordErrorEnum("START_ERROR", 1, 501, "AudioRecord start error");
        START_ERROR = r1;
        AudioRecordErrorEnum r2 = new AudioRecordErrorEnum("RELEASE_ERROR", 2, 502, "AudioRecord release error");
        RELEASE_ERROR = r2;
        AudioRecordErrorEnum r3 = new AudioRecordErrorEnum("UNKNOWN_ERROR", 3, 10000, "AudioRecord unknown error");
        UNKNOWN_ERROR = r3;
        AudioRecordErrorEnum[] r5 = {r0, r1, r2, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AudioRecordErrorEnum[] values() {
        return (AudioRecordErrorEnum[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMassage() {
        return this.massage;
    }

    public static AudioRecordErrorEnum valueOf(String r1) {
        return (AudioRecordErrorEnum) a.a(AudioRecordErrorEnum.class, r1);
    }

    public AudioRecordErrorEnum(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.massage = r4;
    }
}
