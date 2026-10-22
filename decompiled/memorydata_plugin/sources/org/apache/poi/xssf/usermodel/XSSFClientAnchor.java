package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.bv;
import org.openxmlformats.schemas.drawingml.x2006.main.bz;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.j;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFClientAnchor extends XSSFAnchor implements ClientAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final j EMPTY_MARKER = null;
    private ClientAnchor.AnchorType anchorType;
    private j cell1;
    private j cell2;
    private bv position;
    private XSSFSheet sheet;
    private bz size;

    static {
        EMPTY_MARKER = (j) ZeusTransformUtils.preCheckCast(j.f19038a.newInstance(), j.class, "com.obric.memorydata.plugin");
    }

    public XSSFClientAnchor() {
        this(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public XSSFClientAnchor(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        this.anchorType = ClientAnchor.AnchorType.MOVE_AND_RESIZE;
        j r0 = (j) ZeusTransformUtils.preCheckCast(j.f19038a.newInstance(), j.class, "com.obric.memorydata.plugin");
        this.cell1 = r0;
        r0.setCol(r8);
        this.cell1.setColOff(Integer.valueOf(r4));
        this.cell1.setRow(r9);
        this.cell1.setRowOff(Integer.valueOf(r5));
        j r12 = (j) ZeusTransformUtils.preCheckCast(j.f19038a.newInstance(), j.class, "com.obric.memorydata.plugin");
        this.cell2 = r12;
        r12.setCol(r10);
        this.cell2.setColOff(Integer.valueOf(r6));
        this.cell2.setRow(r11);
        this.cell2.setRowOff(Integer.valueOf(r7));
    }

    public XSSFClientAnchor(XSSFSheet r3, bv r4, bz r5) {
        bv r6 = (bv) ZeusTransformUtils.wrapperContextForParams(r4, bv.class, "com.obric.memorydata.plugin");
        bz r7 = (bz) ZeusTransformUtils.wrapperContextForParams(r5, bz.class, "com.obric.memorydata.plugin");
        this.anchorType = ClientAnchor.AnchorType.DONT_MOVE_AND_RESIZE;
        this.sheet = r3;
        this.position = r6;
        this.size = r7;
    }

    public XSSFClientAnchor(XSSFSheet r3, j r4, bz r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        bz r7 = (bz) ZeusTransformUtils.wrapperContextForParams(r5, bz.class, "com.obric.memorydata.plugin");
        this.anchorType = ClientAnchor.AnchorType.MOVE_DONT_RESIZE;
        this.sheet = r3;
        this.size = r7;
        this.cell1 = r6;
    }

    public XSSFClientAnchor(j r3, j r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        this.anchorType = ClientAnchor.AnchorType.MOVE_AND_RESIZE;
        this.cell1 = r5;
        this.cell2 = r6;
    }

    private j calcCell(j r9, long r10, long r12) {
        j r11 = (j) ZeusTransformUtils.wrapperContextForParams(r9, j.class, "com.obric.memorydata.plugin");
        j r0 = (j) ZeusTransformUtils.preCheckCast(j.f19038a.newInstance(), j.class, "com.obric.memorydata.plugin");
        int r1 = r11.getRow();
        int r2 = r11.getCol();
        int r3 = Units.columnWidthToEMU(this.sheet.getColumnWidth(r2));
        long r4 = ((long) r3) - POIXMLUnits.parseLength(r11.xgetColOff());
    L4:
        if (r4 >= r10) goto L6;
        r2 = r2 + 1;
        r3 = Units.columnWidthToEMU(this.sheet.getColumnWidth(r2));
        r4 = r4 + ((long) r3);
        goto L4
    L6:
        r0.setCol(r2);
        r0.setColOff(Long.valueOf(((long) r3) - (r4 - r10)));
        int r13 = Units.toEMU(getRowHeight(this.sheet, r1));
        long r5 = ((long) r13) - POIXMLUnits.parseLength(r11.xgetRowOff());
    L8:
        if (r5 >= r12) goto L10;
        r1 = r1 + 1;
        r13 = Units.toEMU(getRowHeight(this.sheet, r1));
        r5 = r5 + ((long) r13);
        goto L8
    L10:
        r0.setRow(r1);
        r0.setRowOff(Long.valueOf(((long) r13) - (r5 - r12)));
        return r0;
    }

    private j getCell1() {
        j r0 = this.cell1;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return calcCell(EMPTY_MARKER, POIXMLUnits.parseLength(this.position.xgetX()), POIXMLUnits.parseLength(this.position.xgetY()));
    }

    private j getCell2() {
        j r0 = this.cell2;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return calcCell(getCell1(), this.size.getCx(), this.size.getCy());
    }

    private static float getRowHeight(XSSFSheet r0, int r1) {
        XSSFRow r2 = r0.getRow(r1);
        if (r2 != null) goto L6;
        return r0.getDefaultRowHeightInPoints();
    L6:
        return r2.getHeightInPoints();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, XSSFClientAnchor.class) == true) goto L5;
        return false;
    L5:
        XSSFClientAnchor r5 = (XSSFClientAnchor) ZeusTransformUtils.preCheckCast(r4, XSSFClientAnchor.class, "com.obric.memorydata.plugin");
        if (getDx1() == r5.getDx1()) goto L8;
        return false;
    L8:
        if (getDx2() == r5.getDx2()) goto L10;
        return false;
    L10:
        if (getDy1() == r5.getDy1()) goto L12;
        return false;
    L12:
        if (getDy2() == r5.getDy2()) goto L14;
        return false;
    L14:
        if (getCol1() == r5.getCol1()) goto L16;
        return false;
    L16:
        if (getCol2() == r5.getCol2()) goto L18;
        return false;
    L18:
        if (getRow1() == r5.getRow1()) goto L20;
        return false;
    L20:
        if (getRow2() != r5.getRow2()) goto L30;
        return true;
    L30:
        return false;
    }

    public short getCol1() {
        return (short) getCell1().getCol();
    }

    public short getCol2() {
        return (short) getCell2().getCol();
    }

    public int getDx1() {
        return Math.toIntExact(POIXMLUnits.parseLength(getCell1().xgetColOff()));
    }

    public int getDx2() {
        return Math.toIntExact(POIXMLUnits.parseLength(getCell2().xgetColOff()));
    }

    public int getDy1() {
        return Math.toIntExact(POIXMLUnits.parseLength(getCell1().xgetRowOff()));
    }

    public int getDy2() {
        return Math.toIntExact(POIXMLUnits.parseLength(getCell2().xgetRowOff()));
    }

    public int getRow1() {
        return getCell1().getRow();
    }

    public int getRow2() {
        return getCell2().getRow();
    }

    public int hashCode() {
        return 42;
    }

    public String toString() {
        return "from : " + getCell1() + "; to: " + getCell2();
    }
}
