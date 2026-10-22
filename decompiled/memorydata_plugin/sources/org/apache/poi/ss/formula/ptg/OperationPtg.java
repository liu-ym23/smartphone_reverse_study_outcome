package org.apache.poi.ss.formula.ptg;

import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public abstract class OperationPtg extends Ptg {
    public OperationPtg() {
    }

    public byte getDefaultOperandClass() {
        return 32;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return null;
    }

    public abstract int getNumberOfOperands();

    public abstract String toFormulaString(String[] r1);
}
