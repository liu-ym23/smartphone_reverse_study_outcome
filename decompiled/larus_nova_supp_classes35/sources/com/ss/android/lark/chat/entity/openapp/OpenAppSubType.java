package com.ss.android.lark.chat.entity.openapp;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum OpenAppSubType extends Enum<OpenAppSubType> {
    public static final OpenAppSubType BOT_CHAT = null;
    public static final OpenAppSubType MINI_APP = null;
    public static final OpenAppSubType UNKNOWN = null;
    public static final /* synthetic */ OpenAppSubType[] a = null;
    int value;

    static {
        OpenAppSubType r0 = new OpenAppSubType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        OpenAppSubType r1 = new OpenAppSubType("MINI_APP", 1, 1);
        MINI_APP = r1;
        OpenAppSubType r3 = new OpenAppSubType("BOT_CHAT", 2, 2);
        BOT_CHAT = r3;
        a = new OpenAppSubType[]{r0, r1, r3};
    }

    public static OpenAppSubType[] values() {
        return (OpenAppSubType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static OpenAppSubType forNumber(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return UNKNOWN;
    L9:
        return BOT_CHAT;
    L11:
        return MINI_APP;
    }

    public static OpenAppSubType valueOf(String r1) {
        return (OpenAppSubType) a.a(OpenAppSubType.class, r1);
    }

    public static OpenAppSubType valueOf(int r0) {
        return forNumber(r0);
    }

    public OpenAppSubType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
