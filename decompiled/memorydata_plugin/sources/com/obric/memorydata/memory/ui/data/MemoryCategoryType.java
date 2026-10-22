package com.obric.memorydata.memory.ui.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryCategoryType;", "", "<init>", "(Ljava/lang/String;I)V", "MEMORY_TIME", "MEMORY_RELATION_TEXT", "MEMORY_LIST_ENTITY", "MEMORY_DETAIL_ENTITY", "MEMORY_OBSERVATION", "MEMORY_AUDIO", "MEMORY_AUTO_MEMORY_PRO", "MEMORY_FOOTER", "MEMORY_CALENDAR", "MEMORY_EPISODIC_TOPIC", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryCategoryType extends Enum<MemoryCategoryType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryCategoryType[] $VALUES = null;
    public static final MemoryCategoryType MEMORY_AUDIO = null;
    public static final MemoryCategoryType MEMORY_AUTO_MEMORY_PRO = null;
    public static final MemoryCategoryType MEMORY_CALENDAR = null;
    public static final MemoryCategoryType MEMORY_DETAIL_ENTITY = null;
    public static final MemoryCategoryType MEMORY_EPISODIC_TOPIC = null;
    public static final MemoryCategoryType MEMORY_FOOTER = null;
    public static final MemoryCategoryType MEMORY_LIST_ENTITY = null;
    public static final MemoryCategoryType MEMORY_OBSERVATION = null;
    public static final MemoryCategoryType MEMORY_RELATION_TEXT = null;
    public static final MemoryCategoryType MEMORY_TIME = null;

    private static final /* synthetic */ MemoryCategoryType[] $values() {
        return new MemoryCategoryType[]{MEMORY_TIME, MEMORY_RELATION_TEXT, MEMORY_LIST_ENTITY, MEMORY_DETAIL_ENTITY, MEMORY_OBSERVATION, MEMORY_AUDIO, MEMORY_AUTO_MEMORY_PRO, MEMORY_FOOTER, MEMORY_CALENDAR, MEMORY_EPISODIC_TOPIC};
    }

    static {
        MEMORY_TIME = new MemoryCategoryType("MEMORY_TIME", 0);
        MEMORY_RELATION_TEXT = new MemoryCategoryType("MEMORY_RELATION_TEXT", 1);
        MEMORY_LIST_ENTITY = new MemoryCategoryType("MEMORY_LIST_ENTITY", 2);
        MEMORY_DETAIL_ENTITY = new MemoryCategoryType("MEMORY_DETAIL_ENTITY", 3);
        MEMORY_OBSERVATION = new MemoryCategoryType("MEMORY_OBSERVATION", 4);
        MEMORY_AUDIO = new MemoryCategoryType("MEMORY_AUDIO", 5);
        MEMORY_AUTO_MEMORY_PRO = new MemoryCategoryType("MEMORY_AUTO_MEMORY_PRO", 6);
        MEMORY_FOOTER = new MemoryCategoryType("MEMORY_FOOTER", 7);
        MEMORY_CALENDAR = new MemoryCategoryType("MEMORY_CALENDAR", 8);
        MEMORY_EPISODIC_TOPIC = new MemoryCategoryType("MEMORY_EPISODIC_TOPIC", 9);
        MemoryCategoryType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemoryCategoryType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemoryCategoryType> getEntries() {
        return $ENTRIES;
    }

    public static MemoryCategoryType valueOf(String r2) {
        return (MemoryCategoryType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryCategoryType.class, r2), MemoryCategoryType.class, "com.obric.memorydata.plugin");
    }

    public static MemoryCategoryType[] values() {
        return (MemoryCategoryType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryCategoryType[].class, "com.obric.memorydata.plugin");
    }
}
