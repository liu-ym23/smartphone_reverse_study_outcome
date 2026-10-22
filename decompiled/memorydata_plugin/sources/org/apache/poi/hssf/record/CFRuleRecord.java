package org.apache.poi.hssf.record;

import org.apache.poi.ss.formula.Formula;

/* JADX INFO: loaded from: classes7.dex */
public final class CFRuleRecord extends CFRuleBase {
    public CFRuleRecord(RecordInputStream r3) {
        setConditionType(r3.readByte());
        setComparisonOperation(r3.readByte());
        int r0 = r3.readUShort();
        int r1 = r3.readUShort();
        readFormatOptions(r3);
        setFormula1(Formula.read(r0, r3));
        setFormula2(Formula.read(r1, r3));
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return ((getFormattingBlockSize() + 6) + getFormulaSize(getFormula1())) + getFormulaSize(getFormula2());
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.CF_RULE;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 433;
    }
}
