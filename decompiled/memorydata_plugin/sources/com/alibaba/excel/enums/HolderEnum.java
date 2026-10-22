package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum HolderEnum extends Enum<HolderEnum> {
    private static final /* synthetic */ HolderEnum[] $VALUES = null;
    public static final HolderEnum ROW = null;
    public static final HolderEnum SHEET = null;
    public static final HolderEnum TABLE = null;
    public static final HolderEnum WORKBOOK = null;

    static {
        HolderEnum r0 = new HolderEnum("WORKBOOK", 0);
        WORKBOOK = r0;
        HolderEnum r1 = new HolderEnum("SHEET", 1);
        SHEET = r1;
        HolderEnum r3 = new HolderEnum("TABLE", 2);
        TABLE = r3;
        HolderEnum r5 = new HolderEnum("ROW", 3);
        ROW = r5;
        $VALUES = new HolderEnum[]{r0, r1, r3, r5};
    }

    private HolderEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static HolderEnum valueOf(String r2) {
        return (HolderEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(HolderEnum.class, r2), HolderEnum.class, "com.obric.memorydata.plugin");
    }

    public static HolderEnum[] values() {
        return (HolderEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HolderEnum[].class, "com.obric.memorydata.plugin");
    }
}
