package com.obric.assistant.live.oenum;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/live/oenum/MicMuteState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "UNMUTE", "MUTE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MicMuteState extends Enum<MicMuteState> {
    public static final MicMuteState MUTE = null;
    public static final MicMuteState NA = null;
    public static final MicMuteState UNMUTE = null;
    public static final /* synthetic */ MicMuteState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MicMuteState> getEntries() {
        return b;
    }

    static {
        MicMuteState r0 = new MicMuteState("NA", 0);
        NA = r0;
        MicMuteState r1 = new MicMuteState("UNMUTE", 1);
        UNMUTE = r1;
        MicMuteState r3 = new MicMuteState("MUTE", 2);
        MUTE = r3;
        MicMuteState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MicMuteState[] values() {
        return (MicMuteState[]) a.clone();
    }

    public static MicMuteState valueOf(String r1) {
        return (MicMuteState) a.a(MicMuteState.class, r1);
    }

    public MicMuteState(String r1, int r2) {
        super(r1, r2);
    }
}
