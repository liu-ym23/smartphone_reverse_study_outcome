package org.apache.commons.math3.optim.nonlinear.scalar.gradient;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.optim.nonlinear.scalar.GradientMultivariateOptimizer;

/* JADX INFO: loaded from: classes6.dex */
public class NonLinearConjugateGradientOptimizer extends GradientMultivariateOptimizer {

    public static final enum Formula extends Enum<Formula> {
        private static final /* synthetic */ Formula[] $VALUES = null;
        public static final Formula FLETCHER_REEVES = null;
        public static final Formula POLAK_RIBIERE = null;

        static {
            Formula r0 = new Formula("FLETCHER_REEVES", 0);
            FLETCHER_REEVES = r0;
            Formula r1 = new Formula("POLAK_RIBIERE", 1);
            POLAK_RIBIERE = r1;
            $VALUES = new Formula[]{r0, r1};
        }

        private Formula(String r1, int r2) {
            super(r1, r2);
        }

        public static Formula valueOf(String r2) {
            return (Formula) ZeusTransformUtils.preCheckCast(Enum.valueOf(Formula.class, r2), Formula.class, "com.obric.memorydata.plugin");
        }

        public static Formula[] values() {
            return (Formula[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Formula[].class, "com.obric.memorydata.plugin");
        }
    }
}
