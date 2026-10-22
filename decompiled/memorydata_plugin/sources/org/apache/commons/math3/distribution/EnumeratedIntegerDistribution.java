package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class EnumeratedIntegerDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 20130308;
    protected final EnumeratedDistribution<Integer> innerDistribution;

    public EnumeratedIntegerDistribution(RandomGenerator r10, int[] r11) {
        RandomGenerator r12 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r10, RandomGenerator.class, "com.obric.memorydata.plugin");
        super(r12);
        HashMap r0 = new HashMap();
        int r2 = r11.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        int r5 = r11[r4];
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r5)), Integer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        r6 = 0;
    L7:
        r0.put(Integer.valueOf(r5), Integer.valueOf(r6.intValue() + 1));
        r4 = r4 + 1;
        goto L3
    L8:
        int r7 = r0.size();
        double r8 = r11.length;
        int[] r13 = new int[r7];
        double[] r9 = new double[r7];
        Iterator r1 = r0.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r13[r3] = ((Integer) ZeusTransformUtils.preCheckCast(r14.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r9[r3] = ((double) ((Integer) ZeusTransformUtils.preCheckCast(r14.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue()) / r8;
        r3 = r3 + 1;
        goto L10
    L12:
        this.innerDistribution = new EnumeratedDistribution(r12, createDistribution(r13, r9));
    }

    public EnumeratedIntegerDistribution(RandomGenerator r3, int[] r4, double[] r5) {
        RandomGenerator r6 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin");
        super(r6);
        this.innerDistribution = new EnumeratedDistribution(r6, createDistribution(r4, r5));
    }

    public EnumeratedIntegerDistribution(int[] r2) {
        this(new Well19937c(), r2);
    }

    public EnumeratedIntegerDistribution(int[] r2, double[] r3) {
        this(new Well19937c(), r2, r3);
    }

    private static List<Pair<Integer, Double>> createDistribution(int[] r6, double[] r7) {
        if (r6.length != r7.length) goto L10;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L8;
        r0.add(new Pair(Integer.valueOf(r6[r1]), Double.valueOf(r7[r1])));
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        throw new DimensionMismatchException(r7.length, r6.length);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int r7) {
        Iterator<Pair<Integer, Double>> r6 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
    L4:
        if (r6.hasNext() == false) goto L8;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() > r7) goto L4;
        r0 = r0 + ((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L4
    L8:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        Iterator<Pair<Integer, Double>> r7 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L6;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin");
        r0 = r0 + (((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() * ((double) ((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue()));
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        Iterator<Pair<Integer, Double>> r11 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
        double r2 = 0.0d;
    L4:
        if (r11.hasNext() == false) goto L7;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r11.next(), Pair.class, "com.obric.memorydata.plugin");
        r2 = r2 + (((Double) ZeusTransformUtils.preCheckCast(r4.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() * ((double) ((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue()));
        r0 = r0 + ((((Double) ZeusTransformUtils.preCheckCast(r4.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() * ((double) ((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue())) * ((double) ((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue()));
        goto L4
    L7:
        return r0 - (r2 * r2);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        Iterator<Pair<Integer, Double>> r8 = this.innerDistribution.getPmf().iterator();
        int r0 = Integer.MAX_VALUE;
    L4:
        if (r8.hasNext() == false) goto L10;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() >= r0) goto L4;
        if (((Double) ZeusTransformUtils.preCheckCast(r1.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() <= 0.0d) goto L4;
        r0 = ((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        Iterator<Pair<Integer, Double>> r8 = this.innerDistribution.getPmf().iterator();
        int r0 = Integer.MIN_VALUE;
    L4:
        if (r8.hasNext() == false) goto L10;
        Pair r1 = (Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue() <= r0) goto L4;
        if (((Double) ZeusTransformUtils.preCheckCast(r1.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() <= 0.0d) goto L4;
        r0 = ((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L4
    L10:
        return r0;
    }

    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int r1) {
        return this.innerDistribution.probability(Integer.valueOf(r1));
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public int sample() {
        return ((Integer) ZeusTransformUtils.preCheckCast(this.innerDistribution.sample(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }
}
