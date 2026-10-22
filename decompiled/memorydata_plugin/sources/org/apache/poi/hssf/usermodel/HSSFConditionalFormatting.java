package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFConditionalFormatting implements ConditionalFormatting {
    private final CFRecordsAggregate cfAggregate;
    private final HSSFSheet sheet;

    HSSFConditionalFormatting(HSSFSheet r1, CFRecordsAggregate r2) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L8;
        this.sheet = r1;
        this.cfAggregate = r2;
        return;
    L8:
        throw new IllegalArgumentException("cfAggregate must not be null");
    L10:
        throw new IllegalArgumentException("sheet must not be null");
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public CellRangeAddress[] getFormattingRanges() {
        return this.cfAggregate.getHeader().getCellRanges();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public int getNumberOfRules() {
        return this.cfAggregate.getNumberOfRules();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public HSSFConditionalFormattingRule getRule(int r2) {
        CFRuleBase r3 = this.cfAggregate.getRule(r2);
        return new HSSFConditionalFormattingRule(this.sheet, r3);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public /* bridge */ /* synthetic */ ConditionalFormattingRule getRule(int r1) {
        return getRule(r1);
    }

    public String toString() {
        return this.cfAggregate.toString();
    }
}
