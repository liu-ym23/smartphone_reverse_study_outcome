package com.obric.memorydata.memory.ui.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b,\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/ui/data/MemoryItemType;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_TIME", "TYPE_RELATION_TITLE", "TYPE_MEMORY_FOOTER", "TYPE_SHORT_ENTITY", "TYPE_AUDIO_ENTITY", "TYPE_AUTO_MEMORY_PRO", "TYPE_LIST_COLLECT_CONTENT", "TYPE_LIST_COLLECT_STORE", "TYPE_LIST_COMMON_TEXT", "TYPE_LIST_EVENT_SCHEDULE", "TYPE_LIST_EVENT_TODO", "TYPE_LIST_INFO_ADDRESS", "TYPE_LIST_INFO_ANNIVERSARY", "TYPE_LIST_INFO_COMMON", "TYPE_LIST_INFO_DOCUMENTS", "TYPE_LIST_INFO_RELATION", "TYPE_LIST_ORDER_COMMON", "TYPE_LIST_ORDER_FLIGHT", "TYPE_LIST_ORDER_HOTEL", "TYPE_LIST_ORDER_MOVIE_TICKET", "TYPE_LIST_ORDER_TICKET", "TYPE_LIST_ORDER_TRAIN", "TYPE_LIST_DETAIL_SEPARATOR", "TYPE_DETAIL_COLLECT_CONTENT", "TYPE_DETAIL_COLLECT_STORE", "TYPE_DETAIL_COMMON_TEXT", "TYPE_DETAIL_EVENT_SCHEDULE", "TYPE_DETAIL_EVENT_TODO", "TYPE_DETAIL_INFO_ADDRESS", "TYPE_DETAIL_INFO_ANNIVERSARY", "TYPE_DETAIL_INFO_COMMON", "TYPE_DETAIL_INFO_DOCUMENTS", "TYPE_DETAIL_INFO_RELATION", "TYPE_DETAIL_ORDER_COMMON", "TYPE_DETAIL_ORDER_FLIGHT", "TYPE_DETAIL_ORDER_HOTEL", "TYPE_DETAIL_ORDER_MOVIE_TICKET", "TYPE_DETAIL_ORDER_TICKET", "TYPE_DETAIL_ORDER_TRAIN", "TYPE_CALENDAR", "TYPE_EPISODIC_TOPIC", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryItemType extends Enum<MemoryItemType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryItemType[] $VALUES = null;
    public static final MemoryItemType TYPE_AUDIO_ENTITY = null;
    public static final MemoryItemType TYPE_AUTO_MEMORY_PRO = null;
    public static final MemoryItemType TYPE_CALENDAR = null;
    public static final MemoryItemType TYPE_DETAIL_COLLECT_CONTENT = null;
    public static final MemoryItemType TYPE_DETAIL_COLLECT_STORE = null;
    public static final MemoryItemType TYPE_DETAIL_COMMON_TEXT = null;
    public static final MemoryItemType TYPE_DETAIL_EVENT_SCHEDULE = null;
    public static final MemoryItemType TYPE_DETAIL_EVENT_TODO = null;
    public static final MemoryItemType TYPE_DETAIL_INFO_ADDRESS = null;
    public static final MemoryItemType TYPE_DETAIL_INFO_ANNIVERSARY = null;
    public static final MemoryItemType TYPE_DETAIL_INFO_COMMON = null;
    public static final MemoryItemType TYPE_DETAIL_INFO_DOCUMENTS = null;
    public static final MemoryItemType TYPE_DETAIL_INFO_RELATION = null;
    public static final MemoryItemType TYPE_DETAIL_ORDER_COMMON = null;
    public static final MemoryItemType TYPE_DETAIL_ORDER_FLIGHT = null;
    public static final MemoryItemType TYPE_DETAIL_ORDER_HOTEL = null;
    public static final MemoryItemType TYPE_DETAIL_ORDER_MOVIE_TICKET = null;
    public static final MemoryItemType TYPE_DETAIL_ORDER_TICKET = null;
    public static final MemoryItemType TYPE_DETAIL_ORDER_TRAIN = null;
    public static final MemoryItemType TYPE_EPISODIC_TOPIC = null;
    public static final MemoryItemType TYPE_LIST_COLLECT_CONTENT = null;
    public static final MemoryItemType TYPE_LIST_COLLECT_STORE = null;
    public static final MemoryItemType TYPE_LIST_COMMON_TEXT = null;
    public static final MemoryItemType TYPE_LIST_DETAIL_SEPARATOR = null;
    public static final MemoryItemType TYPE_LIST_EVENT_SCHEDULE = null;
    public static final MemoryItemType TYPE_LIST_EVENT_TODO = null;
    public static final MemoryItemType TYPE_LIST_INFO_ADDRESS = null;
    public static final MemoryItemType TYPE_LIST_INFO_ANNIVERSARY = null;
    public static final MemoryItemType TYPE_LIST_INFO_COMMON = null;
    public static final MemoryItemType TYPE_LIST_INFO_DOCUMENTS = null;
    public static final MemoryItemType TYPE_LIST_INFO_RELATION = null;
    public static final MemoryItemType TYPE_LIST_ORDER_COMMON = null;
    public static final MemoryItemType TYPE_LIST_ORDER_FLIGHT = null;
    public static final MemoryItemType TYPE_LIST_ORDER_HOTEL = null;
    public static final MemoryItemType TYPE_LIST_ORDER_MOVIE_TICKET = null;
    public static final MemoryItemType TYPE_LIST_ORDER_TICKET = null;
    public static final MemoryItemType TYPE_LIST_ORDER_TRAIN = null;
    public static final MemoryItemType TYPE_MEMORY_FOOTER = null;
    public static final MemoryItemType TYPE_RELATION_TITLE = null;
    public static final MemoryItemType TYPE_SHORT_ENTITY = null;
    public static final MemoryItemType TYPE_TIME = null;

    private static final /* synthetic */ MemoryItemType[] $values() {
        return new MemoryItemType[]{TYPE_TIME, TYPE_RELATION_TITLE, TYPE_MEMORY_FOOTER, TYPE_SHORT_ENTITY, TYPE_AUDIO_ENTITY, TYPE_AUTO_MEMORY_PRO, TYPE_LIST_COLLECT_CONTENT, TYPE_LIST_COLLECT_STORE, TYPE_LIST_COMMON_TEXT, TYPE_LIST_EVENT_SCHEDULE, TYPE_LIST_EVENT_TODO, TYPE_LIST_INFO_ADDRESS, TYPE_LIST_INFO_ANNIVERSARY, TYPE_LIST_INFO_COMMON, TYPE_LIST_INFO_DOCUMENTS, TYPE_LIST_INFO_RELATION, TYPE_LIST_ORDER_COMMON, TYPE_LIST_ORDER_FLIGHT, TYPE_LIST_ORDER_HOTEL, TYPE_LIST_ORDER_MOVIE_TICKET, TYPE_LIST_ORDER_TICKET, TYPE_LIST_ORDER_TRAIN, TYPE_LIST_DETAIL_SEPARATOR, TYPE_DETAIL_COLLECT_CONTENT, TYPE_DETAIL_COLLECT_STORE, TYPE_DETAIL_COMMON_TEXT, TYPE_DETAIL_EVENT_SCHEDULE, TYPE_DETAIL_EVENT_TODO, TYPE_DETAIL_INFO_ADDRESS, TYPE_DETAIL_INFO_ANNIVERSARY, TYPE_DETAIL_INFO_COMMON, TYPE_DETAIL_INFO_DOCUMENTS, TYPE_DETAIL_INFO_RELATION, TYPE_DETAIL_ORDER_COMMON, TYPE_DETAIL_ORDER_FLIGHT, TYPE_DETAIL_ORDER_HOTEL, TYPE_DETAIL_ORDER_MOVIE_TICKET, TYPE_DETAIL_ORDER_TICKET, TYPE_DETAIL_ORDER_TRAIN, TYPE_CALENDAR, TYPE_EPISODIC_TOPIC};
    }

    static {
        TYPE_TIME = new MemoryItemType("TYPE_TIME", 0);
        TYPE_RELATION_TITLE = new MemoryItemType("TYPE_RELATION_TITLE", 1);
        TYPE_MEMORY_FOOTER = new MemoryItemType("TYPE_MEMORY_FOOTER", 2);
        TYPE_SHORT_ENTITY = new MemoryItemType("TYPE_SHORT_ENTITY", 3);
        TYPE_AUDIO_ENTITY = new MemoryItemType("TYPE_AUDIO_ENTITY", 4);
        TYPE_AUTO_MEMORY_PRO = new MemoryItemType("TYPE_AUTO_MEMORY_PRO", 5);
        TYPE_LIST_COLLECT_CONTENT = new MemoryItemType("TYPE_LIST_COLLECT_CONTENT", 6);
        TYPE_LIST_COLLECT_STORE = new MemoryItemType("TYPE_LIST_COLLECT_STORE", 7);
        TYPE_LIST_COMMON_TEXT = new MemoryItemType("TYPE_LIST_COMMON_TEXT", 8);
        TYPE_LIST_EVENT_SCHEDULE = new MemoryItemType("TYPE_LIST_EVENT_SCHEDULE", 9);
        TYPE_LIST_EVENT_TODO = new MemoryItemType("TYPE_LIST_EVENT_TODO", 10);
        TYPE_LIST_INFO_ADDRESS = new MemoryItemType("TYPE_LIST_INFO_ADDRESS", 11);
        TYPE_LIST_INFO_ANNIVERSARY = new MemoryItemType("TYPE_LIST_INFO_ANNIVERSARY", 12);
        TYPE_LIST_INFO_COMMON = new MemoryItemType("TYPE_LIST_INFO_COMMON", 13);
        TYPE_LIST_INFO_DOCUMENTS = new MemoryItemType("TYPE_LIST_INFO_DOCUMENTS", 14);
        TYPE_LIST_INFO_RELATION = new MemoryItemType("TYPE_LIST_INFO_RELATION", 15);
        TYPE_LIST_ORDER_COMMON = new MemoryItemType("TYPE_LIST_ORDER_COMMON", 16);
        TYPE_LIST_ORDER_FLIGHT = new MemoryItemType("TYPE_LIST_ORDER_FLIGHT", 17);
        TYPE_LIST_ORDER_HOTEL = new MemoryItemType("TYPE_LIST_ORDER_HOTEL", 18);
        TYPE_LIST_ORDER_MOVIE_TICKET = new MemoryItemType("TYPE_LIST_ORDER_MOVIE_TICKET", 19);
        TYPE_LIST_ORDER_TICKET = new MemoryItemType("TYPE_LIST_ORDER_TICKET", 20);
        TYPE_LIST_ORDER_TRAIN = new MemoryItemType("TYPE_LIST_ORDER_TRAIN", 21);
        TYPE_LIST_DETAIL_SEPARATOR = new MemoryItemType("TYPE_LIST_DETAIL_SEPARATOR", 22);
        TYPE_DETAIL_COLLECT_CONTENT = new MemoryItemType("TYPE_DETAIL_COLLECT_CONTENT", 23);
        TYPE_DETAIL_COLLECT_STORE = new MemoryItemType("TYPE_DETAIL_COLLECT_STORE", 24);
        TYPE_DETAIL_COMMON_TEXT = new MemoryItemType("TYPE_DETAIL_COMMON_TEXT", 25);
        TYPE_DETAIL_EVENT_SCHEDULE = new MemoryItemType("TYPE_DETAIL_EVENT_SCHEDULE", 26);
        TYPE_DETAIL_EVENT_TODO = new MemoryItemType("TYPE_DETAIL_EVENT_TODO", 27);
        TYPE_DETAIL_INFO_ADDRESS = new MemoryItemType("TYPE_DETAIL_INFO_ADDRESS", 28);
        TYPE_DETAIL_INFO_ANNIVERSARY = new MemoryItemType("TYPE_DETAIL_INFO_ANNIVERSARY", 29);
        TYPE_DETAIL_INFO_COMMON = new MemoryItemType("TYPE_DETAIL_INFO_COMMON", 30);
        TYPE_DETAIL_INFO_DOCUMENTS = new MemoryItemType("TYPE_DETAIL_INFO_DOCUMENTS", 31);
        TYPE_DETAIL_INFO_RELATION = new MemoryItemType("TYPE_DETAIL_INFO_RELATION", 32);
        TYPE_DETAIL_ORDER_COMMON = new MemoryItemType("TYPE_DETAIL_ORDER_COMMON", 33);
        TYPE_DETAIL_ORDER_FLIGHT = new MemoryItemType("TYPE_DETAIL_ORDER_FLIGHT", 34);
        TYPE_DETAIL_ORDER_HOTEL = new MemoryItemType("TYPE_DETAIL_ORDER_HOTEL", 35);
        TYPE_DETAIL_ORDER_MOVIE_TICKET = new MemoryItemType("TYPE_DETAIL_ORDER_MOVIE_TICKET", 36);
        TYPE_DETAIL_ORDER_TICKET = new MemoryItemType("TYPE_DETAIL_ORDER_TICKET", 37);
        TYPE_DETAIL_ORDER_TRAIN = new MemoryItemType("TYPE_DETAIL_ORDER_TRAIN", 38);
        TYPE_CALENDAR = new MemoryItemType("TYPE_CALENDAR", 39);
        TYPE_EPISODIC_TOPIC = new MemoryItemType("TYPE_EPISODIC_TOPIC", 40);
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
