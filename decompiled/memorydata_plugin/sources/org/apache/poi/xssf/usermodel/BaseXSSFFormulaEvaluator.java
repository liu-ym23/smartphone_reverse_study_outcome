package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.ExternalLinksTable;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseXSSFFormulaEvaluator extends BaseFormulaEvaluator {
    private void cacheExternalWorkbookCells(EvaluationCell r25) {
        String r1 = "com.obric.memorydata.plugin";
        EvaluationCell r0 = (EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r25, EvaluationCell.class, "com.obric.memorydata.plugin");
        Ptg[] r2 = getEvaluationWorkbook().getFormulaTokens(r0);
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L23;
        Ptg r6 = r2[r5];
        if (ZeusTransformUtils.instanceOf(r6, Area3DPxg.class) == false) goto L22;
        Area3DPxg r7 = (Area3DPxg) ZeusTransformUtils.preCheckCast(r6, Area3DPxg.class, r1);
        if (r7.getExternalWorkbookNumber() <= 0) goto L22;
        EvaluationWorkbook.ExternalSheet r8 = getEvaluationWorkbook().getExternalSheet(r7.getSheetName(), r7.getLastSheetName(), r7.getExternalWorkbookNumber());
        XSSFCell r9 = ((XSSFEvaluationCell) ZeusTransformUtils.preCheckCast(r0, XSSFEvaluationCell.class, r1)).getXSSFCell();
        XSSFWorkbook r10 = (XSSFWorkbook) ZeusTransformUtils.preCheckCast(r9.getSheet().getWorkbook().getCreationHelper().getReferencedWorkbooks().get(r8.getWorkbookName()), XSSFWorkbook.class, r1);
        ExternalLinksTable r11 = (ExternalLinksTable) ZeusTransformUtils.preCheckCast(r9.getSheet().getWorkbook().getExternalLinksTable().get(r7.getExternalWorkbookNumber() - 1), ExternalLinksTable.class, r1);
        int r12 = r10.getSheetIndex(r7.getSheetName());
        if (r7.getLastSheetName() == null) goto L11;
        int r15 = r10.getSheetIndex(r7.getLastSheetName());
    L12:
        int r14 = r12;
    L13:
        if (r14 > r15) goto L22;
        XSSFSheet r13 = r10.getSheetAt(r14);
        int r16 = r7.getFirstRow();
        int r17 = r7.getLastRow();
        int r18 = r16;
    L15:
        if (r18 > r17) goto L21;
        XSSFRow r19 = r13.getRow(r18);
        int r20 = r7.getFirstColumn();
        int r4 = r7.getLastColumn();
    L17:
        EvaluationCell r110 = r0;
        if (r20 > r4) goto L20;
        XSSFCell r21 = r19.getCell(r20);
        String r111 = r21.getRawValue();
        String r112 = r1;
        String r22 = new CellReference(r21).formatAsString(false);
        r11.cacheData(r13.getSheetName(), ((long) r18) + 1, r22, r111);
        r20 = r20 + 1;
        r13 = r13;
        r14 = r14;
        r0 = r110;
        r1 = r112;
        r17 = r17;
        r19 = r19;
        r18 = r18;
        goto L17
    L20:
        r18 = r18 + 1;
        r0 = r110;
        r1 = r1;
        goto L15
    L21:
        r14 = r14 + 1;
        r1 = r1;
        goto L13
    L11:
        r15 = r12;
    L22:
        r5 = r5 + 1;
        r0 = r0;
        r1 = r1;
        goto L3
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    public RichTextString createRichTextString(String r1) {
        return new XSSFRichTextString(r1);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    public CellValue evaluateFormulaCellValue(Cell r3) {
        EvaluationCell r4 = toEvaluationCell((Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin"));
        ValueEval r0 = this._bookEvaluator.evaluate(r4);
        cacheExternalWorkbookCells(r4);
        if (ZeusTransformUtils.instanceOf(r0, NumberEval.class) == false) goto L7;
        return new CellValue(((NumberEval) ZeusTransformUtils.preCheckCast(r0, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue());
    L7:
        if (ZeusTransformUtils.instanceOf(r0, BoolEval.class) == false) goto L11;
        return CellValue.valueOf(((BoolEval) ZeusTransformUtils.preCheckCast(r0, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue());
    L11:
        if (ZeusTransformUtils.instanceOf(r0, StringEval.class) == false) goto L15;
        return new CellValue(((StringEval) ZeusTransformUtils.preCheckCast(r0, StringEval.class, "com.obric.memorydata.plugin")).getStringValue());
    L15:
        if (ZeusTransformUtils.instanceOf(r0, ErrorEval.class) == false) goto L19;
        return CellValue.getError(((ErrorEval) ZeusTransformUtils.preCheckCast(r0, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode());
    L19:
        throw new RuntimeException("Unexpected eval class (" + r0.getClass().getName() + ")");
    }

    public abstract EvaluationCell toEvaluationCell(Cell r1);
}
