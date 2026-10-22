package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CellBase implements Cell {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    public CellBase() {
    }

    private void checkLength(String r3) {
        if (r3.length() > getSpreadsheetVersion().getMaxTextLength()) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format(Locale.ROOT, "The maximum length of cell contents (text) is %d characters", new Object[]{Integer.valueOf(getSpreadsheetVersion().getMaxTextLength())}));
    }

    private void tryToDeleteArrayFormulaIfSet() {
        if (isPartOfArrayFormulaGroup() == false) goto L6;
        tryToDeleteArrayFormula(null);
        return;
    }

    public CellAddress getAddress() {
        return new CellAddress(this);
    }

    public abstract SpreadsheetVersion getSpreadsheetVersion();

    public final CellType getValueType() {
        CellType r0 = getCellType();
        if (r0 == CellType.FORMULA) goto L6;
        return r0;
    L6:
        return getCachedFormulaResultType();
    }

    public final void removeFormula() {
        if (getCellType() != CellType.BLANK) goto L6;
        return;
    L6:
        if (isPartOfArrayFormulaGroup() == false) goto L9;
        tryToDeleteArrayFormula(null);
        return;
    L9:
        removeFormulaImpl();
    }

    public abstract void removeFormulaImpl();

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setBlank() {
        setCellType(CellType.BLANK);
    }

    public final void setCellFormula(String r1) {
        tryToDeleteArrayFormulaIfSet();
        if (r1 != null) goto L6;
        removeFormula();
        return;
    L6:
        setCellFormulaImpl(r1);
    }

    public abstract void setCellFormulaImpl(String r1);

    public final void setCellType(CellType r2) {
        if (r2 == null) goto L15;
        if (r2 == CellType._NONE) goto L15;
        if (r2 == CellType.FORMULA) goto L8;
        tryToDeleteArrayFormulaIfSet();
        setCellTypeImpl(r2);
        return;
    L8:
        if (getCellType() != CellType.FORMULA) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Calling Cell.setCellType(CellType.FORMULA) is illegal. Use setCellFormula(String) directly.");
    L15:
        throw new IllegalArgumentException("cellType shall not be null nor _NONE");
    }

    public abstract void setCellTypeImpl(CellType r1);

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(double r2) {
        if (Double.isInfinite(r2) == false) goto L7;
        FormulaError r3 = FormulaError.DIV0;
    L5:
        setCellErrorValue(r3.getCode());
        return;
    L7:
        if (Double.isNaN(r2) == false) goto L9;
        r3 = FormulaError.NUM;
        goto L5
    L9:
        setCellValueImpl(r2);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(String r1) {
        if (r1 != null) goto L5;
        setBlank();
        return;
    L5:
        checkLength(r1);
        setCellValueImpl(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(RichTextString r3) {
        RichTextString r4 = (RichTextString) ZeusTransformUtils.wrapperContextForParams(r3, RichTextString.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L9:
        setBlank();
        return;
    L5:
        if (r4.getString() == null) goto L9;
        checkLength(r4.getString());
        setCellValueImpl(r4);
    }

    public abstract void setCellValueImpl(double r1);

    public abstract void setCellValueImpl(String r1);

    public abstract void setCellValueImpl(RichTextString r1);

    public final void tryToDeleteArrayFormula(String r3) {
        if (getArrayFormulaRange().getNumberOfCells() <= 1) goto L8;
        if (r3 != null) goto L7;
        r3 = "Cell " + new CellReference(this).formatAsString() + " is part of a multi-cell array formula. You cannot change part of an array.";
    L7:
        throw new IllegalStateException(r3);
    L8:
        getRow().getSheet().removeArrayFormula(this);
    }
}
