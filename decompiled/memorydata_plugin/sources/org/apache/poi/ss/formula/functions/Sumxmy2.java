package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: classes7.dex */
public final class Sumxmy2 extends XYNumericFunction {
    private static final XYNumericFunction.Accumulator XMinusYSquaredAccumulator = null;

    static {
        XMinusYSquaredAccumulator = $$Lambda$Sumxmy2$HKT0EN0ALlkvKJnJDmbnrrA6A.INSTANCE;
    }

    public Sumxmy2() {
    }

    static /* synthetic */ double lambda$static$0(double r0, double r2) {
        double r1 = r0 - r2;
        return r1 * r1;
    }

    @Override // org.apache.poi.ss.formula.functions.XYNumericFunction
    public XYNumericFunction.Accumulator createAccumulator() {
        return XMinusYSquaredAccumulator;
    }
}
