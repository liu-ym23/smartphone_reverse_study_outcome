package com.obric.memorydata.task.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerTaskType;", "", "<init>", "(Ljava/lang/String;I)V", "FAST", "SLOW", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum IndexPowerTaskType extends Enum<IndexPowerTaskType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IndexPowerTaskType[] $VALUES = null;
    public static final IndexPowerTaskType FAST = null;
    public static final IndexPowerTaskType SLOW = null;

    private static final /* synthetic */ IndexPowerTaskType[] $values() {
        return new IndexPowerTaskType[]{FAST, SLOW};
    }

    static {
        FAST = new IndexPowerTaskType("FAST", 0);
        SLOW = new IndexPowerTaskType("SLOW", 1);
        IndexPowerTaskType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private IndexPowerTaskType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<IndexPowerTaskType> getEntries() {
        return $ENTRIES;
    }

    public static IndexPowerTaskType valueOf(String r2) {
        return (IndexPowerTaskType) ZeusTransformUtils.preCheckCast(Enum.valueOf(IndexPowerTaskType.class, r2), IndexPowerTaskType.class, "com.obric.memorydata.plugin");
    }

    public static IndexPowerTaskType[] values() {
        return (IndexPowerTaskType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IndexPowerTaskType[].class, "com.obric.memorydata.plugin");
    }
}
