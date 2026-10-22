package com.ss.android.lark.pb.searches;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FilterInTab extends Enum<FilterInTab> implements WireEnum {
    private static final /* synthetic */ FilterInTab[] $VALUES = null;
    public static final ProtoAdapter<FilterInTab> ADAPTER = null;
    public static final FilterInTab DOC_CHAT = null;
    public static final FilterInTab DOC_FORMAT = null;
    public static final FilterInTab DOC_FROM = null;
    public static final FilterInTab DOC_MATCH_SCOPE = null;
    public static final FilterInTab DOC_MINE = null;
    public static final FilterInTab DOC_OWNER = null;
    public static final FilterInTab DOC_SHARER = null;
    public static final FilterInTab DOC_SORT = null;
    public static final FilterInTab DOC_TYPE = null;
    public static final FilterInTab DOC_VIEW_TIME = null;
    public static final FilterInTab GROUP_MEMBER = null;
    public static final FilterInTab GROUP_SORT = null;
    public static final FilterInTab GROUP_TYPE = null;
    public static final FilterInTab MSG_AT_ME = null;
    public static final FilterInTab MSG_CHAT = null;
    public static final FilterInTab MSG_HIDE_BOT = null;
    public static final FilterInTab MSG_SENDER = null;
    public static final FilterInTab MSG_SEND_TIME = null;
    public static final FilterInTab MSG_TYPE = null;
    public static final FilterInTab SMART_CHAT = null;
    public static final FilterInTab SMART_MAIL_USER = null;
    public static final FilterInTab SMART_TIME = null;
    public static final FilterInTab SMART_USER = null;
    private final int value;

    static {
        FilterInTab r0 = new FilterInTab("SMART_USER", 0, 1);
        SMART_USER = r0;
        FilterInTab r1 = new FilterInTab("SMART_CHAT", 1, 2);
        SMART_CHAT = r1;
        FilterInTab r4 = new FilterInTab("SMART_TIME", 2, 3);
        SMART_TIME = r4;
        FilterInTab r6 = new FilterInTab("SMART_MAIL_USER", 3, 4);
        SMART_MAIL_USER = r6;
        FilterInTab r8 = new FilterInTab("MSG_SENDER", 4, 10);
        MSG_SENDER = r8;
        FilterInTab r10 = new FilterInTab("MSG_CHAT", 5, 11);
        MSG_CHAT = r10;
        FilterInTab r12 = new FilterInTab("MSG_TYPE", 6, 12);
        MSG_TYPE = r12;
        FilterInTab r15 = new FilterInTab("MSG_SEND_TIME", 7, 13);
        MSG_SEND_TIME = r15;
        FilterInTab r13 = new FilterInTab("MSG_AT_ME", 8, 14);
        MSG_AT_ME = r13;
        FilterInTab r7 = new FilterInTab("MSG_HIDE_BOT", 9, 15);
        MSG_HIDE_BOT = r7;
        FilterInTab r3 = new FilterInTab("DOC_MINE", 10, 30);
        DOC_MINE = r3;
        FilterInTab r2 = new FilterInTab("DOC_OWNER", 11, 31);
        DOC_OWNER = r2;
        FilterInTab r5 = new FilterInTab("DOC_SHARER", 12, 32);
        DOC_SHARER = r5;
        FilterInTab r11 = new FilterInTab("DOC_CHAT", 13, 33);
        DOC_CHAT = r11;
        FilterInTab r9 = new FilterInTab("DOC_TYPE", 14, 34);
        DOC_TYPE = r9;
        FilterInTab r14 = new FilterInTab("DOC_FORMAT", 15, 35);
        DOC_FORMAT = r14;
        FilterInTab r16 = new FilterInTab("DOC_VIEW_TIME", 16, 36);
        DOC_VIEW_TIME = r16;
        FilterInTab r17 = new FilterInTab("DOC_MATCH_SCOPE", 17, 37);
        DOC_MATCH_SCOPE = r17;
        FilterInTab r18 = new FilterInTab("DOC_SORT", 18, 38);
        DOC_SORT = r18;
        FilterInTab r19 = new FilterInTab("DOC_FROM", 19, 39);
        DOC_FROM = r19;
        FilterInTab r110 = new FilterInTab("GROUP_TYPE", 20, 50);
        GROUP_TYPE = r110;
        FilterInTab r20 = new FilterInTab("GROUP_MEMBER", 21, 51);
        GROUP_MEMBER = r20;
        FilterInTab r21 = new FilterInTab("GROUP_SORT", 22, 52);
        GROUP_SORT = r21;
        $VALUES = new FilterInTab[]{r0, r1, r4, r6, r8, r10, r12, r15, r13, r7, r3, r2, r5, r11, r9, r14, r16, r17, r18, r19, r110, r20, r21};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilterInTab.class);
    }

    public static FilterInTab[] values() {
        return (FilterInTab[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FilterInTab fromValue(int r1) {
        if (r1 == 1) goto L60;
        if (r1 == 2) goto L58;
        if (r1 == 3) goto L56;
        if (r1 == 4) goto L54;
        switch(r1) {
            case 10: goto L52;
            case 11: goto L50;
            case 12: goto L48;
            case 13: goto L46;
            case 14: goto L44;
            case 15: goto L42;
            default: goto L11;
        };
    L11:
        switch(r1) {
            case 30: goto L40;
            case 31: goto L38;
            case 32: goto L36;
            case 33: goto L34;
            case 34: goto L32;
            case 35: goto L30;
            case 36: goto L28;
            case 37: goto L26;
            case 38: goto L24;
            case 39: goto L22;
            default: goto L12;
        };
    L12:
        switch(r1) {
            case 50: goto L20;
            case 51: goto L18;
            case 52: goto L16;
            default: goto L13;
        };
    L13:
        return null;
    L16:
        return GROUP_SORT;
    L18:
        return GROUP_MEMBER;
    L20:
        return GROUP_TYPE;
    L22:
        return DOC_FROM;
    L24:
        return DOC_SORT;
    L26:
        return DOC_MATCH_SCOPE;
    L28:
        return DOC_VIEW_TIME;
    L30:
        return DOC_FORMAT;
    L32:
        return DOC_TYPE;
    L34:
        return DOC_CHAT;
    L36:
        return DOC_SHARER;
    L38:
        return DOC_OWNER;
    L40:
        return DOC_MINE;
    L42:
        return MSG_HIDE_BOT;
    L44:
        return MSG_AT_ME;
    L46:
        return MSG_SEND_TIME;
    L48:
        return MSG_TYPE;
    L50:
        return MSG_CHAT;
    L52:
        return MSG_SENDER;
    L54:
        return SMART_MAIL_USER;
    L56:
        return SMART_TIME;
    L58:
        return SMART_CHAT;
    L60:
        return SMART_USER;
    }

    public static FilterInTab valueOf(String r1) {
        return (FilterInTab) a.a(FilterInTab.class, r1);
    }

    private FilterInTab(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
