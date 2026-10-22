package com.obric.audio.enroll.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/audio/enroll/model/TeamState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "CANDIDATE", "ONSTAGE", "DONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamState extends Enum<TeamState> {
    public static final TeamState CANDIDATE = null;
    public static final TeamState DONE = null;
    public static final TeamState NA = null;
    public static final TeamState ONSTAGE = null;
    public static final /* synthetic */ TeamState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TeamState> getEntries() {
        return b;
    }

    static {
        TeamState r0 = new TeamState("NA", 0);
        NA = r0;
        TeamState r1 = new TeamState("CANDIDATE", 1);
        CANDIDATE = r1;
        TeamState r3 = new TeamState("ONSTAGE", 2);
        ONSTAGE = r3;
        TeamState r5 = new TeamState("DONE", 3);
        DONE = r5;
        TeamState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static TeamState[] values() {
        return (TeamState[]) a.clone();
    }

    public static TeamState valueOf(String r1) {
        return (TeamState) a.a(TeamState.class, r1);
    }

    public TeamState(String r1, int r2) {
        super(r1, r2);
    }
}
