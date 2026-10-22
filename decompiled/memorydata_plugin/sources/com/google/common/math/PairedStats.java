package com.google.common.math;

import com.google.common.base.i;
import com.google.common.base.k;
import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class PairedStats implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    PairedStats(Stats r1, Stats r2, double r3) {
        this.xStats = r1;
        this.yStats = r2;
        this.sumOfProductsOfDeltas = r3;
    }

    private static double ensureInUnitRange(double r3) {
        if (r3 < 1.0d) goto L6;
        return 1.0d;
    L6:
        if (r3 > (-1.0d)) goto L8;
        return -1.0d;
    L8:
        return r3;
    }

    private static double ensurePositive(double r2) {
        if (r2 <= 0.0d) goto L5;
        return r2;
    L5:
        return Double.MIN_VALUE;
    }

    public static PairedStats fromByteArray(byte[] r4) {
        n.a(r4);
        if (r4.length != 88) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, "Expected PairedStats.BYTES = %s, got %s", 88, r4.length);
        ByteBuffer r5 = ByteBuffer.wrap(r4).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(r5), Stats.readFrom(r5), r5.getDouble());
    L5:
        r0 = false;
        goto L6
    }

    public long count() {
        return this.xStats.count();
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (getClass() == r4.getClass()) goto L8;
        return false;
    L8:
        PairedStats r5 = (PairedStats) ZeusTransformUtils.preCheckCast(r4, PairedStats.class, "com.obric.memorydata.plugin");
        if (this.xStats.equals(r5.xStats) == true) goto L11;
        return false;
    L11:
        if (this.yStats.equals(r5.yStats) == true) goto L13;
        return false;
    L13:
        if (Double.doubleToLongBits(this.sumOfProductsOfDeltas) != Double.doubleToLongBits(r5.sumOfProductsOfDeltas)) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return k.a(new Object[]{this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas)});
    }

    public d leastSquaresFit() {
        boolean r1 = true;
        if (count() <= 1) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == true) goto L9;
        double r3 = this.xStats.sumOfSquaresOfDeltas();
        if (r3 <= 0.0d) goto L19;
        if (this.yStats.sumOfSquaresOfDeltas() <= 0.0d) goto L17;
        return d.a(this.xStats.mean(), this.yStats.mean()).a(this.sumOfProductsOfDeltas / r3);
    L17:
        return d.b(this.yStats.mean());
    L19:
        if (this.yStats.sumOfSquaresOfDeltas() > 0.0d) goto L22;
        r1 = false;
    L22:
        n.b(r1);
        return d.a(this.xStats.mean());
    L9:
        return d.a();
    L5:
        r0 = false;
        goto L6
    }

    public double pearsonsCorrelationCoefficient() {
        boolean r1 = true;
        if (count() <= 1) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        if (Double.isNaN(this.sumOfProductsOfDeltas) == false) goto L10;
        return Double.NaN;
    L10:
        double r3 = xStats().sumOfSquaresOfDeltas();
        double r5 = yStats().sumOfSquaresOfDeltas();
        if (r3 <= 0.0d) goto L13;
        boolean r2 = true;
    L14:
        n.b(r2);
        if (r5 > 0.0d) goto L18;
        r1 = false;
    L18:
        n.b(r1);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(r3 * r5)));
    L13:
        r2 = false;
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    public double populationCovariance() {
        if (count() == 0) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        return this.sumOfProductsOfDeltas / count();
    L5:
        r0 = false;
        goto L6
    }

    public double sampleCovariance() {
        if (count() <= 1) goto L5;
        boolean r0 = true;
    L6:
        n.b(r0);
        return this.sumOfProductsOfDeltas / (count() - 1);
    L5:
        r0 = false;
        goto L6
    }

    double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer r0 = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(r0);
        this.yStats.writeTo(r0);
        r0.putDouble(this.sumOfProductsOfDeltas);
        return r0.array();
    }

    public String toString() {
        if (count() <= 0) goto L7;
        i.a r4 = i.a(this).a("xStats", this.xStats).a("yStats", this.yStats).a("populationCovariance", populationCovariance());
    L6:
        return r4.toString();
    L7:
        r4 = i.a(this).a("xStats", this.xStats).a("yStats", this.yStats);
        goto L6
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }
}
