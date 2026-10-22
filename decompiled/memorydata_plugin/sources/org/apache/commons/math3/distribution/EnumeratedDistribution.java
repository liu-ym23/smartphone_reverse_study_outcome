package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class EnumeratedDistribution<T> implements Serializable {
    private static final long serialVersionUID = 20123308;
    private final double[] cumulativeProbabilities;
    private final double[] probabilities;
    protected final RandomGenerator random;
    private final List<T> singletons;

    public EnumeratedDistribution(List<Pair<T, Double>> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this(new Well19937c(), r4);
    }

    public EnumeratedDistribution(RandomGenerator r9, List<Pair<T, Double>> r10) {
        RandomGenerator r11 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r9, RandomGenerator.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        this.random = r11;
        this.singletons = new ArrayList(r12.size());
        double[] r13 = new double[r12.size()];
        int r0 = 0;
        int r2 = 0;
    L3:
        double r4 = 0.0d;
        if (r2 >= r12.size()) goto L18;
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r12.get(r2), Pair.class, "com.obric.memorydata.plugin");
        this.singletons.add((T) r3.getKey());
        double r6 = ((Double) ZeusTransformUtils.preCheckCast(r3.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r6 < 0.0d) goto L17;
        if (Double.isInfinite(r6) == true) goto L15;
        if (Double.isNaN(r6) == true) goto L13;
        r13[r2] = r6;
        r2 = r2 + 1;
        goto L3
    L13:
        throw new NotANumberException();
    L15:
        throw new NotFiniteNumberException(Double.valueOf(r6), new Object[0]);
    L17:
        throw new NotPositiveException((Number) ZeusTransformUtils.preCheckCast(r3.getValue(), Number.class, "com.obric.memorydata.plugin"));
    L18:
        double[] r14 = MathArrays.normalizeArray(r13, 1.0d);
        this.probabilities = r14;
        this.cumulativeProbabilities = new double[r14.length];
    L19:
        double[] r15 = this.probabilities;
        if (r0 >= r15.length) goto L22;
        r4 = r4 + r15[r0];
        this.cumulativeProbabilities[r0] = r4;
        r0 = r0 + 1;
        goto L19
    }

    public List<Pair<T, Double>> getPmf() {
        ArrayList r0 = new ArrayList(this.probabilities.length);
        int r1 = 0;
    L4:
        if (r1 >= this.probabilities.length) goto L6;
        r0.add(new Pair(this.singletons.get(r1), Double.valueOf(this.probabilities[r1])));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    double probability(T r6) {
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= this.probabilities.length) goto L13;
        if (r6 == null) goto L7;
    L8:
        if (r6 == null) goto L12;
        if (r6.equals(this.singletons.get(r2)) == false) goto L12;
    L11:
        r0 = r0 + this.probabilities[r2];
    L12:
        r2 = r2 + 1;
        goto L4
    L7:
        if (this.singletons.get(r2) == null) goto L11;
    L13:
        return r0;
    }

    public void reseedRandomGenerator(long r1) {
        this.random.setSeed(r1);
    }

    public T sample() {
        double r0 = this.random.nextDouble();
        int r2 = Arrays.binarySearch(this.cumulativeProbabilities, r0);
        if (r2 >= 0) goto L5;
        r2 = (-r2) - 1;
    L5:
        if (r2 >= 0) goto L7;
    L12:
        List<T> r5 = this.singletons;
        return r5.get(r5.size() - 1);
    L7:
        if (r2 >= this.probabilities.length) goto L12;
        if (r0 >= this.cumulativeProbabilities[r2]) goto L12;
        return this.singletons.get(r2);
    }

    public Object[] sample(int r4) {
        if (r4 <= 0) goto L8;
        Object[] r0 = new Object[r4];
        int r1 = 0;
    L4:
        if (r1 >= r4) goto L6;
        r0[r1] = sample();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    L8:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r4));
    }

    public T[] sample(int r4, T[] r5) {
        if (r4 <= 0) goto L14;
        int r0 = 0;
        if (r5 == null) goto L12;
        if (r5.length >= r4) goto L8;
        r5 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r5.getClass().getComponentType(), r4), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
    L8:
        if (r0 >= r4) goto L10;
        T[] r6 = r5;
        r6[r0] = sample();
        r0 = r0 + 1;
        goto L8
    L10:
        return r5;
    L12:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    L14:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r4));
    }
}
