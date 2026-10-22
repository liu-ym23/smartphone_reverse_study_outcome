package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: classes7.dex */
public interface EvaluationWorkbook {

    public static class ExternalName {
        private final int _ix;
        private final String _nameName;
        private final int _nameNumber;

        public ExternalName(String r1, int r2, int r3) {
            this._nameName = r1;
            this._nameNumber = r2;
            this._ix = r3;
        }

        public int getIx() {
            return this._ix;
        }

        public String getName() {
            return this._nameName;
        }
    }

    public static class ExternalSheet {
        private final String _sheetName;
        private final String _workbookName;

        public ExternalSheet(String r1, String r2) {
            this._workbookName = r1;
            this._sheetName = r2;
        }

        public String getSheetName() {
            return this._sheetName;
        }

        public String getWorkbookName() {
            return this._workbookName;
        }
    }

    public static class ExternalSheetRange extends ExternalSheet {
        private final String _lastSheetName;

        public ExternalSheetRange(String r1, String r2, String r3) {
            super(r1, r2);
            this._lastSheetName = r3;
        }

        public String getFirstSheetName() {
            return getSheetName();
        }

        public String getLastSheetName() {
            return this._lastSheetName;
        }
    }

    ExternalName getExternalName(int r1, int r2);

    ExternalName getExternalName(String r1, String r2, int r3);

    ExternalSheet getExternalSheet(int r1);

    ExternalSheet getExternalSheet(String r1, String r2, int r3);

    Ptg[] getFormulaTokens(EvaluationCell r1);

    EvaluationName getName(String r1, int r2);

    EvaluationName getName(NamePtg r1);

    EvaluationSheet getSheet(int r1);

    int getSheetIndex(String r1);

    int getSheetIndex(EvaluationSheet r1);

    String getSheetName(int r1);

    SpreadsheetVersion getSpreadsheetVersion();

    String resolveNameXText(NameXPtg r1);
}
