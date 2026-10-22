package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum RowTypeEnum extends Enum<RowTypeEnum> {
    private static final /* synthetic */ RowTypeEnum[] $VALUES = null;
    public static final RowTypeEnum DATA = null;
    public static final RowTypeEnum EMPTY = null;

    static {
        RowTypeEnum r0 = new RowTypeEnum("DATA", 0);
        DATA = r0;
        RowTypeEnum r1 = new RowTypeEnum("EMPTY", 1);
        EMPTY = r1;
        $VALUES = new RowTypeEnum[]{r0, r1};
    }

    private RowTypeEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static RowTypeEnum valueOf(String r2) {
        return (RowTypeEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(RowTypeEnum.class, r2), RowTypeEnum.class, "com.obric.memorydata.plugin");
    }

    public static RowTypeEnum[] values() {
        return (RowTypeEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RowTypeEnum[].class, "com.obric.memorydata.plugin");
    }
}
