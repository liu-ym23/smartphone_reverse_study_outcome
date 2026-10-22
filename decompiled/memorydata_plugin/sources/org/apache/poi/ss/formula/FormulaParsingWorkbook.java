package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public interface FormulaParsingWorkbook {
    Name createName();

    Ptg get3DReferencePtg(AreaReference r1, SheetIdentifier r2);

    Ptg get3DReferencePtg(CellReference r1, SheetIdentifier r2);

    EvaluationName getName(String r1, int r2);

    Ptg getNameXPtg(String r1, SheetIdentifier r2);

    SpreadsheetVersion getSpreadsheetVersion();

    Table getTable(String r1);
}
