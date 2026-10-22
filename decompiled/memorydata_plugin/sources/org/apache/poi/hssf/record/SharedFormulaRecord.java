package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.SharedFormula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SharedFormulaRecord extends SharedValueRecordBase {
    private int field_5_reserved;
    private Formula field_7_parsed_expr;

    public SharedFormulaRecord() {
        this(new CellRangeAddress8Bit(0, 0, 0, 0));
    }

    public SharedFormulaRecord(RecordInputStream r3) {
        super(r3);
        this.field_5_reserved = r3.readShort();
        this.field_7_parsed_expr = Formula.read(r3.readShort(), r3, r3.available());
    }

    private SharedFormulaRecord(CellRangeAddress8Bit r1) {
        super(r1);
        this.field_7_parsed_expr = Formula.create(Ptg.EMPTY_PTG_ARRAY);
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    public int getExtraDataSize() {
        return this.field_7_parsed_expr.getEncodedSize() + 2;
    }

    public Ptg[] getFormulaTokens(FormulaRecord r4) {
        int r0 = r4.getRow();
        short r5 = r4.getColumn();
        if (isInRange(r0, r5) == false) goto L7;
        return new SharedFormula(SpreadsheetVersion.EXCEL97).convertSharedFormulas(this.field_7_parsed_expr.getTokens(), r0, r5);
    L7:
        throw new RuntimeException("Shared Formula Conversion: Coding Error");
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("range", new $$Lambda$giiPCmWfiPVfU3OPesBw6Mbq31g(this), "reserved", new $$Lambda$SharedFormulaRecord$E1iNrMFVRutWoMKzgkxmQx_eYl4(this), "formula", new $$Lambda$SharedFormulaRecord$i8O3_NAKjBa3M8hDnj2eHcfpf_Y(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.SHARED_FORMULA;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 1212;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$SharedFormulaRecord() {
        return Integer.valueOf(this.field_5_reserved);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$SharedFormulaRecord() {
        return this.field_7_parsed_expr;
    }
}
