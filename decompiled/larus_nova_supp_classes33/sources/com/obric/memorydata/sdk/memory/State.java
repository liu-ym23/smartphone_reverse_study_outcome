package com.obric.memorydata.sdk.memory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/memory/State;", "", "<init>", "(Ljava/lang/String;I)V", "BEGIN", "SUCCESS_NEW", "SUCCESS_UPDATE", "FAILURE_ERROR", "TIMEOUT", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum State extends Enum<State> {
    public static final State BEGIN = null;
    public static final a Companion = null;
    public static final State FAILURE_ERROR = null;
    public static final State SUCCESS_NEW = null;
    public static final State SUCCESS_UPDATE = null;
    public static final State TIMEOUT = null;
    public static final /* synthetic */ State[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<State> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.sdk.memory.State$a] */
    static {
        State r0 = new State("BEGIN", 0);
        BEGIN = r0;
        State r1 = new State("SUCCESS_NEW", 1);
        SUCCESS_NEW = r1;
        State r3 = new State("SUCCESS_UPDATE", 2);
        SUCCESS_UPDATE = r3;
        State r5 = new State("FAILURE_ERROR", 3);
        FAILURE_ERROR = r5;
        State r7 = new State("TIMEOUT", 4);
        TIMEOUT = r7;
        State[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static State[] values() {
        return (State[]) a.clone();
    }

    public static State valueOf(String r1) {
        return (State) r27.a.a(State.class, r1);
    }

    public State(String r1, int r2) {
        super(r1, r2);
    }
}
