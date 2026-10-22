package com.google.common.hash;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.stream.Collector;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class BloomFilter<T> implements com.google.common.base.z, Serializable {
    private final h bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        public SerialForm(BloomFilter<T> r5) {
            this.data = h.e(BloomFilter.access$000(r5).f9287a);
            this.numHashFunctions = BloomFilter.access$100(r5);
            this.funnel = BloomFilter.access$200(r5);
            this.strategy = BloomFilter.access$300(r5);
        }

        public Object readResolve() {
            return new BloomFilter(new h(this.data), this.numHashFunctions, this.funnel, this.strategy, null);
        }
    }

    public interface Strategy extends Serializable {
        <T> boolean mightContain(T r5, Funnel<? super T> r10, int r11, h r12);

        int ordinal();

        <T> boolean put(T r5, Funnel<? super T> r10, int r11, h r12);
    }

    public /* synthetic */ BloomFilter(h r5, int r10, Funnel r11, Strategy r12, g r13) {
        this(r5, r10, r11, r12);
    }

    public static /* synthetic */ h access$000(BloomFilter r5) {
        return r5.bits;
    }

    public static /* synthetic */ int access$100(BloomFilter r5) {
        return r5.numHashFunctions;
    }

    public static /* synthetic */ Funnel access$200(BloomFilter r5) {
        return r5.funnel;
    }

    public static /* synthetic */ Strategy access$300(BloomFilter r5) {
        return r5.strategy;
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r5, int r10, double r11) {
        return create(r5, r10, r11);
    }

    public static long optimalNumOfBits(long r5, double r10) {
        if (r10 != 0.0d) goto L6;
        r10 = Double.MIN_VALUE;
    L6:
        return (long) ((Math.log(r10) * (-r5)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    public static int optimalNumOfHashFunctions(long r5, long r10) {
        return Math.max(1, (int) Math.round(Math.log(2.0d) * (r10 / r5)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream r17, Funnel<? super T> r18) throws IOException {
        com.google.common.base.b0.n(r17, "InputStream");
        com.google.common.base.b0.n(r18, "Funnel");
        int r5 = -1;
        DataInputStream r10 = new DataInputStream(r17);     // Catch: RuntimeException -> L30
        byte r11 = r10.readByte();     // Catch: RuntimeException -> L30
        int r12 = r10.readByte() & UByte.MAX_VALUE;
        r5 = r10.readInt();     // Catch: RuntimeException -> L23
        BloomFilterStrategies r13 = BloomFilterStrategies.values()[r11];     // Catch: RuntimeException -> L23
        long r14 = r5;
        int r15 = Long.numberOfLeadingZeros(-65) + (Long.numberOfLeadingZeros(64) + (Long.numberOfLeadingZeros(~r14) + Long.numberOfLeadingZeros(r14)));     // Catch: RuntimeException -> L23
        int r16 = 0;
        if (r15 <= 65) goto L9;
        long r19 = r14 * 64;     // Catch: RuntimeException -> L23
    L20:
        h r20 = new h(r19);     // Catch: RuntimeException -> L23
    L21:
        if (r16 >= r5) goto L26;
        r20.c(r16, r10.readLong());     // Catch: RuntimeException -> L23
        r16 = r16 + 1;     // Catch: RuntimeException -> L23
        goto L21
    L26:
        return new BloomFilter(r20, r12, r18, r13);
    L9:
        boolean r110 = true;
        if (r15 < 64) goto L12;
        boolean r21 = true;
    L13:
        com.lynx.tasm.utils.j.k(r14, r21);     // Catch: RuntimeException -> L23
        long r111 = r14 * 64;     // Catch: RuntimeException -> L23
        if (r14 != 0) goto L16;
    L19:
        com.lynx.tasm.utils.j.k(r14, r110);     // Catch: RuntimeException -> L23
        r19 = r111;
        goto L20
    L16:
        if ((r111 / r14) == 64) goto L19;
        r110 = false;
        goto L19
    L12:
        r21 = false;
    L23:
        e = e;
        int r22 = r5;
    L25:
        r5 = r11;
    L32:
        StringBuilder r23 = new StringBuilder(134);
        r23.append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ");
        r23.append(r5);
        r23.append(" numHashFunctions: ");
        r23.append(r12);
        r23.append(" dataLength: ");
        r23.append(r22);
        throw new IOException(r23.toString(), e);
    L28:
        e = e;
        r22 = -1;
        r12 = -1;
    L30:
        e = e;
        r22 = -1;
        r12 = -1;
        goto L32
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> r5, long r10) {
        return toBloomFilter(r5, r10, 0.03d);
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.z
    @Deprecated
    public boolean apply(T r5) {
        return mightContain(r5);
    }

    public long approximateElementCount() {
        double r5 = this.bits.a();
        double r10 = ((-Math.log1p(-(this.bits.f9288b.sum() / r5))) * r5) / ((double) this.numHashFunctions);
        RoundingMode r11 = RoundingMode.HALF_UP;
        int r12 = com.google.common.math.b.f9304a;
        if (com.lynx.tasm.utils.e.i(r10) == false) goto L56;
        boolean r13 = true;
        switch(com.google.common.math.a.f9303a[r11.ordinal()]) {
            case 1: goto L37;
            case 2: goto L31;
            case 3: goto L24;
            case 4: goto L10;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L11;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        double r14 = Math.rint(r10);
        if (Math.abs(r10 - r14) != 0.5d) goto L40;
        r14 = r10;
    L40:
        if (((-9.223372036854776E18d) - r14) >= 1.0d) goto L42;
        boolean r15 = true;
    L44:
        if (r14 < 9.223372036854776E18d) goto L48;
        r13 = false;
    L48:
        if ((r15 & r13) == true) goto L50;
        String r16 = String.valueOf(r11);
        StringBuilder r17 = new StringBuilder(r16.length() + 83);
        r17.append("rounded value is out of range for input ");
        r17.append(r10);
        r17.append(" and rounding mode ");
        r17.append(r16);
        throw new ArithmeticException(r17.toString());
    L50:
        return (long) r14;
    L42:
        r15 = false;
        goto L44
    L10:
        r14 = r10;
        goto L40
    L11:
        r14 = Math.rint(r10);
        if (Math.abs(r10 - r14) != 0.5d) goto L40;
        r14 = Math.copySign(0.5d, r10) + r10;
        goto L40
    L14:
        r14 = Math.rint(r10);
        goto L40
    L7:
        throw new AssertionError();
    L16:
        if (com.google.common.math.b.a(r10) == true) goto L60;
        long r18 = (long) r10;
        if (r10 <= 0.0d) goto L21;
        int r19 = 1;
    L22:
        r14 = r18 + ((long) r19);
        goto L40
    L21:
        r19 = -1;
        goto L22
    L60:
        r14 = r10;
        goto L40
    L24:
        if (r10 > 0.0d) goto L26;
        r14 = r10;
        goto L40
    L26:
        if (com.google.common.math.b.a(r10) == true) goto L61;
        long r20 = ((long) r10) + 1;
    L29:
        r14 = r20;
        goto L40
    L61:
        r14 = r10;
        goto L40
    L31:
        if (r10 < 0.0d) goto L33;
        r14 = r10;
        goto L40
    L33:
        if (com.google.common.math.b.a(r10) == true) goto L62;
        r20 = ((long) r10) - 1;
        goto L29
    L62:
        r14 = r10;
        goto L40
    L37:
        if (com.google.common.math.b.a(r10) == false) goto L54;
        r14 = r10;
        goto L40
    L54:
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    L56:
        throw new ArithmeticException("input is infinite or NaN");
    }

    public long bitSize() {
        return this.bits.a();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter(new h(h.e(this.bits.f9287a)), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.z
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof BloomFilter) == false) goto L18;
        BloomFilter r10 = (BloomFilter) r5;
        if (this.numHashFunctions != r10.numHashFunctions) goto L17;
        if (this.funnel.equals(r10.funnel) == false) goto L17;
        if (this.bits.equals(r10.bits) == false) goto L17;
        if (this.strategy.equals(r10.strategy) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public double expectedFpp() {
        return Math.pow(this.bits.f9288b.sum() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits});
    }

    public boolean isCompatible(BloomFilter<T> r5) {
        r5.getClass();
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

    public boolean mightContain(T r5) {
        return this.strategy.mightContain(r5, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T r5) {
        return this.strategy.put(r5, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> r10) {
        r10.getClass();
        boolean r5 = true;
        int r11 = 0;
        if (this == r10) goto L5;
        boolean r12 = true;
    L6:
        com.google.common.base.b0.g("Cannot combine a BloomFilter with itself.", r12);
        int r13 = this.numHashFunctions;
        int r14 = r10.numHashFunctions;
        if (r13 != r14) goto L9;
        boolean r15 = true;
    L10:
        com.google.common.base.b0.e("BloomFilters must have the same number of hash functions (%s != %s)", r13, r14, r15);
        if (bitSize() != r10.bitSize()) goto L13;
        boolean r16 = true;
    L14:
        long r17 = bitSize();
        long r18 = r10.bitSize();
        if (r16 == false) goto L26;
        com.google.common.base.b0.k(this.strategy.equals(r10.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, r10.strategy);
        com.google.common.base.b0.k(this.funnel.equals(r10.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, r10.funnel);
        h r19 = this.bits;
        h r20 = r10.bits;
        AtomicLongArray r21 = r19.f9287a;
        if (r21.length() == r20.f9287a.length()) goto L20;
        r5 = false;
    L20:
        int r22 = r21.length();
        AtomicLongArray r23 = r20.f9287a;
        com.google.common.base.b0.e("BitArrays must be of equal length (%s != %s)", r22, r23.length(), r5);
    L22:
        if (r11 >= r21.length()) goto L24;
        r19.c(r11, r23.get(r11));
        r11 = r11 + 1;
        goto L22
    L24:
        return;
    L26:
        throw new IllegalArgumentException(com.google.common.base.b0.A("BloomFilters must have the same size underlying bit arrays (%s != %s)", new Object[]{Long.valueOf(r17), Long.valueOf(r18)}));
    L13:
        r16 = false;
        goto L14
    L9:
        r15 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.google.common.base.z, java.util.function.Predicate
    public boolean test(Object r5) {
        return apply(r5);
    }

    public void writeTo(OutputStream r11) throws IOException {
        DataOutputStream r5 = new DataOutputStream(r11);
        long r10 = this.strategy.ordinal();
        byte r12 = (byte) r10;
        int r13 = 0;
        boolean r14 = true;
        if (r12 != r10) goto L5;
        boolean r15 = true;
    L6:
        com.google.common.base.b0.f("Out of range: %s", r10, r15);
        r5.writeByte(r12);
        long r16 = this.numHashFunctions;
        if ((r16 >> 8) == 0) goto L10;
        r14 = false;
    L10:
        com.google.common.base.b0.f("out of range: %s", r16, r14);
        r5.writeByte((byte) r16);
        r5.writeInt(this.bits.f9287a.length());
    L12:
        if (r13 >= this.bits.f9287a.length()) goto L14;
        r5.writeLong(this.bits.f9287a.get(r13));
        r13 = r13 + 1;
        goto L12
    L14:
        return;
    L5:
        r15 = false;
        goto L6
    }

    public BloomFilter(h r5, int r10, Funnel r11, Strategy r12) {
        boolean r13 = false;
        if (r10 <= 0) goto L5;
        boolean r14 = true;
    L6:
        com.google.common.base.b0.d(r10, "numHashFunctions (%s) must be > 0", r14);
        if (r10 > 255) goto L9;
        r13 = true;
    L9:
        com.google.common.base.b0.d(r10, "numHashFunctions (%s) must be <= 255", r13);
        r5.getClass();
        this.bits = r5;
        this.numHashFunctions = r10;
        r11.getClass();
        this.funnel = r11;
        r12.getClass();
        this.strategy = r12;
        return;
    L5:
        r14 = false;
        goto L6
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r10, long r11, double r12) {
        return create(r10, r11, r12, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(final Funnel<? super T> r10, final long r11, final double r12) {
        r10.getClass();
        boolean r5 = false;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        com.google.common.base.b0.f("Expected insertions (%s) must be >= 0", r11, r13);
        if (r12 <= 0.0d) goto L9;
        boolean r14 = true;
    L10:
        com.google.common.base.b0.h("False positive probability (%s) must be > 0.0", r14, Double.valueOf(r12));
        if (r12 >= 1.0d) goto L13;
        r5 = true;
    L13:
        com.google.common.base.b0.h("False positive probability (%s) must be < 1.0", r5, Double.valueOf(r12));
        return Collector.of(new d(r10, r11, r12), new e(0), new f(0), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT});
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L6
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r5, int r10) {
        return create(r5, r10);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r5, long r10) {
        return create(r5, r10, 0.03d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> r10, long r11, double r12, Strategy r13) {
        r10.getClass();
        boolean r5 = false;
        if (r11 < 0) goto L5;
        boolean r14 = true;
    L6:
        com.google.common.base.b0.f("Expected insertions (%s) must be >= 0", r11, r14);
        if (r12 <= 0.0d) goto L9;
        boolean r15 = true;
    L10:
        com.google.common.base.b0.h("False positive probability (%s) must be > 0.0", r15, Double.valueOf(r12));
        if (r12 >= 1.0d) goto L13;
        r5 = true;
    L13:
        com.google.common.base.b0.h("False positive probability (%s) must be < 1.0", r5, Double.valueOf(r12));
        r13.getClass();
        if (r11 != 0) goto L16;
        r11 = 1;
    L16:
        long r16 = optimalNumOfBits(r11, r12);
        return new BloomFilter(new h(r16), optimalNumOfHashFunctions(r11, r16), r10, r13);
    L19:
        e = move-exception;
        StringBuilder r17 = new StringBuilder(57);
        r17.append("Could not create BloomFilter of ");
        r17.append(r16);
        r17.append(" bits");
        throw new IllegalArgumentException(r17.toString(), e);
    L9:
        r15 = false;
        goto L10
    L5:
        r14 = false;
        goto L6
    }
}
