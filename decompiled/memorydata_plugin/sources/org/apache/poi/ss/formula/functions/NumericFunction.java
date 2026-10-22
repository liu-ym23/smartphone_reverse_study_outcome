package org.apache.poi.ss.formula.functions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class NumericFunction implements Function {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Function ABS = null;
    public static final Function ACOS = null;
    public static final Function ACOSH = null;
    public static final Function ASIN = null;
    public static final Function ASINH = null;
    public static final Function ATAN = null;
    public static final Function ATAN2 = null;
    public static final Function ATANH = null;
    public static final Function CEILING = null;
    public static final Function COMBIN = null;
    public static final Function COS = null;
    public static final Function COSH = null;
    public static final Function DEGREES = null;
    public static final Function DOLLAR = null;
    public static final Function EVEN = null;
    public static final Function EXP = null;
    public static final Function FACT = null;
    public static final Function FLOOR = null;
    public static final Function INT = null;
    public static final Function LN = null;
    public static final Function LOG = null;
    public static final Function LOG10 = null;
    private static final double LOG_10_TO_BASE_e = 0.0d;
    public static final Function MOD = null;
    public static final Function ODD = null;
    public static final Function PI = null;
    static final NumberEval PI_EVAL = null;
    public static final Function POISSON = null;
    public static final Function POWER = null;
    public static final Function RADIANS = null;
    public static final Function RAND = null;
    public static final Function ROUND = null;
    public static final Function ROUNDDOWN = null;
    public static final Function ROUNDUP = null;
    public static final Function SIGN = null;
    public static final Function SIN = null;
    public static final Function SINH = null;
    public static final Function SQRT = null;
    public static final Function TAN = null;
    public static final Function TANH = null;
    public static final Function TRUNC = null;

    private interface OneDoubleIf {
        double apply(double r1);
    }

    private interface TwoDoubleIf {
        Object apply(double r1, double r3);
    }

    static {
        LOG_10_TO_BASE_e = Math.log(10.0d);
        ABS = oneDouble($$Lambda$NumericFunction$lutZkHYkfQlK1Z9gc9yAVpKBDBc.INSTANCE);
        ACOS = oneDouble($$Lambda$NumericFunction$7X6DvMDd86odElElYqX6bY9ALE.INSTANCE);
        ACOSH = oneDouble($$Lambda$xMj1uppdannvlAnp2AEOmQ0QCY.INSTANCE);
        ASIN = oneDouble($$Lambda$NumericFunction$Z9tYSRQXrV0Vp4ADqEPRliZtg.INSTANCE);
        ASINH = oneDouble($$Lambda$WwLI_JmQRXvsvz6pHDv4AZmHUB8.INSTANCE);
        ATAN = oneDouble($$Lambda$NumericFunction$OiMEQR8FFzHvZ62J2_w_uOajXZ8.INSTANCE);
        ATANH = oneDouble($$Lambda$1qKX1uxVkZ01cO3rLTVrku5rIw.INSTANCE);
        COS = oneDouble($$Lambda$NumericFunction$nHC4Z6ArIHBjZhlaOccOtSqXAvs.INSTANCE);
        COSH = oneDouble($$Lambda$HwWFmX5RlnWeDc2URLRKUO5HVBA.INSTANCE);
        DEGREES = oneDouble($$Lambda$NumericFunction$OqU1bAuikwCCY0rfGsf3whtoSs.INSTANCE);
        DOLLAR = $$Lambda$NumericFunction$5na2beWOq7SfXaG2Z8Uscgn0S3c.INSTANCE;
        EXP = oneDouble($$Lambda$NumericFunction$aTv83_xzNQ195d5nvOIG90W9AE4.INSTANCE);
        FACT = oneDouble($$Lambda$fa3mU71CzZ4JnG5hrKjpXBBwLd0.INSTANCE);
        INT = oneDouble($$Lambda$NumericFunction$wpFWIzbh28YUIyx74Z1jGzGDDDA.INSTANCE);
        LN = oneDouble($$Lambda$NumericFunction$lhw6wyVBvTGHUl2lU0GvNbwIppE.INSTANCE);
        LOG10 = oneDouble($$Lambda$NumericFunction$uFMFjXvCTTLSIPB2m1ldSJeFtI.INSTANCE);
        RADIANS = oneDouble($$Lambda$NumericFunction$AT5klQZ4qpjEWZgMT8Whiqrqqj0.INSTANCE);
        SIGN = oneDouble($$Lambda$TnMT78xnULZ6wnEh3Lk2DMUsJg.INSTANCE);
        SIN = oneDouble($$Lambda$NumericFunction$oUEVyaXT39czf2LqUITr4ZG1Ck.INSTANCE);
        SINH = oneDouble($$Lambda$o8L79GG7seRY2Ueg1E3lZFk0OFI.INSTANCE);
        SQRT = oneDouble($$Lambda$NumericFunction$gA6mlQ8HcwlqNbLSSaNiFftGqIM.INSTANCE);
        TAN = oneDouble($$Lambda$NumericFunction$9HUNzFEgfPdz37DJ8YBAbOdL1M.INSTANCE);
        TANH = oneDouble($$Lambda$obDjahDWjHzwxNzdeveJtUKVEC8.INSTANCE);
        ATAN2 = twoDouble($$Lambda$NumericFunction$28WPgjWuL3pQEkwfazfViB6gC6Y.INSTANCE);
        CEILING = twoDouble($$Lambda$cJrzzIZQjDJeWtgbpMjIMyDhB_I.INSTANCE);
        COMBIN = twoDouble($$Lambda$NumericFunction$t94F2IS2nO1JWGFRG11C7jjHtw.INSTANCE);
        FLOOR = twoDouble($$Lambda$NumericFunction$MEvTRXhsaft9jAcgvzxRxmkea8c.INSTANCE);
        MOD = twoDouble($$Lambda$NumericFunction$PqjVHPR8RsNjNVRULvXtKBW0c.INSTANCE);
        POWER = twoDouble($$Lambda$NumericFunction$zDQmfi3wSFOLJp68WzgAriZVuo.INSTANCE);
        ROUND = twoDouble($$Lambda$jRxAXqbtHmhqslIKPSA2fFfSqIM.INSTANCE);
        ROUNDDOWN = twoDouble($$Lambda$VyQ8DwWtWGLlmOvKVGC8yD5Q4lQ.INSTANCE);
        ROUNDUP = twoDouble($$Lambda$Wkw3QQqxPskfKy2tVBbTR1IY20.INSTANCE);
        TRUNC = $$Lambda$NumericFunction$lNsujAetBUxAa6jH2MbJSPFEig.INSTANCE;
        LOG = $$Lambda$y9Aa1XtHwCtvLq3klHgHOB9e6k.INSTANCE;
        PI_EVAL = new NumberEval(3.141592653589793d);
        PI = $$Lambda$NumericFunction$4hbxkUpB8YAKG8Ld2MjDR6I05Ko.INSTANCE;
        RAND = $$Lambda$NumericFunction$KVAd3_pjjaq6fYLXqNLbI28voYs.INSTANCE;
        POISSON = $$Lambda$TZN1Q2xVbpGplPyugfYq7cx4HEI.INSTANCE;
        ODD = oneDouble($$Lambda$NumericFunction$gBSKzHQOw_e5Co_8n1jKhkmDdlc.INSTANCE);
        EVEN = oneDouble($$Lambda$NumericFunction$QR9jZlPSauYDfyNqNcY0FJRbnBE.INSTANCE);
    }

    public NumericFunction() {
    }

    public static void checkValue(double r1) {
        if (Double.isNaN(r1) == true) goto L8;
        if (Double.isInfinite(r1) == true) goto L8;
        return;
    L8:
        throw new EvaluationException(ErrorEval.NUM_ERROR);
    }

    private static ValueEval evaluateDollar(ValueEval[] r6, int r7, int r8) {
        if (r6.length == 1) goto L27;
        if (r6.length == 2) goto L27;
        return ErrorEval.VALUE_INVALID;
    L27:
        double r2 = singleOperandEvaluate(r6[0], r7, r8);     // Catch: EvaluationException -> L24
        if (r6.length != 1) goto L12;
        double r9 = 2.0d;
    L13:
        int r10 = (int) r9;     // Catch: EvaluationException -> L24
        if (r10 > 127) goto L16;
        if (r10 >= 0) goto L19;
        BigDecimal r11 = BigDecimal.valueOf(Math.pow(10.0d, -r10));     // Catch: EvaluationException -> L24
        r2 = BigDecimal.valueOf(r2).divide(r11, MathContext.DECIMAL128).toBigInteger().multiply(r11.toBigInteger()).doubleValue();     // Catch: EvaluationException -> L24
    L19:
        DecimalFormat r12 = (DecimalFormat) ZeusTransformUtils.preCheckCast(NumberFormat.getCurrencyInstance(LocaleUtil.getUserLocale()), DecimalFormat.class, "com.obric.memorydata.plugin");     // Catch: EvaluationException -> L24
        int r13 = Math.max(r10, 0);     // Catch: EvaluationException -> L24
        if (LocaleUtil.getUserLocale().getCountry().equalsIgnoreCase("US") == false) goto L22;
        r12.setNegativePrefix("(" + r12.getDecimalFormatSymbols().getCurrencySymbol());     // Catch: EvaluationException -> L24
        r12.setNegativeSuffix(")");     // Catch: EvaluationException -> L24
    L22:
        r12.setMinimumFractionDigits(r13);     // Catch: EvaluationException -> L24
        r12.setMaximumFractionDigits(r13);     // Catch: EvaluationException -> L24
        return new StringEval(r12.format(r2).replace(" ", " "));
    L16:
        return ErrorEval.VALUE_INVALID;
    L12:
        r9 = singleOperandEvaluate(r6[1], r7, r8);     // Catch: EvaluationException -> L24
    L24:
        e = move-exception;
        return e.getErrorEval();
    }

    private static double evaluateEven(double r6) {
        if (r6 != 0.0d) goto L5;
        return 0.0d;
    L5:
        double r0 = Math.abs(r6);
        long r2 = ((long) r0) & (-2);
        double r7 = MathX.sign(r6);
        if (Double.compare(r2, r0) == 0) goto L10;
        r2 = r2 + 2;
    L10:
        return r7 * r2;
    }

    private static double evaluateOdd(double r7) {
        if (r7 != 0.0d) goto L5;
        return 1.0d;
    L5:
        double r3 = Math.abs(r7) + 1.0d;
        long r0 = ((long) r3) & (-2);
        double r8 = MathX.sign(r7);
        if (Double.compare(r0, r3) != 0) goto L8;
        long r1 = r0 - 1;
    L10:
        return r8 * r1;
    L8:
        r1 = r0 + 1;
        goto L10
    }

    private static ValueEval evaluatePI(ValueEval[] r0, int r1, int r2) {
        if (r0.length == 0) goto L6;
        return ErrorEval.VALUE_INVALID;
    L6:
        return PI_EVAL;
    }

    private static ValueEval evaluateRand(ValueEval[] r0, int r1, int r2) {
        if (r0.length == 0) goto L6;
        return ErrorEval.VALUE_INVALID;
    L6:
        return new NumberEval(Math.random());
    }

    private static ValueEval evaluateTrunc(ValueEval[] r4, int r5, int r6) {
        if (r4.length == 1) goto L18;
        if (r4.length == 2) goto L18;
        return ErrorEval.VALUE_INVALID;
    L18:
        double r2 = singleOperandEvaluate(r4[0], r5, r6);     // Catch: EvaluationException -> L15
        if (r4.length != 1) goto L12;
        double r7 = 0.0d;
    L13:
        double r8 = MathX.roundDown(r2, r7);     // Catch: EvaluationException -> L15
        checkValue(r8);     // Catch: EvaluationException -> L15
        return new NumberEval(r8);
    L12:
        r7 = singleOperandEvaluate(r4[1], r5, r6);     // Catch: EvaluationException -> L15
    L15:
        e = move-exception;
        return e.getErrorEval();
    }

    public static /* synthetic */ ValueEval lambda$4hbxkUpB8YAKG8Ld2MjDR6I05Ko(ValueEval[] r0, int r1, int r2) {
        return evaluatePI(r0, r1, r2);
    }

    public static /* synthetic */ ValueEval lambda$5na2beWOq7SfXaG2Z8Uscgn0S3c(ValueEval[] r0, int r1, int r2) {
        return evaluateDollar(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$7X6DvMD-d86odElElYqX6bY9ALE, reason: not valid java name */
    public static /* synthetic */ double m3180lambda$7X6DvMDd86odElElYqX6bY9ALE(double r0) {
        return Math.acos(r0);
    }

    /* JADX INFO: renamed from: lambda$9HUNzFEgfPdz3-7DJ8YBAbOdL1M, reason: not valid java name */
    public static /* synthetic */ double m3181lambda$9HUNzFEgfPdz37DJ8YBAbOdL1M(double r0) {
        return Math.tan(r0);
    }

    public static /* synthetic */ double lambda$AT5klQZ4qpjEWZgMT8Whiqrqqj0(double r0) {
        return Math.toRadians(r0);
    }

    public static /* synthetic */ ValueEval lambda$KVAd3_pjjaq6fYLXqNLbI28voYs(ValueEval[] r0, int r1, int r2) {
        return evaluateRand(r0, r1, r2);
    }

    public static /* synthetic */ double lambda$OiMEQR8FFzHvZ62J2_w_uOajXZ8(double r0) {
        return Math.atan(r0);
    }

    /* JADX INFO: renamed from: lambda$OqU1bAuikwCCY0r-fGsf3whtoSs, reason: not valid java name */
    public static /* synthetic */ double m3182lambda$OqU1bAuikwCCY0rfGsf3whtoSs(double r0) {
        return Math.toDegrees(r0);
    }

    public static /* synthetic */ double lambda$QR9jZlPSauYDfyNqNcY0FJRbnBE(double r0) {
        return evaluateEven(r0);
    }

    /* JADX INFO: renamed from: lambda$Z9t-YSRQXrV0Vp4ADqEPRli-Ztg, reason: not valid java name */
    public static /* synthetic */ double m3183lambda$Z9tYSRQXrV0Vp4ADqEPRliZtg(double r0) {
        return Math.asin(r0);
    }

    public static /* synthetic */ double lambda$gA6mlQ8HcwlqNbLSSaNiFftGqIM(double r0) {
        return Math.sqrt(r0);
    }

    public static /* synthetic */ double lambda$gBSKzHQOw_e5Co_8n1jKhkmDdlc(double r0) {
        return evaluateOdd(r0);
    }

    /* JADX INFO: renamed from: lambda$lNsujAetBUxAa6jH2-MbJSPFEig, reason: not valid java name */
    public static /* synthetic */ ValueEval m3184lambda$lNsujAetBUxAa6jH2MbJSPFEig(ValueEval[] r0, int r1, int r2) {
        return evaluateTrunc(r0, r1, r2);
    }

    public static /* synthetic */ double lambda$lhw6wyVBvTGHUl2lU0GvNbwIppE(double r0) {
        return Math.log(r0);
    }

    public static /* synthetic */ double lambda$lutZkHYkfQlK1Z9gc9yAVpKBDBc(double r0) {
        return Math.abs(r0);
    }

    public static /* synthetic */ double lambda$nHC4Z6ArIHBjZhlaOccOtSqXAvs(double r0) {
        return Math.cos(r0);
    }

    /* JADX INFO: renamed from: lambda$oUEVyaXT39czf2LqUITr4Z-G1Ck, reason: not valid java name */
    public static /* synthetic */ double m3185lambda$oUEVyaXT39czf2LqUITr4ZG1Ck(double r0) {
        return Math.sin(r0);
    }

    static /* synthetic */ ValueEval lambda$oneDouble$7(OneDoubleIf r2, ValueEval[] r3, int r4, int r5) {
        OneDoubleIf r6 = (OneDoubleIf) ZeusTransformUtils.wrapperContextForParams(r2, OneDoubleIf.class, "com.obric.memorydata.plugin");
        if (r3.length == 1) goto L18;
        return ErrorEval.VALUE_INVALID;
    L18:
        double r7 = r6.apply(singleOperandEvaluate(r3[0], r4, r5));     // Catch: EvaluationException -> L15
        if (Double.isNaN(r7) == true) goto L14;
        if (Double.isInfinite(r7) == true) goto L14;
        return new NumberEval(r7);
    L14:
        return ErrorEval.NUM_ERROR;
    L15:
        e = move-exception;
        return e.getErrorEval();
    }

    static /* synthetic */ double lambda$static$0(double r2) {
        return Math.pow(2.718281828459045d, r2);
    }

    static /* synthetic */ double lambda$static$1(double r2) {
        return Math.round(r2 - 0.5d);
    }

    static /* synthetic */ double lambda$static$2(double r2) {
        return Math.log(r2) / LOG_10_TO_BASE_e;
    }

    static /* synthetic */ Object lambda$static$3(double r3, double r5) {
        if (r3 != 0.0d) goto L8;
        if (r5 != 0.0d) goto L8;
        return ErrorEval.DIV_ZERO;
    L8:
        return Double.valueOf(Math.atan2(r5, r3));
    }

    static /* synthetic */ Object lambda$static$4(double r3, double r5) {
        if (r3 > 2.147483647E9d) goto L9;
        if (r5 > 2.147483647E9d) goto L9;
        return Double.valueOf(MathX.nChooseK((int) r3, (int) r5));
    L9:
        return ErrorEval.NUM_ERROR;
    }

    static /* synthetic */ Object lambda$static$5(double r3, double r5) {
        if (r5 != 0.0d) goto L9;
        if (r3 != 0.0d) goto L11;
        return Double.valueOf(0.0d);
    L11:
        return ErrorEval.DIV_ZERO;
    L9:
        return Double.valueOf(MathX.floor(r3, r5));
    }

    static /* synthetic */ Object lambda$static$6(double r2, double r4) {
        if (r4 != 0.0d) goto L6;
        return ErrorEval.DIV_ZERO;
    L6:
        return Double.valueOf(MathX.mod(r2, r4));
    }

    static /* synthetic */ ValueEval lambda$twoDouble$8(TwoDoubleIf r4, ValueEval[] r5, int r6, int r7) {
        TwoDoubleIf r8 = (TwoDoubleIf) ZeusTransformUtils.wrapperContextForParams(r4, TwoDoubleIf.class, "com.obric.memorydata.plugin");
        if (r5.length == 2) goto L22;
        return ErrorEval.VALUE_INVALID;
    L22:
        Object r9 = r8.apply(singleOperandEvaluate(r5[0], r6, r7), singleOperandEvaluate(r5[1], r6, r7));     // Catch: EvaluationException -> L19
        if (ZeusTransformUtils.instanceOf(r9, ErrorEval.class) == true) goto L10;
        double r10 = ((Double) ZeusTransformUtils.preCheckCast(r9, Double.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: EvaluationException -> L19
        if (Double.isNaN(r10) == true) goto L18;
        if (Double.isInfinite(r10) == true) goto L18;
        return new NumberEval(r10);
    L18:
        return ErrorEval.NUM_ERROR;
    L10:
        return (ErrorEval) ZeusTransformUtils.preCheckCast(r9, ErrorEval.class, "com.obric.memorydata.plugin");
    L19:
        e = move-exception;
        return e.getErrorEval();
    }

    /* JADX INFO: renamed from: lambda$zDQmfi3wSFOLJp-68WzgAriZVuo, reason: not valid java name */
    public static /* synthetic */ double m3186lambda$zDQmfi3wSFOLJp68WzgAriZVuo(double r0, double r2) {
        return Math.pow(r0, r2);
    }

    private static Function oneDouble(OneDoubleIf r2) {
        final OneDoubleIf r3 = (OneDoubleIf) ZeusTransformUtils.wrapperContextForParams(r2, OneDoubleIf.class, "com.obric.memorydata.plugin");
        return new $$Lambda$NumericFunction$K4z_aEw1jvhNRtztKgCLvgoM0I(r3);
    }

    public static double singleOperandEvaluate(ValueEval r2, int r3, int r4) {
        ValueEval r5 = (ValueEval) ZeusTransformUtils.wrapperContextForParams(r2, ValueEval.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        double r6 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(r5, r3, r4));
        checkValue(r6);
        return r6;
    L7:
        throw new IllegalArgumentException("arg must not be null");
    }

    private static Function twoDouble(TwoDoubleIf r2) {
        final TwoDoubleIf r3 = (TwoDoubleIf) ZeusTransformUtils.wrapperContextForParams(r2, TwoDoubleIf.class, "com.obric.memorydata.plugin");
        return new $$Lambda$NumericFunction$K8LimbjEPQz6VbfpJZUPyetZJ1A(r3);
    }

    public abstract double eval(ValueEval[] r1, int r2, int r3);

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] r1, int r2, int r3) {
        double r0 = eval(r1, r2, r3);     // Catch: EvaluationException -> L5
        checkValue(r0);     // Catch: EvaluationException -> L5
        return new NumberEval(r0);
    L5:
        e = move-exception;
        return e.getErrorEval();
    }
}
