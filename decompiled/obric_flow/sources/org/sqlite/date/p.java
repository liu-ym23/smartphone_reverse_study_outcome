package org.sqlite.date;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale f21102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21104c;
    public final String d;

    public p(int r5, TimeZone r10, Locale r11) {
        this.f21102a = r11;
        this.f21103b = r5;
        this.f21104c = FastDatePrinter.getTimeZoneDisplay(r10, false, r5, r11);
        this.d = FastDatePrinter.getTimeZoneDisplay(r10, true, r5, r11);
    }

    @Override // org.sqlite.date.l
    public final int a() {
        return Math.max(this.f21104c.length(), this.d.length());
    }

    @Override // org.sqlite.date.l
    public final void b(Calendar r5, StringBuffer r10) {
        TimeZone r11 = r5.getTimeZone();
        int r12 = r5.get(16);
        Locale r13 = this.f21102a;
        int r14 = this.f21103b;
        if (r12 == 0) goto L5;
        r10.append(FastDatePrinter.getTimeZoneDisplay(r11, true, r14, r13));
        return;
    L5:
        r10.append(FastDatePrinter.getTimeZoneDisplay(r11, false, r14, r13));
    }
}
