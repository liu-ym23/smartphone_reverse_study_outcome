package org.apache.commons.lang3.time;

import java.io.Serializable;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
public class FastDateParser implements Serializable {
    public static final Locale g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Comparator f20945h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentMap[] f20946i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f20947j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f20948k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i f20949l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final i f20950m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final i f20951n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final i f20952o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final i f20953p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c f20954q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final i f20955r = null;
    public static final i s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f20956t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e f20957u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final i f20958v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final i f20959w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final i f20960x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final i f20961y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeZone f20963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Locale f20964c;
    public final int d;
    public final int e;
    public final transient ArrayList f;

    static {
        g = new Locale("ja", "JP", "JP");
        f20945h = new ca.d(25);
        f20946i = new ConcurrentMap[17];
        f20947j = new a(1);
        f20948k = new b(2);
        f20949l = new i(1);
        f20950m = new i(3);
        f20951n = new i(4);
        f20952o = new i(6);
        f20953p = new i(5);
        f20954q = new c(7);
        f20955r = new i(8);
        s = new i(11);
        f20956t = new d(11);
        f20957u = new e(10);
        f20958v = new i(10);
        f20959w = new i(12);
        f20960x = new i(13);
        f20961y = new i(14);
    }

    public FastDateParser(String r11, TimeZone r12, Locale r13) {
        this.f20962a = r11;
        this.f20963b = r12;
        this.f20964c = r13;
        Calendar r14 = Calendar.getInstance(r12, r13);
        if (r13.equals(g) == false) goto L5;
        int r15 = 0;
    L6:
        int r5 = (r15 / 100) * 100;
        this.d = r5;
        this.e = r15 - r5;
        this.f = new ArrayList();
        int r16 = 0;
    L8:
        if (r16 < this.f20962a.length()) goto L10;
        l r10 = null;
    L84:
        if (r10 == null) goto L85;
        this.f.add(r10);
        goto L8
    L85:
        return;
    L10:
        char r17 = this.f20962a.charAt(r16);
        if (r17 < 'A') goto L14;
        if (r17 > 'Z') goto L14;
    L16:
        int r18 = r16;
    L17:
        r18 = r18 + 1;
        if (r18 >= this.f20962a.length()) goto L21;
        if (this.f20962a.charAt(r18) == r17) goto L17;
    L21:
        int r19 = r18 - r16;
        if (r17 == 'y') goto L60;
        if (r17 == 'z') goto L59;
        switch(r17) {
            case 68: goto L58;
            case 69: goto L57;
            case 70: goto L56;
            case 71: goto L55;
            case 72: goto L54;
            default: goto L26;
        };
    L54:
        k r20 = s;
    L63:
        l r21 = new l(r20, r19);
        r16 = r18;
        r10 = r21;
        goto L84
    L55:
        r20 = a(0, r14);
        goto L63
    L56:
        r20 = f20955r;
        goto L63
    L57:
        r20 = a(7, r14);
        goto L63
    L58:
        r20 = f20952o;
        goto L63
    L26:
        switch(r17) {
            case 75: goto L53;
            case 77: goto L50;
            case 83: goto L49;
            case 97: goto L48;
            case 100: goto L47;
            case 104: goto L46;
            case 107: goto L45;
            case 109: goto L44;
            case 115: goto L43;
            case 117: goto L42;
            case 119: goto L41;
            default: goto L27;
        };
    L27:
        switch(r17) {
            case 87: goto L40;
            case 88: goto L32;
            case 89: goto L60;
            case 90: goto L30;
            default: goto L29;
        };
    L30:
        if (r19 != 2) goto L59;
        r20 = h.d;
        goto L63
    L32:
        if (r19 == 1) goto L39;
        if (r19 == 2) goto L38;
        if (r19 != 3) goto L36;
        r20 = h.d;
        goto L63
    L36:
        h r110 = h.f20970b;
        throw new IllegalArgumentException("invalid number of X");
    L38:
        r20 = h.f20971c;
        goto L63
    L39:
        r20 = h.f20970b;
        goto L63
    L40:
        r20 = f20951n;
        goto L63
    L29:
        throw new IllegalArgumentException("Format '" + r17 + "' not supported");
    L41:
        r20 = f20950m;
        goto L63
    L42:
        r20 = f20954q;
        goto L63
    L43:
        r20 = f20960x;
        goto L63
    L44:
        r20 = f20959w;
        goto L63
    L45:
        r20 = f20956t;
        goto L63
    L46:
        r20 = f20957u;
        goto L63
    L47:
        r20 = f20953p;
        goto L63
    L48:
        r20 = a(9, r14);
        goto L63
    L49:
        r20 = f20961y;
        goto L63
    L50:
        if (r19 < 3) goto L52;
        r20 = a(2, r14);
        goto L63
    L52:
        r20 = f20948k;
        goto L63
    L53:
        r20 = f20958v;
    L59:
        r20 = a(15, r14);
    L60:
        if (r19 <= 2) goto L62;
        r20 = f20949l;
        goto L63
    L62:
        r20 = f20947j;
    L14:
        if (r17 < 'a') goto L64;
        if (r17 <= 'z') goto L16;
    L64:
        StringBuilder r22 = new StringBuilder();
        boolean r23 = false;
    L66:
        if (r16 >= this.f20962a.length()) goto L82;
        char r24 = this.f20962a.charAt(r16);
        if (r23 == true) goto L75;
        if (r24 < 'A') goto L71;
        if (r24 <= 'Z') goto L82;
    L71:
        if (r24 < 'a') goto L75;
        if (r24 <= 'z') goto L82;
    L75:
        if (r24 != '\'') goto L81;
        r16 = r16 + 1;
        if (r16 == this.f20962a.length()) goto L80;
        if (this.f20962a.charAt(r16) == '\'') goto L81;
    L80:
        r23 = !r23;
    L81:
        r16 = r16 + 1;
        r22.append(r24);
    L82:
        if (r23 == true) goto L88;
        String r25 = r22.toString();
        r10 = new l(new g(r25), r25.length());
        goto L84
    L88:
        throw new IllegalArgumentException("Unterminated quote");
    L5:
        r14.setTime(new Date());
        r15 = r14.get(1) - 80;
        goto L6
    }

