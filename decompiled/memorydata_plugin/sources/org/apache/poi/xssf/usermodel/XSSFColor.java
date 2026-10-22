package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.ExtendedColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ac;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFColor extends ExtendedColor {
    private final ac ctColor;
    private final IndexedColorMap indexedColorMap;

    public XSSFColor() {
        this((ac) ZeusTransformUtils.preCheckCast(ac.f19413a.newInstance(), ac.class, "com.obric.memorydata.plugin"), null);
    }

    private XSSFColor(ac r3, IndexedColorMap r4) {
        ac r5 = (ac) ZeusTransformUtils.wrapperContextForParams(r3, ac.class, "com.obric.memorydata.plugin");
        IndexedColorMap r6 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r4, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this.ctColor = r5;
        this.indexedColorMap = r6;
    }

    public XSSFColor(byte[] r4, IndexedColorMap r5) {
        IndexedColorMap r6 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r5, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this((ac) ZeusTransformUtils.preCheckCast(ac.f19413a.newInstance(), ac.class, "com.obric.memorydata.plugin"), r6);
        this.ctColor.setRgb(r4);
    }

    public static XSSFColor from(ac r2, IndexedColorMap r3) {
        ac r4 = (ac) ZeusTransformUtils.wrapperContextForParams(r2, ac.class, "com.obric.memorydata.plugin");
        IndexedColorMap r5 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r3, IndexedColorMap.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        return new XSSFColor(r4, r5);
    }

    private boolean sameARGB(XSSFColor r4) {
        if (isRGB() == r4.isRGB()) goto L5;
        return false;
    L5:
        if (isRGB() == true) goto L7;
    L8:
        return true;
    L7:
        if (Arrays.equals(getARGB(), r4.getARGB()) == true) goto L8;
        return false;
    }

    private boolean sameAuto(XSSFColor r1) {
        if (isAuto() != r1.isAuto()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean sameIndexed(XSSFColor r4) {
        if (isIndexed() == r4.isIndexed()) goto L5;
        return false;
    L5:
        if (isIndexed() == true) goto L7;
    L8:
        return true;
    L7:
        if (getIndexed() == r4.getIndexed()) goto L8;
        return false;
    }

    private boolean sameTheme(XSSFColor r4) {
        if (isThemed() == r4.isThemed()) goto L5;
        return false;
    L5:
        if (isThemed() == true) goto L7;
    L8:
        return true;
    L7:
        if (getTheme() == r4.getTheme()) goto L8;
        return false;
    }

    private boolean sameTint(XSSFColor r4) {
        if (hasTint() == r4.hasTint()) goto L5;
        return false;
    L5:
        if (hasTint() == true) goto L7;
    L8:
        return true;
    L7:
        if (getTint() == r4.getTint()) goto L8;
        return false;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, XSSFColor.class) == true) goto L5;
        return false;
    L5:
        XSSFColor r5 = (XSSFColor) ZeusTransformUtils.preCheckCast(r4, XSSFColor.class, "com.obric.memorydata.plugin");
        if (sameARGB(r5) == true) goto L8;
        return false;
    L8:
        if (sameTheme(r5) == true) goto L10;
        return false;
    L10:
        if (sameIndexed(r5) == true) goto L12;
        return false;
    L12:
        if (sameTint(r5) == true) goto L14;
        return false;
    L14:
        if (sameAuto(r5) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public byte[] getARGB() {
        byte[] r4 = getRGBOrARGB();
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.length != 3) goto L10;
        byte[] r0 = new byte[4];
        r0[0] = -1;
        System.arraycopy(r4, 0, r0, 1, 3);
        return r0;
    L10:
        return r4;
    }

    public ac getCTColor() {
        return this.ctColor;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public short getIndex() {
        return (short) this.ctColor.getIndexed();
    }

    public short getIndexed() {
        return getIndex();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getIndexedRGB() {
        if (isIndexed() == false) goto L10;
        IndexedColorMap r0 = this.indexedColorMap;
        short r1 = getIndex();
        if (r0 == null) goto L9;
        return r0.getRGB(r1);
    L9:
        return DefaultIndexedColorMap.getDefaultRGB(r1);
    L10:
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public byte[] getStoredRBG() {
        return this.ctColor.getRgb();
    }

    public int getTheme() {
        return (int) this.ctColor.getTheme();
    }

    public double getTint() {
        return this.ctColor.getTint();
    }

    public boolean hasTint() {
        if (this.ctColor.isSetTint() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.ctColor.getTint() == 0.0d) goto L7;
        return true;
    }

    public int hashCode() {
        return this.ctColor.toString().hashCode();
    }

    public boolean isAuto() {
        return this.ctColor.getAuto();
    }

    @Override // org.apache.poi.ss.usermodel.ExtendedColor
    public boolean isIndexed() {
        return this.ctColor.isSetIndexed();
    }

    public boolean isRGB() {
        return this.ctColor.isSetRgb();
    }

    public boolean isThemed() {
        return this.ctColor.isSetTheme();
    }
}
