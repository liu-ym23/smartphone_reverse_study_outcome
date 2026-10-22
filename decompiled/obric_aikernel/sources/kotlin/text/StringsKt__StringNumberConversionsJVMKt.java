package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n1#1,274:1\n265#1,7:275\n265#1,7:282\n265#1,7:289\n265#1,7:296\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n142#1:275,7\n149#1:282,7\n229#1:289,7\n240#1:296,7\n*E\n"})
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public StringsKt__StringNumberConversionsJVMKt() {
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String r10, Function1<? super String, ? extends T> r11) {
        if (ScreenFloatValueRegEx.value.matches(r10) == false) goto L11;
        return r11.invoke(r10);
    L11:
        return null;
    L12:
        return null;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new BigDecimal(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(String r10, MathContext r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "mathContext");
        return new BigDecimal(r10, r11);
    }

    @SinceKotlin(version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r10) == false) goto L11;
        return new BigDecimal(r10);
    L11:
        return null;
    L12:
        return null;
    }

    @SinceKotlin(version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(String r10, MathContext r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "mathContext");
        if (ScreenFloatValueRegEx.value.matches(r10) == false) goto L11;
        return new BigDecimal(r10, r11);
    L11:
        return null;
    L12:
        return null;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new BigInteger(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new BigInteger(r10, CharsKt.checkRadix(r11));
    }

    @SinceKotlin(version = "1.2")
    public static final BigInteger toBigIntegerOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toBigIntegerOrNull(r10, 10);
    }

    @SinceKotlin(version = "1.2")
    public static final BigInteger toBigIntegerOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CharsKt.checkRadix(r11);
        int r12 = r10.length();
        if (r12 == 0) goto L19;
        int r13 = 0;
        if (r12 == 1) goto L15;
        if (r10.charAt(0) != '-') goto L9;
        r13 = 1;
    L9:
        if (r13 >= r12) goto L18;
        if (CharsKt__CharJVMKt.digitOf(r10.charAt(r13), r11) < 0) goto L12;
        r13 = r13 + 1;
        goto L9
    L12:
        return null;
    L18:
        return new BigInteger(r10, CharsKt.checkRadix(r11));
    L15:
        if (CharsKt__CharJVMKt.digitOf(r10.charAt(0), r11) >= 0) goto L18;
        return null;
    L19:
        return null;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean toBoolean(String r10) {
        return Boolean.parseBoolean(r10);
    }

    @InlineOnly
    private static final byte toByte(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Byte.parseByte(r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte toByte(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Byte.parseByte(r10, CharsKt.checkRadix(r11));
    }

    @InlineOnly
    private static final double toDouble(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Double.parseDouble(r10);
    }

    @SinceKotlin(version = "1.1")
    public static final Double toDoubleOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r10) == false) goto L11;
        return Double.valueOf(Double.parseDouble(r10));
    L11:
        return null;
    L12:
        return null;
    }

    @InlineOnly
    private static final float toFloat(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Float.parseFloat(r10);
    }

    @SinceKotlin(version = "1.1")
    public static final Float toFloatOrNull(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r10) == false) goto L11;
        return Float.valueOf(Float.parseFloat(r10));
    L11:
        return null;
    L12:
        return null;
    }

    @InlineOnly
    private static final int toInt(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Integer.parseInt(r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int toInt(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Integer.parseInt(r10, CharsKt.checkRadix(r11));
    }

    @InlineOnly
    private static final long toLong(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Long.parseLong(r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long toLong(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Long.parseLong(r10, CharsKt.checkRadix(r11));
    }

    @InlineOnly
    private static final short toShort(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Short.parseShort(r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short toShort(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Short.parseShort(r10, CharsKt.checkRadix(r11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(byte r10, int r11) {
        String r12 = Integer.toString(r10, CharsKt.checkRadix(CharsKt.checkRadix(r11)));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        return r12;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(int r10, int r11) {
        String r12 = Integer.toString(r10, CharsKt.checkRadix(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        return r12;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(long r10, int r11) {
        String r12 = Long.toString(r10, CharsKt.checkRadix(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        return r12;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(short r10, int r11) {
        String r12 = Integer.toString(r10, CharsKt.checkRadix(CharsKt.checkRadix(r11)));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        return r12;
    }
}
