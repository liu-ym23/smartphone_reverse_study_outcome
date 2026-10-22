package org.apache.commons.math3.optim.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum PivotSelectionRule extends Enum<PivotSelectionRule> {
    private static final /* synthetic */ PivotSelectionRule[] $VALUES = null;
    public static final PivotSelectionRule BLAND = null;
    public static final PivotSelectionRule DANTZIG = null;

    static {
        PivotSelectionRule r0 = new PivotSelectionRule("DANTZIG", 0);
        DANTZIG = r0;
        PivotSelectionRule r1 = new PivotSelectionRule("BLAND", 1);
        BLAND = r1;
        $VALUES = new PivotSelectionRule[]{r0, r1};
    }

    private PivotSelectionRule(String r1, int r2) {
        super(r1, r2);
    }

    public static PivotSelectionRule valueOf(String r2) {
        return (PivotSelectionRule) ZeusTransformUtils.preCheckCast(Enum.valueOf(PivotSelectionRule.class, r2), PivotSelectionRule.class, "com.obric.memorydata.plugin");
    }

    public static PivotSelectionRule[] values() {
        return (PivotSelectionRule[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PivotSelectionRule[].class, "com.obric.memorydata.plugin");
    }
}
