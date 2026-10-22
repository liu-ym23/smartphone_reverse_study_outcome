package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFSheetConditionalFormatting implements SheetConditionalFormatting {
    private final ConditionalFormattingTable _conditionalFormattingTable;
    private final HSSFSheet _sheet;

    HSSFSheetConditionalFormatting(HSSFSheet r1) {
        this._sheet = r1;
        this._conditionalFormattingTable = r1.getSheet().getConditionalFormattingTable();
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public HSSFConditionalFormatting getConditionalFormattingAt(int r2) {
        CFRecordsAggregate r3 = this._conditionalFormattingTable.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new HSSFConditionalFormatting(this._sheet, r3);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public /* bridge */ /* synthetic */ ConditionalFormatting getConditionalFormattingAt(int r1) {
        return getConditionalFormattingAt(r1);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int getNumConditionalFormattings() {
        return this._conditionalFormattingTable.size();
    }
}
