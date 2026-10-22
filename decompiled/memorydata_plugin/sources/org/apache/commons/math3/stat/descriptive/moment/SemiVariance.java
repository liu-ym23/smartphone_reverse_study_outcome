package org.apache.commons.math3.stat.descriptive.moment;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SemiVariance extends AbstractUnivariateStatistic implements Serializable {
    public static final Direction DOWNSIDE_VARIANCE = null;
    public static final Direction UPSIDE_VARIANCE = null;
    private static final long serialVersionUID = -2653430366886024994L;
    private boolean biasCorrected;
    private Direction varianceDirection;

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction DOWNSIDE = null;
        public static final Direction UPSIDE = null;
        private boolean direction;

        static {
            Direction r0 = new Direction("UPSIDE", 0, true);
            UPSIDE = r0;
            Direction r1 = new Direction("DOWNSIDE", 1, false);
            DOWNSIDE = r1;
            $VALUES = new Direction[]{r0, r1};
        }

        private Direction(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.direction = r3;
        }

        public static Direction valueOf(String r2) {
            return (Direction) ZeusTransformUtils.preCheckCast(Enum.valueOf(Direction.class, r2), Direction.class, "com.obric.memorydata.plugin");
        }

        public static Direction[] values() {
            return (Direction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Direction[].class, "com.obric.memorydata.plugin");
        }

        boolean getDirection() {
            return this.direction;
        }
    }

    static {
        UPSIDE_VARIANCE = Direction.UPSIDE;
        DOWNSIDE_VARIANCE = Direction.DOWNSIDE;
    }

    public SemiVariance() {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
    }

    public SemiVariance(Direction r2) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        this.varianceDirection = r2;
    }

    public SemiVariance(SemiVariance r2) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        copy(r2, this);
    }

    public SemiVariance(boolean r2) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        this.biasCorrected = r2;
    }

    public SemiVariance(boolean r2, Direction r3) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        this.biasCorrected = r2;
        this.varianceDirection = r3;
    }

    public static void copy(SemiVariance r1, SemiVariance r2) {
        MathUtils.checkNotNull(r1);
        MathUtils.checkNotNull(r2);
        r2.setData(r1.getDataRef());
        r2.biasCorrected = r1.biasCorrected;
        r2.varianceDirection = r1.varianceDirection;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public SemiVariance copy() {
        SemiVariance r0 = new SemiVariance();
        copy(this, r0);
        return r0;
    }

    public double evaluate(double[] r9, double r10) {
        return evaluate(r9, r10, this.varianceDirection, this.biasCorrected, 0, r9.length);
    }

    public double evaluate(double[] r9, double r10, Direction r12) {
        return evaluate(r9, r10, r12, this.biasCorrected, 0, r9.length);
    }

    public double evaluate(double[] r6, double r7, Direction r9, boolean r10, int r11, int r12) {
        test(r6, r11, r12);
        if (r6.length != 0) goto L6;
        return Double.NaN;
    L6:
        double r0 = 0.0d;
        if (r6.length != 1) goto L9;
        return 0.0d;
    L9:
        boolean r5 = r9.getDirection();
    L10:
        if (r11 >= r12) goto L18;
        if (r6[r11] <= r7) goto L14;
        boolean r13 = true;
    L15:
        if (r13 != r5) goto L17;
        double r3 = r6[r11] - r7;
        r0 = r0 + (r3 * r3);
    L17:
        r11 = r11 + 1;
        goto L10
    L14:
        r13 = false;
        goto L15
    L18:
        double r8 = r12;
        if (r10 == false) goto L23;
        return r0 / (r8 - 1.0d);
    L23:
        return r0 / r8;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r10, int r11, int r12) {
        return evaluate(r10, new Mean().evaluate(r10, r11, r12), this.varianceDirection, this.biasCorrected, 0, r10.length);
    }

    public double evaluate(double[] r10, Direction r11) {
        return evaluate(r10, new Mean().evaluate(r10), r11, this.biasCorrected, 0, r10.length);
    }

    public Direction getVarianceDirection() {
        return this.varianceDirection;
    }

    public boolean isBiasCorrected() {
        return this.biasCorrected;
    }

    public void setBiasCorrected(boolean r1) {
        this.biasCorrected = r1;
    }

    public void setVarianceDirection(Direction r1) {
        this.varianceDirection = r1;
    }
}
