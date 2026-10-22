package kotlin.math;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;

/* JADX INFO: loaded from: classes2.dex */
class MathKt__MathJVMKt extends MathKt__MathHKt {
    public MathKt__MathJVMKt() {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double IEEErem(double r10, double r11) {
        return Math.IEEEremainder(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float IEEErem(float r10, float r11) {
        return (float) Math.IEEEremainder(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double abs(double r10) {
        return Math.abs(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float abs(float r10) {
        return Math.abs(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int abs(int r10) {
        return Math.abs(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long abs(long r10) {
        return Math.abs(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double acos(double r10) {
        return Math.acos(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acos(float r10) {
        return (float) Math.acos(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final double acosh(double r10) {
        if (r10 >= 1.0d) goto L6;
        return Double.NaN;
    L6:
        if (r10 > Constants.upper_taylor_2_bound) goto L17;
        double r11 = 1;
        double r12 = r10 - r11;
        if (r12 >= Constants.taylor_n_bound) goto L18;
        double r13 = Math.sqrt(r12);
        if (r13 < Constants.taylor_2_bound) goto L15;
        r13 = r13 - (((r13 * r13) * r13) / ((double) 12));
    L15:
        return r13 * Math.sqrt(2.0d);
    L18:
        return Math.log(r10 + Math.sqrt((r10 * r10) - r11));
    L17:
        return Math.log(r10) + Constants.LN2;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float acosh(float r10) {
        return (float) acosh(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double asin(double r10) {
        return Math.asin(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asin(float r10) {
        return (float) Math.asin(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final double asinh(double r10) {
        double r11 = Constants.taylor_n_bound;
        if (r10 < r11) goto L13;
        if (r10 > Constants.upper_taylor_n_bound) goto L7;
        double r12 = Math.sqrt((r10 * r10) + ((double) 1));
    L20:
        return Math.log(r10 + r12);
    L7:
        if (r10 > Constants.upper_taylor_2_bound) goto L19;
        r10 = r10 * ((double) 2);
        r12 = ((double) 1) / r10;
        goto L20
    L19:
        return Math.log(r10) + Constants.LN2;
    L13:
        if (r10 > (-r11)) goto L16;
        return -asinh(-r10);
    L16:
        if (Math.abs(r10) >= Constants.taylor_2_bound) goto L18;
        return r10;
    L18:
        return r10 - (((r10 * r10) * r10) / ((double) 6));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float asinh(float r10) {
        return (float) asinh(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan(double r10) {
        return Math.atan(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan(float r10) {
        return (float) Math.atan(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double atan2(double r10, double r11) {
        return Math.atan2(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atan2(float r10, float r11) {
        return (float) Math.atan2(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    public static final double atanh(double r10) {
        if (Math.abs(r10) < Constants.taylor_n_bound) goto L5;
        double r11 = 1;
        return Math.log((r11 + r10) / (r11 - r10)) / ((double) 2);
    L5:
        if (Math.abs(r10) > Constants.taylor_2_bound) goto L7;
        return r10;
    L7:
        return r10 + (((r10 * r10) * r10) / ((double) 3));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float atanh(float r10) {
        return (float) atanh(r10);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final double cbrt(double r10) {
        return Math.cbrt(r10);
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final float cbrt(float r10) {
        return (float) Math.cbrt(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ceil(double r10) {
        return Math.ceil(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ceil(float r10) {
        return (float) Math.ceil(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cos(double r10) {
        return Math.cos(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cos(float r10) {
        return (float) Math.cos(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double cosh(double r10) {
        return Math.cosh(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float cosh(float r10) {
        return (float) Math.cosh(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double exp(double r10) {
        return Math.exp(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float exp(float r10) {
        return (float) Math.exp(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double expm1(double r10) {
        return Math.expm1(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float expm1(float r10) {
        return (float) Math.expm1(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double floor(double r10) {
        return Math.floor(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float floor(float r10) {
        return (float) Math.floor(r10);
    }

    private static final double getAbsoluteValue(double r10) {
        return Math.abs(r10);
    }

    private static final float getAbsoluteValue(float r10) {
        return Math.abs(r10);
    }

    private static final int getAbsoluteValue(int r10) {
        return Math.abs(r10);
    }

    private static final long getAbsoluteValue(long r10) {
        return Math.abs(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(double r10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(float r10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(int r10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getAbsoluteValue$annotations(long r10) {
    }

    private static final double getSign(double r10) {
        return Math.signum(r10);
    }

    private static final float getSign(float r10) {
        return Math.signum(r10);
    }

    public static int getSign(int r10) {
        if (r10 >= 0) goto L4;
        return -1;
    L4:
        if (r10 <= 0) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static int getSign(long r10) {
        if (r10 >= 0) goto L5;
        return -1;
    L5:
        if (r10 <= 0) goto L7;
        return 1;
    L7:
        return 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(double r10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getSign$annotations(float r10) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(int r10) {
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void getSign$annotations(long r10) {
    }

    private static final double getUlp(double r10) {
        return Math.ulp(r10);
    }

    private static final float getUlp(float r10) {
        return Math.ulp(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(double r10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void getUlp$annotations(float r10) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double hypot(double r10, double r11) {
        return Math.hypot(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float hypot(float r10, float r11) {
        return (float) Math.hypot(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln(double r10) {
        return Math.log(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln(float r10) {
        return (float) Math.log(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double ln1p(double r10) {
        return Math.log1p(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float ln1p(float r10) {
        return (float) Math.log1p(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final double log(double r10, double r11) {
        if (r11 > 0.0d) goto L5;
        return Double.NaN;
    L5:
        if (r11 != 1.0d) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L11;
        return Double.NaN;
    L11:
        return Math.log(r10) / Math.log(r11);
    L7:
        r12 = false;
        goto L8
    }

    @SinceKotlin(version = "1.2")
    public static final float log(float r10, float r11) {
        if (r11 > 0.0f) goto L5;
        return Float.NaN;
    L5:
        if (r11 != 1.0f) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L11;
        return Float.NaN;
    L11:
        return (float) (Math.log(r10) / Math.log(r11));
    L7:
        r12 = false;
        goto L8
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double log10(double r10) {
        return Math.log10(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float log10(float r10) {
        return (float) Math.log10(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final double log2(double r10) {
        return Math.log(r10) / Constants.LN2;
    }

    @SinceKotlin(version = "1.2")
    public static final float log2(float r10) {
        return (float) (Math.log(r10) / Constants.LN2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double max(double r10, double r11) {
        return Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float max(float r10, float r11) {
        return Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int max(int r10, int r11) {
        return Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long max(long r10, long r11) {
        return Math.max(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double min(double r10, double r11) {
        return Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float min(float r10, float r11) {
        return Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int min(int r10, int r11) {
        return Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long min(long r10, long r11) {
        return Math.min(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextDown(double r10) {
        return Math.nextAfter(r10, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextDown(float r10) {
        return Math.nextAfter(r10, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextTowards(double r10, double r11) {
        return Math.nextAfter(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextTowards(float r10, float r11) {
        return Math.nextAfter(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double nextUp(double r10) {
        return Math.nextUp(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float nextUp(float r10) {
        return Math.nextUp(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double r10, double r11) {
        return Math.pow(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double pow(double r10, int r11) {
        return Math.pow(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float r10, float r11) {
        return (float) Math.pow(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float pow(float r10, int r11) {
        return (float) Math.pow(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double round(double r10) {
        return Math.rint(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float round(float r10) {
        return (float) Math.rint(r10);
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(double r10) {
        if (Double.isNaN(r10) == true) goto L13;
        if (r10 <= 2.147483647E9d) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r10 >= (-2.147483648E9d)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) Math.round(r10);
    L13:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    public static int roundToInt(float r10) {
        if (Float.isNaN(r10) == true) goto L7;
        return Math.round(r10);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    public static long roundToLong(double r10) {
        if (Double.isNaN(r10) == true) goto L7;
        return Math.round(r10);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    @SinceKotlin(version = "1.2")
    public static final long roundToLong(float r10) {
        return MathKt.roundToLong(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sign(double r10) {
        return Math.signum(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sign(float r10) {
        return Math.signum(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sin(double r10) {
        return Math.sin(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sin(float r10) {
        return (float) Math.sin(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sinh(double r10) {
        return Math.sinh(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sinh(float r10) {
        return (float) Math.sinh(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double sqrt(double r10) {
        return Math.sqrt(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float sqrt(float r10) {
        return (float) Math.sqrt(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tan(double r10) {
        return Math.tan(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tan(float r10) {
        return (float) Math.tan(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double tanh(double r10) {
        return Math.tanh(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float tanh(float r10) {
        return (float) Math.tanh(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final double truncate(double r10) {
        if (Double.isNaN(r10) == false) goto L5;
        return r10;
    L5:
        if (Double.isInfinite(r10) == false) goto L8;
        return r10;
    L8:
        if (r10 <= 0.0d) goto L11;
        return Math.floor(r10);
    L11:
        return Math.ceil(r10);
    }

    @SinceKotlin(version = "1.2")
    public static final float truncate(float r10) {
        if (Float.isNaN(r10) == false) goto L5;
        return r10;
    L5:
        if (Float.isInfinite(r10) == false) goto L8;
        return r10;
    L8:
        if (r10 <= 0.0f) goto L10;
        double r11 = Math.floor(r10);
    L12:
        return (float) r11;
    L10:
        r11 = Math.ceil(r10);
        goto L12
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double r10, double r11) {
        return Math.copySign(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double withSign(double r10, int r11) {
        return Math.copySign(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float r10, float r11) {
        return Math.copySign(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float withSign(float r10, int r11) {
        return Math.copySign(r10, r11);
    }
}
