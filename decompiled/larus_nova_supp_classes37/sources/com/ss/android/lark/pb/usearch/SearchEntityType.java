package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SearchEntityType extends Enum<SearchEntityType> implements WireEnum {
    private static final /* synthetic */ SearchEntityType[] $VALUES = null;
    public static final ProtoAdapter<SearchEntityType> ADAPTER = null;
    public static final SearchEntityType APP = null;
    public static final SearchEntityType BANNER = null;
    public static final SearchEntityType BOT = null;
    public static final SearchEntityType CALENDAR_EVENT = null;
    public static final SearchEntityType CHAMELEON = null;
    public static final SearchEntityType CRYPTO_P2P_CHAT = null;
    public static final SearchEntityType CUSTOMIZATION = null;
    public static final SearchEntityType DEPARTMENT = null;
    public static final SearchEntityType DOC = null;
    public static final SearchEntityType EMAIL = null;
    public static final SearchEntityType FACILITY = null;
    public static final SearchEntityType GROUP_CHAT = null;
    public static final SearchEntityType MAIL_CONTACT = null;
    public static final SearchEntityType MAIL_USER = null;
    public static final SearchEntityType MESSAGE = null;
    public static final SearchEntityType MESSAGE_FILE = null;
    public static final SearchEntityType MY_AI = null;
    public static final SearchEntityType NEW_USER_GROUP = null;
    public static final SearchEntityType ONCALL = null;
    public static final SearchEntityType PANO = null;
    public static final SearchEntityType PASSAGE = null;
    public static final SearchEntityType PHOENIX = null;
    public static final SearchEntityType QA_CARD = null;
    public static final SearchEntityType RESOURCE = null;
    public static final SearchEntityType SECTION = null;
    public static final SearchEntityType SHIELD_P2P_CHAT = null;
    public static final SearchEntityType SLASH_COMMAND = null;
    public static final SearchEntityType THREAD = null;
    public static final SearchEntityType UNKNOWN = null;
    public static final SearchEntityType URL = null;
    public static final SearchEntityType USER = null;
    public static final SearchEntityType USER_GROUP = null;
    public static final SearchEntityType USER_GROUP_ASSIGN = null;
    public static final SearchEntityType WIKI = null;
    public static final SearchEntityType WIKI_SPACE = null;
    private final int value;

    static {
        SearchEntityType r0 = new SearchEntityType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        SearchEntityType r1 = new SearchEntityType("USER", 1, 1);
        USER = r1;
        SearchEntityType r3 = new SearchEntityType("BOT", 2, 2);
        BOT = r3;
        SearchEntityType r5 = new SearchEntityType("GROUP_CHAT", 3, 3);
        GROUP_CHAT = r5;
        SearchEntityType r7 = new SearchEntityType("CRYPTO_P2P_CHAT", 4, 4);
        CRYPTO_P2P_CHAT = r7;
        SearchEntityType r9 = new SearchEntityType("MESSAGE", 5, 5);
        MESSAGE = r9;
        SearchEntityType r11 = new SearchEntityType("DOC", 6, 7);
        DOC = r11;
        SearchEntityType r13 = new SearchEntityType("WIKI", 7, 8);
        WIKI = r13;
        SearchEntityType r14 = new SearchEntityType("APP", 8, 9);
        APP = r14;
        SearchEntityType r15 = new SearchEntityType("ONCALL", 9, 10);
        ONCALL = r15;
        SearchEntityType r12 = new SearchEntityType("THREAD", 10, 11);
        THREAD = r12;
        SearchEntityType r10 = new SearchEntityType("QA_CARD", 11, 12);
        QA_CARD = r10;
        SearchEntityType r8 = new SearchEntityType("URL", 12, 13);
        URL = r8;
        SearchEntityType r6 = new SearchEntityType("DEPARTMENT", 13, 14);
        DEPARTMENT = r6;
        SearchEntityType r4 = new SearchEntityType("PANO", 14, 15);
        PANO = r4;
        SearchEntityType r2 = new SearchEntityType("SLASH_COMMAND", 15, 16);
        SLASH_COMMAND = r2;
        SearchEntityType r16 = new SearchEntityType("SECTION", 16, 17);
        SECTION = r16;
        SearchEntityType r17 = new SearchEntityType("RESOURCE", 17, 18);
        RESOURCE = r17;
        SearchEntityType r18 = new SearchEntityType("CUSTOMIZATION", 18, 19);
        CUSTOMIZATION = r18;
        SearchEntityType r19 = new SearchEntityType("FACILITY", 19, 20);
        FACILITY = r19;
        SearchEntityType r20 = new SearchEntityType("MAIL_CONTACT", 20, 21);
        MAIL_CONTACT = r20;
        SearchEntityType r21 = new SearchEntityType("CHAMELEON", 21, 22);
        CHAMELEON = r21;
        SearchEntityType r22 = new SearchEntityType("CALENDAR_EVENT", 22, 23);
        CALENDAR_EVENT = r22;
        SearchEntityType r23 = new SearchEntityType("BANNER", 23, 24);
        BANNER = r23;
        SearchEntityType r24 = new SearchEntityType("WIKI_SPACE", 24, 25);
        WIKI_SPACE = r24;
        SearchEntityType r25 = new SearchEntityType("PHOENIX", 25, 26);
        PHOENIX = r25;
        SearchEntityType r26 = new SearchEntityType("SHIELD_P2P_CHAT", 26, 27);
        SHIELD_P2P_CHAT = r26;
        SearchEntityType r27 = new SearchEntityType("USER_GROUP", 27, 28);
        USER_GROUP = r27;
        SearchEntityType r28 = new SearchEntityType("USER_GROUP_ASSIGN", 28, 29);
        USER_GROUP_ASSIGN = r28;
        SearchEntityType r29 = new SearchEntityType("MESSAGE_FILE", 29, 30);
        MESSAGE_FILE = r29;
        SearchEntityType r30 = new SearchEntityType("MY_AI", 30, 31);
        MY_AI = r30;
        SearchEntityType r31 = new SearchEntityType("PASSAGE", 31, 32);
        PASSAGE = r31;
        SearchEntityType r32 = new SearchEntityType("EMAIL", 32, 33);
        EMAIL = r32;
        SearchEntityType r33 = new SearchEntityType("MAIL_USER", 33, 34);
        MAIL_USER = r33;
        SearchEntityType r34 = new SearchEntityType("NEW_USER_GROUP", 34, 35);
        NEW_USER_GROUP = r34;
        $VALUES = new SearchEntityType[]{r0, r1, r3, r5, r7, r9, r11, r13, r14, r15, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34};
        ADAPTER = ProtoAdapter.newEnumAdapter(SearchEntityType.class);
    }

    public static SearchEntityType[] values() {
        return (SearchEntityType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SearchEntityType fromValue(int r0) {
        switch(r0) {
            case 0: goto L74;
            case 1: goto L72;
            case 2: goto L70;
            case 3: goto L68;
            case 4: goto L66;
            case 5: goto L64;
            case 6: goto L3;
            case 7: goto L62;
            case 8: goto L60;
            case 9: goto L58;
            case 10: goto L56;
            case 11: goto L54;
            case 12: goto L52;
            case 13: goto L50;
            case 14: goto L48;
            case 15: goto L46;
            case 16: goto L44;
            case 17: goto L42;
            case 18: goto L40;
            case 19: goto L38;
            case 20: goto L36;
            case 21: goto L34;
            case 22: goto L32;
            case 23: goto L30;
            case 24: goto L28;
            case 25: goto L26;
            case 26: goto L24;
            case 27: goto L22;
            case 28: goto L20;
            case 29: goto L18;
            case 30: goto L16;
            case 31: goto L14;
            case 32: goto L12;
            case 33: goto L10;
            case 34: goto L8;
            case 35: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return NEW_USER_GROUP;
    L8:
        return MAIL_USER;
    L10:
        return EMAIL;
    L12:
        return PASSAGE;
    L14:
        return MY_AI;
    L16:
        return MESSAGE_FILE;
    L18:
        return USER_GROUP_ASSIGN;
    L20:
        return USER_GROUP;
    L22:
        return SHIELD_P2P_CHAT;
    L24:
        return PHOENIX;
    L26:
        return WIKI_SPACE;
    L28:
        return BANNER;
    L30:
        return CALENDAR_EVENT;
    L32:
        return CHAMELEON;
    L34:
        return MAIL_CONTACT;
    L36:
        return FACILITY;
    L38:
        return CUSTOMIZATION;
    L40:
        return RESOURCE;
    L42:
        return SECTION;
    L44:
        return SLASH_COMMAND;
    L46:
        return PANO;
    L48:
        return DEPARTMENT;
    L50:
        return URL;
    L52:
        return QA_CARD;
    L54:
        return THREAD;
    L56:
        return ONCALL;
    L58:
        return APP;
    L60:
        return WIKI;
    L62:
        return DOC;
    L64:
        return MESSAGE;
    L66:
        return CRYPTO_P2P_CHAT;
    L68:
        return GROUP_CHAT;
    L70:
        return BOT;
    L72:
        return USER;
    L74:
        return UNKNOWN;
    }

    public static SearchEntityType valueOf(String r1) {
        return (SearchEntityType) a.a(SearchEntityType.class, r1);
    }

    private SearchEntityType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
