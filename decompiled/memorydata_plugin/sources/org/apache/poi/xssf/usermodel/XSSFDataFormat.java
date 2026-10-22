package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.xssf.model.StylesTable;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFDataFormat {
    private final StylesTable stylesSource;

    public XSSFDataFormat(StylesTable r1) {
        this.stylesSource = r1;
    }

    public String getFormat(short r1) {
        String r0 = this.stylesSource.getNumberFormatAt(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return BuiltinFormats.getBuiltinFormat(r1);
    }
}
