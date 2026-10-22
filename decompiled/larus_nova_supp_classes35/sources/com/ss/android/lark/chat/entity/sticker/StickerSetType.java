package com.ss.android.lark.chat.entity.sticker;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum StickerSetType extends Enum<StickerSetType> {
    public static final StickerSetType FREE = null;
    public static final StickerSetType UNKNOWN_STICKER_SET_TYPE = null;
    public static final /* synthetic */ StickerSetType[] a = null;
    private int mValue;

    static {
        StickerSetType r0 = new StickerSetType("UNKNOWN_STICKER_SET_TYPE", 0, 0);
        UNKNOWN_STICKER_SET_TYPE = r0;
        StickerSetType r1 = new StickerSetType("FREE", 1, 1);
        FREE = r1;
        a = new StickerSetType[]{r0, r1};
    }

    public static StickerSetType[] values() {
        return (StickerSetType[]) a.clone();
    }

    public int getNumber() {
        return this.mValue;
    }

    public static StickerSetType forNumber(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return FREE;
    L10:
        return UNKNOWN_STICKER_SET_TYPE;
    }

    public static StickerSetType valueOf(String r1) {
        return (StickerSetType) a.a(StickerSetType.class, r1);
    }

    public static StickerSetType valueOf(int r0) {
        return forNumber(r0);
    }

    public StickerSetType(String r1, int r2, int r3) {
        super(r1, r2);
        this.mValue = r3;
    }
}
