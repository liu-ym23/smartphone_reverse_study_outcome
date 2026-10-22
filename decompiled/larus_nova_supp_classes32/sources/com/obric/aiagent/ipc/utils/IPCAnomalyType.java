package com.obric.aiagent.ipc.utils;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/ipc/utils/IPCAnomalyType;", NameKeys.UnloadStrategy_No_Strategy, "eventValue", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventValue", "()Ljava/lang/String;", "FAILURE", "SLOW", "FREQUENT", "ipc-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IPCAnomalyType extends Enum<IPCAnomalyType> {
    public static final IPCAnomalyType FAILURE = null;
    public static final IPCAnomalyType FREQUENT = null;
    public static final IPCAnomalyType SLOW = null;
    public static final /* synthetic */ IPCAnomalyType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String eventValue;

    public static EnumEntries<IPCAnomalyType> getEntries() {
        return b;
    }

    static {
        IPCAnomalyType r0 = new IPCAnomalyType("FAILURE", 0, "failure");
        FAILURE = r0;
        IPCAnomalyType r1 = new IPCAnomalyType("SLOW", 1, "slow");
        SLOW = r1;
        IPCAnomalyType r2 = new IPCAnomalyType("FREQUENT", 2, "frequent");
        FREQUENT = r2;
        IPCAnomalyType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static IPCAnomalyType[] values() {
        return (IPCAnomalyType[]) a.clone();
    }

    public final String getEventValue() {
        return this.eventValue;
    }

    public static IPCAnomalyType valueOf(String r1) {
        return (IPCAnomalyType) a.a(IPCAnomalyType.class, r1);
    }

    public IPCAnomalyType(String r1, int r2, String r3) {
        super(r1, r2);
        this.eventValue = r3;
    }
}
