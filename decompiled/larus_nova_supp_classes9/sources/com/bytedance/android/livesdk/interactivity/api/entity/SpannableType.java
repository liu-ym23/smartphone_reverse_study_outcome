package com.bytedance.android.livesdk.interactivity.api.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final enum SpannableType extends Enum<SpannableType> {
    public static final SpannableType DISPLAY_TEXT = null;
    public static final SpannableType GAME = null;
    public static final SpannableType MESSAGE_FILTER = null;
    public static final SpannableType MINI_CARD = null;
    public static final SpannableType NORMAL = null;
    public static final /* synthetic */ SpannableType[] a = null;

    static {
        SpannableType r0 = new SpannableType("NORMAL", 0);
        NORMAL = r0;
        SpannableType r1 = new SpannableType("GAME", 1);
        GAME = r1;
        SpannableType r3 = new SpannableType("DISPLAY_TEXT", 2);
        DISPLAY_TEXT = r3;
        SpannableType r5 = new SpannableType("MESSAGE_FILTER", 3);
        MESSAGE_FILTER = r5;
        SpannableType r7 = new SpannableType("MINI_CARD", 4);
        MINI_CARD = r7;
        a = new SpannableType[]{r0, r1, r3, r5, r7};
    }

    public static SpannableType[] values() {
        return (SpannableType[]) a.clone();
    }

    public static SpannableType valueOf(String r1) {
        return (SpannableType) r27.a.a(SpannableType.class, r1);
    }

    public SpannableType(String r1, int r2) {
        super(r1, r2);
    }
}
