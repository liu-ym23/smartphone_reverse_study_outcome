package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum FillPatternType extends Enum<FillPatternType> {
    private static final /* synthetic */ FillPatternType[] $VALUES = null;
    public static final FillPatternType ALT_BARS = null;
    public static final FillPatternType BIG_SPOTS = null;
    public static final FillPatternType BRICKS = null;
    public static final FillPatternType DIAMONDS = null;
    public static final FillPatternType FINE_DOTS = null;
    public static final FillPatternType LEAST_DOTS = null;
    public static final FillPatternType LESS_DOTS = null;
    public static final FillPatternType NO_FILL = null;
    public static final FillPatternType SOLID_FOREGROUND = null;
    public static final FillPatternType SPARSE_DOTS = null;
    public static final FillPatternType SQUARES = null;
    public static final FillPatternType THICK_BACKWARD_DIAG = null;
    public static final FillPatternType THICK_FORWARD_DIAG = null;
    public static final FillPatternType THICK_HORZ_BANDS = null;
    public static final FillPatternType THICK_VERT_BANDS = null;
    public static final FillPatternType THIN_BACKWARD_DIAG = null;
    public static final FillPatternType THIN_FORWARD_DIAG = null;
    public static final FillPatternType THIN_HORZ_BANDS = null;
    public static final FillPatternType THIN_VERT_BANDS = null;
    private static final int length = 0;
    private final short code;

    static {
        FillPatternType r0 = new FillPatternType("NO_FILL", 0, 0);
        NO_FILL = r0;
        FillPatternType r1 = new FillPatternType("SOLID_FOREGROUND", 1, 1);
        SOLID_FOREGROUND = r1;
        FillPatternType r3 = new FillPatternType("FINE_DOTS", 2, 2);
        FINE_DOTS = r3;
        FillPatternType r5 = new FillPatternType("ALT_BARS", 3, 3);
        ALT_BARS = r5;
        FillPatternType r7 = new FillPatternType("SPARSE_DOTS", 4, 4);
        SPARSE_DOTS = r7;
        FillPatternType r9 = new FillPatternType("THICK_HORZ_BANDS", 5, 5);
        THICK_HORZ_BANDS = r9;
        FillPatternType r11 = new FillPatternType("THICK_VERT_BANDS", 6, 6);
        THICK_VERT_BANDS = r11;
        FillPatternType r13 = new FillPatternType("THICK_BACKWARD_DIAG", 7, 7);
        THICK_BACKWARD_DIAG = r13;
        FillPatternType r15 = new FillPatternType("THICK_FORWARD_DIAG", 8, 8);
        THICK_FORWARD_DIAG = r15;
        FillPatternType r14 = new FillPatternType("BIG_SPOTS", 9, 9);
        BIG_SPOTS = r14;
        FillPatternType r12 = new FillPatternType("BRICKS", 10, 10);
        BRICKS = r12;
        FillPatternType r10 = new FillPatternType("THIN_HORZ_BANDS", 11, 11);
        THIN_HORZ_BANDS = r10;
        FillPatternType r8 = new FillPatternType("THIN_VERT_BANDS", 12, 12);
        THIN_VERT_BANDS = r8;
        FillPatternType r6 = new FillPatternType("THIN_BACKWARD_DIAG", 13, 13);
        THIN_BACKWARD_DIAG = r6;
        FillPatternType r4 = new FillPatternType("THIN_FORWARD_DIAG", 14, 14);
        THIN_FORWARD_DIAG = r4;
        FillPatternType r2 = new FillPatternType("SQUARES", 15, 15);
        SQUARES = r2;
        FillPatternType r16 = new FillPatternType("DIAMONDS", 16, 16);
        DIAMONDS = r16;
        FillPatternType r17 = new FillPatternType("LESS_DOTS", 17, 17);
        LESS_DOTS = r17;
        FillPatternType r18 = new FillPatternType("LEAST_DOTS", 18, 18);
        LEAST_DOTS = r18;
        $VALUES = new FillPatternType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
        length = values().length;
    }

    private FillPatternType(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = (short) r3;
    }

    public static FillPatternType forInt(int r3) {
        if (r3 < 0) goto L8;
        if (r3 > length) goto L8;
        return values()[r3];
    L8:
        throw new IllegalArgumentException("Invalid FillPatternType code: " + r3);
    }

    public static FillPatternType valueOf(String r2) {
        return (FillPatternType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FillPatternType.class, r2), FillPatternType.class, "com.obric.memorydata.plugin");
    }

    public static FillPatternType[] values() {
        return (FillPatternType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FillPatternType[].class, "com.obric.memorydata.plugin");
    }

    public short getCode() {
        return this.code;
    }
}
