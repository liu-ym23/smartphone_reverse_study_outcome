package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: classes7.dex */
public final class DividePtg extends ValueOperatorPtg {
    public static final DividePtg instance = null;

    static {
        instance = new DividePtg();
    }

    private DividePtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 6;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] r2) {
        return r2[0] + "/" + r2[1];
    }
}
