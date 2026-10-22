package com.alibaba.excel.enums;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum BooleanEnum extends Enum<BooleanEnum> {
    private static final /* synthetic */ BooleanEnum[] $VALUES = null;
    public static final BooleanEnum DEFAULT = null;
    public static final BooleanEnum FALSE = null;
    public static final BooleanEnum TRUE = null;
    Boolean booleanValue;

    static {
        BooleanEnum r0 = new BooleanEnum("DEFAULT", 0, null);
        DEFAULT = r0;
        BooleanEnum r1 = new BooleanEnum("TRUE", 1, Boolean.TRUE);
        TRUE = r1;
        BooleanEnum r3 = new BooleanEnum("FALSE", 2, Boolean.FALSE);
        FALSE = r3;
        $VALUES = new BooleanEnum[]{r0, r1, r3};
    }

    private BooleanEnum(String r1, int r2, Boolean r3) {
        super(r1, r2);
        this.booleanValue = r3;
    }

    public static BooleanEnum valueOf(String r2) {
        return (BooleanEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(BooleanEnum.class, r2), BooleanEnum.class, "com.obric.memorydata.plugin");
    }

    public static BooleanEnum[] values() {
        return (BooleanEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BooleanEnum[].class, "com.obric.memorydata.plugin");
    }

    public Boolean getBooleanValue() {
        return this.booleanValue;
    }
}
