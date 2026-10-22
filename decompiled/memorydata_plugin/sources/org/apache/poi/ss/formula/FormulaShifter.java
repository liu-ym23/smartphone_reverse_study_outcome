package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class FormulaShifter {
    private final int _amountToMove;
    private final int _firstMovedIndex;
    private final int _lastMovedIndex;

    private static final enum ShiftMode extends Enum<ShiftMode> {
        private static final /* synthetic */ ShiftMode[] $VALUES = null;
        public static final ShiftMode ColumnCopy = null;
        public static final ShiftMode ColumnMove = null;
        public static final ShiftMode RowCopy = null;
        public static final ShiftMode RowMove = null;
        public static final ShiftMode SheetMove = null;

        static {
            ShiftMode r0 = new ShiftMode("RowMove", 0);
            RowMove = r0;
            ShiftMode r1 = new ShiftMode("RowCopy", 1);
            RowCopy = r1;
            ShiftMode r3 = new ShiftMode("ColumnMove", 2);
            ColumnMove = r3;
            ShiftMode r5 = new ShiftMode("ColumnCopy", 3);
            ColumnCopy = r5;
            ShiftMode r7 = new ShiftMode("SheetMove", 4);
            SheetMove = r7;
            $VALUES = new ShiftMode[]{r0, r1, r3, r5, r7};
        }

        private ShiftMode(String r1, int r2) {
            super(r1, r2);
        }

        public static ShiftMode valueOf(String r2) {
            return (ShiftMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ShiftMode.class, r2), ShiftMode.class, "com.obric.memorydata.plugin");
        }

        public static ShiftMode[] values() {
            return (ShiftMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ShiftMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public String toString() {
        return getClass().getName() + " [" + this._firstMovedIndex + this._lastMovedIndex + this._amountToMove + "]";
    }
}
