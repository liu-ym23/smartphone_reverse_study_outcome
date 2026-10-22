package org.apache.poi.ss.formula.ptg;

import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public final class UnaryPlusPtg extends ValueOperatorPtg {
    public static final UnaryPlusPtg instance = null;

    static {
        instance = new UnaryPlusPtg();
    }

    private UnaryPlusPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 18;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] r2) {
        return Marker.ANY_NON_NULL_MARKER + r2[0];
    }
}
