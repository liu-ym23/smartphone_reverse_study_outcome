package com.bytedance.bdinstall.dtrait.constant;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum DTraitEnum extends Enum<DTraitEnum> {
    private static final /* synthetic */ DTraitEnum[] $VALUES = null;
    public static final DTraitEnum COLLECT = null;
    public static final DTraitEnum FACTOR = null;

    static {
        DTraitEnum r0 = new DTraitEnum("COLLECT", 0);
        COLLECT = r0;
        DTraitEnum r1 = new DTraitEnum("FACTOR", 1);
        FACTOR = r1;
        $VALUES = new DTraitEnum[]{r0, r1};
    }

    private DTraitEnum(String r1, int r2) {
        super(r1, r2);
    }

    public static DTraitEnum valueOf(String r2) {
        return (DTraitEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(DTraitEnum.class, r2), DTraitEnum.class, "com.obric.memorydata.plugin");
    }

    public static DTraitEnum[] values() {
        return (DTraitEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DTraitEnum[].class, "com.obric.memorydata.plugin");
    }
}
