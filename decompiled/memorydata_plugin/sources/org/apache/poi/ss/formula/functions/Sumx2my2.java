package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: classes7.dex */
public final class Sumx2my2 extends XYNumericFunction {
    private static final XYNumericFunction.Accumulator XSquaredMinusYSquaredAccumulator = null;

    static {
        XSquaredMinusYSquaredAccumulator = $$Lambda$Sumx2my2$P8WcTBs4bLXzncPDMIXjEWKHgU.INSTANCE;
    }

    public Sumx2my2() {
    }

    static /* synthetic */ double lambda$static$0(double r0, double r2) {
        return (r0 * r0) - (r2 * r2);
    }

    @Override // org.apache.poi.ss.formula.functions.XYNumericFunction
    public XYNumericFunction.Accumulator createAccumulator() {
        return XSquaredMinusYSquaredAccumulator;
    }
}
