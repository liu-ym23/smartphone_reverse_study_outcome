package org.sqlite.date;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class FastDatePrinter implements Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f21075c = null;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient l[] f21076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f21077b;
    private final Locale mLocale;
    private final String mPattern;
    private final TimeZone mTimeZone;

    static {
        f21075c = new ConcurrentHashMap(7);
    }

    public FastDatePrinter(String r5, TimeZone r10, Locale r11) {
        this.mPattern = r5;
        this.mTimeZone = r10;
        this.mLocale = r11;
        a();
    }

    public static void access$000(StringBuffer r5, int r10) {
        r5.append((char) ((r10 / 10) + 48));
        r5.append((char) ((r10 % 10) + 48));
    }

    public static String getTimeZoneDisplay(TimeZone r5, boolean r10, int r11, Locale r12) {
        o r13 = new o(r5, r10, r11, r12);
        ConcurrentHashMap r14 = f21075c;
        String r15 = (String) r14.get(r13);
        if (r15 != null) goto L8;
        String r16 = r5.getDisplayName(r10, r11, r12);
        String r17 = (String) r14.putIfAbsent(r13, r16);
        if (r17 != null) goto L7;
        return r16;
    L7:
        return r17;
    L8:
        return r15;
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        a();
    }

    public final void a() {
        List<l> r5 = parsePattern();
        l[] r10 = (l[]) r5.toArray(new l[r5.size()]);
        this.f21076a = r10;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        r11 = r11 - 1;
        if (r11 < 0) goto L6;
        r12 = r12 + this.f21076a[r11].a();
        goto L3
    L6:
        this.f21077b = r12;
    }

    public StringBuffer applyRules(Calendar r5, StringBuffer r10) {
        l[] r11 = this.f21076a;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13].b(r5, r10);
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof FastDatePrinter) == true) goto L5;
        return false;
    L5:
        FastDatePrinter r10 = (FastDatePrinter) r5;
        if (this.mPattern.equals(r10.mPattern) == true) goto L8;
        return false;
    L8:
        if (this.mTimeZone.equals(r10.mTimeZone) == true) goto L10;
        return false;
    L10:
        if (this.mLocale.equals(r10.mLocale) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public StringBuffer format(Object r5, StringBuffer r10, FieldPosition r11) {
        if ((r5 instanceof Date) == false) goto L7;
        return format((Date) r5, r10);
    L7:
        if ((r5 instanceof Calendar) == false) goto L11;
        return format((Calendar) r5, r10);
    L11:
        if ((r5 instanceof Long) == false) goto L15;
        return format(((Long) r5).longValue(), r10);
    L15:
        if (r5 != null) goto L17;
        String r12 = "<null>";
    L19:
        throw new IllegalArgumentException("Unknown class: ".concat(r12));
    L17:
        r12 = r5.getClass().getName();
        goto L19
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.f21077b;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        int r5 = this.mPattern.hashCode();
        int r10 = this.mTimeZone.hashCode();
        return (((this.mLocale.hashCode() * 13) + r10) * 13) + r5;
    }

    public List<l> parsePattern() {
        DateFormatSymbols r5 = new DateFormatSymbols(this.mLocale);
        ArrayList r10 = new ArrayList();
        String[] r11 = r5.getEras();
        String[] r12 = r5.getMonths();
        String[] r13 = r5.getShortMonths();
        String[] r14 = r5.getWeekdays();
        String[] r15 = r5.getShortWeekdays();
        String[] r16 = r5.getAmPmStrings();
        int r17 = this.mPattern.length();
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L82;
        int[] r19 = {r18};
        String r110 = parseToken(this.mPattern, r19);
        int r111 = r19[0];
        int r112 = r110.length();
        if (r112 == 0) goto L82;
        char r113 = r110.charAt(0);
        if (r113 != 'W') goto L10;
        Object r114 = selectNumberRule(4, r112);
    L81:
        r10.add(r114);
        r18 = r111 + 1;
        goto L3
    L10:
        if (r113 == 'X') goto L71;
        if (r113 == 'y') goto L64;
        if (r113 == 'z') goto L60;
        switch(r113) {
            case 39: goto L55;
            case 75: goto L54;
            case 77: goto L45;
            case 83: goto L43;
            case 90: goto L37;
            case 97: goto L35;
            case 100: goto L34;
            case 104: goto L33;
            case 107: goto L32;
            case 109: goto L31;
            case 115: goto L30;
            case 119: goto L29;
            default: goto L17;
        };
    L17:
        switch(r113) {
            case 68: goto L28;
            case 69: goto L24;
            case 70: goto L22;
            case 71: goto L21;
            case 72: goto L20;
            default: goto L19;
        };
    L20:
        r114 = selectNumberRule(11, r112);
        goto L81
    L21:
        r114 = new n(0, r11);
        goto L81
    L22:
        r114 = selectNumberRule(8, r112);
        goto L81
    L28:
        r114 = selectNumberRule(6, r112);
        goto L81
    L24:
        if (r112 >= 4) goto L26;
        String[] r115 = r15;
    L27:
        r114 = new n(7, r115);
        goto L81
    L26:
        r115 = r14;
        goto L27
    L19:
        throw new IllegalArgumentException("Illegal pattern component: ".concat(r110));
    L29:
        r114 = selectNumberRule(3, r112);
        goto L81
    L30:
        r114 = selectNumberRule(13, r112);
        goto L81
    L31:
        r114 = selectNumberRule(12, r112);
        goto L81
    L32:
        r114 = new r(selectNumberRule(11, r112), 1);
        goto L81
    L33:
        r114 = new r(selectNumberRule(10, r112), 0);
        goto L81
    L34:
        r114 = selectNumberRule(5, r112);
        goto L81
    L35:
        r114 = new n(9, r16);
        goto L81
    L43:
        r114 = selectNumberRule(14, r112);
        goto L81
    L54:
        r114 = selectNumberRule(10, r112);
        goto L81
    L55:
        String r116 = r110.substring(1);
        if (r116.length() != 1) goto L58;
        Object r117 = new h(r116.charAt(0));
    L47:
        r114 = r117;
        goto L81
    L58:
        r117 = new m(r116);
        goto L47
    L37:
        if (r112 != 1) goto L40;
        r114 = q.d;
        goto L81
    L40:
        if (r112 != 2) goto L42;
        r114 = q.e;
        goto L81
    L42:
        r114 = q.f21105c;
        goto L81
    L45:
        if (r112 < 4) goto L49;
        r117 = new n(2, r12);
        goto L47
    L49:
        if (r112 != 3) goto L51;
        r117 = new n(2, r13);
        goto L47
    L51:
        if (r112 != 2) goto L53;
        r114 = s.f21110b;
        goto L81
    L53:
        r114 = s.d;
        goto L81
    L60:
        if (r112 < 4) goto L62;
        r114 = new p(1, this.mTimeZone, this.mLocale);
        goto L81
    L62:
        r114 = new p(0, this.mTimeZone, this.mLocale);
        goto L81
    L64:
        if (r112 != 2) goto L67;
        r114 = s.f21111c;
        goto L81
    L67:
        if (r112 >= 4) goto L69;
        r112 = 4;
    L69:
        r114 = selectNumberRule(1, r112);
        goto L81
    L71:
        if (r112 == 1) goto L79;
        if (r112 != 2) goto L74;
        r114 = i.f21092c;
        goto L81
    L74:
        if (r112 != 3) goto L77;
        r114 = i.d;
        goto L81
    L77:
        throw new IllegalArgumentException("invalid number of X");
    L79:
        r114 = i.f21091b;
    L82:
        return r10;
    }

    public String parseToken(String r13, int[] r14) {
        StringBuilder r12 = new StringBuilder();
        int r5 = r14[0];
        int r10 = r13.length();
        char r11 = r13.charAt(r5);
        if (r11 < 'A') goto L6;
        if (r11 > 'Z') goto L6;
    L8:
        r12.append(r11);
    L9:
        int r15 = r5 + 1;
        if (r15 >= r10) goto L32;
        if (r13.charAt(r15) != r11) goto L32;
        r12.append(r11);
        r5 = r15;
    L32:
        r14[0] = r5;
        return r12.toString();
    L6:
        if (r11 < 'a') goto L14;
        if (r11 <= 'z') goto L8;
    L14:
        r12.append('\'');
        boolean r16 = false;
    L15:
        if (r5 >= r10) goto L32;
        char r17 = r13.charAt(r5);
        if (r17 != '\'') goto L24;
        int r18 = r5 + 1;
        if (r18 < r10) goto L21;
    L23:
        r16 = !r16;
    L31:
        r5 = r5 + 1;
        goto L15
    L21:
        if (r13.charAt(r18) != '\'') goto L23;
        r12.append(r17);
        r5 = r18;
        goto L31
    L24:
        if (r16 == true) goto L30;
        if (r17 < 'A') goto L27;
        if (r17 > 'Z') goto L27;
    L29:
        r5 = r5 - 1;
    L27:
        if (r17 < 'a') goto L30;
        if (r17 <= 'z') goto L29;
    L30:
        r12.append(r17);
        goto L31
    }

    public j selectNumberRule(int r5, int r10) {
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return new k(r5, r10);
    L9:
        return new t(r5, 0);
    L11:
        return new t(r5, 1);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
    }

    public String format(long r5) {
        GregorianCalendar r10 = new GregorianCalendar(this.mTimeZone, this.mLocale);
        r10.setTimeInMillis(r5);
        return applyRules(r10, new StringBuffer(this.f21077b)).toString();
    }

    public String format(Date r5) {
        GregorianCalendar r10 = new GregorianCalendar(this.mTimeZone, this.mLocale);
        r10.setTime(r5);
        return applyRules(r10, new StringBuffer(this.f21077b)).toString();
    }

    public StringBuffer format(Date r5, StringBuffer r10) {
        GregorianCalendar r11 = new GregorianCalendar(this.mTimeZone, this.mLocale);
        r11.setTime(r5);
        return applyRules(r11, r10);
    }

    public String format(Calendar r5) {
        return format(r5, new StringBuffer(this.f21077b)).toString();
    }

    public StringBuffer format(long r5, StringBuffer r10) {
        return format(new Date(r5), r10);
    }

    public StringBuffer format(Calendar r5, StringBuffer r10) {
        return applyRules(r5, r10);
    }
}
