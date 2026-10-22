package org.apache.poi.hssf.model;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFFormulaParser {
    private static FormulaParsingWorkbook createParsingWorkbook(HSSFWorkbook r0) {
        return HSSFEvaluationWorkbook.create(r0);
    }

    public static Ptg[] parse(String r0, HSSFWorkbook r1, FormulaType r2, int r3) {
        return FormulaParser.parse(r0, createParsingWorkbook(r1), r2, r3);
    }

    public static String toFormulaString(HSSFWorkbook r0, Ptg[] r1) {
        return FormulaRenderer.toFormulaString(HSSFEvaluationWorkbook.create(r0), r1);
    }
}
