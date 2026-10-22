package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Stack;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: classes7.dex */
public class FormulaRenderer {
    private static String[] getOperands(Stack<String> r5, int r6) {
        String[] r0 = new String[r6];
        int r1 = r6 - 1;
    L3:
        if (r1 < 0) goto L9;
        if (r5.isEmpty() == true) goto L8;
        r0[r1] = (String) ZeusTransformUtils.preCheckCast(r5.pop(), String.class, "com.obric.memorydata.plugin");
        r1 = r1 - 1;
        goto L3
    L8:
        throw new IllegalStateException("Too few arguments supplied to operation. Expected (" + r6 + ") operands but got (" + ((r6 - r1) - 1) + ")");
    L9:
        return r0;
    }

    public static String toFormulaString(FormulaRenderingWorkbook r7, Ptg[] r8) {
        FormulaRenderingWorkbook r9 = (FormulaRenderingWorkbook) ZeusTransformUtils.wrapperContextForParams(r7, FormulaRenderingWorkbook.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L57;
        if (r8.length == 0) goto L57;
        Stack r0 = new Stack();
        int r2 = r8.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L48;
        Ptg r4 = r8[r3];
        if (ZeusTransformUtils.instanceOf(r4, MemAreaPtg.class) == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r4, MemFuncPtg.class) == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r4, MemErrPtg.class) == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r4, ParenthesisPtg.class) == false) goto L20;
        String r5 = "(" + ((String) ZeusTransformUtils.preCheckCast(r0.pop(), String.class, "com.obric.memorydata.plugin")) + ")";
    L18:
        r0.push(r5);
        goto L46
    L20:
        if (ZeusTransformUtils.instanceOf(r4, AttrPtg.class) == false) goto L40;
        AttrPtg r6 = (AttrPtg) ZeusTransformUtils.preCheckCast(r4, AttrPtg.class, "com.obric.memorydata.plugin");
        if (r6.isOptimizedIf() == true) goto L46;
        if (r6.isOptimizedChoose() == true) goto L46;
        if (r6.isSkip() == true) goto L46;
        if (r6.isSpace() == true) goto L46;
        if (r6.isSemiVolatile() == true) goto L46;
        if (r6.isSum() == false) goto L38;
        r5 = r6.toFormulaString(getOperands(r0, r6.getNumberOfOperands()));
        goto L18
    L38:
        throw new RuntimeException("Unexpected tAttr: " + r6);
    L40:
        if (ZeusTransformUtils.instanceOf(r4, WorkbookDependentFormula.class) == false) goto L43;
        r5 = ((WorkbookDependentFormula) ZeusTransformUtils.preCheckCast(r4, WorkbookDependentFormula.class, "com.obric.memorydata.plugin")).toFormulaString(r9);
        goto L18
    L43:
        if (ZeusTransformUtils.instanceOf(r4, OperationPtg.class) == true) goto L45;
        r5 = r4.toFormulaString();
        goto L18
    L45:
        OperationPtg r10 = (OperationPtg) ZeusTransformUtils.preCheckCast(r4, OperationPtg.class, "com.obric.memorydata.plugin");
        r5 = r10.toFormulaString(getOperands(r0, r10.getNumberOfOperands()));
    L46:
        r3 = r3 + 1;
        goto L7
    L48:
        if (r0.isEmpty() == true) goto L55;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r0.pop(), String.class, "com.obric.memorydata.plugin");
        if (r0.isEmpty() == false) goto L53;
        return r11;
    L53:
        throw new IllegalStateException("too much stuff left on the stack");
    L55:
        throw new IllegalStateException("Stack underflow");
    L57:
        throw new IllegalArgumentException("ptgs must not be null");
    }
}
