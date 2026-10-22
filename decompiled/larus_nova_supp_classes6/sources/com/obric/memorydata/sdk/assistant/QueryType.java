package com.obric.memorydata.sdk.assistant;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/assistant/QueryType;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "AUDIO", "IM", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum QueryType extends Enum<QueryType> {
    public static final QueryType AUDIO = null;
    public static final a Companion = null;
    public static final QueryType IM = null;
    public static final QueryType NA = null;
    public static final /* synthetic */ QueryType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<QueryType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.memorydata.sdk.assistant.QueryType$a] */
    static {
        QueryType r0 = new QueryType("NA", 0);
        NA = r0;
        QueryType r1 = new QueryType("AUDIO", 1);
        AUDIO = r1;
        QueryType r3 = new QueryType("IM", 2);
        IM = r3;
        QueryType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static QueryType[] values() {
        return (QueryType[]) a.clone();
    }

    public static QueryType valueOf(String r1) {
        return (QueryType) r27.a.a(QueryType.class, r1);
    }

    public QueryType(String r1, int r2) {
        super(r1, r2);
    }
}
