package com.google.common.math;

import ai.j0;
import com.google.common.base.b0;
import com.google.common.base.w;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
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

    public Stats(long r5, double r10, double r11, double r12, double r13) {
        this.count = r5;
        this.mean = r10;
        this.sumOfSquaresOfDeltas = r11;
        this.min = r12;
        this.max = r13;
    }

    public static Stats fromByteArray(byte[] r5) {
        r5.getClass();
        if (r5.length != 40) goto L5;
        boolean r10 = true;
    L6:
        b0.e("Expected Stats.BYTES = %s remaining , got %s", 40, r5.length, r10);
        return readFrom(ByteBuffer.wrap(r5).order(ByteOrder.LITTLE_ENDIAN));
    L5:
        r10 = false;
        goto L6
    }

    public static double meanOf(Iterable<? extends Number> r5) {
        return meanOf(r5.iterator());
    }

    public static Stats of(Iterable<? extends Number> r22) {
        Iterator<? extends Number> r5 = r22.iterator();
        long r10 = 0;
        long r11 = 0;
        double r12 = 0.0d;
        double r18 = 0.0d;
        double r13 = Double.NaN;
        double r14 = Double.NaN;
    L4:
        if (r5.hasNext() == false) goto L20;
        double r15 = r5.next().doubleValue();
        if (r11 == r10) goto L8;
        r11 = r11 + 1;
        if (com.google.common.primitives.a.s(r15) == true) goto L14;
    L16:
        double r16 = r15;
        r12 = l.c(r12, r16);
        double r17 = Double.NaN;
    L17:
        r13 = Math.min(r13, r16);
        r14 = Math.max(r14, r16);
        r18 = r17;
    L18:
        r10 = 0;
        goto L4
    L14:
        if (com.google.common.primitives.a.s(r12) == false) goto L16;
        double r19 = r15 - r12;
        double r20 = (r19 / r11) + r12;
        r17 = j0.a(r15, r20, r19, r18);
        r16 = r15;
        r12 = r20;
        goto L17
    L8:
        if (com.google.common.primitives.a.s(r15) == true) goto L10;
        r13 = r15;
        r12 = r13;
        r14 = r12;
        r11 = 1;
        r18 = Double.NaN;
        goto L18
    L10:
        r13 = r15;
        r12 = r13;
        r14 = r12;
        r11 = 1;
        goto L18
    L20:
        return new Stats(r11, r12, r18, r13, r14);
    }

    public static Stats readFrom(ByteBuffer r15) {
        r15.getClass();
        if (r15.remaining() < 40) goto L5;
        boolean r5 = true;
    L6:
        b0.e("Expected at least Stats.BYTES = %s remaining , got %s", 40, r15.remaining(), r5);
        return new Stats(r15.getLong(), r15.getDouble(), r15.getDouble(), r15.getDouble(), r15.getDouble());
    L5:
        r5 = false;
        goto L6
    }

    public static Collector<Number, l, Stats> toStats() {
        return Collector.of(new androidx.emoji2.text.flatbuffer.a(1), new com.google.common.hash.e(2), new com.google.common.hash.f(1), new com.google.android.material.color.utilities.h(2), new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (Stats.class == r10.getClass()) goto L8;
        return false;
    L8:
        Stats r11 = (Stats) r10;
        if (this.count == r11.count) goto L11;
        return false;
    L11:
        if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(r11.mean)) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(r11.sumOfSquaresOfDeltas)) goto L15;
        return false;
    L15:
        if (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(r11.min)) goto L17;
        return false;
    L17:
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(r11.max)) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)});
    }

    public double max() {
        if (this.count == 0) goto L5;
        boolean r5 = true;
    L6:
        b0.t(r5);
        return this.max;
    L5:
        r5 = false;
        goto L6
    }

    public double mean() {
        if (this.count == 0) goto L5;
        boolean r5 = true;
    L6:
        b0.t(r5);
        return this.mean;
    L5:
        r5 = false;
        goto L6
    }

    public double min() {
        if (this.count == 0) goto L5;
        boolean r5 = true;
    L6:
        b0.t(r5);
        return this.min;
    L5:
        r5 = false;
        goto L6
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        if (this.count <= 0) goto L5;
        boolean r5 = true;
    L6:
        b0.t(r5);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L11;
        return Double.NaN;
    L11:
        if (this.count != 1) goto L13;
        return 0.0d;
    L13:
        double r10 = this.sumOfSquaresOfDeltas;
        b0.i(!Double.isNaN(r10));
        return Math.max(r10, 0.0d) / count();
    L5:
        r5 = false;
        goto L6
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        if (this.count <= 1) goto L5;
        boolean r5 = true;
    L6:
        b0.t(r5);
        if (Double.isNaN(this.sumOfSquaresOfDeltas) == false) goto L10;
        return Double.NaN;
    L10:
        double r10 = this.sumOfSquaresOfDeltas;
        b0.i(!Double.isNaN(r10));
        return Math.max(r10, 0.0d) / (this.count - 1);
    L5:
        r5 = false;
        goto L6
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer r5 = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(r5);
        return r5.array();
    }

    public String toString() {
        if (count() <= 0) goto L6;
        w r5 = b0.E(this);
        r5.a(this.count, "count");
        r5.c("mean", String.valueOf(this.mean));
        r5.c("populationStandardDeviation", String.valueOf(populationStandardDeviation()));
        r5.c("min", String.valueOf(this.min));
        r5.c("max", String.valueOf(this.max));
        return r5.toString();
    L6:
        w r10 = b0.E(this);
        r10.a(this.count, "count");
        return r10.toString();
    }

    public void writeTo(ByteBuffer r5) {
        r5.getClass();
        if (r5.remaining() < 40) goto L5;
        boolean r10 = true;
    L6:
        b0.e("Expected at least Stats.BYTES = %s remaining , got %s", 40, r5.remaining(), r10);
        r5.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static double meanOf(Iterator<? extends Number> r10) {
        b0.i(r10.hasNext());
        double r5 = r10.next().doubleValue();
        long r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L11;
        double r12 = r10.next().doubleValue();
        r11 = r11 + 1;
        if (com.google.common.primitives.a.s(r12) == false) goto L10;
        if (com.google.common.primitives.a.s(r5) == false) goto L10;
        r5 = ((r12 - r5) / r11) + r5;
    L10:
        r5 = l.c(r5, r12);
        goto L4
    L11:
        return r5;
    }

    public static double meanOf(double... r10) {
        int r5 = 1;
        if (r10.length <= 0) goto L5;
        boolean r11 = true;
    L6:
        b0.i(r11);
        double r12 = r10[0];
    L8:
        if (r5 >= r10.length) goto L16;
        double r13 = r10[r5];
        if (com.google.common.primitives.a.s(r13) == true) goto L12;
    L14:
        r12 = l.c(r12, r13);
    L15:
        r5 = r5 + 1;
        goto L8
    L12:
        if (com.google.common.primitives.a.s(r12) == false) goto L14;
        r12 = ((r13 - r12) / ((double) (r5 + 1))) + r12;
        goto L15
    L16:
        return r12;
    L5:
        r11 = false;
        goto L6
    }

    public static Stats of(Iterator<? extends Number> r21) {
        long r5 = 0;
        long r10 = 0;
        double r11 = 0.0d;
        double r17 = 0.0d;
        double r12 = Double.NaN;
        double r13 = Double.NaN;
    L4:
        if (r21.hasNext() == false) goto L20;
        double r14 = r21.next().doubleValue();
        if (r10 == r5) goto L8;
        r10 = r10 + 1;
        if (com.google.common.primitives.a.s(r14) == true) goto L14;
    L16:
        double r15 = r14;
        r11 = l.c(r11, r15);
        double r16 = Double.NaN;
    L17:
        r12 = Math.min(r12, r15);
        r13 = Math.max(r13, r15);
        r17 = r16;
    L18:
        r5 = 0;
        goto L4
    L14:
        if (com.google.common.primitives.a.s(r11) == false) goto L16;
        double r18 = r14 - r11;
        double r19 = (r18 / r10) + r11;
        r16 = j0.a(r14, r19, r18, r17);
        r15 = r14;
        r11 = r19;
        goto L17
    L8:
        if (com.google.common.primitives.a.s(r14) == true) goto L10;
        r12 = r14;
        r11 = r12;
        r13 = r11;
        r10 = 1;
        r17 = Double.NaN;
        goto L18
    L10:
        r12 = r14;
        r11 = r12;
        r13 = r11;
        r10 = 1;
        goto L18
    L20:
        return new Stats(r10, r11, r17, r12, r13);
    }

    public static double meanOf(int... r10) {
        int r5 = 1;
        if (r10.length <= 0) goto L5;
        boolean r11 = true;
    L6:
        b0.i(r11);
        double r12 = r10[0];
    L8:
        if (r5 >= r10.length) goto L16;
        double r13 = r10[r5];
        if (com.google.common.primitives.a.s(r13) == true) goto L12;
    L14:
        r12 = l.c(r12, r13);
    L15:
        r5 = r5 + 1;
        goto L8
    L12:
        if (com.google.common.primitives.a.s(r12) == false) goto L14;
        r12 = ((r13 - r12) / ((double) (r5 + 1))) + r12;
        goto L15
    L16:
        return r12;
    L5:
        r11 = false;
        goto L6
    }

    public static Stats of(double... r24) {
        int r5 = r24.length;
        long r10 = 0;
        int r11 = 0;
        long r12 = 0;
        double r13 = 0.0d;
        double r20 = 0.0d;
        double r14 = Double.NaN;
        double r15 = Double.NaN;
    L3:
        if (r11 >= r5) goto L19;
        double r16 = r24[r11];
        if (r12 == r10) goto L7;
        r12 = r12 + 1;
        if (com.google.common.primitives.a.s(r16) == true) goto L13;
    L15:
        double r17 = r15;
        r13 = l.c(r13, r16);
        double r18 = Double.NaN;
    L16:
        r14 = Math.min(r14, r16);
        r20 = r18;
        r15 = Math.max(r17, r16);
    L17:
        r11 = r11 + 1;
        r10 = 0;
        goto L3
    L13:
        if (com.google.common.primitives.a.s(r13) == false) goto L15;
        double r19 = r16 - r13;
        double r21 = (r19 / r12) + r13;
        double r110 = r15;
        r18 = j0.a(r16, r21, r19, r20);
        r17 = r110;
        r13 = r21;
        goto L16
    L7:
        if (com.google.common.primitives.a.s(r16) == true) goto L9;
        r14 = r16;
        r13 = r14;
        r15 = r13;
        r12 = 1;
        r20 = Double.NaN;
        goto L17
    L9:
        r14 = r16;
        r13 = r14;
        r15 = r13;
        r12 = 1;
        goto L17
    L19:
        return new Stats(r12, r13, r20, r14, r15);
    }

    public static double meanOf(long... r10) {
        int r5 = 1;
        if (r10.length <= 0) goto L5;
        boolean r11 = true;
    L6:
        b0.i(r11);
        double r12 = r10[0];
    L8:
        if (r5 >= r10.length) goto L16;
        double r13 = r10[r5];
        if (com.google.common.primitives.a.s(r13) == true) goto L12;
    L14:
        r12 = l.c(r12, r13);
    L15:
        r5 = r5 + 1;
        goto L8
    L12:
        if (com.google.common.primitives.a.s(r12) == false) goto L14;
        r12 = ((r13 - r12) / ((double) (r5 + 1))) + r12;
        goto L15
    L16:
        return r12;
    L5:
        r11 = false;
        goto L6
    }

    public static Stats of(int... r24) {
        int r5 = r24.length;
        long r10 = 0;
        int r11 = 0;
        long r12 = 0;
        double r13 = 0.0d;
        double r20 = 0.0d;
        double r14 = Double.NaN;
        double r15 = Double.NaN;
    L3:
        if (r11 >= r5) goto L19;
        double r16 = r24[r11];
        if (r12 == r10) goto L7;
        r12 = r12 + 1;
        if (com.google.common.primitives.a.s(r16) == true) goto L13;
    L15:
        double r17 = r15;
        r13 = l.c(r13, r16);
        double r18 = Double.NaN;
    L16:
        r14 = Math.min(r14, r16);
        r20 = r18;
        r15 = Math.max(r17, r16);
    L17:
        r11 = r11 + 1;
        r10 = 0;
        goto L3
    L13:
        if (com.google.common.primitives.a.s(r13) == false) goto L15;
        double r19 = r16 - r13;
        double r21 = (r19 / r12) + r13;
        double r110 = r15;
        r18 = j0.a(r16, r21, r19, r20);
        r17 = r110;
        r13 = r21;
        goto L16
    L7:
        if (com.google.common.primitives.a.s(r16) == true) goto L9;
        r14 = r16;
        r13 = r14;
        r15 = r13;
        r12 = 1;
        r20 = Double.NaN;
        goto L17
    L9:
        r14 = r16;
        r13 = r14;
        r15 = r13;
        r12 = 1;
        goto L17
    L19:
        return new Stats(r12, r13, r20, r14, r15);
    }

    public static Stats of(long... r24) {
        int r5 = r24.length;
        long r10 = 0;
        int r11 = 0;
        long r12 = 0;
        double r13 = 0.0d;
        double r20 = 0.0d;
        double r14 = Double.NaN;
        double r15 = Double.NaN;
    L3:
        if (r11 >= r5) goto L19;
        double r16 = r24[r11];
        if (r12 == r10) goto L7;
        r12 = r12 + 1;
        if (com.google.common.primitives.a.s(r16) == true) goto L13;
    L15:
        double r17 = r15;
        r13 = l.c(r13, r16);
        double r18 = Double.NaN;
    L16:
        r14 = Math.min(r14, r16);
        r20 = r18;
        r15 = Math.max(r17, r16);
    L17:
        r11 = r11 + 1;
        r10 = 0;
        goto L3
    L13:
        if (com.google.common.primitives.a.s(r13) == false) goto L15;
        double r19 = r16 - r13;
        double r21 = (r19 / r12) + r13;
        double r110 = r15;
        r18 = j0.a(r16, r21, r19, r20);
        r17 = r110;
        r13 = r21;
        goto L16
    L7:
        if (com.google.common.primitives.a.s(r16) == true) goto L9;
        r14 = r16;
        r13 = r14;
        r15 = r13;
        r12 = 1;
        r20 = Double.NaN;
        goto L17
    L9:
        r14 = r16;
        r13 = r14;
        r15 = r13;
        r12 = 1;
        goto L17
    L19:
        return new Stats(r12, r13, r20, r14, r15);
    }

    public static Stats of(DoubleStream r5) {
        return ((l) r5.collect(new androidx.emoji2.text.flatbuffer.a(1), new k(), new com.google.common.hash.e(1))).d();
    }

    public static Stats of(IntStream r5) {
        return ((l) r5.collect(new androidx.emoji2.text.flatbuffer.a(1), new j(), new com.google.common.hash.e(1))).d();
    }

    public static Stats of(LongStream r5) {
        return ((l) r5.collect(new androidx.emoji2.text.flatbuffer.a(1), new i(), new com.google.common.hash.e(1))).d();
    }
}
