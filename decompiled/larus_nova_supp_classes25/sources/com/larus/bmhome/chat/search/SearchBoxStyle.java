package com.larus.bmhome.chat.search;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchBoxStyle;", "", "<init>", "(Ljava/lang/String;I)V", "singleRowNormal", "singleRowTiny", "doubleColumnVideo", "doubleColumnImage", "singleRowVideoNew", "doubleColumnMixedMedia", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SearchBoxStyle extends Enum<SearchBoxStyle> {
    public static final /* synthetic */ SearchBoxStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final SearchBoxStyle doubleColumnImage = null;
    public static final SearchBoxStyle doubleColumnMixedMedia = null;
    public static final SearchBoxStyle doubleColumnVideo = null;
    public static final SearchBoxStyle singleRowNormal = null;
    public static final SearchBoxStyle singleRowTiny = null;
    public static final SearchBoxStyle singleRowVideoNew = null;

    public static EnumEntries<SearchBoxStyle> getEntries() {
        return b;
    }

    static {
        SearchBoxStyle r0 = new SearchBoxStyle("singleRowNormal", 0);
        singleRowNormal = r0;
        SearchBoxStyle r1 = new SearchBoxStyle("singleRowTiny", 1);
        singleRowTiny = r1;
        SearchBoxStyle r3 = new SearchBoxStyle("doubleColumnVideo", 2);
        doubleColumnVideo = r3;
        SearchBoxStyle r5 = new SearchBoxStyle("doubleColumnImage", 3);
        doubleColumnImage = r5;
        SearchBoxStyle r7 = new SearchBoxStyle("singleRowVideoNew", 4);
        singleRowVideoNew = r7;
        SearchBoxStyle r9 = new SearchBoxStyle("doubleColumnMixedMedia", 5);
        doubleColumnMixedMedia = r9;
        SearchBoxStyle[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static SearchBoxStyle[] values() {
        return (SearchBoxStyle[]) a.clone();
    }

    public static SearchBoxStyle valueOf(String r1) {
        return (SearchBoxStyle) r27.a.a(SearchBoxStyle.class, r1);
    }

    public SearchBoxStyle(String r1, int r2) {
        super(r1, r2);
    }
}
