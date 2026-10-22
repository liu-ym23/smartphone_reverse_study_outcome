package com.larus.audio.audiov3.audio.player;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/audio/audiov3/audio/player/AudioPlayerErrorEnum;", "", "code", "", "massage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMassage", "()Ljava/lang/String;", "START_ERROR", "RELEASE_ERROR", "CONFIG_ERROR", "WRITE_ERROR", "INIT_ERROR", "UNKNOWN_ERROR", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AudioPlayerErrorEnum extends Enum<AudioPlayerErrorEnum> {
    public static final AudioPlayerErrorEnum CONFIG_ERROR = null;
    public static final AudioPlayerErrorEnum INIT_ERROR = null;
    public static final AudioPlayerErrorEnum RELEASE_ERROR = null;
    public static final AudioPlayerErrorEnum START_ERROR = null;
    public static final AudioPlayerErrorEnum UNKNOWN_ERROR = null;
    public static final AudioPlayerErrorEnum WRITE_ERROR = null;
    public static final /* synthetic */ AudioPlayerErrorEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;
    private final String massage;

    public static EnumEntries<AudioPlayerErrorEnum> getEntries() {
        return b;
    }

    static {
        AudioPlayerErrorEnum r0 = new AudioPlayerErrorEnum("START_ERROR", 0, 501, "audio player start error");
        START_ERROR = r0;
        AudioPlayerErrorEnum r1 = new AudioPlayerErrorEnum("RELEASE_ERROR", 1, 502, "audio player release error");
        RELEASE_ERROR = r1;
        AudioPlayerErrorEnum r2 = new AudioPlayerErrorEnum("CONFIG_ERROR", 2, 503, "audio player config error");
        CONFIG_ERROR = r2;
        AudioPlayerErrorEnum r3 = new AudioPlayerErrorEnum("WRITE_ERROR", 3, 504, "audio player write error");
        WRITE_ERROR = r3;
        AudioPlayerErrorEnum r5 = new AudioPlayerErrorEnum("INIT_ERROR", 4, 505, "audio player init error");
        INIT_ERROR = r5;
        AudioPlayerErrorEnum r7 = new AudioPlayerErrorEnum("UNKNOWN_ERROR", 5, 10000, "audio player unknown error");
        UNKNOWN_ERROR = r7;
        AudioPlayerErrorEnum[] r9 = {r0, r1, r2, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static AudioPlayerErrorEnum[] values() {
        return (AudioPlayerErrorEnum[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMassage() {
        return this.massage;
    }

    public static AudioPlayerErrorEnum valueOf(String r1) {
        return (AudioPlayerErrorEnum) a.a(AudioPlayerErrorEnum.class, r1);
    }

    public AudioPlayerErrorEnum(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.code = r3;
        this.massage = r4;
    }
}
