package org.apache.commons.math3.optimization.general;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final enum ConjugateGradientFormula extends Enum<ConjugateGradientFormula> {
    private static final /* synthetic */ ConjugateGradientFormula[] $VALUES = null;
    public static final ConjugateGradientFormula FLETCHER_REEVES = null;
    public static final ConjugateGradientFormula POLAK_RIBIERE = null;

    static {
        ConjugateGradientFormula r0 = new ConjugateGradientFormula("FLETCHER_REEVES", 0);
        FLETCHER_REEVES = r0;
        ConjugateGradientFormula r1 = new ConjugateGradientFormula("POLAK_RIBIERE", 1);
        POLAK_RIBIERE = r1;
        $VALUES = new ConjugateGradientFormula[]{r0, r1};
    }

    private ConjugateGradientFormula(String r1, int r2) {
        super(r1, r2);
    }

    public static ConjugateGradientFormula valueOf(String r2) {
        return (ConjugateGradientFormula) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConjugateGradientFormula.class, r2), ConjugateGradientFormula.class, "com.obric.memorydata.plugin");
    }

    public static ConjugateGradientFormula[] values() {
        return (ConjugateGradientFormula[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConjugateGradientFormula[].class, "com.obric.memorydata.plugin");
    }
}
