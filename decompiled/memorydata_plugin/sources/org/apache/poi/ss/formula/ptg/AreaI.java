package org.apache.poi.ss.formula.ptg;

/* JADX INFO: loaded from: classes7.dex */
public interface AreaI {

    public static class OffsetArea implements AreaI {
        private final int _firstColumn;
        private final int _firstRow;
        private final int _lastColumn;
        private final int _lastRow;

        public OffsetArea(int r2, int r3, int r4, int r5, int r6, int r7) {
            this._firstRow = Math.min(r4, r5) + r2;
            this._lastRow = r2 + Math.max(r4, r5);
            this._firstColumn = Math.min(r6, r7) + r3;
            this._lastColumn = r3 + Math.max(r6, r7);
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getFirstColumn() {
            return this._firstColumn;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getFirstRow() {
            return this._firstRow;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getLastColumn() {
            return this._lastColumn;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getLastRow() {
            return this._lastRow;
        }
    }

    int getFirstColumn();

    int getFirstRow();

    int getLastColumn();

    int getLastRow();
}
