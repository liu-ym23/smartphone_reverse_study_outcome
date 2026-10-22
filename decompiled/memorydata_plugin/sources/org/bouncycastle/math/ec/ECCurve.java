package org.bouncycastle.math.ec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.math.Primes;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.FiniteFields;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ECCurve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ECFieldElement f17979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ECFieldElement f17980b;
    protected BigInteger cofactor;
    protected int coord;
    protected ECEndomorphism endomorphism;
    protected FiniteField field;
    protected ECMultiplier multiplier;
    protected BigInteger order;

    public static abstract class AbstractF2m extends ECCurve {
        private BigInteger[] si;

        public AbstractF2m(int r1, int r2, int r3, int r4) {
            super(buildField(r1, r2, r3, r4));
            this.si = null;
        }

        private static FiniteField buildField(int r5, int r6, int r7, int r8) {
            if ((r7 | r8) != 0) goto L5;
            int[] r9 = {0, r6, r5};
        L7:
            return FiniteFields.getBinaryExtensionField(r9);
        L5:
            r9 = new int[]{0, r6, r7, r8, r5};
            goto L7
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom r2, int r3) {
        L2:
            BigInteger r0 = BigIntegers.createRandomBigInteger(r3, r2);
            if (r0.signum() <= 0) goto L2;
            return r0;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createPoint(BigInteger r3, BigInteger r4) {
            ECFieldElement r5 = fromBigInteger(r3);
            ECFieldElement r6 = fromBigInteger(r4);
            int r0 = getCoordinateSystem();
            if (r0 == 5) goto L8;
            if (r0 == 6) goto L8;
        L16:
            return createRawPoint(r5, r6);
        L8:
            if (r5.isZero() == true) goto L10;
            r6 = r6.divide(r5).add(r5);
            goto L16
        L10:
            if (r6.square().equals(getB()) == true) goto L16;
            throw new IllegalArgumentException();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint decompressPoint(int r4, BigInteger r5) {
            ECFieldElement r6 = fromBigInteger(r5);
            if (r6.isZero() == false) goto L5;
            ECFieldElement r7 = getB().sqrt();
        L20:
            if (r7 == null) goto L24;
            return createRawPoint(r6, r7);
        L24:
            throw new IllegalArgumentException("Invalid point compression");
        L5:
            ECFieldElement r0 = solveQuadraticEquation(r6.square().invert().multiply(getB()).add(getA()).add(r6));
            if (r0 == null) goto L19;
            boolean r1 = r0.testBitZero();
            boolean r2 = true;
            if (r4 == 1) goto L11;
            r2 = false;
        L11:
            if (r1 == r2) goto L13;
            r0 = r0.addOne();
        L13:
            int r8 = getCoordinateSystem();
            if (r8 != 5) goto L16;
        L18:
            r7 = r0.add(r6);
            goto L20
        L16:
            if (r8 == 6) goto L18;
            r7 = r0.multiply(r6);
            goto L20
        L19:
            r7 = null;
            goto L20
        }

        synchronized BigInteger[] getSi() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.si != null) goto L6;
            this.si = Tnaf.getSi(this);     // Catch: Throwable -> L9
        L6:
            BigInteger[] r0 = this.si;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r0;
        }

        public boolean isKoblitz() {
            if (this.order != null) goto L5;
        L13:
            return false;
        L5:
            if (this.cofactor == null) goto L13;
            if (this.f17980b.isOne() == false) goto L13;
            if (this.f17979a.isZero() == false) goto L11;
        L12:
            return true;
        L11:
            if (this.f17979a.isOne() == false) goto L13;
            goto L12
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElementMult(SecureRandom r3) {
            int r0 = getFieldSize();
            return fromBigInteger(implRandomFieldElementMult(r3, r0)).multiply(fromBigInteger(implRandomFieldElementMult(r3, r0)));
        }

        public ECFieldElement solveQuadraticEquation(ECFieldElement r10) {
            ECFieldElement.AbstractF2m r0 = (ECFieldElement.AbstractF2m) ZeusTransformUtils.preCheckCast(r10, ECFieldElement.AbstractF2m.class, "com.obric.memorydata.plugin");
            boolean r1 = r0.hasFastTrace();
            if (r1 == true) goto L5;
        L7:
            int r3 = getFieldSize();
            if ((r3 & 1) == 0) goto L17;
            ECFieldElement r9 = r0.halfTrace();
            if (r1 == false) goto L12;
        L15:
            return r9;
        L12:
            if (r9.square().add(r9).add(r10).isZero() == true) goto L15;
            return null;
        L17:
            if (r10.isZero() == false) goto L19;
            return r10;
        L19:
            ECFieldElement r2 = fromBigInteger(ECConstants.ZERO);
            Random r4 = new Random();
        L20:
            ECFieldElement r5 = fromBigInteger(new BigInteger(r3, r4));
            int r6 = 1;
            ECFieldElement r7 = r10;
            ECFieldElement r8 = r2;
        L21:
            if (r6 >= r3) goto L24;
            ECFieldElement r11 = r7.square();
            r8 = r8.square().add(r11.multiply(r5));
            r7 = r11.add(r10);
            r6 = r6 + 1;
            goto L21
        L24:
            if (r7.isZero() == false) goto L25;
            if (r8.square().add(r8).isZero() == true) goto L20;
            return r8;
        L25:
            return null;
        L5:
            if (r0.trace() == 0) goto L7;
            return null;
        }
    }

    public static abstract class AbstractFp extends ECCurve {
        public AbstractFp(BigInteger r1) {
            super(FiniteFields.getPrimeField(r1));
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom r2, BigInteger r3) {
        L2:
            BigInteger r0 = BigIntegers.createRandomBigInteger(r3.bitLength(), r2);
            if (r0.signum() <= 0) goto L2;
            if (r0.compareTo(r3) >= 0) goto L2;
            return r0;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint decompressPoint(int r4, BigInteger r5) {
            ECFieldElement r6 = fromBigInteger(r5);
            ECFieldElement r0 = r6.square().add(this.f17979a).multiply(r6).add(this.f17980b).sqrt();
            if (r0 == null) goto L13;
            boolean r1 = r0.testBitZero();
            boolean r2 = true;
            if (r4 == 1) goto L8;
            r2 = false;
        L8:
            if (r1 == r2) goto L11;
            r0 = r0.negate();
        L11:
            return createRawPoint(r6, r0);
        L13:
            throw new IllegalArgumentException("Invalid point compression");
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement randomFieldElementMult(SecureRandom r3) {
            BigInteger r0 = getField().getCharacteristic();
            return fromBigInteger(implRandomFieldElementMult(r3, r0)).multiply(fromBigInteger(implRandomFieldElementMult(r3, r0)));
        }
    }

    public class Config {
        protected int coord;
        protected ECEndomorphism endomorphism;
        protected ECMultiplier multiplier;
        final /* synthetic */ ECCurve this$0;

        Config(ECCurve r3, int r4, ECEndomorphism r5, ECMultiplier r6) {
            ECEndomorphism r7 = (ECEndomorphism) ZeusTransformUtils.wrapperContextForParams(r5, ECEndomorphism.class, "com.obric.memorydata.plugin");
            ECMultiplier r8 = (ECMultiplier) ZeusTransformUtils.wrapperContextForParams(r6, ECMultiplier.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.coord = r4;
            this.endomorphism = r7;
            this.multiplier = r8;
        }

        public ECCurve create() {
            if (this.this$0.supportsCoordinateSystem(this.coord) == false) goto L16;
            ECCurve r0 = this.this$0.cloneCurve();
            if (r0 == this.this$0) goto L14;
            monitor-enter(r0);
            r0.coord = this.coord;     // Catch: Throwable -> L10
            r0.endomorphism = this.endomorphism;     // Catch: Throwable -> L10
            r0.multiplier = this.multiplier;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r0;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalStateException("implementation returned current curve");
        L16:
            throw new IllegalStateException("unsupported coordinate system");
        }

        public Config setEndomorphism(ECEndomorphism r3) {
            this.endomorphism = (ECEndomorphism) ZeusTransformUtils.wrapperContextForParams(r3, ECEndomorphism.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    public static class F2m extends AbstractF2m {
        private ECPoint.F2m infinity;
        private int k1;
        private int k2;
        private int k3;
        private int m;

        public F2m(int r10, int r11, int r12, int r13, BigInteger r14, BigInteger r15) {
            this(r10, r11, r12, r13, r14, r15, null, null);
        }

        public F2m(int r1, int r2, int r3, int r4, BigInteger r5, BigInteger r6, BigInteger r7, BigInteger r8) {
            super(r1, r2, r3, r4);
            this.m = r1;
            this.k1 = r2;
            this.k2 = r3;
            this.k3 = r4;
            this.order = r7;
            this.cofactor = r8;
            this.infinity = new ECPoint.F2m(this, null, null);
            this.f17979a = fromBigInteger(r5);
            this.f17980b = fromBigInteger(r6);
            this.coord = 6;
        }

        public F2m(int r1, int r2, int r3, int r4, ECFieldElement r5, ECFieldElement r6, BigInteger r7, BigInteger r8) {
            super(r1, r2, r3, r4);
            this.m = r1;
            this.k1 = r2;
            this.k2 = r3;
            this.k3 = r4;
            this.order = r7;
            this.cofactor = r8;
            this.infinity = new ECPoint.F2m(this, null, null);
            this.f17979a = r5;
            this.f17980b = r6;
            this.coord = 6;
        }

        public F2m(int r10, int r11, BigInteger r12, BigInteger r13, BigInteger r14, BigInteger r15) {
            this(r10, r11, 0, 0, r12, r13, r14, r15);
        }

        static /* synthetic */ int access$100(F2m r0) {
            return r0.m;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECCurve cloneCurve() {
            return new F2m(this.m, this.k1, this.k2, this.k3, this.f17979a, this.f17980b, this.order, this.cofactor);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECLookupTable createCacheSafeLookupTable(ECPoint[] r10, int r11, final int r12) {
            final int r4 = (this.m + 63) >>> 6;
            int r3 = 0;
            if (isTrinomial() == false) goto L5;
            int[] r0 = {this.k1};
        L6:
            final int[] r6 = r0;
            final long[] r5 = new long[(r12 * r4) * 2];
            int r1 = 0;
        L7:
            if (r3 >= r12) goto L10;
            ECPoint r2 = r10[r11 + r3];
            ((ECFieldElement.F2m) ZeusTransformUtils.preCheckCast(r2.getRawXCoord(), ECFieldElement.F2m.class, "com.obric.memorydata.plugin")).x.copyTo(r5, r1);
            int r7 = r1 + r4;
            ((ECFieldElement.F2m) ZeusTransformUtils.preCheckCast(r2.getRawYCoord(), ECFieldElement.F2m.class, "com.obric.memorydata.plugin")).x.copyTo(r5, r7);
            r1 = r7 + r4;
            r3 = r3 + 1;
            goto L7
        L10:
            return new AnonymousClass1(this, r12, r4, r5, r6);
        L5:
            r0 = new int[]{this.k1, this.k2, this.k3};
            goto L6
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECMultiplier createDefaultMultiplier() {
            if (isKoblitz() == false) goto L7;
            return new WTauNafMultiplier();
        L7:
            return super.createDefaultMultiplier();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3) {
            return new ECPoint.F2m(this, r2, r3);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
            return new ECPoint.F2m(this, r2, r3, r4);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger r7) {
            if (r7 == null) goto L14;
            if (r7.signum() < 0) goto L14;
            if (r7.bitLength() > this.m) goto L14;
            int r0 = this.k2;
            int r1 = this.k3;
            if ((r0 | r1) != 0) goto L10;
            int[] r2 = {this.k1};
        L12:
            return new ECFieldElement.F2m(this.m, r2, new LongArray(r7));
        L10:
            r2 = new int[]{this.k1, r0, r1};
        L14:
            throw new IllegalArgumentException("x value invalid in F2m field element");
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.m;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public boolean isTrinomial() {
            if (this.k2 == 0) goto L5;
        L7:
            return false;
        L5:
            if (this.k3 != 0) goto L7;
            return true;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public boolean supportsCoordinateSystem(int r2) {
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L6;
            return true;
        L6:
            if (r2 == 6) goto L11;
            return false;
        L11:
            return true;
        L9:
            return true;
        }
    }

    public static class Fp extends AbstractFp {
        private static final Set<BigInteger> knownQs = null;
        private static final BigIntegers.Cache validatedQs = null;
        ECPoint.Fp infinity;
        BigInteger q;
        BigInteger r;

        static {
            knownQs = Collections.synchronizedSet(new HashSet());
            validatedQs = new BigIntegers.Cache();
        }

        public Fp(BigInteger r7, BigInteger r8, BigInteger r9) {
            this(r7, r8, r9, null, null);
        }

        public Fp(BigInteger r8, BigInteger r9, BigInteger r10, BigInteger r11, BigInteger r12) {
            this(r8, r9, r10, r11, r12, false);
        }

        public Fp(BigInteger r4, BigInteger r5, BigInteger r6, BigInteger r7, BigInteger r8, boolean r9) {
            super(r4);
            if (r9 == false) goto L6;
            this.q = r4;
            knownQs.add(r4);
        L22:
            this.r = ECFieldElement.Fp.calculateResidue(r4);
            this.infinity = new ECPoint.Fp(this, null, null);
            this.f17979a = fromBigInteger(r5);
            this.f17980b = fromBigInteger(r6);
            this.order = r7;
            this.cofactor = r8;
            this.coord = 4;
            return;
        L6:
            if (knownQs.contains(r4) == true) goto L21;
            BigIntegers.Cache r10 = validatedQs;
            if (r10.contains(r4) == true) goto L21;
            int r0 = Properties.asInteger("org.bouncycastle.ec.fp_max_size", 1042);
            int r1 = Properties.asInteger("org.bouncycastle.ec.fp_certainty", 100);
            int r2 = r4.bitLength();
            if (r0 < r2) goto L20;
            if (Primes.hasAnySmallFactors(r4) == true) goto L18;
            if (Primes.isMRProbablePrime(r4, CryptoServicesRegistrar.getSecureRandom(), ECCurve.access$000(r2, r1)) == false) goto L18;
            r10.add(r4);
        L18:
            throw new IllegalArgumentException("Fp q value not prime");
        L20:
            throw new IllegalArgumentException("Fp q value out of range");
        L21:
            this.q = r4;
            goto L22
        }

        public Fp(BigInteger r1, BigInteger r2, ECFieldElement r3, ECFieldElement r4, BigInteger r5, BigInteger r6) {
            super(r1);
            this.q = r1;
            this.r = r2;
            this.infinity = new ECPoint.Fp(this, null, null);
            this.f17979a = r3;
            this.f17980b = r4;
            this.order = r5;
            this.cofactor = r6;
            this.coord = 4;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECCurve cloneCurve() {
            return new Fp(this.q, this.r, this.f17979a, this.f17980b, this.order, this.cofactor);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3) {
            return new ECPoint.Fp(this, r2, r3);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement r2, ECFieldElement r3, ECFieldElement[] r4) {
            return new ECPoint.Fp(this, r2, r3, r4);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger r3) {
            if (r3 == null) goto L10;
            if (r3.signum() < 0) goto L10;
            if (r3.compareTo(this.q) >= 0) goto L10;
            return new ECFieldElement.Fp(this.q, this.r, r3);
        L10:
            throw new IllegalArgumentException("x value invalid for Fp field element");
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.q.bitLength();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint importPoint(ECPoint r6) {
            if (this == r6.getCurve()) goto L18;
            if (getCoordinateSystem() != 2) goto L18;
            if (r6.isInfinity() == true) goto L18;
            int r0 = r6.getCurve().getCoordinateSystem();
            if (r0 == 2) goto L16;
            if (r0 == 3) goto L16;
            if (r0 != 4) goto L18;
        L16:
            return new ECPoint.Fp(this, fromBigInteger(r6.x.toBigInteger()), fromBigInteger(r6.y.toBigInteger()), new ECFieldElement[]{fromBigInteger(r6.zs[0].toBigInteger())});
        L18:
            return super.importPoint(r6);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public boolean supportsCoordinateSystem(int r2) {
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L6;
            return true;
        L6:
            if (r2 != 2) goto L8;
            return true;
        L8:
            if (r2 == 4) goto L14;
            return false;
        L14:
            return true;
        L11:
            return true;
        }
    }

    public ECCurve(FiniteField r3) {
        FiniteField r4 = (FiniteField) ZeusTransformUtils.wrapperContextForParams(r3, FiniteField.class, "com.obric.memorydata.plugin");
        this.coord = 0;
        this.endomorphism = null;
        this.multiplier = null;
        this.field = r4;
    }

    static /* synthetic */ int access$000(int r0, int r1) {
        return getNumberOfIterations(r0, r1);
    }

    private static int getNumberOfIterations(int r4, int r5) {
        if (r4 < 1536) goto L12;
        if (r5 > 100) goto L7;
        return 3;
    L7:
        if (r5 > 128) goto L10;
        return 4;
    L10:
        return 4 + (((r5 - 128) + 1) / 2);
    L12:
        if (r4 < 1024) goto L21;
        if (r5 > 100) goto L16;
        return 4;
    L16:
        if (r5 > 112) goto L19;
        return 5;
    L19:
        return (((r5 - 112) + 1) / 2) + 5;
    L21:
        if (r4 < 512) goto L30;
        if (r5 <= 80) goto L39;
        if (r5 > 100) goto L28;
        return 7;
    L28:
        return (((r5 - 100) + 1) / 2) + 7;
    L39:
        return 5;
    L30:
        if (r5 > 80) goto L33;
        return 40;
    L33:
        return 40 + (((r5 - 80) + 1) / 2);
    }

    public void checkPoint(ECPoint r1) {
        if (r1 == null) goto L7;
        if (this != r1.getCurve()) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("'point' must be non-null and on this curve");
    }

    public void checkPoints(ECPoint[] r3, int r4, int r5) {
        if (r3 == null) goto L21;
        if (r4 < 0) goto L19;
        if (r5 < 0) goto L19;
        if (r4 > (r3.length - r5)) goto L19;
        int r0 = 0;
    L8:
        if (r0 >= r5) goto L17;
        ECPoint r1 = r3[r4 + r0];
        if (r1 == null) goto L16;
        if (this == r1.getCurve()) goto L16;
        throw new IllegalArgumentException("'points' entries must be null or on this curve");
    L16:
        r0 = r0 + 1;
        goto L8
    L17:
        return;
    L19:
        throw new IllegalArgumentException("invalid range specified for 'points'");
    L21:
        throw new IllegalArgumentException("'points' cannot be null");
    }

    public abstract ECCurve cloneCurve();

    public synchronized Config configure() {
        monitor-enter(this);
        Config r0 = new Config(this, this.coord, this.endomorphism, this.multiplier);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] r13, int r14, final int r15) {
        final int r0 = (getFieldSize() + 7) >>> 3;
        final byte[] r1 = new byte[(r15 * r0) * 2];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r15) goto L14;
        ECPoint r5 = r13[r14 + r3];
        byte[] r6 = r5.getRawXCoord().toBigInteger().toByteArray();
        byte[] r7 = r5.getRawYCoord().toBigInteger().toByteArray();
        int r8 = 1;
        if (r6.length <= r0) goto L7;
        int r9 = 1;
    L8:
        int r10 = r6.length - r9;
        if (r7.length > r0) goto L12;
        r8 = 0;
    L12:
        int r11 = r7.length - r8;
        int r12 = r4 + r0;
        System.arraycopy(r6, r9, r1, r12 - r10, r10);
        r4 = r12 + r0;
        System.arraycopy(r7, r8, r1, r4 - r11, r11);
        r3 = r3 + 1;
        goto L3
    L7:
        r9 = 0;
        goto L8
    L14:
        return new AnonymousClass1(this, r15, r0, r1);
    }

    public ECMultiplier createDefaultMultiplier() {
        if (ZeusTransformUtils.instanceOf(this.endomorphism, GLVEndomorphism.class) == false) goto L7;
        return new GLVMultiplier(this, (GLVEndomorphism) ZeusTransformUtils.preCheckCast(this.endomorphism, GLVEndomorphism.class, "com.obric.memorydata.plugin"));
    L7:
        return new WNafL2RMultiplier();
    }

    public ECPoint createPoint(BigInteger r1, BigInteger r2) {
        return createRawPoint(fromBigInteger(r1), fromBigInteger(r2));
    }

    public abstract ECPoint createRawPoint(ECFieldElement r1, ECFieldElement r2);

    public abstract ECPoint createRawPoint(ECFieldElement r1, ECFieldElement r2, ECFieldElement[] r3);

    public ECPoint decodePoint(byte[] r8) {
        int r0 = (getFieldSize() + 7) / 8;
        boolean r2 = false;
        byte r3 = r8[0];
        if (r3 == 0) goto L42;
        if (r3 == 2) goto L33;
        if (r3 == 3) goto L33;
        if (r3 == 4) goto L28;
        if (r3 == 6) goto L17;
        if (r3 == 7) goto L17;
        throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(r3, 16));
    L17:
        if (r8.length != ((r0 * 2) + 1)) goto L26;
        BigInteger r5 = BigIntegers.fromUnsignedByteArray(r8, 1, r0);
        BigInteger r9 = BigIntegers.fromUnsignedByteArray(r8, r0 + 1, r0);
        boolean r1 = r9.testBit(0);
        if (r3 != 7) goto L21;
        r2 = true;
    L21:
        if (r1 != r2) goto L24;
        ECPoint r7 = validatePoint(r5, r9);
    L44:
        if (r3 != 0) goto L46;
    L50:
        return r7;
    L46:
        if (r7.isInfinity() == false) goto L50;
        throw new IllegalArgumentException("Invalid infinity encoding");
    L24:
        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
    L26:
        throw new IllegalArgumentException("Incorrect length for hybrid encoding");
    L28:
        if (r8.length != ((r0 * 2) + 1)) goto L31;
        r7 = validatePoint(BigIntegers.fromUnsignedByteArray(r8, 1, r0), BigIntegers.fromUnsignedByteArray(r8, r0 + 1, r0));
        goto L44
    L31:
        throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
    L33:
        if (r8.length != (r0 + 1)) goto L40;
        r7 = decompressPoint(r3 & 1, BigIntegers.fromUnsignedByteArray(r8, 1, r0));
        if (r7.implIsValid(true, true) == true) goto L44;
        throw new IllegalArgumentException("Invalid point");
    L40:
        throw new IllegalArgumentException("Incorrect length for compressed encoding");
    L42:
        if (r8.length != 1) goto L52;
        r7 = getInfinity();
        goto L44
    L52:
        throw new IllegalArgumentException("Incorrect length for infinity encoding");
    }

    public abstract ECPoint decompressPoint(int r1, BigInteger r2);

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, ECCurve.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (equals((ECCurve) ZeusTransformUtils.preCheckCast(r3, ECCurve.class, "com.obric.memorydata.plugin")) == false) goto L9;
        goto L9
    }

    public boolean equals(ECCurve r3) {
        if (this == r3) goto L12;
        if (r3 != null) goto L5;
    L11:
        return false;
    L5:
        if (getField().equals(r3.getField()) == false) goto L11;
        if (getA().toBigInteger().equals(r3.getA().toBigInteger()) == false) goto L11;
        if (getB().toBigInteger().equals(r3.getB().toBigInteger()) == false) goto L11;
    L12:
        return true;
    }

    public abstract ECFieldElement fromBigInteger(BigInteger r1);

    public ECFieldElement getA() {
        return this.f17979a;
    }

    public ECFieldElement getB() {
        return this.f17980b;
    }

    public BigInteger getCofactor() {
        return this.cofactor;
    }

    public int getCoordinateSystem() {
        return this.coord;
    }

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public FiniteField getField() {
        return this.field;
    }

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public ECMultiplier getMultiplier() {
        if (this.multiplier != null) goto L6;
        this.multiplier = createDefaultMultiplier();
    L6:
        return this.multiplier;
    }

    public BigInteger getOrder() {
        return this.order;
    }

    public int hashCode() {
        int r0 = getField().hashCode() ^ Integers.rotateLeft(getA().toBigInteger().hashCode(), 8);
        return Integers.rotateLeft(getB().toBigInteger().hashCode(), 16) ^ r0;
    }

    public ECPoint importPoint(ECPoint r2) {
        if (this != r2.getCurve()) goto L6;
        return r2;
    L6:
        if (r2.isInfinity() == true) goto L8;
        ECPoint r3 = r2.normalize();
        return createPoint(r3.getXCoord().toBigInteger(), r3.getYCoord().toBigInteger());
    L8:
        return getInfinity();
    }

    public void normalizeAll(ECPoint[] r4) {
        normalizeAll(r4, 0, r4.length, null);
    }

    public void normalizeAll(ECPoint[] r8, int r9, int r10, ECFieldElement r11) {
        checkPoints(r8, r9, r10);
        int r7 = getCoordinateSystem();
        if (r7 != 0) goto L5;
    L21:
        if (r11 != null) goto L24;
        return;
    L24:
        throw new IllegalArgumentException("'iso' not valid for affine coordinates");
    L5:
        if (r7 == 5) goto L21;
        ECFieldElement[] r12 = new ECFieldElement[r10];
        int[] r0 = new int[r10];
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= r10) goto L15;
        int r4 = r9 + r2;
        ECPoint r5 = r8[r4];
        if (r5 == null) goto L14;
        if (r11 == null) goto L12;
    L13:
        r12[r3] = r5.getZCoord(0);
        r0[r3] = r4;
        r3 = r3 + 1;
        goto L14
    L12:
        if (r5.isNormalized() == false) goto L13;
    L14:
        r2 = r2 + 1;
        goto L7
    L15:
        if (r3 != 0) goto L17;
        return;
    L17:
        ECAlgorithms.montgomeryTrick(r12, 0, r3, r11);
    L18:
        if (r1 >= r3) goto L20;
        int r13 = r0[r1];
        r8[r13] = r8[r13].normalize(r12[r1]);
        r1 = r1 + 1;
        goto L18
    }

    public PreCompInfo precompute(ECPoint r3, String r4, PreCompCallback r5) {
        PreCompCallback r6 = (PreCompCallback) ZeusTransformUtils.wrapperContextForParams(r5, PreCompCallback.class, "com.obric.memorydata.plugin");
        checkPoint(r3);
        monitor-enter(r3);
        Hashtable r2 = r3.preCompTable;     // Catch: Throwable -> L17
        if (r2 != null) goto L7;
        r2 = new Hashtable(4);     // Catch: Throwable -> L17
        r3.preCompTable = r2;     // Catch: Throwable -> L17
    L7:
        monitor-exit(r3);     // Catch: Throwable -> L17
        monitor-enter(r2);
        PreCompInfo r7 = (PreCompInfo) ZeusTransformUtils.preCheckCast(r2.get(r4), PreCompInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        PreCompInfo r8 = r6.precompute(r7);     // Catch: Throwable -> L14
        if (r8 == r7) goto L12;
        r2.put(r4, r8);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L14
        return r8;
    L14:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        throw th;
    }

    public abstract ECFieldElement randomFieldElementMult(SecureRandom r1);

    public boolean supportsCoordinateSystem(int r1) {
        if (r1 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    public ECPoint validatePoint(BigInteger r1, BigInteger r2) {
        ECPoint r0 = createPoint(r1, r2);
        if (r0.isValid() == false) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Invalid point coordinates");
    }
}
