package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.util.NumberComparer;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class DStarRunner implements Function3Arg {
    private final DStarAlgorithmEnum algoType;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.functions.DStarRunner$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator = null;

        static {
            int[] r0 = new int[operator.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator = r0;
            r0[operator.largerThan.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.largerEqualThan.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.smallerThan.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.smallerEqualThan.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[operator.equal.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum DStarAlgorithmEnum extends Enum<DStarAlgorithmEnum> {
        private static final /* synthetic */ DStarAlgorithmEnum[] $VALUES = null;
        public static final DStarAlgorithmEnum DAVERAGE = null;
        public static final DStarAlgorithmEnum DCOUNT = null;
        public static final DStarAlgorithmEnum DCOUNTA = null;
        public static final DStarAlgorithmEnum DGET = null;
        public static final DStarAlgorithmEnum DMAX = null;
        public static final DStarAlgorithmEnum DMIN = null;
        public static final DStarAlgorithmEnum DPRODUCT = null;
        public static final DStarAlgorithmEnum DSTDEV = null;
        public static final DStarAlgorithmEnum DSTDEVP = null;
        public static final DStarAlgorithmEnum DSUM = null;
        public static final DStarAlgorithmEnum DVAR = null;
        public static final DStarAlgorithmEnum DVARP = null;
        private final Supplier<IDStarAlgorithm> implSupplier;

        static {
            DStarAlgorithmEnum r0 = new DStarAlgorithmEnum("DGET", 0, $$Lambda$wyDMVvAkZN0nfftA_aIOKo2No.INSTANCE);
            DGET = r0;
            DStarAlgorithmEnum r1 = new DStarAlgorithmEnum("DMIN", 1, $$Lambda$fT0ODNika0DyC6hu6O_oyuVgZNQ.INSTANCE);
            DMIN = r1;
            DStarAlgorithmEnum r2 = new DStarAlgorithmEnum("DMAX", 2, $$Lambda$JalEGcpikBNJY2iEXzYFRCmBvMk.INSTANCE);
            DMAX = r2;
            DStarAlgorithmEnum r4 = new DStarAlgorithmEnum("DSUM", 3, $$Lambda$tXFXeGZ648Hqm1Hd7ShqrR95MY.INSTANCE);
            DSUM = r4;
            DStarAlgorithmEnum r6 = new DStarAlgorithmEnum("DCOUNT", 4, $$Lambda$9OmULXPL8U1FlFboS_UGskGtrNI.INSTANCE);
            DCOUNT = r6;
            DStarAlgorithmEnum r8 = new DStarAlgorithmEnum("DCOUNTA", 5, $$Lambda$afqIoPqvLoMcE5RFF_yCy6Y5Io.INSTANCE);
            DCOUNTA = r8;
            DStarAlgorithmEnum r10 = new DStarAlgorithmEnum("DAVERAGE", 6, $$Lambda$csoWsbJf9G1TgIKL4kk0MM62i4.INSTANCE);
            DAVERAGE = r10;
            DStarAlgorithmEnum r12 = new DStarAlgorithmEnum("DSTDEV", 7, $$Lambda$XpdzZgxYVadfpGtxbzkxlDdwttM.INSTANCE);
            DSTDEV = r12;
            DStarAlgorithmEnum r14 = new DStarAlgorithmEnum("DSTDEVP", 8, $$Lambda$j7EMOn8B2D_FG1_yW2v_OgQdkGc.INSTANCE);
            DSTDEVP = r14;
            DStarAlgorithmEnum r13 = new DStarAlgorithmEnum("DVAR", 9, $$Lambda$ySzspiZU2OdznoV0_uP6AsLXN0.INSTANCE);
            DVAR = r13;
            DStarAlgorithmEnum r11 = new DStarAlgorithmEnum("DVARP", 10, $$Lambda$krU4wYTs5J7jPzb2QJd7mHUQQo.INSTANCE);
            DVARP = r11;
            DStarAlgorithmEnum r9 = new DStarAlgorithmEnum("DPRODUCT", 11, $$Lambda$fFzYplYJTVH8qlMJzNbKPIvb3IA.INSTANCE);
            DPRODUCT = r9;
            $VALUES = new DStarAlgorithmEnum[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9};
        }

        private DStarAlgorithmEnum(String r3, int r4, Supplier r5) {
            Supplier<IDStarAlgorithm> r6 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r5, Supplier.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.implSupplier = r6;
        }

        public static DStarAlgorithmEnum valueOf(String r2) {
            return (DStarAlgorithmEnum) ZeusTransformUtils.preCheckCast(Enum.valueOf(DStarAlgorithmEnum.class, r2), DStarAlgorithmEnum.class, "com.obric.memorydata.plugin");
        }

        public static DStarAlgorithmEnum[] values() {
            return (DStarAlgorithmEnum[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DStarAlgorithmEnum[].class, "com.obric.memorydata.plugin");
        }

        public IDStarAlgorithm newInstance() {
            return (IDStarAlgorithm) ZeusTransformUtils.preCheckCast(this.implSupplier.get(), IDStarAlgorithm.class, "com.obric.memorydata.plugin");
        }
    }

    private static final enum operator extends Enum<operator> {
        private static final /* synthetic */ operator[] $VALUES = null;
        public static final operator equal = null;
        public static final operator largerEqualThan = null;
        public static final operator largerThan = null;
        public static final operator smallerEqualThan = null;
        public static final operator smallerThan = null;

        static {
            operator r0 = new operator("largerThan", 0);
            largerThan = r0;
            operator r1 = new operator("largerEqualThan", 1);
            largerEqualThan = r1;
            operator r3 = new operator("smallerThan", 2);
            smallerThan = r3;
            operator r5 = new operator("smallerEqualThan", 3);
            smallerEqualThan = r5;
            operator r7 = new operator("equal", 4);
            equal = r7;
            $VALUES = new operator[]{r0, r1, r3, r5, r7};
        }

        private operator(String r1, int r2) {
            super(r1, r2);
        }

        public static operator valueOf(String r2) {
            return (operator) ZeusTransformUtils.preCheckCast(Enum.valueOf(operator.class, r2), operator.class, "com.obric.memorydata.plugin");
        }

        public static operator[] values() {
            return (operator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), operator[].class, "com.obric.memorydata.plugin");
        }
    }

    public DStarRunner(DStarAlgorithmEnum r1) {
        this.algoType = r1;
    }

    private static boolean fulfillsConditions(AreaEval r10, int r11, AreaEval r12) {
        AreaEval r13 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r10, AreaEval.class, "com.obric.memorydata.plugin");
        AreaEval r14 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r12, AreaEval.class, "com.obric.memorydata.plugin");
        int r0 = r14.getHeight();
        int r2 = 1;
    L3:
        boolean r3 = false;
        if (r2 >= r0) goto L33;
        int r4 = r14.getWidth();
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L29;
        ValueEval r6 = resolveReference(r14, r2, r5);
        if (ZeusTransformUtils.instanceOf(r6, BlankEval.class) == true) goto L20;
        ValueEval r7 = resolveReference(r14, 0, r5);
        if (ZeusTransformUtils.instanceOf(r7, StringValueEval.class) == false) goto L28;
        if (getColumnForName(r7, r13) != (-1)) goto L15;
        boolean r8 = false;
    L16:
        if (r8 == false) goto L22;
        if (testNormalCondition(resolveReference(r13, r11, getColumnForName(r7, r13)), r6) == true) goto L20;
    L30:
        if (r3 == true) goto L31;
        r2 = r2 + 1;
        goto L3
    L31:
        return true;
    L22:
        if (OperandResolver.coerceValueToString(r6).isEmpty() == false) goto L26;
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L26:
        throw new NotImplementedException("D* function with formula conditions");
    L15:
        r8 = true;
        goto L16
    L28:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    L20:
        r5 = r5 + 1;
        goto L6
    L29:
        r3 = true;
        goto L30
    L33:
        return false;
    }

    private static int getColumnForName(ValueEval r2, AreaEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        AreaEval r5 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r3, AreaEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, NumericValueEval.class) == false) goto L13;
        int r6 = OperandResolver.coerceValueToInt(r4) - 1;
        if (r6 >= 0) goto L7;
        return -1;
    L7:
        if (r6 >= r5.getWidth()) goto L14;
        return r6;
    L14:
        return -1;
    L13:
        return getColumnForString(r5, OperandResolver.coerceValueToString(r4));
    }

    private static int getColumnForString(AreaEval r5, String r6) {
        AreaEval r7 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r5, AreaEval.class, "com.obric.memorydata.plugin");
        int r0 = r7.getWidth();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        ValueEval r3 = resolveReference(r7, 0, r2);
        if (ZeusTransformUtils.instanceOf(r3, BlankEval.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, ErrorEval.class) == true) goto L13;
        if (r6.equalsIgnoreCase(OperandResolver.coerceValueToString(r3)) == false) goto L13;
        return r2;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return -1;
    }

    private static Double getNumberFromValueEval(ValueEval r3) {
        ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, NumericValueEval.class) == false) goto L7;
        return Double.valueOf(((NumericValueEval) ZeusTransformUtils.preCheckCast(r4, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue());
    L7:
        if (ZeusTransformUtils.instanceOf(r4, StringValueEval.class) == true) goto L13;
    L11:
        return null;
    L13:
        return Double.valueOf(Double.parseDouble(((StringValueEval) ZeusTransformUtils.preCheckCast(r4, StringValueEval.class, "com.obric.memorydata.plugin")).getStringValue()));
    }

    private static ValueEval resolveReference(AreaEval r2, int r3, int r4) {
        AreaEval r5 = (AreaEval) ZeusTransformUtils.wrapperContextForParams(r2, AreaEval.class, "com.obric.memorydata.plugin");
        return OperandResolver.getSingleValue(r5.getValue(r3, r4), r5.getFirstRow() + r3, r5.getFirstColumn() + r4);
    L5:
        e = move-exception;
        return e.getErrorEval();
    }

    private static boolean testNormalCondition(ValueEval r4, ValueEval r5) {
        ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r4, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r7, StringEval.class) == false) goto L54;
        String r8 = ((StringEval) ZeusTransformUtils.preCheckCast(r7, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
        if (r8.startsWith("<") == false) goto L13;
        String r9 = r8.substring(1);
        if (r9.startsWith("=") == false) goto L11;
        return testNumericCondition(r6, operator.smallerEqualThan, r9.substring(1));
    L11:
        return testNumericCondition(r6, operator.smallerThan, r9);
    L13:
        if (r8.startsWith(">") == false) goto L20;
        String r10 = r8.substring(1);
        if (r10.startsWith("=") == false) goto L19;
        return testNumericCondition(r6, operator.largerEqualThan, r10.substring(1));
    L19:
        return testNumericCondition(r6, operator.largerThan, r10);
    L20:
        String r1 = "";
        if (r8.startsWith("=") == false) goto L40;
        String r11 = r8.substring(1);
        if (r11.isEmpty() == true) goto L25;
        Integer.parseInt(r11);     // Catch: NumberFormatException -> L28
    L27:
        r2 = true;
    L28:
        Double.parseDouble(r11);     // Catch: NumberFormatException -> L69
    L30:
        if (r2 == false) goto L34;
        return testNumericCondition(r6, operator.equal, r11);
    L34:
        if (ZeusTransformUtils.instanceOf(r6, BlankEval.class) == true) goto L38;
        r1 = OperandResolver.coerceValueToString(r6);
    L38:
        return r11.equalsIgnoreCase(r1);
    L25:
        return ZeusTransformUtils.instanceOf(r6, BlankEval.class);
    L40:
        if (r8.isEmpty() == false) goto L44;
        return ZeusTransformUtils.instanceOf(r6, StringEval.class);
    L44:
        if (ZeusTransformUtils.instanceOf(r6, BlankEval.class) == true) goto L47;
        r1 = OperandResolver.coerceValueToString(r6);
    L47:
        String r12 = r1.toLowerCase(LocaleUtil.getUserLocale());
        String r13 = r8.toLowerCase(LocaleUtil.getUserLocale());
        Pattern r0 = Countif.StringMatcher.getWildCardPattern(r13);
        if (r0 != null) goto L52;
        return r12.startsWith(r13);
    L52:
        return r0.matcher(r12).matches();
    L54:
        if (ZeusTransformUtils.instanceOf(r7, NumericValueEval.class) == false) goto L62;
        double r3 = ((NumericValueEval) ZeusTransformUtils.preCheckCast(r7, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        Double r14 = getNumberFromValueEval(r6);
        if (r14 != null) goto L58;
        return false;
    L58:
        if (r3 == r14.doubleValue()) goto L60;
        return false;
    L60:
        return true;
    L62:
        if (ZeusTransformUtils.instanceOf(r7, ErrorEval.class) == true) goto L64;
        return false;
    L64:
        if (ZeusTransformUtils.instanceOf(r6, ErrorEval.class) == true) goto L66;
        return false;
    L66:
        if (((ErrorEval) ZeusTransformUtils.preCheckCast(r7, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode() == ((ErrorEval) ZeusTransformUtils.preCheckCast(r6, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode()) goto L68;
        return false;
    L68:
        return true;
    }

    private static boolean testNumericCondition(ValueEval r5, operator r6, String r7) {
        ValueEval r8 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, NumericValueEval.class) == true) goto L5;
        return false;
    L5:
        double r0 = ((NumericValueEval) ZeusTransformUtils.preCheckCast(r8, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue();
        double r3 = Integer.parseInt(r7);     // Catch: NumberFormatException -> L8
    L9:
        int r9 = NumberComparer.compare(r0, r3);
        int r10 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$DStarRunner$operator[r6.ordinal()];
        if (r10 != 1) goto L12;
        if (r9 > 0) goto L34;
        return false;
    L34:
        return true;
    L12:
        if (r10 != 2) goto L14;
        if (r9 >= 0) goto L31;
        return false;
    L31:
        return true;
    L14:
        if (r10 != 3) goto L16;
        if (r9 < 0) goto L28;
        return false;
    L28:
        return true;
    L16:
        if (r10 != 4) goto L18;
        if (r9 <= 0) goto L25;
        return false;
    L25:
        return true;
    L18:
        if (r10 == 5) goto L20;
        return false;
    L20:
        if (r9 == 0) goto L22;
        return false;
    L22:
        return true;
    L8:
        r3 = Double.parseDouble(r7);     // Catch: NumberFormatException -> L35
    L36:
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int r4, int r5, ValueEval r6, ValueEval r7, ValueEval r8) {
        ValueEval r9 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r10 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r7, ValueEval.class, "com.obric.memorydata.plugin");
        ValueEval r11 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r8, ValueEval.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, AreaEval.class) == false) goto L50;
        if (ZeusTransformUtils.instanceOf(r11, AreaEval.class) == false) goto L50;
        AreaEval r12 = (AreaEval) ZeusTransformUtils.preCheckCast(r9, AreaEval.class, "com.obric.memorydata.plugin");
        AreaEval r13 = (AreaEval) ZeusTransformUtils.preCheckCast(r11, AreaEval.class, "com.obric.memorydata.plugin");
        IDStarAlgorithm r3 = this.algoType.newInstance();
        int r0 = -1;
        int r2 = 1;
        ValueEval r14 = OperandResolver.getSingleValue(r10, r4, r5);     // Catch: Exception -> L51 EvaluationException -> L25
        if (ZeusTransformUtils.instanceOf(r14, NumericValueEval.class) == false) goto L11;
        int r15 = ((int) Math.round(((NumericValueEval) ZeusTransformUtils.preCheckCast(r14, NumericValueEval.class, "com.obric.memorydata.plugin")).getNumberValue())) - 1;     // Catch: Exception -> L51 EvaluationException -> L25
    L12:
        if (r15 == (-1)) goto L55;
    L30:
        int r16 = r12.getHeight();
    L31:
        if (r2 >= r16) goto L48;
        if (fulfillsConditions(r12, r2, r13) == false) goto L44;
        ValueEval r17 = resolveReference(r12, r2, r15);
        if (r15 >= 0) goto L42;
        if (r3.allowEmptyMatchField() == false) goto L42;
        if (ZeusTransformUtils.instanceOf(r17, NumericValueEval.class) == true) goto L42;
        r17 = NumberEval.ZERO;
    L42:
        if (r3.processMatch(r17) == false) goto L48;
    L44:
        r2 = r2 + 1;
    L46:
        return ErrorEval.VALUE_INVALID;
    L48:
        return r3.getResult();
    L55:
    L18:
        e = move-exception;
        r0 = r15;
        e = e;
    L27:
        if (r3.allowEmptyMatchField() == false) goto L29;
    L24:
        r15 = r0;
        goto L30
    L29:
        return e.getErrorEval();
    L17:
        r0 = r15;
        goto L21
    L14:
        if (r3.allowEmptyMatchField() == true) goto L30;
        return ErrorEval.VALUE_INVALID;
    L11:
        r15 = getColumnForName(r14, r12);     // Catch: Exception -> L51 EvaluationException -> L25
    L25:
        e = e;
    L21:
        if (r3.allowEmptyMatchField() == true) goto L24;
        return ErrorEval.VALUE_INVALID;
    L50:
        return ErrorEval.VALUE_INVALID;
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] r8, int r9, int r10) {
        if (r8.length != 3) goto L7;
        return evaluate(r9, r10, r8[0], r8[1], r8[2]);
    L7:
        return ErrorEval.VALUE_INVALID;
    }
}
