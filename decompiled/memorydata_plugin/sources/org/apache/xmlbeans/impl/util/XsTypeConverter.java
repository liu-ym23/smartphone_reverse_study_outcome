package org.apache.xmlbeans.impl.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.net.URI;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;

/* JADX INFO: loaded from: classes7.dex */
public final class XsTypeConverter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char[] CH_ZEROS = null;
    private static final BigDecimal DECIMAL__ZERO = null;
    private static final String[] URI_CHARS_REPLACED_WITH = null;
    private static final String[] URI_CHARS_TO_BE_REPLACED = null;

    static {
        DECIMAL__ZERO = new BigDecimal(0.0d);
        URI_CHARS_TO_BE_REPLACED = new String[]{" ", "{", "}", "|", "\\", "^", "[", "]", "`"};
        URI_CHARS_REPLACED_WITH = new String[]{"%20", "%7b", "%7d", "%7c", "%5c", "%5e", "%5b", "%5d", "%60"};
        CH_ZEROS = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
    }

    public XsTypeConverter() {
    }

    public static CharSequence lexAnyURI(CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder(r7.toString());
        int r2 = 0;
    L4:
        if (r2 >= URI_CHARS_TO_BE_REPLACED.length) goto L15;
        int r3 = 0;
    L6:
        int r4 = r0.indexOf(URI_CHARS_TO_BE_REPLACED[r2], r3);
        if (r4 < 0) goto L9;
        r0.replace(r4, r4 + 1, URI_CHARS_REPLACED_WITH[r2]);
        r3 = r4 + 3;
        goto L6
    L9:
        r2 = r2 + 1;
        goto L4
    L15:
        URI.create(r0.toString());     // Catch: IllegalArgumentException -> L12
        return r7;
    L12:
        e = move-exception;
        throw new InvalidLexicalValueException("invalid anyURI value: " + r7, e);
    }

    public static double lexDouble(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        String r0 = r5.toString();
    L14:
        e = move-exception;
        if (r0.equals("INF") == false) goto L20;
        return Double.POSITIVE_INFINITY;
    L20:
        if (r0.equals("-INF") == false) goto L24;
        return Double.NEGATIVE_INFINITY;
    L24:
        if (r0.equals("NaN") == false) goto L27;
        return Double.NaN;
    L27:
        throw e;
    L4:
        if (r5.length() <= 0) goto L13;
        char r6 = r5.charAt(r5.length() - 1);     // Catch: NumberFormatException -> L14
        if (r6 == 'd') goto L11;
        if (r6 != 'D') goto L13;
    L11:
        throw new NumberFormatException("Invalid char '" + r6 + "' in double.");     // Catch: NumberFormatException -> L14
    L13:
        return Double.parseDouble(r0);
    }

    public static float lexFloat(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        String r0 = r5.toString();
    L16:
        e = move-exception;
        if (r0.equals("INF") == false) goto L22;
        return Float.POSITIVE_INFINITY;
    L22:
        if (r0.equals("-INF") == false) goto L26;
        return Float.NEGATIVE_INFINITY;
    L26:
        if (r0.equals("NaN") == false) goto L29;
        return Float.NaN;
    L29:
        throw e;
    L4:
        if (r5.length() <= 0) goto L15;
        char r1 = r5.charAt(r5.length() - 1);     // Catch: NumberFormatException -> L16
        if (r1 == 'f') goto L10;
        if (r1 != 'F') goto L15;
    L10:
        if (r5.charAt(r5.length() - 2) == 'N') goto L15;
        throw new NumberFormatException("Invalid char '" + r1 + "' in float.");     // Catch: NumberFormatException -> L16
    L15:
        return Float.parseFloat(r0);
    }

    public static int lexInt(CharSequence r2) {
        return parseInt((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static long lexLong(CharSequence r2) {
        return Long.parseLong(trimInitialPlus(((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString()));
    }

    private static int parseInt(CharSequence r2) {
        return parseIntXsdNumber((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int parseIntXsdNumber(CharSequence r10, int r11, int r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r13.length();
        int r3 = 1;
        if (r0 < 1) goto L28;
        int r4 = 0;
        char r5 = r13.charAt(0);
        if (r5 != '-') goto L8;
        int r14 = r11 / 10;
        int r15 = -(r11 % 10);
        int r6 = 1;
    L12:
        int r7 = 0;
    L14:
        if (r4 >= (r0 - r6)) goto L26;
        int r8 = Character.digit(r13.charAt(r4 + r6), 10);
        if (r8 < 0) goto L24;
        if (r7 < r14) goto L22;
        if (r7 != r14) goto L20;
        if (r8 > r15) goto L22;
    L20:
        r7 = (r7 * 10) - r8;
        r4 = r4 + 1;
    L22:
        throw new NumberFormatException("For input string: \"" + r13.toString() + "\"");
    L24:
        throw new NumberFormatException("For input string: \"" + r13.toString() + "\"");
    L26:
        return r3 * r7;
    L8:
        if (r5 != '+') goto L10;
        int r16 = -(r12 / 10);
        int r17 = r12 % 10;
        r6 = 1;
    L11:
        r3 = -1;
        int r9 = r17;
        r14 = r16;
        r15 = r9;
        goto L12
    L10:
        r16 = -(r12 / 10);
        r17 = r12 % 10;
        r6 = 0;
        goto L11
    L28:
        throw new NumberFormatException("For input string: \"" + r13.toString() + "\"");
    }

    public static String printDecimal(BigDecimal r7) {
        String r0 = r7.unscaledValue().toString();
        int r1 = r7.scale();
        if (r1 != 0) goto L5;
    L32:
        return r0;
    L5:
        if (r7.longValue() != 0) goto L9;
        if (r1 < 0) goto L32;
    L9:
        if (r7.signum() >= 0) goto L11;
        int r8 = 1;
    L12:
        StringBuilder r4 = new StringBuilder((r0.length() + 1) + Math.abs(r1));
        if (r8 != 1) goto L15;
        r4.append('-');
    L15:
        if (r1 <= 0) goto L25;
        int r2 = r1 - (r0.length() - r8);
        if (r2 < 0) goto L23;
        r4.append("0.");
    L19:
        char[] r3 = CH_ZEROS;
        if (r2 <= r3.length) goto L22;
        r4.append(r3);
        r2 = r2 - r3.length;
        goto L19
    L22:
        r4.append(r3, 0, r2);
        String r9 = r0.substring(r8);
    L24:
        r4.append(r9);
    L31:
        return r4.toString();
    L23:
        int r5 = r8 - r2;
        r4.append(r0.substring(r8, r5));
        r4.append('.');
        r9 = r0.substring(r5);
        goto L24
    L25:
        r4.append(r0.substring(r8));
    L26:
        char[] r10 = CH_ZEROS;
        if (r1 >= (-r10.length)) goto L29;
        r4.append(r10);
        r1 = r1 + r10.length;
        goto L26
    L29:
        r4.append(r10, 0, -r1);
        goto L31
    L11:
        r8 = 0;
        goto L12
    }

    private static String trimInitialPlus(String r2) {
        if (r2.length() > 0) goto L5;
        return r2;
    L5:
        if (r2.charAt(0) == '+') goto L7;
        return r2;
    L7:
        return r2.substring(1);
    }
}
