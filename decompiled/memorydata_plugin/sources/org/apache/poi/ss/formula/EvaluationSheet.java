package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: classes7.dex */
public interface EvaluationSheet {
    EvaluationCell getCell(int r1, int r2);

    int getLastRowNum();

    boolean isRowHidden(int r1);
}
