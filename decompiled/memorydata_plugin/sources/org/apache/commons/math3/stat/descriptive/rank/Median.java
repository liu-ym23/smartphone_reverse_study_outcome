package org.apache.commons.math3.stat.descriptive.rank;

import java.io.Serializable;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.util.KthSelector;

/* JADX INFO: loaded from: classes6.dex */
public class Median extends Percentile implements Serializable {
    private static final double FIXED_QUANTILE_50 = 50.0d;
    private static final long serialVersionUID = -3961477041290915687L;

    public Median() {
        super(FIXED_QUANTILE_50);
    }

    public Median(Median r1) {
        super(r1);
    }

    private Median(Percentile.EstimationType r7, NaNStrategy r8, KthSelector r9) {
        super(FIXED_QUANTILE_50, r7, r8, r9);
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public Median withEstimationType(Percentile.EstimationType r3) {
        return new Median(r3, getNaNStrategy(), getKthSelector());
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public /* bridge */ /* synthetic */ Percentile withEstimationType(Percentile.EstimationType r1) {
        return withEstimationType(r1);
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public Median withKthSelector(KthSelector r3) {
        return new Median(getEstimationType(), getNaNStrategy(), r3);
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public /* bridge */ /* synthetic */ Percentile withKthSelector(KthSelector r1) {
        return withKthSelector(r1);
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public Median withNaNStrategy(NaNStrategy r3) {
        return new Median(getEstimationType(), r3, getKthSelector());
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public /* bridge */ /* synthetic */ Percentile withNaNStrategy(NaNStrategy r1) {
        return withNaNStrategy(r1);
    }
}
