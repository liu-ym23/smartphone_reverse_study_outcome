package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum WriteTypeEnum extends Enum<WriteTypeEnum> {
    private static final /* synthetic */ WriteTypeEnum[] $VALUES = null;
    public static final WriteTypeEnum ADD = null;
    public static final WriteTypeEnum FILL = null;

    static {
        WriteTypeEnum r0 = new WriteTypeEnum("ADD", 0);
        ADD = r0;
        WriteTypeEnum r1 = new WriteTypeEnum("FILL", 1);
        FILL = r1;
        $VALUES = new WriteTypeEnum[]{r0, r1};
    }

    private WriteTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static WriteTypeEnum valueOf(String r2) {
        return (WriteTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(WriteTypeEnum.class, r2), WriteTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static WriteTypeEnum[] values() {
        return (WriteTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WriteTypeEnum[].class, "com.obric.memorydata.plugin");
    }
}
