package org.apache.poi.ss.formula;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes7.dex */
public interface EvaluationCell {
    CellRangeAddress getArrayFormulaRange();

    boolean getBooleanCellValue();

    CellType getCachedFormulaResultType();

    CellType getCellType();

    int getColumnIndex();

    int getErrorCellValue();

    Object getIdentityKey();

    double getNumericCellValue();

    int getRowIndex();

    EvaluationSheet getSheet();

    String getStringCellValue();

    boolean isPartOfArrayFormulaGroup();
}
