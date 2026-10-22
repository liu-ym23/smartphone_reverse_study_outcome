package com.bytedance.android.live.base.model.message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final enum PieceType extends Enum<PieceType> {
    public static final PieceType GIFT = null;
    public static final PieceType HEART = null;
    public static final PieceType IMAGE = null;
    public static final PieceType PATTERN_REF = null;
    public static final PieceType STRING = null;
    public static final PieceType UNKNOWN = null;
    public static final PieceType USER = null;
    public static final /* synthetic */ PieceType[] a = null;
    private int pieceType;
    private String tag;

    static {
        PieceType r0 = new PieceType("UNKNOWN", 0, 0, "");
        UNKNOWN = r0;
        PieceType r1 = new PieceType("STRING", 1, 1, "string");
        STRING = r1;
        PieceType r2 = new PieceType("USER", 2, 11, "user");
        USER = r2;
        PieceType r4 = new PieceType("GIFT", 3, 12, "gift");
        GIFT = r4;
        PieceType r6 = new PieceType("HEART", 4, 13, "heart");
        HEART = r6;
        PieceType r7 = new PieceType("PATTERN_REF", 5, 14, "pref");
        PATTERN_REF = r7;
        PieceType r9 = new PieceType("IMAGE", 6, 15, "image");
        IMAGE = r9;
        a = new PieceType[]{r0, r1, r2, r4, r6, r7, r9};
    }

    public static PieceType[] values() {
        return (PieceType[]) a.clone();
    }

    public int getPieceType() {
        return this.pieceType;
    }

    public String getTag() {
        return this.tag;
    }

    public static PieceType valueOf(String r1) {
        return (PieceType) r27.a.a(PieceType.class, r1);
    }

    public PieceType(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.pieceType = r3;
        this.tag = r4;
    }
}
