package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum ConditionFilterType extends Enum<ConditionFilterType> {
    private static final /* synthetic */ ConditionFilterType[] $VALUES = null;
    public static final ConditionFilterType ABOVE_AVERAGE = null;
    public static final ConditionFilterType BEGINS_WITH = null;
    public static final ConditionFilterType CONTAINS_BLANKS = null;
    public static final ConditionFilterType CONTAINS_ERRORS = null;
    public static final ConditionFilterType CONTAINS_TEXT = null;
    public static final ConditionFilterType DUPLICATE_VALUES = null;
    public static final ConditionFilterType ENDS_WITH = null;
    public static final ConditionFilterType FILTER = null;
    public static final ConditionFilterType NOT_CONTAINS_BLANKS = null;
    public static final ConditionFilterType NOT_CONTAINS_ERRORS = null;
    public static final ConditionFilterType NOT_CONTAINS_TEXT = null;
    public static final ConditionFilterType TIME_PERIOD = null;
    public static final ConditionFilterType TOP_10 = null;
    public static final ConditionFilterType UNIQUE_VALUES = null;

    static {
        ConditionFilterType r0 = new ConditionFilterType("FILTER", 0);
        FILTER = r0;
        ConditionFilterType r1 = new ConditionFilterType("TOP_10", 1);
        TOP_10 = r1;
        ConditionFilterType r3 = new ConditionFilterType("UNIQUE_VALUES", 2);
        UNIQUE_VALUES = r3;
        ConditionFilterType r5 = new ConditionFilterType("DUPLICATE_VALUES", 3);
        DUPLICATE_VALUES = r5;
        ConditionFilterType r7 = new ConditionFilterType("CONTAINS_TEXT", 4);
        CONTAINS_TEXT = r7;
        ConditionFilterType r9 = new ConditionFilterType("NOT_CONTAINS_TEXT", 5);
        NOT_CONTAINS_TEXT = r9;
        ConditionFilterType r11 = new ConditionFilterType("BEGINS_WITH", 6);
        BEGINS_WITH = r11;
        ConditionFilterType r13 = new ConditionFilterType("ENDS_WITH", 7);
        ENDS_WITH = r13;
        ConditionFilterType r15 = new ConditionFilterType("CONTAINS_BLANKS", 8);
        CONTAINS_BLANKS = r15;
        ConditionFilterType r14 = new ConditionFilterType("NOT_CONTAINS_BLANKS", 9);
        NOT_CONTAINS_BLANKS = r14;
        ConditionFilterType r12 = new ConditionFilterType("CONTAINS_ERRORS", 10);
        CONTAINS_ERRORS = r12;
        ConditionFilterType r10 = new ConditionFilterType("NOT_CONTAINS_ERRORS", 11);
        NOT_CONTAINS_ERRORS = r10;
        ConditionFilterType r8 = new ConditionFilterType("TIME_PERIOD", 12);
        TIME_PERIOD = r8;
        ConditionFilterType r6 = new ConditionFilterType("ABOVE_AVERAGE", 13);
        ABOVE_AVERAGE = r6;
        $VALUES = new ConditionFilterType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
    }

    private ConditionFilterType(String r1, int r2) {
        super(r1, r2);
    }

    public static ConditionFilterType valueOf(String r2) {
        return (ConditionFilterType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConditionFilterType.class, r2), ConditionFilterType.class, "com.obric.memorydata.plugin");
    }

    public static ConditionFilterType[] values() {
        return (ConditionFilterType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConditionFilterType[].class, "com.obric.memorydata.plugin");
    }
}
