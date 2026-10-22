package org.apache.poi.ss.usermodel;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes7.dex */
public interface Sheet extends Iterable<Row> {
    Row createRow(int r1);

    List<CellRangeAddress> getMergedRegions();

    int getNumMergedRegions();

    int getPhysicalNumberOfRows();

    Row getRow(int r1);

    SheetConditionalFormatting getSheetConditionalFormatting();

    String getSheetName();

    Workbook getWorkbook();

    @Override // java.lang.Iterable
    default Iterator<Row> iterator() {
        return rowIterator();
    }

    CellRange<? extends Cell> removeArrayFormula(Cell r1);

    Iterator<Row> rowIterator();

    @Override // java.lang.Iterable
    default Spliterator<Row> spliterator() {
        return Spliterators.spliterator(rowIterator(), getPhysicalNumberOfRows(), 0);
    }
}
