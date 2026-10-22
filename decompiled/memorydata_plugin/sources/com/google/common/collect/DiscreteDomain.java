package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean supportsFastOffset;

    /* JADX INFO: renamed from: com.google.common.collect.DiscreteDomain$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
        private static final BigIntegerDomain INSTANCE = null;
        private static final BigInteger MAX_LONG = null;
        private static final BigInteger MIN_LONG = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new BigIntegerDomain();
            MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
            MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        }

        BigIntegerDomain() {
            super(true, null);
        }

        static /* synthetic */ BigIntegerDomain access$300() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ long distance(Comparable r3, Comparable r4) {
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            return distance((BigInteger) ZeusTransformUtils.preCheckCast(r5, BigInteger.class, "com.obric.memorydata.plugin"), (BigInteger) ZeusTransformUtils.preCheckCast(r6, BigInteger.class, "com.obric.memorydata.plugin"));
        }

        public long distance(BigInteger r1, BigInteger r2) {
            return r2.subtract(r1).max(MIN_LONG).min(MAX_LONG).longValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ Comparable next(Comparable r3) {
            return next((BigInteger) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), BigInteger.class, "com.obric.memorydata.plugin"));
        }

        public BigInteger next(BigInteger r1) {
            return r1.add(BigInteger.ONE);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* synthetic */ Comparable offset(Comparable r3, long r4) {
            return offset((BigInteger) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), BigInteger.class, "com.obric.memorydata.plugin"), r4);
        }

        BigInteger offset(BigInteger r1, long r2) {
            o.a(r2, "distance");
            return r1.add(BigInteger.valueOf(r2));
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ Comparable previous(Comparable r3) {
            return previous((BigInteger) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), BigInteger.class, "com.obric.memorydata.plugin"));
        }

        public BigInteger previous(BigInteger r1) {
            return r1.subtract(BigInteger.ONE);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    private static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
        private static final IntegerDomain INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new IntegerDomain();
        }

        IntegerDomain() {
            super(true, null);
        }

        static /* synthetic */ IntegerDomain access$000() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ long distance(Comparable r3, Comparable r4) {
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            return distance((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin"), (Integer) ZeusTransformUtils.preCheckCast(r6, Integer.class, "com.obric.memorydata.plugin"));
        }

        public long distance(Integer r3, Integer r4) {
            return ((long) r4.intValue()) - ((long) r3.intValue());
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable maxValue() {
            return maxValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable minValue() {
            return minValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ Comparable next(Comparable r3) {
            return next((Integer) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), Integer.class, "com.obric.memorydata.plugin"));
        }

        public Integer next(Integer r1) {
            int r0 = r1.intValue();
            if (r0 != Integer.MAX_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r0 + 1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* synthetic */ Comparable offset(Comparable r3, long r4) {
            return offset((Integer) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), Integer.class, "com.obric.memorydata.plugin"), r4);
        }

        Integer offset(Integer r1, long r2) {
            o.a(r2, "distance");
            return Integer.valueOf(Ints.a(r1.longValue() + r2));
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ Comparable previous(Comparable r3) {
            return previous((Integer) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), Integer.class, "com.obric.memorydata.plugin"));
        }

        public Integer previous(Integer r1) {
            int r0 = r1.intValue();
            if (r0 != Integer.MIN_VALUE) goto L6;
            return null;
        L6:
            return Integer.valueOf(r0 - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    private static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
        private static final LongDomain INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new LongDomain();
        }

        LongDomain() {
            super(true, null);
        }

        static /* synthetic */ LongDomain access$200() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ long distance(Comparable r3, Comparable r4) {
            Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
            Comparable r6 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.memorydata.plugin");
            return distance((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin"), (Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin"));
        }

        public long distance(Long r7, Long r8) {
            long r0 = r8.longValue() - r7.longValue();
            if (r8.longValue() <= r7.longValue()) goto L9;
            if (r0 >= 0) goto L9;
            return Long.MAX_VALUE;
        L9:
            if (r8.longValue() < r7.longValue()) goto L11;
        L14:
            return r0;
        L11:
            if (r0 <= 0) goto L14;
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable maxValue() {
            return maxValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long maxValue() {
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* bridge */ /* synthetic */ Comparable minValue() {
            return minValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ Comparable next(Comparable r3) {
            return next((Long) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), Long.class, "com.obric.memorydata.plugin"));
        }

        public Long next(Long r3) {
            long r2 = r3.longValue();
            if (r2 != Long.MAX_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r2 + 1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* synthetic */ Comparable offset(Comparable r3, long r4) {
            return offset((Long) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), Long.class, "com.obric.memorydata.plugin"), r4);
        }

        Long offset(Long r3, long r4) {
            o.a(r4, "distance");
            long r0 = r3.longValue() + r4;
            if (r0 >= 0) goto L10;
            if (r3.longValue() >= 0) goto L7;
            boolean r2 = true;
        L8:
            com.google.common.base.n.a(r2, "overflow");
            goto L10
        L7:
            r2 = false;
        L10:
            return Long.valueOf(r0);
        }

        @Override // com.google.common.collect.DiscreteDomain
        public /* synthetic */ Comparable previous(Comparable r3) {
            return previous((Long) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin"), Long.class, "com.obric.memorydata.plugin"));
        }

        public Long previous(Long r3) {
            long r2 = r3.longValue();
            if (r2 != Long.MIN_VALUE) goto L6;
            return null;
        L6:
            return Long.valueOf(r2 - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean r1) {
        this.supportsFastOffset = r1;
    }

    /* synthetic */ DiscreteDomain(boolean r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.access$300();
    }

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.access$000();
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.access$200();
    }

    public abstract long distance(C r1, C r2);

    public C maxValue() {
        throw new NoSuchElementException();
    }

    public C minValue() {
        throw new NoSuchElementException();
    }

    public abstract C next(C r1);

    C offset(C r6, long r7) {
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.memorydata.plugin");
        o.a(r7, "distance");
        long r0 = 0;
        C r2 = (C) r8;
    L4:
        if (r0 >= r7) goto L10;
        r2 = (C) next(r2);
        if (r2 == null) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("overflowed computing offset(" + r8 + ", " + r7 + ")");
    L10:
        return r2;
    }

    public abstract C previous(C r1);
}
