package com.google.common.math;

import com.google.common.base.b0;
import com.google.common.base.w;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class PairedStats implements Serializable {
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    public PairedStats(Stats r5, Stats r10, double r11) {
        this.xStats = r5;
        this.yStats = r10;
        this.sumOfProductsOfDeltas = r11;
    }

    public static PairedStats fromByteArray(byte[] r5) {
        r5.getClass();
        if (r5.length != 88) goto L5;
        boolean r10 = true;
    L6:
        b0.e("Expected PairedStats.BYTES = %s, got %s", 88, r5.length, r10);
        ByteBuffer r11 = ByteBuffer.wrap(r5).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(r11), Stats.readFrom(r11), r11.getDouble());
    L5:
        r10 = false;
        goto L6
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (PairedStats.class == r5.getClass()) goto L8;
        return false;
    L8:
        PairedStats r10 = (PairedStats) r5;
        if (this.xStats.equals(r10.xStats) == true) goto L11;
        return false;
    L11:
        if (this.yStats.equals(r10.yStats) == true) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfProductsOfDeltas) != Double.doubleToLongBits(r10.sumOfProductsOfDeltas)) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas)});
    }

    public g leastSquaresFit() {
        boolean r5 = false;
        if (count() <= 1) goto L5;
        boolean r10 = true;
    L6:
        b0.t(r10);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == true) goto L9;
        double r11 = this.xStats.sumOfSquaresOfDeltas();
        if (r11 <= 0.0d) goto L27;
        if (this.yStats.sumOfSquaresOfDeltas() <= 0.0d) goto L24;
        double r12 = this.xStats.mean();
        double r13 = this.yStats.mean();
        if (com.lynx.tasm.utils.e.i(r12) == true) goto L17;
    L19:
        b0.i(r5);
        double r14 = this.sumOfProductsOfDeltas / r11;
        b0.i(!Double.isNaN(r14));
        if (com.lynx.tasm.utils.e.i(r14) == false) goto L23;
        return new e(r14, r13 - (r12 * r14));
    L23:
        return new f(r12);
    L17:
        if (com.lynx.tasm.utils.e.i(r13) == false) goto L19;
        r5 = true;
        goto L19
    L24:
        double r15 = this.yStats.mean();
        b0.i(com.lynx.tasm.utils.e.i(r15));
        return new e(0.0d, r15);
    L27:
        if (this.yStats.sumOfSquaresOfDeltas() <= 0.0d) goto L29;
        r5 = true;
    L29:
        b0.t(r5);
        double r16 = this.xStats.mean();
        b0.i(com.lynx.tasm.utils.e.i(r16));
        return new f(r16);
    L9:
        return d.f9306a;
    L5:
        r10 = false;
        goto L6
    }

    public double pearsonsCorrelationCoefficient() {
        boolean r5 = false;
        if (count() <= 1) goto L5;
        boolean r10 = true;
    L6:
        b0.t(r10);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == false) goto L10;
        return Double.NaN;
    L10:
        double r11 = xStats().sumOfSquaresOfDeltas();
        double r12 = yStats().sumOfSquaresOfDeltas();
        if (r11 <= 0.0d) goto L13;
        boolean r13 = true;
    L14:
        b0.t(r13);
        if (r12 <= 0.0d) goto L17;
        r5 = true;
    L17:
        b0.t(r5);
        double r14 = r11 * r12;
        if (r14 > 0.0d) goto L21;
        r14 = Double.MIN_VALUE;
    L21:
        double r15 = this.sumOfProductsOfDeltas / Math.sqrt(r14);
        double r16 = 1.0d;
        if (r15 >= 1.0d) goto L27;
        r16 = -1.0d;
        if (r15 <= (-1.0d)) goto L27;
        return r15;
    L27:
        return r16;
    L13:
        r13 = false;
        goto L14
    L5:
        r10 = false;
        goto L6
    }

    public double populationCovariance() {
        if (count() == 0) goto L5;
        boolean r5 = true;
    L6:
        b0.t(r5);
        return this.sumOfProductsOfDeltas / count();
    L5:
        r5 = false;
        goto L6
    }

    public double sampleCovariance() {
        if (count() <= 1) goto L5;
        boolean r5 = true;
    L6:
        b0.t(r5);
        return this.sumOfProductsOfDeltas / (count() - 1);
    L5:
        r5 = false;
        goto L6
    }

    public double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer r5 = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(r5);
        this.yStats.writeTo(r5);
        r5.putDouble(this.sumOfProductsOfDeltas);
        return r5.array();
    }

    public String toString() {
        if (count() <= 0) goto L6;
        w r5 = b0.E(this);
        r5.b(this.xStats, "xStats");
        r5.b(this.yStats, "yStats");
        r5.c("populationCovariance", String.valueOf(populationCovariance()));
        return r5.toString();
    L6:
        w r10 = b0.E(this);
        r10.b(this.xStats, "xStats");
        r10.b(this.yStats, "yStats");
        return r10.toString();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
