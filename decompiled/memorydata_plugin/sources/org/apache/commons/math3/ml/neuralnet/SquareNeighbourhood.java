package org.apache.commons.math3.ml.neuralnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum SquareNeighbourhood extends Enum<SquareNeighbourhood> {
    private static final /* synthetic */ SquareNeighbourhood[] $VALUES = null;
    public static final SquareNeighbourhood MOORE = null;
    public static final SquareNeighbourhood VON_NEUMANN = null;

    static {
        SquareNeighbourhood r0 = new SquareNeighbourhood("VON_NEUMANN", 0);
        VON_NEUMANN = r0;
        SquareNeighbourhood r1 = new SquareNeighbourhood("MOORE", 1);
        MOORE = r1;
        $VALUES = new SquareNeighbourhood[]{r0, r1};
    }

    private SquareNeighbourhood(String r1, int r2) {
        super(r1, r2);
    }

    public static SquareNeighbourhood valueOf(String r2) {
        return (SquareNeighbourhood) ZeusTransformUtils.preCheckCast(Enum.valueOf(SquareNeighbourhood.class, r2), SquareNeighbourhood.class, "com.obric.memorydata.plugin");
    }

    public static SquareNeighbourhood[] values() {
        return (SquareNeighbourhood[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SquareNeighbourhood[].class, "com.obric.memorydata.plugin");
    }
}
