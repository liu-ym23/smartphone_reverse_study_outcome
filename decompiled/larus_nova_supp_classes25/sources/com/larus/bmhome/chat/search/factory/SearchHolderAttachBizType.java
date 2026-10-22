package com.larus.bmhome.chat.search.factory;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/search/factory/SearchHolderAttachBizType;", "", "<init>", "(Ljava/lang/String;I)V", "RichVideoCardDoubleColumn", "Other", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SearchHolderAttachBizType extends Enum<SearchHolderAttachBizType> {
    public static final SearchHolderAttachBizType Other = null;
    public static final SearchHolderAttachBizType RichVideoCardDoubleColumn = null;
    public static final /* synthetic */ SearchHolderAttachBizType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SearchHolderAttachBizType> getEntries() {
        return b;
    }

    static {
        SearchHolderAttachBizType r0 = new SearchHolderAttachBizType("RichVideoCardDoubleColumn", 0);
        RichVideoCardDoubleColumn = r0;
        SearchHolderAttachBizType r1 = new SearchHolderAttachBizType("Other", 1);
        Other = r1;
        SearchHolderAttachBizType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SearchHolderAttachBizType[] values() {
        return (SearchHolderAttachBizType[]) a.clone();
    }

    public static SearchHolderAttachBizType valueOf(String r1) {
        return (SearchHolderAttachBizType) a.a(SearchHolderAttachBizType.class, r1);
    }

    public SearchHolderAttachBizType(String r1, int r2) {
        super(r1, r2);
    }
}
