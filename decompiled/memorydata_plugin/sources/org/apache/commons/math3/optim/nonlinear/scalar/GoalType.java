package org.apache.commons.math3.optim.nonlinear.scalar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum GoalType extends Enum<GoalType> {
    private static final /* synthetic */ GoalType[] $VALUES = null;
    public static final GoalType MAXIMIZE = null;
    public static final GoalType MINIMIZE = null;

    static {
        GoalType r0 = new GoalType("MAXIMIZE", 0);
        MAXIMIZE = r0;
        GoalType r1 = new GoalType("MINIMIZE", 1);
        MINIMIZE = r1;
        $VALUES = new GoalType[]{r0, r1};
    }

    private GoalType(String r1, int r2) {
        super(r1, r2);
    }

    public static GoalType valueOf(String r2) {
        return (GoalType) ZeusTransformUtils.preCheckCast(Enum.valueOf(GoalType.class, r2), GoalType.class, "com.obric.memorydata.plugin");
    }

    public static GoalType[] values() {
        return (GoalType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GoalType[].class, "com.obric.memorydata.plugin");
    }
}
