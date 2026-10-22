package com.google.common.math;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.common.base.i;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.primitives.Doubles;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/* JADX INFO: loaded from: classes2.dex */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    Stats(long r1, double r3, double r5, double r7, double r9) {
        this.count = r1;
        this.mean = r3;
        this.sumOfSquaresOfDeltas = r5;
        this.min = r7;
        this.max = r9;
    }

    public static Stats fromByteArray(byte[] r4) {
        n.a(r4);
        if (r4.length != 40) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "Expected Stats.BYTES = %s remaining , got %s", 40, r4.length);
        return readFrom(ByteBuffer.wrap(r4).order(ByteOrder.LITTLE_ENDIAN));
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ void lambda$toStats$0(f r2, Number r3) {
        r2.a(r3.doubleValue());
    }

    static /* synthetic */ f lambda$toStats$1(f r0, f r1) {
        r0.a(r1);
        return r0;
    }

    public static double meanOf(Iterable<? extends Number> r2) {
        return meanOf(((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator());
    }

    public static double meanOf(Iterator<? extends Number> r12) {
        Iterator r13 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r12, Iterator.class, "com.obric.memorydata.plugin");
        n.a(r13.hasNext());
        double r2 = ((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        long r6 = 1;
    L4:
        if (r13.hasNext() == false) goto L11;
        double r8 = ((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).doubleValue();
        r6 = r6 + 1;
        if (Doubles.b(r8) == false) goto L10;
        if (Doubles.b(r2) == false) goto L10;
        r2 = r2 + ((r8 - r2) / r6);
    L10:
        r2 = f.a(r2, r8);
        goto L4
    L11:
        return r2;
    }

    public static double meanOf(double... r7) {
        int r2 = 1;
        if (r7.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0);
        double r1 = r7[0];
    L8:
        if (r2 >= r7.length) goto L16;
        double r3 = r7[r2];
        if (Doubles.b(r3) == true) goto L12;
    L14:
        r1 = f.a(r1, r3);
    L15:
        r2 = r2 + 1;
        goto L8
    L12:
        if (Doubles.b(r1) == false) goto L14;
        r1 = r1 + ((r3 - r1) / ((double) (r2 + 1)));
        goto L15
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static double meanOf(int... r7) {
        int r2 = 1;
        if (r7.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0);
        double r1 = r7[0];
    L8:
        if (r2 >= r7.length) goto L16;
        double r3 = r7[r2];
        if (Doubles.b(r3) == true) goto L12;
    L14:
        r1 = f.a(r1, r3);
    L15:
        r2 = r2 + 1;
        goto L8
    L12:
        if (Doubles.b(r1) == false) goto L14;
        r1 = r1 + ((r3 - r1) / ((double) (r2 + 1)));
        goto L15
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static double meanOf(long... r7) {
        int r2 = 1;
        if (r7.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0);
        double r1 = r7[0];
    L8:
        if (r2 >= r7.length) goto L16;
        double r3 = r7[r2];
        if (Doubles.b(r3) == true) goto L12;
    L14:
        r1 = f.a(r1, r3);
    L15:
        r2 = r2 + 1;
        goto L8
    L12:
        if (Doubles.b(r1) == false) goto L14;
        r1 = r1 + ((r3 - r1) / ((double) (r2 + 1)));
        goto L15
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static Stats of(Iterable<? extends Number> r2) {
        Iterable<? extends Number> r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        f r0 = new f();
        r0.a(r3);
        return r0.a();
    }

    public static Stats of(Iterator<? extends Number> r2) {
        Iterator<? extends Number> r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        f r0 = new f();
        r0.a(r3);
        return r0.a();
    }

    public static Stats of(DoubleStream r4) {
        return ((f) ZeusTransformUtils.preCheckCast(((DoubleStream) ZeusTransformUtils.wrapperContextForParams(r4, DoubleStream.class, "com.obric.memorydata.plugin")).collect($$Lambda$6OdRcFW3J9SIRJifXnbgaTTCoqg.INSTANCE, $$Lambda$2SBnuMnM8HM0PmZSo8IhLWc8UBk.INSTANCE, $$Lambda$RkeXSiU0crO5frg1wUobL1hDzg.INSTANCE), f.class, "com.obric.memorydata.plugin")).a();
    }

    public static Stats of(IntStream r4) {
        return ((f) ZeusTransformUtils.preCheckCast(((IntStream) ZeusTransformUtils.wrapperContextForParams(r4, IntStream.class, "com.obric.memorydata.plugin")).collect($$Lambda$6OdRcFW3J9SIRJifXnbgaTTCoqg.INSTANCE, $$Lambda$Eq32b9XNAiyZTjeejUFzmdPS8Qg.INSTANCE, $$Lambda$RkeXSiU0crO5frg1wUobL1hDzg.INSTANCE), f.class, "com.obric.memorydata.plugin")).a();
    }

    public static Stats of(LongStream r4) {
        return ((f) ZeusTransformUtils.preCheckCast(((LongStream) ZeusTransformUtils.wrapperContextForParams(r4, LongStream.class, "com.obric.memorydata.plugin")).collect($$Lambda$6OdRcFW3J9SIRJifXnbgaTTCoqg.INSTANCE, $$Lambda$6tCj0r9EQmAgmD21KiHqznJ5TYU.INSTANCE, $$Lambda$RkeXSiU0crO5frg1wUobL1hDzg.INSTANCE), f.class, "com.obric.memorydata.plugin")).a();
    }

    public static Stats of(double... r1) {
        f r0 = new f();
        r0.a(r1);
        return r0.a();
    }

    public static Stats of(int... r1) {
        f r0 = new f();
        r0.a(r1);
        return r0.a();
    }

    public static Stats of(long... r1) {
        f r0 = new f();
        r0.a(r1);
        return r0.a();
    }

    static Stats readFrom(ByteBuffer r15) {
        n.a(r15);
        if (r15.remaining() < 40) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "Expected at least Stats.BYTES = %s remaining , got %s", 40, r15.remaining());
        return new Stats(r15.getLong(), r15.getDouble(), r15.getDouble(), r15.getDouble(), r15.getDouble());
    L5:
        r0 = false;
        goto L6
    }

    public static Collector<Number, f, Stats> toStats() {
        return Collector.of($$Lambda$6OdRcFW3J9SIRJifXnbgaTTCoqg.INSTANCE, $$Lambda$Stats$vJK4kMiN9boZMjcP0MXTdJ5n7vk.INSTANCE, $$Lambda$Stats$CsesmS_cxk7A_mjuh7wuMJKCH4Q.INSTANCE, $$Lambda$9L4HJBSX7NvbMtTk192fEffPGw.INSTANCE, new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if (getClass() == r6.getClass()) goto L8;
        return false;
    L8:
        Stats r7 = (Stats) ZeusTransformUtils.preCheckCast(r6, Stats.class, "com.obric.memorydata.plugin");
        if (this.count == r7.count) goto L11;
        return false;
    L11:
        if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(r7.mean)) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(r7.sumOfSquaresOfDeltas)) goto L15;
        return false;
    L15:
        if (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(r7.min)) goto L17;
        return false;
    L17:
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(r7.max)) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return k.a(new Object[]{Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)});
    }

    public double max() {
        if (this.count == 0) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        return this.max;
    L5:
        r0 = false;
        goto L6
    }

    public double mean() {
        if (this.count == 0) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        return this.mean;
    L5:
        r0 = false;
        goto L6
    }

    public double min() {
        if (this.count == 0) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        return this.min;
    L5:
        r0 = false;
        goto L6
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        if (this.count <= 0) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        if (this.count != 1) goto L15;
        return 0.0d;
    L15:
        return b.c(this.sumOfSquaresOfDeltas) / count();
    L5:
        r0 = false;
        goto L6
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        if (this.count <= 1) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        return b.c(this.sumOfSquaresOfDeltas) / (this.count - 1);
    L5:
        r0 = false;
        goto L6
    }

    public double sum() {
        return this.mean * this.count;
    }

    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer r0 = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(r0);
        return r0.array();
    }

    public String toString() {
        if (count() <= 0) goto L7;
        i.a r4 = i.a(this).a(CommonConsts.COUNT_TYPE, this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a("min", this.min).a("max", this.max);
    L6:
        return r4.toString();
    L7:
        r4 = i.a(this).a(CommonConsts.COUNT_TYPE, this.count);
        goto L6
    }

    void writeTo(ByteBuffer r5) {
        n.a(r5);
        if (r5.remaining() < 40) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "Expected at least Stats.BYTES = %s remaining , got %s", 40, r5.remaining());
        r5.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
