package com.ss.android.lark.message.card.entity;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final enum CardImageShowMode extends Enum<CardImageShowMode> {
    public static final CardImageShowMode CROP_CENTER = null;
    public static final CardImageShowMode FIT_HORIZONTAL = null;
    public static final CardImageShowMode LARGE = null;
    public static final CardImageShowMode MEDIUM = null;
    public static final CardImageShowMode SMALL = null;
    public static final CardImageShowMode STRETCH = null;
    public static final CardImageShowMode TINY = null;
    public static final /* synthetic */ CardImageShowMode[] a = null;
    private int showModeValue;

    static {
        CardImageShowMode r0 = new CardImageShowMode("CROP_CENTER", 0, 0);
        CROP_CENTER = r0;
        CardImageShowMode r1 = new CardImageShowMode("STRETCH", 1, 1);
        STRETCH = r1;
        CardImageShowMode r3 = new CardImageShowMode("FIT_HORIZONTAL", 2, 2);
        FIT_HORIZONTAL = r3;
        CardImageShowMode r5 = new CardImageShowMode("LARGE", 3, 3);
        LARGE = r5;
        CardImageShowMode r7 = new CardImageShowMode("MEDIUM", 4, 4);
        MEDIUM = r7;
        CardImageShowMode r9 = new CardImageShowMode("SMALL", 5, 5);
        SMALL = r9;
        CardImageShowMode r11 = new CardImageShowMode("TINY", 6, 6);
        TINY = r11;
        a = new CardImageShowMode[]{r0, r1, r3, r5, r7, r9, r11};
    }

    public static CardImageShowMode[] values() {
        return (CardImageShowMode[]) a.clone();
    }

    public int getShowModeValue() {
        return this.showModeValue;
    }

    public static CardImageShowMode forNumber(int r0) {
        switch(r0) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return TINY;
    L8:
        return SMALL;
    L10:
        return MEDIUM;
    L12:
        return LARGE;
    L14:
        return FIT_HORIZONTAL;
    L16:
        return STRETCH;
    L18:
        return CROP_CENTER;
    }

    public static CardImageShowMode valueOf(String r1) {
        return (CardImageShowMode) a.a(CardImageShowMode.class, r1);
    }

    public static CardImageShowMode valueOf(int r0) {
        return forNumber(r0);
    }

    public CardImageShowMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.showModeValue = r3;
    }
}
