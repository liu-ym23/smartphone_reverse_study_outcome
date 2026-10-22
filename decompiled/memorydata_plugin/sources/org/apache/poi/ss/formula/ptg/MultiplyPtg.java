package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: classes7.dex */
public final class MultiplyPtg extends ValueOperatorPtg {
    public static final MultiplyPtg instance = null;

    static {
        instance = new MultiplyPtg();
    }

    private MultiplyPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 5;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] r2) {
        return r2[0] + "*" + r2[1];
    }
}
