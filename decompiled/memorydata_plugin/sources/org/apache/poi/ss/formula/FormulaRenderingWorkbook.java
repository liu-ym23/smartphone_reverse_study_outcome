package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;

/* JADX INFO: loaded from: classes7.dex */
public interface FormulaRenderingWorkbook {
    EvaluationWorkbook.ExternalSheet getExternalSheet(int r1);

    String getNameText(NamePtg r1);

    String getSheetFirstNameByExternSheet(int r1);

    String getSheetLastNameByExternSheet(int r1);

    String resolveNameXText(NameXPtg r1);
}
