package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.ControlPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;

/* JADX INFO: loaded from: classes7.dex */
final class OperandClassTransformer {
    private final FormulaType _formulaType;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.OperandClassTransformer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$FormulaType = null;

        static {
            int[] r0 = new int[FormulaType.values().length];
            $SwitchMap$org$apache$poi$ss$formula$FormulaType = r0;
            r0[FormulaType.CELL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.NAMEDRANGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.DATAVALIDATION_LIST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public OperandClassTransformer(FormulaType r1) {
        this._formulaType = r1;
    }

    private static boolean isSimpleValueFunction(Ptg r5) {
        if (ZeusTransformUtils.instanceOf(r5, AbstractFunctionPtg.class) == false) goto L14;
        AbstractFunctionPtg r6 = (AbstractFunctionPtg) ZeusTransformUtils.preCheckCast(r5, AbstractFunctionPtg.class, "com.obric.memorydata.plugin");
        if (r6.getDefaultOperandClass() == 32) goto L7;
        return false;
    L7:
        int r0 = r6.getNumberOfOperands() - 1;
    L8:
        if (r0 < 0) goto L13;
        if (r6.getParameterClass(r0) != 32) goto L11;
        r0 = r0 - 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    L14:
        return false;
    }

    private static boolean isSingleArgSum(Ptg r2) {
        if (ZeusTransformUtils.instanceOf(r2, AttrPtg.class) == true) goto L5;
        return false;
    L5:
        return ((AttrPtg) ZeusTransformUtils.preCheckCast(r2, AttrPtg.class, "com.obric.memorydata.plugin")).isSum();
    }

    private void setSimpleValueFuncClass(AbstractFunctionPtg r1, byte r2, boolean r3) {
        byte r0 = 64;
        if (r3 == true) goto L7;
        if (r2 == 64) goto L7;
        r0 = 32;
    L7:
        r1.setClass(r0);
    }

    private byte transformClass(byte r1, byte r2, boolean r3) {
        if (r2 != 0) goto L4;
        if (r3 == true) goto L14;
        return r1;
    L14:
        return 0;
    L4:
        if (r2 == 32) goto L9;
        if (r2 != 64) goto L8;
    L11:
        return 64;
    L8:
        throw new IllegalStateException("Unexpected operand class (" + r2 + ")");
    L9:
        if (r3 == true) goto L11;
        return 32;
    }

    private void transformFunctionNode(AbstractFunctionPtg r8, ParseNode[] r9, byte r10, boolean r11) {
        byte r0 = r8.getDefaultOperandClass();
        boolean r1 = true;
        int r6 = 0;
        if (r11 == false) goto L13;
        if (r0 == 0) goto L11;
        if (r0 == 32) goto L10;
        if (r0 != 64) goto L9;
    L7:
        r8.setClass((byte) 64);
    L26:
        r1 = false;
    L36:
        if (r6 >= r9.length) goto L38;
        transformNode(r9[r6], r8.getParameterClass(r6), r1);
        r6 = r6 + 1;
        goto L36
    L38:
        return;
    L9:
        throw new IllegalStateException("Unexpected operand class (" + r0 + ")");
    L10:
        r8.setClass((byte) 64);
        goto L36
    L11:
        if (r10 != 0) goto L7;
        r8.setClass((byte) 0);
        goto L26
    L13:
        if (r0 != r10) goto L15;
        r8.setClass(r0);
        goto L26
    L15:
        if (r10 == 0) goto L30;
        if (r10 == 32) goto L29;
        if (r10 != 64) goto L28;
        if (r0 == 0) goto L23;
        if (r0 != 32) goto L22;
        r8.setClass((byte) 64);
    L24:
        if (r0 != 32) goto L26;
    L22:
        throw new IllegalStateException("Unexpected operand class (" + r0 + ")");
    L23:
        r8.setClass((byte) 0);
        goto L24
    L28:
        throw new IllegalStateException("Unexpected operand class (" + r10 + ")");
    L29:
        r8.setClass((byte) 32);
        goto L26
    L30:
        if (r0 == 32) goto L29;
        if (r0 == 64) goto L7;
        throw new IllegalStateException("Unexpected operand class (" + r0 + ")");
    }

    private void transformNode(ParseNode r7, byte r8, boolean r9) {
        Ptg r0 = r7.getToken();
        ParseNode[] r10 = r7.getChildren();
        int r3 = 0;
        if (isSimpleValueFunction(r0) == false) goto L14;
        if (r8 != 64) goto L7;
        boolean r1 = true;
    L8:
        int r4 = r10.length;
    L9:
        if (r3 >= r4) goto L11;
        transformNode(r10[r3], r8, r1);
        r3 = r3 + 1;
        goto L9
    L11:
        setSimpleValueFuncClass((AbstractFunctionPtg) ZeusTransformUtils.preCheckCast(r0, AbstractFunctionPtg.class, "com.obric.memorydata.plugin"), r8, r9);
        return;
    L7:
        r1 = false;
        goto L8
    L14:
        if (isSingleArgSum(r0) == false) goto L17;
        r0 = FuncVarPtg.SUM;
    L17:
        if (ZeusTransformUtils.instanceOf(r0, ValueOperatorPtg.class) == false) goto L19;
    L45:
        if (r8 != 0) goto L47;
        r8 = 32;
    L47:
        int r2 = r10.length;
    L48:
        if (r3 >= r2) goto L50;
        transformNode(r10[r3], r8, r9);
        r3 = r3 + 1;
        goto L48
    L50:
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r0, ControlPtg.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r0, MemFuncPtg.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r0, MemAreaPtg.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r0, UnionPtg.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r0, IntersectionPtg.class) == true) goto L45;
        if (ZeusTransformUtils.instanceOf(r0, AbstractFunctionPtg.class) == false) goto L34;
        transformFunctionNode((AbstractFunctionPtg) ZeusTransformUtils.preCheckCast(r0, AbstractFunctionPtg.class, "com.obric.memorydata.plugin"), r10, r8, r9);
        return;
    L34:
        if (r10.length <= 0) goto L41;
        if (r0 != RangePtg.instance) goto L39;
        return;
    L39:
        throw new IllegalStateException("Node should not have any children");
    L41:
        if (r0.isBaseToken() == false) goto L43;
        return;
    L43:
        r0.setClass(transformClass(r0.getPtgClass(), r8, r9));
    }

    public void transformFormula(ParseNode r4) {
        int r0 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$FormulaType[this._formulaType.ordinal()];
        if (r0 != 1) goto L5;
        byte r1 = 32;
    L16:
        transformNode(r4, r1, false);
        return;
    L5:
        if (r0 != 2) goto L7;
        r1 = 64;
        goto L16
    L7:
        if (r0 != 3) goto L9;
    L13:
        r1 = 0;
        goto L16
    L9:
        if (r0 == 4) goto L13;
        throw new RuntimeException("Incomplete code - formula type (" + this._formulaType + ") not supported yet");
    }
}
