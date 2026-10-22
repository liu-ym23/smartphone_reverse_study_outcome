package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public class ConditionalFormattingEvaluator {
    private final Map<String, List<EvaluationConditionalFormatRule>> formats;
    private final Map<CellReference, List<EvaluationConditionalFormatRule>> values;
    private final Workbook workbook;
    private final WorkbookEvaluator workbookEvaluator;

    public static CellReference getRef(Cell r7) {
        Cell r8 = (Cell) ZeusTransformUtils.wrapperContextForParams(r7, Cell.class, "com.obric.memorydata.plugin");
        return new CellReference(r8.getSheet().getSheetName(), r8.getRowIndex(), r8.getColumnIndex(), false, false);
    }

    public List<EvaluationConditionalFormatRule> getConditionalFormattingForCell(Cell r3) {
        return getConditionalFormattingForCell(getRef((Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin")));
    }

    public List<EvaluationConditionalFormatRule> getConditionalFormattingForCell(CellReference r7) {
        List<EvaluationConditionalFormatRule> r0 = (List) ZeusTransformUtils.preCheckCast(this.values.get(r7), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L19;
        r0 = new ArrayList();
        if (r7.getSheetName() == null) goto L7;
        Sheet r1 = this.workbook.getSheet(r7.getSheetName());
    L8:
        boolean r3 = false;
        Iterator<EvaluationConditionalFormatRule> r2 = getRules(r1).iterator();
    L10:
        if (r2.hasNext() == false) goto L17;
        EvaluationConditionalFormatRule r4 = (EvaluationConditionalFormatRule) ZeusTransformUtils.preCheckCast(r2.next(), EvaluationConditionalFormatRule.class, "com.obric.memorydata.plugin");
        if (r3 == true) goto L10;
        if (r4.matches(r7) == false) goto L10;
        r0.add(r4);
        r3 = r4.getRule().getStopIfTrue();
        goto L10
    L17:
        Collections.sort(r0);
        this.values.put(r7, r0);
        goto L19
    L7:
        Workbook r5 = this.workbook;
        r1 = r5.getSheetAt(r5.getActiveSheetIndex());
    L19:
        return Collections.unmodifiableList(r0);
    }

    public List<EvaluationConditionalFormatRule> getRules(Sheet r19) {
        Sheet r1 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r19, Sheet.class, "com.obric.memorydata.plugin");
        String r3 = r1.getSheetName();
        List r2 = (List) ZeusTransformUtils.preCheckCast(this.formats.get(r3), List.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L17;
        if (this.formats.containsKey(r3) == true) goto L7;
        SheetConditionalFormatting r4 = r1.getSheetConditionalFormatting();
        int r11 = r4.getNumConditionalFormattings();
        ArrayList r12 = new ArrayList(r11);
        this.formats.put(r3, r12);
        int r14 = 0;
    L9:
        if (r14 >= r11) goto L15;
        ConditionalFormatting r15 = r4.getConditionalFormattingAt(r14);
        CellRangeAddress[] r16 = r15.getFormattingRanges();
        int r10 = 0;
    L12:
        if (r10 >= r15.getNumberOfRules()) goto L14;
        ConditionalFormattingRule r8 = r15.getRule(r10);
        r12.add(new EvaluationConditionalFormatRule(this.workbookEvaluator, r1, r15, r14, r8, r10, r16));
        r10 = r10 + 1;
        goto L12
    L14:
        r14 = r14 + 1;
        goto L9
    L15:
        Collections.sort(r12);
        r2 = r12;
        goto L17
    L7:
        return Collections.emptyList();
    L17:
        return Collections.unmodifiableList(r2);
    }
}
