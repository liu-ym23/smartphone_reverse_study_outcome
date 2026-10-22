package org.apache.commons.math3.analysis.solvers;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum AllowedSolution extends Enum<AllowedSolution> {
    private static final /* synthetic */ AllowedSolution[] $VALUES = null;
    public static final AllowedSolution ABOVE_SIDE = null;
    public static final AllowedSolution ANY_SIDE = null;
    public static final AllowedSolution BELOW_SIDE = null;
    public static final AllowedSolution LEFT_SIDE = null;
    public static final AllowedSolution RIGHT_SIDE = null;

    static {
        AllowedSolution r0 = new AllowedSolution("ANY_SIDE", 0);
        ANY_SIDE = r0;
        AllowedSolution r1 = new AllowedSolution("LEFT_SIDE", 1);
        LEFT_SIDE = r1;
        AllowedSolution r3 = new AllowedSolution("RIGHT_SIDE", 2);
        RIGHT_SIDE = r3;
        AllowedSolution r5 = new AllowedSolution("BELOW_SIDE", 3);
        BELOW_SIDE = r5;
        AllowedSolution r7 = new AllowedSolution("ABOVE_SIDE", 4);
        ABOVE_SIDE = r7;
        $VALUES = new AllowedSolution[]{r0, r1, r3, r5, r7};
    }

    private AllowedSolution(String r1, int r2) {
        super(r1, r2);
    }

    public static AllowedSolution valueOf(String r2) {
        return (AllowedSolution) ZeusTransformUtils.preCheckCast(Enum.valueOf(AllowedSolution.class, r2), AllowedSolution.class, "com.obric.memorydata.plugin");
    }

    public static AllowedSolution[] values() {
        return (AllowedSolution[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AllowedSolution[].class, "com.obric.memorydata.plugin");
    }
}
