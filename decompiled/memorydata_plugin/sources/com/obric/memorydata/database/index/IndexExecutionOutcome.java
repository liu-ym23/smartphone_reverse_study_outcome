package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/index/IndexExecutionOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "TERMINAL_SUCCESS", "TERMINAL_FAILURE", "NON_TERMINAL_RETRY", "THERMAL_DEFERRED", "LOCATION_DEFERRED", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum IndexExecutionOutcome extends Enum<IndexExecutionOutcome> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IndexExecutionOutcome[] $VALUES = null;
    public static final IndexExecutionOutcome LOCATION_DEFERRED = null;
    public static final IndexExecutionOutcome NON_TERMINAL_RETRY = null;
    public static final IndexExecutionOutcome TERMINAL_FAILURE = null;
    public static final IndexExecutionOutcome TERMINAL_SUCCESS = null;
    public static final IndexExecutionOutcome THERMAL_DEFERRED = null;

    private static final /* synthetic */ IndexExecutionOutcome[] $values() {
        return new IndexExecutionOutcome[]{TERMINAL_SUCCESS, TERMINAL_FAILURE, NON_TERMINAL_RETRY, THERMAL_DEFERRED, LOCATION_DEFERRED};
    }

    static {
        TERMINAL_SUCCESS = new IndexExecutionOutcome("TERMINAL_SUCCESS", 0);
        TERMINAL_FAILURE = new IndexExecutionOutcome("TERMINAL_FAILURE", 1);
        NON_TERMINAL_RETRY = new IndexExecutionOutcome("NON_TERMINAL_RETRY", 2);
        THERMAL_DEFERRED = new IndexExecutionOutcome("THERMAL_DEFERRED", 3);
        LOCATION_DEFERRED = new IndexExecutionOutcome("LOCATION_DEFERRED", 4);
        IndexExecutionOutcome[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private IndexExecutionOutcome(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<IndexExecutionOutcome> getEntries() {
        return $ENTRIES;
    }

    public static IndexExecutionOutcome valueOf(String r2) {
        return (IndexExecutionOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(IndexExecutionOutcome.class, r2), IndexExecutionOutcome.class, "com.obric.memorydata.plugin");
    }

    public static IndexExecutionOutcome[] values() {
        return (IndexExecutionOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IndexExecutionOutcome[].class, "com.obric.memorydata.plugin");
    }
}
