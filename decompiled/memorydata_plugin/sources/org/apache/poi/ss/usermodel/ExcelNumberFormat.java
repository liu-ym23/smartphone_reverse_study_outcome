package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.ss.formula.EvaluationConditionalFormatRule;

/* JADX INFO: loaded from: classes7.dex */
public class ExcelNumberFormat {
    private final String format;
    private final int idx;

    public ExcelNumberFormat(int r1, String r2) {
        this.idx = r1;
        this.format = r2;
    }

    public static ExcelNumberFormat from(Cell r3, ConditionalFormattingEvaluator r4) {
        Cell r5 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        ExcelNumberFormat r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r4 == null) goto L11;
        Iterator<EvaluationConditionalFormatRule> r6 = r4.getConditionalFormattingForCell(r5).iterator();
    L8:
        if (r6.hasNext() == false) goto L11;
        r0 = ((EvaluationConditionalFormatRule) ZeusTransformUtils.preCheckCast(r6.next(), EvaluationConditionalFormatRule.class, "com.obric.memorydata.plugin")).getNumberFormat();
        if (r0 == null) goto L8;
    L11:
        if (r0 == null) goto L13;
        return r0;
    L13:
        return from(r5.getCellStyle());
    }

    public static ExcelNumberFormat from(CellStyle r2) {
        CellStyle r3 = (CellStyle) ZeusTransformUtils.wrapperContextForParams(r2, CellStyle.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return new ExcelNumberFormat(r3.getDataFormat(), r3.getDataFormatString());
    }

    public String getFormat() {
        return this.format;
    }

    public int getIdx() {
        return this.idx;
    }
}
