package org.apache.poi.ss.util;

/* JADX INFO: loaded from: classes7.dex */
public final class NumberToTextConverter {
    private static void appendExp(StringBuilder r1, int r2) {
        if (r2 >= 10) goto L6;
        r1.append('0');
        r1.append((char) (r2 + 48));
        return;
    L6:
        r1.append(r2);
    }

    private static void convertToText(StringBuilder r3, NormalisedDecimal r4) {
        NormalisedDecimal r5 = r4.roundUnits();
        int r0 = r5.getDecimalExponent();
        if (Math.abs(r0) <= 98) goto L7;
        String r6 = r5.getSignificantDecimalDigitsLastDigitRounded();
        if (r6.length() != 16) goto L8;
        r0 = r0 + 1;
    L8:
        int r1 = countSignifantDigits(r6);
        if (r0 >= 0) goto L11;
        formatLessThanOne(r3, r6, r0, r1);
        return;
    L11:
        formatGreaterThanOne(r3, r6, r0, r1);
        return;
    L7:
        r6 = r5.getSignificantDecimalDigits();
        goto L8
    }

    private static int countSignifantDigits(String r3) {
        int r0 = r3.length() - 1;
    L4:
        if (r3.charAt(r0) != '0') goto L11;
        r0 = r0 - 1;
        if (r0 >= 0) goto L4;
        throw new RuntimeException("No non-zero digits found");
    L11:
        return r0 + 1;
    }

    private static void formatGreaterThanOne(StringBuilder r4, String r5, int r6, int r7) {
        if (r6 <= 19) goto L9;
        r4.append(r5.charAt(0));
        if (r7 <= 1) goto L7;
        r4.append('.');
        r4.append(r5.subSequence(1, r7));
    L7:
        r4.append("E+");
        appendExp(r4, r6);
        return;
    L9:
        int r3 = (r7 - r6) - 1;
        if (r3 <= 0) goto L13;
        int r8 = r6 + 1;
        r4.append(r5.subSequence(0, r8));
        r4.append('.');
        r4.append(r5.subSequence(r8, r7));
        return;
    L13:
        r4.append(r5.subSequence(0, r7));
        int r9 = -r3;
    L14:
        if (r9 <= 0) goto L16;
        r4.append('0');
        r9 = r9 - 1;
        goto L14
    }

    private static void formatLessThanOne(StringBuilder r3, String r4, int r5, int r6) {
        int r7 = -r5;
        int r0 = r7 - 1;
        if (needsScientificNotation((r0 + 2) + r6) == false) goto L9;
        r3.append(r4.charAt(0));
        if (r6 <= 1) goto L7;
        r3.append('.');
        r3.append(r4.subSequence(1, r6));
    L7:
        r3.append("E-");
        appendExp(r3, r7);
        return;
    L9:
        r3.append("0.");
    L10:
        if (r0 <= 0) goto L12;
        r3.append('0');
        r0 = r0 - 1;
        goto L10
    L12:
        r3.append(r4.subSequence(0, r6));
    }

    private static boolean needsScientificNotation(int r1) {
        if (r1 <= 20) goto L5;
        return true;
    L5:
        return false;
    }

    static String rawDoubleBitsToText(long r7) {
        boolean r3 = false;
        if (r7 >= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        r7 = r7 & Long.MAX_VALUE;
    L9:
        if (r7 != 0) goto L14;
        if (r2 == false) goto L13;
        return "-0";
    L13:
        return "0";
    L14:
        ExpandedDouble r0 = new ExpandedDouble(r7);
        if (r0.getBinaryExponent() >= (-1022)) goto L21;
        if (r2 == false) goto L19;
        return "-0";
    L19:
        return "0";
    L21:
        if (r0.getBinaryExponent() == 1024) goto L23;
        r3 = r2;
    L27:
        NormalisedDecimal r8 = r0.normaliseBaseTen();
        StringBuilder r9 = new StringBuilder(21);
        if (r3 == false) goto L30;
        r9.append('-');
    L30:
        convertToText(r9, r8);
        return r9.toString();
    L23:
        if (r7 != (-276939487313920L)) goto L27;
        return "3.484840871308E+308";
    L5:
        r2 = false;
        goto L6
    }

    public static String toText(double r0) {
        return rawDoubleBitsToText(Double.doubleToLongBits(r0));
    }
}
