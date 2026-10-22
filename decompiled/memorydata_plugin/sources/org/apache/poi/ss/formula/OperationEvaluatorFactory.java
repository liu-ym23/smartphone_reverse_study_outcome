package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.eval.ConcatEval;
import org.apache.poi.ss.formula.eval.FunctionEval;
import org.apache.poi.ss.formula.eval.IntersectionEval;
import org.apache.poi.ss.formula.eval.PercentEval;
import org.apache.poi.ss.formula.eval.RangeEval;
import org.apache.poi.ss.formula.eval.RelationalOperationEval;
import org.apache.poi.ss.formula.eval.TwoOperandNumericOperation;
import org.apache.poi.ss.formula.eval.UnaryMinusEval;
import org.apache.poi.ss.formula.eval.UnaryPlusEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.formula.functions.Indirect;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AddPtg;
import org.apache.poi.ss.formula.ptg.ConcatPtg;
import org.apache.poi.ss.formula.ptg.DividePtg;
import org.apache.poi.ss.formula.ptg.EqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.LessEqualPtg;
import org.apache.poi.ss.formula.ptg.LessThanPtg;
import org.apache.poi.ss.formula.ptg.MultiplyPtg;
import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.PowerPtg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.SubtractPtg;
import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: loaded from: classes7.dex */
final class OperationEvaluatorFactory {
    private static final Map<Byte, Function> _instancesByPtgClass = null;

    static {
        _instancesByPtgClass = initialiseInstancesMap();
    }

    public static ValueEval evaluate(OperationPtg r5, ValueEval[] r6, OperationEvaluationContext r7) {
        if (r5 == null) goto L28;
        Function r0 = (Function) ZeusTransformUtils.preCheckCast(_instancesByPtgClass.get(Byte.valueOf(r5.getSid())), Function.class, "com.obric.memorydata.plugin");
        FreeRefFunction r1 = null;
        if (r0 == null) goto L6;
    L14:
        if (r0 != null) goto L16;
        if (r1 == null) goto L26;
        return r1.evaluate(r6, r7);
    L26:
        throw new RuntimeException("Unexpected operation ptg class (" + r5.getClass().getName() + ")");
    L16:
        if (ZeusTransformUtils.instanceOf(r0, ArrayFunction.class) == false) goto L21;
        ValueEval r8 = evaluateArrayFunction((ArrayFunction) ZeusTransformUtils.preCheckCast(r0, ArrayFunction.class, "com.obric.memorydata.plugin"), r6, r7);
        if (r8 == null) goto L21;
        return r8;
    L21:
        return r0.evaluate(r6, r7.getRowIndex(), r7.getColumnIndex());
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AbstractFunctionPtg.class) == false) goto L14;
        short r3 = ((AbstractFunctionPtg) ZeusTransformUtils.preCheckCast(r5, AbstractFunctionPtg.class, "com.obric.memorydata.plugin")).getFunctionIndex();
        if (r3 != 148) goto L10;
        r1 = Indirect.instance;
        goto L14
    L10:
        if (r3 == 255) goto L12;
        r0 = FunctionEval.getBasicFunction(r3);
        goto L14
    L12:
        r1 = UserDefinedFunction.instance;
        goto L14
    L28:
        throw new IllegalArgumentException("ptg must not be null");
    }

    static ValueEval evaluateArrayFunction(ArrayFunction r3, ValueEval[] r4, OperationEvaluationContext r5) {
        ArrayFunction r6 = (ArrayFunction) ZeusTransformUtils.wrapperContextForParams(r3, ArrayFunction.class, "com.obric.memorydata.plugin");
        EvaluationCell r0 = r5.getWorkbook().getSheet(r5.getSheetIndex()).getCell(r5.getRowIndex(), r5.getColumnIndex());
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isPartOfArrayFormulaGroup() == false) goto L10;
        CellRangeAddress r7 = r0.getArrayFormulaRange();
        int r1 = r7.getFirstRow();
        int r8 = r7.getFirstColumn();
    L8:
        return r6.evaluateArray(r4, r1, r8);
    L10:
        if (r5.isArraymode() == false) goto L14;
        r1 = r5.getRowIndex();
        r8 = r5.getColumnIndex();
        goto L8
    L14:
        return null;
    }

    private static Map<Byte, Function> initialiseInstancesMap() {
        HashMap r0 = new HashMap(32);
        r0.put(Byte.valueOf(AddPtg.instance.getSid()), TwoOperandNumericOperation.AddEval);
        r0.put(Byte.valueOf(SubtractPtg.instance.getSid()), TwoOperandNumericOperation.SubtractEval);
        r0.put(Byte.valueOf(MultiplyPtg.instance.getSid()), TwoOperandNumericOperation.MultiplyEval);
        r0.put(Byte.valueOf(DividePtg.instance.getSid()), TwoOperandNumericOperation.DivideEval);
        r0.put(Byte.valueOf(PowerPtg.instance.getSid()), TwoOperandNumericOperation.PowerEval);
        r0.put(Byte.valueOf(ConcatPtg.instance.getSid()), ConcatEval.instance);
        r0.put(Byte.valueOf(LessThanPtg.instance.getSid()), RelationalOperationEval.LessThanEval);
        r0.put(Byte.valueOf(LessEqualPtg.instance.getSid()), RelationalOperationEval.LessEqualEval);
        r0.put(Byte.valueOf(EqualPtg.instance.getSid()), RelationalOperationEval.EqualEval);
        r0.put(Byte.valueOf(GreaterEqualPtg.instance.getSid()), RelationalOperationEval.GreaterEqualEval);
        r0.put(Byte.valueOf(GreaterThanPtg.instance.getSid()), RelationalOperationEval.GreaterThanEval);
        r0.put(Byte.valueOf(NotEqualPtg.instance.getSid()), RelationalOperationEval.NotEqualEval);
        r0.put(Byte.valueOf(IntersectionPtg.instance.getSid()), IntersectionEval.instance);
        r0.put(Byte.valueOf(RangePtg.instance.getSid()), RangeEval.instance);
        r0.put(Byte.valueOf(UnaryPlusPtg.instance.getSid()), UnaryPlusEval.instance);
        r0.put(Byte.valueOf(UnaryMinusPtg.instance.getSid()), UnaryMinusEval.instance);
        r0.put(Byte.valueOf(PercentPtg.instance.getSid()), PercentEval.instance);
        return r0;
    }
}
