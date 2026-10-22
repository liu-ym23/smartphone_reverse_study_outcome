package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.apache.poi.ss.usermodel.ConditionFilterType;
import org.apache.poi.ss.usermodel.ConditionType;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bc;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cv;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.x;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFConditionalFormattingRule implements ConditionalFormattingRule {
    private static final Map<STCfType.Enum, ConditionFilterType> filterTypeLookup = null;
    private static final Map<STCfType.Enum, ConditionType> typeLookup = null;
    private final x _cfRule;
    private final XSSFSheet _sh;

    static {
        HashMap r0 = new HashMap();
        typeLookup = r0;
        HashMap r1 = new HashMap();
        filterTypeLookup = r1;
        r0.put(STCfType.d, ConditionType.CELL_VALUE_IS);
        r0.put(STCfType.c, ConditionType.FORMULA);
        r0.put(STCfType.e, ConditionType.COLOR_SCALE);
        r0.put(STCfType.f, ConditionType.DATA_BAR);
        r0.put(STCfType.g, ConditionType.ICON_SET);
        r0.put(STCfType.h, ConditionType.FILTER);
        r0.put(STCfType.i, ConditionType.FILTER);
        r0.put(STCfType.j, ConditionType.FILTER);
        r0.put(STCfType.k, ConditionType.FILTER);
        r0.put(STCfType.l, ConditionType.FILTER);
        r0.put(STCfType.m, ConditionType.FILTER);
        r0.put(STCfType.n, ConditionType.FILTER);
        r0.put(STCfType.o, ConditionType.FILTER);
        r0.put(STCfType.p, ConditionType.FILTER);
        r0.put(STCfType.q, ConditionType.FILTER);
        r0.put(STCfType.r, ConditionType.FILTER);
        r0.put(STCfType.s, ConditionType.FILTER);
        r0.put(STCfType.t, ConditionType.FILTER);
        r1.put(STCfType.h, ConditionFilterType.TOP_10);
        r1.put(STCfType.i, ConditionFilterType.UNIQUE_VALUES);
        r1.put(STCfType.j, ConditionFilterType.DUPLICATE_VALUES);
        r1.put(STCfType.k, ConditionFilterType.CONTAINS_TEXT);
        r1.put(STCfType.l, ConditionFilterType.NOT_CONTAINS_TEXT);
        r1.put(STCfType.m, ConditionFilterType.BEGINS_WITH);
        r1.put(STCfType.n, ConditionFilterType.ENDS_WITH);
        r1.put(STCfType.o, ConditionFilterType.CONTAINS_BLANKS);
        r1.put(STCfType.p, ConditionFilterType.NOT_CONTAINS_BLANKS);
        r1.put(STCfType.q, ConditionFilterType.CONTAINS_ERRORS);
        r1.put(STCfType.r, ConditionFilterType.NOT_CONTAINS_ERRORS);
        r1.put(STCfType.s, ConditionFilterType.TIME_PERIOD);
        r1.put(STCfType.t, ConditionFilterType.ABOVE_AVERAGE);
    }

    XSSFConditionalFormattingRule(XSSFSheet r3, x r4) {
        this._cfRule = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.memorydata.plugin");
        this._sh = r3;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public byte getComparisonOperation() {
        STConditionalFormattingOperator.Enum r1 = this._cfRule.getOperator();
        if (r1 != null) goto L6;
        return 0;
    L6:
        switch(r1.intValue()) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        return 0;
    L8:
        return 2;
    L10:
        return 1;
    L12:
        return 5;
    L14:
        return 7;
    L16:
        return 4;
    L18:
        return 3;
    L20:
        return 8;
    L22:
        return 6;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterType getConditionFilterType() {
        return (ConditionFilterType) ZeusTransformUtils.preCheckCast(filterTypeLookup.get(this._cfRule.getType()), ConditionFilterType.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionType getConditionType() {
        return (ConditionType) ZeusTransformUtils.preCheckCast(typeLookup.get(this._cfRule.getType()), ConditionType.class, "com.obric.memorydata.plugin");
    }

    bc getDxf(boolean r7) {
        StylesTable r0 = this._sh.getWorkbook().getStylesSource();
        if (r0._getDXfsSize() > 0) goto L5;
    L7:
        bc r1 = null;
    L8:
        if (r7 == false) goto L12;
        if (r1 != null) goto L13;
        bc r2 = (bc) ZeusTransformUtils.preCheckCast(bc.f19463a.newInstance(), bc.class, "com.obric.memorydata.plugin");
        int r8 = r0.putDxf(r2);
        this._cfRule.setDxfId(((long) r8) - 1);
        return r2;
    L13:
        return r1;
    L12:
        return r1;
    L5:
        if (this._cfRule.isSetDxfId() == false) goto L7;
        r1 = r0.getDxfAt((int) this._cfRule.getDxfId());
        goto L8
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterData getFilterConfiguration() {
        return new XSSFConditionFilterData(this._cfRule);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula1() {
        if (this._cfRule.sizeOfFormulaArray() > 0) goto L7;
        return null;
    L7:
        return this._cfRule.getFormulaArray(0);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula2() {
        if (this._cfRule.sizeOfFormulaArray() == 2) goto L7;
        return null;
    L7:
        return this._cfRule.getFormulaArray(1);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ExcelNumberFormat getNumberFormat() {
        bc r3 = getDxf(false);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isSetNumFmt() == false) goto L11;
        cv r4 = r3.getNumFmt();
        return new ExcelNumberFormat((int) r4.getNumFmtId(), r4.getFormatCode());
    L11:
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public int getPriority() {
        int r1 = this._cfRule.getPriority();
        if (r1 >= 1) goto L7;
        return 0;
    L7:
        return r1;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public boolean getStopIfTrue() {
        return this._cfRule.getStopIfTrue();
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public int getStripeSize() {
        return 0;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getText() {
        return this._cfRule.getText();
    }
}
