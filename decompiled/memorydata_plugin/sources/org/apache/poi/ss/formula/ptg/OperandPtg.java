package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: classes7.dex */
public abstract class OperandPtg extends Ptg {
    public OperandPtg() {
    }

    public OperandPtg(OperandPtg r1) {
        super(r1);
    }

    public abstract OperandPtg copy();

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return false;
    }
}
