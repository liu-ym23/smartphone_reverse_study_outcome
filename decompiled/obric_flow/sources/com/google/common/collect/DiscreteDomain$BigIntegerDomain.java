package com.google.common.collect;

import java.io.Serializable;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
final class DiscreteDomain$BigIntegerDomain extends n2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DiscreteDomain$BigIntegerDomain f8803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f8804b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f8805c = null;
    private static final long serialVersionUID = 0;

    static {
        f8803a = new DiscreteDomain$BigIntegerDomain();
        f8804b = BigInteger.valueOf(Long.MIN_VALUE);
        f8805c = BigInteger.valueOf(Long.MAX_VALUE);
    }

    public DiscreteDomain$BigIntegerDomain() {
        super(true);
    }

    public static /* synthetic */ DiscreteDomain$BigIntegerDomain access$300() {
        return f8803a;
    }

    private Object readResolve() {
        return f8803a;
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ long distance(Comparable r5, Comparable r10) {
        return distance((BigInteger) r5, (BigInteger) r10);
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable next(Comparable r5) {
        return next((BigInteger) r5);
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable offset(Comparable r5, long r10) {
        return offset((BigInteger) r5, r10);
    }

    @Override // com.google.common.collect.n2
    public /* bridge */ /* synthetic */ Comparable previous(Comparable r5) {
        return previous((BigInteger) r5);
    }

    public String toString() {
        return "DiscreteDomain.bigIntegers()";
    }

    public long distance(BigInteger r5, BigInteger r10) {
        return r10.subtract(r5).max(f8804b).min(f8805c).longValue();
    }

    public BigInteger next(BigInteger r5) {
        return r5.add(BigInteger.ONE);
    }

    public BigInteger offset(BigInteger r5, long r10) {
        p7.r(r10);
        return r5.add(BigInteger.valueOf(r10));
    }

    public BigInteger previous(BigInteger r5) {
        return r5.subtract(BigInteger.ONE);
    }
}
