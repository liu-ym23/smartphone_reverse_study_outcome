package com.ss.android.lark.chat.export.entity.message.content;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum ContentValueType extends Enum<ContentValueType> {
    public static final ContentValueType ACTION = null;
    public static final ContentValueType BOT = null;
    public static final ContentValueType CHAT = null;
    public static final ContentValueType CHATTER = null;
    public static final ContentValueType DEPARTMENT = null;
    public static final ContentValueType TEXT = null;
    public static final ContentValueType UNKNOWN = null;
    public static final ContentValueType URL = null;
    public static final ContentValueType USER = null;
    public static final /* synthetic */ ContentValueType[] a = null;
    private final int value;

    static {
        ContentValueType r0 = new ContentValueType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ContentValueType r1 = new ContentValueType("USER", 1, 1);
        USER = r1;
        ContentValueType r3 = new ContentValueType("BOT", 2, 2);
        BOT = r3;
        ContentValueType r5 = new ContentValueType("TEXT", 3, 3);
        TEXT = r5;
        ContentValueType r7 = new ContentValueType("CHAT", 4, 4);
        CHAT = r7;
        ContentValueType r9 = new ContentValueType("CHATTER", 5, 5);
        CHATTER = r9;
        ContentValueType r11 = new ContentValueType("URL", 6, 6);
        URL = r11;
        ContentValueType r13 = new ContentValueType("ACTION", 7, 7);
        ACTION = r13;
        ContentValueType r15 = new ContentValueType("DEPARTMENT", 8, 8);
        DEPARTMENT = r15;
        a = new ContentValueType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }

    public static ContentValueType[] values() {
        return (ContentValueType[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ContentValueType fromValue(int r0) {
        switch(r0) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return DEPARTMENT;
    L8:
        return ACTION;
    L10:
        return URL;
    L12:
        return CHATTER;
    L14:
        return CHAT;
    L16:
        return TEXT;
    L18:
        return BOT;
    L20:
        return USER;
    L22:
        return UNKNOWN;
    }

    public static ContentValueType valueOf(String r1) {
        return (ContentValueType) r27.a.a(ContentValueType.class, r1);
    }

    public ContentValueType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
