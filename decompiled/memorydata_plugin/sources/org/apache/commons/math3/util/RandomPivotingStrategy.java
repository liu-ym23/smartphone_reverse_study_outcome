package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class RandomPivotingStrategy implements Serializable, PivotingStrategyInterface {
    private static final long serialVersionUID = 20140713;
    private final RandomGenerator random;

    public RandomPivotingStrategy(RandomGenerator r3) {
        this.random = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.math3.util.PivotingStrategyInterface
    public int pivotIndex(double[] r1, int r2, int r3) {
        int r4 = r3 - r2;
        MathArrays.verifyValues(r1, r2, r4);
        return r2 + this.random.nextInt(r4 - 1);
    }
}
