package org.apache.commons.math3.transform;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum DctNormalization extends Enum<DctNormalization> {
    private static final /* synthetic */ DctNormalization[] $VALUES = null;
    public static final DctNormalization ORTHOGONAL_DCT_I = null;
    public static final DctNormalization STANDARD_DCT_I = null;

    static {
        DctNormalization r0 = new DctNormalization("STANDARD_DCT_I", 0);
        STANDARD_DCT_I = r0;
        DctNormalization r1 = new DctNormalization("ORTHOGONAL_DCT_I", 1);
        ORTHOGONAL_DCT_I = r1;
        $VALUES = new DctNormalization[]{r0, r1};
    }

    private DctNormalization(String r1, int r2) {
        super(r1, r2);
    }

    public static DctNormalization valueOf(String r2) {
        return (DctNormalization) ZeusTransformUtils.preCheckCast(Enum.valueOf(DctNormalization.class, r2), DctNormalization.class, "com.obric.memorydata.plugin");
    }

    public static DctNormalization[] values() {
        return (DctNormalization[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DctNormalization[].class, "com.obric.memorydata.plugin");
    }
}
