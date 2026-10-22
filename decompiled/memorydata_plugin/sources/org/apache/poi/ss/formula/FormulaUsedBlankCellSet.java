package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
final class FormulaUsedBlankCellSet {
    private final Map<BookSheetKey, BlankCellSheetGroup> _sheetGroupsByBookSheet;

    private static final class BlankCellRectangleGroup {
        private final int _firstColumnIndex;
        private final int _firstRowIndex;
        private final int _lastColumnIndex;
        private int _lastRowIndex;

        public BlankCellRectangleGroup(int r1, int r2, int r3) {
            this._firstRowIndex = r1;
            this._firstColumnIndex = r2;
            this._lastColumnIndex = r3;
            this._lastRowIndex = r1;
        }

        public boolean acceptRow(int r3, int r4, int r5) {
            if (r4 == this._firstColumnIndex) goto L6;
            return false;
        L6:
            if (r5 == this._lastColumnIndex) goto L9;
            return false;
        L9:
            if (r3 == (this._lastRowIndex + 1)) goto L11;
            return false;
        L11:
            this._lastRowIndex = r3;
            return true;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(64);
            CellReference r1 = new CellReference(this._firstRowIndex, this._firstColumnIndex, false, false);
            CellReference r2 = new CellReference(this._lastRowIndex, this._lastColumnIndex, false, false);
            r0.append(getClass().getName());
            r0.append(" [").append(r1.formatAsString()).append(':').append(r2.formatAsString()).append("]");
            return r0.toString();
        }
    }

    private static final class BlankCellSheetGroup {
        private BlankCellRectangleGroup _currentRectangleGroup;
        private int _currentRowIndex;
        private int _firstColumnIndex;
        private int _lastColumnIndex;
        private int _lastDefinedRow;
        private final List<BlankCellRectangleGroup> _rectangleGroups;

        public BlankCellSheetGroup(int r2) {
            this._rectangleGroups = new ArrayList();
            this._currentRowIndex = -1;
            this._lastDefinedRow = r2;
        }

        public void addCell(int r5, int r6) {
            if (r5 <= this._lastDefinedRow) goto L5;
            return;
        L5:
            int r0 = this._currentRowIndex;
            if (r0 != (-1)) goto L9;
        L7:
            this._currentRowIndex = r5;
            this._firstColumnIndex = r6;
        L8:
            this._lastColumnIndex = r6;
            return;
        L9:
            if (r0 == r5) goto L11;
        L13:
            BlankCellRectangleGroup r1 = this._currentRectangleGroup;
            if (r1 != null) goto L18;
            BlankCellRectangleGroup r2 = new BlankCellRectangleGroup(this._currentRowIndex, this._firstColumnIndex, this._lastColumnIndex);
        L16:
            this._currentRectangleGroup = r2;
            goto L7
        L18:
            if (r1.acceptRow(r0, this._firstColumnIndex, this._lastColumnIndex) == true) goto L7;
            this._rectangleGroups.add(this._currentRectangleGroup);
            r2 = new BlankCellRectangleGroup(this._currentRowIndex, this._firstColumnIndex, this._lastColumnIndex);
            goto L16
        L11:
            if ((this._lastColumnIndex + 1) != r6) goto L13;
            goto L13
        }
    }

    public static final class BookSheetKey {
        private final int _bookIndex;
        private final int _sheetIndex;

        public BookSheetKey(int r1, int r2) {
            this._bookIndex = r1;
            this._sheetIndex = r2;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, BookSheetKey.class) == true) goto L5;
            return false;
        L5:
            BookSheetKey r5 = (BookSheetKey) ZeusTransformUtils.preCheckCast(r4, BookSheetKey.class, "com.obric.memorydata.plugin");
            if (this._bookIndex == r5._bookIndex) goto L8;
            return false;
        L8:
            if (this._sheetIndex != r5._sheetIndex) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (this._bookIndex * 17) + this._sheetIndex;
        }
    }

    public FormulaUsedBlankCellSet() {
        this._sheetGroupsByBookSheet = new HashMap();
    }

    private BlankCellSheetGroup getSheetGroup(EvaluationWorkbook r4, int r5, int r6) {
        EvaluationWorkbook r7 = (EvaluationWorkbook) ZeusTransformUtils.wrapperContextForParams(r4, EvaluationWorkbook.class, "com.obric.memorydata.plugin");
        BookSheetKey r0 = new BookSheetKey(r5, r6);
        BlankCellSheetGroup r8 = (BlankCellSheetGroup) ZeusTransformUtils.preCheckCast(this._sheetGroupsByBookSheet.get(r0), BlankCellSheetGroup.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        BlankCellSheetGroup r9 = new BlankCellSheetGroup(r7.getSheet(r6).getLastRowNum());
        this._sheetGroupsByBookSheet.put(r0, r9);
        return r9;
    L6:
        return r8;
    }

    public void addCell(EvaluationWorkbook r3, int r4, int r5, int r6, int r7) {
        getSheetGroup((EvaluationWorkbook) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationWorkbook.class, "com.obric.memorydata.plugin"), r4, r5).addCell(r6, r7);
    }

    public boolean isEmpty() {
        return this._sheetGroupsByBookSheet.isEmpty();
    }
}
