package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum IgnoredErrorType extends Enum<IgnoredErrorType> {
    private static final /* synthetic */ IgnoredErrorType[] $VALUES = null;
    public static final IgnoredErrorType CALCULATED_COLUMN = null;
    public static final IgnoredErrorType EMPTY_CELL_REFERENCE = null;
    public static final IgnoredErrorType EVALUATION_ERROR = null;
    public static final IgnoredErrorType FORMULA = null;
    public static final IgnoredErrorType FORMULA_RANGE = null;
    public static final IgnoredErrorType LIST_DATA_VALIDATION = null;
    public static final IgnoredErrorType NUMBER_STORED_AS_TEXT = null;
    public static final IgnoredErrorType TWO_DIGIT_TEXT_YEAR = null;
    public static final IgnoredErrorType UNLOCKED_FORMULA = null;

    static {
        IgnoredErrorType r0 = new IgnoredErrorType("CALCULATED_COLUMN", 0);
        CALCULATED_COLUMN = r0;
        IgnoredErrorType r1 = new IgnoredErrorType("EMPTY_CELL_REFERENCE", 1);
        EMPTY_CELL_REFERENCE = r1;
        IgnoredErrorType r3 = new IgnoredErrorType("EVALUATION_ERROR", 2);
        EVALUATION_ERROR = r3;
        IgnoredErrorType r5 = new IgnoredErrorType("FORMULA", 3);
        FORMULA = r5;
        IgnoredErrorType r7 = new IgnoredErrorType("FORMULA_RANGE", 4);
        FORMULA_RANGE = r7;
        IgnoredErrorType r9 = new IgnoredErrorType("LIST_DATA_VALIDATION", 5);
        LIST_DATA_VALIDATION = r9;
        IgnoredErrorType r11 = new IgnoredErrorType("NUMBER_STORED_AS_TEXT", 6);
        NUMBER_STORED_AS_TEXT = r11;
        IgnoredErrorType r13 = new IgnoredErrorType("TWO_DIGIT_TEXT_YEAR", 7);
        TWO_DIGIT_TEXT_YEAR = r13;
        IgnoredErrorType r15 = new IgnoredErrorType("UNLOCKED_FORMULA", 8);
        UNLOCKED_FORMULA = r15;
        $VALUES = new IgnoredErrorType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
    }

    private IgnoredErrorType(String r1, int r2) {
        super(r1, r2);
    }

    public static IgnoredErrorType valueOf(String r2) {
        return (IgnoredErrorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(IgnoredErrorType.class, r2), IgnoredErrorType.class, "com.obric.memorydata.plugin");
    }

    public static IgnoredErrorType[] values() {
        return (IgnoredErrorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IgnoredErrorType[].class, "com.obric.memorydata.plugin");
    }
}
