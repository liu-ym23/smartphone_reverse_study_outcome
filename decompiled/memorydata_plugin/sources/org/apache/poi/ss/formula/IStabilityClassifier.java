package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: classes7.dex */
public interface IStabilityClassifier {
    public static final IStabilityClassifier TOTALLY_IMMUTABLE = null;

    static {
        TOTALLY_IMMUTABLE = $$Lambda$IStabilityClassifier$JtuhqmDEUnV9U_wSHGOp_6xfQ.INSTANCE;
    }

    static /* synthetic */ boolean lambda$static$0(int r0, int r1, int r2) {
        return true;
    }

    boolean isCellFinal(int r1, int r2, int r3);
}
