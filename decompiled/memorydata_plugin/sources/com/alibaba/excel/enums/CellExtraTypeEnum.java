package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum CellExtraTypeEnum extends Enum<CellExtraTypeEnum> {
    private static final /* synthetic */ CellExtraTypeEnum[] $VALUES = null;
    public static final CellExtraTypeEnum COMMENT = null;
    public static final CellExtraTypeEnum HYPERLINK = null;
    public static final CellExtraTypeEnum MERGE = null;

    static {
        CellExtraTypeEnum r0 = new CellExtraTypeEnum("COMMENT", 0);
        COMMENT = r0;
        CellExtraTypeEnum r1 = new CellExtraTypeEnum("HYPERLINK", 1);
        HYPERLINK = r1;
        CellExtraTypeEnum r3 = new CellExtraTypeEnum("MERGE", 2);
        MERGE = r3;
        $VALUES = new CellExtraTypeEnum[]{r0, r1, r3};
    }

    private CellExtraTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static CellExtraTypeEnum valueOf(String r2) {
        return (CellExtraTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(CellExtraTypeEnum.class, r2), CellExtraTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static CellExtraTypeEnum[] values() {
        return (CellExtraTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CellExtraTypeEnum[].class, "com.obric.memorydata.plugin");
    }
}
