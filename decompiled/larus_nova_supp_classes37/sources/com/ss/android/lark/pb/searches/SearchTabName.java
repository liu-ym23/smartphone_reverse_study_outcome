package com.ss.android.lark.pb.searches;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SearchTabName extends Enum<SearchTabName> implements WireEnum {
    private static final /* synthetic */ SearchTabName[] $VALUES = null;
    public static final ProtoAdapter<SearchTabName> ADAPTER = null;
    public static final SearchTabName APP_TAB = null;
    public static final SearchTabName CALENDAR_TAB = null;
    public static final SearchTabName CHATTER_TAB = null;
    public static final SearchTabName CHAT_TAB = null;
    public static final SearchTabName DOCS_TAB = null;
    public static final SearchTabName EMAIL_TAB = null;
    public static final SearchTabName HELPDESK_TAB = null;
    public static final SearchTabName MESSAGE_TAB = null;
    public static final SearchTabName OPEN_SEARCH_TAB = null;
    public static final SearchTabName PANO_TAB = null;
    public static final SearchTabName SMART_SEARCH_TAB = null;
    public static final SearchTabName UNKNOWN_TAB = null;
    public static final SearchTabName WIKI_TAB = null;
    private final int value;

    static {
        SearchTabName r0 = new SearchTabName("UNKNOWN_TAB", 0, 0);
        UNKNOWN_TAB = r0;
        SearchTabName r1 = new SearchTabName("MESSAGE_TAB", 1, 1);
        MESSAGE_TAB = r1;
        SearchTabName r3 = new SearchTabName("DOCS_TAB", 2, 2);
        DOCS_TAB = r3;
        SearchTabName r5 = new SearchTabName("WIKI_TAB", 3, 3);
        WIKI_TAB = r5;
        SearchTabName r7 = new SearchTabName("CHAT_TAB", 4, 4);
        CHAT_TAB = r7;
        SearchTabName r9 = new SearchTabName("CALENDAR_TAB", 5, 5);
        CALENDAR_TAB = r9;
        SearchTabName r11 = new SearchTabName("APP_TAB", 6, 6);
        APP_TAB = r11;
        SearchTabName r13 = new SearchTabName("EMAIL_TAB", 7, 7);
        EMAIL_TAB = r13;
        SearchTabName r15 = new SearchTabName("CHATTER_TAB", 8, 8);
        CHATTER_TAB = r15;
        SearchTabName r14 = new SearchTabName("PANO_TAB", 9, 9);
        PANO_TAB = r14;
        SearchTabName r12 = new SearchTabName("HELPDESK_TAB", 10, 10);
        HELPDESK_TAB = r12;
        SearchTabName r10 = new SearchTabName("OPEN_SEARCH_TAB", 11, 255);
        OPEN_SEARCH_TAB = r10;
        SearchTabName r6 = new SearchTabName("SMART_SEARCH_TAB", 12, 11);
        SMART_SEARCH_TAB = r6;
        $VALUES = new SearchTabName[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r6};
        ADAPTER = ProtoAdapter.newEnumAdapter(SearchTabName.class);
    }

    public static SearchTabName[] values() {
        return (SearchTabName[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchTabName fromValue(int r1) {
        if (r1 == 255) goto L32;
        switch(r1) {
            case 0: goto L30;
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return SMART_SEARCH_TAB;
    L10:
        return HELPDESK_TAB;
    L12:
        return PANO_TAB;
    L14:
        return CHATTER_TAB;
    L16:
        return EMAIL_TAB;
    L18:
        return APP_TAB;
    L20:
        return CALENDAR_TAB;
    L22:
        return CHAT_TAB;
    L24:
        return WIKI_TAB;
    L26:
        return DOCS_TAB;
    L28:
        return MESSAGE_TAB;
    L30:
        return UNKNOWN_TAB;
    L32:
        return OPEN_SEARCH_TAB;
    }

    public static SearchTabName valueOf(String r1) {
        return (SearchTabName) a.a(SearchTabName.class, r1);
    }

    private SearchTabName(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
