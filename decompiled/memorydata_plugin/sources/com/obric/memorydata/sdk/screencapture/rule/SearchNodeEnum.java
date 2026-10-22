package com.obric.memorydata.sdk.screencapture.rule;

import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "", "<init>", "(Ljava/lang/String;I)V", PendingMemoryCalendar.TYPE_EVENT, "SOURCE", "ROOT_VIEW_TREE", "TOUCH_POSITION", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SearchNodeEnum extends Enum<SearchNodeEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SearchNodeEnum[] $VALUES = null;
    public static final SearchNodeEnum EVENT = null;
    public static final SearchNodeEnum ROOT_VIEW_TREE = null;
    public static final SearchNodeEnum SOURCE = null;
    public static final SearchNodeEnum TOUCH_POSITION = null;

    private static final /* synthetic */ SearchNodeEnum[] $values() {
        return new SearchNodeEnum[]{EVENT, SOURCE, ROOT_VIEW_TREE, TOUCH_POSITION};
    }

    static {
        EVENT = new SearchNodeEnum(PendingMemoryCalendar.TYPE_EVENT, 0);
        SOURCE = new SearchNodeEnum("SOURCE", 1);
        ROOT_VIEW_TREE = new SearchNodeEnum("ROOT_VIEW_TREE", 2);
        TOUCH_POSITION = new SearchNodeEnum("TOUCH_POSITION", 3);
        SearchNodeEnum[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private SearchNodeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<SearchNodeEnum> getEntries() {
        return $ENTRIES;
    }

    public static SearchNodeEnum valueOf(String r2) {
        return (SearchNodeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(SearchNodeEnum.class, r2), SearchNodeEnum.class, "com.obric.memorydata.plugin");
    }

    public static SearchNodeEnum[] values() {
        return (SearchNodeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SearchNodeEnum[].class, "com.obric.memorydata.plugin");
    }
}
