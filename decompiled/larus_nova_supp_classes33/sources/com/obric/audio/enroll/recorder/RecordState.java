package com.obric.audio.enroll.recorder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/audio/enroll/recorder/RecordState;", "", "<init>", "(Ljava/lang/String;I)V", "STOP", "START", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordState extends Enum<RecordState> {
    public static final RecordState START = null;
    public static final RecordState STOP = null;
    public static final /* synthetic */ RecordState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RecordState> getEntries() {
        return b;
    }

    static {
        RecordState r0 = new RecordState("STOP", 0);
        STOP = r0;
        RecordState r1 = new RecordState("START", 1);
        START = r1;
        RecordState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RecordState[] values() {
        return (RecordState[]) a.clone();
    }

    public static RecordState valueOf(String r1) {
        return (RecordState) r27.a.a(RecordState.class, r1);
    }

    public RecordState(String r1, int r2) {
        super(r1, r2);
    }
}
