package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: classes7.dex */
public final class GreaterEqualPtg extends ValueOperatorPtg {
    public static final GreaterEqualPtg instance = null;

    static {
        instance = new GreaterEqualPtg();
    }

    private GreaterEqualPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 12;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] r2) {
        return r2[0] + ">=" + r2[1];
    }
}
