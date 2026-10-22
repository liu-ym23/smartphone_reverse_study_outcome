package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = null;
    private static final String UTC_ID = "UTC";

    public ISO8601Utils() {
    }

    static {
        TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    }

    public static String format(Date r2) {
        return format(r2, false, TIMEZONE_UTC);
    }

    public static String format(Date r1, boolean r2) {
        return format(r1, r2, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String r2, int r3) {
    L3:
        if (r3 >= r2.length()) goto L12;
        char r0 = r2.charAt(r3);
        if (r0 < '0') goto L10;
        if (r0 > '9') goto L10;
        r3 = r3 + 1;
    L10:
        return r3;
    L12:
        return r2.length();
    }

    public static Date parse(String r19, ParsePosition r20) throws ParseException {
        int r6 = r20.getIndex();     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r7 = r6 + 4;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r8 = parseInt(r19, r6, r7);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (checkOffset(r19, r7, '-') == false) goto L6;
        r7 = r7 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L6:
        int r9 = r7 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r10 = parseInt(r19, r7, r9);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (checkOffset(r19, r9, '-') == false) goto L9;
        r9 = r9 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L9:
        int r11 = r9 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r12 = parseInt(r19, r9, r11);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        boolean r13 = checkOffset(r19, r11, 'T');     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r13 == true) goto L16;
        if (r19.length() > r11) goto L16;
        GregorianCalendar r0 = new GregorianCalendar(r8, r10 - 1, r12);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        r0.setLenient(false);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        r20.setIndex(r11);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        return r0.getTime();
    L16:
        if (r13 == false) goto L46;
        int r14 = r11 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r15 = r14 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r16 = parseInt(r19, r14, r15);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (checkOffset(r19, r15, ':') == false) goto L20;
        r15 = r15 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L20:
        int r17 = r15 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r18 = parseInt(r19, r15, r17);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (checkOffset(r19, r17, ':') == false) goto L24;
        r17 = r17 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L24:
        if (r19.length() <= r17) goto L45;
        char r110 = r19.charAt(r17);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r110 == 'Z') goto L45;
        if (r110 == '+') goto L45;
        if (r110 == '-') goto L45;
        int r111 = r17 + 2;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r112 = parseInt(r19, r17, r111);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r112 <= 59) goto L35;
        if (r112 >= 63) goto L35;
        r112 = 59;
    L35:
        if (checkOffset(r19, r111, '.') == false) goto L44;
        int r113 = r111 + 1;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r21 = indexOfNonDigit(r19, r113 + 1);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r114 = Math.min(r21, r113 + 3);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r115 = parseInt(r19, r113, r114);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        int r116 = r114 - r113;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r116 != 1) goto L39;
        r115 = r115 * 100;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L43:
        int r117 = r115;
        r11 = r21;
        int r22 = r16;
    L49:
        if (r19.length() <= r11) goto L90;
        char r118 = r19.charAt(r11);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        if (r118 != 'Z') goto L61;
        TimeZone r1 = TIMEZONE_UTC;     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        int r119 = r11 + 1;     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
    L85:
        GregorianCalendar r3 = new GregorianCalendar(r1);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r3.setLenient(false);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r3.set(1, r8);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r3.set(2, r10 - 1);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r3.set(5, r12);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r3.set(11, r22);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r3.set(12, r18);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r3.set(13, r112);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r3.set(14, r117);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        r20.setIndex(r119);     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        return r3.getTime();
    L61:
        if (r118 != '+') goto L63;
    L67:
        String r5 = r19.substring(r11);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        if (r5.length() >= 5) goto L71;
        r5 = r5.concat("00");     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
    L71:
        r119 = r11 + r5.length();     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        if ("+0000".equals(r5) == false) goto L74;
    L84:
        r1 = TIMEZONE_UTC;     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        goto L85
    L74:
        if ("+00:00".equals(r5) == true) goto L84;
        String r4 = "GMT".concat(r5);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        TimeZone r23 = TimeZone.getTimeZone(r4);     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        String r24 = r23.getID();     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
        if (r24.equals(r4) == false) goto L79;
    L83:
        r1 = r23;
        goto L85
    L79:
        if (r24.replace(":", "").equals(r4) == true) goto L83;
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + r4 + " given, resolves to " + r23.getID());     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
    L63:
        if (r118 == '-') goto L67;
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + r118 + "'");     // Catch: IllegalArgumentException -> L54 NumberFormatException -> L56 IndexOutOfBoundsException -> L58
    L54:
        e = e;
    L96:
        if (r19 != null) goto L98;
        String r2 = null;
    L99:
        String r25 = e.getMessage();
        if (r25 != null) goto L102;
    L103:
        r25 = "(" + e.getClass().getName() + ")";
    L104:
        ParseException r26 = new ParseException("Failed to parse date [" + r2 + "]: " + r25, r20.getIndex());
        r26.initCause(e);
        throw r26;
    L102:
        if (r25.isEmpty() == false) goto L104;
    L98:
        r2 = "\"" + r19 + '\"';
    L58:
        e = e;
    L56:
        e = e;
        goto L96
    L90:
        throw new IllegalArgumentException("No time zone indicator");     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
    L39:
        if (r116 != 2) goto L43;
        r115 = r115 * 10;     // Catch: IllegalArgumentException -> L91 NumberFormatException -> L93 IndexOutOfBoundsException -> L95
        goto L43
    L44:
        r22 = r16;
        r11 = r111;
        r117 = 0;
    L45:
        r22 = r16;
        r11 = r17;
    L47:
        r117 = 0;
        r112 = 0;
        goto L49
    L46:
        r22 = 0;
        r18 = 0;
    L91:
        e = e;
    L95:
        e = e;
    L93:
        e = e;
        goto L96
    }

    private static boolean checkOffset(String r1, int r2, char r3) {
        if (r2 < r1.length()) goto L5;
    L7:
        return false;
    L5:
        if (r1.charAt(r2) != r3) goto L7;
        return true;
    }

    public static String format(Date r6, boolean r7, TimeZone r8) {
        GregorianCalendar r0 = new GregorianCalendar(r8, Locale.US);
        r0.setTime(r6);
        if (r7 == false) goto L5;
        int r1 = 4;
    L6:
        int r2 = 19 + r1;
        if (r8.getRawOffset() != 0) goto L9;
        int r3 = 1;
    L10:
        StringBuilder r4 = new StringBuilder(r2 + r3);
        padInt(r4, r0.get(1), 4);
        char r9 = '-';
        r4.append('-');
        padInt(r4, r0.get(2) + 1, 2);
        r4.append('-');
        padInt(r4, r0.get(5), 2);
        r4.append('T');
        padInt(r4, r0.get(11), 2);
        r4.append(':');
        padInt(r4, r0.get(12), 2);
        r4.append(':');
        padInt(r4, r0.get(13), 2);
        if (r7 == false) goto L13;
        r4.append('.');
        padInt(r4, r0.get(14), 3);
    L13:
        int r10 = r8.getOffset(r0.getTimeInMillis());
        if (r10 == 0) goto L20;
        int r11 = r10 / 60000;
        int r5 = Math.abs(r11 / 60);
        int r12 = Math.abs(r11 % 60);
        if (r10 < 0) goto L19;
        r9 = '+';
    L19:
        r4.append(r9);
        padInt(r4, r5, 2);
        r4.append(':');
        padInt(r4, r12, 2);
    L22:
        return r4.toString();
    L20:
        r4.append('Z');
        goto L22
    L9:
        r3 = 6;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    private static void padInt(StringBuilder r1, int r2, int r3) {
        String r4 = Integer.toString(r2);
        int r5 = r3 - r4.length();
    L3:
        if (r5 <= 0) goto L5;
        r1.append('0');
        r5 = r5 - 1;
        goto L3
    L5:
        r1.append(r4);
    }

    private static int parseInt(String r5, int r6, int r7) throws NumberFormatException {
        if (r6 < 0) goto L23;
        if (r7 > r5.length()) goto L23;
        if (r6 > r7) goto L23;
        if (r6 >= r7) goto L13;
        int r2 = r6 + 1;
        int r3 = Character.digit(r5.charAt(r6), 10);
        if (r3 < 0) goto L12;
        int r4 = -r3;
    L14:
        if (r2 >= r7) goto L21;
        int r8 = r2 + 1;
        int r9 = Character.digit(r5.charAt(r2), 10);
        if (r9 < 0) goto L19;
        r4 = (r4 * 10) - r9;
        r2 = r8;
        goto L14
    L19:
        throw new NumberFormatException("Invalid number: " + r5.substring(r6, r7));
    L21:
        return -r4;
    L12:
        throw new NumberFormatException("Invalid number: " + r5.substring(r6, r7));
    L13:
        r4 = 0;
        r2 = r6;
    L23:
        throw new NumberFormatException(r5);
    }
}
