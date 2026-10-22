package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.FontScheme;
import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.model.ThemesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ac;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.by;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bz;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ca;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cb;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cc;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cm;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.e;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fg;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fh;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFFont implements Font {
    public static final short DEFAULT_FONT_COLOR = 0;
    private final by _ctFont;
    private int _index;
    private IndexedColorMap _indexedColorMap;
    private ThemesTable _themes;

    static {
        DEFAULT_FONT_COLOR = IndexedColors.BLACK.getIndex();
    }

    public XSSFFont() {
        this._ctFont = (by) ZeusTransformUtils.preCheckCast(by.f19507a.newInstance(), by.class, "com.obric.memorydata.plugin");
        setFontName("Calibri");
        setFontHeight(11.0d);
    }

    public XSSFFont(by r3, int r4, IndexedColorMap r5) {
        by r6 = (by) ZeusTransformUtils.wrapperContextForParams(r3, by.class, "com.obric.memorydata.plugin");
        IndexedColorMap r7 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r5, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this._ctFont = r6;
        this._index = (short) r4;
        this._indexedColorMap = r7;
    }

    private double getFontHeightRaw() {
        if (this._ctFont.sizeOfSzArray() != 0) goto L5;
        cc r2 = null;
    L6:
        if (r2 != null) goto L8;
        return 11.0d;
    L8:
        return r2.getVal();
    L5:
        r2 = this._ctFont.getSzArray(0);
        goto L6
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, XSSFFont.class) == true) goto L5;
        return false;
    L5:
        XSSFFont r5 = (XSSFFont) ZeusTransformUtils.preCheckCast(r4, XSSFFont.class, "com.obric.memorydata.plugin");
        if (Objects.equals(Boolean.valueOf(getItalic()), Boolean.valueOf(r5.getItalic())) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(Boolean.valueOf(getBold()), Boolean.valueOf(r5.getBold())) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(Boolean.valueOf(getStrikeout()), Boolean.valueOf(r5.getStrikeout())) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(Integer.valueOf(getCharSet()), Integer.valueOf(r5.getCharSet())) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(Short.valueOf(getColor()), Short.valueOf(r5.getColor())) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(Integer.valueOf(getFamily()), Integer.valueOf(r5.getFamily())) == true) goto L18;
        return false;
    L18:
        if (Objects.equals(Short.valueOf(getFontHeight()), Short.valueOf(r5.getFontHeight())) == true) goto L20;
        return false;
    L20:
        if (Objects.equals(getFontName(), r5.getFontName()) == true) goto L22;
        return false;
    L22:
        if (Objects.equals(getScheme(), r5.getScheme()) == true) goto L24;
        return false;
    L24:
        if (Objects.equals(Short.valueOf(getThemeColor()), Short.valueOf(r5.getThemeColor())) == true) goto L26;
        return false;
    L26:
        if (Objects.equals(Short.valueOf(getTypeOffset()), Short.valueOf(r5.getTypeOffset())) == true) goto L28;
        return false;
    L28:
        if (Objects.equals(Byte.valueOf(getUnderline()), Byte.valueOf(r5.getUnderline())) == true) goto L30;
        return false;
    L30:
        if (Objects.equals(getXSSFColor(), r5.getXSSFColor()) == false) goto L45;
        return true;
    L45:
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getBold() {
        if (this._ctFont.sizeOfBArray() != 0) goto L5;
        e r2 = null;
    L6:
        if (r2 != null) goto L8;
        return false;
    L8:
        if (r2.getVal() == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r2 = this._ctFont.getBArray(0);
        goto L6
    }

    public by getCTFont() {
        return this._ctFont;
    }

    public int getCharSet() {
        if (this._ctFont.sizeOfCharsetArray() != 0) goto L5;
        cm r1 = null;
    L6:
        if (r1 != null) goto L8;
        FontCharset r2 = FontCharset.ANSI;
    L10:
        return r2.getNativeId();
    L8:
        r2 = FontCharset.valueOf(r1.getVal());
        goto L10
    L5:
        r1 = this._ctFont.getCharsetArray(0);
        goto L6
    }

    public short getColor() {
        if (this._ctFont.sizeOfColorArray() != 0) goto L5;
        ac r4 = null;
    L6:
        if (r4 == null) goto L8;
        long r0 = r4.getIndexed();
        if (r0 != DEFAULT_FONT_COLOR) goto L14;
        return IndexedColors.BLACK.getIndex();
    L14:
        if (r0 != IndexedColors.RED.getIndex()) goto L18;
        return IndexedColors.RED.getIndex();
    L18:
        return (short) r0;
    L8:
        return IndexedColors.BLACK.getIndex();
    L5:
        r4 = this._ctFont.getColorArray(0);
        goto L6
    }

    public int getFamily() {
        if (this._ctFont.sizeOfFamilyArray() != 0) goto L5;
        bz r1 = null;
    L6:
        if (r1 != null) goto L8;
        FontFamily r2 = FontFamily.NOT_APPLICABLE;
    L10:
        return r2.getValue();
    L8:
        r2 = FontFamily.valueOf(r1.getVal());
        goto L10
    L5:
        r1 = this._ctFont.getFamilyArray(0);
        goto L6
    }

    public short getFontHeight() {
        return (short) (getFontHeightRaw() * 20.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public short getFontHeightInPoints() {
        return (short) getFontHeightRaw();
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public String getFontName() {
        if (this._ctFont.sizeOfNameArray() != 0) goto L5;
        ca r1 = null;
    L6:
        if (r1 != null) goto L9;
        return "Calibri";
    L9:
        return r1.getVal();
    L5:
        r1 = this._ctFont.getNameArray(0);
        goto L6
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public boolean getItalic() {
        if (this._ctFont.sizeOfIArray() != 0) goto L5;
        e r2 = null;
    L6:
        if (r2 != null) goto L8;
        return false;
    L8:
        if (r2.getVal() == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r2 = this._ctFont.getIArray(0);
        goto L6
    }

    public FontScheme getScheme() {
        if (this._ctFont.sizeOfSchemeArray() != 0) goto L5;
        cb r1 = null;
    L6:
        if (r1 != null) goto L9;
        return FontScheme.NONE;
    L9:
        return FontScheme.valueOf(r1.getVal().intValue());
    L5:
        r1 = this._ctFont.getSchemeArray(0);
        goto L6
    }

    public boolean getStrikeout() {
        if (this._ctFont.sizeOfStrikeArray() != 0) goto L5;
        e r2 = null;
    L6:
        if (r2 != null) goto L8;
        return false;
    L8:
        if (r2.getVal() == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r2 = this._ctFont.getStrikeArray(0);
        goto L6
    }

    public short getThemeColor() {
        if (this._ctFont.sizeOfColorArray() != 0) goto L5;
        ac r2 = null;
    L6:
        if (r2 != null) goto L8;
        long r0 = 0;
    L10:
        return (short) r0;
    L8:
        r0 = r2.getTheme();
        goto L10
    L5:
        r2 = this._ctFont.getColorArray(0);
        goto L6
    }

    public short getTypeOffset() {
        if (this._ctFont.sizeOfVertAlignArray() != 0) goto L5;
        fh r3 = null;
    L6:
        if (r3 != null) goto L8;
        return 0;
    L8:
        int r4 = r3.getVal().intValue();
        if (r4 != 1) goto L11;
        return 0;
    L11:
        if (r4 != 2) goto L13;
        return 1;
    L13:
        if (r4 != 3) goto L16;
        return 2;
    L16:
        throw new POIXMLException("Wrong offset value " + r4);
    L5:
        r3 = this._ctFont.getVertAlignArray(0);
        goto L6
    }

    @Override // org.apache.poi.ss.usermodel.Font
    public byte getUnderline() {
        if (this._ctFont.sizeOfUArray() != 0) goto L5;
        fg r2 = null;
    L6:
        if (r2 != null) goto L8;
        return 0;
    L8:
        return FontUnderline.valueOf(r2.getVal().intValue()).getByteValue();
    L5:
        r2 = this._ctFont.getUArray(0);
        goto L6
    }

    public XSSFColor getXSSFColor() {
        if (this._ctFont.sizeOfColorArray() != 0) goto L5;
        ac r0 = null;
    L6:
        if (r0 == null) goto L11;
        XSSFColor r1 = XSSFColor.from(r0, this._indexedColorMap);
        ThemesTable r3 = this._themes;
        if (r3 == null) goto L10;
        r3.inheritFromThemeAsRequired(r1);
    L10:
        return r1;
    L11:
        return null;
    L5:
        r0 = this._ctFont.getColorArray(0);
        goto L6
    }

    public int hashCode() {
        return this._ctFont.toString().hashCode();
    }

    public void setColor(short r3) {
        int r0 = this._ctFont.sizeOfColorArray();
        by r2 = this._ctFont;
        if (r0 != 0) goto L5;
        ac r4 = r2.addNewColor();
    L7:
        if (r3 != 10) goto L9;
        r3 = IndexedColors.RED.getIndex();
    L13:
        r4.setIndexed(r3);
        return;
    L9:
        if (r3 != Short.MAX_VALUE) goto L13;
        r3 = DEFAULT_FONT_COLOR;
        goto L13
    L5:
        r4 = r2.getColorArray(0);
        goto L7
    }

    public void setFamily(int r2) {
        int r0 = this._ctFont.sizeOfFamilyArray();
        by r1 = this._ctFont;
        if (r0 != 0) goto L5;
        bz r3 = r1.addNewFamily();
    L6:
        r3.setVal(r2);
        return;
    L5:
        r3 = r1.getFamilyArray(0);
        goto L6
    }

    public void setFamily(FontFamily r1) {
        setFamily(r1.getValue());
    }

    public void setFontHeight(double r2) {
        int r0 = this._ctFont.sizeOfSzArray();
        by r1 = this._ctFont;
        if (r0 != 0) goto L5;
        cc r3 = r1.addNewSz();
    L6:
        r3.setVal(r2);
        return;
    L5:
        r3 = r1.getSzArray(0);
        goto L6
    }

    public void setFontHeightInPoints(short r3) {
        setFontHeight(r3);
    }

    public void setFontName(String r2) {
        int r0 = this._ctFont.sizeOfNameArray();
        by r1 = this._ctFont;
        if (r0 != 0) goto L5;
        ca r3 = r1.addNewName();
    L6:
        if (r2 != null) goto L8;
        r2 = "Calibri";
    L8:
        r3.setVal(r2);
        return;
    L5:
        r3 = r1.getNameArray(0);
        goto L6
    }

    public void setScheme(FontScheme r2) {
        int r0 = this._ctFont.sizeOfSchemeArray();
        by r1 = this._ctFont;
        if (r0 != 0) goto L5;
        cb r3 = r1.addNewScheme();
    L6:
        r3.setVal(STFontScheme.Enum.forInt(r2.getValue()));
        return;
    L5:
        r3 = r1.getSchemeArray(0);
        goto L6
    }

    public void setThemesTable(ThemesTable r1) {
        this._themes = r1;
    }

    public String toString() {
        return this._ctFont.toString();
    }
}
