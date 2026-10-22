package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFEvaluationWorkbook extends BaseXSSFEvaluationWorkbook {
    private final Map<XSSFSheet, XSSFEvaluationSheet> _sheetCache;

    private XSSFEvaluationWorkbook(XSSFWorkbook r1) {
        super(r1);
        this._sheetCache = new HashMap();
    }

    public static XSSFEvaluationWorkbook create(XSSFWorkbook r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new XSSFEvaluationWorkbook(r1);
    }

    static /* synthetic */ XSSFEvaluationSheet lambda$getSheet$0(XSSFSheet r0, XSSFSheet r1) {
        return new XSSFEvaluationSheet(r0);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public Ptg[] getFormulaTokens(EvaluationCell r4) {
        XSSFCell r5 = ((XSSFEvaluationCell) ZeusTransformUtils.preCheckCast((EvaluationCell) ZeusTransformUtils.wrapperContextForParams(r4, EvaluationCell.class, "com.obric.memorydata.plugin"), XSSFEvaluationCell.class, "com.obric.memorydata.plugin")).getXSSFCell();
        int r0 = this._uBook.getSheetIndex(r5.getSheet());
        int r1 = r5.getRowIndex();
        return FormulaParser.parse(r5.getCellFormula(this), this, FormulaType.CELL, r0, r1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationSheet getSheet(int r2) {
        if (r2 >= 0) goto L4;
    L5:
        this._uBook.getSheetAt(r2);
    L6:
        final XSSFSheet r3 = this._uBook.getSheetAt(r2);
        return (EvaluationSheet) ZeusTransformUtils.preCheckCast(this._sheetCache.computeIfAbsent(r3, new $$Lambda$XSSFEvaluationWorkbook$qUmYLlfwAnF6QLnbV28wLYCh65A(r3)), EvaluationSheet.class, "com.obric.memorydata.plugin");
    L4:
        if (r2 < this._uBook.getNumberOfSheets()) goto L6;
        goto L5
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(EvaluationSheet r3) {
        XSSFSheet r4 = ((XSSFEvaluationSheet) ZeusTransformUtils.preCheckCast((EvaluationSheet) ZeusTransformUtils.wrapperContextForParams(r3, EvaluationSheet.class, "com.obric.memorydata.plugin"), XSSFEvaluationSheet.class, "com.obric.memorydata.plugin")).getXSSFSheet();
        return this._uBook.getSheetIndex(r4);
    }
}
