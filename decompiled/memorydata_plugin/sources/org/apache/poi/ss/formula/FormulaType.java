package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum FormulaType extends Enum<FormulaType> {
    private static final /* synthetic */ FormulaType[] $VALUES = null;
    public static final FormulaType ARRAY = null;
    public static final FormulaType CELL = null;
    public static final FormulaType CONDFORMAT = null;
    public static final FormulaType DATAVALIDATION_LIST = null;
    public static final FormulaType NAMEDRANGE = null;
    public static final FormulaType SHARED = null;
    private final boolean isSingleValue;

    static {
        FormulaType r0 = new FormulaType("CELL", 0, true);
        CELL = r0;
        FormulaType r1 = new FormulaType("SHARED", 1, true);
        SHARED = r1;
        FormulaType r4 = new FormulaType("ARRAY", 2, false);
        ARRAY = r4;
        FormulaType r5 = new FormulaType("CONDFORMAT", 3, true);
        CONDFORMAT = r5;
        FormulaType r7 = new FormulaType("NAMEDRANGE", 4, false);
        NAMEDRANGE = r7;
        FormulaType r9 = new FormulaType("DATAVALIDATION_LIST", 5, false);
        DATAVALIDATION_LIST = r9;
        $VALUES = new FormulaType[]{r0, r1, r4, r5, r7, r9};
    }

    private FormulaType(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.isSingleValue = r3;
    }

    public static FormulaType forInt(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= values().length) goto L8;
        return values()[r3];
    L8:
        throw new IllegalArgumentException("Invalid FormulaType code: " + r3);
    }

    public static FormulaType valueOf(String r2) {
        return (FormulaType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FormulaType.class, r2), FormulaType.class, "com.obric.memorydata.plugin");
    }

    public static FormulaType[] values() {
        return (FormulaType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FormulaType[].class, "com.obric.memorydata.plugin");
    }

    public boolean isSingleValue() {
        return this.isSingleValue;
    }
}
