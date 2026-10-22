package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: classes7.dex */
public final class UnaryMinusPtg extends ValueOperatorPtg {
    public static final UnaryMinusPtg instance = null;

    static {
        instance = new UnaryMinusPtg();
    }

    private UnaryMinusPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 19;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] r2) {
        return "-" + r2[0];
    }
}
