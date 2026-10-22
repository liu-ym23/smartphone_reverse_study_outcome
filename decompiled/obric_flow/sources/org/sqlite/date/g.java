package org.sqlite.date;

import ai.j0;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeMap f21089b;

    public g(Locale r10) {
        this.f21089b = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        String[][] r11 = DateFormatSymbols.getInstance(r10).getZoneStrings();
        int r5 = r11.length;
        int r12 = 0;
    L4:
        if (r12 >= r5) goto L23;
        String[] r13 = r11[r12];
        if (r13[0].startsWith("GMT") == true) goto L22;
        TimeZone r14 = TimeZone.getTimeZone(r13[0]);
        if (this.f21089b.containsKey(r13[1]) == true) goto L12;
        this.f21089b.put(r13[1], r14);
    L12:
        if (this.f21089b.containsKey(r13[2]) == true) goto L15;
        this.f21089b.put(r13[2], r14);
    L15:
        if (r14.useDaylightTime() == false) goto L22;
        if (this.f21089b.containsKey(r13[3]) == true) goto L20;
        this.f21089b.put(r13[3], r14);
    L20:
        if (this.f21089b.containsKey(r13[4]) == true) goto L22;
        this.f21089b.put(r13[4], r14);
    L22:
        r12 = r12 + 1;
        goto L4
    L23:
        StringBuilder r15 = j0.u("(GMT[+-]\\d{1,2}:\\d{2}|[+-]\\d{4}|");
        Iterator r16 = this.f21089b.keySet().iterator();
    L25:
        if (r16.hasNext() == false) goto L27;
        FastDateParser.access$100(r15, (String) r16.next(), false).append('|');
        goto L25
    L27:
        r15.setCharAt(r15.length() - 1, ')');
        this.f21088a = r15.toString();
    }

    @Override // org.sqlite.date.f
    public final boolean a(FastDateParser r5, StringBuilder r10) {
        r10.append(this.f21088a);
        return true;
    }

    @Override // org.sqlite.date.f
    public final void c(FastDateParser r5, Calendar r10, String r11) {
        if (r11.charAt(0) != '+') goto L5;
    L15:
        TimeZone r12 = TimeZone.getTimeZone("GMT".concat(r11));
    L16:
        r10.setTimeZone(r12);
        return;
    L5:
        if (r11.charAt(0) == '-') goto L15;
        if (r11.startsWith("GMT") == false) goto L10;
        r12 = TimeZone.getTimeZone(r11);
        goto L16
    L10:
        r12 = (TimeZone) this.f21089b.get(r11);
        if (r12 != null) goto L16;
        throw new IllegalArgumentException(r11.concat(" is not a supported timezone name"));
    }
}
