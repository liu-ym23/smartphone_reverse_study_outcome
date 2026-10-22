package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStringsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,805:1\n1174#2,2:806\n1#3:808\n1726#4,3:809\n*S KotlinDebug\n*F\n+ 1 StringsJVM.kt\nkotlin/text/StringsKt__StringsJVMKt\n*L\n73#1:806,2\n600#1:809,3\n*E\n"})
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public StringsKt__StringsJVMKt() {
    }

    @InlineOnly
    private static final String String(StringBuffer r10) {
        Intrinsics.checkNotNullParameter(r10, "stringBuffer");
        return new String(r10);
    }

    @InlineOnly
    private static final String String(StringBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "stringBuilder");
        return new String(r10);
    }

    @InlineOnly
    private static final String String(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        return new String(r10, Charsets.UTF_8);
    }

    @InlineOnly
    private static final String String(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        return new String(r10, r11, r12, Charsets.UTF_8);
    }

    @InlineOnly
    private static final String String(byte[] r10, int r11, int r12, Charset r13) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        Intrinsics.checkNotNullParameter(r13, "charset");
        return new String(r10, r11, r12, r13);
    }

    @InlineOnly
    private static final String String(byte[] r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        Intrinsics.checkNotNullParameter(r11, "charset");
        return new String(r10, r11);
    }

    @InlineOnly
    private static final String String(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "chars");
        return new String(r10);
    }

    @InlineOnly
    private static final String String(char[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "chars");
        return new String(r10, r11, r12);
    }

    @InlineOnly
    private static final String String(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "codePoints");
        return new String(r10, r11, r12);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Locale r11 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r11, "getDefault()");
        return capitalize(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String capitalize(String r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "locale");
        if (r10.length() <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L15;
        char r13 = r10.charAt(0);
        if (Character.isLowerCase(r13) == false) goto L16;
        StringBuilder r14 = new StringBuilder();
        char r15 = Character.toTitleCase(r13);
        if (r15 == Character.toUpperCase(r13)) goto L12;
        r14.append(r15);
    L13:
        String r16 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).substring(startIndex)");
        r14.append(r16);
        String r17 = r14.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "StringBuilder().apply(builderAction).toString()");
        return r17;
    L12:
        String r18 = r10.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type java.lang.String");
        String r19 = r18.toUpperCase(r11);
        Intrinsics.checkNotNullExpressionValue(r19, "this as java.lang.String).toUpperCase(locale)");
        r14.append(r19);
        goto L13
    L16:
        return r10;
    L15:
        return r10;
    L5:
        r12 = false;
        goto L6
    }

    @InlineOnly
    private static final int codePointAt(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.codePointAt(r11);
    }

    @InlineOnly
    private static final int codePointBefore(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.codePointBefore(r11);
    }

    @InlineOnly
    private static final int codePointCount(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.codePointCount(r11, r12);
    }

    public static final int compareTo(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        if (r12 == false) goto L7;
        return r10.compareToIgnoreCase(r11);
    L7:
        return r10.compareTo(r11);
    }

    public static /* synthetic */ int compareTo$default(String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return compareTo(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String concatToString(char[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new String(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String concatToString(char[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r11, r12, r10.length);
        return new String(r10, r11, r12 - r11);
    }

    public static /* synthetic */ String concatToString$default(char[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.length;
    L9:
        return StringsKt.concatToString(r10, r11, r12);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(CharSequence r10, CharSequence r11) {
        if ((r10 instanceof String) == false) goto L7;
        if (r11 == null) goto L7;
        return ((String) r10).contentEquals(r11);
    L7:
        return StringsKt__StringsKt.contentEqualsImpl(r10, r11);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean contentEquals(CharSequence r10, CharSequence r11, boolean r12) {
        if (r12 == false) goto L5;
        return StringsKt__StringsKt.contentEqualsIgnoreCaseImpl(r10, r11);
    L5:
        return contentEquals(r10, r11);
    }

    @InlineOnly
    private static final boolean contentEquals(String r10, CharSequence r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charSequence");
        return r10.contentEquals(r11);
    }

    @InlineOnly
    private static final boolean contentEquals(String r10, StringBuffer r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "stringBuilder");
        return r10.contentEquals(r11);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L8;
        return r10;
    L8:
        if (Character.isLowerCase(r10.charAt(0)) == true) goto L12;
        StringBuilder r12 = new StringBuilder();
        String r13 = r10.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.String");
        String r14 = r13.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toLowerCase()");
        r12.append(r14);
        String r15 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).substring(startIndex)");
        r12.append(r15);
        return r12.toString();
    L12:
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @LowPriorityInOverloadResolution
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String decapitalize(String r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "locale");
        if (r10.length() <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L8;
        return r10;
    L8:
        if (Character.isLowerCase(r10.charAt(0)) == true) goto L12;
        StringBuilder r13 = new StringBuilder();
        String r14 = r10.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        String r15 = r14.toLowerCase(r11);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toLowerCase(locale)");
        r13.append(r15);
        String r16 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).substring(startIndex)");
        r13.append(r16);
        return r13.toString();
    L12:
        return r10;
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static String decodeToString(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new String(r10, Charsets.UTF_8);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String decodeToString(byte[] r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r11, r12, r10.length);
        if (r13 == false) goto L5;
        String r14 = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r10, r11, r12 - r11)).toString();
        Intrinsics.checkNotNullExpressionValue(r14, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return r14;
    L5:
        return new String(r10, r11, r12 - r11, Charsets.UTF_8);
    }

    public static /* synthetic */ String decodeToString$default(byte[] r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.length;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = false;
    L12:
        return decodeToString(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte[] encodeToByteArray(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r11 = r10.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).getBytes(charset)");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte[] encodeToByteArray(String r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r11, r12, r10.length());
        if (r13 == true) goto L6;
        String r14 = r10.substring(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        Charset r15 = Charsets.UTF_8;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        byte[] r16 = r14.getBytes(r15);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).getBytes(charset)");
        return r16;
    L6:
        ByteBuffer r17 = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(r10, r11, r12));
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
        Intrinsics.checkNotNullExpressionValue(r21, "{\n        byteBuffer.array()\n    }");
        return r21;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = false;
    L12:
        return encodeToByteArray(r10, r11, r12, r13);
    }

    public static boolean endsWith(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "suffix");
        if (r12 == true) goto L7;
        return r10.endsWith(r11);
    L7:
        return StringsKt.regionMatches(r10, r10.length() - r11.length(), r11, 0, r11.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return StringsKt.endsWith(r10, r11, r12);
    }

    public static boolean equals(String r10, String r11, boolean r12) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        if (r12 == true) goto L10;
        return r10.equals(r11);
    L10:
        return r10.equalsIgnoreCase(r11);
    }

    public static /* synthetic */ boolean equals$default(String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return StringsKt.equals(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String format(String r10, Locale r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "args");
        String r13 = String.format(r11, r10, Arrays.copyOf(r12, r12.length));
        Intrinsics.checkNotNullExpressionValue(r13, "format(locale, this, *args)");
        return r13;
    }

    @InlineOnly
    private static final String format(String r10, Object... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "args");
        String r12 = String.format(r10, Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "format(this, *args)");
        return r12;
    }

    @InlineOnly
    private static final String format(StringCompanionObject r10, String r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        Intrinsics.checkNotNullParameter(r12, "args");
        String r13 = String.format(r11, Arrays.copyOf(r12, r12.length));
        Intrinsics.checkNotNullExpressionValue(r13, "format(format, *args)");
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final String format(StringCompanionObject r10, Locale r11, String r12, Object... r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "format");
        Intrinsics.checkNotNullParameter(r13, "args");
        String r14 = String.format(r11, r12, Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r14, "format(locale, format, *args)");
        return r14;
    }

    public static Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Comparator<String> r11 = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(r11, "CASE_INSENSITIVE_ORDER");
        return r11;
    }

    @InlineOnly
    private static final String intern(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.intern();
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).intern()");
        return r11;
    }

    public static boolean isBlank(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() == 0) goto L17;
        Iterable r11 = StringsKt.getIndices(r10);
        if ((r11 instanceof Collection) == true) goto L7;
    L9:
        Iterator r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L8;
        if (CharsKt.isWhitespace(r10.charAt(((IntIterator) r12).nextInt())) == true) goto L11;
        boolean r13 = false;
    L15:
        if (r13 == true) goto L17;
        return false;
    L8:
        r13 = true;
        goto L15
    L7:
        if (((Collection) r11).isEmpty() == false) goto L9;
    L17:
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String lowercase(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String lowercase(String r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "locale");
        String r12 = r10.toLowerCase(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toLowerCase(locale)");
        return r12;
    }

    @InlineOnly
    private static final int nativeIndexOf(String r10, char r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.indexOf(r11, r12);
    }

    @InlineOnly
    private static final int nativeIndexOf(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "str");
        return r10.indexOf(r11, r12);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(String r10, char r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.lastIndexOf(r11, r12);
    }

    @InlineOnly
    private static final int nativeLastIndexOf(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "str");
        return r10.lastIndexOf(r11, r12);
    }

    @InlineOnly
    private static final int offsetByCodePoints(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.offsetByCodePoints(r11, r12);
    }

    public static final boolean regionMatches(CharSequence r10, int r11, CharSequence r12, int r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "other");
        if ((r10 instanceof String) == false) goto L9;
        if ((r12 instanceof String) == false) goto L9;
        return StringsKt.regionMatches((String) r10, r11, (String) r12, r13, r14, r15);
    L9:
        return StringsKt__StringsKt.regionMatchesImpl(r10, r11, r12, r13, r14, r15);
    }

    public static boolean regionMatches(String r10, int r11, String r12, int r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "other");
        if (r15 == true) goto L6;
        return r10.regionMatches(r11, r12, r13, r14);
    L6:
        return r10.regionMatches(r15, r11, r12, r13, r14);
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence r10, int r11, CharSequence r12, int r13, int r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return regionMatches(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ boolean regionMatches$default(String r10, int r11, String r12, int r13, int r14, boolean r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = false;
    L6:
        return StringsKt.regionMatches(r10, r11, r12, r13, r14, r15);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static String repeat(CharSequence r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r12 = 0;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L25;
        if (r11 == 0) goto L28;
        if (r11 == 1) goto L23;
        int r14 = r10.length();
        if (r14 == 0) goto L29;
        if (r14 == 1) goto L18;
        StringBuilder r15 = new StringBuilder(r10.length() * r11);
        ?? r16 = new IntRange(1, r11).iterator2();
    L15:
        if (r16.hasNext() == false) goto L17;
        r16.nextInt();
        r15.append(r10);
        goto L15
    L17:
        String r17 = r15.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "{\n                    va…tring()\n                }");
        return r17;
    L18:
        char r18 = r10.charAt(0);
        char[] r19 = new char[r11];
    L19:
        if (r12 >= r11) goto L31;
        r19[r12] = r18;
        r12 = r12 + 1;
        goto L19
    L31:
        return new String(r19);
    L29:
        return "";
    L23:
        return r10.toString();
    L28:
        return "";
    L25:
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + r11 + '.').toString());
    L5:
        r13 = false;
        goto L6
    }

    public static final String replace(String r10, char r11, char r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r13 == true) goto L7;
        String r14 = r10.replace(r11, r12);
        String r15 = "this as java.lang.String…replace(oldChar, newChar)";
    L5:
        Intrinsics.checkNotNullExpressionValue(r14, r15);
        return r14;
    L7:
        StringBuilder r16 = new StringBuilder(r10.length());
        int r17 = 0;
    L9:
        if (r17 >= r10.length()) goto L14;
        char r18 = r10.charAt(r17);
        if (CharsKt__CharKt.equals(r18, r11, r13) == false) goto L13;
        r18 = r12;
    L13:
        r16.append(r18);
        r17 = r17 + 1;
        goto L9
    L14:
        r14 = r16.toString();
        r15 = "StringBuilder(capacity).…builderAction).toString()";
        goto L5
    }

    public static final String replace(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "oldValue");
        Intrinsics.checkNotNullParameter(r12, "newValue");
        int r14 = 0;
        int r15 = StringsKt__StringsKt.indexOf(r10, r11, 0, r13);
        if (r15 >= 0) goto L5;
        return r10;
    L5:
        int r16 = r11.length();
        int r17 = RangesKt.coerceAtLeast(r16, 1);
        int r18 = (r10.length() - r16) + r12.length();
        if (r18 < 0) goto L15;
        StringBuilder r19 = new StringBuilder(r18);
    L8:
        r19.append(r10, r14, r15);
        r19.append(r12);
        r14 = r15 + r16;
        if (r15 >= r10.length()) goto L12;
        r15 = StringsKt__StringsKt.indexOf(r10, r11, r15 + r17, r13);
        if (r15 > 0) goto L8;
    L12:
        r19.append(r10, r14, r10.length());
        String r20 = r19.toString();
        Intrinsics.checkNotNullExpressionValue(r20, "stringBuilder.append(this, i, length).toString()");
        return r20;
    L15:
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String replace$default(String r10, char r11, char r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return replace(r10, r11, r12, r13);
    }

    public static /* synthetic */ String replace$default(String r10, String r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return replace(r10, r11, r12, r13);
    }

    public static final String replaceFirst(String r10, char r11, char r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r14 = StringsKt.indexOf$default(r10, r11, 0, r13, 2, null);
        if (r14 >= 0) goto L6;
        return r10;
    L6:
        return StringsKt__StringsKt.replaceRange(r10, r14, r14 + 1, String.valueOf(r12)).toString();
    }

    public static final String replaceFirst(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "oldValue");
        Intrinsics.checkNotNullParameter(r12, "newValue");
        int r14 = StringsKt.indexOf$default(r10, r11, 0, r13, 2, null);
        if (r14 >= 0) goto L6;
        return r10;
    L6:
        return StringsKt__StringsKt.replaceRange(r10, r14, r11.length() + r14, r12).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String r10, char r11, char r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return replaceFirst(r10, r11, r12, r13);
    }

    public static /* synthetic */ String replaceFirst$default(String r10, String r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return replaceFirst(r10, r11, r12, r13);
    }

    public static final List<String> split(CharSequence r10, Pattern r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(r12);
        if (r12 != 0) goto L5;
        r12 = -1;
    L5:
        String[] r13 = r11.split(r10, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "regex.split(this, if (limit == 0) -1 else limit)");
        return ArraysKt.asList(r13);
    }

    public static /* synthetic */ List split$default(CharSequence r10, Pattern r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return split(r10, r11, r12);
    }

    public static boolean startsWith(String r10, String r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (r13 == true) goto L7;
        return r10.startsWith(r11, r12);
    L7:
        return StringsKt.regionMatches(r10, r12, r11, 0, r11.length(), r13);
    }

    public static boolean startsWith(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "prefix");
        if (r12 == true) goto L7;
        return r10.startsWith(r11);
    L7:
        return StringsKt.regionMatches(r10, 0, r11, 0, r11.length(), r12);
    }

    public static /* synthetic */ boolean startsWith$default(String r10, String r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r13 = false;
    L6:
        return StringsKt.startsWith(r10, r11, r12, r13);
    }

    public static /* synthetic */ boolean startsWith$default(String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return StringsKt.startsWith(r10, r11, r12);
    }

    @InlineOnly
    private static final String substring(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r12 = r10.substring(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).substring(startIndex)");
        return r12;
    }

    @InlineOnly
    private static final String substring(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r13 = r10.substring(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        return r13;
    }

    @InlineOnly
    private static final byte[] toByteArray(String r10, Charset r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        byte[] r12 = r10.getBytes(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).getBytes(charset)");
        return r12;
    }

    static /* synthetic */ byte[] toByteArray$default(String r10, Charset r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "charset");
        byte[] r14 = r10.getBytes(r11);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).getBytes(charset)");
        return r14;
    }

    @InlineOnly
    private static final char[] toCharArray(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        char[] r11 = r10.toCharArray();
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toCharArray()");
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char[] toCharArray(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r11, r12, r10.length());
        char[] r13 = new char[r12 - r11];
        r10.getChars(r11, r12, r13, 0);
        return r13;
    }

    @InlineOnly
    private static final char[] toCharArray(String r10, char[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        r10.getChars(r13, r14, r11, r12);
        return r11;
    }

    public static /* synthetic */ char[] toCharArray$default(String r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        return toCharArray(r10, r11, r12);
    }

    static /* synthetic */ char[] toCharArray$default(String r10, char[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = r10.length();
    L11:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        r10.getChars(r13, r14, r11, r12);
        return r11;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String toLowerCase(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toLowerCase()");
        return r11;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String toLowerCase(String r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "locale");
        String r12 = r10.toLowerCase(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toLowerCase(locale)");
        return r12;
    }

    @InlineOnly
    private static final Pattern toPattern(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Pattern r12 = Pattern.compile(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "compile(this, flags)");
        return r12;
    }

    static /* synthetic */ Pattern toPattern$default(String r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Pattern r14 = Pattern.compile(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r14, "compile(this, flags)");
        return r14;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String toUpperCase(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toUpperCase()");
        return r11;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final String toUpperCase(String r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "locale");
        String r12 = r10.toUpperCase(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toUpperCase(locale)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String uppercase(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String uppercase(String r10, Locale r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "locale");
        String r12 = r10.toUpperCase(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toUpperCase(locale)");
        return r12;
    }
}
