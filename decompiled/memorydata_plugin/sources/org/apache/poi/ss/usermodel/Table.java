package org.apache.poi.ss.usermodel;

import java.util.regex.Pattern;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public interface Table {
    public static final Pattern isStructuredReference = null;

    static {
        isStructuredReference = Pattern.compile("[a-zA-Z_\\\\][a-zA-Z0-9._]*\\[.*\\]");
    }

    boolean contains(CellReference r1);

    int findColumnIndex(String r1);

    int getEndColIndex();

    int getEndRowIndex();

    int getHeaderRowCount();

    String getName();

    String getSheetName();

    int getStartColIndex();

    int getStartRowIndex();

    TableStyleInfo getStyle();

    int getTotalsRowCount();
}
