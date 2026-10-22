package com.obric.memorydata.recommend.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryItemType;", "", "<init>", "(Ljava/lang/String;I)V", "MEMORY_CATEGORY", "MEMORY_ENTITY", "PORTRAIT_ENTITY", "TODO_ENTITY", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryItemType extends Enum<MemoryItemType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryItemType[] $VALUES = null;
    public static final MemoryItemType MEMORY_CATEGORY = null;
    public static final MemoryItemType MEMORY_ENTITY = null;
    public static final MemoryItemType PORTRAIT_ENTITY = null;
    public static final MemoryItemType TODO_ENTITY = null;

    private static final /* synthetic */ MemoryItemType[] $values() {
        return new MemoryItemType[]{MEMORY_CATEGORY, MEMORY_ENTITY, PORTRAIT_ENTITY, TODO_ENTITY};
    }

    static {
        MEMORY_CATEGORY = new MemoryItemType("MEMORY_CATEGORY", 0);
        MEMORY_ENTITY = new MemoryItemType("MEMORY_ENTITY", 1);
        PORTRAIT_ENTITY = new MemoryItemType("PORTRAIT_ENTITY", 2);
        TODO_ENTITY = new MemoryItemType("TODO_ENTITY", 3);
        MemoryItemType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemoryItemType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemoryItemType> getEntries() {
        return $ENTRIES;
    }

    public static MemoryItemType valueOf(String r2) {
        return (MemoryItemType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryItemType.class, r2), MemoryItemType.class, "com.obric.memorydata.plugin");
    }

    public static MemoryItemType[] values() {
        return (MemoryItemType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryItemType[].class, "com.obric.memorydata.plugin");
    }
}
