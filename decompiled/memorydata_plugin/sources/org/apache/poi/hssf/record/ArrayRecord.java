package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ArrayRecord extends SharedValueRecordBase {
    private int _field3notUsed;
    private Formula _formula;
    private int _options;

    public ArrayRecord(RecordInputStream r3) {
        super(r3);
        this._options = r3.readUShort();
        this._field3notUsed = r3.readInt();
        this._formula = Formula.read(r3.readUShort(), r3, r3.available());
    }

    @Override // org.apache.poi.hssf.record.SharedValueRecordBase
    public int getExtraDataSize() {
        return this._formula.getEncodedSize() + 6;
    }

    public Ptg[] getFormulaTokens() {
        return this._formula.getTokens();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("range", new $$Lambda$FA06C6GxB7LCaMNQ1kYQpu2QOY(this), "options", new $$Lambda$ArrayRecord$AfgnBxr7oH5vNzjsoyyQISPBnLQ(this), "notUsed", new $$Lambda$ArrayRecord$fuAL1eXLBlliOlYFYdLZ7gOzGE(this), "formula", new $$Lambda$ArrayRecord$KG1CLSkeaWOCOD_FI4LziHdHKI(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.ARRAY;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 545;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ArrayRecord() {
        return Integer.valueOf(this._options);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ArrayRecord() {
        return Integer.valueOf(this._field3notUsed);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ArrayRecord() {
        return this._formula;
    }
}
