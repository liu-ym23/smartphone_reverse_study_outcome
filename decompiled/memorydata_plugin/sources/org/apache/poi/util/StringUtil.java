package org.apache.poi.util;

import com.obric.capabilitykit.common.ErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public final class StringUtil {
    private static int MAX_RECORD_LENGTH = 10000000;
    public static final Charset UTF16LE = null;
    public static final Charset UTF8 = null;
    public static final Charset WIN_1252 = null;
    private static final int[] symbolMap_f020 = null;
    private static final int[] symbolMap_f0a0 = null;

    static {
        UTF16LE = StandardCharsets.UTF_16LE;
        UTF8 = StandardCharsets.UTF_8;
        WIN_1252 = Charset.forName("cp1252");
        symbolMap_f020 = new int[]{32, 33, 8704, 35, 8707, 37, 38, 8717, 40, 41, 8727, 43, 44, 8722, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, 91, 8765, 93, 8869, 95, 32, 945, 946, 967, 948, 949, 966, 947, 951, 953, 981, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, 123, 124, 125, 8764, 32};
        symbolMap_f0a0 = new int[]{8364, 978, 8242, 8804, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8591, 8593, 8594, 8595, 176, 177, 8243, 8805, 215, 181, 8706, 8729, 247, 8800, 8801, 8776, 8230, 9168, 9135, 8629, 8501, 8475, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, 174, 169, 8482, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, ErrorCode.Message.MESSAGE_SEND_NO_SIM, 174, 169, 8482, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 32, ErrorCode.Message.MESSAGE_SEND_AIRPLANE_MODE, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 32};
    }

    public static int countMatches(CharSequence r4, char r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r1 = r6.length();
        int r2 = 0;
    L6:
        if (r0 >= r1) goto L11;
        if (r6.charAt(r0) != r5) goto L10;
        r2 = r2 + 1;
    L10:
        r0 = r0 + 1;
        goto L6
    L11:
        return r2;
    }

    public static boolean endsWithIgnoreCase(String r6, String r7) {
        int r5 = r7.length();
        return r6.regionMatches(true, r6.length() - r5, r7, 0, r5);
    }

    public static int getEncodedSize(String r1) {
        int r0 = r1.length();
        if (hasMultibyte(r1) == false) goto L5;
        int r2 = 2;
    L7:
        return (r0 * r2) + 3;
    L5:
        r2 = 1;
        goto L7
    }

    public static String getFromCompressedUnicode(byte[] r2, int r3, int r4) {
        return new String(r2, r3, Math.min(r4, r2.length - r3), StandardCharsets.ISO_8859_1);
    }

    public static String getFromUnicodeLE(byte[] r2) {
        if (r2.length != 0) goto L7;
        return "";
    L7:
        return getFromUnicodeLE(r2, 0, r2.length / 2);
    }

    public static String getFromUnicodeLE(byte[] r2, int r3, int r4) {
        if (r4 != 0) goto L5;
        return "";
    L5:
        if (r3 < 0) goto L16;
        if (r3 >= r2.length) goto L16;
        if (r4 < 0) goto L14;
        if (((r2.length - r3) / 2) < r4) goto L14;
        return new String(r2, r3, r4 * 2, UTF16LE);
    L14:
        throw new IllegalArgumentException("Illegal length " + r4);
    L16:
        throw new ArrayIndexOutOfBoundsException("Illegal offset " + r3 + " (String data is of length " + r2.length + ")");
    }

    public static String getFromUnicodeLE0Terminated(byte[] r5, int r6, int r7) {
        if (r6 < 0) goto L42;
        if (r6 >= r5.length) goto L42;
        if (r7 < 0) goto L40;
        if (((r5.length - r6) / 2) < r7) goto L40;
        String r0 = "";
        int r1 = 0;
        if (r7 > 0) goto L11;
    L25:
        String r2 = "";
    L26:
        if (r1 >= r7) goto L33;
        int r3 = (r1 * 2) + r6;
        if (r5[r3] != 0) goto L32;
        if (r5[r3 + 1] == 0) goto L33;
    L32:
        r1 = r1 + 1;
    L33:
        int r8 = Math.min(r1, r7);
        StringBuilder r4 = new StringBuilder().append(r2);
        if (r8 == 0) goto L38;
        r0 = new String(r5, r6, r8 * 2, UTF16LE);
    L38:
        return r4.append(r0).toString();
    L11:
        if (r6 >= (r5.length - 1)) goto L25;
        if (r5[r6] != 0) goto L25;
        if (r5[r6 + 1] != 0) goto L25;
        r6 = r6 + 2;
        if (r7 <= 1) goto L19;
        short r9 = LittleEndian.getShort(r5, r6);
    L21:
        if (Character.isJavaIdentifierPart(r9) == false) goto L23;
        r7 = r7 - 1;
    L24:
        r2 = "?";
        goto L26
    L23:
        r7 = 0;
        goto L24
    L19:
        r9 = 0;
    L40:
        throw new IllegalArgumentException("Illegal length " + r7);
    L42:
        throw new ArrayIndexOutOfBoundsException("Illegal offset " + r6 + " (String data is of length " + r5.length + ")");
    }

    public static byte[] getToUnicodeLE(String r1) {
        return r1.getBytes(UTF16LE);
    }

    public static boolean hasMultibyte(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        char[] r6 = r5.toCharArray();
        int r1 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r6[r2] > 255) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static boolean isBlank(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = length(r6);
        if (r0 != 0) goto L5;
        return true;
    L5:
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L11;
        if (Character.isWhitespace(r6.charAt(r3)) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static boolean isNotBlank(CharSequence r2) {
        return !isBlank((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static boolean isUpperCase(char r1) {
        String r2 = Character.toString(r1);
        return r2.toUpperCase(Locale.ROOT).equals(r2);
    }

    public static int length(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return 0;
    L6:
        return r3.length();
    }

    public static void putCompressedUnicode(String r2, LittleEndianOutput r3) {
        ((LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin")).write(r2.getBytes(StandardCharsets.ISO_8859_1));
    }

    public static void putUnicodeLE(String r2, LittleEndianOutput r3) {
        ((LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin")).write(r2.getBytes(UTF16LE));
    }

    public static String readCompressedUnicode(LittleEndianInput r2, int r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte[] r5 = IOUtils.safelyAllocate(r3, MAX_RECORD_LENGTH);
        r4.readFully(r5);
        return new String(r5, StandardCharsets.ISO_8859_1);
    }

    public static String readUnicodeLE(LittleEndianInput r4, int r5) {
        LittleEndianInput r6 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte[] r7 = IOUtils.safelyAllocate(((long) r5) * 2, MAX_RECORD_LENGTH);
        r6.readFully(r7);
        return new String(r7, UTF16LE);
    }

    public static String readUnicodeString(LittleEndianInput r2) {
        LittleEndianInput r3 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r0 = r3.readUShort();
        if ((r3.readByte() & 1) != 0) goto L7;
        return readCompressedUnicode(r3, r0);
    L7:
        return readUnicodeLE(r3, r0);
    }

    public static String readUnicodeString(LittleEndianInput r2, int r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianInput.class, "com.obric.memorydata.plugin");
        if ((r4.readByte() & 1) != 0) goto L7;
        return readCompressedUnicode(r4, r3);
    L7:
        return readUnicodeLE(r4, r3);
    }

    public static String repeat(char r0, int r1) {
        if (r1 > 0) goto L5;
        return "";
    L5:
        char[] r2 = new char[r1];
        Arrays.fill(r2, r0);
        return new String(r2);
    }

    public static String toLowerCase(char r1) {
        return Character.toString(r1).toLowerCase(Locale.ROOT);
    }

    public static String toUpperCase(char r1) {
        return Character.toString(r1).toUpperCase(Locale.ROOT);
    }

    public static void writeUnicodeString(LittleEndianOutput r2, String r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r2, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r4.writeShort(r3.length());
        boolean r0 = hasMultibyte(r3);
        r4.writeByte(r0 ? 1 : 0);
        if (r0 == false) goto L5;
        putUnicodeLE(r3, r4);
        return;
    L5:
        putCompressedUnicode(r3, r4);
    }
}
