package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.apache.poi.ss.usermodel.ConditionFilterType;
import org.apache.poi.ss.usermodel.ConditionType;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFConditionalFormattingRule implements ConditionalFormattingRule {
    private final CFRuleBase cfRuleRecord;
    private final HSSFSheet sheet;
    private final HSSFWorkbook workbook;

    HSSFConditionalFormattingRule(HSSFSheet r1, CFRuleBase r2) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L8;
        this.sheet = r1;
        this.workbook = r1.getWorkbook();
        this.cfRuleRecord = r2;
        return;
    L8:
        throw new IllegalArgumentException("pRuleRecord must not be null");
    L10:
        throw new IllegalArgumentException("pSheet must not be null");
    }

    private CFRule12Record getCFRule12Record(boolean r3) {
        if (ZeusTransformUtils.instanceOf(this.cfRuleRecord, CFRule12Record.class) == true) goto L5;
        if (r3 == true) goto L10;
        return null;
    L10:
        throw new IllegalArgumentException("Can't convert a CF into a CF12 record");
    L5:
        return (CFRule12Record) ZeusTransformUtils.preCheckCast(this.cfRuleRecord, CFRule12Record.class, "com.obric.memorydata.plugin");
    }

    static String toFormulaString(Ptg[] r1, HSSFWorkbook r2) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.length != 0) goto L7;
        return null;
    L7:
        return HSSFFormulaParser.toFormulaString(r2, r1);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public byte getComparisonOperation() {
        return this.cfRuleRecord.getComparisonOperation();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterType getConditionFilterType() {
        if (getConditionType() == ConditionType.FILTER) goto L7;
        return null;
    L7:
        return ConditionFilterType.FILTER;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionType getConditionType() {
        return ConditionType.forId(this.cfRuleRecord.getConditionType());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterData getFilterConfiguration() {
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula1() {
        return toFormulaString(this.cfRuleRecord.getParsedExpression1());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula2() {
        if (this.cfRuleRecord.getConditionType() != 1) goto L11;
        byte r0 = this.cfRuleRecord.getComparisonOperation();
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        return null;
    L10:
        return toFormulaString(this.cfRuleRecord.getParsedExpression2());
    L11:
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ExcelNumberFormat getNumberFormat() {
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public int getPriority() {
        CFRule12Record r1 = getCFRule12Record(false);
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.getPriority();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public boolean getStopIfTrue() {
        return true;
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public int getStripeSize() {
        return 0;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getText() {
        return null;
    }

    String toFormulaString(Ptg[] r1) {
        return toFormulaString(r1, this.workbook);
    }
}
