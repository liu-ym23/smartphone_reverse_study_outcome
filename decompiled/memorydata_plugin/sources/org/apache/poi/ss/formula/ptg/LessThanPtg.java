package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: classes7.dex */
public final class LessThanPtg extends ValueOperatorPtg {
    public static final LessThanPtg instance = null;

    static {
        instance = new LessThanPtg();
    }

    private LessThanPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 9;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] r2) {
        return r2[0] + "<" + r2[1];
    }
}
