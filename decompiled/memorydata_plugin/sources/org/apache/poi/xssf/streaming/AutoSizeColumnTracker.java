package org.apache.poi.xssf.streaming;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.SheetUtil;

/* JADX INFO: loaded from: classes7.dex */
class AutoSizeColumnTracker {
    private final DataFormatter dataFormatter;
    private final int defaultCharWidth;
    private final Map<Integer, ColumnWidthPair> maxColumnWidths;
    private boolean trackAllColumns;
    private final Set<Integer> untrackedColumns;

    private static class ColumnWidthPair {
        private double withSkipMergedCells;
        private double withUseMergedCells;

        public ColumnWidthPair() {
            this(-1.0d, -1.0d);
        }

        public ColumnWidthPair(double r1, double r3) {
            this.withSkipMergedCells = r1;
            this.withUseMergedCells = r3;
        }

        public void setMaxColumnWidths(double r3, double r5) {
            this.withUseMergedCells = Math.max(this.withUseMergedCells, r5);
            this.withSkipMergedCells = Math.max(this.withSkipMergedCells, r3);
        }
    }

    public AutoSizeColumnTracker(Sheet r3) {
        Sheet r4 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r3, Sheet.class, "com.obric.memorydata.plugin");
        this.dataFormatter = new DataFormatter();
        this.maxColumnWidths = new HashMap();
        this.untrackedColumns = new HashSet();
        this.defaultCharWidth = SheetUtil.getDefaultCharWidth(r4.getWorkbook());
    }

    private boolean implicitlyTrackColumn(int r3) {
        if (this.untrackedColumns.contains(Integer.valueOf(r3)) == true) goto L6;
        trackColumn(r3);
        return true;
    L6:
        return false;
    }

    private void implicitlyTrackColumnsInRow(Row r4) {
        Row r5 = (Row) ZeusTransformUtils.wrapperContextForParams(r4, Row.class, "com.obric.memorydata.plugin");
        if (this.trackAllColumns == false) goto L8;
        Iterator<Cell> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        implicitlyTrackColumn(((Cell) ZeusTransformUtils.preCheckCast(r6.next(), Cell.class, "com.obric.memorydata.plugin")).getColumnIndex());
        goto L6
    L10:
        return;
    }

    private void updateColumnWidth(Cell r5, ColumnWidthPair r6) {
        Cell r7 = (Cell) ZeusTransformUtils.wrapperContextForParams(r5, Cell.class, "com.obric.memorydata.plugin");
        r6.setMaxColumnWidths(SheetUtil.getCellWidth(r7, this.defaultCharWidth, this.dataFormatter, false), SheetUtil.getCellWidth(r7, this.defaultCharWidth, this.dataFormatter, true));
    }

    public boolean trackColumn(int r3) {
        this.untrackedColumns.remove(Integer.valueOf(r3));
        if (this.maxColumnWidths.containsKey(Integer.valueOf(r3)) == true) goto L6;
        this.maxColumnWidths.put(Integer.valueOf(r3), new ColumnWidthPair());
        return true;
    L6:
        return false;
    }

    public void updateColumnWidths(Row r6) {
        Row r7 = (Row) ZeusTransformUtils.wrapperContextForParams(r6, Row.class, "com.obric.memorydata.plugin");
        implicitlyTrackColumnsInRow(r7);
        if (this.maxColumnWidths.size() >= r7.getPhysicalNumberOfCells()) goto L10;
        Iterator<Map.Entry<Integer, ColumnWidthPair>> r0 = this.maxColumnWidths.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Cell r3 = r7.getCell(((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        if (r3 == null) goto L6;
        updateColumnWidth(r3, (ColumnWidthPair) ZeusTransformUtils.preCheckCast(r2.getValue(), ColumnWidthPair.class, "com.obric.memorydata.plugin"));
        goto L6
    L16:
        return;
    L10:
        Iterator<Cell> r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L27;
        Cell r1 = (Cell) ZeusTransformUtils.preCheckCast(r8.next(), Cell.class, "com.obric.memorydata.plugin");
        int r4 = r1.getColumnIndex();
        if (this.maxColumnWidths.containsKey(Integer.valueOf(r4)) == false) goto L12;
        updateColumnWidth(r1, (ColumnWidthPair) ZeusTransformUtils.preCheckCast(this.maxColumnWidths.get(Integer.valueOf(r4)), ColumnWidthPair.class, "com.obric.memorydata.plugin"));
        goto L12
    }
}
