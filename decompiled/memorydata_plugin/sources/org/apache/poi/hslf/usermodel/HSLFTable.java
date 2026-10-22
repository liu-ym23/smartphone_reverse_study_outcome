package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.sl.usermodel.TableShape;

/* JADX INFO: loaded from: classes7.dex */
public final class HSLFTable extends HSLFGroupShape implements TableShape<HSLFShape, HSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected HSLFTableCell[][] cells;
    private int columnCount;

    static class LineRect {
        final HSLFLine l;
        final double lx1;
        final double lx2;
        final double ly1;
        final double ly2;

        LineRect(HSLFLine r3) {
            this.l = r3;
            Rectangle2D r4 = r3.getAnchor();
            this.lx1 = r4.getMinX();
            this.lx2 = r4.getMaxX();
            this.ly1 = r4.getMinY();
            this.ly2 = r4.getMaxY();
        }

        int bottomFit(double r1, double r3, double r5, double r7) {
            return (int) (((Math.abs(r1 - this.lx1) + Math.abs(r7 - this.ly1)) + Math.abs(r3 - this.lx2)) + Math.abs(r7 - this.ly2));
        }

        int leftFit(double r3, double r5, double r7, double r9) {
            return (int) (((Math.abs(r3 - this.lx1) + Math.abs(r7 - this.ly1)) + Math.abs(r3 - this.lx2)) + Math.abs(r9 - this.ly2));
        }

        int rightFit(double r3, double r5, double r7, double r9) {
            return (int) (((Math.abs(r5 - this.lx1) + Math.abs(r7 - this.ly1)) + Math.abs(r5 - this.lx2)) + Math.abs(r9 - this.ly2));
        }

        int topFit(double r1, double r3, double r5, double r7) {
            return (int) (((Math.abs(r1 - this.lx1) + Math.abs(r5 - this.ly1)) + Math.abs(r3 - this.lx2)) + Math.abs(r5 - this.ly2));
        }
    }

    static {
    }

    public HSLFTable(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
        this.columnCount = -1;
    }

    private int calcSpan(List<Double> r6, double r7, int r9) {
        ListIterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).listIterator(r9);
        double r1 = ((Double) ZeusTransformUtils.preCheckCast(r5.next(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        int r8 = 1;
    L4:
        if (r5.hasNext() == false) goto L8;
        if ((((Double) ZeusTransformUtils.preCheckCast(r5.next(), Double.class, "com.obric.memorydata.plugin")).doubleValue() - r1) >= r7) goto L8;
        r8 = r8 + 1;
    L8:
        return r8;
    }

    private void cellListToArray() {
        ArrayList r0 = new ArrayList();
        Iterator<HSLFShape> r1 = getShapes().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        HSLFShape r2 = (HSLFShape) ZeusTransformUtils.preCheckCast(r1.next(), HSLFShape.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, HSLFTableCell.class) == false) goto L4;
        r0.add((HSLFTableCell) ZeusTransformUtils.preCheckCast(r2, HSLFTableCell.class, "com.obric.memorydata.plugin"));
        goto L4
    L9:
        if (r0.isEmpty() == true) goto L20;
        TreeSet r3 = new TreeSet();
        TreeSet r4 = new TreeSet();
        Iterator r5 = r0.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        Rectangle2D r6 = ((HSLFTableCell) ZeusTransformUtils.preCheckCast(r5.next(), HSLFTableCell.class, "com.obric.memorydata.plugin")).getAnchor();
        r3.add(Double.valueOf(r6.getX()));
        r4.add(Double.valueOf(r6.getY()));
        goto L12
    L14:
        this.cells = (HSLFTableCell[][]) Array.newInstance(HSLFTableCell.class, new int[]{r4.size(), r3.size()});
        ArrayList r7 = new ArrayList(r3);
        ArrayList r8 = new ArrayList(r4);
        Iterator r9 = r0.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        HSLFTableCell r10 = (HSLFTableCell) ZeusTransformUtils.preCheckCast(r9.next(), HSLFTableCell.class, "com.obric.memorydata.plugin");
        Rectangle2D r11 = r10.getAnchor();
        int r12 = r8.indexOf(Double.valueOf(r11.getY()));
        int r13 = r7.indexOf(Double.valueOf(r11.getX()));
        this.cells[r12][r13] = r10;
        int r14 = calcSpan(r7, r11.getWidth(), r13);
        int r15 = calcSpan(r8, r11.getHeight(), r12);
        r10.setGridSpan(r14);
        r10.setRowSpan(r15);
        goto L16
    L18:
        return;
    L20:
        throw new IllegalStateException("HSLFTable without HSLFTableCells");
    }

    private void fitLinesToCells() {
        ArrayList r0 = new ArrayList();
        Iterator<HSLFShape> r1 = getShapes().iterator();
    L3:
        String r3 = "com.obric.memorydata.plugin";
        if (r1.hasNext() == false) goto L8;
        HSLFShape r2 = (HSLFShape) ZeusTransformUtils.preCheckCast(r1.next(), HSLFShape.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, HSLFLine.class) == false) goto L3;
        r0.add(new LineRect((HSLFLine) ZeusTransformUtils.preCheckCast(r2, HSLFLine.class, "com.obric.memorydata.plugin")));
        goto L3
    L8:
        HSLFTableCell[][] r4 = this.cells;
        int r5 = r4.length;
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L47;
        HSLFTableCell[] r7 = r4[r6];
        int r8 = r7.length;
        int r9 = 0;
    L11:
        if (r9 >= r8) goto L46;
        HSLFTableCell r10 = r7[r9];
        if (r10 != null) goto L15;
        ArrayList r28 = r0;
        HSLFTableCell[][] r29 = r4;
        int r30 = r5;
        String r32 = r3;
        int r35 = r6;
        HSLFTableCell[] r31 = r7;
        int r33 = r8;
    L45:
        r9 = r9 + 1;
        r0 = r28;
        r4 = r29;
        r5 = r30;
        r7 = r31;
        r3 = r32;
        r8 = r33;
        r6 = r35;
        goto L11
    L15:
        Rectangle2D r11 = r10.getAnchor();
        double r20 = r11.getMinX();
        double r22 = r11.getMaxX();
        double r24 = r11.getMinY();
        double r26 = r11.getMaxY();
        Iterator r12 = r0.iterator();
        r28 = r0;
        r29 = r4;
        int r13 = Integer.MAX_VALUE;
        int r14 = Integer.MAX_VALUE;
        int r15 = Integer.MAX_VALUE;
        LineRect r16 = null;
        LineRect r17 = null;
        LineRect r18 = null;
        LineRect r19 = null;
        int r110 = Integer.MAX_VALUE;
    L16:
        r30 = r5;
        if (r12.hasNext() == false) goto L32;
        HSLFTableCell[] r34 = r7;
        LineRect r21 = (LineRect) ZeusTransformUtils.preCheckCast(r12.next(), LineRect.class, r3);
        LineRect r23 = r19;
        String r36 = r3;
        int r37 = r8;
        int r25 = r110;
        int r27 = r13;
        int r38 = r6;
        Iterator r39 = r12;
        int r111 = r14;
        int r40 = r15;
        int r112 = r21.leftFit(r20, r22, r24, r26);
        if (r112 >= r111) goto L21;
        r23 = r21;
        r111 = r112;
    L21:
        int r113 = r21.topFit(r20, r22, r24, r26);
        if (r113 >= r40) goto L24;
        r18 = r21;
        r40 = r113;
    L24:
        int r114 = r21.rightFit(r20, r22, r24, r26);
        if (r114 >= r25) goto L27;
        r16 = r21;
        r25 = r114;
    L27:
        int r115 = r21.bottomFit(r20, r22, r24, r26);
        if (r115 >= r27) goto L30;
        r17 = r21;
        r13 = r115;
    L31:
        r110 = r25;
        r15 = r40;
        r19 = r23;
        r14 = r111;
        r5 = r30;
        r7 = r34;
        r3 = r36;
        r8 = r37;
        r12 = r39;
        r6 = r38;
        goto L16
    L30:
        r13 = r27;
        goto L31
    L32:
        r32 = r3;
        r35 = r6;
        r31 = r7;
        r33 = r8;
        LineRect r41 = r19;
        int r42 = r110;
        int r43 = r13;
        int r44 = r15;
        if (r14 >= 5) goto L36;
        if (r41 == null) goto L36;
        r10.borderLeft = r41.l;
    L36:
        if (r44 >= 5) goto L39;
        if (r18 == null) goto L39;
        r10.borderTop = r18.l;
    L39:
        if (r42 >= 5) goto L42;
        if (r16 == null) goto L42;
        r10.borderRight = r16.l;
    L42:
        if (r43 >= 5) goto L45;
        if (r17 == null) goto L45;
        r10.borderBottom = r17.l;
        goto L45
    L46:
        r6 = r6 + 1;
        goto L9
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public HSLFTableCell getCell(int r3, int r4) {
        if (r3 < 0) goto L15;
        HSLFTableCell[][] r2 = this.cells;
        if (r2.length <= r3) goto L15;
        HSLFTableCell[] r5 = r2[r3];
        if (r5 == null) goto L15;
        if (r4 < 0) goto L15;
        if (r5.length <= r4) goto L15;
        return r5[r4];
    L15:
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public /* bridge */ /* synthetic */ TableCell getCell(int r1, int r2) {
        return getCell(r1, r2);
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public int getNumberOfColumns() {
        if (this.columnCount != (-1)) goto L11;
        HSLFTableCell[][] r0 = this.cells;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        HSLFTableCell[] r3 = r0[r2];
        if (r3 == null) goto L9;
        this.columnCount = Math.max(this.columnCount, r3.length);
    L9:
        r2 = r2 + 1;
    L11:
        return this.columnCount;
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public int getNumberOfRows() {
        return this.cells.length;
    }

    public void initTable() {
        cellListToArray();
        fitLinesToCells();
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFShape
    public void setSheet(HSLFSheet r8) {
        super.setSheet(r8);
        HSLFTableCell[][] r0 = this.cells;
        if (r0 != null) goto L5;
        initTable();
        return;
    L5:
        int r7 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r7) goto L14;
        HSLFTableCell[] r3 = r0[r2];
        int r4 = r3.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L10;
        r3[r5].setSheet(r8);
        r5 = r5 + 1;
        goto L8
    L10:
        r2 = r2 + 1;
        goto L6
    }
}
