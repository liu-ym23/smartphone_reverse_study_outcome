package androidx.room.jarjarred.org.antlr.v4.misc;

import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CharSupport {
    public static String[] ANTLRLiteralCharValueEscape;
    public static int[] ANTLRLiteralEscapedCharValue;

    static {
        int[] r5 = new int[255];
        ANTLRLiteralEscapedCharValue = r5;
        String[] r10 = new String[255];
        ANTLRLiteralCharValueEscape = r10;
        r5[110(0x6e, float:1.54E-43)] = 10;
        r5[114(0x72, float:1.6E-43)] = 13;
        r5[116(0x74, float:1.63E-43)] = 9;
        r5[98] = 8;
        r5[102(0x66, float:1.43E-43)] = 12;
        r5[92] = 92;
        r10[10] = "\\n";
        r10[13] = "\\r";
        r10[9] = "\\t";
        r10[8] = "\\b";
        r10[12] = "\\f";
        r10[92] = "\\\\";
    }

    public CharSupport() {
    }

    public static String capitalize(String r5) {
        return Character.toUpperCase(r5.charAt(0)) + r5.substring(1);
    }

    public static String getANTLRCharLiteralForChar(int r5) {
        if (r5 >= 0) goto L5;
        String r10 = Grammar.INVALID_TOKEN_NAME;
    L26:
        return a.p("'", '\'', r10);
    L5:
        String[] r11 = ANTLRLiteralCharValueEscape;
        if (r5 >= r11.length) goto L8;
        String r12 = r11[r5];
    L9:
        if (r12 == null) goto L11;
        r10 = r12;
        goto L26
    L11:
        char r13 = (char) r5;
        if (Character.UnicodeBlock.of(r13) != Character.UnicodeBlock.BASIC_LATIN) goto L22;
        if (Character.isISOControl(r13) == true) goto L22;
        if (r5 != 92) goto L18;
        r10 = "\\\\";
        goto L26
    L18:
        if (r5 != 39) goto L20;
        r10 = "\\'";
        goto L26
    L20:
        r10 = Character.toString(r13);
    L22:
        if (r5 > 65535) goto L24;
        r10 = String.format("\\u%04X", new Object[]{Integer.valueOf(r5)});
        goto L26
    L24:
        r10 = String.format("\\u{%06X}", new Object[]{Integer.valueOf(r5)});
        goto L26
    L8:
        r12 = null;
        goto L9
    }

    public static int getCharValueFromCharInGrammarLiteral(String r10) {
        int r5 = r10.length();
        if (r5 == 1) goto L33;
        int r11 = 2;
        if (r5 == 2) goto L23;
        if (r5 == 6) goto L14;
        if (r10.startsWith("\\u{") == true) goto L11;
        return -1;
    L11:
        return parseHexValue(r10, 3, r10.indexOf(125));
    L14:
        if (r10.startsWith("\\u") == true) goto L17;
        return -1;
    L17:
        if (r10.charAt(2) != '{') goto L19;
        int r12 = r10.indexOf(125);
        r11 = 3;
    L21:
        return parseHexValue(r10, r11, r12);
    L19:
        r12 = r10.length();
        goto L21
    L23:
        if (r10.charAt(0) == '\\') goto L25;
        return -1;
    L25:
        char r13 = r10.charAt(1);
        if (r13 != '\'') goto L28;
        return r13;
    L28:
        int r14 = ANTLRLiteralEscapedCharValue[r13];
        if (r14 != 0) goto L31;
        return -1;
    L31:
        return r14;
    L33:
        return r10.charAt(0);
    }

    public static int getCharValueFromGrammarCharLiteral(String r5) {
        if (r5 != null) goto L4;
        return -1;
    L4:
        if (r5.length() >= 3) goto L7;
        return -1;
    L7:
        return getCharValueFromCharInGrammarLiteral(r5.substring(1, r5.length() - 1));
    }

    public static String getIntervalSetEscapedString(IntervalSet r5) {
        StringBuilder r10 = new StringBuilder();
        Iterator<Interval> r11 = r5.getIntervals().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Interval r12 = r11.next();
        r10.append(getRangeEscapedString(r12.f665a, r12.f666b));
        if (r11.hasNext() == false) goto L4;
        r10.append(" | ");
        goto L4
    L9:
        return r10.toString();
    }

    public static String getRangeEscapedString(int r5, int r10) {
        if (r5 == r10) goto L5;
        return getANTLRCharLiteralForChar(r5) + ".." + getANTLRCharLiteralForChar(r10);
    L5:
        return getANTLRCharLiteralForChar(r5);
    }

    public static String getStringFromGrammarStringLiteral(String r11) {
        StringBuilder r5 = new StringBuilder();
        int r10 = 1;
        int r12 = r11.length() - 1;
    L3:
        if (r10 >= r12) goto L49;
        int r13 = r10 + 1;
        if (r11.charAt(r10) != '\\') goto L41;
        int r14 = r10 + 2;
        if (r13 < r12) goto L9;
    L42:
        if (r14 > r12) goto L43;
        int r15 = getCharValueFromCharInGrammarLiteral(r11.substring(r10, r14));
        if (r15 == (-1)) goto L46;
        r5.appendCodePoint(r15);
        r10 = r14;
        goto L3
    L46:
        return null;
    L43:
        return null;
    L9:
        if (r11.charAt(r13) != 'u') goto L42;
        if (r14 >= r12) goto L30;
        if (r11.charAt(r14) != '{') goto L30;
        int r16 = r10 + 3;
    L15:
        int r17 = r16 + 1;
        if (r17 > r12) goto L17;
        char r18 = r11.charAt(r16);
        if (r18 == '}') goto L20;
        if (Character.isDigit(r18) == true) goto L28;
        if (r18 < 'a') goto L25;
        if (r18 <= 'f') goto L28;
    L25:
        if (r18 < 'A') goto L27;
        if (r18 <= 'F') goto L28;
    L27:
        return null;
    L28:
        r16 = r17;
        goto L15
    L20:
        r14 = r17;
        goto L42
    L17:
        return null;
    L30:
        if (r14 >= (r10 + 6)) goto L42;
        if (r14 > r12) goto L32;
        char r19 = r11.charAt(r14);
        if (Character.isDigit(r19) == true) goto L40;
        if (r19 < 'a') goto L37;
        if (r19 <= 'f') goto L40;
    L37:
        if (r19 < 'A') goto L39;
        if (r19 <= 'F') goto L40;
    L39:
        return null;
    L40:
        r14 = r14 + 1;
        goto L30
    L32:
        return null;
    L41:
        r14 = r13;
        goto L42
    L49:
        return r5.toString();
    }

    public static int parseHexValue(String r5, int r10, int r11) {
        if (r10 < 0) goto L12;
        if (r11 >= 0) goto L10;
        return -1;
    L10:
        return Integer.parseInt(r5.substring(r10, r11), 16);
    L14:
        return -1;
    L12:
        return -1;
    }
}
