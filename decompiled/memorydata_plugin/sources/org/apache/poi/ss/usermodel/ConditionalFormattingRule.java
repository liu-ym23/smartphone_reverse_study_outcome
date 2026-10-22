package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: classes7.dex */
public interface ConditionalFormattingRule extends DifferentialStyleProvider {
    byte getComparisonOperation();

    ConditionFilterType getConditionFilterType();

    ConditionType getConditionType();

    ConditionFilterData getFilterConfiguration();

    String getFormula1();

    String getFormula2();

    ExcelNumberFormat getNumberFormat();

    int getPriority();

    boolean getStopIfTrue();

    String getText();
}
