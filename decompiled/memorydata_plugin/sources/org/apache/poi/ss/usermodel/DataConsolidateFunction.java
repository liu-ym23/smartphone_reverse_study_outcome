package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum DataConsolidateFunction extends Enum<DataConsolidateFunction> {
    private static final /* synthetic */ DataConsolidateFunction[] $VALUES = null;
    public static final DataConsolidateFunction AVERAGE = null;
    public static final DataConsolidateFunction COUNT = null;
    public static final DataConsolidateFunction COUNT_NUMS = null;
    public static final DataConsolidateFunction MAX = null;
    public static final DataConsolidateFunction MIN = null;
    public static final DataConsolidateFunction PRODUCT = null;
    public static final DataConsolidateFunction STD_DEV = null;
    public static final DataConsolidateFunction STD_DEVP = null;
    public static final DataConsolidateFunction SUM = null;
    public static final DataConsolidateFunction VAR = null;
    public static final DataConsolidateFunction VARP = null;
    private final String name;
    private final int value;

    static {
        DataConsolidateFunction r0 = new DataConsolidateFunction("AVERAGE", 0, 1, "Average");
        AVERAGE = r0;
        DataConsolidateFunction r1 = new DataConsolidateFunction("COUNT", 1, 2, "Count");
        COUNT = r1;
        DataConsolidateFunction r4 = new DataConsolidateFunction("COUNT_NUMS", 2, 3, "Count");
        COUNT_NUMS = r4;
        DataConsolidateFunction r6 = new DataConsolidateFunction("MAX", 3, 4, "Max");
        MAX = r6;
        DataConsolidateFunction r7 = new DataConsolidateFunction("MIN", 4, 5, "Min");
        MIN = r7;
        DataConsolidateFunction r10 = new DataConsolidateFunction("PRODUCT", 5, 6, "Product");
        PRODUCT = r10;
        DataConsolidateFunction r12 = new DataConsolidateFunction("STD_DEV", 6, 7, "StdDev");
        STD_DEV = r12;
        DataConsolidateFunction r11 = new DataConsolidateFunction("STD_DEVP", 7, 8, "StdDevp");
        STD_DEVP = r11;
        DataConsolidateFunction r9 = new DataConsolidateFunction("SUM", 8, 9, "Sum");
        SUM = r9;
        DataConsolidateFunction r8 = new DataConsolidateFunction("VAR", 9, 10, "Var");
        VAR = r8;
        DataConsolidateFunction r5 = new DataConsolidateFunction("VARP", 10, 11, "Varp");
        VARP = r5;
        $VALUES = new DataConsolidateFunction[]{r0, r1, r4, r6, r7, r10, r12, r11, r9, r8, r5};
    }

    private DataConsolidateFunction(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.name = r4;
    }

    public static DataConsolidateFunction valueOf(String r2) {
        return (DataConsolidateFunction) ZeusTransformUtils.preCheckCast(Enum.valueOf(DataConsolidateFunction.class, r2), DataConsolidateFunction.class, "com.obric.memorydata.plugin");
    }

    public static DataConsolidateFunction[] values() {
        return (DataConsolidateFunction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DataConsolidateFunction[].class, "com.obric.memorydata.plugin");
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
