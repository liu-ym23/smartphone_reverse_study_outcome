package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum WriteDirectionEnum extends Enum<WriteDirectionEnum> {
    private static final /* synthetic */ WriteDirectionEnum[] $VALUES = null;
    public static final WriteDirectionEnum HORIZONTAL = null;
    public static final WriteDirectionEnum VERTICAL = null;

    static {
        WriteDirectionEnum r0 = new WriteDirectionEnum("VERTICAL", 0);
        VERTICAL = r0;
        WriteDirectionEnum r1 = new WriteDirectionEnum("HORIZONTAL", 1);
        HORIZONTAL = r1;
        $VALUES = new WriteDirectionEnum[]{r0, r1};
    }

    private WriteDirectionEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static WriteDirectionEnum valueOf(String r2) {
        return (WriteDirectionEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(WriteDirectionEnum.class, r2), WriteDirectionEnum.class, "com.obric.memorydata.plugin");
    }

    public static WriteDirectionEnum[] values() {
        return (WriteDirectionEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WriteDirectionEnum[].class, "com.obric.memorydata.plugin");
    }
}
