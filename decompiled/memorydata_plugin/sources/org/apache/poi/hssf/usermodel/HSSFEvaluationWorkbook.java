package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.aggregates.FormulaRecordAggregate;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationName;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.formula.SheetRangeIdentifier;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFEvaluationWorkbook implements EvaluationWorkbook, FormulaParsingWorkbook, FormulaRenderingWorkbook {
    private final InternalWorkbook _iBook;
    private final HSSFWorkbook _uBook;

    private static final class Name implements EvaluationName {
        private final int _index;
        private final NameRecord _nameRecord;

        public Name(NameRecord r1, int r2) {
            this._nameRecord = r1;
            this._index = r2;
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public NamePtg createPtg() {
            return new NamePtg(this._index);
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public Ptg[] getNameDefinition() {
            return this._nameRecord.getNameDefinition();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public String getNameText() {
            return this._nameRecord.getNameText();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean hasFormula() {
            return this._nameRecord.hasFormula();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean isFunctionName() {
            return this._nameRecord.isFunctionName();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean isRange() {
            return this._nameRecord.hasFormula();
        }
    }

    private HSSFEvaluationWorkbook(HSSFWorkbook r1) {
        this._uBook = r1;
        this._iBook = r1.getWorkbook();
    }

    public static HSSFEvaluationWorkbook create(HSSFWorkbook r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new HSSFEvaluationWorkbook(r1);
    }

    private int getSheetExtIx(SheetIdentifier r5) {
        if (r5 != null) goto L4;
        return -1;
    L4:
        String r0 = r5.getBookName();
        String r1 = r5.getSheetIdentifier().getName();
        if (ZeusTransformUtils.instanceOf(r5, SheetRangeIdentifier.class) == false) goto L7;
        String r6 = ((SheetRangeIdentifier) ZeusTransformUtils.preCheckCast(r5, SheetRangeIdentifier.class, "com.obric.memorydata.plugin")).getLastSheetIdentifier().getName();
    L8:
        if (r0 != null) goto L11;
        int r2 = this._uBook.getSheetIndex(r1);
        int r7 = this._uBook.getSheetIndex(r6);
        return this._iBook.checkExternSheet(r2, r7);
    L11:
        return this._iBook.getExternalSheetIndex(r0, r1, r6);
    L7:
        r6 = r1;
        goto L8
    }

    public int convertFromExternSheetIndex(int r1) {
        return this._iBook.getFirstSheetIndexFromExternSheetIndex(r1);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public HSSFName createName() {
        return this._uBook.createName();
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public /* bridge */ /* synthetic */ org.apache.poi.ss.usermodel.Name createName() {
        return createName();
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Ptg get3DReferencePtg(AreaReference r1, SheetIdentifier r2) {
        return new Area3DPtg(r1, getSheetExtIx(r2));
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Ptg get3DReferencePtg(CellReference r1, SheetIdentifier r2) {
        return new Ref3DPtg(r1, getSheetExtIx(r2));
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(int r1, int r2) {
        return this._iBook.getExternalName(r1, r2);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(String r1, String r2, int r3) {
        throw new IllegalStateException("XSSF-style external names are not supported for HSSF");
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(int r5) {
        EvaluationWorkbook.ExternalSheet r0 = this._iBook.getExternalSheet(r5);
        if (r0 != null) goto L15;
        int r1 = convertFromExternSheetIndex(r5);
        if (r1 != (-1)) goto L8;
        return null;
    L8:
        if (r1 != (-2)) goto L10;
        return null;
    L10:
        String r2 = getSheetName(r1);
        int r6 = this._iBook.getLastSheetIndexFromExternSheetIndex(r5);
        if (r6 != r1) goto L14;
        return new EvaluationWorkbook.ExternalSheet(null, r2);
    L14:
        return new EvaluationWorkbook.ExternalSheetRange(null, r2, getSheetName(r6));
    L15:
        return r0;
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(String r1, String r2, int r3) {
        throw new IllegalStateException("XSSF-style external references are not supported for HSSF");
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public Ptg[] getFormulaTokens(EvaluationCell r2) {
        return ((FormulaRecordAggregate) ZeusTransformUtils.preCheckCast(((HSSFEvaluationCell) ZeusTransformUtils.preCheckCast((EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationCell.class, "com.obric.memorydata.plugin"), HSSFEvaluationCell.class, "com.obric.memorydata.plugin")).getHSSFCell().getCellValueRecord(), FormulaRecordAggregate.class, "com.obric.memorydata.plugin")).getFormulaTokens();
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaParsingWorkbook
    public EvaluationName getName(String r5, int r6) {
        int r0 = 0;
    L4:
        if (r0 >= this._iBook.getNumNames()) goto L13;
        NameRecord r1 = this._iBook.getNameRecord(r0);
        if (r1.getSheetNumber() != (r6 + 1)) goto L11;
        if (r5.equalsIgnoreCase(r1.getNameText()) == false) goto L11;
        return new Name(r1, r0);
    L11:
        r0 = r0 + 1;
        goto L4
    L13:
        if (r6 != (-1)) goto L16;
        return null;
    L16:
        return getName(r5, -1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationName getName(NamePtg r2) {
        int r3 = r2.getIndex();
        return new Name(this._iBook.getNameRecord(r3), r3);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getNameText(NamePtg r1) {
        return this._iBook.getNameRecord(r1.getIndex()).getNameText();
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public NameXPtg getNameXPtg(String r2, SheetIdentifier r3) {
        int r4 = getSheetExtIx(r3);
        return this._iBook.getNameXPtg(r2, r4, this._uBook.getUDFFinder());
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public /* bridge */ /* synthetic */ Ptg getNameXPtg(String r1, SheetIdentifier r2) {
        return getNameXPtg(r1, r2);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationSheet getSheet(int r2) {
        return new HSSFEvaluationSheet(this._uBook.getSheetAt(r2));
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getSheetFirstNameByExternSheet(int r1) {
        return this._iBook.findSheetFirstNameFromExternSheet(r1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(String r1) {
        return this._uBook.getSheetIndex(r1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(EvaluationSheet r3) {
        HSSFSheet r4 = ((HSSFEvaluationSheet) ZeusTransformUtils.preCheckCast((EvaluationSheet) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationSheet.class, "com.obric.memorydata.plugin"), HSSFEvaluationSheet.class, "com.obric.memorydata.plugin")).getHSSFSheet();
        return this._uBook.getSheetIndex(r4);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getSheetLastNameByExternSheet(int r1) {
        return this._iBook.findSheetLastNameFromExternSheet(r1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public String getSheetName(int r1) {
        return this._uBook.getSheetName(r1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaParsingWorkbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL97;
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Table getTable(String r1) {
        throw new IllegalStateException("XSSF-style tables are not supported for HSSF");
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String resolveNameXText(NameXPtg r2) {
        return this._iBook.resolveNameXText(r2.getSheetRefIndex(), r2.getNameIndex());
    }
}
