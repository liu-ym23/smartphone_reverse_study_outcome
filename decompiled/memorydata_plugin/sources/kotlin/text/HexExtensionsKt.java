package kotlin.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002\u001a(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002\u001a@\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0000\u001a@\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0000\u001a \u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a5\u0010\u001c\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007H\u0082\b\u001a$\u0010#\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0002\u001a\u001c\u0010'\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a<\u0010(\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\rH\u0002\u001a\u0015\u0010+\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0082\b\u001a,\u0010,\u001a\u00020\r*\u00020-2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a<\u0010,\u001a\u00020\r*\u00020-2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a*\u00104\u001a\u000205*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u00104\u001a\u000205*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a*\u00108\u001a\u00020-*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u00108\u001a\u00020-*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a&\u00109\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a&\u0010<\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a&\u0010=\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a$\u0010>\u001a\u00020-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a*\u0010?\u001a\u00020\r*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010?\u001a\u00020\r*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a,\u0010@\u001a\u00020\r*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\rH\u0003\u001a*\u0010A\u001a\u00020\n*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010A\u001a\u00020\n*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a,\u0010B\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\rH\u0003\u001a*\u0010C\u001a\u00020D*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010C\u001a\u00020D*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0015\u0010E\u001a\u00020\n*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0082\b\u001a\u0014\u0010F\u001a\u000205*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a\u001c\u0010G\u001a\u00020\r*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a\u001c\u0010H\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a\u0014\u0010I\u001a\u00020J*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a,\u0010K\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010L\u001a\u00020!H\u0002\u001a,\u0010M\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002\u001a,\u0010N\u001a\u00020$*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002\u001a\u001c\u0010O\u001a\u00020\r*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a\u0016\u0010P\u001a\u00020\u0007*\u0002052\b\b\u0002\u00106\u001a\u000207H\u0007\u001a*\u0010P\u001a\u00020\u0007*\u00020-2\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020-2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020D2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a$\u0010Q\u001a\u00020\u0007*\u00020\n2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\rH\u0003\u001a,\u0010V\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010W\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010X\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010Y\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "checkFormatLength", "formatLength", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", "index", "endIndex", "part", "ignoreCase", "", "partName", "checkMaxDigits", "", "startIndex", "maxDigits", "checkNewLineAt", "checkPrefixSuffixMaxDigits", "prefix", "suffix", "decimalFromHexDigitAt", "formatByteAt", "", "byteToDigits", "destination", "", "destinationOffset", "bytePrefix", "byteSuffix", "hexToByte", "", "format", "Lkotlin/text/HexFormat;", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArraySlowPath", "hexToInt", "hexToIntImpl", "hexToLong", "hexToLongImpl", "hexToShort", "", "longDecimalFromHexDigitAt", "parseByteAt", "parseInt", "parseLong", "throwInvalidDigitAt", "", "throwInvalidNumberOfDigits", "requireMaxLength", "throwInvalidPrefixSuffix", "throwNotContainedAt", "toCharArrayIfNotEmpty", "toHexString", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toHexStringNoLineAndGroupSeparator", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringSlowPath", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS = null;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS = null;
    private static final int[] HEX_DIGITS_TO_DECIMAL = null;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL = null;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] r1 = new int[256];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 256) goto L6;
        r1[r3] = LOWER_CASE_HEX_DIGITS.charAt(r3 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(r3 >> 4) << '\b');
        r3 = r3 + 1;
        goto L4
    L6:
        BYTE_TO_LOWER_CASE_HEX_DIGITS = r1;
        int[] r4 = new int[256];
        int r5 = 0;
    L8:
        if (r5 >= 256) goto L10;
        r4[r5] = UPPER_CASE_HEX_DIGITS.charAt(r5 & 15) | (UPPER_CASE_HEX_DIGITS.charAt(r5 >> 4) << '\b');
        r5 = r5 + 1;
        goto L8
    L10:
        BYTE_TO_UPPER_CASE_HEX_DIGITS = r4;
        int[] r6 = new int[256];
        int r7 = 0;
    L11:
        if (r7 >= 256) goto L13;
        r6[r7] = -1;
        r7 = r7 + 1;
        goto L11
    L13:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(LOWER_CASE_HEX_DIGITS, CharSequence.class, "com.obric.memorydata.plugin");
        int r9 = 0;
        int r10 = 0;
    L15:
        if (r9 >= r8.length()) goto L17;
        r6[r8.charAt(r9)] = r10;
        r9 = r9 + 1;
        r10 = r10 + 1;
        goto L15
    L17:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(UPPER_CASE_HEX_DIGITS, CharSequence.class, "com.obric.memorydata.plugin");
        int r12 = 0;
        int r13 = 0;
    L19:
        if (r12 >= r11.length()) goto L21;
        r6[r11.charAt(r12)] = r13;
        r12 = r12 + 1;
        r13 = r13 + 1;
        goto L19
    L21:
        HEX_DIGITS_TO_DECIMAL = r6;
        long[] r14 = new long[256];
        int r15 = 0;
    L22:
        if (r15 >= 256) goto L24;
        r14[r15] = -1;
        r15 = r15 + 1;
        goto L22
    L24:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(LOWER_CASE_HEX_DIGITS, CharSequence.class, "com.obric.memorydata.plugin");
        int r16 = 0;
        int r17 = 0;
    L26:
        if (r16 >= r0.length()) goto L28;
        r14[r0.charAt(r16)] = r17;
        r16 = r16 + 1;
        r17 = r17 + 1;
        goto L26
    L28:
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(UPPER_CASE_HEX_DIGITS, CharSequence.class, "com.obric.memorydata.plugin");
        int r19 = 0;
    L30:
        if (r2 >= r18.length()) goto L32;
        r14[r18.charAt(r2)] = r19;
        r2 = r2 + 1;
        r19 = r19 + 1;
        goto L30
    L32:
        HEX_DIGITS_TO_LONG_DECIMAL = r14;
    }

    private static final long charsPerSet(long r4, int r6, int r7) {
        if (r6 <= 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        long r1 = r6;
        return (r4 * r1) + (((long) r7) * (r1 - 1));
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r0 = false;
        goto L5
    }

    private static final int checkContainsAt(String r4, int r5, int r6, String r7, boolean r8, String r9) {
        int r2 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r5;
    L8:
        int r1 = ((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length();
    L9:
        if (r2 >= r1) goto L15;
        if (CharsKt.equals(r7.charAt(r2), r4.charAt(r5 + r2), r8) == true) goto L13;
        throwNotContainedAt(r4, r5, r6, r7, r9);
    L13:
        r2 = r2 + 1;
        goto L9
    L15:
        return r5 + r7.length();
    L5:
        r0 = false;
        goto L6
    }

    private static final int checkFormatLength(long r4) {
        boolean r1 = false;
        if (0 <= r4) goto L5;
    L7:
        if (r1 == false) goto L11;
        return (int) r4;
    L11:
        throw new IllegalArgumentException("The resulting string length is too big: " + ULong.m1641toStringimpl(ULong.m1595constructorimpl(r4)));
    L5:
        if (r4 > 2147483647L) goto L7;
        r1 = true;
        goto L7
    }

    private static final void checkMaxDigits(String r1, int r2, int r3, int r4) {
        if (r2 < r3) goto L4;
    L5:
        throwInvalidNumberOfDigits(r1, r2, r3, r4, false);
        return;
    L4:
        if ((r3 - r2) > r4) goto L5;
    }

    private static final int checkNewLineAt(String r3, int r4, int r5) {
        if (r3.charAt(r4) != '\r') goto L10;
        int r0 = r4 + 1;
        if (r0 < r5) goto L7;
        return r0;
    L7:
        if (r3.charAt(r0) == '\n') goto L17;
        return r0;
    L17:
        return r4 + 2;
    L10:
        if (r3.charAt(r4) != '\n') goto L14;
        return r4 + 1;
    L14:
        throw new NumberFormatException("Expected a new line at index " + r4 + ", but was " + r3.charAt(r4));
    }

    private static final void checkPrefixSuffixMaxDigits(String r7, int r8, int r9, String r10, String r11, boolean r12, int r13) {
        if (((r9 - r8) - r10.length()) > r11.length()) goto L5;
        throwInvalidPrefixSuffix(r7, r8, r9, r10, r11);
    L5:
        boolean r2 = true;
        int r3 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L18;
        int r1 = ((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length();
        int r4 = 0;
    L12:
        if (r4 >= r1) goto L17;
        if (CharsKt.equals(r10.charAt(r4), r7.charAt(r8 + r4), r12) == true) goto L16;
        throwNotContainedAt(r7, r8, r9, r10, "prefix");
    L16:
        r4 = r4 + 1;
        goto L12
    L17:
        r8 = r8 + r10.length();
    L18:
        int r14 = r9 - r11.length();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L22;
        r2 = false;
    L22:
        if (r2 == true) goto L30;
        int r5 = ((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length();
    L24:
        if (r3 >= r5) goto L29;
        if (CharsKt.equals(r11.charAt(r3), r7.charAt(r14 + r3), r12) == true) goto L28;
        throwNotContainedAt(r7, r14, r9, r11, "suffix");
    L28:
        r3 = r3 + 1;
        goto L24
    L29:
        r11.length();
    L30:
        checkMaxDigits(r7, r8, r14, r13);
        return;
    L8:
        r0 = false;
        goto L9
    }

    private static final int decimalFromHexDigitAt(String r3, int r4) {
        char r0 = r3.charAt(r4);
        if ((r0 >>> '\b') != 0) goto L8;
        int[] r1 = HEX_DIGITS_TO_DECIMAL;
        if (r1[r0] < 0) goto L8;
        return r1[r0];
    L8:
        throwInvalidDigitAt(r3, r4);
        throw new KotlinNothingValueException();
    }

    private static final int formatByteAt(byte[] r0, int r1, String r2, String r3, int[] r4, char[] r5, int r6) {
        return toCharArrayIfNotEmpty(r3, r5, formatByteAt(r0, r1, r4, r5, toCharArrayIfNotEmpty(r2, r5, r6)));
    }

    private static final int formatByteAt(byte[] r0, int r1, int[] r2, char[] r3, int r4) {
        int r5 = r2[r0[r1] & 255];
        r3[r4] = (char) (r5 >> 8);
        r3[r4 + 1] = (char) (r5 & 255);
        return r4 + 2;
    }

    private static final int formattedStringLength(int r4, int r5, int r6, int r7) {
        if (r4 <= 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        long r8 = r5;
        return checkFormatLength((r4 * (((((long) r6) + 2) + ((long) r7)) + r8)) - r8);
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r0 = false;
        goto L5
    }

    public static final int formattedStringLength(int r6, int r7, int r8, int r9, int r10, int r11, int r12) {
        if (r6 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        int r2 = r6 - 1;
        int r3 = r2 / r7;
        int r4 = (r7 - 1) / r8;
        int r5 = r6 % r7;
        if (r5 == 0) goto L11;
        r7 = r5;
    L11:
        int r13 = (r4 * r3) + ((r7 - 1) / r8);
        return checkFormatLength(((((long) r3) + (((long) r13) * ((long) r9))) + (((long) ((r2 - r3) - r13)) * ((long) r10))) + (((long) r6) * ((((long) r11) + 2) + ((long) r12))));
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r1 = false;
        goto L6
    }

    private static final byte hexToByte(String r1, int r2, int r3, HexFormat r4) {
        return (byte) hexToIntImpl(r1, r2, r3, r4, 2);
    }

    public static final byte hexToByte(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToByte(r2, 0, r2.length(), r3);
    }

    static /* synthetic */ byte hexToByte$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToByte(r0, r1, r2, r3);
    }

    public static /* synthetic */ byte hexToByte$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToByte(r0, r1);
    }

    private static final byte[] hexToByteArray(String r2, int r3, int r4, HexFormat r5) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r3, r4, r2.length());
        if (r3 == r4) goto L5;
        HexFormat.BytesHexFormat r6 = r5.getBytes();
        if (r6.getNoLineAndGroupSeparator$kotlin_stdlib() == false) goto L12;
        byte[] r0 = hexToByteArrayNoLineAndGroupSeparator(r2, r3, r4, r6);
        if (r0 == null) goto L12;
        return r0;
    L12:
        return hexToByteArraySlowPath(r2, r3, r4, r6);
    L5:
        return new byte[0];
    }

    public static final byte[] hexToByteArray(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToByteArray(r2, 0, r2.length(), r3);
    }

    static /* synthetic */ byte[] hexToByteArray$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToByteArray(r0, r1, r2, r3);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToByteArray(r0, r1);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String r1, int r2, int r3, HexFormat.BytesHexFormat r4) {
        if (r4.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() == false) goto L7;
        return hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(r1, r2, r3, r4);
    L7:
        return hexToByteArrayNoLineAndGroupSeparatorSlowPath(r1, r2, r3, r4);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String r12, int r13, int r14, HexFormat.BytesHexFormat r15) {
        String r0 = r15.getBytePrefix();
        String r1 = r15.getByteSuffix();
        String r2 = r15.getByteSeparator();
        int r3 = r2.length();
        long r6 = r3;
        long r4 = ((((long) r0.length()) + 2) + ((long) r1.length())) + r6;
        long r8 = r14 - r13;
        int r5 = (int) ((r8 + r6) / r4);
        if (((((long) r5) * r4) - r6) == r8) goto L6;
        return null;
    L6:
        boolean r16 = r15.getIgnoreCase$kotlin_stdlib();
        byte[] r7 = new byte[r5];
        int r9 = 0;
        boolean r10 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == true) goto L19;
        int r17 = ((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length();
        int r18 = 0;
    L13:
        if (r18 >= r17) goto L18;
        if (CharsKt.equals(r0.charAt(r18), r12.charAt(r13 + r18), r16) == true) goto L17;
        throwNotContainedAt(r12, r13, r14, r0, "byte prefix");
    L17:
        r18 = r18 + 1;
        goto L13
    L18:
        r13 = r13 + r0.length();
    L19:
        String r19 = r1 + r2 + r0;
        int r20 = r5 - 1;
        int r21 = 0;
    L20:
        if (r21 >= r20) goto L35;
        r7[r21] = parseByteAt(r12, r13);
        r13 = r13 + 2;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L24;
        boolean r22 = true;
    L25:
        if (r22 == true) goto L34;
        int r23 = ((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).length();
        int r24 = 0;
    L28:
        if (r24 >= r23) goto L33;
        if (CharsKt.equals(r19.charAt(r24), r12.charAt(r13 + r24), r16) == true) goto L32;
        throwNotContainedAt(r12, r13, r14, r19, "byte suffix + byte separator + byte prefix");
    L32:
        r24 = r24 + 1;
        goto L28
    L33:
        r13 = r13 + r19.length();
    L34:
        r21 = r21 + 1;
        goto L20
    L24:
        r22 = false;
        goto L25
    L35:
        r7[r20] = parseByteAt(r12, r13);
        int r110 = r13 + 2;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L39;
        r10 = false;
    L39:
        if (r10 == true) goto L47;
        int r25 = ((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length();
    L41:
        if (r9 >= r25) goto L46;
        if (CharsKt.equals(r1.charAt(r9), r12.charAt(r110 + r9), r16) == true) goto L45;
        throwNotContainedAt(r12, r110, r14, r1, "byte suffix");
    L45:
        r9 = r9 + 1;
        goto L41
    L46:
        r1.length();
    L47:
        return r7;
    L9:
        r11 = false;
        goto L10
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String r12, int r13, int r14, HexFormat.BytesHexFormat r15) {
        int r0 = r15.getByteSeparator().length();
        int r1 = 0;
        if (r0 > 1) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L38;
        int r16 = r14 - r13;
        int r4 = 2;
        if (r0 != 0) goto L17;
        if ((r16 & 1) == 0) goto L12;
        return null;
    L12:
        int r17 = r16 >> 1;
        byte[] r18 = new byte[r17];
        int r19 = 0;
    L13:
        if (r1 >= r17) goto L15;
        r18[r1] = parseByteAt(r12, r19);
        r19 = r19 + 2;
        r1 = r1 + 1;
        goto L13
    L15:
        return r18;
    L17:
        if ((r16 % 3) == 2) goto L19;
        return null;
    L19:
        int r110 = (r16 / 3) + 1;
        byte[] r2 = new byte[r110];
        char r5 = r15.getByteSeparator().charAt(0);
        r2[0] = parseByteAt(r12, 0);
        int r6 = 1;
    L20:
        if (r6 >= r110) goto L36;
        if (r12.charAt(r4) == r5) goto L35;
        String r7 = r15.getByteSeparator();
        boolean r8 = r15.getIgnoreCase$kotlin_stdlib();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == true) goto L35;
        int r10 = ((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length();
        int r11 = 0;
    L29:
        if (r11 >= r10) goto L34;
        if (CharsKt.equals(r7.charAt(r11), r12.charAt(r4 + r11), r8) == true) goto L33;
        throwNotContainedAt(r12, r4, r14, r7, "byte separator");
    L33:
        r11 = r11 + 1;
        goto L29
    L34:
        r7.length();
        goto L35
    L26:
        r9 = false;
    L35:
        r2[r6] = parseByteAt(r12, r4 + 1);
        r4 = r4 + 3;
        r6 = r6 + 1;
        goto L20
    L36:
        return r2;
    L38:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r3 = false;
        goto L6
    }

    private static final byte[] hexToByteArraySlowPath(String r20, int r21, int r22, HexFormat.BytesHexFormat r23) {
        int r9 = r23.getBytesPerLine();
        int r10 = r23.getBytesPerGroup();
        String r11 = r23.getBytePrefix();
        String r12 = r23.getByteSuffix();
        String r13 = r23.getByteSeparator();
        String r14 = r23.getGroupSeparator();
        boolean r15 = r23.getIgnoreCase$kotlin_stdlib();
        int r2 = parsedByteArrayMaxSize(r22 - r21, r9, r10, r14.length(), r13.length(), r11.length(), r12.length());
        byte[] r3 = new byte[r2];
        int r5 = r21;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L3:
        if (r5 >= r22) goto L73;
        int r16 = r2;
        if (r7 != r9) goto L8;
        r5 = checkNewLineAt(r20, r5, r22);
        int r4 = 1;
        int r17 = 0;
    L7:
        r8 = 0;
    L42:
        int r18 = r17 + r4;
        int r19 = r8 + r4;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L45;
        boolean r24 = true;
    L46:
        if (r24 == false) goto L48;
        int r110 = r19;
    L56:
        if ((r22 - 2) >= r5) goto L58;
        boolean r25 = true;
        throwInvalidNumberOfDigits(r20, r5, r22, 2, true);
    L59:
        int r26 = r6 + 1;
        r3[r6] = parseByteAt(r20, r5);
        r5 = r5 + 2;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L63;
        r25 = false;
    L63:
        if (r25 == true) goto L72;
        int r27 = ((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length();
        int r28 = 0;
    L66:
        if (r28 >= r27) goto L71;
        if (CharsKt.equals(r12.charAt(r28), r20.charAt(r5 + r28), r15) == true) goto L70;
        throwNotContainedAt(r20, r5, r22, r12, "byte suffix");
    L70:
        r28 = r28 + 1;
        goto L66
    L71:
        r5 = r5 + r12.length();
    L72:
        r6 = r26;
        r2 = r16;
        r7 = r18;
        r8 = r110;
        goto L3
    L58:
        r25 = true;
        goto L59
    L48:
        int r29 = ((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length();
        int r30 = 0;
    L49:
        if (r30 >= r29) goto L54;
        int r111 = r29;
        int r112 = r19;
        if (CharsKt.equals(r11.charAt(r30), r20.charAt(r5 + r30), r15) == true) goto L53;
        throwNotContainedAt(r20, r5, r22, r11, "byte prefix");
    L53:
        r30 = r30 + 1;
        r29 = r111;
        r19 = r112;
        goto L49
    L54:
        r110 = r19;
        r5 = r5 + r11.length();
        goto L56
    L45:
        r24 = false;
        goto L46
    L8:
        if (r8 == r10) goto L10;
        r17 = r7;
        if (r8 == 0) goto L41;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L29;
        boolean r31 = true;
    L30:
        if (r31 == false) goto L32;
        int r113 = r8;
    L39:
        r8 = r113;
        goto L41
    L32:
        int r32 = ((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length();
        int r33 = 0;
    L33:
        if (r33 >= r32) goto L38;
        int r114 = r32;
        int r115 = r8;
        if (CharsKt.equals(r13.charAt(r33), r20.charAt(r5 + r33), r15) == true) goto L37;
        throwNotContainedAt(r20, r5, r22, r13, "byte separator");
    L37:
        r33 = r33 + 1;
        r32 = r114;
        r8 = r115;
        goto L33
    L38:
        r113 = r8;
        r5 = r5 + r13.length();
        goto L39
    L29:
        r31 = false;
    L41:
        r4 = 1;
        goto L42
    L10:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L12;
        boolean r34 = true;
    L13:
        if (r34 == false) goto L15;
        int r116 = r7;
    L23:
        r17 = r116;
        r4 = 1;
        goto L7
    L15:
        int r35 = ((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length();
        int r36 = 0;
    L16:
        r116 = r7;
        if (r36 >= r35) goto L22;
        int r117 = r35;
        if (CharsKt.equals(r14.charAt(r36), r20.charAt(r5 + r36), r15) == true) goto L21;
        throwNotContainedAt(r20, r5, r22, r14, "group separator");
    L21:
        r36 = r36 + 1;
        r7 = r116;
        r35 = r117;
        goto L16
    L22:
        r5 = r5 + r14.length();
        goto L23
    L12:
        r34 = false;
        goto L13
    L73:
        if (r6 == r2) goto L92;
        byte[] r37 = Arrays.copyOf(r3, r6);
        Intrinsics.checkNotNullExpressionValue(r37, "copyOf(...)");
        return r37;
    L92:
        return r3;
    }

    private static final int hexToInt(String r1, int r2, int r3, HexFormat r4) {
        return hexToIntImpl(r1, r2, r3, r4, 8);
    }

    public static final int hexToInt(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToInt(r2, 0, r2.length(), r3);
    }

    static /* synthetic */ int hexToInt$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToInt(r0, r1, r2, r3);
    }

    public static /* synthetic */ int hexToInt$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToInt(r0, r1);
    }

    private static final int hexToIntImpl(String r9, int r10, int r11, HexFormat r12, int r13) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r9.length());
        HexFormat.NumberHexFormat r14 = r12.getNumber();
        if (r14.isDigitsOnly$kotlin_stdlib() == false) goto L7;
        checkMaxDigits(r9, r10, r11, r13);
    L6:
        return parseInt(r9, r10, r11);
    L7:
        String r7 = r14.getPrefix();
        String r8 = r14.getSuffix();
        checkPrefixSuffixMaxDigits(r9, r10, r11, r7, r8, r14.getIgnoreCase$kotlin_stdlib(), r13);
        r10 = r10 + r7.length();
        r11 = r11 - r8.length();
        goto L6
    }

    private static final long hexToLong(String r1, int r2, int r3, HexFormat r4) {
        return hexToLongImpl(r1, r2, r3, r4, 16);
    }

    public static final long hexToLong(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToLong(r2, 0, r2.length(), r3);
    }

    static /* synthetic */ long hexToLong$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToLong(r0, r1, r2, r3);
    }

    public static /* synthetic */ long hexToLong$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToLong(r0, r1);
    }

    private static final long hexToLongImpl(String r9, int r10, int r11, HexFormat r12, int r13) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r9.length());
        HexFormat.NumberHexFormat r14 = r12.getNumber();
        if (r14.isDigitsOnly$kotlin_stdlib() == false) goto L7;
        checkMaxDigits(r9, r10, r11, r13);
    L6:
        return parseLong(r9, r10, r11);
    L7:
        String r7 = r14.getPrefix();
        String r8 = r14.getSuffix();
        checkPrefixSuffixMaxDigits(r9, r10, r11, r7, r8, r14.getIgnoreCase$kotlin_stdlib(), r13);
        r10 = r10 + r7.length();
        r11 = r11 - r8.length();
        goto L6
    }

    private static final short hexToShort(String r1, int r2, int r3, HexFormat r4) {
        return (short) hexToIntImpl(r1, r2, r3, r4, 4);
    }

    public static final short hexToShort(String r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return hexToShort(r2, 0, r2.length(), r3);
    }

    static /* synthetic */ short hexToShort$default(String r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return hexToShort(r0, r1, r2, r3);
    }

    public static /* synthetic */ short hexToShort$default(String r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return hexToShort(r0, r1);
    }

    private static final long longDecimalFromHexDigitAt(String r6, int r7) {
        char r0 = r6.charAt(r7);
        if ((r0 >>> '\b') != 0) goto L8;
        long[] r1 = HEX_DIGITS_TO_LONG_DECIMAL;
        if (r1[r0] < 0) goto L8;
        return r1[r0];
    L8:
        throwInvalidDigitAt(r6, r7);
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String r4, int r5) {
        char r0 = r4.charAt(r5);
        if ((r0 >>> '\b') != 0) goto L14;
        int[] r1 = HEX_DIGITS_TO_DECIMAL;
        if (r1[r0] < 0) goto L14;
        int r2 = r1[r0];
        int r6 = r5 + 1;
        char r3 = r4.charAt(r6);
        if ((r3 >>> '\b') == 0) goto L9;
    L12:
        throwInvalidDigitAt(r4, r6);
        throw new KotlinNothingValueException();
    L9:
        if (r1[r3] < 0) goto L12;
        return (byte) (r1[r3] | (r2 << 4));
    L14:
        throwInvalidDigitAt(r4, r5);
        throw new KotlinNothingValueException();
    }

    private static final int parseInt(String r4, int r5, int r6) {
        int r0 = 0;
    L3:
        if (r5 >= r6) goto L11;
        int r1 = r0 << 4;
        char r2 = r4.charAt(r5);
        if ((r2 >>> '\b') != 0) goto L9;
        int[] r3 = HEX_DIGITS_TO_DECIMAL;
        if (r3[r2] < 0) goto L9;
        r0 = r1 | r3[r2];
        r5 = r5 + 1;
    L9:
        throwInvalidDigitAt(r4, r5);
        throw new KotlinNothingValueException();
    L11:
        return r0;
    }

    private static final long parseLong(String r8, int r9, int r10) {
        long r2 = 0;
    L3:
        if (r9 >= r10) goto L11;
        long r3 = r2 << 4;
        char r4 = r8.charAt(r9);
        if ((r4 >>> '\b') != 0) goto L9;
        long[] r5 = HEX_DIGITS_TO_LONG_DECIMAL;
        if (r5[r4] < 0) goto L9;
        r2 = r3 | r5[r4];
        r9 = r9 + 1;
    L9:
        throwInvalidDigitAt(r8, r9);
        throw new KotlinNothingValueException();
    L11:
        return r2;
    }

    public static final int parsedByteArrayMaxSize(int r19, int r20, int r21, int r22, int r23, int r24, int r25) {
        if (r19 <= 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L20;
        long r8 = (((long) r24) + 2) + ((long) r25);
        long r9 = charsPerSet(r8, r21, r23);
        if (r20 > r21) goto L10;
        long r11 = charsPerSet(r8, r20, r23);
    L13:
        long r13 = r19;
        long r15 = wholeElementsPerSet(r13, r11, 1);
        long r14 = r13 - ((r11 + 1) * r15);
        long r12 = wholeElementsPerSet(r14, r9, r22);
        long r16 = r14 - ((r9 + ((long) r22)) * r12);
        long r5 = wholeElementsPerSet(r16, r8, r23);
        if ((r16 - ((r8 + ((long) r23)) * r5)) <= 0) goto L16;
        int r0 = 1;
    L18:
        return (int) (r0 + (((r15 * ((long) r20)) + (r12 * ((long) r21))) + r5));
    L16:
        r0 = 0;
        goto L18
    L10:
        r11 = charsPerSet(r9, r20 / r21, r22);
        int r17 = r20 % r21;
        if (r17 == 0) goto L13;
        r11 = (r11 + ((long) r22)) + charsPerSet(r8, r17, r23);
        goto L13
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r7 = false;
        goto L6
    }

    private static final Void throwInvalidDigitAt(String r3, int r4) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + r4 + ", but was " + r3.charAt(r4));
    }

    private static final void throwInvalidNumberOfDigits(String r3, int r4, int r5, int r6, boolean r7) {
        if (r7 == false) goto L4;
        String r8 = "exactly";
    L5:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.String");
        String r9 = r3.substring(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r9, "substring(...)");
        throw new NumberFormatException("Expected " + r8 + ' ' + r6 + " hexadecimal digits at index " + r4 + ", but was " + r9 + " of length " + (r5 - r4));
    L4:
        r8 = "at most";
        goto L5
    }

    private static final void throwInvalidPrefixSuffix(String r1, int r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.lang.String");
        String r6 = r1.substring(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r6, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + r4 + "\" and suffix \"" + r5 + "\", but was " + r6);
    }

    private static final void throwNotContainedAt(String r2, int r3, int r4, String r5, String r6) {
        int r7 = RangesKt.coerceAtMost(r5.length() + r3, r4);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        String r8 = r2.substring(r3, r7);
        Intrinsics.checkNotNullExpressionValue(r8, "substring(...)");
        throw new NumberFormatException("Expected " + r6 + " \"" + r5 + "\" at index " + r3 + ", but was " + r8);
    }

    private static final int toCharArrayIfNotEmpty(String r3, char[] r4, int r5) {
        int r0 = r3.length();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L7;
        int r1 = r3.length();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.String");
        r3.getChars(0, r1, r4, r5);
        goto L9
    L7:
        r4[r5] = r3.charAt(0);
    L9:
        return r5 + r3.length();
    }

    public static final String toHexString(byte r5, HexFormat r6) {
        Intrinsics.checkNotNullParameter(r6, "format");
        if (r6.getUpperCase() == false) goto L5;
        String r0 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r7 = r6.getNumber();
        if (r7.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r2 = {r0.charAt((r5 >> 4) & 15), r0.charAt(r5 & 15)};
        if (r7.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt.concatToString$default(r2, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(r5 & 255) - 24) >> 2, 1), 0, 2, null);
    L12:
        return StringsKt.concatToString(r2);
    L14:
        return toHexStringImpl(r5, r7, r0, 8);
    L5:
        r0 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    public static final String toHexString(int r6, HexFormat r7) {
        Intrinsics.checkNotNullParameter(r7, "format");
        if (r7.getUpperCase() == false) goto L5;
        String r0 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r8 = r7.getNumber();
        if (r8.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r1 = {r0.charAt((r6 >> 28) & 15), r0.charAt((r6 >> 24) & 15), r0.charAt((r6 >> 20) & 15), r0.charAt((r6 >> 16) & 15), r0.charAt((r6 >> 12) & 15), r0.charAt((r6 >> 8) & 15), r0.charAt((r6 >> 4) & 15), r0.charAt(r6 & 15)};
        if (r8.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt.concatToString$default(r1, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(r6) >> 2, 7), 0, 2, null);
    L12:
        return StringsKt.concatToString(r1);
    L14:
        return toHexStringImpl(r6, r8, r0, 32);
    L5:
        r0 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    public static final String toHexString(long r12, HexFormat r14) {
        Intrinsics.checkNotNullParameter(r14, "format");
        if (r14.getUpperCase() == false) goto L5;
        String r0 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r15 = r14.getNumber();
        if (r15.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r2 = {r0.charAt((int) ((r12 >> 60) & 15)), r0.charAt((int) ((r12 >> 56) & 15)), r0.charAt((int) ((r12 >> 52) & 15)), r0.charAt((int) ((r12 >> 48) & 15)), r0.charAt((int) ((r12 >> 44) & 15)), r0.charAt((int) ((r12 >> 40) & 15)), r0.charAt((int) ((r12 >> 36) & 15)), r0.charAt((int) ((r12 >> 32) & 15)), r0.charAt((int) ((r12 >> 28) & 15)), r0.charAt((int) ((r12 >> 24) & 15)), r0.charAt((int) ((r12 >> 20) & 15)), r0.charAt((int) ((r12 >> 16) & 15)), r0.charAt((int) ((r12 >> 12) & 15)), r0.charAt((int) ((r12 >> 8) & 15)), r0.charAt((int) ((r12 >> 4) & 15)), r0.charAt((int) (15 & r12))};
        if (r15.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt.concatToString$default(r2, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(r12) >> 2, 15), 0, 2, null);
    L12:
        return StringsKt.concatToString(r2);
    L14:
        return toHexStringImpl(r12, r15, r0, 64);
    L5:
        r0 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    public static final String toHexString(short r6, HexFormat r7) {
        Intrinsics.checkNotNullParameter(r7, "format");
        if (r7.getUpperCase() == false) goto L5;
        String r0 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r8 = r7.getNumber();
        if (r8.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r1 = {r0.charAt((r6 >> 12) & 15), r0.charAt((r6 >> 8) & 15), r0.charAt((r6 >> 4) & 15), r0.charAt(r6 & 15)};
        if (r8.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt.concatToString$default(r1, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(r6 & UShort.MAX_VALUE) - 16) >> 2, 3), 0, 2, null);
    L12:
        return StringsKt.concatToString(r1);
    L14:
        return toHexStringImpl(r6, r8, r0, 16);
    L5:
        r0 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    public static final String toHexString(byte[] r2, int r3, int r4, HexFormat r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r5, "format");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r3, r4, r2.length);
        if (r3 != r4) goto L7;
        return "";
    L7:
        if (r5.getUpperCase() == false) goto L9;
        int[] r0 = BYTE_TO_UPPER_CASE_HEX_DIGITS;
    L10:
        HexFormat.BytesHexFormat r6 = r5.getBytes();
        if (r6.getNoLineAndGroupSeparator$kotlin_stdlib() == false) goto L15;
        return toHexStringNoLineAndGroupSeparator(r2, r3, r4, r6, r0);
    L15:
        return toHexStringSlowPath(r2, r3, r4, r6, r0);
    L9:
        r0 = BYTE_TO_LOWER_CASE_HEX_DIGITS;
        goto L10
    }

    public static final String toHexString(byte[] r2, HexFormat r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        return toHexString(r2, 0, r2.length, r3);
    }

    public static /* synthetic */ String toHexString$default(byte r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r1);
    }

    public static /* synthetic */ String toHexString$default(int r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r1);
    }

    public static /* synthetic */ String toHexString$default(long r0, HexFormat r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r2);
    }

    public static /* synthetic */ String toHexString$default(short r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r1);
    }

    public static /* synthetic */ String toHexString$default(byte[] r0, int r1, int r2, HexFormat r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.length;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = HexFormat.Companion.getDefault();
    L12:
        return toHexString(r0, r1, r2, r3);
    }

    public static /* synthetic */ String toHexString$default(byte[] r0, HexFormat r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r0, r1);
    }

    private static final String toHexStringImpl(long r14, HexFormat.NumberHexFormat r16, String r17, int r18) {
        if ((r18 & 3) != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        int r1 = r18 >> 2;
        String r3 = r16.getPrefix();
        String r4 = r16.getSuffix();
        boolean r5 = r16.getRemoveLeadingZeros();
        int r6 = checkFormatLength((((long) r3.length()) + ((long) r1)) + ((long) r4.length()));
        char[] r7 = new char[r6];
        int r9 = 0;
        boolean r8 = r5;
        int r10 = toCharArrayIfNotEmpty(r3, r7, 0);
        int r11 = r18;
    L8:
        if (r9 >= r1) goto L19;
        r11 = r11 - 4;
        int r12 = (int) ((r14 >> r11) & 15);
        if (r8 == false) goto L14;
        if (r12 != 0) goto L14;
        if (r11 <= 0) goto L14;
        r8 = true;
    L15:
        if (r8 == true) goto L18;
        r7[r10] = r17.charAt(r12);
        r10 = r10 + 1;
    L18:
        r9 = r9 + 1;
    L14:
        r8 = false;
        goto L15
    L19:
        int r2 = toCharArrayIfNotEmpty(r4, r7, r10);
        if (r2 != r6) goto L23;
        return StringsKt.concatToString(r7);
    L23:
        return StringsKt.concatToString$default(r7, 0, r2, 1, null);
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] r1, int r2, int r3, HexFormat.BytesHexFormat r4, int[] r5) {
        if (r4.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() == false) goto L7;
        return toHexStringShortByteSeparatorNoPrefixAndSuffix(r1, r2, r3, r4, r5);
    L7:
        return toHexStringNoLineAndGroupSeparatorSlowPath(r1, r2, r3, r4, r5);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] r10, int r11, int r12, HexFormat.BytesHexFormat r13, int[] r14) {
        String r7 = r13.getBytePrefix();
        String r8 = r13.getByteSuffix();
        String r15 = r13.getByteSeparator();
        char[] r9 = new char[formattedStringLength(r12 - r11, r15.length(), r7.length(), r8.length())];
        int r0 = formatByteAt(r10, r11, r7, r8, r14, r9, 0);
    L3:
        r11 = r11 + 1;
        if (r11 >= r12) goto L7;
        r0 = formatByteAt(r10, r11, r7, r8, r14, r9, toCharArrayIfNotEmpty(r15, r9, r0));
        goto L3
    L7:
        return StringsKt.concatToString(r9);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] r8, int r9, int r10, HexFormat.BytesHexFormat r11, int[] r12) {
        int r0 = r11.getByteSeparator().length();
        int r1 = 0;
        if (r0 > 1) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L20;
        int r4 = r10 - r9;
        if (r0 != 0) goto L14;
        char[] r13 = new char[checkFormatLength(((long) r4) * 2)];
    L10:
        if (r9 >= r10) goto L13;
        r1 = formatByteAt(r8, r9, r12, r13, r1);
        r9 = r9 + 1;
        goto L10
    L13:
        return StringsKt.concatToString(r13);
    L14:
        char[] r2 = new char[checkFormatLength((((long) r4) * 3) - 1)];
        char r14 = r11.getByteSeparator().charAt(0);
        int r5 = formatByteAt(r8, r9, r12, r2, 0);
        int r15 = r9 + 1;
    L15:
        if (r15 >= r10) goto L18;
        r2[r5] = r14;
        r5 = formatByteAt(r8, r15, r12, r2, r5 + 1);
        r15 = r15 + 1;
        goto L15
    L18:
        return StringsKt.concatToString(r2);
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r3 = false;
        goto L6
    }

    private static final String toHexStringSlowPath(byte[] r22, int r23, int r24, HexFormat.BytesHexFormat r25, int[] r26) {
        int r8 = r25.getBytesPerLine();
        int r9 = r25.getBytesPerGroup();
        String r10 = r25.getBytePrefix();
        String r11 = r25.getByteSuffix();
        String r12 = r25.getByteSeparator();
        String r13 = r25.getGroupSeparator();
        int r14 = formattedStringLength(r24 - r23, r8, r9, r13.length(), r12.length(), r10.length(), r11.length());
        char[] r15 = new char[r14];
        boolean r16 = false;
        int r7 = r23;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r7 >= r24) goto L13;
        if (r2 != r8) goto L7;
        r15[r1] = '\n';
        r1 = r1 + 1;
        int r18 = 0;
        int r19 = 0;
    L10:
        if (r19 == 0) goto L12;
        r1 = toCharArrayIfNotEmpty(r12, r15, r1);
    L12:
        r1 = formatByteAt(r22, r7, r10, r11, r26, r15, r1);
        r3 = r19 + 1;
        r2 = r18 + 1;
        r7 = r7 + 1;
        goto L4
    L7:
        if (r3 != r9) goto L9;
        r1 = toCharArrayIfNotEmpty(r13, r15, r1);
        r18 = r2;
        r19 = 0;
        goto L10
    L9:
        r18 = r2;
        r19 = r3;
        goto L10
    L13:
        if (r1 != r14) goto L15;
        r16 = true;
    L15:
        if (r16 == false) goto L19;
        return StringsKt.concatToString(r15);
    L19:
        throw new IllegalStateException("Check failed.".toString());
    }

    private static final long wholeElementsPerSet(long r3, long r5, int r7) {
        if (r3 > 0) goto L5;
        return 0;
    L5:
        if (r5 <= 0) goto L10;
        long r0 = r7;
        return (r3 + r0) / (r5 + r0);
    L10:
        return 0;
    }
}
