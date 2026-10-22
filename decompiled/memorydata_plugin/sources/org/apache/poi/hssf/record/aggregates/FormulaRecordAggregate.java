package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.ArrayRecord;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.SharedFormulaRecord;
import org.apache.poi.hssf.record.SharedValueRecordBase;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.hssf.util.CellRangeAddress8Bit;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class FormulaRecordAggregate extends RecordAggregate implements CellValueRecordInterface {
    private final FormulaRecord _formulaRecord;
    private SharedFormulaRecord _sharedFormulaRecord;
    private SharedValueManager _sharedValueManager;
    private StringRecord _stringRecord;

    public FormulaRecordAggregate(FormulaRecord r2, StringRecord r3, SharedValueManager r4) {
        if (r4 == null) goto L19;
        if (r2.hasCachedResultString() == false) goto L10;
        if (r3 == null) goto L9;
    L11:
        this._stringRecord = r3;
        this._formulaRecord = r2;
        this._sharedValueManager = r4;
        if (r2.isSharedFormula() == false) goto L20;
        CellReference r5 = r2.getFormula().getExpReference();
        if (r5 != null) goto L16;
        handleMissingSharedFormulaRecord(r2);
        return;
    L16:
        this._sharedFormulaRecord = r4.linkSharedFormulaRecord(r5, this);
        return;
    L20:
        return;
    L9:
        throw new RecordFormatException("Formula record flag is set but String record was not found");
    L10:
        r3 = null;
        goto L11
    L19:
        throw new IllegalArgumentException("sfm must not be null");
    }

    private static void handleMissingSharedFormulaRecord(FormulaRecord r3) {
        if (ZeusTransformUtils.instanceOf(r3.getParsedExpression()[0], ExpPtg.class) == true) goto L7;
        r3.setSharedFormula(false);
        return;
    L7:
        throw new RecordFormatException("SharedFormulaRecord not found for FormulaRecord with (isSharedFormula=true)");
    }

    public CellRangeAddress getArrayFormulaRange() {
        if (this._sharedFormulaRecord != null) goto L15;
        CellReference r0 = this._formulaRecord.getFormula().getExpReference();
        if (r0 == null) goto L13;
        ArrayRecord r4 = this._sharedValueManager.getArrayRecord(r0.getRow(), r0.getCol());
        if (r4 == null) goto L11;
        CellRangeAddress8Bit r5 = r4.getRange();
        return new CellRangeAddress(r5.getFirstRow(), r5.getLastRow(), r5.getFirstColumn(), r5.getLastColumn());
    L11:
        throw new IllegalStateException("ArrayRecord was not found for the locator " + r0.formatAsString());
    L13:
        throw new IllegalStateException("not an array formula cell.");
    L15:
        throw new IllegalStateException("not an array formula cell.");
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this._formulaRecord.getColumn();
    }

    public FormulaRecord getFormulaRecord() {
        return this._formulaRecord;
    }

    public Ptg[] getFormulaTokens() {
        SharedFormulaRecord r0 = this._sharedFormulaRecord;
        if (r0 != null) goto L5;
        CellReference r1 = this._formulaRecord.getFormula().getExpReference();
        if (r1 == null) goto L11;
        return this._sharedValueManager.getArrayRecord(r1.getRow(), r1.getCol()).getFormulaTokens();
    L11:
        return this._formulaRecord.getParsedExpression();
    L5:
        return r0.getFormulaTokens(this._formulaRecord);
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this._formulaRecord.getRow();
    }

    public String getStringValue() {
        StringRecord r0 = this._stringRecord;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString();
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this._formulaRecord.getXFIndex();
    }

    public boolean isPartOfArrayFormula() {
        if (this._sharedFormulaRecord == null) goto L5;
        return false;
    L5:
        CellReference r0 = this._formulaRecord.getFormula().getExpReference();
        if (r0 != null) goto L8;
        ArrayRecord r3 = null;
    L9:
        if (r3 == null) goto L12;
        return true;
    L12:
        return false;
    L8:
        r3 = this._sharedValueManager.getArrayRecord(r0.getRow(), r0.getCol());
        goto L9
    }

    public void notifyFormulaChanging() {
        SharedFormulaRecord r0 = this._sharedFormulaRecord;
        if (r0 == null) goto L6;
        this._sharedValueManager.unlink(r0);
        return;
    }

    public CellRangeAddress removeArrayFormula(int r3, int r4) {
        CellRangeAddress8Bit r5 = this._sharedValueManager.removeArrayFormula(r3, r4);
        this._formulaRecord.setParsedExpression(null);
        return new CellRangeAddress(r5.getFirstRow(), r5.getLastRow(), r5.getFirstColumn(), r5.getLastColumn());
    }

    public void setCachedBooleanResult(boolean r2) {
        this._stringRecord = null;
        this._formulaRecord.setCachedResultBoolean(r2);
    }

    public void setCachedDoubleResult(double r2) {
        this._stringRecord = null;
        this._formulaRecord.setValue(r2);
    }

    public void setCachedErrorResult(int r2) {
        this._stringRecord = null;
        this._formulaRecord.setCachedResultErrorCode(r2);
    }

    public void setCachedStringResult(String r2) {
        if (this._stringRecord != null) goto L5;
        this._stringRecord = new StringRecord();
    L5:
        this._stringRecord.setString(r2);
        int r3 = r2.length();
        FormulaRecord r1 = this._formulaRecord;
        if (r3 >= 1) goto L8;
        r1.setCachedResultTypeEmptyString();
        return;
    L8:
        r1.setCachedResultTypeString();
    }

    public void setColumn(short r1) {
        this._formulaRecord.setColumn(r1);
    }

    public void setParsedExpression(Ptg[] r1) {
        notifyFormulaChanging();
        this._formulaRecord.setParsedExpression(r1);
    }

    public void setRow(int r1) {
        this._formulaRecord.setRow(r1);
    }

    public void setXFIndex(short r1) {
        this._formulaRecord.setXFIndex(r1);
    }

    public String toString() {
        return this._formulaRecord.toString();
    }

    public void unlinkSharedFormula() {
        SharedFormulaRecord r0 = this._sharedFormulaRecord;
        if (r0 == null) goto L7;
        Ptg[] r1 = r0.getFormulaTokens(this._formulaRecord);
        this._formulaRecord.setParsedExpression(r1);
        this._formulaRecord.setSharedFormula(false);
        this._sharedFormulaRecord = null;
        return;
    L7:
        throw new IllegalStateException("Formula not linked to shared formula");
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r3) {
        RecordAggregate.RecordVisitor r4 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        r4.visitRecord(this._formulaRecord);
        SharedValueRecordBase r0 = this._sharedValueManager.getRecordForFirstCell(this);
        if (r0 == null) goto L6;
        r4.visitRecord(r0);
    L6:
        if (this._formulaRecord.hasCachedResultString() == false) goto L11;
        StringRecord r2 = this._stringRecord;
        if (r2 == null) goto L12;
        r4.visitRecord(r2);
        return;
    L12:
        return;
    }
}
