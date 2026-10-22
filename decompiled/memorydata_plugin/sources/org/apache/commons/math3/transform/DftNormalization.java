package org.apache.commons.math3.transform;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum DftNormalization extends Enum<DftNormalization> {
    private static final /* synthetic */ DftNormalization[] $VALUES = null;
    public static final DftNormalization STANDARD = null;
    public static final DftNormalization UNITARY = null;

    static {
        DftNormalization r0 = new DftNormalization("STANDARD", 0);
        STANDARD = r0;
        DftNormalization r1 = new DftNormalization("UNITARY", 1);
        UNITARY = r1;
        $VALUES = new DftNormalization[]{r0, r1};
    }

    private DftNormalization(String r1, int r2) {
        super(r1, r2);
    }

    public static DftNormalization valueOf(String r2) {
        return (DftNormalization) ZeusTransformUtils.preCheckCast(Enum.valueOf(DftNormalization.class, r2), DftNormalization.class, "com.obric.memorydata.plugin");
    }

    public static DftNormalization[] values() {
        return (DftNormalization[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DftNormalization[].class, "com.obric.memorydata.plugin");
    }
}
