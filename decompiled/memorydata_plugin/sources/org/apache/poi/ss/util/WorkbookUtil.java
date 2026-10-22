package org.apache.poi.ss.util;

/* JADX INFO: loaded from: classes7.dex */
public class WorkbookUtil {
    public static void validateSheetName(String r6) {
        if (r6 == null) goto L31;
        int r0 = r6.length();
        if (r0 < 1) goto L29;
        if (r0 > 31) goto L29;
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L22;
        char r4 = r6.charAt(r3);
        if (r4 == '*') goto L20;
        if (r4 == '/') goto L20;
        if (r4 == ':') goto L20;
        if (r4 == '?') goto L20;
        switch(r4) {
            case 91: goto L20;
            case 92: goto L20;
            case 93: goto L20;
            default: goto L18;
        };
    L18:
        r3 = r3 + 1;
    L20:
        throw new IllegalArgumentException("Invalid char (" + r4 + ") found at index (" + r3 + ") in sheet name '" + r6 + "'");
    L22:
        if (r6.charAt(0) == '\'') goto L27;
        if (r6.charAt(r0 - 1) == '\'') goto L27;
        return;
    L27:
        throw new IllegalArgumentException("Invalid sheet name '" + r6 + "'. Sheet names must not begin or end with (').");
    L29:
        throw new IllegalArgumentException("sheetName '" + r6 + "' is invalid - character count MUST be greater than or equal to 1 and less than or equal to 31");
    L31:
        throw new IllegalArgumentException("sheetName must not be null");
    }
}
