package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseFormulaEvaluator implements FormulaEvaluator {
    protected final WorkbookEvaluator _bookEvaluator;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.BaseFormulaEvaluator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;

        static {
            int[] r0 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r0;
            r0[CellType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public abstract RichTextString createRichTextString(String r1);

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public CellType evaluateFormulaCell(Cell r3) {
        Cell r4 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        if (r4.getCellType() != CellType.FORMULA) goto L10;
        CellValue r0 = evaluateFormulaCellValue(r4);
        setCellValue(r4, r0);
        return r0.getCellType();
    L10:
        return CellType._NONE;
    }

    public abstract CellValue evaluateFormulaCellValue(Cell r1);

    public EvaluationWorkbook getEvaluationWorkbook() {
        return this._bookEvaluator.getWorkbook();
    }

    public void setCellValue(Cell r4, CellValue r5) {
        Cell r6 = (Cell) ZeusTransformUtils.wrapperContextForParams(r4, Cell.class, "com.obric.memorydata.plugin");
        CellType r0 = r5.getCellType();
        int r1 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r0.ordinal()];
        if (r1 != 1) goto L5;
        r6.setCellValue(r5.getBooleanValue());
        return;
    L5:
        if (r1 != 2) goto L7;
        r6.setCellErrorValue(r5.getErrorValue());
        return;
    L7:
        if (r1 != 4) goto L9;
        r6.setCellValue(r5.getNumberValue());
        return;
    L9:
        if (r1 != 5) goto L12;
        r6.setCellValue(createRichTextString(r5.getStringValue()));
        return;
    L12:
        throw new IllegalStateException("Unexpected cell value type (" + r0 + ")");
    }
}
