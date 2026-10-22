package com.obric.audio.enroll.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/audio/enroll/model/TeamEnrollState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_START", "BORN", "ENROLLING", "OVERSIZE", "CHECKING_SIMILARITY", "SIMILARITY_FAIL", "SIMILARITY_PASS", "CHECKING_ENROLL", "ENROLL_MATCHED", "ENROLL_NOT_MATCHED_COMMON_ERROR", "ENROLL_NOT_MATCHED_NETWORK_ERROR", "TIMEOUT", "DONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TeamEnrollState extends Enum<TeamEnrollState> {
    public static final TeamEnrollState BORN = null;
    public static final TeamEnrollState CHECKING_ENROLL = null;
    public static final TeamEnrollState CHECKING_SIMILARITY = null;
    public static final TeamEnrollState DONE = null;
    public static final TeamEnrollState ENROLLING = null;
    public static final TeamEnrollState ENROLL_MATCHED = null;
    public static final TeamEnrollState ENROLL_NOT_MATCHED_COMMON_ERROR = null;
    public static final TeamEnrollState ENROLL_NOT_MATCHED_NETWORK_ERROR = null;
    public static final TeamEnrollState NOT_START = null;
    public static final TeamEnrollState OVERSIZE = null;
    public static final TeamEnrollState SIMILARITY_FAIL = null;
    public static final TeamEnrollState SIMILARITY_PASS = null;
    public static final TeamEnrollState TIMEOUT = null;
    public static final /* synthetic */ TeamEnrollState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TeamEnrollState> getEntries() {
        return b;
    }

    static {
        TeamEnrollState r0 = new TeamEnrollState("NOT_START", 0);
        NOT_START = r0;
        TeamEnrollState r1 = new TeamEnrollState("BORN", 1);
        BORN = r1;
        TeamEnrollState r3 = new TeamEnrollState("ENROLLING", 2);
        ENROLLING = r3;
        TeamEnrollState r5 = new TeamEnrollState("OVERSIZE", 3);
        OVERSIZE = r5;
        TeamEnrollState r7 = new TeamEnrollState("CHECKING_SIMILARITY", 4);
        CHECKING_SIMILARITY = r7;
        TeamEnrollState r9 = new TeamEnrollState("SIMILARITY_FAIL", 5);
        SIMILARITY_FAIL = r9;
        TeamEnrollState r11 = new TeamEnrollState("SIMILARITY_PASS", 6);
        SIMILARITY_PASS = r11;
        TeamEnrollState r13 = new TeamEnrollState("CHECKING_ENROLL", 7);
        CHECKING_ENROLL = r13;
        TeamEnrollState r15 = new TeamEnrollState("ENROLL_MATCHED", 8);
        ENROLL_MATCHED = r15;
        TeamEnrollState r14 = new TeamEnrollState("ENROLL_NOT_MATCHED_COMMON_ERROR", 9);
        ENROLL_NOT_MATCHED_COMMON_ERROR = r14;
        TeamEnrollState r12 = new TeamEnrollState("ENROLL_NOT_MATCHED_NETWORK_ERROR", 10);
        ENROLL_NOT_MATCHED_NETWORK_ERROR = r12;
        TeamEnrollState r10 = new TeamEnrollState("TIMEOUT", 11);
        TIMEOUT = r10;
        TeamEnrollState r8 = new TeamEnrollState("DONE", 12);
        DONE = r8;
        TeamEnrollState[] r6 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static TeamEnrollState[] values() {
        return (TeamEnrollState[]) a.clone();
    }

    public static TeamEnrollState valueOf(String r1) {
        return (TeamEnrollState) a.a(TeamEnrollState.class, r1);
    }

    public TeamEnrollState(String r1, int r2) {
        super(r1, r2);
    }
}
