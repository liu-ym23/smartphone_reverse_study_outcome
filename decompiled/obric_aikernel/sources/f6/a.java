package f6;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f8865a = null;

    static {
        f8865a = TimeZone.getTimeZone("UTC");
    }

    private static boolean a(String r10, int r11, char r12) {
        if (r11 < r10.length()) goto L5;
    L7:
        return false;
    L5:
        if (r10.charAt(r11) != r12) goto L7;
        return true;
    }

    private static int b(String r10, int r11) {
    L3:
        if (r11 >= r10.length()) goto L12;
        char r12 = r10.charAt(r11);
        if (r12 < '0') goto L10;
        if (r12 > '9') goto L10;
        r11 = r11 + 1;
    L10:
        return r11;
    L12:
        return r10.length();
    }

    public static Date c(String r17, ParsePosition r18) {
        int r10 = r18.getIndex();     // Catch: Throwable -> L79
        int r11 = r10 + 4;     // Catch: Throwable -> L79
        int r12 = d(r17, r10, r11);     // Catch: Throwable -> L79
        if (a(r17, r11, '-') == false) goto L6;
        r11 = r11 + 1;     // Catch: Throwable -> L79
    L6:
        int r13 = r11 + 2;     // Catch: Throwable -> L79
        int r14 = d(r17, r11, r13);     // Catch: Throwable -> L79
        if (a(r17, r13, '-') == false) goto L9;
        r13 = r13 + 1;     // Catch: Throwable -> L79
    L9:
        int r15 = r13 + 2;     // Catch: Throwable -> L79
        int r16 = d(r17, r13, r15);     // Catch: Throwable -> L79
        boolean r19 = a(r17, r15, 'T');     // Catch: Throwable -> L79
        if (r19 == true) goto L16;
        if (r17.length() > r15) goto L16;
        GregorianCalendar r20 = new GregorianCalendar(r12, r14 - 1, r16);     // Catch: Throwable -> L79
        r20.setLenient(false);     // Catch: Throwable -> L79
        r18.setIndex(r15);     // Catch: Throwable -> L79
        return r20.getTime();
    L16:
        if (r19 == false) goto L45;
        int r21 = r15 + 1;     // Catch: Throwable -> L79
        int r22 = r21 + 2;     // Catch: Throwable -> L79
        int r23 = d(r17, r21, r22);     // Catch: Throwable -> L79
        if (a(r17, r22, ':') == false) goto L20;
        r22 = r22 + 1;     // Catch: Throwable -> L79
    L20:
        int r110 = r22 + 2;     // Catch: Throwable -> L79
        int r24 = d(r17, r22, r110);     // Catch: Throwable -> L79
        if (a(r17, r110, ':') == false) goto L24;
        r110 = r110 + 1;     // Catch: Throwable -> L79
    L24:
        if (r17.length() <= r110) goto L44;
        char r111 = r17.charAt(r110);     // Catch: Throwable -> L79
        if (r111 == 'Z') goto L44;
        if (r111 == '+') goto L44;
        if (r111 == '-') goto L44;
        int r112 = r110 + 2;     // Catch: Throwable -> L79
        int r113 = d(r17, r110, r112);     // Catch: Throwable -> L79
        if (r113 <= 59) goto L35;
        if (r113 >= 63) goto L35;
        r113 = 59;
    L35:
        if (a(r17, r112, '.') == false) goto L43;
        int r114 = r112 + 1;     // Catch: Throwable -> L79
        int r115 = b(r17, r114 + 1);     // Catch: Throwable -> L79
        int r25 = Math.min(r115, r114 + 3);     // Catch: Throwable -> L79
        int r116 = d(r17, r114, r25);     // Catch: Throwable -> L79
        int r26 = r25 - r114;     // Catch: Throwable -> L79
        if (r26 == 1) goto L41;
        if (r26 != 2) goto L42;
        r116 = r116 * 10;     // Catch: Throwable -> L79
    L42:
        int r27 = r24;
        int r117 = r116;
        int r28 = r23;
        r15 = r115;
    L48:
        if (r17.length() <= r15) goto L78;
        char r118 = r17.charAt(r15);     // Catch: Throwable -> L79
        if (r118 != 'Z') goto L52;
        TimeZone r29 = f8865a;     // Catch: Throwable -> L79
        int r30 = r15 + 1;     // Catch: Throwable -> L79
    L75:
        GregorianCalendar r119 = new GregorianCalendar(r29);     // Catch: Throwable -> L79
        r119.setLenient(false);     // Catch: Throwable -> L79
        r119.set(1, r12);     // Catch: Throwable -> L79
        r119.set(2, r14 - 1);     // Catch: Throwable -> L79
        r119.set(5, r16);     // Catch: Throwable -> L79
        r119.set(11, r28);     // Catch: Throwable -> L79
        r119.set(12, r27);     // Catch: Throwable -> L79
        r119.set(13, r113);     // Catch: Throwable -> L79
        r119.set(14, r117);     // Catch: Throwable -> L79
        r18.setIndex(r30);     // Catch: Throwable -> L79
        return r119.getTime();
    L52:
        if (r118 == '+') goto L57;
        if (r118 == '-') goto L57;
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + r118 + "'");     // Catch: Throwable -> L79
    L57:
        String r31 = r17.substring(r15);     // Catch: Throwable -> L79
        if (r31.length() >= 5) goto L61;
        r31 = r31 + "00";     // Catch: Throwable -> L79
    L61:
        r30 = r15 + r31.length();     // Catch: Throwable -> L79
        if ("+0000".equals(r31) == false) goto L64;
    L74:
        r29 = f8865a;     // Catch: Throwable -> L79
        goto L75
    L64:
        if ("+00:00".equals(r31) == true) goto L74;
        String r32 = "GMT" + r31;     // Catch: Throwable -> L79
        TimeZone r120 = TimeZone.getTimeZone(r32);     // Catch: Throwable -> L79
        String r121 = r120.getID();     // Catch: Throwable -> L79
        if (r121.equals(r32) == false) goto L69;
    L73:
        r29 = r120;
        goto L75
    L69:
        if (r121.replace(":", "").equals(r32) == true) goto L73;
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + r32 + " given, resolves to " + r120.getID());     // Catch: Throwable -> L79
    L78:
        throw new IllegalArgumentException("No time zone indicator");     // Catch: Throwable -> L79
    L41:
        r116 = r116 * 100;     // Catch: Throwable -> L79
        goto L42
    L43:
        r27 = r24;
        r28 = r23;
        r15 = r112;
        r117 = 0;
    L44:
        r27 = r24;
        r117 = 0;
        r28 = r23;
        r15 = r110;
    L46:
        r113 = 0;
        goto L48
    L45:
        r28 = 0;
        r27 = 0;
        r117 = 0;
    L79:
        e = move-exception;
        if (r17 != null) goto L82;
        String r33 = null;
    L83:
        String r34 = e.getMessage();
        if (r34 != null) goto L86;
    L87:
        r34 = "(" + e.getClass().getName() + ")";
    L88:
        ParseException r35 = new ParseException("Failed to parse date [" + r33 + "]: " + r34, r18.getIndex());
        r35.initCause(e);
        throw r35;
    L86:
        if (r34.isEmpty() == false) goto L88;
    L82:
        r33 = Typography.quote + r17 + Typography.quote;
        goto L83
    }

    private static int d(String r10, int r11, int r12) {
        if (r11 < 0) goto L23;
        if (r12 > r10.length()) goto L23;
        if (r11 > r12) goto L23;
        if (r11 >= r12) goto L13;
        int r13 = r11 + 1;
        int r14 = Character.digit(r10.charAt(r11), 10);
        if (r14 < 0) goto L12;
        int r15 = -r14;
    L14:
        if (r13 >= r12) goto L21;
        int r16 = r13 + 1;
        int r17 = Character.digit(r10.charAt(r13), 10);
        if (r17 < 0) goto L19;
        r15 = (r15 * 10) - r17;
        r13 = r16;
        goto L14
    L19:
        throw new NumberFormatException("Invalid number: " + r10.substring(r11, r12));
    L21:
        return -r15;
    L12:
        throw new NumberFormatException("Invalid number: " + r10.substring(r11, r12));
    L13:
        r15 = 0;
        r13 = r11;
    L23:
        throw new NumberFormatException(r10);
    }
}
