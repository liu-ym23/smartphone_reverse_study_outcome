package com.bytedance.bdinstall.dtrait.constant;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum DTraitRiskType extends Enum<DTraitRiskType> {
    private static final /* synthetic */ DTraitRiskType[] $VALUES = null;
    public static final DTraitRiskType HIGH = null;
    public static final DTraitRiskType LOW = null;
    private final String value;

    static {
        DTraitRiskType r0 = new DTraitRiskType("HIGH", 0, "HIGH");
        HIGH = r0;
        DTraitRiskType r1 = new DTraitRiskType("LOW", 1, "LOW");
        LOW = r1;
        $VALUES = new DTraitRiskType[]{r0, r1};
    }

    private DTraitRiskType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static DTraitRiskType valueOf(String r2) {
        return (DTraitRiskType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DTraitRiskType.class, r2), DTraitRiskType.class, "com.obric.memorydata.plugin");
    }

    public static DTraitRiskType[] values() {
        return (DTraitRiskType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DTraitRiskType[].class, "com.obric.memorydata.plugin");
    }

    public String getValue() {
        return this.value;
    }
}
