package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.FormulaError;

/* JADX INFO: loaded from: classes7.dex */
public final class Countif extends Fixed2ArgFunction {

    private static final class BooleanMatcher extends MatcherBase {
        private final int _value;

        public BooleanMatcher(boolean r1, CmpOp r2) {
            super(r2);
            this._value = boolToInt(r1);
        }

        private static int boolToInt(boolean r0) {
            return r0 ? 1 : 0;
        }

        @Override // org.apache.poi.ss.formula.functions.Countif.MatcherBase
        public String getValueText() {
            if (this._value != 1) goto L5;
            return "TRUE";
        L5:
            return "FALSE";
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval r5) {
            ValueEval r6 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, StringEval.class) == false) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r6, BoolEval.class) == false) goto L10;
            return evaluate(boolToInt(((BoolEval) ZeusTransformUtils.preCheckCast(r6, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue()) - this._value);
        L10:
            if (ZeusTransformUtils.instanceOf(r6, BlankEval.class) == false) goto L16;
            if (getCode() == 2) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (ZeusTransformUtils.instanceOf(r6, NumberEval.class) == true) goto L18;
            return false;
        L18:
            if (getCode() == 2) goto L20;
            return false;
        L20:
            return true;
        }
    }

    private static final class CmpOp {
        public static final CmpOp OP_EQ = null;
        public static final CmpOp OP_GE = null;
        public static final CmpOp OP_GT = null;
        public static final CmpOp OP_LE = null;
        public static final CmpOp OP_LT = null;
        public static final CmpOp OP_NE = null;
        public static final CmpOp OP_NONE = null;
        private final int _code;
        private final String _representation;

        static {
            OP_NONE = op("", 0);
            OP_EQ = op("=", 1);
            OP_NE = op("<>", 2);
            OP_LE = op("<=", 3);
            OP_LT = op("<", 4);
            OP_GT = op(">", 5);
            OP_GE = op(">=", 6);
        }

        private CmpOp(String r1, int r2) {
            this._representation = r1;
            this._code = r2;
        }

        public static CmpOp getOperator(String r4) {
            int r0 = r4.length();
            if (r0 >= 1) goto L7;
            return OP_NONE;
        L7:
            switch(r4.charAt(0)) {
                case 60: goto L20;
                case 61: goto L19;
                case 62: goto L10;
                default: goto L9;
            };
        L10:
            if (r0 <= 1) goto L17;
            if (r4.charAt(1) != '=') goto L17;
            return OP_GE;
        L17:
            return OP_GT;
        L20:
            if (r0 <= 1) goto L31;
            char r5 = r4.charAt(1);
            if (r5 == '=') goto L29;
            if (r5 != '>') goto L31;
            return OP_NE;
        L29:
            return OP_LE;
        L31:
            return OP_LT;
        L9:
            return OP_NONE;
        L19:
            return OP_EQ;
        }

        private static CmpOp op(String r1, int r2) {
            return new CmpOp(r1, r2);
        }

        public boolean evaluate(int r4) {
            switch(this._code) {
                case 0: goto L26;
                case 1: goto L26;
                case 2: goto L22;
                case 3: goto L18;
                case 4: goto L14;
                case 5: goto L10;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            if (r4 < 0) goto L9;
            return true;
        L9:
            return false;
        L10:
            if (r4 <= 0) goto L13;
            return true;
        L13:
            return false;
        L14:
            if (r4 >= 0) goto L17;
            return true;
        L17:
            return false;
        L18:
            if (r4 > 0) goto L21;
            return true;
        L21:
            return false;
        L22:
            if (r4 == 0) goto L25;
            return true;
        L25:
            return false;
        L26:
            if (r4 != 0) goto L29;
            return true;
        L29:
            return false;
        L5:
            throw new RuntimeException("Cannot call boolean evaluate on non-equality operator '" + this._representation + "'");
        }

        public boolean evaluate(boolean r4) {
            int r0 = this._code;
            if (r0 != 0) goto L5;
        L12:
            return r4;
        L5:
            if (r0 == 1) goto L12;
            if (r0 != 2) goto L11;
            return !r4;
        L11:
            throw new RuntimeException("Cannot call boolean evaluate on non-equality operator '" + this._representation + "'");
        }

        public int getCode() {
            return this._code;
        }

        public int getLength() {
            return this._representation.length();
        }

        public String getRepresentation() {
            return this._representation;
        }

        public String toString() {
            return getClass().getName() + " [" + this._representation + "]";
        }
    }

    public static final class ErrorMatcher extends MatcherBase {
        private final int _value;

        public ErrorMatcher(int r1, CmpOp r2) {
            super(r2);
            this._value = r1;
        }

        public int getValue() {
            return this._value;
        }

        @Override // org.apache.poi.ss.formula.functions.Countif.MatcherBase
        public String getValueText() {
            return FormulaError.forInt(this._value).getString();
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval r3) {
            ValueEval r4 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r3, ValueEval.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, ErrorEval.class) == true) goto L5;
            return false;
        L5:
            return evaluate(((ErrorEval) ZeusTransformUtils.preCheckCast(r4, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode() - this._value);
        }
    }

    private static abstract class MatcherBase implements CountUtils.I_MatchPredicate {
        private final CmpOp _operator;

        MatcherBase(CmpOp r1) {
            this._operator = r1;
        }

        public final boolean evaluate(int r1) {
            return this._operator.evaluate(r1);
        }

        public final boolean evaluate(boolean r1) {
            return this._operator.evaluate(r1);
        }

        public final int getCode() {
            return this._operator.getCode();
        }

        public abstract String getValueText();

        public final String toString() {
            return getClass().getName() + " [" + this._operator.getRepresentation() + getValueText() + "]";
        }
    }

    private static final class NumberMatcher extends MatcherBase {
        private final double _value;

        public NumberMatcher(double r1, CmpOp r3) {
            super(r3);
            this._value = r1;
        }

        @Override // org.apache.poi.ss.formula.functions.Countif.MatcherBase
        public String getValueText() {
            return String.valueOf(this._value);
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval r6) {
            ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, StringEval.class) == false) goto L19;
            int r0 = getCode();
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L10;
            if (r0 == 2) goto L9;
            return false;
        L9:
            return true;
        L10:
            Double r8 = OperandResolver.parseDouble(((StringEval) ZeusTransformUtils.preCheckCast(r7, StringEval.class, "com.obric.memorydata.plugin")).getStringValue());
            if (r8 != null) goto L14;
            return false;
        L14:
            if (this._value != r8.doubleValue()) goto L17;
            return true;
        L17:
            return false;
        L19:
            if (ZeusTransformUtils.instanceOf(r7, NumberEval.class) == false) goto L23;
            return evaluate(Double.compare(((NumberEval) ZeusTransformUtils.preCheckCast(r7, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue(), this._value));
        L23:
            if (ZeusTransformUtils.instanceOf(r7, BlankEval.class) == true) goto L25;
            return false;
        L25:
            if (getCode() == 2) goto L27;
            return false;
        L27:
            return true;
        }
    }

    public static final class StringMatcher extends MatcherBase {
        private final Pattern _pattern;
        private final String _value;

        public StringMatcher(String r2, CmpOp r3) {
            super(r3);
            this._value = r2;
            int r4 = r3.getCode();
            if (r4 != 0) goto L5;
        L9:
            Pattern r5 = getWildCardPattern(r2);
        L10:
            this._pattern = r5;
            return;
        L5:
            if (r4 == 1) goto L9;
            if (r4 == 2) goto L9;
            r5 = null;
            goto L10
        }

        public static Pattern getWildCardPattern(String r12) {
            int r0 = r12.length();
            StringBuilder r1 = new StringBuilder(r0);
            int r2 = 0;
            boolean r3 = false;
        L3:
            if (r2 >= r0) goto L32;
            char r4 = r12.charAt(r2);
            if (r4 != '$') goto L7;
        L30:
            r1.append("\\").append(r4);
        L31:
            r2 = r2 + 1;
            goto L3
        L7:
            if (r4 == '.') goto L30;
            if (r4 != '?') goto L11;
            r1.append('.');
        L20:
            r3 = true;
            goto L31
        L11:
            if (r4 == '[') goto L30;
            if (r4 == '~') goto L21;
            if (r4 == ']') goto L30;
            if (r4 == '^') goto L30;
            switch(r4) {
                case 40: goto L30;
                case 41: goto L30;
                case 42: goto L19;
                default: goto L18;
            };
        L18:
            r1.append(r4);
            goto L31
        L19:
            r1.append(".*");
            goto L20
        L21:
            int r5 = r2 + 1;
            if (r5 >= r0) goto L28;
            char r10 = r12.charAt(r5);
            if (r10 == '*') goto L27;
            if (r10 != '?') goto L28;
        L27:
            r1.append('[').append(r10).append(']');
            r2 = r5;
        L28:
            r1.append('~');
            goto L31
        L32:
            if (r3 == true) goto L34;
            return null;
        L34:
            return Pattern.compile(r1.toString(), 2);
        }

        @Override // org.apache.poi.ss.formula.functions.Countif.MatcherBase
        public String getValueText() {
            Pattern r0 = this._pattern;
            if (r0 != null) goto L7;
            return this._value;
        L7:
            return r0.pattern();
        }

        @Override // org.apache.poi.ss.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval r6) {
            ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, BlankEval.class) == false) goto L18;
            int r8 = getCode();
            if (r8 == 0) goto L14;
            if (r8 == 1) goto L14;
            if (r8 == 2) goto L10;
            return false;
        L10:
            if (this._value.length() != 0) goto L12;
            return false;
        L12:
            return true;
        L14:
            if (this._value.length() == 0) goto L16;
            return false;
        L16:
            return true;
        L18:
            if (ZeusTransformUtils.instanceOf(r7, StringEval.class) == true) goto L20;
            return false;
        L20:
            String r9 = ((StringEval) ZeusTransformUtils.preCheckCast(r7, StringEval.class, "com.obric.memorydata.plugin")).getStringValue();
            if (r9.length() < 1) goto L23;
        L29:
            Pattern r0 = this._pattern;
            if (r0 == null) goto L34;
            return evaluate(r0.matcher(r9).matches());
        L34:
            return evaluate(r9.compareToIgnoreCase(this._value));
        L23:
            if (this._value.length() >= 1) goto L29;
            int r5 = getCode();
            if (r5 == 0) goto L28;
            if (r5 == 2) goto L28;
            return false;
        L28:
            return true;
        }
    }

    public Countif() {
    }

    private double countMatchingCellsInArea(ValueEval r2, CountUtils.I_MatchPredicate r3) {
        ValueEval r1 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        CountUtils.I_MatchPredicate r4 = (CountUtils.I_MatchPredicate) ZeusTransformUtils.wrapperContextForParams(r3, CountUtils.I_MatchPredicate.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, RefEval.class) == false) goto L8;
        int r5 = CountUtils.countMatchingCellsInRef((RefEval) ZeusTransformUtils.preCheckCast(r1, RefEval.class, "com.obric.memorydata.plugin"), r4);
    L6:
        return r5;
    L8:
        if (ZeusTransformUtils.instanceOf(r1, ThreeDEval.class) == false) goto L11;
        r5 = CountUtils.countMatchingCellsInArea((ThreeDEval) ZeusTransformUtils.preCheckCast(r1, ThreeDEval.class, "com.obric.memorydata.plugin"), r4);
        goto L6
    L11:
        throw new IllegalArgumentException("Bad range arg type (" + r1.getClass().getName() + ")");
    }

    static CountUtils.I_MatchPredicate createCriteriaPredicate(ValueEval r2, int r3, int r4) {
        ValueEval r5 = evaluateCriteriaArg((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4);
        if (ZeusTransformUtils.instanceOf(r5, NumberEval.class) == false) goto L7;
        return new NumberMatcher(((NumberEval) ZeusTransformUtils.preCheckCast(r5, NumberEval.class, "com.obric.memorydata.plugin")).getNumberValue(), CmpOp.OP_NONE);
    L7:
        if (ZeusTransformUtils.instanceOf(r5, BoolEval.class) == false) goto L11;
        return new BooleanMatcher(((BoolEval) ZeusTransformUtils.preCheckCast(r5, BoolEval.class, "com.obric.memorydata.plugin")).getBooleanValue(), CmpOp.OP_NONE);
    L11:
        if (ZeusTransformUtils.instanceOf(r5, StringEval.class) == false) goto L15;
        return createGeneralMatchPredicate((StringEval) ZeusTransformUtils.preCheckCast(r5, StringEval.class, "com.obric.memorydata.plugin"));
    L15:
        if (ZeusTransformUtils.instanceOf(r5, ErrorEval.class) == false) goto L19;
        return new ErrorMatcher(((ErrorEval) ZeusTransformUtils.preCheckCast(r5, ErrorEval.class, "com.obric.memorydata.plugin")).getErrorCode(), CmpOp.OP_NONE);
    L19:
        if (r5 != BlankEval.instance) goto L23;
        return null;
    L23:
        throw new RuntimeException("Unexpected type for criteria (" + r5.getClass().getName() + ")");
    }

    private static CountUtils.I_MatchPredicate createGeneralMatchPredicate(StringEval r3) {
        String r4 = r3.getStringValue();
        CmpOp r0 = CmpOp.getOperator(r4);
        String r5 = r4.substring(r0.getLength());
        Boolean r1 = parseBoolean(r5);
        if (r1 != null) goto L5;
        Double r2 = OperandResolver.parseDouble(r5);
        if (r2 != null) goto L9;
        ErrorEval r6 = parseError(r5);
        if (r6 == null) goto L15;
        return new ErrorMatcher(r6.getErrorCode(), r0);
    L15:
        return new StringMatcher(r5, r0);
    L9:
        return new NumberMatcher(r2.doubleValue(), r0);
    L5:
        return new BooleanMatcher(r1.booleanValue(), r0);
    }

    private static ValueEval evaluateCriteriaArg(ValueEval r2, int r3, int r4) {
        return OperandResolver.getSingleValue((ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4);
    L5:
        e = move-exception;
        return e.getErrorEval();
    }

    static Boolean parseBoolean(String r3) {
        if (r3.length() >= 1) goto L5;
        return null;
    L5:
        char r0 = r3.charAt(0);
        if (r0 == 'F') goto L19;
        if (r0 == 'T') goto L15;
        if (r0 == 'f') goto L19;
        if (r0 == 't') goto L15;
    L22:
        return null;
    L15:
        if ("TRUE".equalsIgnoreCase(r3) == false) goto L22;
        return Boolean.TRUE;
    L19:
        if ("FALSE".equalsIgnoreCase(r3) == false) goto L22;
        return Boolean.FALSE;
    }

    private static ErrorEval parseError(String r3) {
        if (r3.length() >= 4) goto L5;
    L35:
        return null;
    L5:
        if (r3.charAt(0) != '#') goto L35;
        if (r3.equals("#NULL!") == false) goto L12;
        return ErrorEval.NULL_INTERSECTION;
    L12:
        if (r3.equals("#DIV/0!") == false) goto L16;
        return ErrorEval.DIV_ZERO;
    L16:
        if (r3.equals("#VALUE!") == false) goto L20;
        return ErrorEval.VALUE_INVALID;
    L20:
        if (r3.equals("#REF!") == false) goto L24;
        return ErrorEval.REF_INVALID;
    L24:
        if (r3.equals("#NAME?") == false) goto L28;
        return ErrorEval.NAME_INVALID;
    L28:
        if (r3.equals("#NUM!") == false) goto L32;
        return ErrorEval.NUM_ERROR;
    L32:
        if (r3.equals("#N/A") == false) goto L35;
        return ErrorEval.NA;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int r3, int r4, ValueEval r5, ValueEval r6) {
        ValueEval r7 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r5, ValueEval.class, "com.obric.memorydata.plugin");
        CountUtils.I_MatchPredicate r8 = createCriteriaPredicate((ValueEval) ZeusTransformUtils.wrapperContextForParams(r6, ValueEval.class, "com.obric.memorydata.plugin"), r3, r4);
        if (r8 != null) goto L7;
        return NumberEval.ZERO;
    L7:
        return new NumberEval(countMatchingCellsInArea(r7, r8));
    }
}
