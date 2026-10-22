package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum HeadKindEnum extends Enum<HeadKindEnum> {
    private static final /* synthetic */ HeadKindEnum[] $VALUES = null;
    public static final HeadKindEnum CLASS = null;
    public static final HeadKindEnum NONE = null;
    public static final HeadKindEnum STRING = null;

    static {
        HeadKindEnum r0 = new HeadKindEnum("NONE", 0);
        NONE = r0;
        HeadKindEnum r1 = new HeadKindEnum("CLASS", 1);
        CLASS = r1;
        HeadKindEnum r3 = new HeadKindEnum("STRING", 2);
        STRING = r3;
        $VALUES = new HeadKindEnum[]{r0, r1, r3};
    }

    private HeadKindEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static HeadKindEnum valueOf(String r2) {
        return (HeadKindEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(HeadKindEnum.class, r2), HeadKindEnum.class, "com.obric.memorydata.plugin");
    }

    public static HeadKindEnum[] values() {
        return (HeadKindEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HeadKindEnum[].class, "com.obric.memorydata.plugin");
    }
}
