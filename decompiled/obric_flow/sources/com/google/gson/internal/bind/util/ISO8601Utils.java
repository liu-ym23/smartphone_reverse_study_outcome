package com.google.gson.internal.bind.util;

import androidx.constraintlayout.motion.widget.a;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = null;
    private static final String UTC_ID = "UTC";

    static {
        TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    }

    private ISO8601Utils() {
    }

    private static boolean checkOffset(String r5, int r10, char r11) {
        if (r10 < r5.length()) goto L5;
    L7:
        return false;
    L5:
        if (r5.charAt(r10) != r11) goto L7;
        return true;
    }

    public static String format(Date r5) {
        return format(r5, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String r5, int r10) {
    L3:
        if (r10 >= r5.length()) goto L12;
        char r11 = r5.charAt(r10);
        if (r11 < '0') goto L10;
        if (r11 > '9') goto L10;
        r10 = r10 + 1;
    L10:
        return r10;
    L12:
        return r5.length();
    }

    private static void padInt(StringBuilder r5, int r10, int r11) {
        String r12 = Integer.toString(r10);
        int r13 = r11 - r12.length();
    L3:
        if (r13 <= 0) goto L5;
        r5.append('0');
        r13 = r13 - 1;
        goto L3
    L5:
        r5.append(r12);
    }

    public static Date parse(String r19, ParsePosition r20) throws ParseException {
        int r10 = r20.getIndex();     // Catch: Throwable -> L15
        int r11 = r10 + 4;     // Catch: Throwable -> L15
        int r12 = parseInt(r19, r10, r11);     // Catch: Throwable -> L15
        if (checkOffset(r19, r11, '-') == false) goto L6;
        r11 = r10 + 5;     // Catch: Throwable -> L15
    L6:
        int r13 = r11 + 2;     // Catch: Throwable -> L15
        int r14 = parseInt(r19, r11, r13);     // Catch: Throwable -> L15
        if (checkOffset(r19, r13, '-') == false) goto L9;
        r13 = r11 + 3;     // Catch: Throwable -> L15
    L9:
        int r15 = r13 + 2;     // Catch: Throwable -> L15
        int r16 = parseInt(r19, r13, r15);     // Catch: Throwable -> L15
        boolean r17 = checkOffset(r19, r15, 'T');     // Catch: Throwable -> L15
        if (r17 == true) goto L18;
        if (r19.length() > r15) goto L18;
        GregorianCalendar r5 = new GregorianCalendar(r12, r14 - 1, r16);     // Catch: Throwable -> L15
        r5.setLenient(false);     // Catch: Throwable -> L15
        r20.setIndex(r15);     // Catch: Throwable -> L15
        return r5.getTime();
    L18:
        if (r17 == false) goto L48;
        int r18 = r13 + 5;     // Catch: Throwable -> L15
        int r21 = parseInt(r19, r13 + 3, r18);     // Catch: Throwable -> L15
        if (checkOffset(r19, r18, ':') == false) goto L22;
        r18 = r13 + 6;     // Catch: Throwable -> L15
    L22:
        int r22 = r18 + 2;     // Catch: Throwable -> L15
        int r110 = parseInt(r19, r18, r22);     // Catch: Throwable -> L15
        if (checkOffset(r19, r22, ':') == false) goto L26;
        r22 = r18 + 3;     // Catch: Throwable -> L15
    L26:
        if (r19.length() <= r22) goto L47;
        char r111 = r19.charAt(r22);     // Catch: Throwable -> L15
        if (r111 == 'Z') goto L47;
        if (r111 == '+') goto L47;
        if (r111 == '-') goto L47;
        int r112 = r22 + 2;     // Catch: Throwable -> L15
        int r113 = parseInt(r19, r22, r112);     // Catch: Throwable -> L15
        if (r113 <= 59) goto L37;
        if (r113 >= 63) goto L37;
        r113 = 59;
    L37:
        if (checkOffset(r19, r112, '.') == false) goto L46;
        int r23 = r22 + 3;     // Catch: Throwable -> L15
        int r114 = indexOfNonDigit(r19, r22 + 4);     // Catch: Throwable -> L15
        int r24 = Math.min(r114, r22 + 6);     // Catch: Throwable -> L15
        int r115 = parseInt(r19, r23, r24);     // Catch: Throwable -> L15
        int r25 = r24 - r23;     // Catch: Throwable -> L15
        if (r25 != 1) goto L41;
        r115 = r115 * 100;     // Catch: Throwable -> L15
    L45:
        int r26 = r21;
        r15 = r114;
        int r27 = r110;
        int r116 = r115;
    L50:
        if (r19.length() <= r15) goto L82;
        char r117 = r19.charAt(r15);     // Catch: Throwable -> L15
        if (r117 != 'Z') goto L55;
        TimeZone r28 = TIMEZONE_UTC;     // Catch: Throwable -> L15
        int r29 = r15 + 1;     // Catch: Throwable -> L15
    L79:
        GregorianCalendar r30 = new GregorianCalendar(r28);     // Catch: Throwable -> L15
        r30.setLenient(false);     // Catch: Throwable -> L15
        r30.set(1, r12);     // Catch: Throwable -> L15
        r30.set(2, r14 - 1);     // Catch: Throwable -> L15
        r30.set(5, r16);     // Catch: Throwable -> L15
        r30.set(11, r26);     // Catch: Throwable -> L15
        r30.set(12, r27);     // Catch: Throwable -> L15
        r30.set(13, r113);     // Catch: Throwable -> L15
        r30.set(14, r116);     // Catch: Throwable -> L15
        r20.setIndex(r29);     // Catch: Throwable -> L15
        return r30.getTime();
    L55:
        if (r117 != '+') goto L57;
    L61:
        String r31 = r19.substring(r15);     // Catch: Throwable -> L15
        if (r31.length() >= 5) goto L65;
        r31 = r31.concat("00");     // Catch: Throwable -> L15
    L65:
        r29 = r15 + r31.length();     // Catch: Throwable -> L15
        if (r31.equals("+0000") == false) goto L68;
    L78:
        r28 = TIMEZONE_UTC;     // Catch: Throwable -> L15
        goto L79
    L68:
        if (r31.equals("+00:00") == true) goto L78;
        String r32 = "GMT".concat(r31);     // Catch: Throwable -> L15
        TimeZone r33 = TimeZone.getTimeZone(r32);     // Catch: Throwable -> L15
        String r34 = r33.getID();     // Catch: Throwable -> L15
        if (r34.equals(r32) == false) goto L73;
    L77:
        r28 = r33;
        goto L79
    L73:
        if (r34.replace(":", "").equals(r32) == true) goto L77;
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + r32 + " given, resolves to " + r33.getID());     // Catch: Throwable -> L15
    L57:
        if (r117 == '-') goto L61;
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + r117 + "'");     // Catch: Throwable -> L15
    L82:
        throw new IllegalArgumentException("No time zone indicator");     // Catch: Throwable -> L15
    L41:
        if (r25 != 2) goto L45;
        r115 = r115 * 10;     // Catch: Throwable -> L15
        goto L45
    L46:
        r26 = r21;
        r15 = r112;
        r27 = r110;
        r116 = 0;
    L47:
        r27 = r110;
        r116 = 0;
        r113 = 0;
        r15 = r22;
        r26 = r21;
        goto L50
    L48:
        r26 = 0;
        r27 = 0;
        r116 = 0;
        r113 = 0;
    L15:
        e = move-exception;
        if (r19 != null) goto L85;
        String r35 = null;
    L86:
        String r36 = e.getMessage();
        if (r36 != null) goto L89;
    L90:
        r36 = "(" + e.getClass().getName() + ")";
    L91:
        ParseException r37 = new ParseException(a.p("Failed to parse date [", r35, "]: ", r36), r20.getIndex());
        r37.initCause(e);
        throw r37;
    L89:
        if (r36.isEmpty() == false) goto L91;
    L85:
        r35 = androidx.room.jarjarred.org.antlr.runtime.a.p("\"", Typography.quote, r19);
        goto L86
    }

    private static int parseInt(String r5, int r10, int r11) throws NumberFormatException {
        if (r10 < 0) goto L23;
        if (r11 > r5.length()) goto L23;
        if (r10 > r11) goto L23;
        if (r10 >= r11) goto L13;
        int r12 = r10 + 1;
        int r13 = Character.digit(r5.charAt(r10), 10);
        if (r13 < 0) goto L12;
        int r14 = -r13;
    L14:
        if (r12 >= r11) goto L21;
        int r15 = r12 + 1;
        int r16 = Character.digit(r5.charAt(r12), 10);
        if (r16 < 0) goto L19;
        r14 = (r14 * 10) - r16;
        r12 = r15;
        goto L14
    L19:
        throw new NumberFormatException("Invalid number: " + r5.substring(r10, r11));
    L21:
        return -r14;
    L12:
        throw new NumberFormatException("Invalid number: " + r5.substring(r10, r11));
    L13:
        r14 = 0;
        r12 = r10;
    L23:
        throw new NumberFormatException(r5);
    }

    public static String format(Date r5, boolean r10) {
        return format(r5, r10, TIMEZONE_UTC);
    }

    public static String format(Date r10, boolean r11, TimeZone r12) {
        GregorianCalendar r5 = new GregorianCalendar(r12, Locale.US);
        r5.setTime(r10);
        if (r11 == false) goto L5;
        int r13 = 4;
    L6:
        int r14 = 19 + r13;
        if (r12.getRawOffset() != 0) goto L9;
        int r15 = 1;
    L10:
        StringBuilder r16 = new StringBuilder(r14 + r15);
        padInt(r16, r5.get(1), 4);
        char r17 = '-';
        r16.append('-');
        padInt(r16, r5.get(2) + 1, 2);
        r16.append('-');
        padInt(r16, r5.get(5), 2);
        r16.append('T');
        padInt(r16, r5.get(11), 2);
        r16.append(':');
        padInt(r16, r5.get(12), 2);
        r16.append(':');
        padInt(r16, r5.get(13), 2);
        if (r11 == false) goto L13;
        r16.append('.');
        padInt(r16, r5.get(14), 3);
    L13:
        int r18 = r12.getOffset(r5.getTimeInMillis());
        if (r18 == 0) goto L20;
        int r19 = r18 / 60000;
        int r20 = Math.abs(r19 / 60);
        int r21 = Math.abs(r19 % 60);
        if (r18 < 0) goto L19;
        r17 = '+';
    L19:
        r16.append(r17);
        padInt(r16, r20, 2);
        r16.append(':');
        padInt(r16, r21, 2);
    L22:
        return r16.toString();
    L20:
        r16.append('Z');
        goto L22
    L9:
        r15 = 6;
        goto L10
    L5:
        r13 = 0;
        goto L6
    }
}
