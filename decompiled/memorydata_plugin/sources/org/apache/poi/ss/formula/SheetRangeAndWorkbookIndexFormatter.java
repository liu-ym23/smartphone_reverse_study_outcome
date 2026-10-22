package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: classes7.dex */
public class SheetRangeAndWorkbookIndexFormatter {
    private static boolean anySheetNameNeedsEscaping(String r0, String r1) {
        return SheetNameFormatter.needsDelimiting(r0) | SheetNameFormatter.needsDelimiting(r1);
    }

    public static String format(StringBuilder r1, int r2, String r3, String r4) {
        if (anySheetNameNeedsEscaping(r3, r4) == false) goto L7;
        return formatWithDelimiting(r1, r2, r3, r4);
    L7:
        return formatWithoutDelimiting(r1, r2, r3, r4);
    }

    private static String formatWithDelimiting(StringBuilder r2, int r3, String r4, String r5) {
        r2.append('\'');
        if (r3 < 0) goto L5;
        r2.append('[');
        r2.append(r3);
        r2.append(']');
    L5:
        SheetNameFormatter.appendAndEscape(r2, r4);
        if (r5 == null) goto L8;
        r2.append(':');
        SheetNameFormatter.appendAndEscape(r2, r5);
    L8:
        r2.append('\'');
        return r2.toString();
    }

    private static String formatWithoutDelimiting(StringBuilder r1, int r2, String r3, String r4) {
        if (r2 < 0) goto L4;
        r1.append('[');
        r1.append(r2);
        r1.append(']');
    L4:
        r1.append(r3);
        if (r4 == null) goto L8;
        r1.append(':');
        r1.append(r4);
    L8:
        return r1.toString();
    }
}
