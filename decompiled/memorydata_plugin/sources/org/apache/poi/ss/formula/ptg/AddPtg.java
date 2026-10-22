package org.apache.poi.ss.formula.ptg;

import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public final class AddPtg extends ValueOperatorPtg {
    public static final AddPtg instance = null;

    static {
        instance = new AddPtg();
    }

    private AddPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return 3;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] r2) {
        return r2[0] + Marker.ANY_NON_NULL_MARKER + r2[1];
    }
}
