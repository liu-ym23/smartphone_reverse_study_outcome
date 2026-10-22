package org.apache.commons.math3.geometry.euclidean.threed;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum RotationConvention extends Enum<RotationConvention> {
    private static final /* synthetic */ RotationConvention[] $VALUES = null;
    public static final RotationConvention FRAME_TRANSFORM = null;
    public static final RotationConvention VECTOR_OPERATOR = null;

    static {
        RotationConvention r0 = new RotationConvention("VECTOR_OPERATOR", 0);
        VECTOR_OPERATOR = r0;
        RotationConvention r1 = new RotationConvention("FRAME_TRANSFORM", 1);
        FRAME_TRANSFORM = r1;
        $VALUES = new RotationConvention[]{r0, r1};
    }

    private RotationConvention(String r1, int r2) {
        super(r1, r2);
    }

    public static RotationConvention valueOf(String r2) {
        return (RotationConvention) ZeusTransformUtils.preCheckCast(Enum.valueOf(RotationConvention.class, r2), RotationConvention.class, "com.obric.memorydata.plugin");
    }

    public static RotationConvention[] values() {
        return (RotationConvention[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RotationConvention[].class, "com.obric.memorydata.plugin");
    }
}
