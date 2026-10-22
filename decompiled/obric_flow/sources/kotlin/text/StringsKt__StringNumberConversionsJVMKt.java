package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\u0082\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u000f\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0003H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u001b*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0010*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001e\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010!\u001a\u00020\"*\u00020\u0003H\u0087\b\u001a\u0015\u0010!\u001a\u00020\"*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020 2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b¨\u0006$"}, d2 = {"screenFloatValue", ExifInterface.GPS_DIRECTION_TRUE, "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n1#1,274:1\n265#1,7:275\n265#1,7:282\n265#1,7:289\n265#1,7:296\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n142#1:275,7\n149#1:282,7\n229#1:289,7\n240#1:296,7\n*E\n"})
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public StringsKt__StringNumberConversionsJVMKt() {
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String r5, Function1<? super String, ? extends T> r10) {
        if (ScreenFloatValueRegEx.value.matches(r5) == false) goto L10;
        return r10.invoke(r5);
    L10:
        return null;
    L11:
        return null;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new BigDecimal(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r5) == false) goto L11;
        return new BigDecimal(r5);
    L11:
        return null;
    L12:
        return null;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new BigInteger(r5);
    }

    @SinceKotlin(version = "1.2")
    public static final BigInteger toBigIntegerOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toBigIntegerOrNull(r5, 10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean toBoolean(String r5) {
        return Boolean.parseBoolean(r5);
    }

    @InlineOnly
    private static final byte toByte(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Byte.parseByte(r5);
    }

    @InlineOnly
    private static final double toDouble(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Double.parseDouble(r5);
    }

    @SinceKotlin(version = "1.1")
    public static Double toDoubleOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r5) == false) goto L10;
        return Double.valueOf(Double.parseDouble(r5));
    L10:
        return null;
    L11:
        return null;
    }

    @InlineOnly
    private static final float toFloat(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Float.parseFloat(r5);
    }

    @SinceKotlin(version = "1.1")
    public static Float toFloatOrNull(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r5) == false) goto L10;
        return Float.valueOf(Float.parseFloat(r5));
    L10:
        return null;
    L11:
        return null;
    }

    @InlineOnly
    private static final int toInt(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Integer.parseInt(r5);
    }

    @InlineOnly
    private static final long toLong(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Long.parseLong(r5);
    }

    @InlineOnly
    private static final short toShort(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Short.parseShort(r5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(byte r5, int r10) {
        return Integer.toString(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal toBigDecimal(String r5, MathContext r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "mathContext");
        return new BigDecimal(r5, r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger toBigInteger(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new BigInteger(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.2")
    public static final BigInteger toBigIntegerOrNull(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CharsKt__CharJVMKt.checkRadix(r11);
        int r5 = r10.length();
        if (r5 == 0) goto L19;
        int r12 = 0;
        if (r5 == 1) goto L15;
        if (r10.charAt(0) != '-') goto L9;
        r12 = 1;
    L9:
        if (r12 >= r5) goto L18;
        if (CharsKt__CharJVMKt.digitOf(r10.charAt(r12), r11) < 0) goto L12;
        r12 = r12 + 1;
        goto L9
    L12:
        return null;
    L18:
        return new BigInteger(r10, CharsKt__CharJVMKt.checkRadix(r11));
    L15:
        if (CharsKt__CharJVMKt.digitOf(r10.charAt(0), r11) >= 0) goto L18;
        return null;
    L19:
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte toByte(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Byte.parseByte(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int toInt(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Integer.parseInt(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long toLong(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Long.parseLong(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short toShort(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Short.parseShort(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(short r5, int r10) {
        return Integer.toString(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(int r5, int r10) {
        return Integer.toString(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }

    @SinceKotlin(version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(String r5, MathContext r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "mathContext");
        if (ScreenFloatValueRegEx.value.matches(r5) == false) goto L11;
        return new BigDecimal(r5, r10);
    L11:
        return null;
    L12:
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(long r5, int r10) {
        return Long.toString(r5, CharsKt__CharJVMKt.checkRadix(r10));
    }
}
