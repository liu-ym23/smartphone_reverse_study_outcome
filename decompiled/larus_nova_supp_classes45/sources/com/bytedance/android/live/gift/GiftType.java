package com.bytedance.android.live.gift;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final enum GiftType extends Enum<GiftType> {
    public static final GiftType BLIND_BOX = null;
    public static final GiftType FREE_CELL = null;
    public static final GiftType GAME = null;
    public static final GiftType GOLDEN_BEAN_CELL = null;
    public static final GiftType INTERACT_GIFT = null;
    public static final GiftType MEMBER_GIFT = null;
    public static final GiftType MIDDLE_GIFT = null;
    public static final GiftType MULTI_INTERACT = null;
    public static final GiftType NORMAL_GIFT = null;
    public static final GiftType SPECIAL_GIFT = null;
    public static final GiftType STICKER_GIFT = null;
    public static final GiftType TASK_GIFT = null;
    public static final GiftType UNKNOWN = null;
    public static final /* synthetic */ GiftType[] a = null;

    static {
        GiftType r0 = new GiftType("UNKNOWN", 0);
        UNKNOWN = r0;
        GiftType r1 = new GiftType("NORMAL_GIFT", 1);
        NORMAL_GIFT = r1;
        GiftType r3 = new GiftType("TASK_GIFT", 2);
        TASK_GIFT = r3;
        GiftType r5 = new GiftType("STICKER_GIFT", 3);
        STICKER_GIFT = r5;
        GiftType r7 = new GiftType("MIDDLE_GIFT", 4);
        MIDDLE_GIFT = r7;
        GiftType r9 = new GiftType("SPECIAL_GIFT", 5);
        SPECIAL_GIFT = r9;
        GiftType r11 = new GiftType("FREE_CELL", 6);
        FREE_CELL = r11;
        GiftType r13 = new GiftType("GOLDEN_BEAN_CELL", 7);
        GOLDEN_BEAN_CELL = r13;
        GiftType r15 = new GiftType("GAME", 8);
        GAME = r15;
        GiftType r14 = new GiftType("BLIND_BOX", 9);
        BLIND_BOX = r14;
        GiftType r12 = new GiftType("INTERACT_GIFT", 10);
        INTERACT_GIFT = r12;
        GiftType r16 = new GiftType("MULTI_INTERACT", 11);
        MULTI_INTERACT = r16;
        GiftType r8 = new GiftType("MEMBER_GIFT", 12);
        MEMBER_GIFT = r8;
        a = new GiftType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r16, r8};
    }

    public static GiftType[] values() {
        return (GiftType[]) a.clone();
    }

    public static GiftType valueOf(String r1) {
        return (GiftType) a.a(GiftType.class, r1);
    }

    public GiftType(String r1, int r2) {
        super(r1, r2);
    }
}
