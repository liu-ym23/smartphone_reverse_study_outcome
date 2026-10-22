package org.apache.poi.ss.usermodel;

import java.time.LocalDateTime;
import java.util.Date;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes7.dex */
public interface Cell {
    CellRangeAddress getArrayFormulaRange();

    boolean getBooleanCellValue();

    CellType getCachedFormulaResultType();

    String getCellFormula();

    CellStyle getCellStyle();

    CellType getCellType();

    int getColumnIndex();

    Date getDateCellValue();

    byte getErrorCellValue();

    LocalDateTime getLocalDateTimeCellValue();

    double getNumericCellValue();

    RichTextString getRichStringCellValue();

    Row getRow();

    int getRowIndex();

    Sheet getSheet();

    String getStringCellValue();

    boolean isPartOfArrayFormulaGroup();

    void setBlank();

    void setCellErrorValue(byte r1);

    void setCellValue(double r1);

    void setCellValue(String r1);

    void setCellValue(RichTextString r1);

    void setCellValue(boolean r1);
}
