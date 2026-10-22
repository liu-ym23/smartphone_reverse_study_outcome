package org.apache.poi.xssf.streaming;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator;

/* JADX INFO: loaded from: classes7.dex */
public final class SXSSFFormulaEvaluator extends BaseXSSFFormulaEvaluator {
    private static final c LOG = null;

    public static class RowFlushedException extends IllegalStateException {
        public RowFlushedException(int r3, int r4) {
            super("Row " + r3 + " has been flushed (rows up to " + r4 + " have been flushed), cannot evaluate all cells");
        }
    }

    public static class SheetsFlushedException extends IllegalStateException {
        public SheetsFlushedException() {
            super("One or more sheets have been flushed, cannot evaluate all cells");
        }
    }

    static {
        LOG = b.a(SXSSFFormulaEvaluator.class);
    }

    @Override // org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator
    public EvaluationCell toEvaluationCell(Cell r3) {
        Cell r2 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, SXSSFCell.class) == false) goto L7;
        return new SXSSFEvaluationCell((SXSSFCell) ZeusTransformUtils.preCheckCast(r2, SXSSFCell.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalArgumentException("Unexpected type of cell: " + r2.getClass() + ". Only SXSSFCells can be evaluated.");
    }
}
