package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.q;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFCellStyle implements CellStyle {
    private final fo _cellStyleXf;
    private fo _cellXf;
    private int _cellXfId;
    private final StylesTable _stylesSource;
    private ThemesTable _theme;

    public XSSFCellStyle(int r1, int r2, StylesTable r3, ThemesTable r4) {
        this._cellXfId = r1;
        this._stylesSource = r3;
        this._cellXf = r3.getCellXfAt(r1);
        if (r2 != (-1)) goto L5;
        fo r5 = null;
    L6:
        this._cellStyleXf = r5;
        this._theme = r4;
        return;
    L5:
        r5 = r3.getCellStyleXfAt(r2);
        goto L6
    }

    private int getFontId() {
        if (this._cellXf.isSetFontId() == false) goto L7;
        fo r2 = this._cellXf;
    L6:
        return (int) r2.getFontId();
    L7:
        r2 = this._cellStyleXf;
        goto L6
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, XSSFCellStyle.class) == true) goto L6;
        return false;
    L6:
        XSSFCellStyle r4 = (XSSFCellStyle) ZeusTransformUtils.preCheckCast(r3, XSSFCellStyle.class, "com.obric.memorydata.plugin");
        return this._cellXf.toString().equals(r4.getCoreXf().toString());
    }

    public fo getCoreXf() {
        return this._cellXf;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getDataFormat() {
        return (short) this._cellXf.getNumFmtId();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public String getDataFormatString() {
        return new XSSFDataFormat(this._stylesSource).getFormat(getDataFormat());
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public int getFontIndex() {
        return getFontId();
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndention() {
        q r2 = this._cellXf.getAlignment();
        if (r2 != null) goto L5;
        long r0 = 0;
    L7:
        return (short) r0;
    L5:
        r0 = r2.getIndent();
        goto L7
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getIndex() {
        return (short) this._cellXfId;
    }

    @Override // org.apache.poi.ss.usermodel.CellStyle
    public short getRotation() {
        q r1 = this._cellXf.getAlignment();
        if (r1 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r1.getTextRotation() == null) goto L8;
        return r1.getTextRotation().shortValue();
    }

    public int hashCode() {
        return this._cellXf.toString().hashCode();
    }

    public void verifyBelongsToStylesSource(StylesTable r1) {
        if (this._stylesSource != r1) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("This Style does not belong to the supplied Workbook Styles Source. Are you trying to assign a style from one workbook to the cell of a different workbook?");
    }
}
