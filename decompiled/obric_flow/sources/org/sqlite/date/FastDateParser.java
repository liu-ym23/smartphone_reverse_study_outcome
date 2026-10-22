package org.sqlite.date;

import ai.j0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class FastDateParser implements Serializable {
    static final Locale JAPANESE_IMPERIAL = null;
    public static final Pattern e = null;
    public static final ConcurrentMap[] f = null;
    public static final b g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f21058h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f21059i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f21060j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f21061k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f21062l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f21063m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f21064n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e f21065o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f21066p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f21067q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e f21068r = null;
    public static final e s = null;
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e f21069t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e f21070u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f21071v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Pattern f21072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient f[] f21073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f21074c;
    private final int century;
    public transient f d;
    private final Locale locale;
    private final String pattern;
    private final int startYear;
    private final TimeZone timeZone;

    static {
        JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
        e = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|S+|W+|X+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");
        f = new ConcurrentMap[17];
        g = new b(1, 0);
        f21058h = new b(2, 1);
        f21059i = new e(1);
        f21060j = new e(3);
        f21061k = new e(4);
        f21062l = new e(6);
        f21063m = new e(5);
        f21064n = new e(8);
        f21065o = new e(11);
        f21066p = new b(11, 2);
        f21067q = new b(10, 3);
        f21068r = new e(10);
        s = new e(12);
        f21069t = new e(13);
        f21070u = new e(14);
        f21071v = new d("(Z|(?:[+-]\\d{2}(?::?\\d{2})?))", 0);
    }

    public FastDateParser(String r5, TimeZone r10, Locale r11) {
        this(r5, r10, r11, null);
    }

    public static StringBuilder access$100(StringBuilder r5, String r10, boolean r11) {
        r5.append("\\Q");
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L22;
        char r13 = r10.charAt(r12);
        if (r13 != '\'') goto L8;
        if (r11 == false) goto L21;
        r12 = r12 + 1;
        if (r12 == r10.length()) goto L23;
        r13 = r10.charAt(r12);
    L23:
        return r5;
    L21:
        r5.append(r13);
        r12 = r12 + 1;
        goto L4
    L8:
        if (r13 != '\\') goto L21;
        r12 = r12 + 1;
        if (r12 == r10.length()) goto L21;
        r5.append(r13);
        r13 = r10.charAt(r12);
        if (r13 != 'E') goto L21;
        r5.append("E\\\\E\\");
        r13 = 'Q';
        goto L21
    L22:
        r5.append("\\E");
        goto L23
    }

    public static Map access$200(int r5, Calendar r10, Locale r11) {
        return r10.getDisplayNames(r5, 0, r11);
    }

    public static int access$300(FastDateParser r5, int r10) {
        int r11 = r5.century + r10;
        if (r10 < r5.startYear) goto L6;
        return r11;
    L6:
        return r11 + 100;
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        c(Calendar.getInstance(this.timeZone, this.locale));
    }

    public final f a(int r5, Calendar r10) {
        ConcurrentMap[] r11 = f;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r11[r5] != null) goto L9;
        r11[r5] = new ConcurrentHashMap(3);     // Catch: Throwable -> L7
    L9:
        ConcurrentMap r12 = r11[r5];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        f r13 = (f) r12.get(this.locale);
        if (r13 == null) goto L14;
    L20:
        return r13;
    L14:
        if (r5 != 15) goto L16;
        r13 = new g(this.locale);
    L17:
        f r14 = (f) r12.putIfAbsent(this.locale, r13);
        if (r14 == null) goto L20;
        return r14;
    L16:
        r13 = new c(r5, r10, this.locale);
        goto L17
    }

    public final f b(String r10, Calendar r11) {
        char r5 = r10.charAt(0);
        if (r5 == 'W') goto L74;
        if (r5 != 'X') goto L7;
        int r12 = r10.length();
        if (r12 == 1) goto L72;
        if (r12 == 2) goto L78;
        if (r12 != 3) goto L69;
        return d.e;
    L69:
        throw new IllegalArgumentException("invalid number of X");
    L78:
        return d.d;
    L72:
        return d.f21084c;
    L7:
        if (r5 == 'y') goto L59;
        if (r5 == 'z') goto L57;
        switch(r5) {
            case 39: goto L51;
            case 75: goto L49;
            case 77: goto L44;
            case 83: goto L42;
            case 90: goto L38;
            case 97: goto L36;
            case 100: goto L34;
            case 104: goto L32;
            case 107: goto L30;
            case 109: goto L28;
            case 115: goto L26;
            case 119: goto L24;
            default: goto L11;
        };
    L11:
        switch(r5) {
            case 68: goto L22;
            case 69: goto L20;
            case 70: goto L18;
            case 71: goto L16;
            case 72: goto L14;
            default: goto L55;
        };
    L14:
        return f21065o;
    L16:
        return a(0, r11);
    L18:
        return f21064n;
    L20:
        return a(7, r11);
    L22:
        return f21062l;
    L55:
        return new d(r10, 1);
    L24:
        return f21060j;
    L26:
        return f21069t;
    L28:
        return s;
    L30:
        return f21066p;
    L32:
        return f21067q;
    L34:
        return f21063m;
    L36:
        return a(9, r11);
    L38:
        if (r10.equals("ZZ") == false) goto L57;
        return f21071v;
    L42:
        return f21070u;
    L44:
        if (r10.length() < 3) goto L47;
        return a(2, r11);
    L47:
        return f21058h;
    L49:
        return f21068r;
    L51:
        if (r10.length() <= 2) goto L55;
        return new d(androidx.constraintlayout.motion.widget.a.n(r10, 1, 1), 1);
    L57:
        return a(15, r11);
    L59:
        if (r10.length() <= 2) goto L62;
        return f21059i;
    L62:
        return g;
    L74:
        return f21061k;
    }

    public final void c(Calendar r10) {
        StringBuilder r5 = new StringBuilder();
        ArrayList r11 = new ArrayList();
        Matcher r12 = e.matcher(this.pattern);
        if (r12.lookingAt() == false) goto L21;
        String r13 = r12.group();
        this.f21074c = r13;
        f r14 = b(r13, r10);
    L5:
        r12.region(r12.end(), r12.regionEnd());
        if (r12.lookingAt() == false) goto L7;
        String r15 = r12.group();
        this.d = b(r15, r10);
        if (r14.a(this, r5) == false) goto L19;
        r11.add(r14);
    L19:
        this.f21074c = r15;
        r14 = this.d;
        goto L5
    L7:
        this.d = null;
        if (r12.regionStart() != r12.regionEnd()) goto L15;
        if (r14.a(this, r5) == false) goto L12;
        r11.add(r14);
    L12:
        this.f21074c = null;
        this.f21073b = (f[]) r11.toArray(new f[r11.size()]);
        this.f21072a = Pattern.compile(r5.toString());
        return;
    L15:
        throw new IllegalArgumentException("Failed to parse \"" + this.pattern + "\" ; gave up at index " + r12.regionStart());
    L21:
        throw new IllegalArgumentException("Illegal pattern character '" + this.pattern.charAt(r12.regionStart()) + "'");
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof FastDateParser) == true) goto L5;
        return false;
    L5:
        FastDateParser r10 = (FastDateParser) r5;
        if (this.pattern.equals(r10.pattern) == true) goto L8;
        return false;
    L8:
        if (this.timeZone.equals(r10.timeZone) == true) goto L10;
        return false;
    L10:
        if (this.locale.equals(r10.locale) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public int getFieldWidth() {
        return this.f21074c.length();
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Pattern getParsePattern() {
        return this.f21072a;
    }

    public String getPattern() {
        return this.pattern;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        int r5 = this.pattern.hashCode();
        int r10 = this.timeZone.hashCode();
        return (((this.locale.hashCode() * 13) + r10) * 13) + r5;
    }

    public boolean isNextNumber() {
        f r5 = this.d;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.b() == false) goto L7;
        return true;
    }

    public Date parse(String r10) throws ParseException {
        Date r5 = parse(r10, new ParsePosition(0));
        if (r5 == null) goto L5;
        return r5;
    L5:
        if (this.locale.equals(JAPANESE_IMPERIAL) == true) goto L7;
        StringBuilder r11 = j0.x("Unparseable date: \"", r10, "\" does not match ");
        r11.append(this.f21072a.pattern());
        throw new ParseException(r11.toString(), 0);
    L7:
        throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\nUnparseable date: \"" + r10 + "\" does not match " + this.f21072a.pattern(), 0);
    }

    public Object parseObject(String r5) throws ParseException {
        return parse(r5);
    }

    public String toString() {
        return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
    }

    public FastDateParser(String r5, TimeZone r10, Locale r11, Date r12) {
        this.pattern = r5;
        this.timeZone = r10;
        this.locale = r11;
        Calendar r13 = Calendar.getInstance(r10, r11);
        if (r12 == null) goto L6;
        r13.setTime(r12);
        int r14 = r13.get(1);
    L9:
        int r15 = (r14 / 100) * 100;
        this.century = r15;
        this.startYear = r14 - r15;
        c(r13);
        return;
    L6:
        if (r11.equals(JAPANESE_IMPERIAL) == false) goto L8;
        r14 = 0;
        goto L9
    L8:
        r13.setTime(new Date());
        r14 = r13.get(1) - 80;
        goto L9
    }

    public Object parseObject(String r5, ParsePosition r10) {
        return parse(r5, r10);
    }

    public Date parse(String r10, ParsePosition r11) {
        int r5 = r11.getIndex();
        Matcher r12 = this.f21072a.matcher(r10.substring(r5));
        if (r12.lookingAt() == true) goto L6;
        return null;
    L6:
        Calendar r13 = Calendar.getInstance(this.timeZone, this.locale);
        r13.clear();
        int r14 = 0;
    L7:
        f[] r15 = this.f21073b;
        if (r14 >= r15.length) goto L10;
        int r16 = r14 + 1;
        r15[r14].c(this, r13, r12.group(r16));
        r14 = r16;
        goto L7
    L10:
        r11.setIndex(r12.end() + r5);
        return r13.getTime();
    }
}
