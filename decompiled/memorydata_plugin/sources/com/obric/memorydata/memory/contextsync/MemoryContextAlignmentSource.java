package com.obric.memorydata.memory.contextsync;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextAlignmentSource;", "", "<init>", "(Ljava/lang/String;I)V", "STARTUP", "PROVIDER_CHANGED", "SEMANTIC_CHANGED", "SCREEN_ON_RECOVERY", "MIGRATION_RESTORED", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryContextAlignmentSource extends Enum<MemoryContextAlignmentSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryContextAlignmentSource[] $VALUES = null;
    public static final MemoryContextAlignmentSource MIGRATION_RESTORED = null;
    public static final MemoryContextAlignmentSource PROVIDER_CHANGED = null;
    public static final MemoryContextAlignmentSource SCREEN_ON_RECOVERY = null;
    public static final MemoryContextAlignmentSource SEMANTIC_CHANGED = null;
    public static final MemoryContextAlignmentSource STARTUP = null;

    private static final /* synthetic */ MemoryContextAlignmentSource[] $values() {
        return new MemoryContextAlignmentSource[]{STARTUP, PROVIDER_CHANGED, SEMANTIC_CHANGED, SCREEN_ON_RECOVERY, MIGRATION_RESTORED};
    }

    static {
        STARTUP = new MemoryContextAlignmentSource("STARTUP", 0);
        PROVIDER_CHANGED = new MemoryContextAlignmentSource("PROVIDER_CHANGED", 1);
        SEMANTIC_CHANGED = new MemoryContextAlignmentSource("SEMANTIC_CHANGED", 2);
        SCREEN_ON_RECOVERY = new MemoryContextAlignmentSource("SCREEN_ON_RECOVERY", 3);
        MIGRATION_RESTORED = new MemoryContextAlignmentSource("MIGRATION_RESTORED", 4);
        MemoryContextAlignmentSource[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemoryContextAlignmentSource(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemoryContextAlignmentSource> getEntries() {
        return $ENTRIES;
    }

    public static MemoryContextAlignmentSource valueOf(String r2) {
        return (MemoryContextAlignmentSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryContextAlignmentSource.class, r2), MemoryContextAlignmentSource.class, "com.obric.memorydata.plugin");
    }

    public static MemoryContextAlignmentSource[] values() {
        return (MemoryContextAlignmentSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryContextAlignmentSource[].class, "com.obric.memorydata.plugin");
    }
}
