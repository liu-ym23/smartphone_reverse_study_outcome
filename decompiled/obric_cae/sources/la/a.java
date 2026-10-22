package la;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import defpackage.b;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f9188a = null;

    static {
        f9188a = TimeZone.getTimeZone("UTC");
    }

    public static boolean a(String r8, int r10, char r11) {
        if (r10 < r8.length()) goto L5;
    L7:
        return false;
    L5:
        if (r8.charAt(r10) != r11) goto L7;
        return true;
    }

    public static Date b(String r18, ParsePosition r19) {
        int r8 = r19.getIndex();     // Catch: Throwable -> L90
        int r10 = r8 + 4;     // Catch: Throwable -> L90
        int r11 = c(r8, r10, r18);     // Catch: Throwable -> L90
        if (a(r18, r10, '-') == false) goto L6;
        r10 = r10 + 1;     // Catch: Throwable -> L90
    L6:
        int r12 = r10 + 2;     // Catch: Throwable -> L90
        int r13 = c(r10, r12, r18);     // Catch: Throwable -> L90
        if (a(r18, r12, '-') == false) goto L9;
        r12 = r12 + 1;     // Catch: Throwable -> L90
    L9:
        int r14 = r12 + 2;     // Catch: Throwable -> L90
        int r15 = c(r12, r14, r18);     // Catch: Throwable -> L90
        boolean r16 = a(r18, r14, 'T');     // Catch: Throwable -> L90
        if (r16 == true) goto L16;
        if (r18.length() > r14) goto L16;
        GregorianCalendar r17 = new GregorianCalendar(r11, r13 - 1, r15);     // Catch: Throwable -> L90
        r17.setLenient(false);     // Catch: Throwable -> L90
        r19.setIndex(r14);     // Catch: Throwable -> L90
        return r17.getTime();
    L16:
        if (r16 == false) goto L55;
        int r20 = r14 + 1;     // Catch: Throwable -> L90
        int r21 = r20 + 2;     // Catch: Throwable -> L90
        int r22 = c(r20, r21, r18);     // Catch: Throwable -> L90
        if (a(r18, r21, ':') == false) goto L20;
        r21 = r21 + 1;     // Catch: Throwable -> L90
    L20:
        int r110 = r21 + 2;     // Catch: Throwable -> L90
        int r23 = c(r21, r110, r18);     // Catch: Throwable -> L90
        if (a(r18, r110, ':') == false) goto L24;
        r110 = r110 + 1;     // Catch: Throwable -> L90
    L24:
        if (r18.length() <= r110) goto L54;
        char r111 = r18.charAt(r110);     // Catch: Throwable -> L90
        if (r111 == 'Z') goto L54;
        if (r111 == '+') goto L54;
        if (r111 == '-') goto L54;
        int r24 = r110 + 2;     // Catch: Throwable -> L90
        int r112 = c(r110, r24, r18);     // Catch: Throwable -> L90
        if (r112 <= 59) goto L35;
        if (r112 >= 63) goto L35;
        r112 = 59;
    L35:
        if (a(r18, r24, '.') == false) goto L53;
        int r25 = r24 + 1;     // Catch: Throwable -> L90
        int r113 = r25 + 1;     // Catch: Throwable -> L90
    L38:
        if (r113 >= r18.length()) goto L45;
        char r114 = r18.charAt(r113);     // Catch: Throwable -> L90
        if (r114 < '0') goto L46;
        if (r114 > '9') goto L46;
        r113 = r113 + 1;     // Catch: Throwable -> L90
    L46:
        int r115 = Math.min(r113, r25 + 3);     // Catch: Throwable -> L90
        int r116 = c(r25, r115, r18);     // Catch: Throwable -> L90
        int r117 = r115 - r25;     // Catch: Throwable -> L90
        if (r117 == 1) goto L51;
        if (r117 != 2) goto L52;
        r116 = r116 * 10;     // Catch: Throwable -> L90
    L52:
        r24 = r113;
    L58:
        if (r18.length() <= r24) goto L89;
        char r118 = r18.charAt(r24);     // Catch: Throwable -> L90
        TimeZone r119 = f9188a;
        if (r118 != 'Z') goto L64;
        int r26 = r24 + 1;
    L86:
        GregorianCalendar r120 = new GregorianCalendar(r119);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r120.setLenient(false);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r120.set(1, r11);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r120.set(2, r13 - 1);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r120.set(5, r15);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r120.set(11, r22);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r120.set(12, r23);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r120.set(13, r112);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r120.set(14, r116);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r19.setIndex(r26);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        return r120.getTime();
    L64:
        if (r118 != '+') goto L66;
    L70:
        String r121 = r18.substring(r24);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        if (r121.length() >= 5) goto L74;
        r121 = r121 + "00";     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
    L74:
        r26 = r24 + r121.length();     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        if ("+0000".equals(r121) == true) goto L86;
        if ("+00:00".equals(r121) == true) goto L86;
        String r122 = "GMT" + r121;     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        r119 = TimeZone.getTimeZone(r122);     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        String r123 = r119.getID();     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
        if (r123.equals(r122) == true) goto L86;
        if (r123.replace(BdimCategoryConstants.SEPARATOR_COLON, "").equals(r122) == true) goto L86;
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + r122 + " given, resolves to " + r119.getID());     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
    L66:
        if (r118 == '-') goto L70;
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + r118 + "'");     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
    L89:
        throw new IllegalArgumentException("No time zone indicator");     // Catch: Throwable -> L90 Throwable -> L90 Throwable -> L90
    L51:
        r116 = r116 * 100;     // Catch: Throwable -> L90
        goto L52
    L45:
        r113 = r18.length();     // Catch: Throwable -> L90
        goto L46
    L53:
        r116 = 0;
    L54:
        int r27 = r22;
        r14 = r110;
    L56:
        r116 = 0;
        r112 = 0;
        int r124 = r14;
        r22 = r27;
        r24 = r124;
        goto L58
    L55:
        r27 = 0;
        r23 = 0;
    L90:
        e = move-exception;
        if (r18 != null) goto L93;
        String r28 = null;
    L94:
        String r29 = e.getMessage();
        if (r29 != null) goto L97;
    L98:
        r29 = "(" + e.getClass().getName() + ")";
    L99:
        ParseException r30 = new ParseException(b.e("Failed to parse date [", r28, "]: ", r29), r19.getIndex());
        r30.initCause(e);
        throw r30;
    L97:
        if (r29.isEmpty() == false) goto L99;
    L93:
        r28 = "\"" + r18 + '\"';
        goto L94
    }

    public static int c(int r8, int r10, String r11) {
        if (r8 < 0) goto L23;
        if (r10 > r11.length()) goto L23;
        if (r8 > r10) goto L23;
        if (r8 >= r10) goto L13;
        int r12 = r8 + 1;
        int r13 = Character.digit(r11.charAt(r8), 10);
        if (r13 < 0) goto L12;
        int r14 = -r13;
    L14:
        if (r12 >= r10) goto L21;
        int r15 = r12 + 1;
        int r16 = Character.digit(r11.charAt(r12), 10);
        if (r16 < 0) goto L19;
        r14 = (r14 * 10) - r16;
        r12 = r15;
        goto L14
    L19:
        throw new NumberFormatException("Invalid number: " + r11.substring(r8, r10));
    L21:
        return -r14;
    L12:
        throw new NumberFormatException("Invalid number: " + r11.substring(r8, r10));
    L13:
        r14 = 0;
        r12 = r8;
    L23:
        throw new NumberFormatException(r11);
    }
}