    public final boolean a(String r11, ParsePosition r12, Calendar r13) {
        ListIterator r5 = this.f.listIterator();
    L4:
        if (r5.hasNext() == false) goto L17;
        l r10 = (l) r5.next();
        if (r10.f20974a.a() == true) goto L8;
    L13:
        int r14 = 0;
    L15:
        if (r10.f20974a.b(this, r13, r11, r12, r14) == true) goto L4;
        return false;
    L8:
        if (r5.hasNext() == false) goto L13;
        k r15 = ((l) r5.next()).f20974a;
        r5.previous();
        if (r15.a() == false) goto L13;
        r14 = r10.f20975b;
        goto L15
    L17:
        return true;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof FastDateParser) == true) goto L5;
        return false;
    L5:
        FastDateParser r10 = (FastDateParser) r5;
        if (this.f20962a.equals(r10.f20962a) == true) goto L8;
    L13:
        return false;
    L8:
        if (this.f20963b.equals(r10.f20963b) == false) goto L13;
        if (this.f20964c.equals(r10.f20964c) == false) goto L13;
        return true;
    }

    public final int hashCode() {
        int r5 = this.f20962a.hashCode();
        int r10 = this.f20963b.hashCode();
        return (((this.f20964c.hashCode() * 13) + r10) * 13) + r5;
    }

    public final String toString() {
        return "FastDateParser[" + this.f20962a + "," + this.f20964c + "," + this.f20963b.getID() + "]";
    }

    public static StringBuilder a(StringBuilder r10, String r11) {
        int r5 = 0;
    L4:
        if (r5 >= r11.length()) goto L23;
        char r12 = r11.charAt(r5);
        if (r12 == '$') goto L20;
        if (r12 == '.') goto L20;
        if (r12 == '?') goto L20;
        if (r12 == '^') goto L20;
        if (r12 == '[') goto L20;
        if (r12 == '\\') goto L20;
        if (r12 == '{') goto L20;
        if (r12 == '|') goto L20;
        switch(r12) {
            case 40: goto L20;
            case 41: goto L20;
            case 42: goto L20;
            case 43: goto L20;
            default: goto L21;
        };
    L21:
        r10.append(r12);
        r5 = r5 + 1;
    L20:
        r10.append('\\');
        goto L21
    L23:
        if (r10.charAt(r10.length() - 1) != '.') goto L25;
        r10.append('?');
    L25:
        return r10;
    }

    public static HashMap a(Calendar r5, Locale r10, int r11, StringBuilder r12) {
        HashMap r13 = new HashMap();
        Map<String, Integer> r14 = r5.getDisplayNames(r11, 0, r10);
        TreeSet r15 = new TreeSet(f20945h);
        Iterator<Map.Entry<String, Integer>> r16 = r14.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L8;
        Map.Entry<String, Integer> r17 = r16.next();
        String r18 = r17.getKey().toLowerCase(r10);
        if (r15.add(r18) == false) goto L4;
        r13.put(r18, r17.getValue());
        goto L4
    L8:
        Iterator r19 = r15.iterator();
    L10:
        if (r19.hasNext() == false) goto L12;
        a(r12, (String) r19.next()).append('|');
        goto L10
    L12:
        return r13;
    }

    public final k a(int r5, Calendar r10) {
        ConcurrentMap[] r11 = f20946i;
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
        k r13 = (k) r12.get(this.f20964c);
        if (r13 == null) goto L14;
        return r13;
    L14:
        if (r5 != 15) goto L16;
        k r14 = new n(this.f20964c);
    L17:
        k r15 = (k) r12.putIfAbsent(this.f20964c, r14);
        if (r15 == null) goto L20;
        return r15;
    L20:
        return r14;
    L16:
        r14 = new f(r5, r10, this.f20964c);
        goto L17
    }
}
