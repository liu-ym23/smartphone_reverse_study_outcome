package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final class SheetNameFormatter {
    private static final Pattern CELL_REF_PATTERN = null;

    static {
        CELL_REF_PATTERN = Pattern.compile("([A-Za-z]+)([0-9]+)");
    }

    static void appendAndEscape(Appendable r4, String r5) {
        Appendable r6 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        r6.append("#REF");     // Catch: Exception -> L14
        return;
    L6:
        int r0 = r5.length();     // Catch: Exception -> L14
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L13;
        char r2 = r5.charAt(r1);     // Catch: Exception -> L14
        if (r2 != '\'') goto L11;
        r6.append('\'');     // Catch: Exception -> L14
    L11:
        r6.append(r2);     // Catch: Exception -> L14
        r1 = r1 + 1;
        goto L7
    L13:
        return;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void appendFormat(Appendable r2, String r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin");
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (needsDelimiting(r3) == false) goto L6;
        r4.append('\'');     // Catch: Exception -> L8
        appendAndEscape(r4, r3);     // Catch: Exception -> L8
        r4.append('\'');     // Catch: Exception -> L8
        return;
    L6:
        appendAndEscape(r4, r3);     // Catch: Exception -> L8
    }

    public static void appendFormat(Appendable r4, String r5, String r6) {
        Appendable r7 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r4, Appendable.class, "com.obric.memorydata.plugin");
    L15:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (needsDelimiting(r5) == false) goto L6;
    L9:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        r7.append('\'');     // Catch: Exception -> L15
        r7.append('[');     // Catch: Exception -> L15
        appendAndEscape(r7, r5.replace('[', '(').replace(']', ')'));     // Catch: Exception -> L15
        r7.append(']');     // Catch: Exception -> L15
        appendAndEscape(r7, r6);     // Catch: Exception -> L15
        r7.append('\'');     // Catch: Exception -> L15
        return;
    L13:
        r7.append('[');     // Catch: Exception -> L15
        appendOrREF(r7, r5);     // Catch: Exception -> L15
        r7.append(']');     // Catch: Exception -> L15
        appendOrREF(r7, r6);     // Catch: Exception -> L15
        return;
    L6:
        if (needsDelimiting(r6) == true) goto L9;
        r0 = false;
        goto L11
    }

    private static void appendOrREF(Appendable r2, String r3) {
        Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        r3 = "#REF";
    L5:
        r4.append(r3);
    }

    static boolean cellReferenceIsWithinRange(String r1, String r2) {
        return CellReference.cellReferenceIsWithinRange(r1, r2, SpreadsheetVersion.EXCEL97);
    }

    public static String format(String r2) {
        if (r2 != null) goto L5;
        int r1 = 0;
    L6:
        StringBuilder r0 = new StringBuilder(r1 + 2);
        appendFormat(r0, r2);
        return r0.toString();
    L5:
        r1 = r2.length();
        goto L6
    }

    static boolean isSpecialChar(char r3) {
        if (Character.isLetterOrDigit(r3) == false) goto L6;
        return false;
    L6:
        if (r3 == '\t') goto L19;
        if (r3 == '\n') goto L19;
        if (r3 == '\r') goto L19;
        if (r3 != '.') goto L14;
    L17:
        return false;
    L14:
        if (r3 == '_') goto L17;
        return true;
    L19:
        throw new RuntimeException("Illegal character (0x" + Integer.toHexString(r3) + ") found in sheet name");
    }

    private static boolean nameLooksLikeBooleanLiteral(String r3) {
        char r1 = r3.charAt(0);
        if (r1 != 'F') goto L5;
    L14:
        String r0 = "FALSE";
    L13:
        return r0.equalsIgnoreCase(r3);
    L5:
        if (r1 != 'T') goto L7;
    L11:
        r0 = "TRUE";
        goto L13
    L7:
        if (r1 == 'f') goto L14;
        if (r1 == 't') goto L11;
        return false;
    }

    static boolean nameLooksLikePlainCellReference(String r2) {
        Matcher r3 = CELL_REF_PATTERN.matcher(r2);
        if (r3.matches() == true) goto L7;
        return false;
    L7:
        return cellReferenceIsWithinRange(r3.group(1), r3.group(2));
    }

    static boolean needsDelimiting(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = r5.length();
        if (r1 >= 1) goto L9;
        return false;
    L9:
        if (Character.isDigit(r5.charAt(0)) == false) goto L11;
        return true;
    L11:
        int r3 = 0;
    L12:
        if (r3 >= r1) goto L18;
        if (isSpecialChar(r5.charAt(r3)) == true) goto L15;
        r3 = r3 + 1;
        goto L12
    L15:
        return true;
    L18:
        if (Character.isLetter(r5.charAt(0)) == false) goto L25;
        if (Character.isDigit(r5.charAt(r1 - 1)) == false) goto L25;
        if (nameLooksLikePlainCellReference(r5) == false) goto L25;
        return true;
    L25:
        if (nameLooksLikeBooleanLiteral(r5) == false) goto L27;
        return true;
    L27:
        return false;
    }
}
