package org.apache.commons.lang3.time;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Locale f20978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f20979c;

    public n(Locale r15) {
        this.f20979c = new HashMap();
        this.f20978b = r15;
        StringBuilder r5 = new StringBuilder("((?iu)[+-]\\d{4}|GMT[+-]\\d{1,2}:\\d{2}");
        TreeSet r10 = new TreeSet(FastDateParser.f20945h);
        String[][] r11 = DateFormatSymbols.getInstance(r15).getZoneStrings();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L24;
        String[] r14 = r11[r13];
        String r16 = r14[0];
        if (r16.equalsIgnoreCase("GMT") == true) goto L23;
        TimeZone r17 = TimeZone.getTimeZone(r16);
        m r18 = new m(r17, false);
        m r19 = r18;
        int r110 = 1;
    L9:
        if (r110 >= r14.length) goto L23;
        if (r110 != 3) goto L13;
        r19 = new m(r17, true);
    L17:
        String r111 = r14[r110];
        if (r111 == null) goto L22;
        String r112 = r111.toLowerCase(r15);
        if (r10.add(r112) == false) goto L22;
        this.f20979c.put(r112, r19);
    L22:
        r110 = r110 + 1;
        goto L9
    L13:
        if (r110 != 5) goto L17;
        r19 = r18;
    L23:
        r13 = r13 + 1;
        goto L3
    L24:
        Iterator r113 = r10.iterator();
    L26:
        if (r113.hasNext() == false) goto L28;
        String r20 = (String) r113.next();
        r5.append('|');
        FastDateParser.a(r5, r20);
        goto L26
    L28:
        r5.append(")");
        this.f20973a = Pattern.compile(r5.toString());
    }

    @Override // org.apache.commons.lang3.time.j
    public final void c(String r5, Calendar r10) {
        TimeZone r11 = o.a(r5);
        if (r11 == null) goto L6;
        r10.setTimeZone(r11);
        return;
    L6:
        String r12 = r5.toLowerCase(this.f20978b);
        HashMap r13 = this.f20979c;
        m r14 = (m) r13.get(r12);
        if (r14 != null) goto L9;
        r14 = (m) r13.get(r12 + '.');
    L9:
        r10.set(16, r14.f20977b);
        r10.set(15, r14.f20976a.getRawOffset());
    }
}
