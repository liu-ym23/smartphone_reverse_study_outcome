package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: classes7.dex */
public interface DataValidationConstraint {
    String[] getExplicitListValues();

    String getFormula1();

    String getFormula2();

    int getOperator();

    int getValidationType();
}
