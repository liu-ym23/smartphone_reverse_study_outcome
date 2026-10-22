package com.ss.android.lark.message.service.dto;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum CardActionMethodType extends Enum<CardActionMethodType> {
    public static final CardActionMethodType GET = null;
    public static final CardActionMethodType LARK_COMMAND = null;
    public static final CardActionMethodType OPEN_URL = null;
    public static final CardActionMethodType POST = null;
    public static final CardActionMethodType UNKNOWN = null;
    public static final /* synthetic */ CardActionMethodType[] a = null;
    private int value;

    static {
        CardActionMethodType r0 = new CardActionMethodType("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        CardActionMethodType r1 = new CardActionMethodType("GET", 1, 1);
        GET = r1;
        CardActionMethodType r2 = new CardActionMethodType("POST", 2, 2);
        POST = r2;
        CardActionMethodType r5 = new CardActionMethodType("LARK_COMMAND", 3, 3);
        LARK_COMMAND = r5;
        CardActionMethodType r7 = new CardActionMethodType("OPEN_URL", 4, 4);
        OPEN_URL = r7;
        a = new CardActionMethodType[]{r0, r1, r2, r5, r7};
    }

    public static CardActionMethodType[] values() {
        return (CardActionMethodType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static CardActionMethodType forNumber(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return UNKNOWN;
    L13:
        return OPEN_URL;
    L15:
        return LARK_COMMAND;
    L17:
        return POST;
    L19:
        return GET;
    }

    public static CardActionMethodType valueOf(String r1) {
        return (CardActionMethodType) a.a(CardActionMethodType.class, r1);
    }

    public static CardActionMethodType valueOf(int r0) {
        return forNumber(r0);
    }

    public CardActionMethodType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
