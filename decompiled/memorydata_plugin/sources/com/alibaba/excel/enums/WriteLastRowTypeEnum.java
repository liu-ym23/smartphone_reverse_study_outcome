package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum WriteLastRowTypeEnum extends Enum<WriteLastRowTypeEnum> {
    private static final /* synthetic */ WriteLastRowTypeEnum[] $VALUES = null;
    public static final WriteLastRowTypeEnum COMMON_EMPTY = null;
    public static final WriteLastRowTypeEnum HAS_DATA = null;
    public static final WriteLastRowTypeEnum TEMPLATE_EMPTY = null;

    static {
        WriteLastRowTypeEnum r0 = new WriteLastRowTypeEnum("COMMON_EMPTY", 0);
        COMMON_EMPTY = r0;
        WriteLastRowTypeEnum r1 = new WriteLastRowTypeEnum("TEMPLATE_EMPTY", 1);
        TEMPLATE_EMPTY = r1;
        WriteLastRowTypeEnum r3 = new WriteLastRowTypeEnum("HAS_DATA", 2);
        HAS_DATA = r3;
        $VALUES = new WriteLastRowTypeEnum[]{r0, r1, r3};
    }

    private WriteLastRowTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static WriteLastRowTypeEnum valueOf(String r2) {
        return (WriteLastRowTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(WriteLastRowTypeEnum.class, r2), WriteLastRowTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static WriteLastRowTypeEnum[] values() {
        return (WriteLastRowTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WriteLastRowTypeEnum[].class, "com.obric.memorydata.plugin");
    }
}
