package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a\f\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'H\u0087\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0087\b\u001a\f\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u00100\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00105\u001a<\u00100\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00106\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00107\u001a\r\u00108\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010@\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\u0087\b\u001a4\u0010B\u001a\u00020#*\u00020'2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010B\u001a\u00020#*\u00020\u00022\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020'2\u0006\u0010F\u001a\u00020\u0011\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020N*\u00020'2\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u0011\u001a\u001c\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u0017\u0010U\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\r\u0010V\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a3\u0010V\u001a\u00020\u0014*\u00020\u00022\u0006\u0010W\u001a\u00020\u00142\b\b\u0002\u0010X\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a \u0010V\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010Y\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u0017\u0010Z\u001a\u00020P*\u00020\u00022\b\b\u0002\u0010[\u001a\u00020\u0011H\u0087\b\u001a\r\u0010\\\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\r\u0010]\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010]\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006^"}, d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nStringsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,818:1\n1179#2,2:819\n1#3:821\n*S KotlinDebug\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n*L\n73#1:819,2\n*E\n"})
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public StringsKt__StringsJVMKt() {
    }

    @InlineOnly
    private static final String String(byte[] r5, int r10, int r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        Intrinsics.checkNotNullParameter(r12, "charset");
        return new String(r5, r10, r11, r12);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return capitalize(r5, Locale.getDefault());
    }

    @InlineOnly
    private static final int codePointAt(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.codePointAt(r10);
    }

    @InlineOnly
    private static final int codePointBefore(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.codePointBefore(r10);
    }

    @InlineOnly
    private static final int codePointCount(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.codePointCount(r10, r11);
    }

    public static final int compareTo(String r5, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        if (r11 == false) goto L7;
        return r5.compareToIgnoreCase(r10);
    L7:
        return r5.compareTo(r10);
    }

    public static /* synthetic */ int compareTo$default(String r5, String r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return compareTo(r5, r10, r11);
    }

    @SinceKotlin(version = "1.4")
    public static final String concatToString(char[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new String(r5);
    }

    public static /* synthetic */ String concatToString$default(char[] r5, int r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.length;
    L9:
        return concatToString(r5, r10, r11);
    }

    @InlineOnly
    private static final boolean contentEquals(String r5, CharSequence r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charSequence");
        return r5.contentEquals(r10);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        if (Character.isLowerCase(r5.charAt(0)) == true) goto L9;
        StringBuilder r10 = new StringBuilder();
        String r11 = r5.substring(0, 1);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.lang.String");
        r10.append(r11.toLowerCase());
        r10.append(r5.substring(1));
        return r10.toString();
    L9:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static String decodeToString(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new String(r5, Charsets.UTF_8);
    }

    public static /* synthetic */ String decodeToString$default(byte[] r5, int r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.length;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = false;
    L12:
        return decodeToString(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    public static final byte[] encodeToByteArray(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getBytes(Charsets.UTF_8);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String r5, int r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = false;
    L12:
        return encodeToByteArray(r5, r10, r11, r12);
    }

    public static boolean endsWith(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        if (r12 == true) goto L7;
        return r10.endsWith(r11);
    L7:
        return regionMatches(r10, r10.length() - r11.length(), r11, 0, r11.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String r5, String r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return endsWith(r5, r10, r11);
    }

    public static boolean equals(String r5, String r10, boolean r11) {
        if (r5 != null) goto L7;
        if (r10 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        if (r11 == true) goto L10;
        return r5.equals(r10);
    L10:
        return r5.equalsIgnoreCase(r10);
    }

    public static /* synthetic */ boolean equals$default(String r5, String r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return equals(r5, r10, r11);
    }

    @InlineOnly
    private static final String format(String r5, Object... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "args");
        return String.format(r5, Arrays.copyOf(r10, r10.length));
    }

    public static Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return String.CASE_INSENSITIVE_ORDER;
    }

    @InlineOnly
    private static final String intern(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.intern();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String lowercase(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.toLowerCase(Locale.ROOT);
    }

    @InlineOnly
    private static final int nativeIndexOf(String r5, char r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.indexOf(r10, r11);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(String r5, char r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.lastIndexOf(r10, r11);
    }

    @InlineOnly
    private static final int offsetByCodePoints(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.offsetByCodePoints(r10, r11);
    }

    public static final boolean regionMatches(CharSequence r10, int r11, CharSequence r12, int r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "other");
        if ((r10 instanceof String) == false) goto L9;
        if ((r12 instanceof String) == false) goto L9;
        return regionMatches((String) r10, r11, (String) r12, r13, r14, r15);
    L9:
        return StringsKt__StringsKt.regionMatchesImpl(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence r10, int r11, CharSequence r12, int r13, int r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return regionMatches(r10, r11, r12, r13, r14, r15);
    }

    public static String repeat(CharSequence r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 < 0) goto L24;
        if (r10 == 0) goto L27;
        int r11 = 1;
        if (r10 == 1) goto L22;
        int r12 = r5.length();
        if (r12 == 0) goto L28;
        if (r12 == 1) goto L17;
        StringBuilder r13 = new StringBuilder(r5.length() * r10);
        if (1 > r10) goto L16;
    L13:
        r13.append(r5);
        if (r11 == r10) goto L16;
        r11 = r11 + 1;
    L16:
        String r14 = r13.toString();
        Intrinsics.checkNotNull(r14);
        return r14;
    L17:
        int r15 = 0;
        char r16 = r5.charAt(0);
        char[] r17 = new char[r10];
    L18:
        if (r15 >= r10) goto L30;
        r17[r15] = r16;
        r15 = r15 + 1;
        goto L18
    L30:
        return new String(r17);
    L28:
        return "";
    L22:
        return r5.toString();
    L27:
        return "";
    L24:
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + r10 + '.').toString());
    }

    public static final String replace(String r5, char r10, char r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r12 == false) goto L5;
        StringBuilder r13 = new StringBuilder(r5.length());
        int r14 = 0;
    L8:
        if (r14 >= r5.length()) goto L14;
        char r15 = r5.charAt(r14);
        if (CharsKt__CharKt.equals(r15, r10, r12) == false) goto L12;
        r15 = r11;
    L12:
        r13.append(r15);
        r14 = r14 + 1;
        goto L8
    L14:
        return r13.toString();
    L5:
        return r5.replace(r10, r11);
    }

    public static /* synthetic */ String replace$default(String r5, char r10, char r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return replace(r5, r10, r11, r12);
    }

    public static final String replaceFirst(String r10, char r11, char r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r14 = StringsKt__StringsKt.indexOf$default(r10, r11, 0, r13, 2, null);
        if (r14 >= 0) goto L6;
        return r10;
    L6:
        return StringsKt__StringsKt.replaceRange(r10, r14, r14 + 1, String.valueOf(r12)).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String r5, char r10, char r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return replaceFirst(r5, r10, r11, r12);
    }

    public static final List<String> split(CharSequence r5, Pattern r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(r11);
        if (r11 != 0) goto L6;
        r11 = -1;
    L6:
        return ArraysKt.asList(r10.split(r5, r11));
    }

    public static /* synthetic */ List split$default(CharSequence r5, Pattern r10, int r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        return split(r5, r10, r11);
    }

    public static boolean startsWith(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (r12 == true) goto L7;
        return r10.startsWith(r11);
    L7:
        return regionMatches(r10, 0, r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean startsWith$default(String r5, String r10, boolean r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        return startsWith(r5, r10, r11);
    }

    @InlineOnly
    private static final String substring(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.substring(r10);
    }

    @InlineOnly
    private static final byte[] toByteArray(String r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return r5.getBytes(r10);
    }

    public static /* synthetic */ byte[] toByteArray$default(String r5, Charset r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return r5.getBytes(r10);
    }

    @SinceKotlin(version = "1.4")
    public static final char[] toCharArray(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r5.length());
        char[] r12 = new char[r11 - r10];
        r5.getChars(r10, r11, r12, 0);
        return r12;
    }

    public static /* synthetic */ char[] toCharArray$default(String r5, int r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        return toCharArray(r5, r10, r11);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String toLowerCase(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.toLowerCase();
    }

    @InlineOnly
    private static final Pattern toPattern(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Pattern.compile(r5, r10);
    }

    public static /* synthetic */ Pattern toPattern$default(String r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Pattern.compile(r5, r10);
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String toUpperCase(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.toUpperCase();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String uppercase(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.toUpperCase(Locale.ROOT);
    }

    @InlineOnly
    private static final String String(byte[] r5, Charset r10) {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        Intrinsics.checkNotNullParameter(r10, "charset");
        return new String(r5, r10);
    }

    @SinceKotlin(version = "1.4")
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "locale");
        if (r5.length() <= 0) goto L12;
        char r11 = r5.charAt(0);
        if (Character.isLowerCase(r11) == false) goto L13;
        StringBuilder r12 = new StringBuilder();
        char r13 = Character.toTitleCase(r11);
        if (r13 == Character.toUpperCase(r11)) goto L9;
        r12.append(r13);
    L10:
        r12.append(r5.substring(1));
        return r12.toString();
    L9:
        String r14 = r5.substring(0, 1);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        r12.append(r14.toUpperCase(r10));
        goto L10
    L13:
        return r5;
    L12:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final String concatToString(char[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r5.length);
        return new String(r5, r10, r11 - r10);
    }

    @InlineOnly
    private static final boolean contentEquals(String r5, StringBuffer r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "stringBuilder");
        return r5.contentEquals(r10);
    }

    @SinceKotlin(version = "1.4")
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "locale");
        if (r5.length() > 0) goto L5;
        return r5;
    L5:
        if (Character.isLowerCase(r5.charAt(0)) == true) goto L9;
        StringBuilder r11 = new StringBuilder();
        String r12 = r5.substring(0, 1);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.lang.String");
        r11.append(r12.toLowerCase(r10));
        r11.append(r5.substring(1));
        return r11.toString();
    L9:
        return r5;
    }

    @SinceKotlin(version = "1.4")
    public static final String decodeToString(byte[] r5, int r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r5.length);
        if (r12 == false) goto L5;
        CharsetDecoder r13 = Charsets.UTF_8.newDecoder();
        CodingErrorAction r14 = CodingErrorAction.REPORT;
        return r13.onMalformedInput(r14).onUnmappableCharacter(r14).decode(ByteBuffer.wrap(r5, r10, r11 - r10)).toString();
    L5:
        return new String(r5, r10, r11 - r10, Charsets.UTF_8);
    }

    @SinceKotlin(version = "1.4")
    public static final byte[] encodeToByteArray(String r5, int r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r5.length());
        if (r12 == true) goto L6;
        String r13 = r5.substring(r10, r11);
        Charset r14 = Charsets.UTF_8;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.String");
        return r13.getBytes(r14);
    L6:
        CharsetEncoder r15 = Charsets.UTF_8.newEncoder();
        CodingErrorAction r16 = CodingErrorAction.REPORT;
        ByteBuffer r17 = r15.onMalformedInput(r16).onUnmappableCharacter(r16).encode(CharBuffer.wrap(r5, r10, r11));
        if (r17.hasArray() == true) goto L9;
    L13:
        byte[] r18 = new byte[r17.remaining()];
        r17.get(r18);
        return r18;
    L9:
        if (r17.arrayOffset() != 0) goto L13;
        int r19 = r17.remaining();
        byte[] r20 = r17.array();
        Intrinsics.checkNotNull(r20);
        if (r19 != r20.length) goto L13;
        byte[] r21 = r17.array();
        Intrinsics.checkNotNull(r21);
        return r21;
    }

    @InlineOnly
    private static final String format(StringCompanionObject r5, String r10, Object... r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        Intrinsics.checkNotNullParameter(r11, "args");
        return String.format(r10, Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String lowercase(String r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "locale");
        return r5.toLowerCase(r10);
    }

    @InlineOnly
    private static final int nativeIndexOf(String r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "str");
        return r5.indexOf(r10, r11);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(String r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "str");
        return r5.lastIndexOf(r10, r11);
    }

    public static /* synthetic */ boolean regionMatches$default(String r10, int r11, String r12, int r13, int r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return regionMatches(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ String replace$default(String r5, String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return replace(r5, r10, r11, r12);
    }

    public static /* synthetic */ String replaceFirst$default(String r5, String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return replaceFirst(r5, r10, r11, r12);
    }

    public static /* synthetic */ boolean startsWith$default(String r5, String r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = false;
    L6:
        return startsWith(r5, r10, r11, r12);
    }

    @InlineOnly
    private static final String substring(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.substring(r10, r11);
    }

    public static /* synthetic */ char[] toCharArray$default(String r5, char[] r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = r5.length();
    L11:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "destination");
        r5.getChars(r12, r13, r10, r11);
        return r10;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String toLowerCase(String r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "locale");
        return r5.toLowerCase(r10);
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String toUpperCase(String r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "locale");
        return r5.toUpperCase(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String uppercase(String r5, Locale r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "locale");
        return r5.toUpperCase(r10);
    }

    @InlineOnly
    private static final String String(byte[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        return new String(r5, r10, r11, Charsets.UTF_8);
    }

    @SinceKotlin(version = "1.5")
    public static boolean contentEquals(CharSequence r5, CharSequence r10) {
        if ((r5 instanceof String) == false) goto L7;
        if (r10 == null) goto L7;
        return ((String) r5).contentEquals(r10);
    L7:
        return StringsKt__StringsKt.contentEqualsImpl(r5, r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String format(String r5, Locale r10, Object... r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "args");
        return String.format(r10, r5, Arrays.copyOf(r11, r11.length));
    }

    public static final String replaceFirst(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "oldValue");
        Intrinsics.checkNotNullParameter(r12, "newValue");
        int r14 = StringsKt__StringsKt.indexOf$default(r10, r11, 0, r13, 2, null);
        if (r14 >= 0) goto L6;
        return r10;
    L6:
        return StringsKt__StringsKt.replaceRange(r10, r14, r11.length() + r14, r12).toString();
    }

    public static boolean startsWith(String r10, String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (r13 == true) goto L7;
        return r10.startsWith(r11, r12);
    L7:
        return regionMatches(r10, r12, r11, 0, r11.length(), r13);
    }

    @InlineOnly
    private static final char[] toCharArray(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.toCharArray();
    }

    @InlineOnly
    private static final String String(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "bytes");
        return new String(r5, Charsets.UTF_8);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String format(StringCompanionObject r5, Locale r10, String r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        Intrinsics.checkNotNullParameter(r12, "args");
        return String.format(r10, r11, Arrays.copyOf(r12, r12.length));
    }

    public static boolean regionMatches(String r10, int r11, String r12, int r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "other");
        if (r15 == true) goto L6;
        return r10.regionMatches(r11, r12, r13, r14);
    L6:
        return r10.regionMatches(r15, r11, r12, r13, r14);
    }

    @InlineOnly
    private static final char[] toCharArray(String r5, char[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "destination");
        r5.getChars(r12, r13, r10, r11);
        return r10;
    }

    @InlineOnly
    private static final String String(char[] r5) {
        Intrinsics.checkNotNullParameter(r5, "chars");
        return new String(r5);
    }

    @InlineOnly
    private static final String String(char[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "chars");
        return new String(r5, r10, r11);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(CharSequence r5, CharSequence r10, boolean r11) {
        if (r11 == false) goto L5;
        return StringsKt__StringsKt.contentEqualsIgnoreCaseImpl(r5, r10);
    L5:
        return contentEquals(r5, r10);
    }

    public static final String replace(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "oldValue");
        Intrinsics.checkNotNullParameter(r12, "newValue");
        int r5 = 0;
        int r14 = StringsKt__StringsKt.indexOf(r10, r11, 0, r13);
        if (r14 >= 0) goto L5;
        return r10;
    L5:
        int r15 = r11.length();
        int r16 = RangesKt.coerceAtLeast(r15, 1);
        int r17 = r10.length() - r15;
        int r18 = r12.length() + r17;
        if (r18 < 0) goto L15;
        StringBuilder r19 = new StringBuilder(r18);
    L8:
        r19.append(r10, r5, r14);
        r19.append(r12);
        r5 = r14 + r15;
        if (r14 >= r10.length()) goto L12;
        r14 = StringsKt__StringsKt.indexOf(r10, r11, r14 + r16, r13);
        if (r14 > 0) goto L8;
    L12:
        r19.append(r10, r5, r10.length());
        return r19.toString();
    L15:
        throw new OutOfMemoryError();
    }

    @InlineOnly
    private static final String String(int[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "codePoints");
        return new String(r5, r10, r11);
    }

    @InlineOnly
    private static final String String(StringBuffer r5) {
        Intrinsics.checkNotNullParameter(r5, "stringBuffer");
        return new String(r5);
    }

    @InlineOnly
    private static final String String(StringBuilder r5) {
        Intrinsics.checkNotNullParameter(r5, "stringBuilder");
        return new String(r5);
    }
}
