package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.aj;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFSheetConditionalFormatting implements SheetConditionalFormatting {
    private final XSSFSheet _sheet;

    XSSFSheetConditionalFormatting(XSSFSheet r1) {
        this._sheet = r1;
    }

    private void checkIndex(int r4) {
        int r3 = getNumConditionalFormattings();
        if (r4 < 0) goto L7;
        if (r4 >= r3) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Specified CF index " + r4 + " is outside the allowable range (0.." + (r3 - 1) + ")");
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public /* bridge */ /* synthetic */ ConditionalFormatting getConditionalFormattingAt(int r1) {
        return getConditionalFormattingAt(r1);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public XSSFConditionalFormatting getConditionalFormattingAt(int r2) {
        checkIndex(r2);
        aj r3 = this._sheet.getCTWorksheet().getConditionalFormattingArray(r2);
        return new XSSFConditionalFormatting(this._sheet, r3);
    }

    @Override // org.apache.poi.ss.usermodel.SheetConditionalFormatting
    public int getNumConditionalFormattings() {
        return this._sheet.getCTWorksheet().sizeOfConditionalFormattingArray();
    }
}
