package org.apache.poi.xssf.model;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFComment;

/* JADX INFO: loaded from: classes7.dex */
public interface Comments {
    XSSFComment findCellComment(CellAddress r1);

    void setSheet(Sheet r1);
}
