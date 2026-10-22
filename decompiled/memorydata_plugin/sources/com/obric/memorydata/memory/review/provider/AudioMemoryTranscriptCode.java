package com.obric.memorydata.memory.review.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptCode;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "EMPTY", "NOT_FOUND", "INVALID_CURSOR", "STALE_CURSOR", "TOO_LARGE", "INTERNAL_ERROR", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AudioMemoryTranscriptCode extends Enum<AudioMemoryTranscriptCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AudioMemoryTranscriptCode[] $VALUES = null;
    public static final AudioMemoryTranscriptCode EMPTY = null;
    public static final AudioMemoryTranscriptCode INTERNAL_ERROR = null;
    public static final AudioMemoryTranscriptCode INVALID_CURSOR = null;
    public static final AudioMemoryTranscriptCode NOT_FOUND = null;
    public static final AudioMemoryTranscriptCode OK = null;
    public static final AudioMemoryTranscriptCode STALE_CURSOR = null;
    public static final AudioMemoryTranscriptCode TOO_LARGE = null;

    private static final /* synthetic */ AudioMemoryTranscriptCode[] $values() {
        return new AudioMemoryTranscriptCode[]{OK, EMPTY, NOT_FOUND, INVALID_CURSOR, STALE_CURSOR, TOO_LARGE, INTERNAL_ERROR};
    }

    static {
        OK = new AudioMemoryTranscriptCode("OK", 0);
        EMPTY = new AudioMemoryTranscriptCode("EMPTY", 1);
        NOT_FOUND = new AudioMemoryTranscriptCode("NOT_FOUND", 2);
        INVALID_CURSOR = new AudioMemoryTranscriptCode("INVALID_CURSOR", 3);
        STALE_CURSOR = new AudioMemoryTranscriptCode("STALE_CURSOR", 4);
        TOO_LARGE = new AudioMemoryTranscriptCode("TOO_LARGE", 5);
        INTERNAL_ERROR = new AudioMemoryTranscriptCode("INTERNAL_ERROR", 6);
        AudioMemoryTranscriptCode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AudioMemoryTranscriptCode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AudioMemoryTranscriptCode> getEntries() {
        return $ENTRIES;
    }

    public static AudioMemoryTranscriptCode valueOf(String r2) {
        return (AudioMemoryTranscriptCode) ZeusTransformUtils.preCheckCast(Enum.valueOf(AudioMemoryTranscriptCode.class, r2), AudioMemoryTranscriptCode.class, "com.obric.memorydata.plugin");
    }

    public static AudioMemoryTranscriptCode[] values() {
        return (AudioMemoryTranscriptCode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AudioMemoryTranscriptCode[].class, "com.obric.memorydata.plugin");
    }
}
