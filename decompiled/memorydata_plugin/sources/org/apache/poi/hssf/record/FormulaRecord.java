package org.apache.poi.hssf.record;

import com.bytedance.crash.entity.EventBody;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class FormulaRecord extends CellRecord {
    private static final BitField alwaysCalc = null;
    private static final BitField calcOnLoad = null;
    private static final BitField sharedFormula = null;
    private double field_4_value;
    private short field_5_options;
    private int field_6_zero;
    private Formula field_8_parsed_expr;
    private FormulaSpecialCachedValue specialCachedValue;

    static {
        alwaysCalc = BitFieldFactory.getInstance(1);
        calcOnLoad = BitFieldFactory.getInstance(2);
        sharedFormula = BitFieldFactory.getInstance(8);
    }

    public FormulaRecord() {
        this.field_8_parsed_expr = Formula.create(Ptg.EMPTY_PTG_ARRAY);
    }

    public FormulaRecord(RecordInputStream r4) {
        super(r4);
        long r0 = r4.readLong();
        this.field_5_options = r4.readShort();
        FormulaSpecialCachedValue r2 = FormulaSpecialCachedValue.create(r0);
        this.specialCachedValue = r2;
        if (r2 != null) goto L5;
        this.field_4_value = Double.longBitsToDouble(r0);
    L5:
        this.field_6_zero = r4.readInt();
        this.field_8_parsed_expr = Formula.read(r4.readShort(), r4, r4.available());
    }

    public boolean getCachedBooleanValue() {
        return this.specialCachedValue.getBooleanValue();
    }

    public int getCachedErrorValue() {
        return this.specialCachedValue.getErrorValue();
    }

    @Deprecated
    public int getCachedResultType() {
        FormulaSpecialCachedValue r0 = this.specialCachedValue;
        if (r0 != null) goto L7;
        return CellType.NUMERIC.getCode();
    L7:
        return r0.getValueType();
    }

    public CellType getCachedResultTypeEnum() {
        FormulaSpecialCachedValue r0 = this.specialCachedValue;
        if (r0 != null) goto L7;
        return CellType.NUMERIC;
    L7:
        return r0.getValueTypeEnum();
    }

    public Formula getFormula() {
        return this.field_8_parsed_expr;
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$FormulaRecord$AJUmkS4JDVmHKiJS1HvoCJNi2Y(this), "options", new $$Lambda$X8pHrNHSg7N4RxQMxnS0zRA57_Y(this), "alwaysCalc", new $$Lambda$5KP9_IHAri1lwzbAgc7_pz_I(this), "calcOnLoad", new $$Lambda$00_ljXRlCQUhje1xYD7Mx2nyPYM(this), "shared", new $$Lambda$a1bl3Ldu5Jz1QJB0dpKvW2Oz7sQ(this), "zero", new $$Lambda$FormulaRecord$rfghSyXuHaOzRxpKno3AV4I8wu0(this), EventBody.KEY_VALUE, new $$Lambda$FormulaRecord$nnzUGTi9rXZLn6FfoG7jaDmua8c(this), "formula", new $$Lambda$sJbBeNAYE8FtJigmlTW2d3vzHs0(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FORMULA;
    }

    public short getOptions() {
        return this.field_5_options;
    }

    public Ptg[] getParsedExpression() {
        return this.field_8_parsed_expr.getTokens();
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 6;
    }

    public double getValue() {
        return this.field_4_value;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return this.field_8_parsed_expr.getEncodedSize() + 14;
    }

    public boolean hasCachedResultString() {
        FormulaSpecialCachedValue r0 = this.specialCachedValue;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getTypeCode() != 0) goto L7;
        return true;
    }

    public boolean isAlwaysCalc() {
        return alwaysCalc.isSet(this.field_5_options);
    }

    public boolean isCalcOnLoad() {
        return calcOnLoad.isSet(this.field_5_options);
    }

    public boolean isSharedFormula() {
        return sharedFormula.isSet(this.field_5_options);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FormulaRecord() {
        return super.getGenericProperties();
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$FormulaRecord() {
        return Integer.valueOf(this.field_6_zero);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$FormulaRecord() {
        FormulaSpecialCachedValue r0 = this.specialCachedValue;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Double.valueOf(this.field_4_value);
    }

    public void setCachedResultBoolean(boolean r1) {
        this.specialCachedValue = FormulaSpecialCachedValue.createCachedBoolean(r1);
    }

    public void setCachedResultErrorCode(int r1) {
        this.specialCachedValue = FormulaSpecialCachedValue.createCachedErrorCode(r1);
    }

    public void setCachedResultTypeEmptyString() {
        this.specialCachedValue = FormulaSpecialCachedValue.createCachedEmptyValue();
    }

    public void setCachedResultTypeString() {
        this.specialCachedValue = FormulaSpecialCachedValue.createForString();
    }

    public void setOptions(short r1) {
        this.field_5_options = r1;
    }

    public void setParsedExpression(Ptg[] r1) {
        this.field_8_parsed_expr = Formula.create(r1);
    }

    public void setSharedFormula(boolean r3) {
        this.field_5_options = sharedFormula.setShortBoolean(this.field_5_options, r3);
    }

    public void setValue(double r1) {
        this.field_4_value = r1;
        this.specialCachedValue = null;
    }
}
