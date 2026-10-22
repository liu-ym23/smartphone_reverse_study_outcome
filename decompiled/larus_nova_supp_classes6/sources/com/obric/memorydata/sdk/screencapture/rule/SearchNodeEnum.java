package com.obric.memorydata.sdk.screencapture.rule;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "EVENT", "SOURCE", "ROOT_VIEW_TREE", "TOUCH_POSITION", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final enum SearchNodeEnum extends Enum<SearchNodeEnum> {
    public static final SearchNodeEnum EVENT = null;
    public static final SearchNodeEnum ROOT_VIEW_TREE = null;
    public static final SearchNodeEnum SOURCE = null;
    public static final SearchNodeEnum TOUCH_POSITION = null;
    public static final /* synthetic */ SearchNodeEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SearchNodeEnum> getEntries() {
        return b;
    }

    static {
        SearchNodeEnum r0 = new SearchNodeEnum("EVENT", 0);
        EVENT = r0;
        SearchNodeEnum r1 = new SearchNodeEnum("SOURCE", 1);
        SOURCE = r1;
        SearchNodeEnum r3 = new SearchNodeEnum("ROOT_VIEW_TREE", 2);
        ROOT_VIEW_TREE = r3;
        SearchNodeEnum r5 = new SearchNodeEnum("TOUCH_POSITION", 3);
        TOUCH_POSITION = r5;
        SearchNodeEnum[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static SearchNodeEnum[] values() {
        return (SearchNodeEnum[]) a.clone();
    }

    public static SearchNodeEnum valueOf(String r1) {
        return (SearchNodeEnum) a.a(SearchNodeEnum.class, r1);
    }

    public SearchNodeEnum(String r1, int r2) {
        super(r1, r2);
    }
}
