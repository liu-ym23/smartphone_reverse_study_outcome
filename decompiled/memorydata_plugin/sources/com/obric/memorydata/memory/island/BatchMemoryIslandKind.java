package com.obric.memorydata.memory.island;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/island/BatchMemoryIslandKind;", "", "<init>", "(Ljava/lang/String;I)V", "EPISODIC", "SEMANTIC", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BatchMemoryIslandKind extends Enum<BatchMemoryIslandKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BatchMemoryIslandKind[] $VALUES = null;
    public static final BatchMemoryIslandKind EPISODIC = null;
    public static final BatchMemoryIslandKind SEMANTIC = null;

    private static final /* synthetic */ BatchMemoryIslandKind[] $values() {
        return new BatchMemoryIslandKind[]{EPISODIC, SEMANTIC};
    }

    static {
        EPISODIC = new BatchMemoryIslandKind("EPISODIC", 0);
        SEMANTIC = new BatchMemoryIslandKind("SEMANTIC", 1);
        BatchMemoryIslandKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private BatchMemoryIslandKind(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<BatchMemoryIslandKind> getEntries() {
        return $ENTRIES;
    }

    public static BatchMemoryIslandKind valueOf(String r2) {
        return (BatchMemoryIslandKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(BatchMemoryIslandKind.class, r2), BatchMemoryIslandKind.class, "com.obric.memorydata.plugin");
    }

    public static BatchMemoryIslandKind[] values() {
        return (BatchMemoryIslandKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BatchMemoryIslandKind[].class, "com.obric.memorydata.plugin");
    }
}
