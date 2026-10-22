package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum Side extends Enum<Side> {
    private static final /* synthetic */ Side[] $VALUES = null;
    public static final Side BOTH = null;
    public static final Side HYPER = null;
    public static final Side MINUS = null;
    public static final Side PLUS = null;

    static {
        Side r0 = new Side("PLUS", 0);
        PLUS = r0;
        Side r1 = new Side("MINUS", 1);
        MINUS = r1;
        Side r3 = new Side("BOTH", 2);
        BOTH = r3;
        Side r5 = new Side("HYPER", 3);
        HYPER = r5;
        $VALUES = new Side[]{r0, r1, r3, r5};
    }

    private Side(String r1, int r2) {
        super(r1, r2);
    }

    public static Side valueOf(String r2) {
        return (Side) ZeusTransformUtils.preCheckCast(Enum.valueOf(Side.class, r2), Side.class, "com.obric.memorydata.plugin");
    }

    public static Side[] values() {
        return (Side[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Side[].class, "com.obric.memorydata.plugin");
    }
}
