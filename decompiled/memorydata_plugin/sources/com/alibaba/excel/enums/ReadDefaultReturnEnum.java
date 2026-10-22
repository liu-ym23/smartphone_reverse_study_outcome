package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum ReadDefaultReturnEnum extends Enum<ReadDefaultReturnEnum> {
    private static final /* synthetic */ ReadDefaultReturnEnum[] $VALUES = null;
    public static final ReadDefaultReturnEnum ACTUAL_DATA = null;
    public static final ReadDefaultReturnEnum READ_CELL_DATA = null;
    public static final ReadDefaultReturnEnum STRING = null;

    static {
        ReadDefaultReturnEnum r0 = new ReadDefaultReturnEnum("STRING", 0);
        STRING = r0;
        ReadDefaultReturnEnum r1 = new ReadDefaultReturnEnum("ACTUAL_DATA", 1);
        ACTUAL_DATA = r1;
        ReadDefaultReturnEnum r3 = new ReadDefaultReturnEnum("READ_CELL_DATA", 2);
        READ_CELL_DATA = r3;
        $VALUES = new ReadDefaultReturnEnum[]{r0, r1, r3};
    }

    private ReadDefaultReturnEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static ReadDefaultReturnEnum valueOf(String r2) {
        return (ReadDefaultReturnEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReadDefaultReturnEnum.class, r2), ReadDefaultReturnEnum.class, "com.obric.memorydata.plugin");
    }

    public static ReadDefaultReturnEnum[] values() {
        return (ReadDefaultReturnEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReadDefaultReturnEnum[].class, "com.obric.memorydata.plugin");
    }
}
