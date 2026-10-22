package org.sqlite.date;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f21078b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f21079a;

    static {
        f21078b = new ConcurrentHashMap(7);
    }

    public a() {
        this.f21079a = new ConcurrentHashMap(7);
    }

    public final Format a(Integer r5, Integer r10, TimeZone r11, Locale r12) {
        if (r12 != null) goto L4;
        r12 = Locale.getDefault();
    L4:
        u r13 = new u(new Object[]{r5, r10, r12});
        ConcurrentHashMap r14 = f21078b;
        String r15 = (String) r14.get(r13);
        if (r15 != null) goto L18;
        if (r5 != null) goto L8;
        DateFormat r16 = DateFormat.getTimeInstance(r10.intValue(), r12);     // Catch: ClassCastException -> L15
    L11:
        String r17 = ((SimpleDateFormat) r16).toPattern();     // Catch: ClassCastException -> L15
        String r18 = (String) r14.putIfAbsent(r13, r17);     // Catch: ClassCastException -> L15
        if (r18 == null) goto L14;
        r15 = r18;
        goto L18
    L14:
        r15 = r17;
        goto L18
    L8:
        if (r10 != null) goto L10;
        r16 = DateFormat.getDateInstance(r5.intValue(), r12);     // Catch: ClassCastException -> L15
        goto L11
    L10:
        r16 = DateFormat.getDateTimeInstance(r5.intValue(), r10.intValue(), r12);     // Catch: ClassCastException -> L15
    L16:
        throw new IllegalArgumentException("No date time pattern for locale: " + r12);
    L18:
        return b(r15, r11, r12);
    }

    public final Format b(String r5, TimeZone r10, Locale r11) {
        if (r5 == null) goto L14;
        if (r10 != null) goto L5;
        r10 = TimeZone.getDefault();
    L5:
        if (r11 != null) goto L7;
        r11 = Locale.getDefault();
    L7:
        u r12 = new u(new Object[]{r5, r10, r11});
        ConcurrentHashMap r13 = this.f21079a;
        Format r14 = (Format) r13.get(r12);
        if (r14 != null) goto L15;
        FastDateFormat r15 = new FastDateFormat(r5, r10, r11);
        Format r16 = (Format) r13.putIfAbsent(r12, r15);
        if (r16 != null) goto L12;
        return r15;
    L12:
        return r16;
    L15:
        return r14;
    L14:
        throw new NullPointerException("pattern must not be null");
    }
}
