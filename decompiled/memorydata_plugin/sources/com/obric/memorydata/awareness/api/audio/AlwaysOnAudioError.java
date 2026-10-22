package com.obric.memorydata.awareness.api.audio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioError;", "", "<init>", "(Ljava/lang/String;I)V", "PLATFORM_UNAVAILABLE", "AUDIO_NOT_READY_OR_EMPTY", "PERMISSION_DENIED", "INVALID_TIME_WINDOW", "MALFORMED_RESPONSE", "PLATFORM_CALL_FAILED", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AlwaysOnAudioError extends Enum<AlwaysOnAudioError> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AlwaysOnAudioError[] $VALUES = null;
    public static final AlwaysOnAudioError AUDIO_NOT_READY_OR_EMPTY = null;
    public static final AlwaysOnAudioError INVALID_TIME_WINDOW = null;
    public static final AlwaysOnAudioError MALFORMED_RESPONSE = null;
    public static final AlwaysOnAudioError PERMISSION_DENIED = null;
    public static final AlwaysOnAudioError PLATFORM_CALL_FAILED = null;
    public static final AlwaysOnAudioError PLATFORM_UNAVAILABLE = null;

    private static final /* synthetic */ AlwaysOnAudioError[] $values() {
        return new AlwaysOnAudioError[]{PLATFORM_UNAVAILABLE, AUDIO_NOT_READY_OR_EMPTY, PERMISSION_DENIED, INVALID_TIME_WINDOW, MALFORMED_RESPONSE, PLATFORM_CALL_FAILED};
    }

    static {
        PLATFORM_UNAVAILABLE = new AlwaysOnAudioError("PLATFORM_UNAVAILABLE", 0);
        AUDIO_NOT_READY_OR_EMPTY = new AlwaysOnAudioError("AUDIO_NOT_READY_OR_EMPTY", 1);
        PERMISSION_DENIED = new AlwaysOnAudioError("PERMISSION_DENIED", 2);
        INVALID_TIME_WINDOW = new AlwaysOnAudioError("INVALID_TIME_WINDOW", 3);
        MALFORMED_RESPONSE = new AlwaysOnAudioError("MALFORMED_RESPONSE", 4);
        PLATFORM_CALL_FAILED = new AlwaysOnAudioError("PLATFORM_CALL_FAILED", 5);
        AlwaysOnAudioError[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AlwaysOnAudioError(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AlwaysOnAudioError> getEntries() {
        return $ENTRIES;
    }

    public static AlwaysOnAudioError valueOf(String r2) {
        return (AlwaysOnAudioError) ZeusTransformUtils.preCheckCast(Enum.valueOf(AlwaysOnAudioError.class, r2), AlwaysOnAudioError.class, "com.obric.memorydata.plugin");
    }

    public static AlwaysOnAudioError[] values() {
        return (AlwaysOnAudioError[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AlwaysOnAudioError[].class, "com.obric.memorydata.plugin");
    }
}
