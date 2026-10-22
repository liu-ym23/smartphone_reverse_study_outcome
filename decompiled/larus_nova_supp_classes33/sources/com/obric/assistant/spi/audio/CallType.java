package com.obric.assistant.spi.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/spi/audio/CallType;", "", "<init>", "(Ljava/lang/String;I)V", "Audio", "Video", "ScreenShare", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallType extends Enum<CallType> {
    public static final CallType Audio = null;
    public static final CallType ScreenShare = null;
    public static final CallType Video = null;
    public static final /* synthetic */ CallType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CallType> getEntries() {
        return b;
    }

    static {
        CallType r0 = new CallType("Audio", 0);
        Audio = r0;
        CallType r1 = new CallType("Video", 1);
        Video = r1;
        CallType r3 = new CallType("ScreenShare", 2);
        ScreenShare = r3;
        CallType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CallType[] values() {
        return (CallType[]) a.clone();
    }

    public static CallType valueOf(String r1) {
        return (CallType) r27.a.a(CallType.class, r1);
    }

    public CallType(String r1, int r2) {
        super(r1, r2);
    }
}
