package kotlin.text;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002\u001a(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002\u001a@\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0000\u001a@\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0000\u001a \u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a5\u0010\u001c\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007H\u0082\b\u001a$\u0010#\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0002\u001a\u001c\u0010'\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a<\u0010(\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\rH\u0002\u001a\u0015\u0010+\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0082\b\u001a,\u0010,\u001a\u00020\r*\u00020-2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a<\u0010,\u001a\u00020\r*\u00020-2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a*\u00104\u001a\u000205*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u00104\u001a\u000205*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a*\u00108\u001a\u00020-*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u00108\u001a\u00020-*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a&\u00109\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a&\u0010<\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a&\u0010=\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a$\u0010>\u001a\u00020-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a*\u0010?\u001a\u00020\r*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010?\u001a\u00020\r*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a,\u0010@\u001a\u00020\r*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\rH\u0003\u001a*\u0010A\u001a\u00020\n*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010A\u001a\u00020\n*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a,\u0010B\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\rH\u0003\u001a*\u0010C\u001a\u00020D*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010C\u001a\u00020D*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0015\u0010E\u001a\u00020\n*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0082\b\u001a\u0014\u0010F\u001a\u000205*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a\u001c\u0010G\u001a\u00020\r*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a\u001c\u0010H\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a\u0014\u0010I\u001a\u00020J*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a,\u0010K\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010L\u001a\u00020!H\u0002\u001a,\u0010M\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002\u001a,\u0010N\u001a\u00020$*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002\u001a\u001c\u0010O\u001a\u00020\r*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a\u0016\u0010P\u001a\u00020\u0007*\u0002052\b\b\u0002\u00106\u001a\u000207H\u0007\u001a*\u0010P\u001a\u00020\u0007*\u00020-2\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020-2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020D2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a$\u0010Q\u001a\u00020\u0007*\u00020\n2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\rH\u0003\u001a,\u0010V\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010W\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010X\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010Y\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "checkFormatLength", "formatLength", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", "index", "endIndex", "part", "ignoreCase", "", "partName", "checkMaxDigits", "", "startIndex", "maxDigits", "checkNewLineAt", "checkPrefixSuffixMaxDigits", "prefix", "suffix", "decimalFromHexDigitAt", "formatByteAt", "", "byteToDigits", "destination", "", "destinationOffset", "bytePrefix", "byteSuffix", "hexToByte", "", "format", "Lkotlin/text/HexFormat;", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArraySlowPath", "hexToInt", "hexToIntImpl", "hexToLong", "hexToLongImpl", "hexToShort", "", "longDecimalFromHexDigitAt", "parseByteAt", "parseInt", "parseLong", "throwInvalidDigitAt", "", "throwInvalidNumberOfDigits", "requireMaxLength", "throwInvalidPrefixSuffix", "throwNotContainedAt", "toCharArrayIfNotEmpty", "toHexString", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toHexStringNoLineAndGroupSeparator", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringSlowPath", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1050:1\n998#1,7:1052\n998#1,7:1059\n998#1,7:1066\n998#1,7:1073\n998#1,7:1080\n998#1,7:1087\n998#1,7:1094\n998#1,7:1101\n1009#1,5:1108\n1009#1,5:1113\n998#1,7:1118\n998#1,7:1125\n1009#1,5:1132\n1018#1,5:1137\n1#2:1051\n1188#3,3:1142\n1188#3,3:1145\n1188#3,3:1148\n1188#3,3:1151\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n418#1:1052,7\n451#1:1059,7\n455#1:1066,7\n458#1:1073,7\n499#1:1080,7\n502#1:1087,7\n507#1:1094,7\n512#1:1101,7\n519#1:1108,5\n520#1:1113,5\n967#1:1118,7\n969#1:1125,7\n983#1:1132,5\n991#1:1137,5\n42#1:1142,3\n43#1:1145,3\n54#1:1148,3\n55#1:1151,3\n*E\n"})
public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS = null;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS = null;
    private static final int[] HEX_DIGITS_TO_DECIMAL = null;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL = null;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] r5 = new int[256];
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= 256) goto L6;
        r5[r11] = LOWER_CASE_HEX_DIGITS.charAt(r11 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(r11 >> 4) << '\b');
        r11 = r11 + 1;
        goto L4
    L6:
        BYTE_TO_LOWER_CASE_HEX_DIGITS = r5;
        int[] r12 = new int[256];
        int r13 = 0;
    L8:
        if (r13 >= 256) goto L10;
        r12[r13] = UPPER_CASE_HEX_DIGITS.charAt(r13 & 15) | (UPPER_CASE_HEX_DIGITS.charAt(r13 >> 4) << '\b');
        r13 = r13 + 1;
        goto L8
    L10:
        BYTE_TO_UPPER_CASE_HEX_DIGITS = r12;
        int[] r14 = new int[256];
        int r15 = 0;
    L11:
        if (r15 >= 256) goto L13;
        r14[r15] = -1;
        r15 = r15 + 1;
        goto L11
    L13:
        int r16 = 0;
        int r17 = 0;
    L15:
        if (r16 >= LOWER_CASE_HEX_DIGITS.length()) goto L17;
        r14[LOWER_CASE_HEX_DIGITS.charAt(r16)] = r17;
        r16 = r16 + 1;
        r17 = r17 + 1;
        goto L15
    L17:
        int r18 = 0;
        int r19 = 0;
    L19:
        if (r18 >= UPPER_CASE_HEX_DIGITS.length()) goto L21;
        r14[UPPER_CASE_HEX_DIGITS.charAt(r18)] = r19;
        r18 = r18 + 1;
        r19 = r19 + 1;
        goto L19
    L21:
        HEX_DIGITS_TO_DECIMAL = r14;
        long[] r20 = new long[256];
        int r21 = 0;
    L22:
        if (r21 >= 256) goto L24;
        r20[r21] = -1;
        r21 = r21 + 1;
        goto L22
    L24:
        int r22 = 0;
        int r23 = 0;
    L26:
        if (r22 >= LOWER_CASE_HEX_DIGITS.length()) goto L28;
        r20[LOWER_CASE_HEX_DIGITS.charAt(r22)] = r23;
        r22 = r22 + 1;
        r23 = r23 + 1;
        goto L26
    L28:
        int r24 = 0;
    L30:
        if (r10 >= UPPER_CASE_HEX_DIGITS.length()) goto L32;
        r20[UPPER_CASE_HEX_DIGITS.charAt(r10)] = r24;
        r10 = r10 + 1;
        r24 = r24 + 1;
        goto L30
    L32:
        HEX_DIGITS_TO_LONG_DECIMAL = r20;
    }

    private static final long charsPerSet(long r5, int r10, int r11) {
        if (r10 <= 0) goto L6;
        long r12 = r10;
        return ((r12 - 1) * ((long) r11)) + (r5 * r12);
    L6:
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final int checkContainsAt(String r5, int r10, int r11, String r12, boolean r13, String r14) {
        if (r12.length() != 0) goto L5;
        return r10;
    L5:
        int r15 = r12.length();
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L12;
        if (CharsKt__CharKt.equals(r12.charAt(r16), r5.charAt(r10 + r16), r13) == true) goto L10;
        throwNotContainedAt(r5, r10, r11, r12, r14);
    L10:
        r16 = r16 + 1;
        goto L6
    L12:
        return r12.length() + r10;
    }

    private static final int checkFormatLength(long r5) {
        if (0 > r5) goto L9;
        if (r5 > 2147483647L) goto L9;
        return (int) r5;
    L9:
        throw new IllegalArgumentException("The resulting string length is too big: " + ULong.m344toStringimpl(ULong.m298constructorimpl(r5)));
    }

    private static final void checkMaxDigits(String r5, int r10, int r11, int r12) {
        if (r10 < r11) goto L4;
    L5:
        throwInvalidNumberOfDigits(r5, r10, r11, r12, false);
        return;
    L4:
        if ((r11 - r10) > r12) goto L5;
    }

    private static final int checkNewLineAt(String r5, int r10, int r11) {
        if (r5.charAt(r10) != '\r') goto L10;
        int r12 = r10 + 1;
        if (r12 < r11) goto L7;
        return r12;
    L7:
        if (r5.charAt(r12) == '\n') goto L17;
        return r12;
    L17:
        return r10 + 2;
    L10:
        if (r5.charAt(r10) == '\n') goto L12;
        StringBuilder r13 = j0.s(r10, "Expected a new line at index ", ", but was ");
        r13.append(r5.charAt(r10));
        throw new NumberFormatException(r13.toString());
    L12:
        return r10 + 1;
    }

    private static final void checkPrefixSuffixMaxDigits(String r5, int r10, int r11, String r12, String r13, boolean r14, int r15) {
        if (((r11 - r10) - r12.length()) > r13.length()) goto L5;
        throwInvalidPrefixSuffix(r5, r10, r11, r12, r13);
    L5:
        int r16 = 0;
        if (r12.length() == 0) goto L15;
        int r17 = r12.length();
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L14;
        if (CharsKt__CharKt.equals(r12.charAt(r18), r5.charAt(r10 + r18), r14) == true) goto L13;
        throwNotContainedAt(r5, r10, r11, r12, "prefix");
    L13:
        r18 = r18 + 1;
        goto L9
    L14:
        r10 = r10 + r12.length();
    L15:
        int r19 = r11 - r13.length();
        if (r13.length() == 0) goto L24;
        int r20 = r13.length();
    L19:
        if (r16 >= r20) goto L24;
        if (CharsKt__CharKt.equals(r13.charAt(r16), r5.charAt(r19 + r16), r14) == true) goto L23;
        throwNotContainedAt(r5, r19, r11, r13, "suffix");
    L23:
        r16 = r16 + 1;
    L24:
        checkMaxDigits(r5, r10, r19, r15);
    }

    private static final int decimalFromHexDigitAt(String r5, int r10) {
        char r11 = r5.charAt(r10);
        if ((r11 >>> '\b') != 0) goto L7;
        int r12 = HEX_DIGITS_TO_DECIMAL[r11];
        if (r12 < 0) goto L7;
        return r12;
    L7:
        throwInvalidDigitAt(r5, r10);
        throw new KotlinNothingValueException();
    }

    private static final int formatByteAt(byte[] r5, int r10, String r11, String r12, int[] r13, char[] r14, int r15) {
        return toCharArrayIfNotEmpty(r12, r14, formatByteAt(r5, r10, r13, r14, toCharArrayIfNotEmpty(r11, r14, r15)));
    }

    private static final int formattedStringLength(int r5, int r10, int r11, int r12) {
        if (r5 <= 0) goto L6;
        long r13 = r10;
        return checkFormatLength((r5 * (((((long) r11) + 2) + ((long) r12)) + r13)) - r13);
    L6:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte hexToByte(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return hexToByte(r5, 0, r5.length(), r10);
    }

    public static /* synthetic */ byte hexToByte$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return hexToByte(r5, r10);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte[] hexToByteArray(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return hexToByteArray(r5, 0, r5.length(), r10);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return hexToByteArray(r5, r10);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String r5, int r10, int r11, HexFormat.BytesHexFormat r12) {
        if (r12.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() == false) goto L7;
        return hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(r5, r10, r11, r12);
    L7:
        return hexToByteArrayNoLineAndGroupSeparatorSlowPath(r5, r10, r11, r12);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String r12, int r13, int r14, HexFormat.BytesHexFormat r15) {
        String r5 = r15.getBytePrefix();
        String r10 = r15.getByteSuffix();
        String r11 = r15.getByteSeparator();
        int r16 = r11.length();
        long r17 = r16;
        long r18 = ((((long) r5.length()) + 2) + ((long) r10.length())) + r17;
        long r19 = r14 - r13;
        int r20 = (int) ((r19 + r17) / r18);
        if (((((long) r20) * r18) - r17) == r19) goto L6;
        return null;
    L6:
        boolean r110 = r15.getIgnoreCase$kotlin_stdlib();
        byte[] r21 = new byte[r20];
        int r22 = 0;
        if (r5.length() == 0) goto L16;
        int r23 = r5.length();
        int r24 = 0;
    L10:
        if (r24 >= r23) goto L15;
        if (CharsKt__CharKt.equals(r5.charAt(r24), r12.charAt(r13 + r24), r110) == true) goto L14;
        throwNotContainedAt(r12, r13, r14, r5, "byte prefix");
    L14:
        r24 = r24 + 1;
        goto L10
    L15:
        r13 = r13 + r5.length();
    L16:
        String r25 = j0.D(r10, r11, r5);
        int r26 = r20 - 1;
        int r27 = 0;
    L17:
        if (r27 >= r26) goto L29;
        r21[r27] = parseByteAt(r12, r13);
        r13 = r13 + 2;
        if (r25.length() == 0) goto L28;
        int r28 = r25.length();
        int r29 = 0;
    L22:
        if (r29 >= r28) goto L27;
        if (CharsKt__CharKt.equals(r25.charAt(r29), r12.charAt(r13 + r29), r110) == true) goto L26;
        throwNotContainedAt(r12, r13, r14, r25, "byte suffix + byte separator + byte prefix");
    L26:
        r29 = r29 + 1;
        goto L22
    L27:
        r13 = r25.length() + r13;
    L28:
        r27 = r27 + 1;
        goto L17
    L29:
        r21[r26] = parseByteAt(r12, r13);
        int r111 = r13 + 2;
        if (r10.length() == 0) goto L38;
        int r30 = r10.length();
    L33:
        if (r22 >= r30) goto L38;
        if (CharsKt__CharKt.equals(r10.charAt(r22), r12.charAt(r111 + r22), r110) == true) goto L37;
        throwNotContainedAt(r12, r111, r14, r10, "byte suffix");
    L37:
        r22 = r22 + 1;
    L38:
        return r21;
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String r11, int r12, int r13, HexFormat.BytesHexFormat r14) {
        int r5 = r14.getByteSeparator().length();
        int r10 = 1;
        if (r5 > 1) goto L33;
        int r15 = r13 - r12;
        int r16 = 2;
        int r17 = 0;
        if (r5 != 0) goto L14;
        if ((r15 & 1) == 0) goto L9;
        return null;
    L9:
        int r18 = r15 >> 1;
        byte[] r19 = new byte[r18];
        int r110 = 0;
    L10:
        if (r17 >= r18) goto L12;
        r19[r17] = parseByteAt(r11, r110);
        r110 = r110 + 2;
        r17 = r17 + 1;
        goto L10
    L12:
        return r19;
    L14:
        if ((r15 % 3) == 2) goto L16;
        return null;
    L16:
        int r111 = (r15 / 3) + 1;
        byte[] r20 = new byte[r111];
        char r21 = r14.getByteSeparator().charAt(0);
        r20[0] = parseByteAt(r11, 0);
    L17:
        if (r10 >= r111) goto L31;
        if (r11.charAt(r16) == r21) goto L30;
        String r22 = r14.getByteSeparator();
        boolean r23 = r14.getIgnoreCase$kotlin_stdlib();
        if (r22.length() == 0) goto L30;
        int r24 = r22.length();
        int r25 = 0;
    L24:
        if (r25 >= r24) goto L29;
        if (CharsKt__CharKt.equals(r22.charAt(r25), r11.charAt(r16 + r25), r23) == true) goto L28;
        throwNotContainedAt(r11, r16, r13, r22, "byte separator");
    L28:
        r25 = r25 + 1;
        goto L24
    L29:
        r22.length();
    L30:
        r20[r10] = parseByteAt(r11, r16 + 1);
        r16 = r16 + 3;
        r10 = r10 + 1;
        goto L17
    L31:
        return r20;
    L33:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArraySlowPath(String r19, int r20, int r21, HexFormat.BytesHexFormat r22) {
        int r10 = r22.getBytesPerLine();
        int r11 = r22.getBytesPerGroup();
        String r12 = r22.getBytePrefix();
        String r13 = r22.getByteSuffix();
        String r14 = r22.getByteSeparator();
        String r15 = r22.getGroupSeparator();
        boolean r16 = r22.getIgnoreCase$kotlin_stdlib();
        int r5 = parsedByteArrayMaxSize(r21 - r20, r10, r11, r15.length(), r14.length(), r12.length(), r13.length());
        byte[] r17 = new byte[r5];
        int r18 = r20;
        int r23 = 0;
        int r24 = 0;
        int r25 = 0;
    L3:
        if (r18 >= r21) goto L57;
        if (r24 != r10) goto L7;
        r18 = checkNewLineAt(r19, r18, r21);
        int r26 = 0;
    L6:
        r25 = 0;
    L33:
        int r27 = r26 + 1;
        int r28 = r25 + 1;
        if (r12.length() != 0) goto L36;
        int r110 = r28;
    L44:
        if ((r21 - 2) >= r18) goto L46;
        throwInvalidNumberOfDigits(r19, r18, r21, 2, true);
    L46:
        int r29 = r23 + 1;
        r17[r23] = parseByteAt(r19, r18);
        r18 = r18 + 2;
        if (r13.length() != 0) goto L49;
        int r210 = r29;
    L56:
        r23 = r210;
        r24 = r27;
        r25 = r110;
        goto L3
    L49:
        int r30 = r13.length();
        int r31 = 0;
    L50:
        if (r31 >= r30) goto L55;
        int r211 = r29;
        if (CharsKt__CharKt.equals(r13.charAt(r31), r19.charAt(r18 + r31), r16) == true) goto L54;
        throwNotContainedAt(r19, r18, r21, r13, "byte suffix");
    L54:
        r31 = r31 + 1;
        r29 = r211;
        goto L50
    L55:
        r210 = r29;
        r18 = r13.length() + r18;
        goto L56
    L36:
        int r32 = r12.length();
        int r33 = 0;
    L37:
        if (r33 >= r32) goto L42;
        int r111 = r32;
        int r112 = r28;
        if (CharsKt__CharKt.equals(r12.charAt(r33), r19.charAt(r18 + r33), r16) == true) goto L41;
        throwNotContainedAt(r19, r18, r21, r12, "byte prefix");
    L41:
        r33 = r33 + 1;
        r32 = r111;
        r28 = r112;
        goto L37
    L42:
        r110 = r28;
        r18 = r18 + r12.length();
        goto L44
    L7:
        if (r25 == r11) goto L9;
        int r212 = r24;
        if (r25 != 0) goto L22;
        r26 = r212;
        goto L33
    L22:
        if (r14.length() != 0) goto L24;
        int r113 = r25;
    L31:
        r26 = r212;
        r25 = r113;
        goto L33
    L24:
        int r34 = r14.length();
        int r35 = 0;
    L25:
        if (r35 >= r34) goto L30;
        int r114 = r34;
        int r115 = r25;
        if (CharsKt__CharKt.equals(r14.charAt(r35), r19.charAt(r18 + r35), r16) == true) goto L29;
        throwNotContainedAt(r19, r18, r21, r14, "byte separator");
    L29:
        r35 = r35 + 1;
        r34 = r114;
        r25 = r115;
        goto L25
    L30:
        r113 = r25;
        r18 = r18 + r14.length();
        goto L31
    L9:
        if (r15.length() != 0) goto L11;
        int r213 = r24;
    L18:
        r26 = r213;
        goto L6
    L11:
        int r36 = r15.length();
        int r37 = 0;
    L12:
        if (r37 >= r36) goto L17;
        int r214 = r24;
        int r116 = r36;
        if (CharsKt__CharKt.equals(r15.charAt(r37), r19.charAt(r18 + r37), r16) == true) goto L16;
        throwNotContainedAt(r19, r18, r21, r15, "group separator");
    L16:
        r37 = r37 + 1;
        r24 = r214;
        r36 = r116;
        goto L12
    L17:
        r213 = r24;
        r18 = r18 + r15.length();
        goto L18
    L57:
        if (r23 != r5) goto L60;
        return r17;
    L60:
        return Arrays.copyOf(r17, r23);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final int hexToInt(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return hexToInt(r5, 0, r5.length(), r10);
    }

    public static /* synthetic */ int hexToInt$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return hexToInt(r5, r10);
    }

    @ExperimentalStdlibApi
    private static final int hexToIntImpl(String r10, int r11, int r12, HexFormat r13, int r14) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r11, r12, r10.length());
        HexFormat.NumberHexFormat r15 = r13.getNumber();
        if (r15.isDigitsOnly$kotlin_stdlib() == false) goto L6;
        checkMaxDigits(r10, r11, r12, r14);
        return parseInt(r10, r11, r12);
    L6:
        String r16 = r15.getPrefix();
        String r17 = r15.getSuffix();
        checkPrefixSuffixMaxDigits(r10, r11, r12, r16, r17, r15.getIgnoreCase$kotlin_stdlib(), r14);
        return parseInt(r10, r16.length() + r11, r12 - r17.length());
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final long hexToLong(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return hexToLong(r5, 0, r5.length(), r10);
    }

    public static /* synthetic */ long hexToLong$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return hexToLong(r5, r10);
    }

    @ExperimentalStdlibApi
    private static final long hexToLongImpl(String r10, int r11, int r12, HexFormat r13, int r14) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r11, r12, r10.length());
        HexFormat.NumberHexFormat r15 = r13.getNumber();
        if (r15.isDigitsOnly$kotlin_stdlib() == false) goto L6;
        checkMaxDigits(r10, r11, r12, r14);
        return parseLong(r10, r11, r12);
    L6:
        String r16 = r15.getPrefix();
        String r17 = r15.getSuffix();
        checkPrefixSuffixMaxDigits(r10, r11, r12, r16, r17, r15.getIgnoreCase$kotlin_stdlib(), r14);
        return parseLong(r10, r16.length() + r11, r12 - r17.length());
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final short hexToShort(String r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return hexToShort(r5, 0, r5.length(), r10);
    }

    public static /* synthetic */ short hexToShort$default(String r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return hexToShort(r5, r10);
    }

    private static final long longDecimalFromHexDigitAt(String r5, int r10) {
        char r11 = r5.charAt(r10);
        if ((r11 >>> '\b') != 0) goto L7;
        long r12 = HEX_DIGITS_TO_LONG_DECIMAL[r11];
        if (r12 < 0) goto L7;
        return r12;
    L7:
        throwInvalidDigitAt(r5, r10);
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String r5, int r10) {
        char r11 = r5.charAt(r10);
        if ((r11 >>> '\b') != 0) goto L14;
        int[] r12 = HEX_DIGITS_TO_DECIMAL;
        int r13 = r12[r11];
        if (r13 < 0) goto L14;
        int r14 = r10 + 1;
        char r15 = r5.charAt(r14);
        if ((r15 >>> '\b') != 0) goto L12;
        int r16 = r12[r15];
        if (r16 < 0) goto L12;
        return (byte) ((r13 << 4) | r16);
    L12:
        throwInvalidDigitAt(r5, r14);
        throw new KotlinNothingValueException();
    L14:
        throwInvalidDigitAt(r5, r10);
        throw new KotlinNothingValueException();
    }

    private static final int parseInt(String r5, int r10, int r11) {
        int r12 = 0;
    L3:
        if (r10 >= r11) goto L11;
        int r13 = r12 << 4;
        char r14 = r5.charAt(r10);
        if ((r14 >>> '\b') != 0) goto L9;
        int r15 = HEX_DIGITS_TO_DECIMAL[r14];
        if (r15 < 0) goto L9;
        r12 = r13 | r15;
        r10 = r10 + 1;
    L9:
        throwInvalidDigitAt(r5, r10);
        throw new KotlinNothingValueException();
    L11:
        return r12;
    }

    private static final long parseLong(String r10, int r11, int r12) {
        long r5 = 0;
    L3:
        if (r11 >= r12) goto L11;
        long r13 = r5 << 4;
        char r14 = r10.charAt(r11);
        if ((r14 >>> '\b') != 0) goto L9;
        long r15 = HEX_DIGITS_TO_LONG_DECIMAL[r14];
        if (r15 < 0) goto L9;
        r5 = r13 | r15;
        r11 = r11 + 1;
    L9:
        throwInvalidDigitAt(r10, r11);
        throw new KotlinNothingValueException();
    L11:
        return r5;
    }

    public static final int parsedByteArrayMaxSize(int r17, int r18, int r19, int r20, int r21, int r22, int r23) {
        if (r17 <= 0) goto L17;
        long r5 = (((long) r22) + 2) + ((long) r23);
        long r10 = charsPerSet(r5, r19, r21);
        if (r18 > r19) goto L7;
        long r11 = charsPerSet(r5, r18, r21);
    L10:
        long r12 = r17;
        long r13 = wholeElementsPerSet(r12, r11, 1);
        long r14 = r12 - ((r11 + 1) * r13);
        long r15 = wholeElementsPerSet(r14, r10, r20);
        long r16 = r14 - ((r10 + ((long) r20)) * r15);
        long r24 = wholeElementsPerSet(r16, r5, r21);
        if ((r16 - ((r5 + ((long) r21)) * r24)) <= 0) goto L13;
        int r25 = 1;
    L15:
        return (int) ((((r15 * ((long) r19)) + (r13 * ((long) r18))) + r24) + ((long) r25));
    L13:
        r25 = 0;
        goto L15
    L7:
        r11 = charsPerSet(r10, r18 / r19, r20);
        int r110 = r18 % r19;
        if (r110 == 0) goto L10;
        r11 = (r11 + ((long) r20)) + charsPerSet(r5, r110, r21);
        goto L10
    L17:
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final Void throwInvalidDigitAt(String r5, int r10) {
        StringBuilder r11 = j0.s(r10, "Expected a hexadecimal digit at index ", ", but was ");
        r11.append(r5.charAt(r10));
        throw new NumberFormatException(r11.toString());
    }

    private static final void throwInvalidNumberOfDigits(String r5, int r10, int r11, int r12, boolean r13) {
        if (r13 == false) goto L4;
        String r14 = "exactly";
    L5:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        throw new NumberFormatException("Expected " + r14 + ' ' + r12 + " hexadecimal digits at index " + r10 + ", but was " + r5.substring(r10, r11) + " of length " + (r11 - r10));
    L4:
        r14 = "at most";
        goto L5
    }

    private static final void throwInvalidPrefixSuffix(String r5, int r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        String r14 = r5.substring(r10, r11);
        StringBuilder r15 = a.y("Expected a hexadecimal number with prefix \"", r12, "\" and suffix \"", r13, "\", but was ");
        r15.append(r14);
        throw new NumberFormatException(r15.toString());
    }

    private static final void throwNotContainedAt(String r5, int r10, int r11, String r12, String r13) {
        int r14 = RangesKt.coerceAtMost(r12.length() + r10, r11);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        String r15 = r5.substring(r10, r14);
        StringBuilder r16 = a.y("Expected ", r13, " \"", r12, "\" at index ");
        r16.append(r10);
        r16.append(", but was ");
        r16.append(r15);
        throw new NumberFormatException(r16.toString());
    }

    private static final int toCharArrayIfNotEmpty(String r5, char[] r10, int r11) {
        int r12 = r5.length();
        if (r12 == 0) goto L9;
        if (r12 == 1) goto L7;
        int r13 = r5.length();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.String");
        r5.getChars(0, r13, r10, r11);
        goto L9
    L7:
        r10[r11] = r5.charAt(0);
    L9:
        return r5.length() + r11;
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte[] r5, HexFormat r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "format");
        return toHexString(r5, 0, r5.length, r10);
    }

    public static /* synthetic */ String toHexString$default(byte[] r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r5, r10);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringImpl(long r14, HexFormat.NumberHexFormat r16, String r17, int r18) {
        if ((r18 & 3) != 0) goto L23;
        int r5 = r18 >> 2;
        String r10 = r16.getPrefix();
        String r11 = r16.getSuffix();
        boolean r12 = r16.getRemoveLeadingZeros();
        int r13 = checkFormatLength((((long) r10.length()) + ((long) r5)) + ((long) r11.length()));
        char[] r15 = new char[r13];
        boolean r19 = r12;
        int r20 = 0;
        int r21 = toCharArrayIfNotEmpty(r10, r15, 0);
        int r22 = r18;
    L6:
        if (r20 >= r5) goto L17;
        r22 = r22 - 4;
        int r110 = (int) ((r14 >> r22) & 15);
        if (r19 == false) goto L12;
        if (r110 != 0) goto L12;
        if (r22 <= 0) goto L12;
        r19 = true;
    L13:
        if (r19 == true) goto L16;
        r15[r21] = r17.charAt(r110);
        r21 = r21 + 1;
    L16:
        r20 = r20 + 1;
    L12:
        r19 = false;
        goto L13
    L17:
        int r23 = toCharArrayIfNotEmpty(r11, r15, r21);
        if (r23 != r13) goto L21;
        return StringsKt__StringsJVMKt.concatToString(r15);
    L21:
        return StringsKt__StringsJVMKt.concatToString$default(r15, 0, r23, 1, null);
    L23:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @ExperimentalStdlibApi
    private static final String toHexStringNoLineAndGroupSeparator(byte[] r5, int r10, int r11, HexFormat.BytesHexFormat r12, int[] r13) {
        if (r12.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() == false) goto L7;
        return toHexStringShortByteSeparatorNoPrefixAndSuffix(r5, r10, r11, r12, r13);
    L7:
        return toHexStringNoLineAndGroupSeparatorSlowPath(r5, r10, r11, r12, r13);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] r10, int r11, int r12, HexFormat.BytesHexFormat r13, int[] r14) {
        String r15 = r13.getBytePrefix();
        String r16 = r13.getByteSuffix();
        String r17 = r13.getByteSeparator();
        char[] r18 = new char[formattedStringLength(r12 - r11, r17.length(), r15.length(), r16.length())];
        int r5 = formatByteAt(r10, r11, r15, r16, r14, r18, 0);
    L3:
        r11 = r11 + 1;
        if (r11 >= r12) goto L7;
        r5 = formatByteAt(r10, r11, r15, r16, r14, r18, toCharArrayIfNotEmpty(r17, r18, r5));
        goto L3
    L7:
        return StringsKt__StringsJVMKt.concatToString(r18);
    }

    @ExperimentalStdlibApi
    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] r10, int r11, int r12, HexFormat.BytesHexFormat r13, int[] r14) {
        int r5 = r13.getByteSeparator().length();
        if (r5 > 1) goto L17;
        int r15 = r12 - r11;
        int r16 = 0;
        if (r5 != 0) goto L11;
        char[] r17 = new char[checkFormatLength(((long) r15) * 2)];
    L7:
        if (r11 >= r12) goto L10;
        r16 = formatByteAt(r10, r11, r14, r17, r16);
        r11 = r11 + 1;
        goto L7
    L10:
        return StringsKt__StringsJVMKt.concatToString(r17);
    L11:
        char[] r18 = new char[checkFormatLength((((long) r15) * 3) - 1)];
        char r19 = r13.getByteSeparator().charAt(0);
        int r20 = formatByteAt(r10, r11, r14, r18, 0);
        int r21 = r11 + 1;
    L12:
        if (r21 >= r12) goto L15;
        r18[r20] = r19;
        r20 = formatByteAt(r10, r21, r14, r18, r20 + 1);
        r21 = r21 + 1;
        goto L12
    L15:
        return StringsKt__StringsJVMKt.concatToString(r18);
    L17:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @ExperimentalStdlibApi
    private static final String toHexStringSlowPath(byte[] r21, int r22, int r23, HexFormat.BytesHexFormat r24, int[] r25) {
        int r10 = r24.getBytesPerLine();
        int r11 = r24.getBytesPerGroup();
        String r12 = r24.getBytePrefix();
        String r13 = r24.getByteSuffix();
        String r14 = r24.getByteSeparator();
        String r15 = r24.getGroupSeparator();
        int r16 = formattedStringLength(r23 - r22, r10, r11, r15.length(), r14.length(), r12.length(), r13.length());
        char[] r17 = new char[r16];
        int r18 = r22;
        int r5 = 0;
        int r19 = 0;
        int r20 = 0;
    L3:
        if (r18 >= r23) goto L12;
        if (r19 != r10) goto L6;
        r17[r5] = '\n';
        r5 = r5 + 1;
        int r110 = 0;
        int r111 = 0;
    L9:
        if (r111 == 0) goto L11;
        r5 = toCharArrayIfNotEmpty(r14, r17, r5);
    L11:
        r5 = formatByteAt(r21, r18, r12, r13, r25, r17, r5);
        r20 = r111 + 1;
        r19 = r110 + 1;
        r18 = r18 + 1;
        goto L3
    L6:
        if (r20 != r11) goto L8;
        r5 = toCharArrayIfNotEmpty(r15, r17, r5);
        r110 = r19;
        r111 = 0;
        goto L9
    L8:
        r110 = r19;
        r111 = r20;
        goto L9
    L12:
        if (r5 != r16) goto L16;
        return StringsKt__StringsJVMKt.concatToString(r17);
    L16:
        throw new IllegalStateException("Check failed.");
    }

    private static final long wholeElementsPerSet(long r5, long r10, int r11) {
        if (r5 > 0) goto L5;
        return 0;
    L5:
        if (r10 <= 0) goto L10;
        long r12 = r11;
        return (r5 + r12) / (r10 + r12);
    L10:
        return 0;
    }

    @ExperimentalStdlibApi
    private static final byte hexToByte(String r5, int r10, int r11, HexFormat r12) {
        return (byte) hexToIntImpl(r5, r10, r11, r12, 2);
    }

    public static /* synthetic */ byte hexToByte$default(String r5, int r10, int r11, HexFormat r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = HexFormat.Companion.getDefault();
    L12:
        return hexToByte(r5, r10, r11, r12);
    }

    @ExperimentalStdlibApi
    private static final byte[] hexToByteArray(String r5, int r10, int r11, HexFormat r12) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r5.length());
        if (r10 == r11) goto L5;
        HexFormat.BytesHexFormat r13 = r12.getBytes();
        if (r13.getNoLineAndGroupSeparator$kotlin_stdlib() == false) goto L12;
        byte[] r14 = hexToByteArrayNoLineAndGroupSeparator(r5, r10, r11, r13);
        if (r14 == null) goto L12;
        return r14;
    L12:
        return hexToByteArraySlowPath(r5, r10, r11, r13);
    L5:
        return new byte[0];
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String r5, int r10, int r11, HexFormat r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = HexFormat.Companion.getDefault();
    L12:
        return hexToByteArray(r5, r10, r11, r12);
    }

    @ExperimentalStdlibApi
    private static final int hexToInt(String r5, int r10, int r11, HexFormat r12) {
        return hexToIntImpl(r5, r10, r11, r12, 8);
    }

    public static /* synthetic */ int hexToInt$default(String r5, int r10, int r11, HexFormat r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = HexFormat.Companion.getDefault();
    L12:
        return hexToInt(r5, r10, r11, r12);
    }

    @ExperimentalStdlibApi
    private static final long hexToLong(String r5, int r10, int r11, HexFormat r12) {
        return hexToLongImpl(r5, r10, r11, r12, 16);
    }

    public static /* synthetic */ long hexToLong$default(String r5, int r10, int r11, HexFormat r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = HexFormat.Companion.getDefault();
    L12:
        return hexToLong(r5, r10, r11, r12);
    }

    @ExperimentalStdlibApi
    private static final short hexToShort(String r5, int r10, int r11, HexFormat r12) {
        return (short) hexToIntImpl(r5, r10, r11, r12, 4);
    }

    public static /* synthetic */ short hexToShort$default(String r5, int r10, int r11, HexFormat r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = HexFormat.Companion.getDefault();
    L12:
        return hexToShort(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte[] r5, int r10, int r11, HexFormat r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r12, "format");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r5.length);
        if (r10 != r11) goto L7;
        return "";
    L7:
        if (r12.getUpperCase() == false) goto L9;
        int[] r13 = BYTE_TO_UPPER_CASE_HEX_DIGITS;
    L10:
        HexFormat.BytesHexFormat r14 = r12.getBytes();
        if (r14.getNoLineAndGroupSeparator$kotlin_stdlib() == false) goto L15;
        return toHexStringNoLineAndGroupSeparator(r5, r10, r11, r14, r13);
    L15:
        return toHexStringSlowPath(r5, r10, r11, r14, r13);
    L9:
        r13 = BYTE_TO_LOWER_CASE_HEX_DIGITS;
        goto L10
    }

    public static /* synthetic */ String toHexString$default(byte[] r5, int r10, int r11, HexFormat r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.length;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = HexFormat.Companion.getDefault();
    L12:
        return toHexString(r5, r10, r11, r12);
    }

    public static final int formattedStringLength(int r5, int r10, int r11, int r12, int r13, int r14, int r15) {
        if (r5 <= 0) goto L10;
        int r16 = r5 - 1;
        int r17 = r16 / r10;
        int r18 = (r10 - 1) / r11;
        int r19 = r5 % r10;
        if (r19 == 0) goto L7;
        r10 = r19;
    L7:
        int r20 = (r18 * r17) + ((r10 - 1) / r11);
        int r21 = (r16 - r17) - r20;
        return checkFormatLength((((((long) r14) + 2) + ((long) r15)) * ((long) r5)) + ((((long) r21) * ((long) r13)) + ((((long) r20) * ((long) r12)) + r17)));
    L10:
        throw new IllegalArgumentException("Failed requirement.");
    }

    private static final int formatByteAt(byte[] r5, int r10, int[] r11, char[] r12, int r13) {
        int r14 = r11[r5[r10] & UByte.MAX_VALUE];
        r12[r13] = (char) (r14 >> 8);
        r12[r13 + 1] = (char) (r14 & 255);
        return r13 + 2;
    }

    public static /* synthetic */ String toHexString$default(byte r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r5, r10);
    }

    public static /* synthetic */ String toHexString$default(short r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r5, r10);
    }

    public static /* synthetic */ String toHexString$default(int r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r5, r10);
    }

    public static /* synthetic */ String toHexString$default(long r5, HexFormat r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r5, r10);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(byte r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        if (r11.getUpperCase() == false) goto L5;
        String r5 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r12 = r11.getNumber();
        if (r12.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r13 = {r5.charAt((r10 >> 4) & 15), r5.charAt(r10 & 15)};
        if (r12.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt__StringsJVMKt.concatToString$default(r13, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(r10 & UByte.MAX_VALUE) - 24) >> 2, 1), 0, 2, null);
    L12:
        return StringsKt__StringsJVMKt.concatToString(r13);
    L14:
        return toHexStringImpl(r10, r12, r5, 8);
    L5:
        r5 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(short r10, HexFormat r11) {
        Intrinsics.checkNotNullParameter(r11, "format");
        if (r11.getUpperCase() == false) goto L5;
        String r5 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r12 = r11.getNumber();
        if (r12.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r13 = {r5.charAt((r10 >> 12) & 15), r5.charAt((r10 >> 8) & 15), r5.charAt((r10 >> 4) & 15), r5.charAt(r10 & 15)};
        if (r12.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt__StringsJVMKt.concatToString$default(r13, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(r10 & UShort.MAX_VALUE) - 16) >> 2, 3), 0, 2, null);
    L12:
        return StringsKt__StringsJVMKt.concatToString(r13);
    L14:
        return toHexStringImpl(r10, r12, r5, 16);
    L5:
        r5 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(int r14, HexFormat r15) {
        Intrinsics.checkNotNullParameter(r15, "format");
        if (r15.getUpperCase() == false) goto L5;
        String r5 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r16 = r15.getNumber();
        if (r16.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r10 = {r5.charAt((r14 >> 28) & 15), r5.charAt((r14 >> 24) & 15), r5.charAt((r14 >> 20) & 15), r5.charAt((r14 >> 16) & 15), r5.charAt((r14 >> 12) & 15), r5.charAt((r14 >> 8) & 15), r5.charAt((r14 >> 4) & 15), r5.charAt(r14 & 15)};
        if (r16.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt__StringsJVMKt.concatToString$default(r10, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(r14) >> 2, 7), 0, 2, null);
    L12:
        return StringsKt__StringsJVMKt.concatToString(r10);
    L14:
        return toHexStringImpl(r14, r16, r5, 32);
    L5:
        r5 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String toHexString(long r27, HexFormat r29) {
        Intrinsics.checkNotNullParameter(r29, "format");
        if (r29.getUpperCase() == false) goto L5;
        String r10 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r11 = r29.getNumber();
        if (r11.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r12 = {r10.charAt((int) ((r27 >> 60) & 15)), r10.charAt((int) ((r27 >> 56) & 15)), r10.charAt((int) ((r27 >> 52) & 15)), r10.charAt((int) ((r27 >> 48) & 15)), r10.charAt((int) ((r27 >> 44) & 15)), r10.charAt((int) ((r27 >> 40) & 15)), r10.charAt((int) ((r27 >> 36) & 15)), r10.charAt((int) ((r27 >> 32) & 15)), r10.charAt((int) ((r27 >> 28) & 15)), r10.charAt((int) ((r27 >> 24) & 15)), r10.charAt((int) ((r27 >> 20) & 15)), r10.charAt((int) ((r27 >> 16) & 15)), r10.charAt((int) ((r27 >> 12) & 15)), r10.charAt((int) ((r27 >> 8) & 15)), r10.charAt((int) ((r27 >> 4) & 15)), r10.charAt((int) (15 & r27))};
        if (r11.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt__StringsJVMKt.concatToString$default(r12, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(r27) >> 2, 15), 0, 2, null);
    L12:
        return StringsKt__StringsJVMKt.concatToString(r12);
    L14:
        return toHexStringImpl(r27, r11, r10, 64);
    L5:
        r10 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }
}
