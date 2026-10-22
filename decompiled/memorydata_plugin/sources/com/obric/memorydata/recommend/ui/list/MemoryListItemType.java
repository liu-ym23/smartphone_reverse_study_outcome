package com.obric.memorydata.recommend.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryListItemType;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_TIME", "TYPE_DATA", "TYPE_PORTRAIT", "TYPE_TODO", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryListItemType extends Enum<MemoryListItemType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryListItemType[] $VALUES = null;
    public static final MemoryListItemType TYPE_DATA = null;
    public static final MemoryListItemType TYPE_PORTRAIT = null;
    public static final MemoryListItemType TYPE_TIME = null;
    public static final MemoryListItemType TYPE_TODO = null;

    private static final /* synthetic */ MemoryListItemType[] $values() {
        return new MemoryListItemType[]{TYPE_TIME, TYPE_DATA, TYPE_PORTRAIT, TYPE_TODO};
    }

    static {
        TYPE_TIME = new MemoryListItemType("TYPE_TIME", 0);
        TYPE_DATA = new MemoryListItemType("TYPE_DATA", 1);
        TYPE_PORTRAIT = new MemoryListItemType("TYPE_PORTRAIT", 2);
        TYPE_TODO = new MemoryListItemType("TYPE_TODO", 3);
        MemoryListItemType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private MemoryListItemType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemoryListItemType> getEntries() {
        return $ENTRIES;
    }

    public static MemoryListItemType valueOf(String r2) {
        return (MemoryListItemType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryListItemType.class, r2), MemoryListItemType.class, "com.obric.memorydata.plugin");
    }

    public static MemoryListItemType[] values() {
        return (MemoryListItemType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryListItemType[].class, "com.obric.memorydata.plugin");
    }
}
