package kotlin.math;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b8\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0018\u0010+\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0007\u001a\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0007\u001a\u0011\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\b\u001a\u0019\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\b\u001a\u0019\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\b\u001a\u0019\u00102\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH\u0087\b\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0010\u00109\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u0010:\u001a\u00020\u0001*\u00020\u00012\u0006\u0010;\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0006*\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0087\b\u001a\r\u0010<\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010<\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0087\b\u001a\r\u0010?\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010?\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0087\b\u001a\f\u0010A\u001a\u00020\t*\u00020\u0001H\u0007\u001a\f\u0010A\u001a\u00020\t*\u00020\u0006H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0001H\u0007\u001a\f\u0010B\u001a\u00020\f*\u00020\u0006H\u0007\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0087\b\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0007\u001a\u0004\b\u0004\u0010\b\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\n\u001a\u0004\b\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\f*\u00020\f8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\b¨\u0006D"}, d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "cbrt", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/math/MathKt")
class MathKt__MathJVMKt extends MathKt__MathHKt {
    public MathKt__MathJVMKt() {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double IEEErem(double r5, double r10) {
        return Math.IEEEremainder(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double abs(double r5) {
        return Math.abs(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double acos(double r5) {
        return Math.acos(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final double acosh(double r10) {
        if (r10 >= 1.0d) goto L6;
        return Double.NaN;
    L6:
        if (r10 > Constants.upper_taylor_2_bound) goto L17;
        double r5 = 1;
        double r11 = r10 - r5;
        if (r11 >= Constants.taylor_n_bound) goto L18;
        double r12 = Math.sqrt(r11);
        if (r12 < Constants.taylor_2_bound) goto L15;
        r12 = r12 - (((r12 * r12) * r12) / ((double) 12));
    L15:
        return r12 * Math.sqrt(2.0d);
    L18:
        return Math.log(Math.sqrt((r10 * r10) - r5) + r10);
    L17:
        return Math.log(r10) + Constants.LN2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double asin(double r5) {
        return Math.asin(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final double asinh(double r5) {
        double r10 = Constants.taylor_n_bound;
        if (r5 < r10) goto L12;
        if (r5 <= Constants.upper_taylor_n_bound) goto L20;
        if (r5 > Constants.upper_taylor_2_bound) goto L18;
        double r11 = r5 * ((double) 2);
        return Math.log((((double) 1) / r11) + r11);
    L18:
        return Math.log(r5) + Constants.LN2;
    L20:
        return Math.log(Math.sqrt((r5 * r5) + ((double) 1)) + r5);
    L12:
        if (r5 > (-r10)) goto L15;
        return -asinh(-r5);
    L15:
        if (Math.abs(r5) >= Constants.taylor_2_bound) goto L17;
        return r5;
    L17:
        return r5 - (((r5 * r5) * r5) / ((double) 6));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan(double r5) {
        return Math.atan(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan2(double r5, double r10) {
        return Math.atan2(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    public static final double atanh(double r5) {
        if (Math.abs(r5) < Constants.taylor_n_bound) goto L5;
        double r10 = 1;
        return Math.log((r10 + r5) / (r10 - r5)) / ((double) 2);
    L5:
        if (Math.abs(r5) > Constants.taylor_2_bound) goto L7;
        return r5;
    L7:
        return r5 + (((r5 * r5) * r5) / ((double) 3));
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final double cbrt(double r5) {
        return Math.cbrt(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ceil(double r5) {
        return Math.ceil(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cos(double r5) {
        return Math.cos(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cosh(double r5) {
        return Math.cosh(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double exp(double r5) {
        return Math.exp(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double expm1(double r5) {
        return Math.expm1(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double floor(double r5) {
        return Math.floor(r5);
    }

    private static final double getAbsoluteValue(double r5) {
        return Math.abs(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double r5) {
    }

    private static final double getSign(double r5) {
        return Math.signum(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double r5) {
    }

    private static final double getUlp(double r5) {
        return Math.ulp(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double r5) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double hypot(double r5, double r10) {
        return Math.hypot(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln(double r5) {
        return Math.log(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln1p(double r5) {
        return Math.log1p(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final double log(double r5, double r10) {
        if (r10 > 0.0d) goto L5;
        return Double.NaN;
    L5:
        if (r10 != 1.0d) goto L8;
        return Double.NaN;
    L8:
        return Math.log(r5) / Math.log(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double log10(double r5) {
        return Math.log10(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final double log2(double r5) {
        return Math.log(r5) / Constants.LN2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double max(double r5, double r10) {
        return Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double min(double r5, double r10) {
        return Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextDown(double r5) {
        return Math.nextAfter(r5, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextTowards(double r5, double r10) {
        return Math.nextAfter(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextUp(double r5) {
        return Math.nextUp(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double r5, double r10) {
        return Math.pow(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double round(double r5) {
        return Math.rint(r5);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(double r5) {
        if (Double.isNaN(r5) == true) goto L13;
        if (r5 <= 2.147483647E9d) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r5 >= (-2.147483648E9d)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) Math.round(r5);
    L13:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    public static long roundToLong(double r5) {
        if (Double.isNaN(r5) == true) goto L7;
        return Math.round(r5);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sign(double r5) {
        return Math.signum(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sin(double r5) {
        return Math.sin(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sinh(double r5) {
        return Math.sinh(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sqrt(double r5) {
        return Math.sqrt(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tan(double r5) {
        return Math.tan(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tanh(double r5) {
        return Math.tanh(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final double truncate(double r5) {
        if (Double.isNaN(r5) == false) goto L5;
        return r5;
    L5:
        if (Double.isInfinite(r5) == false) goto L8;
        return r5;
    L8:
        if (r5 <= 0.0d) goto L11;
        return Math.floor(r5);
    L11:
        return Math.ceil(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double r5, double r10) {
        return Math.copySign(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float IEEErem(float r5, float r10) {
        return (float) Math.IEEEremainder(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float abs(float r5) {
        return Math.abs(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acos(float r5) {
        return (float) Math.acos(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asin(float r5) {
        return (float) Math.asin(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan(float r5) {
        return (float) Math.atan(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan2(float r5, float r10) {
        return (float) Math.atan2(r5, r10);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final float cbrt(float r5) {
        return (float) Math.cbrt(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ceil(float r5) {
        return (float) Math.ceil(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cos(float r5) {
        return (float) Math.cos(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cosh(float r5) {
        return (float) Math.cosh(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float exp(float r5) {
        return (float) Math.exp(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float expm1(float r5) {
        return (float) Math.expm1(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float floor(float r5) {
        return (float) Math.floor(r5);
    }

    private static final float getAbsoluteValue(float r5) {
        return Math.abs(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float r5) {
    }

    private static final float getSign(float r5) {
        return Math.signum(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float r5) {
    }

    private static final float getUlp(float r5) {
        return Math.ulp(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float r5) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float hypot(float r5, float r10) {
        return (float) Math.hypot(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln(float r5) {
        return (float) Math.log(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln1p(float r5) {
        return (float) Math.log1p(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final float log(float r5, float r10) {
        if (r10 > 0.0f) goto L5;
        return Float.NaN;
    L5:
        if (r10 != 1.0f) goto L8;
        return Float.NaN;
    L8:
        return (float) (Math.log(r5) / Math.log(r10));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float log10(float r5) {
        return (float) Math.log10(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final float log2(float r5) {
        return (float) (Math.log(r5) / Constants.LN2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float max(float r5, float r10) {
        return Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float min(float r5, float r10) {
        return Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextDown(float r5) {
        return Math.nextAfter(r5, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextTowards(float r5, float r10) {
        return Math.nextAfter(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextUp(float r5) {
        return Math.nextUp(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double r5, int r10) {
        return Math.pow(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float round(float r5) {
        return (float) Math.rint(r5);
    }

    @SinceKotlin(version = "1.2")
    public static long roundToLong(float r5) {
        return roundToLong(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sign(float r5) {
        return Math.signum(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sin(float r5) {
        return (float) Math.sin(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sinh(float r5) {
        return (float) Math.sinh(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sqrt(float r5) {
        return (float) Math.sqrt(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tan(float r5) {
        return (float) Math.tan(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tanh(float r5) {
        return (float) Math.tanh(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double r5, int r10) {
        return Math.copySign(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int abs(int r5) {
        return Math.abs(r5);
    }

    private static final int getAbsoluteValue(int r5) {
        return Math.abs(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int r5) {
    }

    public static int getSign(int r5) {
        return Integer.signum(r5);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(int r5) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int max(int r5, int r10) {
        return Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int min(int r5, int r10) {
        return Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float r5, float r10) {
        return (float) Math.pow(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float r5, float r10) {
        return Math.copySign(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long abs(long r5) {
        return Math.abs(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atanh(float r5) {
        return (float) atanh(r5);
    }

    private static final long getAbsoluteValue(long r5) {
        return Math.abs(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long r5) {
    }

    public static int getSign(long r5) {
        return Long.signum(r5);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(long r5) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long max(long r5, long r10) {
        return Math.max(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long min(long r5, long r10) {
        return Math.min(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float r5, int r10) {
        return (float) Math.pow(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(float r5) {
        if (Float.isNaN(r5) == true) goto L7;
        return Math.round(r5);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    public static final float truncate(float r5) {
        if (Float.isNaN(r5) == false) goto L5;
        return r5;
    L5:
        if (Float.isInfinite(r5) == false) goto L8;
        return r5;
    L8:
        if (r5 <= 0.0f) goto L11;
        double r10 = Math.floor(r5);
    L13:
        return (float) r10;
    L11:
        r10 = Math.ceil(r5);
        goto L13
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float r5, int r10) {
        return Math.copySign(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acosh(float r5) {
        return (float) acosh(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asinh(float r5) {
        return (float) asinh(r5);
    }
}
