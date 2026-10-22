package org.apache.commons.math3.stat.descriptive.rank;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.KthSelector;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.MedianOf3PivotingStrategy;
import org.apache.commons.math3.util.PivotingStrategyInterface;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class Percentile extends AbstractUnivariateStatistic implements Serializable {
    private static final int MAX_CACHED_LEVELS = 10;
    private static final int PIVOTS_HEAP_LENGTH = 512;
    private static final long serialVersionUID = -8091216485095130416L;
    private int[] cachedPivots;
    private final EstimationType estimationType;
    private final KthSelector kthSelector;
    private final NaNStrategy nanStrategy;
    private double quantile;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.descriptive.rank.Percentile$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy = null;

        static {
            int[] r0 = new int[NaNStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy = r0;
            r0[NaNStrategy.MAXIMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.MINIMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.REMOVED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static abstract enum EstimationType extends Enum<EstimationType> {
        private static final /* synthetic */ EstimationType[] $VALUES = null;
        public static final EstimationType LEGACY = null;
        public static final EstimationType R_1 = null;
        public static final EstimationType R_2 = null;
        public static final EstimationType R_3 = null;
        public static final EstimationType R_4 = null;
        public static final EstimationType R_5 = null;
        public static final EstimationType R_6 = null;
        public static final EstimationType R_7 = null;
        public static final EstimationType R_8 = null;
        public static final EstimationType R_9 = null;
        private final String name;

        static {
            final String r1 = "LEGACY";
            final int r2 = 0;
            final String r3 = "Legacy Apache Commons Math";
            EstimationType r0 = new AnonymousClass1(r1, r2, r3);
            LEGACY = r0;
            final String r4 = "R_1";
            final int r5 = 1;
            final String r6 = "R-1";
            EstimationType r7 = new AnonymousClass2(r4, r5, r6);
            R_1 = r7;
            final String r8 = "R_2";
            final int r9 = 2;
            final String r10 = "R-2";
            EstimationType r11 = new AnonymousClass3(r8, r9, r10);
            R_2 = r11;
            final String r12 = "R_3";
            final int r13 = 3;
            final String r14 = "R-3";
            EstimationType r15 = new AnonymousClass4(r12, r13, r14);
            R_3 = r15;
            final String r16 = "R_4";
            final int r17 = 4;
            final String r18 = "R-4";
            EstimationType r19 = new AnonymousClass5(r16, r17, r18);
            R_4 = r19;
            final String r110 = "R_5";
            final int r111 = 5;
            final String r112 = "R-5";
            EstimationType r20 = new AnonymousClass6(r110, r111, r112);
            R_5 = r20;
            final String r113 = "R_6";
            final int r114 = 6;
            final String r115 = "R-6";
            EstimationType r116 = new AnonymousClass7(r113, r114, r115);
            R_6 = r116;
            final String r117 = "R_7";
            final int r118 = 7;
            final String r119 = "R-7";
            EstimationType r120 = new AnonymousClass8(r117, r118, r119);
            R_7 = r120;
            final String r121 = "R_8";
            final int r122 = 8;
            final String r123 = "R-8";
            EstimationType r124 = new AnonymousClass9(r121, r122, r123);
            R_8 = r124;
            final String r125 = "R_9";
            final int r126 = 9;
            final String r21 = "R-9";
            EstimationType r127 = new AnonymousClass10(r125, r126, r21);
            R_9 = r127;
            $VALUES = new EstimationType[]{r0, r7, r11, r15, r19, r20, r116, r120, r124, r127};
        }

        private EstimationType(String r1, int r2, String r3) {
            super(r1, r2);
            this.name = r3;
        }

        /* synthetic */ EstimationType(String r1, int r2, String r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        public static EstimationType valueOf(String r2) {
            return (EstimationType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EstimationType.class, r2), EstimationType.class, "com.obric.memorydata.plugin");
        }

        public static EstimationType[] values() {
            return (EstimationType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EstimationType[].class, "com.obric.memorydata.plugin");
        }

        public double estimate(double[] r5, int[] r6, double r7, int r9, KthSelector r10) {
            double r0 = FastMath.floor(r7);
            int r4 = (int) r0;
            double r1 = r7 - r0;
            if (r7 >= 1.0d) goto L7;
            return r10.select(r5, r6, 0);
        L7:
            if (r7 >= r9) goto L9;
            double r8 = r10.select(r5, r6, r4 - 1);
            return r8 + (r1 * (r10.select(r5, r6, r4) - r8));
        L9:
            return r10.select(r5, r6, r9 - 1);
        }

        public double evaluate(double[] r7, double r8, KthSelector r10) {
            return evaluate(r7, null, r8, r10);
        }

        public double evaluate(double[] r9, int[] r10, double r11, KthSelector r13) {
            MathUtils.checkNotNull(r9);
            if (r11 > 100.0d) goto L9;
            if (r11 <= 0.0d) goto L9;
            return estimate(r9, r10, index(r11 / 100.0d, r9.length), r9.length, r13);
        L9:
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(r11), 0, 100);
        }

        String getName() {
            return this.name;
        }

        public abstract double index(double r1, int r3);
    }

    public Percentile() {
        this(50.0d);
    }

    public Percentile(double r7) {
        this(r7, EstimationType.LEGACY, NaNStrategy.REMOVED, new KthSelector(new MedianOf3PivotingStrategy()));
    }

    public Percentile(double r1, EstimationType r3, NaNStrategy r4, KthSelector r5) {
        setQuantile(r1);
        this.cachedPivots = null;
        MathUtils.checkNotNull(r3);
        MathUtils.checkNotNull(r4);
        MathUtils.checkNotNull(r5);
        this.estimationType = r3;
        this.nanStrategy = r4;
        this.kthSelector = r5;
    }

    public Percentile(Percentile r5) {
        MathUtils.checkNotNull(r5);
        this.estimationType = r5.getEstimationType();
        this.nanStrategy = r5.getNaNStrategy();
        this.kthSelector = r5.getKthSelector();
        setData(r5.getDataRef());
        int[] r0 = r5.cachedPivots;
        if (r0 == null) goto L5;
        System.arraycopy(r0, 0, this.cachedPivots, 0, r0.length);
    L5:
        setQuantile(r5.quantile);
    }

    @Deprecated
    public static void copy(Percentile r0, Percentile r1) {
        throw new MathUnsupportedOperationException();
    }

    private static double[] copyOf(double[] r0, int r1, int r2) {
        MathArrays.verifyValues(r0, r1, r2);
        return MathArrays.copyOfRange(r0, r1, r2 + r1);
    }

    private int[] getPivots(double[] r2) {
        if (r2 == getDataRef()) goto L7;
        int[] r1 = new int[512];
        Arrays.fill(r1, -1);
        return r1;
    L7:
        return this.cachedPivots;
    }

    private static double[] removeAndSlice(double[] r5, int r6, int r7, double r8) {
        MathArrays.verifyValues(r5, r6, r7);
        BitSet r0 = new BitSet(r7);
        int r1 = r6;
    L3:
        int r2 = r6 + r7;
        if (r1 >= r2) goto L10;
        if (Precision.equalsIncludingNaN(r8, r5[r1]) == false) goto L8;
        r0.set(r1 - r6);
    L8:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r0.isEmpty() == true) goto L27;
        int r9 = 0;
        if (r0.cardinality() == r7) goto L28;
        double[] r10 = new double[r7 - r0.cardinality()];
        int r3 = r6;
        int r11 = 0;
    L16:
        int r4 = r0.nextSetBit(r9);
        if (r4 == (-1)) goto L19;
        int r12 = r4 - r9;
        System.arraycopy(r5, r3, r10, r11, r12);
        r11 = r11 + r12;
        r9 = r0.nextClearBit(r4);
        r3 = r6 + r9;
        goto L16
    L19:
        if (r3 >= r2) goto L22;
        System.arraycopy(r5, r3, r10, r11, r2 - r3);
    L22:
        return r10;
    L28:
        return new double[0];
    L27:
        return copyOf(r5, r6, r7);
    }

    private static double[] replaceAndSlice(double[] r2, int r3, int r4, double r5, double r7) {
        double[] r6 = copyOf(r2, r3, r4);
        int r8 = 0;
    L3:
        if (r8 >= r4) goto L9;
        if (Precision.equalsIncludingNaN(r5, r6[r8]) == false) goto L7;
        double r0 = r7;
    L8:
        r6[r8] = r0;
        r8 = r8 + 1;
        goto L3
    L7:
        r0 = r6[r8];
        goto L8
    L9:
        return r6;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Percentile copy() {
        return new Percentile(this);
    }

    public double evaluate(double r2) {
        return evaluate(getDataRef(), r2);
    }

    public double evaluate(double[] r8, double r9) {
        test(r8, 0, 0);
        return evaluate(r8, 0, r8.length, r9);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r7, int r8, int r9) {
        return evaluate(r7, r8, r9, this.quantile);
    }

    public double evaluate(double[] r7, int r8, int r9, double r10) {
        test(r7, r8, r9);
        if (r10 > 100.0d) goto L19;
        if (r10 <= 0.0d) goto L19;
        if (r9 != 0) goto L10;
        return Double.NaN;
    L10:
        if (r9 == 1) goto L12;
        double[] r11 = getWorkArray(r7, r8, r9);
        int[] r2 = getPivots(r7);
        if (r11.length != 0) goto L17;
        return Double.NaN;
    L17:
        return this.estimationType.evaluate(r11, r2, r10, this.kthSelector);
    L12:
        return r7[r8];
    L19:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(r10), 0, 100);
    }

    public EstimationType getEstimationType() {
        return this.estimationType;
    }

    public KthSelector getKthSelector() {
        return this.kthSelector;
    }

    public NaNStrategy getNaNStrategy() {
        return this.nanStrategy;
    }

    public PivotingStrategyInterface getPivotingStrategy() {
        return this.kthSelector.getPivotingStrategy();
    }

    public double getQuantile() {
        return this.quantile;
    }

    public double[] getWorkArray(double[] r8, int r9, int r10) {
        if (r8 == getDataRef()) goto L19;
        int r7 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[this.nanStrategy.ordinal()];
        if (r7 == 1) goto L18;
        if (r7 == 2) goto L23;
        if (r7 == 3) goto L22;
        if (r7 != 4) goto L20;
        double[] r11 = copyOf(r8, r9, r10);
        MathArrays.checkNotNaN(r11);
        return r11;
    L20:
        return copyOf(r8, r9, r10);
    L22:
        return removeAndSlice(r8, r9, r10, Double.NaN);
    L23:
        return replaceAndSlice(r8, r9, r10, Double.NaN, Double.NEGATIVE_INFINITY);
    L18:
        return replaceAndSlice(r8, r9, r10, Double.NaN, Double.POSITIVE_INFINITY);
    L19:
        return getDataRef();
    }

    @Deprecated
    int medianOf3(double[] r1, int r2, int r3) {
        return new MedianOf3PivotingStrategy().pivotIndex(r1, r2, r3);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic
    public void setData(double[] r3) {
        if (r3 != null) goto L4;
        this.cachedPivots = null;
    L5:
        super.setData(r3);
        return;
    L4:
        int[] r0 = new int[512];
        this.cachedPivots = r0;
        Arrays.fill(r0, -1);
        goto L5
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic
    public void setData(double[] r3, int r4, int r5) {
        if (r3 != null) goto L4;
        this.cachedPivots = null;
    L5:
        super.setData(r3, r4, r5);
        return;
    L4:
        int[] r0 = new int[512];
        this.cachedPivots = r0;
        Arrays.fill(r0, -1);
        goto L5
    }

    public void setQuantile(double r3) {
        if (r3 <= 0.0d) goto L9;
        if (r3 > 100.0d) goto L9;
        this.quantile = r3;
        return;
    L9:
        throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(r3), 0, 100);
    }

    public Percentile withEstimationType(EstimationType r8) {
        return new Percentile(this.quantile, r8, this.nanStrategy, this.kthSelector);
    }

    public Percentile withKthSelector(KthSelector r8) {
        return new Percentile(this.quantile, this.estimationType, this.nanStrategy, r8);
    }

    public Percentile withNaNStrategy(NaNStrategy r8) {
        return new Percentile(this.quantile, this.estimationType, r8, this.kthSelector);
    }
}
