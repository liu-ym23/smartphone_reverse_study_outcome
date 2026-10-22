package com.google.common.hash;

import com.google.common.base.n;
import com.google.common.base.o;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public final class BloomFilter<T> implements o<T>, Serializable {
    private final BloomFilterStrategies.a bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    /* JADX INFO: renamed from: com.google.common.hash.BloomFilter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> r2) {
            this.data = BloomFilterStrategies.a.a(BloomFilter.access$000(r2).f4709a);
            this.numHashFunctions = BloomFilter.access$100(r2);
            this.funnel = BloomFilter.access$200(r2);
            this.strategy = BloomFilter.access$300(r2);
        }

        Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.a(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }
    }

    interface Strategy extends Serializable {
        <T> boolean mightContain(T r1, Funnel<? super T> r2, int r3, BloomFilterStrategies.a r4);

        int ordinal();

        <T> boolean put(T r1, Funnel<? super T> r2, int r3, BloomFilterStrategies.a r4);
    }

    private BloomFilter(BloomFilterStrategies.a r6, int r7, Funnel<? super T> r8, Strategy r9) {
        Funnel r10 = (Funnel) ZeusTransformUtils.wrapperContextForParams(r8, Funnel.class, "com.obric.memorydata.plugin");
        Strategy r11 = (Strategy) ZeusTransformUtils.wrapperContextForParams(r9, Strategy.class, "com.obric.memorydata.plugin");
        boolean r0 = true;
        if (r7 <= 0) goto L5;
        boolean r3 = true;
    L6:
        n.a(r3, "numHashFunctions (%s) must be > 0", r7);
        if (r7 <= 255) goto L10;
        r0 = false;
    L10:
        n.a(r0, "numHashFunctions (%s) must be <= 255", r7);
        this.bits = (BloomFilterStrategies.a) ZeusTransformUtils.preCheckCast(n.a(r6), BloomFilterStrategies.a.class, "com.obric.memorydata.plugin");
        this.numHashFunctions = r7;
        this.funnel = (Funnel) ZeusTransformUtils.preCheckCast(n.a(r10), Funnel.class, "com.obric.memorydata.plugin");
        this.strategy = (Strategy) ZeusTransformUtils.preCheckCast(n.a(r11), Strategy.class, "com.obric.memorydata.plugin");
        return;
    L5:
        r3 = false;
        goto L6
    }

    /* synthetic */ BloomFilter(BloomFilterStrategies.a r2, int r3, Funnel r4, Strategy r5, AnonymousClass1 r6) {
        this(r2, r3, (Funnel) ZeusTransformUtils.wrapperContextForParams(r4, Funnel.class, "com.obric.memorydata.plugin"), (Strategy) ZeusTransformUtils.wrapperContextForParams(r5, Strategy.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ BloomFilterStrategies.a access$000(BloomFilter r0) {
        return r0.bits;
    }

    static /* synthetic */ int access$100(BloomFilter r0) {
        return r0.numHashFunctions;
    }

    static /* synthetic */ Funnel access$200(BloomFilter r0) {
        return r0.funnel;
    }

    static /* synthetic */ Strategy access$300(BloomFilter r0) {
        return r0.strategy;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r2, int r3) {
        return create((Funnel) ZeusTransformUtils.wrapperContextForParams(r2, Funnel.class, "com.obric.memorydata.plugin"), r3);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r2, int r3, double r4) {
        return create((Funnel) ZeusTransformUtils.wrapperContextForParams(r2, Funnel.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r2, long r3) {
        return create((Funnel) ZeusTransformUtils.wrapperContextForParams(r2, Funnel.class, "com.obric.memorydata.plugin"), r3, 0.03d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r6, long r7, double r9) {
        return create((Funnel) ZeusTransformUtils.wrapperContextForParams(r6, Funnel.class, "com.obric.memorydata.plugin"), r7, r9, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    static <T> BloomFilter<T> create(Funnel<? super T> r6, long r7, double r9, Strategy r11) {
        Funnel r8 = (Funnel) ZeusTransformUtils.wrapperContextForParams(r6, Funnel.class, "com.obric.memorydata.plugin");
        Strategy r12 = (Strategy) ZeusTransformUtils.wrapperContextForParams(r11, Strategy.class, "com.obric.memorydata.plugin");
        n.a(r8);
        boolean r1 = true;
        if (r7 < 0) goto L5;
        boolean r3 = true;
    L6:
        n.a(r3, "Expected insertions (%s) must be >= 0", r7);
        if (r9 <= 0.0d) goto L9;
        boolean r4 = true;
    L10:
        n.a(r4, "False positive probability (%s) must be > 0.0", Double.valueOf(r9));
        if (r9 < 1.0d) goto L14;
        r1 = false;
    L14:
        n.a(r1, "False positive probability (%s) must be < 1.0", Double.valueOf(r9));
        n.a(r12);
        if (r7 != 0) goto L17;
        r7 = 1;
    L17:
        long r10 = optimalNumOfBits(r7, r9);
        return new BloomFilter(new BloomFilterStrategies.a(r10), optimalNumOfHashFunctions(r7, r10), r8, r12);
    L20:
        e = move-exception;
        throw new IllegalArgumentException("Could not create BloomFilter of " + r10 + " bits", e);
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    static /* synthetic */ BloomFilter lambda$toBloomFilter$0(Funnel r2, long r3, double r5) {
        return create((Funnel) ZeusTransformUtils.wrapperContextForParams(r2, Funnel.class, "com.obric.memorydata.plugin"), r3, r5);
    }

    static /* synthetic */ BloomFilter lambda$toBloomFilter$1(BloomFilter r0, BloomFilter r1) {
        r0.putAll(r1);
        return r0;
    }

    static long optimalNumOfBits(long r2, double r4) {
        if (r4 != 0.0d) goto L6;
        r4 = Double.MIN_VALUE;
    L6:
        return (long) (((-r2) * Math.log(r4)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    static int optimalNumOfHashFunctions(long r0, long r2) {
        return Math.max(1, (int) Math.round((r2 / r0) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream r10, Funnel<? super T> r11) {
        Funnel r12 = (Funnel) ZeusTransformUtils.wrapperContextForParams(r11, Funnel.class, "com.obric.memorydata.plugin");
        n.a(r10, "InputStream");
        n.a(r12, "Funnel");
        int r0 = -1;
        DataInputStream r1 = new DataInputStream(r10);     // Catch: RuntimeException -> L14
        byte r13 = r1.readByte();     // Catch: RuntimeException -> L14
        int r2 = UnsignedBytes.a(r1.readByte());     // Catch: RuntimeException -> L12
        r0 = r1.readInt();     // Catch: RuntimeException -> L10
        BloomFilterStrategies r3 = BloomFilterStrategies.values()[r13];     // Catch: RuntimeException -> L10
        BloomFilterStrategies.a r4 = new BloomFilterStrategies.a(LongMath.a(r0, 64));     // Catch: RuntimeException -> L10
        int r5 = 0;
    L6:
        if (r5 >= r0) goto L8;
        r4.a(r5, r1.readLong());     // Catch: RuntimeException -> L10
        r5 = r5 + 1;     // Catch: RuntimeException -> L10
        goto L6
    L8:
        return new BloomFilter(r4, r2, r12, r3);
    L10:
        e = e;
        int r9 = r0;
        r0 = r13;
        int r14 = r9;
    L17:
        throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + r0 + " numHashFunctions: " + r2 + " dataLength: " + r14, e);
    L12:
        e = e;
        r2 = -1;
        r0 = r13;
        r14 = -1;
    L14:
        e = e;
        r14 = -1;
        r2 = -1;
        goto L17
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> r2, long r3) {
        return toBloomFilter((Funnel) ZeusTransformUtils.wrapperContextForParams(r2, Funnel.class, "com.obric.memorydata.plugin"), r3, 0.03d);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> r8, final long r9, final double r11) {
        final Funnel r1 = (Funnel) ZeusTransformUtils.wrapperContextForParams(r8, Funnel.class, "com.obric.memorydata.plugin");
        n.a(r1);
        if (r9 < 0) goto L5;
        boolean r10 = true;
    L6:
        n.a(r10, "Expected insertions (%s) must be >= 0", r9);
        if (r11 <= 0.0d) goto L9;
        boolean r12 = true;
    L10:
        n.a(r12, "False positive probability (%s) must be > 0.0", Double.valueOf(r11));
        if (r11 >= 1.0d) goto L13;
        boolean r13 = true;
    L14:
        n.a(r13, "False positive probability (%s) must be < 1.0", Double.valueOf(r11));
        return Collector.of(new $$Lambda$BloomFilter$bYHgOZxJftGbm8MSCPdAxjcRRqQ(r1, r9, r11), $$Lambda$34GNz1QOsrD1VhFshY69jjgHBY.INSTANCE, $$Lambda$BloomFilter$pSEydPrAyNXsjsY_dCh1gp0mtI.INSTANCE, new Collector.Characteristics[]{Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT});
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = false;
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.o
    @Deprecated
    public boolean apply(T r1) {
        return mightContain(r1);
    }

    public long approximateElementCount() {
        double r0 = this.bits.a();
        return com.google.common.math.a.b(((-Math.log1p(-(this.bits.b() / r0))) * r0) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    long bitSize() {
        return this.bits.a();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.o
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BloomFilter.class) == false) goto L18;
        BloomFilter r6 = (BloomFilter) ZeusTransformUtils.preCheckCast(r5, BloomFilter.class, "com.obric.memorydata.plugin");
        if (this.numHashFunctions != r6.numHashFunctions) goto L17;
        if (this.funnel.equals(r6.funnel) == false) goto L17;
        if (this.bits.equals(r6.bits) == false) goto L17;
        if (this.strategy.equals(r6.strategy) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public double expectedFpp() {
        return Math.pow(this.bits.b() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return com.google.common.base.k.a(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
    }

    public boolean isCompatible(BloomFilter<T> r5) {
        n.a(r5);
        if (this != r5) goto L5;
    L13:
        return false;
    L5:
        if (this.numHashFunctions != r5.numHashFunctions) goto L13;
        if (bitSize() != r5.bitSize()) goto L13;
        if (this.strategy.equals(r5.strategy) == false) goto L13;
        if (this.funnel.equals(r5.funnel) == false) goto L13;
        return true;
    }

    public boolean mightContain(T r4) {
        return this.strategy.mightContain(r4, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T r4) {
        return this.strategy.put(r4, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> r10) {
        n.a(r10);
        if (this == r10) goto L5;
        boolean r2 = true;
    L6:
        n.a(r2, "Cannot combine a BloomFilter with itself.");
        int r3 = this.numHashFunctions;
        int r4 = r10.numHashFunctions;
        if (r3 != r4) goto L9;
        boolean r5 = true;
    L10:
        n.a(r5, "BloomFilters must have the same number of hash functions (%s != %s)", r3, r4);
        if (bitSize() != r10.bitSize()) goto L13;
        boolean r6 = true;
    L14:
        n.a(r6, "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), r10.bitSize());
        n.a(this.strategy.equals(r10.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, r10.strategy);
        n.a(this.funnel.equals(r10.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, r10.funnel);
        this.bits.a(r10.bits);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public void writeTo(OutputStream r4) {
        DataOutputStream r0 = new DataOutputStream(r4);
        r0.writeByte(SignedBytes.a(this.strategy.ordinal()));
        r0.writeByte(UnsignedBytes.a(this.numHashFunctions));
        r0.writeInt(this.bits.f4709a.length());
        int r5 = 0;
    L4:
        if (r5 >= this.bits.f4709a.length()) goto L6;
        r0.writeLong(this.bits.f4709a.get(r5));
        r5 = r5 + 1;
        goto L4
    }
}
