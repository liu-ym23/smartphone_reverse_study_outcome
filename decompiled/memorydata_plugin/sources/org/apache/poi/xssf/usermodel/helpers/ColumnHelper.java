package org.apache.poi.xssf.usermodel.helpers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.poi.xssf.util.CTColComparator;
import org.apache.poi.xssf.util.NumericRanges;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.aa;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.af;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fm;

/* JADX INFO: loaded from: classes7.dex */
public class ColumnHelper {
    private fm worksheet;

    public ColumnHelper(fm r3) {
        this.worksheet = (fm) ZeusTransformUtils.wrapperContextForParams(r3, fm.class, "com.obric.memorydata.plugin");
        cleanColumns();
    }

    private void addCleanColIntoCols(af r20, aa r21, TreeSet<aa> r22) {
        af r2 = (af) ZeusTransformUtils.wrapperContextForParams(r20, af.class, "com.obric.memorydata.plugin");
        aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r21, aa.class, "com.obric.memorydata.plugin");
        List<aa> r5 = getOverlappingCols(r4, r22);
        if (r5.isEmpty() == false) goto L6;
        r22.add(cloneCol(r2, r4));
        return;
    L6:
        r22.removeAll(r5);
        Iterator<aa> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L23;
        aa r7 = (aa) ZeusTransformUtils.preCheckCast(r6.next(), aa.class, "com.obric.memorydata.plugin");
        long[] r8 = getOverlap(r4, r7);
        aa r9 = cloneCol(r2, r7, r8);
        setColumnAttributes(r4, r9);
        r22.add(r9);
        if (r7.getMin() >= r4.getMin()) goto L12;
        aa r10 = r7;
    L13:
        long[] r11 = {Math.min(r7.getMin(), r4.getMin()), r8[0] - 1};
        if (r11[0] > r11[1]) goto L17;
        r22.add(cloneCol(r2, r10, r11));
    L17:
        if (r7.getMax() <= r4.getMax()) goto L19;
        aa r12 = r7;
    L20:
        long[] r13 = {r8[1] + 1, Math.max(r7.getMax(), r4.getMax())};
        if (r13[0] > r13[1]) goto L8;
        r22.add(cloneCol(r2, r12, r13));
        goto L8
    L19:
        r12 = r4;
        goto L20
    L12:
        r10 = r4;
        goto L13
    }

    private aa cloneCol(af r3, aa r4, long[] r5) {
        aa r2 = cloneCol((af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin"), (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin"));
        r2.setMin(r5[0]);
        r2.setMax(r5[1]);
        return r2;
    }

    private boolean columnExists(af r4, long r5, long r7) {
        Iterator<aa> r3 = ((af) ZeusTransformUtils.wrapperContextForParams(r4, af.class, "com.obric.memorydata.plugin")).getColList().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        aa r6 = (aa) ZeusTransformUtils.preCheckCast(r3.next(), aa.class, "com.obric.memorydata.plugin");
        if (r6.getMin() != r5) goto L4;
        if (r6.getMax() != r7) goto L4;
        return true;
    L11:
        return false;
    }

    private long[] getOverlap(aa r3, aa r4) {
        return getOverlappingRange((aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.memorydata.plugin"), (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin"));
    }

    private List<aa> getOverlappingCols(aa r5, TreeSet<aa> r6) {
        aa r7 = (aa) ZeusTransformUtils.wrapperContextForParams(r5, aa.class, "com.obric.memorydata.plugin");
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r6.lower(r7), aa.class, "com.obric.memorydata.plugin");
        TreeSet<aa> r8 = r6;
        if (r0 == null) goto L6;
        r8 = r6.tailSet(r0, overlaps(r0, r7));
    L6:
        ArrayList r1 = new ArrayList();
        Iterator<aa> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        aa r2 = (aa) ZeusTransformUtils.preCheckCast(r9.next(), aa.class, "com.obric.memorydata.plugin");
        if (overlaps(r7, r2) == false) goto L12;
        r1.add(r2);
    L12:
        return r1;
    }

    private long[] getOverlappingRange(aa r3, aa r4) {
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.memorydata.plugin");
        aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        return NumericRanges.getOverlappingRange(toRange(r5), toRange(r6));
    }

    private aa insertCol(af r10, long r11, long r13, aa[] r15) {
        return insertCol((af) ZeusTransformUtils.wrapperContextForParams(r10, af.class, "com.obric.memorydata.plugin"), r11, r13, r15, false, null);
    }

    private aa insertCol(af r11, long r12, long r14, aa[] r16, boolean r17, aa r18) {
        af r8 = (af) ZeusTransformUtils.wrapperContextForParams(r11, af.class, "com.obric.memorydata.plugin");
        aa r9 = (aa) ZeusTransformUtils.wrapperContextForParams(r18, aa.class, "com.obric.memorydata.plugin");
        if (r17 == false) goto L5;
    L9:
        int r0 = 0;
        aa r1 = r8.insertNewCol(0);
        r1.setMin(r12);
        r1.setMax(r14);
        int r2 = r16.length;
    L10:
        if (r0 >= r2) goto L12;
        setColumnAttributes(r16[r0], r1);
        r0 = r0 + 1;
        goto L10
    L12:
        if (r9 == null) goto L14;
        setColumnAttributes(r9, r1);
    L14:
        return r1;
    L5:
        if (columnExists(r8, r12, r14) == false) goto L9;
        return null;
    }

    private boolean overlaps(aa r3, aa r4) {
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.memorydata.plugin");
        aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        if (NumericRanges.getOverlappingType(toRange(r5), toRange(r6)) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private long[] toRange(aa r4) {
        aa r3 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        return new long[]{r3.getMin(), r3.getMax()};
    }

    public void cleanColumns() {
        TreeSet<aa> r0 = new TreeSet(CTColComparator.BY_MIN_MAX);
        af r1 = (af) ZeusTransformUtils.preCheckCast(af.f19419a.newInstance(), af.class, "com.obric.memorydata.plugin");
        af[] r2 = this.worksheet.getColsArray();
        int r5 = 0;
    L4:
        if (r5 >= r2.length) goto L10;
        Iterator<aa> r6 = r2[r5].getColList().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        addCleanColIntoCols(r1, (aa) ZeusTransformUtils.preCheckCast(r6.next(), aa.class, "com.obric.memorydata.plugin"), r0);
        goto L7
    L9:
        r5 = r5 + 1;
        goto L4
    L10:
        int r7 = r5 - 1;
    L11:
        if (r7 < 0) goto L13;
        this.worksheet.removeCols(r7);
        r7 = r7 - 1;
        goto L11
    L13:
        r1.setColArray((aa[]) ZeusTransformUtils.preCheckCast(r0.toArray(new aa[0]), aa[].class, "com.obric.memorydata.plugin"));
        this.worksheet.addNewCols();
        this.worksheet.setColsArray(0, r1);
    }

    public aa cloneCol(af r3, aa r4) {
        af r5 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.memorydata.plugin");
        aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        aa r7 = r5.addNewCol();
        r7.setMin(r6.getMin());
        r7.setMax(r6.getMax());
        setColumnAttributes(r6, r7);
        return r7;
    }

    public int getColDefaultStyle(long r3) {
        if (getColumn(r3, false) != null) goto L5;
        return -1;
    L5:
        return (int) getColumn(r3, false).getStyle();
    }

    public aa getColumn(long r3, boolean r5) {
        return getColumn1Based(r3 + 1, r5);
    }

    public aa getColumn1Based(long r21, boolean r23) {
        if (this.worksheet.sizeOfColsArray() != 0) goto L5;
        return null;
    L5:
        char r10 = 0;
        af r11 = this.worksheet.getColsArray(0);
        aa[] r0 = r11.getColArray();
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L21;
        aa r12 = r0[r3];
        long r4 = r12.getMin();
        long r13 = r12.getMax();
        if (r4 > r21) goto L20;
        if (r13 < r21) goto L20;
        if (r23 == true) goto L13;
    L19:
        return r12;
    L13:
        if (r4 >= r21) goto L16;
        aa[] r6 = new aa[1];
        r6[r10] = r12;
        insertCol(r11, r4, r21 - 1, r6);
    L16:
        if (r13 <= r21) goto L18;
        insertCol(r11, r21 + 1, r13, new aa[]{r12});
    L18:
        r12.setMin(r21);
        r12.setMax(r21);
    L20:
        r3 = r3 + 1;
        r10 = r10;
        goto L6
    L21:
        return null;
    }

    public void setColumnAttributes(aa r3, aa r4) {
        aa r2 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.memorydata.plugin");
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        if (r2.isSetBestFit() == false) goto L6;
        r5.setBestFit(r2.getBestFit());
    L6:
        if (r2.isSetCustomWidth() == false) goto L9;
        r5.setCustomWidth(r2.getCustomWidth());
    L9:
        if (r2.isSetHidden() == false) goto L12;
        r5.setHidden(r2.getHidden());
    L12:
        if (r2.isSetStyle() == false) goto L15;
        r5.setStyle(r2.getStyle());
    L15:
        if (r2.isSetWidth() == false) goto L18;
        r5.setWidth(r2.getWidth());
    L18:
        if (r2.isSetCollapsed() == false) goto L21;
        r5.setCollapsed(r2.getCollapsed());
    L21:
        if (r2.isSetPhonetic() == false) goto L24;
        r5.setPhonetic(r2.getPhonetic());
    L24:
        if (r2.isSetOutlineLevel() == false) goto L27;
        r5.setOutlineLevel(r2.getOutlineLevel());
        return;
    }
}
