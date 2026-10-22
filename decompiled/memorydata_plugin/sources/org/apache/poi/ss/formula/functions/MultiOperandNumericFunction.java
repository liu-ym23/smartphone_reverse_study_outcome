package org.apache.poi.ss.formula.functions;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: loaded from: classes7.dex */
public abstract class MultiOperandNumericFunction implements Function {
    private static final int DEFAULT_MAX_NUM_OPERANDS = 0;
    private EvalConsumer<BlankEval, DoubleList> blankConsumer;
    private EvalConsumer<BoolEval, DoubleList> boolByRefConsumer;
    private EvalConsumer<BoolEval, DoubleList> boolByValueConsumer;
    private EvalConsumer<MissingArgEval, DoubleList> missingArgConsumer;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.functions.MultiOperandNumericFunction$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy = null;

        static {
            int[] r0 = new int[Policy.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy = r0;
            r0[Policy.COERCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy[Policy.SKIP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy[Policy.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class ConsumerFactory {
        private static <T> EvalConsumer<T, DoubleList> createAny(EvalConsumer<T, DoubleList> r2, Policy r3) {
            EvalConsumer<T, DoubleList> r4 = (EvalConsumer) ZeusTransformUtils.wrapperContextForParams(r2, EvalConsumer.class, "com.obric.memorydata.plugin");
            int r5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy[r3.ordinal()];
            if (r5 != 1) goto L5;
            return r4;
        L5:
            if (r5 == 2) goto L13;
            if (r5 != 3) goto L11;
            return throwValueInvalid();
        L11:
            throw new AssertionError();
        L13:
            return doNothing();
        }

        static EvalConsumer<BlankEval, DoubleList> createForBlank(Policy r1) {
            return createAny($$Lambda$MultiOperandNumericFunction$ConsumerFactory$a8XXDEnSdzO_l7_NIbqOA0ytSBQ.INSTANCE, r1);
        }

        static EvalConsumer<BoolEval, DoubleList> createForBoolEval(Policy r1) {
            return createAny($$Lambda$MultiOperandNumericFunction$ConsumerFactory$gibXP_GOKNexjCalsjoq9F54BKo.INSTANCE, r1);
        }

        static EvalConsumer<MissingArgEval, DoubleList> createForMissingArg(Policy r1) {
            return createAny($$Lambda$MultiOperandNumericFunction$ConsumerFactory$HtaRJxm9p5nRr7dt5xymisfn400.INSTANCE, r1);
        }

        private static <T> EvalConsumer<T, DoubleList> doNothing() {
            return $$Lambda$MultiOperandNumericFunction$ConsumerFactory$Df68qEbkRuibCkzAdbpbGmpE3A.INSTANCE;
        }

        static /* synthetic */ void lambda$createForBlank$2(BlankEval r2, DoubleList r3) {
            r3.add(0.0d);
        }

        static /* synthetic */ void lambda$createForBoolEval$1(BoolEval r2, DoubleList r3) {
            r3.add(r2.getNumberValue());
        }

        static /* synthetic */ void lambda$createForMissingArg$0(MissingArgEval r2, DoubleList r3) {
            r3.add(0.0d);
        }

        static /* synthetic */ void lambda$doNothing$3(Object r0, DoubleList r1) {
        }

        static /* synthetic */ void lambda$throwValueInvalid$4(Object r0, DoubleList r1) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }

        private static <T> EvalConsumer<T, DoubleList> throwValueInvalid() {
            return $$Lambda$MultiOperandNumericFunction$ConsumerFactory$8Nlt9JzKpWnh5kAodWnyuEzJuN4.INSTANCE;
        }
    }

    private interface EvalConsumer<T, R> {
        void accept(T r1, R r2);
    }

    public static final enum Policy extends Enum<Policy> {
        private static final /* synthetic */ Policy[] $VALUES = null;
        public static final Policy COERCE = null;
        public static final Policy ERROR = null;
        public static final Policy SKIP = null;

        static {
            Policy r0 = new Policy("COERCE", 0);
            COERCE = r0;
            Policy r1 = new Policy("SKIP", 1);
            SKIP = r1;
            Policy r3 = new Policy(CipherConst.LEVEL_ERROR, 2);
            ERROR = r3;
            $VALUES = new Policy[]{r0, r1, r3};
        }

        private Policy(String r1, int r2) {
            super(r1, r2);
        }

        public static Policy valueOf(String r2) {
            return (Policy) ZeusTransformUtils.preCheckCast(Enum.valueOf(Policy.class, r2), Policy.class, "com.obric.memorydata.plugin");
        }

        public static Policy[] values() {
            return (Policy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Policy[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        DEFAULT_MAX_NUM_OPERANDS = SpreadsheetVersion.EXCEL2007.getMaxFunctionArgs();
    }

    public MultiOperandNumericFunction(boolean r2, boolean r3) {
        this.missingArgConsumer = ConsumerFactory.createForMissingArg(Policy.SKIP);
        if (r2 == false) goto L5;
        Policy r4 = Policy.COERCE;
    L6:
        this.boolByRefConsumer = ConsumerFactory.createForBoolEval(r4);
        this.boolByValueConsumer = ConsumerFactory.createForBoolEval(Policy.COERCE);
        if (r3 == false) goto L9;
        Policy r5 = Policy.COERCE;
    L10:
        this.blankConsumer = ConsumerFactory.createForBlank(r5);
        return;
    L9:
        r5 = Policy.SKIP;
        goto L10
    L5:
        r4 = Policy.SKIP;
        goto L6
    }

    private void collectValue(ValueEval r3, boolean r4, DoubleList r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L45;
        if (ZeusTransformUtils.instanceOf(r6, BoolEval.class) == false) goto L13;
        BoolEval r7 = (BoolEval) ZeusTransformUtils.preCheckCast(r6, BoolEval.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L9;
        EvalConsumer<BoolEval, DoubleList> r2 = this.boolByRefConsumer;
    L10:
        r2.accept(r7, r5);
        return;
    L9:
        r2 = this.boolByValueConsumer;
        goto L10
    L13:
        if (ZeusTransformUtils.instanceOf(r6, NumericValueEval.class) == false) goto L17;
        r5.add(((NumericValueEval) ZeusTransformUtils.preCheckCast(r6, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue());
        return;
    L17:
        if (ZeusTransformUtils.instanceOf(r6, StringValueEval.class) == false) goto L31;
        if (r4 == false) goto L21;
        return;
    L21:
        if (treatStringsAsZero() == false) goto L24;
        double r8 = 0.0d;
    L23:
        r5.add(r8);
        return;
    L24:
        Double r9 = OperandResolver.parseDouble(((StringValueEval) ZeusTransformUtils.preCheckCast(r6, StringValueEval.class, "com.obric.memorydata.plugin")).getStringValue().trim());
        if (r9 == null) goto L29;
        r8 = r9.doubleValue();
        goto L23
    L29:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L31:
        if (ZeusTransformUtils.instanceOf(r6, ErrorEval.class) == true) goto L43;
        if (r6 != BlankEval.instance) goto L37;
        this.blankConsumer.accept((BlankEval) ZeusTransformUtils.preCheckCast(r6, BlankEval.class, "com.obric.memorydata.plugin"), r5);
        return;
    L37:
        if (r6 != MissingArgEval.instance) goto L41;
        this.missingArgConsumer.accept((MissingArgEval) ZeusTransformUtils.preCheckCast(r6, MissingArgEval.class, "com.obric.memorydata.plugin"), r5);
        return;
    L41:
        throw new RuntimeException("Invalid ValueEval type passed for conversion: (" + r6.getClass() + ")");
    L43:
        throw new EvaluationException((ErrorEval) ZeusTransformUtils.preCheckCast(r6, ErrorEval.class, "com.obric.memorydata.plugin"));
    L45:
        throw new IllegalArgumentException("ve must not be null");
    }

    private void collectValues(ValueEval r9, DoubleList r10) {
        ValueEval r11 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r9, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, ThreeDEval.class) == false) goto L27;
        ThreeDEval r12 = (ThreeDEval) ZeusTransformUtils.preCheckCast(r11, ThreeDEval.class, "com.obric.memorydata.plugin");
        int r0 = r12.getFirstSheetIndex();
    L6:
        if (r0 > r12.getLastSheetIndex()) goto L25;
        int r1 = r12.getWidth();
        int r3 = r12.getHeight();
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L24;
        int r5 = 0;
    L10:
        if (r5 >= r1) goto L23;
        ValueEval r6 = r12.getValue(r0, r4, r5);
        if (isSubtotalCounted() == true) goto L17;
        if (r12.isSubTotal(r4, r5) == false) goto L17;
    L22:
        r5 = r5 + 1;
    L17:
        if (isHiddenRowCounted() == false) goto L19;
    L21:
        collectValue(r6, !treatStringsAsZero(), r10);
        goto L22
    L19:
        if (r12.isRowHidden(r4) == false) goto L21;
    L23:
        r4 = r4 + 1;
        goto L8
    L24:
        r0 = r0 + 1;
        goto L6
    L25:
        return;
    L27:
        if (ZeusTransformUtils.instanceOf(r11, TwoDEval.class) == false) goto L42;
        TwoDEval r13 = (TwoDEval) ZeusTransformUtils.preCheckCast(r11, TwoDEval.class, "com.obric.memorydata.plugin");
        int r2 = r13.getWidth();
        int r7 = r13.getHeight();
        int r8 = 0;
    L29:
        if (r8 >= r7) goto L40;
        int r14 = 0;
    L31:
        if (r14 >= r2) goto L39;
        ValueEval r15 = r13.getValue(r8, r14);
        if (isSubtotalCounted() == false) goto L35;
    L37:
        collectValue(r15, !treatStringsAsZero(), r10);
    L38:
        r14 = r14 + 1;
        goto L31
    L35:
        if (r13.isSubTotal(r8, r14) == false) goto L37;
    L39:
        r8 = r8 + 1;
        goto L29
    L40:
        return;
    L42:
        if (ZeusTransformUtils.instanceOf(r11, RefEval.class) == false) goto L48;
        RefEval r16 = (RefEval) ZeusTransformUtils.preCheckCast(r11, RefEval.class, "com.obric.memorydata.plugin");
        int r17 = r16.getFirstSheetIndex();
    L45:
        if (r17 > r16.getLastSheetIndex()) goto L47;
        collectValue(r16.getInnerValueEval(r17), !treatStringsAsZero(), r10);
        r17 = r17 + 1;
        goto L45
    L47:
        return;
    L48:
        collectValue(r11, false, r10);
    }

    public abstract double evaluate(double[] r1);

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r1, int r2, int r3) {
        double r0 = evaluate(getNumberArray(r1));     // Catch: EvaluationException -> L11
        if (Double.isNaN(r0) == true) goto L10;
        if (Double.isInfinite(r0) == true) goto L10;
        return new NumberEval(r0);
    L10:
        return ErrorEval.NUM_ERROR;
    L11:
        e = move-exception;
        return e.getErrorEval();
    }

    public int getMaxNumOperands() {
        return DEFAULT_MAX_NUM_OPERANDS;
    }

    public final double[] getNumberArray(ValueEval[] r5) {
        if (r5.length > getMaxNumOperands()) goto L10;
        DoubleList r0 = new DoubleList();
        int r1 = r5.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L8;
        collectValues(r5[r2], r0);
        r2 = r2 + 1;
        goto L5
    L8:
        return r0.toArray();
    L10:
        throw EvaluationException.invalidValue();
    }

    public boolean isHiddenRowCounted() {
        return true;
    }

    public boolean isSubtotalCounted() {
        return true;
    }

    public void setBlankEvalPolicy(Policy r1) {
        this.blankConsumer = ConsumerFactory.createForBlank(r1);
    }

    public void setMissingArgPolicy(Policy r1) {
        this.missingArgConsumer = ConsumerFactory.createForMissingArg(r1);
    }

    public boolean treatStringsAsZero() {
        return false;
    }
}
