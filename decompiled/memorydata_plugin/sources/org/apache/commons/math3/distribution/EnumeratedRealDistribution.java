package org.apache.commons.math3.distribution;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class EnumeratedRealDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20130308;
    protected final EnumeratedDistribution<Double> innerDistribution;

    public EnumeratedRealDistribution(RandomGenerator r10, double[] r11) {
        RandomGenerator r12 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r10, RandomGenerator.class, "com.obric.memorydata.plugin");
        super(r12);
        HashMap r0 = new HashMap();
        int r2 = r11.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        double r5 = r11[r4];
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(Double.valueOf(r5)), Integer.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
        r7 = 0;
    L7:
        r0.put(Double.valueOf(r5), Integer.valueOf(r7.intValue() + 1));
        r4 = r4 + 1;
        goto L3
    L8:
        int r6 = r0.size();
        double r8 = r11.length;
        double[] r13 = new double[r6];
        double[] r9 = new double[r6];
        Iterator r1 = r0.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r13[r3] = ((Double) ZeusTransformUtils.preCheckCast(r14.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        r9[r3] = ((double) ((Integer) ZeusTransformUtils.preCheckCast(r14.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue()) / r8;
        r3 = r3 + 1;
        goto L10
    L12:
        this.innerDistribution = new EnumeratedDistribution(r12, createDistribution(r13, r9));
    }

    public EnumeratedRealDistribution(RandomGenerator r3, double[] r4, double[] r5) {
        RandomGenerator r6 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin");
        super(r6);
        this.innerDistribution = new EnumeratedDistribution(r6, createDistribution(r4, r5));
    }

    public EnumeratedRealDistribution(double[] r2) {
        this(new Well19937c(), r2);
    }

    public EnumeratedRealDistribution(double[] r2, double[] r3) {
        this(new Well19937c(), r2, r3);
    }

    private static List<Pair<Double, Double>> createDistribution(double[] r6, double[] r7) {
        if (r6.length != r7.length) goto L10;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L8;
        r0.add(new Pair(Double.valueOf(r6[r1]), Double.valueOf(r7[r1])));
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        throw new DimensionMismatchException(r7.length, r6.length);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double r8) {
        Iterator<Pair<Double, Double>> r7 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L8;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin");
        if (((Double) ZeusTransformUtils.preCheckCast(r2.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue() > r8) goto L4;
        r0 = r0 + ((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L4
    L8:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double r1) {
        return probability(r1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        Iterator<Pair<Double, Double>> r7 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L6;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin");
        r0 = r0 + (((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() * ((Double) ZeusTransformUtils.preCheckCast(r2.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        Iterator<Pair<Double, Double>> r11 = this.innerDistribution.getPmf().iterator();
        double r0 = 0.0d;
        double r2 = 0.0d;
    L4:
        if (r11.hasNext() == false) goto L7;
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(r11.next(), Pair.class, "com.obric.memorydata.plugin");
        r2 = r2 + (((Double) ZeusTransformUtils.preCheckCast(r4.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() * ((Double) ZeusTransformUtils.preCheckCast(r4.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        r0 = r0 + ((((Double) ZeusTransformUtils.preCheckCast(r4.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() * ((Double) ZeusTransformUtils.preCheckCast(r4.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue()) * ((Double) ZeusTransformUtils.preCheckCast(r4.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        goto L4
    L7:
        return r0 - (r2 * r2);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        Iterator<Pair<Double, Double>> r9 = this.innerDistribution.getPmf().iterator();
        double r0 = Double.POSITIVE_INFINITY;
    L4:
        if (r9.hasNext() == false) goto L10;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");
        if (((Double) ZeusTransformUtils.preCheckCast(r2.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue() >= r0) goto L4;
        if (((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() <= 0.0d) goto L4;
        r0 = ((Double) ZeusTransformUtils.preCheckCast(r2.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        Iterator<Pair<Double, Double>> r9 = this.innerDistribution.getPmf().iterator();
        double r0 = Double.NEGATIVE_INFINITY;
    L4:
        if (r9.hasNext() == false) goto L10;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");
        if (((Double) ZeusTransformUtils.preCheckCast(r2.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue() <= r0) goto L4;
        if (((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() <= 0.0d) goto L4;
        r0 = ((Double) ZeusTransformUtils.preCheckCast(r2.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double r12) {
        if (r12 < 0.0d) goto L16;
        if (r12 > 1.0d) goto L16;
        double r2 = getSupportLowerBound();
        Iterator<Pair<Double, Double>> r11 = this.innerDistribution.getPmf().iterator();
        double r4 = 0.0d;
    L8:
        if (r11.hasNext() == false) goto L14;
        Pair r6 = (Pair) ZeusTransformUtils.preCheckCast(r11.next(), Pair.class, "com.obric.memorydata.plugin");
        if (((Double) ZeusTransformUtils.preCheckCast(r6.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() == 0.0d) goto L8;
        r4 = r4 + ((Double) ZeusTransformUtils.preCheckCast(r6.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        r2 = ((Double) ZeusTransformUtils.preCheckCast(r6.getKey(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r4 < r12) goto L8;
    L14:
        return r2;
    L16:
        throw new OutOfRangeException(Double.valueOf(r12), 0, 1);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    public boolean isSupportUpperBoundInclusive() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double probability(double r1) {
        return this.innerDistribution.probability(Double.valueOf(r1));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double sample() {
        return ((Double) ZeusTransformUtils.preCheckCast(this.innerDistribution.sample(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
    }
}
