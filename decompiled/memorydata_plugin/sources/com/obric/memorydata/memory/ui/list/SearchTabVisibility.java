package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchTabVisibility;", "", "<init>", "(Ljava/lang/String;I)V", "GONE", "INVISIBLE", "VISIBLE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SearchTabVisibility extends Enum<SearchTabVisibility> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SearchTabVisibility[] $VALUES = null;
    public static final SearchTabVisibility GONE = null;
    public static final SearchTabVisibility INVISIBLE = null;
    public static final SearchTabVisibility VISIBLE = null;

    private static final /* synthetic */ SearchTabVisibility[] $values() {
        return new SearchTabVisibility[]{GONE, INVISIBLE, VISIBLE};
    }

    static {
        GONE = new SearchTabVisibility("GONE", 0);
        INVISIBLE = new SearchTabVisibility("INVISIBLE", 1);
        VISIBLE = new SearchTabVisibility("VISIBLE", 2);
        SearchTabVisibility[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private SearchTabVisibility(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<SearchTabVisibility> getEntries() {
        return $ENTRIES;
    }

    public static SearchTabVisibility valueOf(String r2) {
        return (SearchTabVisibility) ZeusTransformUtils.preCheckCast(Enum.valueOf(SearchTabVisibility.class, r2), SearchTabVisibility.class, "com.obric.memorydata.plugin");
    }

    public static SearchTabVisibility[] values() {
        return (SearchTabVisibility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SearchTabVisibility[].class, "com.obric.memorydata.plugin");
    }
}
