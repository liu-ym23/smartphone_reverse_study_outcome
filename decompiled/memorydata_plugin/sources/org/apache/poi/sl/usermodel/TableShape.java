package org.apache.poi.sl.usermodel;

import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: classes7.dex */
public interface TableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Shape<S, P> {
    TableCell<S, P> getCell(int r1, int r2);

    int getNumberOfColumns();

    int getNumberOfRows();
}
