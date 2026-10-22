package org.apache.poi.ss.formula.ptg;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.SheetNameFormatter;

/* JADX INFO: loaded from: classes7.dex */
final class ExternSheetNameResolver {
    public static String prependSheetName(FormulaRenderingWorkbook r8, int r9, String r10) {
        FormulaRenderingWorkbook r11 = (FormulaRenderingWorkbook) ZeusTransformUtils.wrapperContextForParams(r8, FormulaRenderingWorkbook.class, "com.obric.memorydata.plugin");
        EvaluationWorkbook.ExternalSheet r0 = r11.getExternalSheet(r9);
        if (r0 == null) goto L21;
        String r12 = r0.getWorkbookName();
        String r13 = r0.getSheetName();
        if (r12 == null) goto L11;
        int r6 = r12.length();
        if (r13 != null) goto L9;
        int r7 = 0;
    L10:
        StringBuilder r5 = new StringBuilder(((r6 + r7) + r10.length()) + 4);
        SheetNameFormatter.appendFormat(r5, r12, r13);
    L13:
        if (ZeusTransformUtils.instanceOf(r0, EvaluationWorkbook.ExternalSheetRange.class) == false) goto L27;
        EvaluationWorkbook.ExternalSheetRange r14 = (EvaluationWorkbook.ExternalSheetRange) ZeusTransformUtils.preCheckCast(r0, EvaluationWorkbook.ExternalSheetRange.class, "com.obric.memorydata.plugin");
        if (r14.getFirstSheetName().equals(r14.getLastSheetName()) == true) goto L27;
        r5.append(':');
        StringBuilder r15 = new StringBuilder();
        SheetNameFormatter.appendFormat(r15, r14.getLastSheetName());
        if (r15.charAt(0) != '\'') goto L20;
        r5.insert(0, '\'');
        String r16 = r15.substring(1);
    L19:
        r5.append(r16);
        goto L27
    L20:
        r5.append(r15);
    L27:
        r5.append('!');
        r5.append(r10);
        return r5.toString();
    L9:
        r7 = r13.length();
        goto L10
    L11:
        r5 = new StringBuilder((r13.length() + r10.length()) + 4);
        SheetNameFormatter.appendFormat(r5, r13);
        goto L13
    L21:
        String r1 = r11.getSheetFirstNameByExternSheet(r9);
        r16 = r11.getSheetLastNameByExternSheet(r9);
        r5 = new StringBuilder((r1.length() + r10.length()) + 4);
        if (r1.length() >= 1) goto L24;
        r16 = "#REF";
        goto L19
    L24:
        SheetNameFormatter.appendFormat(r5, r1);
        if (r1.equals(r16) == true) goto L27;
        r5.append(':');
        goto L19
    }
}
