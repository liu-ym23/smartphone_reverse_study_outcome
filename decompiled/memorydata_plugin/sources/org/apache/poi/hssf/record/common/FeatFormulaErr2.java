package org.apache.poi.hssf.record.common;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FeatFormulaErr2 implements SharedFeature {
    private static final BitField CHECK_CALCULATION_ERRORS = null;
    private static final BitField CHECK_DATETIME_FORMATS = null;
    private static final BitField CHECK_EMPTY_CELL_REF = null;
    private static final BitField CHECK_INCONSISTENT_FORMULAS = null;
    private static final BitField CHECK_INCONSISTENT_RANGES = null;
    private static final BitField CHECK_NUMBERS_AS_TEXT = null;
    private static final BitField CHECK_UNPROTECTED_FORMULAS = null;
    private static final BitField PERFORM_DATA_VALIDATION = null;
    private int errorCheck;

    static {
        CHECK_CALCULATION_ERRORS = BitFieldFactory.getInstance(1);
        CHECK_EMPTY_CELL_REF = BitFieldFactory.getInstance(2);
        CHECK_NUMBERS_AS_TEXT = BitFieldFactory.getInstance(4);
        CHECK_INCONSISTENT_RANGES = BitFieldFactory.getInstance(8);
        CHECK_INCONSISTENT_FORMULAS = BitFieldFactory.getInstance(16);
        CHECK_DATETIME_FORMATS = BitFieldFactory.getInstance(32);
        CHECK_UNPROTECTED_FORMULAS = BitFieldFactory.getInstance(64);
        PERFORM_DATA_VALIDATION = BitFieldFactory.getInstance(128);
    }

    public FeatFormulaErr2() {
    }

    public FeatFormulaErr2(RecordInputStream r1) {
        this.errorCheck = r1.readInt();
    }

    public int _getRawErrorCheckValue() {
        return this.errorCheck;
    }

    @Override // org.apache.poi.hssf.record.common.SharedFeature
    public int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("errorCheck", GenericRecordUtil.getBitsAsString(new $$Lambda$5adgn8kAwYs9AaDei96tQId2_E(this), new BitField[]{CHECK_CALCULATION_ERRORS, CHECK_EMPTY_CELL_REF, CHECK_NUMBERS_AS_TEXT, CHECK_INCONSISTENT_RANGES, CHECK_INCONSISTENT_FORMULAS, CHECK_DATETIME_FORMATS, CHECK_UNPROTECTED_FORMULAS, PERFORM_DATA_VALIDATION}, new String[]{"CHECK_CALCULATION_ERRORS", "CHECK_EMPTY_CELL_REF", "CHECK_NUMBERS_AS_TEXT", "CHECK_INCONSISTENT_RANGES", "CHECK_INCONSISTENT_FORMULAS", "CHECK_DATETIME_FORMATS", "CHECK_UNPROTECTED_FORMULAS", "PERFORM_DATA_VALIDATION"}));
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
