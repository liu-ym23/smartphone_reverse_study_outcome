package org.apache.commons.math3.random;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.commons.math3.distribution.RealDistribution;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class RandomDataImpl implements Serializable {
    private static final long serialVersionUID = -626730818244969716L;
    private final RandomDataGenerator delegate;

    public RandomDataImpl() {
        this.delegate = new RandomDataGenerator();
    }

    public RandomDataImpl(RandomGenerator r3) {
        this.delegate = new RandomDataGenerator((RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    RandomDataGenerator getDelegate() {
        return this.delegate;
    }

    public double nextBeta(double r1, double r3) {
        return this.delegate.nextBeta(r1, r3);
    }

    public int nextBinomial(int r1, double r2) {
        return this.delegate.nextBinomial(r1, r2);
    }

    public double nextCauchy(double r1, double r3) {
        return this.delegate.nextCauchy(r1, r3);
    }

    public double nextChiSquare(double r1) {
        return this.delegate.nextChiSquare(r1);
    }

    public double nextExponential(double r1) {
        return this.delegate.nextExponential(r1);
    }

    public double nextF(double r1, double r3) {
        return this.delegate.nextF(r1, r3);
    }

    public double nextGamma(double r1, double r3) {
        return this.delegate.nextGamma(r1, r3);
    }

    public double nextGaussian(double r1, double r3) {
        return this.delegate.nextGaussian(r1, r3);
    }

    public String nextHexString(int r1) {
        return this.delegate.nextHexString(r1);
    }

    public int nextHypergeometric(int r1, int r2, int r3) {
        return this.delegate.nextHypergeometric(r1, r2, r3);
    }

    public int nextInt(int r1, int r2) {
        return this.delegate.nextInt(r1, r2);
    }

    @Deprecated
    public double nextInversionDeviate(RealDistribution r5) {
        return ((RealDistribution) ZeusTransformUtils.wrapperContextForParams(r5, RealDistribution.class, "com.obric.memorydata.plugin")).inverseCumulativeProbability(nextUniform(0.0d, 1.0d));
    }

    @Deprecated
    public int nextInversionDeviate(IntegerDistribution r5) {
        return ((IntegerDistribution) ZeusTransformUtils.wrapperContextForParams(r5, IntegerDistribution.class, "com.obric.memorydata.plugin")).inverseCumulativeProbability(nextUniform(0.0d, 1.0d));
    }

    public long nextLong(long r1, long r3) {
        return this.delegate.nextLong(r1, r3);
    }

    public int nextPascal(int r1, double r2) {
        return this.delegate.nextPascal(r1, r2);
    }

    public int[] nextPermutation(int r1, int r2) {
        return this.delegate.nextPermutation(r1, r2);
    }

    public long nextPoisson(double r1) {
        return this.delegate.nextPoisson(r1);
    }

    public Object[] nextSample(Collection<?> r3, int r4) {
        Collection<?> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.delegate.nextSample(r5, r4);
    }

    public String nextSecureHexString(int r1) {
        return this.delegate.nextSecureHexString(r1);
    }

    public int nextSecureInt(int r1, int r2) {
        return this.delegate.nextSecureInt(r1, r2);
    }

    public long nextSecureLong(long r1, long r3) {
        return this.delegate.nextSecureLong(r1, r3);
    }

    public double nextT(double r1) {
        return this.delegate.nextT(r1);
    }

    public double nextUniform(double r1, double r3) {
        return this.delegate.nextUniform(r1, r3);
    }

    public double nextUniform(double r7, double r9, boolean r11) {
        return this.delegate.nextUniform(r7, r9, r11);
    }

    public double nextWeibull(double r1, double r3) {
        return this.delegate.nextWeibull(r1, r3);
    }

    public int nextZipf(int r1, double r2) {
        return this.delegate.nextZipf(r1, r2);
    }

    public void reSeed() {
        this.delegate.reSeed();
    }

    public void reSeed(long r1) {
        this.delegate.reSeed(r1);
    }

    public void reSeedSecure() {
        this.delegate.reSeedSecure();
    }

    public void reSeedSecure(long r1) {
        this.delegate.reSeedSecure(r1);
    }

    public void setSecureAlgorithm(String r1, String r2) {
        this.delegate.setSecureAlgorithm(r1, r2);
    }
}
