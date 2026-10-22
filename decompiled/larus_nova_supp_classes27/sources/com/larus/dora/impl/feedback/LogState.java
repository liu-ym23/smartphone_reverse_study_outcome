package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/feedback/LogState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ON_BUILDING_P2P_CONNECTION", "P2P_CONNECTION_SUCCESS", "P2P_CONNECTION_FAILED", "ON_FETCHING_LOGS", "LOG_FETCH_SUCCESS", "LOG_FETCH_FAILED", "ON_UPLOADING_LOGS", "LOG_UPLOAD_SUCCESS", "LOG_UPLOAD_FAILED", "READY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogState extends Enum<LogState> {
    public static final LogState IDLE = null;
    public static final LogState LOG_FETCH_FAILED = null;
    public static final LogState LOG_FETCH_SUCCESS = null;
    public static final LogState LOG_UPLOAD_FAILED = null;
    public static final LogState LOG_UPLOAD_SUCCESS = null;
    public static final LogState ON_BUILDING_P2P_CONNECTION = null;
    public static final LogState ON_FETCHING_LOGS = null;
    public static final LogState ON_UPLOADING_LOGS = null;
    public static final LogState P2P_CONNECTION_FAILED = null;
    public static final LogState P2P_CONNECTION_SUCCESS = null;
    public static final LogState READY = null;
    public static final /* synthetic */ LogState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LogState> getEntries() {
        return b;
    }

    static {
        LogState r0 = new LogState("IDLE", 0);
        IDLE = r0;
        LogState r1 = new LogState("ON_BUILDING_P2P_CONNECTION", 1);
        ON_BUILDING_P2P_CONNECTION = r1;
        LogState r3 = new LogState("P2P_CONNECTION_SUCCESS", 2);
        P2P_CONNECTION_SUCCESS = r3;
        LogState r5 = new LogState("P2P_CONNECTION_FAILED", 3);
        P2P_CONNECTION_FAILED = r5;
        LogState r7 = new LogState("ON_FETCHING_LOGS", 4);
        ON_FETCHING_LOGS = r7;
        LogState r9 = new LogState("LOG_FETCH_SUCCESS", 5);
        LOG_FETCH_SUCCESS = r9;
        LogState r11 = new LogState("LOG_FETCH_FAILED", 6);
        LOG_FETCH_FAILED = r11;
        LogState r13 = new LogState("ON_UPLOADING_LOGS", 7);
        ON_UPLOADING_LOGS = r13;
        LogState r15 = new LogState("LOG_UPLOAD_SUCCESS", 8);
        LOG_UPLOAD_SUCCESS = r15;
        LogState r14 = new LogState("LOG_UPLOAD_FAILED", 9);
        LOG_UPLOAD_FAILED = r14;
        LogState r12 = new LogState("READY", 10);
        READY = r12;
        LogState[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static LogState[] values() {
        return (LogState[]) a.clone();
    }

    public static LogState valueOf(String r1) {
        return (LogState) r27.a.a(LogState.class, r1);
    }

    public LogState(String r1, int r2) {
        super(r1, r2);
    }
}
