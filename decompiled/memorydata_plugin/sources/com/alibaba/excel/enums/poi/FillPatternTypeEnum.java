package com.alibaba.excel.enums.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.FillPatternType;

/* JADX INFO: loaded from: classes.dex */
public final enum FillPatternTypeEnum extends Enum<FillPatternTypeEnum> {
    private static final /* synthetic */ FillPatternTypeEnum[] $VALUES = null;
    public static final FillPatternTypeEnum ALT_BARS = null;
    public static final FillPatternTypeEnum BIG_SPOTS = null;
    public static final FillPatternTypeEnum BRICKS = null;
    public static final FillPatternTypeEnum DEFAULT = null;
    public static final FillPatternTypeEnum DIAMONDS = null;
    public static final FillPatternTypeEnum FINE_DOTS = null;
    public static final FillPatternTypeEnum LEAST_DOTS = null;
    public static final FillPatternTypeEnum LESS_DOTS = null;
    public static final FillPatternTypeEnum NO_FILL = null;
    public static final FillPatternTypeEnum SOLID_FOREGROUND = null;
    public static final FillPatternTypeEnum SPARSE_DOTS = null;
    public static final FillPatternTypeEnum SQUARES = null;
    public static final FillPatternTypeEnum THICK_BACKWARD_DIAG = null;
    public static final FillPatternTypeEnum THICK_FORWARD_DIAG = null;
    public static final FillPatternTypeEnum THICK_HORZ_BANDS = null;
    public static final FillPatternTypeEnum THICK_VERT_BANDS = null;
    public static final FillPatternTypeEnum THIN_BACKWARD_DIAG = null;
    public static final FillPatternTypeEnum THIN_FORWARD_DIAG = null;
    public static final FillPatternTypeEnum THIN_HORZ_BANDS = null;
    public static final FillPatternTypeEnum THIN_VERT_BANDS = null;
    FillPatternType poiFillPatternType;

    static {
        FillPatternTypeEnum r0 = new FillPatternTypeEnum("DEFAULT", 0, null);
        DEFAULT = r0;
        FillPatternTypeEnum r1 = new FillPatternTypeEnum("NO_FILL", 1, FillPatternType.NO_FILL);
        NO_FILL = r1;
        FillPatternTypeEnum r3 = new FillPatternTypeEnum("SOLID_FOREGROUND", 2, FillPatternType.SOLID_FOREGROUND);
        SOLID_FOREGROUND = r3;
        FillPatternTypeEnum r4 = new FillPatternTypeEnum("FINE_DOTS", 3, FillPatternType.FINE_DOTS);
        FINE_DOTS = r4;
        FillPatternTypeEnum r6 = new FillPatternTypeEnum("ALT_BARS", 4, FillPatternType.ALT_BARS);
        ALT_BARS = r6;
        FillPatternTypeEnum r8 = new FillPatternTypeEnum("SPARSE_DOTS", 5, FillPatternType.SPARSE_DOTS);
        SPARSE_DOTS = r8;
        FillPatternTypeEnum r10 = new FillPatternTypeEnum("THICK_HORZ_BANDS", 6, FillPatternType.THICK_HORZ_BANDS);
        THICK_HORZ_BANDS = r10;
        FillPatternTypeEnum r12 = new FillPatternTypeEnum("THICK_VERT_BANDS", 7, FillPatternType.THICK_VERT_BANDS);
        THICK_VERT_BANDS = r12;
        FillPatternTypeEnum r14 = new FillPatternTypeEnum("THICK_BACKWARD_DIAG", 8, FillPatternType.THICK_BACKWARD_DIAG);
        THICK_BACKWARD_DIAG = r14;
        FillPatternTypeEnum r13 = new FillPatternTypeEnum("THICK_FORWARD_DIAG", 9, FillPatternType.THICK_FORWARD_DIAG);
        THICK_FORWARD_DIAG = r13;
        FillPatternTypeEnum r11 = new FillPatternTypeEnum("BIG_SPOTS", 10, FillPatternType.BIG_SPOTS);
        BIG_SPOTS = r11;
        FillPatternTypeEnum r9 = new FillPatternTypeEnum("BRICKS", 11, FillPatternType.BRICKS);
        BRICKS = r9;
        FillPatternTypeEnum r7 = new FillPatternTypeEnum("THIN_HORZ_BANDS", 12, FillPatternType.THIN_HORZ_BANDS);
        THIN_HORZ_BANDS = r7;
        FillPatternTypeEnum r5 = new FillPatternTypeEnum("THIN_VERT_BANDS", 13, FillPatternType.THIN_VERT_BANDS);
        THIN_VERT_BANDS = r5;
        FillPatternTypeEnum r2 = new FillPatternTypeEnum("THIN_BACKWARD_DIAG", 14, FillPatternType.THIN_BACKWARD_DIAG);
        THIN_BACKWARD_DIAG = r2;
        FillPatternTypeEnum r15 = new FillPatternTypeEnum("THIN_FORWARD_DIAG", 15, FillPatternType.THIN_FORWARD_DIAG);
        THIN_FORWARD_DIAG = r15;
        FillPatternTypeEnum r16 = new FillPatternTypeEnum("SQUARES", 16, FillPatternType.SQUARES);
        SQUARES = r16;
        FillPatternTypeEnum r17 = new FillPatternTypeEnum("DIAMONDS", 17, FillPatternType.DIAMONDS);
        DIAMONDS = r17;
        FillPatternTypeEnum r18 = new FillPatternTypeEnum("LESS_DOTS", 18, FillPatternType.LESS_DOTS);
        LESS_DOTS = r18;
        FillPatternTypeEnum r19 = new FillPatternTypeEnum("LEAST_DOTS", 19, FillPatternType.LEAST_DOTS);
        LEAST_DOTS = r19;
        $VALUES = new FillPatternTypeEnum[]{r0, r1, r3, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r2, r15, r16, r17, r18, r19};
    }

    private FillPatternTypeEnum(String r1, int r2, FillPatternType r3) {
        super(r1, r2);
        this.poiFillPatternType = r3;
    }

    public static FillPatternTypeEnum valueOf(String r2) {
        return (FillPatternTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(FillPatternTypeEnum.class, r2), FillPatternTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static FillPatternTypeEnum[] values() {
        return (FillPatternTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FillPatternTypeEnum[].class, "com.obric.memorydata.plugin");
    }

    public FillPatternType getPoiFillPatternType() {
        return this.poiFillPatternType;
    }
}
