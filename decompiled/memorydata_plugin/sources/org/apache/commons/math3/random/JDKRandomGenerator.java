package org.apache.commons.math3.random;

import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class JDKRandomGenerator extends Random implements RandomGenerator {
    private static final long serialVersionUID = -7745277476784028798L;

    public JDKRandomGenerator() {
    }

    public JDKRandomGenerator(int r1) {
        setSeed(r1);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int r3) {
        setSeed(r3);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] r3) {
        setSeed(RandomGeneratorFactory.convertToLong(r3));
    }
}
