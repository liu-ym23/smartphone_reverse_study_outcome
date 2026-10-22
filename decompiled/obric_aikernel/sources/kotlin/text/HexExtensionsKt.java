package kotlin.text;

import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,594:1\n1#2:595\n1183#3,3:596\n1183#3,3:599\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n16#1:596,3\n17#1:599,3\n*E\n"})
public final class HexExtensionsKt {
    private static final int[] HEX_DIGITS_TO_DECIMAL = null;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] r10 = new int[128];
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= 128) goto L5;
        r10[r12] = -1;
        r12 = r12 + 1;
        goto L3
    L5:
        int r13 = 0;
        int r14 = 0;
    L7:
        if (r13 >= LOWER_CASE_HEX_DIGITS.length()) goto L9;
        r10[LOWER_CASE_HEX_DIGITS.charAt(r13)] = r14;
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L7
    L9:
        int r15 = 0;
    L11:
        if (r11 >= UPPER_CASE_HEX_DIGITS.length()) goto L13;
        r10[UPPER_CASE_HEX_DIGITS.charAt(r11)] = r15;
        r11 = r11 + 1;
        r15 = r15 + 1;
        goto L11
    L13:
        HEX_DIGITS_TO_DECIMAL = r10;
    }

    private static final long charsPerSet(long r10, int r11, int r12) {
        if (r11 <= 0) goto L4;
        boolean r13 = true;
    L5:
        if (r13 == false) goto L9;
        long r14 = r11;
        return (r10 * r14) + (((long) r12) * (r14 - 1));
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r13 = false;
        goto L5
    }

    private static final int checkContainsAt(String r10, String r11, int r12, int r13, String r14) {
        int r15 = r11.length() + r12;
        if (r15 <= r13) goto L5;
    L7:
        StringBuilder r16 = new StringBuilder();
        r16.append("Expected ");
        r16.append(r14);
        r16.append(" \"");
        r16.append(r11);
        r16.append("\" at index ");
        r16.append(r12);
        r16.append(", but was ");
        int r17 = RangesKt.coerceAtMost(r15, r13);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.String");
        String r18 = r10.substring(r12, r17);
        Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String…ing(startIndex, endIndex)");
        r16.append(r18);
        throw new NumberFormatException(r16.toString());
    L5:
        if (StringsKt.regionMatches(r10, r12, r11, 0, r11.length(), true) == false) goto L7;
        return r15;
    }

    private static final void checkHexLength(String r10, int r11, int r12, int r13, boolean r14) {
        int r15 = r12 - r11;
        boolean r16 = true;
        if (r14 == false) goto L6;
        if (r15 == r13) goto L9;
    L8:
        r16 = false;
    L9:
        if (r16 == true) goto L15;
        if (r14 == false) goto L12;
        String r17 = "exactly";
    L13:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.String");
        String r18 = r10.substring(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String…ing(startIndex, endIndex)");
        throw new NumberFormatException("Expected " + r17 + ' ' + r13 + " hexadecimal digits at index " + r11 + ", but was " + r18 + " of length " + r15);
    L12:
        r17 = "at most";
        goto L13
    L15:
        return;
    L6:
        if (r15 > r13) goto L8;
        goto L8
    }

    private static final int checkNewLineAt(String r10, int r11, int r12) {
        if (r10.charAt(r11) != '\r') goto L10;
        int r13 = r11 + 1;
        if (r13 < r12) goto L7;
        return r13;
    L7:
        if (r10.charAt(r13) == '\n') goto L17;
        return r13;
    L17:
        return r11 + 2;
    L10:
        if (r10.charAt(r11) != '\n') goto L14;
        return r11 + 1;
    L14:
        throw new NumberFormatException("Expected a new line at index " + r11 + ", but was " + r10.charAt(r11));
    }

    private static final int decimalFromHexDigitAt(String r10, int r11) {
        char r12 = r10.charAt(r11);
        if (r12 > 127) goto L9;
        int[] r13 = HEX_DIGITS_TO_DECIMAL;
        if (r13[r12] < 0) goto L9;
        return r13[r12];
    L9:
        throw new NumberFormatException("Expected a hexadecimal digit at index " + r11 + ", but was " + r10.charAt(r11));
    }

    public static final int formattedStringLength(int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        if (r10 <= 0) goto L5;
        boolean r17 = true;
    L6:
        if (r17 == false) goto L18;
        int r18 = r10 - 1;
        int r19 = r18 / r11;
        int r20 = (r11 - 1) / r12;
        int r21 = r10 % r11;
        if (r21 == 0) goto L11;
        r11 = r21;
    L11:
        int r22 = (r20 * r19) + ((r11 - 1) / r12);
        long r23 = ((((long) r19) + (((long) r22) * ((long) r13))) + (((long) ((r18 - r19) - r22)) * ((long) r14))) + (((long) r10) * ((((long) r15) + 2) + ((long) r16)));
        if (RangesKt.intRangeContains(new IntRange(0, Integer.MAX_VALUE), r23) == false) goto L16;
        return (int) r23;
    L16:
        throw new IllegalArgumentException("The resulting string length is too big: " + ULong.m252toStringimpl(ULong.m206constructorimpl(r23)));
    L18:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r17 = false;
        goto L6
    }

    private static /* synthetic */ void getHEX_DIGITS_TO_DECIMAL$annotations() {
    }

    @ExperimentalStdlibApi
    private static final byte hexToByte(String r10, int r11, int r12, HexFormat r13) {
        return (byte) hexToLongImpl(r10, r11, r12, r13, 2);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte hexToByte(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return hexToByte(r10, 0, r10.length(), r11);
    }

    static /* synthetic */ byte hexToByte$default(String r10, int r11, int r12, HexFormat r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = HexFormat.Companion.getDefault();
    L12:
        return hexToByte(r10, r11, r12, r13);
    }

    public static /* synthetic */ byte hexToByte$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return hexToByte(r10, r11);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArray(String r17, int r18, int r19, HexFormat r20) {
        int r10 = r18;
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r19, r17.length());
        if (r10 == r19) goto L5;
        HexFormat.BytesHexFormat r11 = r20.getBytes();
        int r12 = r11.getBytesPerLine();
        int r13 = r11.getBytesPerGroup();
        String r14 = r11.getBytePrefix();
        String r15 = r11.getByteSuffix();
        String r16 = r11.getByteSeparator();
        String r21 = r11.getGroupSeparator();
        String r22 = r16;
        int r23 = parsedByteArrayMaxSize(r19 - r10, r12, r13, r21.length(), r16.length(), r14.length(), r15.length());
        byte[] r24 = new byte[r23];
        int r25 = 0;
        int r26 = 0;
        int r27 = 0;
    L7:
        if (r10 >= r19) goto L16;
        if (r26 != r12) goto L11;
        r10 = checkNewLineAt(r17, r10, r19);
        r26 = 0;
    L10:
        r27 = 0;
    L15:
        r26 = r26 + 1;
        r27 = r27 + 1;
        int r28 = checkContainsAt(r17, r14, r10, r19, "byte prefix");
        String r110 = r22;
        checkHexLength(r17, r28, RangesKt.coerceAtMost(r28 + 2, r19), 2, true);
        int r111 = r28 + 1;
        int r112 = r111 + 1;
        r24[r25] = (byte) ((decimalFromHexDigitAt(r17, r28) << 4) | decimalFromHexDigitAt(r17, r111));
        r10 = checkContainsAt(r17, r15, r112, r19, "byte suffix");
        r25 = r25 + 1;
        r22 = r110;
        goto L7
    L11:
        if (r27 != r13) goto L13;
        r10 = checkContainsAt(r17, r21, r10, r19, "group separator");
        goto L10
    L13:
        if (r27 == 0) goto L15;
        r10 = checkContainsAt(r17, r22, r10, r19, "byte separator");
        goto L15
    L16:
        if (r25 == r23) goto L24;
        byte[] r29 = Arrays.copyOf(r24, r25);
        Intrinsics.checkNotNullExpressionValue(r29, "copyOf(this, newSize)");
        return r29;
    L24:
        return r24;
    L5:
        return new byte[0];
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte[] hexToByteArray(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return hexToByteArray(r10, 0, r10.length(), r11);
    }

    static /* synthetic */ byte[] hexToByteArray$default(String r10, int r11, int r12, HexFormat r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = HexFormat.Companion.getDefault();
    L12:
        return hexToByteArray(r10, r11, r12, r13);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return hexToByteArray(r10, r11);
    }

    @ExperimentalStdlibApi
    private static final int hexToInt(String r10, int r11, int r12, HexFormat r13) {
        return (int) hexToLongImpl(r10, r11, r12, r13, 8);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final int hexToInt(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return hexToInt(r10, 0, r10.length(), r11);
    }

    static /* synthetic */ int hexToInt$default(String r10, int r11, int r12, HexFormat r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = HexFormat.Companion.getDefault();
    L12:
        return hexToInt(r10, r11, r12, r13);
    }

    public static /* synthetic */ int hexToInt$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return hexToInt(r10, r11);
    }

    @ExperimentalStdlibApi
    private static final long hexToLong(String r10, int r11, int r12, HexFormat r13) {
        return hexToLongImpl(r10, r11, r12, r13, 16);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final long hexToLong(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return hexToLong(r10, 0, r10.length(), r11);
    }

    static /* synthetic */ long hexToLong$default(String r10, int r11, int r12, HexFormat r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = HexFormat.Companion.getDefault();
    L12:
        return hexToLong(r10, r11, r12, r13);
    }

    public static /* synthetic */ long hexToLong$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return hexToLong(r10, r11);
    }

    @ExperimentalStdlibApi
    private static final long hexToLongImpl(String r10, int r11, int r12, HexFormat r13, int r14) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r11, r12, r10.length());
        String r15 = r13.getNumber().getPrefix();
        String r16 = r13.getNumber().getSuffix();
        if ((r15.length() + r16.length()) >= (r12 - r11)) goto L8;
        int r17 = checkContainsAt(r10, r15, r11, r12, "prefix");
        int r18 = r12 - r16.length();
        checkContainsAt(r10, r16, r18, r12, "suffix");
        checkHexLength(r10, r17, r18, r14, false);
        long r19 = 0;
    L5:
        if (r17 >= r18) goto L7;
        r19 = (r19 << 4) | ((long) decimalFromHexDigitAt(r10, r17));
        r17 = r17 + 1;
        goto L5
    L7:
        return r19;
    L8:
        StringBuilder r20 = new StringBuilder();
        r20.append("Expected a hexadecimal number with prefix \"");
        r20.append(r15);
        r20.append("\" and suffix \"");
        r20.append(r16);
        r20.append("\", but was ");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.String");
        String r21 = r10.substring(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r21, "this as java.lang.String…ing(startIndex, endIndex)");
        r20.append(r21);
        throw new NumberFormatException(r20.toString());
    }

    static /* synthetic */ long hexToLongImpl$default(String r10, int r11, int r12, HexFormat r13, int r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        return hexToLongImpl(r10, r11, r12, r13, r14);
    }

    @ExperimentalStdlibApi
    private static final short hexToShort(String r10, int r11, int r12, HexFormat r13) {
        return (short) hexToLongImpl(r10, r11, r12, r13, 4);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final short hexToShort(String r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return hexToShort(r10, 0, r10.length(), r11);
    }

    static /* synthetic */ short hexToShort$default(String r10, int r11, int r12, HexFormat r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = HexFormat.Companion.getDefault();
    L12:
        return hexToShort(r10, r11, r12, r13);
    }

    public static /* synthetic */ short hexToShort$default(String r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return hexToShort(r10, r11);
    }

    public static final int parsedByteArrayMaxSize(int r19, int r20, int r21, int r22, int r23, int r24, int r25) {
        if (r19 <= 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L20;
        long r11 = (((long) r24) + 2) + ((long) r25);
        long r12 = charsPerSet(r11, r21, r23);
        if (r20 > r21) goto L10;
        long r13 = charsPerSet(r11, r20, r23);
    L13:
        long r14 = r19;
        long r15 = wholeElementsPerSet(r14, r13, 1);
        long r16 = r14 - ((r13 + 1) * r15);
        long r17 = wholeElementsPerSet(r16, r12, r22);
        long r18 = r16 - ((r12 + ((long) r22)) * r17);
        long r26 = wholeElementsPerSet(r18, r11, r23);
        if ((r18 - ((r11 + ((long) r23)) * r26)) <= 0) goto L16;
        int r27 = 1;
    L18:
        return (int) (r27 + (((r15 * ((long) r20)) + (r17 * ((long) r21))) + r26));
    L16:
        r27 = 0;
        goto L18
    L10:
        r13 = charsPerSet(r12, r20 / r21, r22);
        int r110 = r20 % r21;
        if (r110 == 0) goto L13;
        r13 = (r13 + ((long) r22)) + charsPerSet(r11, r110, r23);
        goto L13
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r10 = false;
        goto L6
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        return toHexStringImpl(r10, r11, 8);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(int r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        return toHexStringImpl(r10, r11, 32);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(long r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        return toHexStringImpl(r10, r11, 64);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(short r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        return toHexStringImpl(r10, r11, 16);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte[] r17, int r18, int r19, HexFormat r20) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r20, "format");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r18, r19, r17.length);
        if (r18 != r19) goto L7;
        return "";
    L7:
        if (r20.getUpperCase() == false) goto L9;
        String r10 = UPPER_CASE_HEX_DIGITS;
    L10:
        HexFormat.BytesHexFormat r11 = r20.getBytes();
        int r12 = r11.getBytesPerLine();
        int r13 = r11.getBytesPerGroup();
        String r14 = r11.getBytePrefix();
        String r15 = r11.getByteSuffix();
        String r16 = r11.getByteSeparator();
        String r21 = r11.getGroupSeparator();
        int r22 = formattedStringLength(r19 - r18, r12, r13, r21.length(), r16.length(), r14.length(), r15.length());
        StringBuilder r23 = new StringBuilder(r22);
        int r24 = r18;
        int r25 = 0;
        int r110 = 0;
    L11:
        if (r24 >= r19) goto L21;
        int r26 = r17[r24] & 255;
        if (r25 != r12) goto L16;
        r23.append('\n');
        r25 = 0;
    L15:
        r110 = 0;
    L18:
        if (r110 == 0) goto L20;
        r23.append(r16);
    L20:
        r23.append(r14);
        r23.append(r10.charAt(r26 >> 4));
        r23.append(r10.charAt(r26 & 15));
        r23.append(r15);
        r110 = r110 + 1;
        r25 = r25 + 1;
        r24 = r24 + 1;
        goto L11
    L16:
        if (r110 != r13) goto L18;
        r23.append(r21);
        goto L15
    L21:
        boolean r27 = true;
        if (r22 == r23.length()) goto L25;
        r27 = false;
    L25:
        if (r27 == false) goto L29;
        String r28 = r23.toString();
        Intrinsics.checkNotNullExpressionValue(r28, "StringBuilder(capacity).…builderAction).toString()");
        return r28;
    L29:
        throw new IllegalStateException("Check failed.".toString());
    L9:
        r10 = LOWER_CASE_HEX_DIGITS;
        goto L10
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte[] r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "format");
        return toHexString(r10, 0, r10.length, r11);
    }

    public static /* synthetic */ String toHexString$default(byte r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r10, r11);
    }

    public static /* synthetic */ String toHexString$default(int r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r10, r11);
    }

    public static /* synthetic */ String toHexString$default(long r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r10, r11);
    }

    public static /* synthetic */ String toHexString$default(short r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r10, r11);
    }

    public static /* synthetic */ String toHexString$default(byte[] r10, int r11, int r12, HexFormat r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.length;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = HexFormat.Companion.getDefault();
    L12:
        return toHexString(r10, r11, r12, r13);
    }

    public static /* synthetic */ String toHexString$default(byte[] r10, HexFormat r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r10, r11);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringImpl(long r11, HexFormat r13, int r14) {
        if ((r14 & 3) != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L24;
        if (r13.getUpperCase() == false) goto L10;
        String r12 = UPPER_CASE_HEX_DIGITS;
    L11:
        String r15 = r13.getNumber().getPrefix();
        String r16 = r13.getNumber().getSuffix();
        int r17 = (r15.length() + (r14 >> 2)) + r16.length();
        boolean r18 = r13.getNumber().getRemoveLeadingZeros();
        StringBuilder r19 = new StringBuilder(r17);
        r19.append(r15);
    L12:
        if (r14 <= 0) goto L21;
        r14 = r14 - 4;
        int r20 = (int) ((r11 >> r14) & 15);
        if (r18 == false) goto L18;
        if (r20 != 0) goto L18;
        if (r14 <= 0) goto L18;
        r18 = true;
    L19:
        if (r18 == true) goto L12;
        r19.append(r12.charAt(r20));
    L18:
        r18 = false;
        goto L19
    L21:
        r19.append(r16);
        String r110 = r19.toString();
        Intrinsics.checkNotNullExpressionValue(r110, "StringBuilder(capacity).…builderAction).toString()");
        return r110;
    L10:
        r12 = LOWER_CASE_HEX_DIGITS;
        goto L11
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r10 = false;
        goto L6
    }

    private static final long wholeElementsPerSet(long r10, long r11, int r12) {
        if (r10 > 0) goto L5;
        return 0;
    L5:
        if (r11 <= 0) goto L10;
        long r13 = r12;
        return (r10 + r13) / (r11 + r13);
    L10:
        return 0;
    }
}
