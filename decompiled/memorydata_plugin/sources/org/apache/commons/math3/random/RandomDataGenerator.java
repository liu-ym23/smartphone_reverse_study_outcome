package org.apache.commons.math3.random;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import org.apache.commons.math3.distribution.BetaDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.distribution.CauchyDistribution;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.apache.commons.math3.distribution.HypergeometricDistribution;
import org.apache.commons.math3.distribution.PascalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.distribution.WeibullDistribution;
import org.apache.commons.math3.distribution.ZipfDistribution;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class RandomDataGenerator implements Serializable {
    private static final long serialVersionUID = -626730818244969716L;
    private RandomGenerator rand;
    private RandomGenerator secRand;

    public RandomDataGenerator() {
        this.rand = null;
        this.secRand = null;
    }

    public RandomDataGenerator(RandomGenerator r3) {
        RandomGenerator r4 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin");
        this.rand = null;
        this.secRand = null;
        this.rand = r4;
    }

    private RandomGenerator getSecRan() {
        if (this.secRand != null) goto L6;
        RandomGenerator r0 = RandomGeneratorFactory.createRandomGenerator(new SecureRandom());
        this.secRand = r0;
        r0.setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    L6:
        return this.secRand;
    }

    private void initRan() {
        this.rand = new Well19937c(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    }

    private static long nextLong(RandomGenerator r11, long r12) {
        RandomGenerator r13 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r11, RandomGenerator.class, "com.obric.memorydata.plugin");
        if (r12 <= 0) goto L12;
        byte[] r3 = new byte[8];
    L5:
        r13.nextBytes(r3);
        int r4 = 0;
        long r5 = 0;
    L6:
        if (r4 >= 8) goto L8;
        r5 = (r5 << 8) | (((long) r3[r4]) & 255);
        r4 = r4 + 1;
        goto L6
    L8:
        long r6 = r5 & Long.MAX_VALUE;
        long r7 = r6 % r12;
        if (((r6 - r7) + (r12 - 1)) < 0) goto L5;
        return r7;
    L12:
        throw new NotStrictlyPositiveException(Long.valueOf(r12));
    }

    public RandomGenerator getRandomGenerator() {
        if (this.rand != null) goto L6;
        initRan();
    L6:
        return this.rand;
    }

    public double nextBeta(double r10, double r12) {
        return new BetaDistribution(getRandomGenerator(), r10, r12, 1.0E-9d).sample();
    }

    public int nextBinomial(int r2, double r3) {
        return new BinomialDistribution(getRandomGenerator(), r2, r3).sample();
    }

    public double nextCauchy(double r10, double r12) {
        return new CauchyDistribution(getRandomGenerator(), r10, r12, 1.0E-9d).sample();
    }

    public double nextChiSquare(double r8) {
        return new ChiSquaredDistribution(getRandomGenerator(), r8, 1.0E-9d).sample();
    }

    public double nextExponential(double r8) {
        return new ExponentialDistribution(getRandomGenerator(), r8, 1.0E-9d).sample();
    }

    public double nextF(double r10, double r12) {
        return new FDistribution(getRandomGenerator(), r10, r12, 1.0E-9d).sample();
    }

    public double nextGamma(double r10, double r12) {
        return new GammaDistribution(getRandomGenerator(), r10, r12, 1.0E-9d).sample();
    }

    public double nextGaussian(double r3, double r5) {
        if (r5 <= 0.0d) goto L7;
        return (r5 * getRandomGenerator().nextGaussian()) + r3;
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.STANDARD_DEVIATION, Double.valueOf(r5));
    }

    public String nextHexString(int r9) {
        if (r9 <= 0) goto L12;
        RandomGenerator r8 = getRandomGenerator();
        StringBuilder r0 = new StringBuilder();
        int r1 = (r9 / 2) + 1;
        byte[] r3 = new byte[r1];
        r8.nextBytes(r3);
        int r4 = 0;
    L4:
        if (r4 >= r1) goto L10;
        String r5 = Integer.toHexString(Integer.valueOf(r3[r4]).intValue() + 128);
        if (r5.length() != 1) goto L8;
        r5 = "0" + r5;
    L8:
        r0.append(r5);
        r4 = r4 + 1;
        goto L4
    L10:
        return r0.toString().substring(0, r9);
    L12:
        throw new NotStrictlyPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(r9));
    }

    public int nextHypergeometric(int r2, int r3, int r4) {
        return new HypergeometricDistribution(getRandomGenerator(), r2, r3, r4).sample();
    }

    public int nextInt(int r2, int r3) {
        return new UniformIntegerDistribution(getRandomGenerator(), r2, r3).sample();
    }

    public long nextLong(long r5, long r7) {
        if (r5 >= r7) goto L19;
        long r0 = (r7 - r5) + 1;
        if (r0 > 0) goto L12;
        RandomGenerator r2 = getRandomGenerator();
    L7:
        long r1 = r2.nextLong();
        if (r1 < r5) goto L7;
        if (r1 > r7) goto L7;
        return r1;
    L12:
        RandomGenerator r4 = getRandomGenerator();
        if (r0 >= 2147483647L) goto L17;
        long r8 = r4.nextInt((int) r0);
    L16:
        return r5 + r8;
    L17:
        r8 = nextLong(r4, r0);
        goto L16
    L19:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Long.valueOf(r5), Long.valueOf(r7), false);
    }

    public int nextPascal(int r2, double r3) {
        return new PascalDistribution(getRandomGenerator(), r2, r3).sample();
    }

    public int[] nextPermutation(int r3, int r4) {
        if (r4 > r3) goto L9;
        if (r4 <= 0) goto L7;
        int[] r5 = MathArrays.natural(r3);
        MathArrays.shuffle(r5, getRandomGenerator());
        return MathArrays.copyOf(r5, r4);
    L7:
        throw new NotStrictlyPositiveException(LocalizedFormats.PERMUTATION_SIZE, Integer.valueOf(r4));
    L9:
        throw new NumberIsTooLargeException(LocalizedFormats.PERMUTATION_EXCEEDS_N, Integer.valueOf(r4), Integer.valueOf(r3), true);
    }

    public long nextPoisson(double r9) {
        return new PoissonDistribution(getRandomGenerator(), r9, 1.0E-12d, PoissonDistribution.DEFAULT_MAX_ITERATIONS).sample();
    }

    public Object[] nextSample(Collection<?> r4, int r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        int r0 = r6.size();
        if (r5 > r0) goto L12;
        if (r5 <= 0) goto L10;
        Object[] r7 = r6.toArray();
        int[] r3 = nextPermutation(r0, r5);
        Object[] r1 = new Object[r5];
        int r2 = 0;
    L6:
        if (r2 >= r5) goto L8;
        r1[r2] = r7[r3[r2]];
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    L10:
        throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(r5));
    L12:
        throw new NumberIsTooLargeException(LocalizedFormats.SAMPLE_SIZE_EXCEEDS_COLLECTION_SIZE, Integer.valueOf(r5), Integer.valueOf(r0), true);
    }

    public String nextSecureHexString(int r11) {
        if (r11 <= 0) goto L22;
        RandomGenerator r10 = getSecRan();
        MessageDigest r0 = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L18
        r0.reset();
        int r1 = (r11 / 40) + 1;
        StringBuilder r3 = new StringBuilder();
        int r4 = 1;
    L6:
        int r6 = 0;
        if (r4 >= (r1 + 1)) goto L17;
        byte[] r5 = new byte[40];
        r10.nextBytes(r5);
        r0.update(r5);
        byte[] r7 = r0.digest();
    L10:
        if (r6 >= r7.length) goto L15;
        String r8 = Integer.toHexString(Integer.valueOf(r7[r6]).intValue() + 128);
        if (r8.length() != 1) goto L14;
        r8 = "0" + r8;
    L14:
        r3.append(r8);
        r6 = r6 + 1;
        goto L10
    L15:
        r4 = r4 + 1;
        goto L6
    L17:
        return r3.toString().substring(0, r11);
    L18:
        e = move-exception;
        throw new MathInternalError(e);
    L22:
        throw new NotStrictlyPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(r11));
    }

    public int nextSecureInt(int r2, int r3) {
        return new UniformIntegerDistribution(getSecRan(), r2, r3).sample();
    }

    public long nextSecureLong(long r5, long r7) {
        if (r5 >= r7) goto L18;
        RandomGenerator r4 = getSecRan();
        long r0 = (r7 - r5) + 1;
        if (r0 > 0) goto L12;
    L6:
        long r1 = r4.nextLong();
        if (r1 < r5) goto L6;
        if (r1 > r7) goto L6;
        return r1;
    L12:
        if (r0 >= 2147483647L) goto L16;
        long r8 = r4.nextInt((int) r0);
    L15:
        return r5 + r8;
    L16:
        r8 = nextLong(r4, r0);
        goto L15
    L18:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Long.valueOf(r5), Long.valueOf(r7), false);
    }

    public double nextT(double r8) {
        return new TDistribution(getRandomGenerator(), r8, 1.0E-9d).sample();
    }

    public double nextUniform(double r7, double r9) {
        return nextUniform(r7, r9, false);
    }

    public double nextUniform(double r5, double r7, boolean r9) {
        if (r5 >= r7) goto L27;
        if (Double.isInfinite(r5) == true) goto L25;
        if (Double.isInfinite(r7) == true) goto L23;
        if (Double.isNaN(r5) == true) goto L21;
        if (Double.isNaN(r7) == true) goto L21;
        RandomGenerator r4 = getRandomGenerator();
    L13:
        double r0 = r4.nextDouble();
        if (r9 == true) goto L19;
        if (r0 <= 0.0d) goto L13;
    L19:
        return (r7 * r0) + ((1.0d - r0) * r5);
    L21:
        throw new NotANumberException();
    L23:
        throw new NotFiniteNumberException(LocalizedFormats.INFINITE_BOUND, Double.valueOf(r7), new Object[0]);
    L25:
        throw new NotFiniteNumberException(LocalizedFormats.INFINITE_BOUND, Double.valueOf(r5), new Object[0]);
    L27:
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Double.valueOf(r5), Double.valueOf(r7), false);
    }

    public double nextWeibull(double r10, double r12) {
        return new WeibullDistribution(getRandomGenerator(), r10, r12, 1.0E-9d).sample();
    }

    public int nextZipf(int r2, double r3) {
        return new ZipfDistribution(getRandomGenerator(), r2, r3).sample();
    }

    public void reSeed() {
        getRandomGenerator().setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    }

    public void reSeed(long r1) {
        getRandomGenerator().setSeed(r1);
    }

    public void reSeedSecure() {
        getSecRan().setSeed(System.currentTimeMillis());
    }

    public void reSeedSecure(long r1) {
        getSecRan().setSeed(r1);
    }

    public void setSecureAlgorithm(String r1, String r2) {
        this.secRand = RandomGeneratorFactory.createRandomGenerator(SecureRandom.getInstance(r1, r2));
    }
}
