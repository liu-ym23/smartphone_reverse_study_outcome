package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum NumericCellTypeEnum extends Enum<NumericCellTypeEnum> {
    private static final /* synthetic */ NumericCellTypeEnum[] $VALUES = null;
    public static final NumericCellTypeEnum DATE = null;
    public static final NumericCellTypeEnum NUMBER = null;

    static {
        NumericCellTypeEnum r0 = new NumericCellTypeEnum("NUMBER", 0);
        NUMBER = r0;
        NumericCellTypeEnum r1 = new NumericCellTypeEnum("DATE", 1);
        DATE = r1;
        $VALUES = new NumericCellTypeEnum[]{r0, r1};
    }

    private NumericCellTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static NumericCellTypeEnum valueOf(String r2) {
        return (NumericCellTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(NumericCellTypeEnum.class, r2), NumericCellTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static NumericCellTypeEnum[] values() {
        return (NumericCellTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NumericCellTypeEnum[].class, "com.obric.memorydata.plugin");
    }
}
