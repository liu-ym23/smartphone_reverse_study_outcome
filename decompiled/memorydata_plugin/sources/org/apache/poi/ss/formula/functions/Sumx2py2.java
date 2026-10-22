package org.apache.poi.ss.formula.functions;

/* JADX INFO: loaded from: classes7.dex */
public final class Sumx2py2 extends XYNumericFunction {
    private static final XYNumericFunction.Accumulator XSquaredPlusYSquaredAccumulator = null;

    static {
        XSquaredPlusYSquaredAccumulator = $$Lambda$Sumx2py2$txcPu70uk94jUui94DS7Vil72NU.INSTANCE;
    }

    public Sumx2py2() {
    }

    static /* synthetic */ double lambda$static$0(double r0, double r2) {
        return (r0 * r0) + (r2 * r2);
    }

    @Override // org.apache.poi.ss.formula.functions.XYNumericFunction
    public XYNumericFunction.Accumulator createAccumulator() {
        return XSquaredPlusYSquaredAccumulator;
    }
}
