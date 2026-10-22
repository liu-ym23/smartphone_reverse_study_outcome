package org.threeten.bp.temporal;

import ai.j0;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes3.dex */
public final class WeekFields implements Serializable {
    public static final WeekFields ISO = null;
    public static final WeekFields SUNDAY_START = null;
    public static final ConcurrentHashMap f = null;
    private static final long serialVersionUID = -1177360819670808121L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient k f21279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient k f21280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient k f21281c;
    public final transient k d;
    public final transient k e;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;

    static {
        f = new ConcurrentHashMap(4, 0.75f, 2);
        ISO = new WeekFields(DayOfWeek.MONDAY, 4);
        SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    }

    public WeekFields(DayOfWeek r10, int r11) {
        ChronoUnit r5 = ChronoUnit.DAYS;
        ChronoUnit r12 = ChronoUnit.WEEKS;
        this.f21279a = new k("DayOfWeek", this, r5, r12, k.f);
        this.f21280b = new k("WeekOfMonth", this, r12, ChronoUnit.MONTHS, k.g);
        this.f21281c = new k("WeekOfYear", this, r12, ChronoUnit.YEARS, k.f21289h);
        j r13 = b.d;
        this.d = new k("WeekOfWeekBasedYear", this, r12, r13, k.f21290i);
        this.e = new k("WeekBasedYear", this, r13, ChronoUnit.FOREVER, k.f21291j);
        jm.c.p(r10, "firstDayOfWeek");
        if (r11 < 1) goto L9;
        if (r11 > 7) goto L9;
        this.firstDayOfWeek = r10;
        this.minimalDays = r11;
        return;
    L9:
        throw new IllegalArgumentException("Minimal number of days is invalid");
    }

    public static /* synthetic */ g access$000(WeekFields r5) {
        return r5.d;
    }

    public static WeekFields of(Locale r5) {
        jm.c.p(r5, "locale");
        GregorianCalendar r10 = new GregorianCalendar(new Locale(r5.getLanguage(), r5.getCountry()));
        return of(DayOfWeek.SUNDAY.plus(r10.getFirstDayOfWeek() - 1), r10.getMinimalDaysInFirstWeek());
    }

    private Object readResolve() throws InvalidObjectException {
        return of(this.firstDayOfWeek, this.minimalDays);
    L4:
        e = move-exception;
        throw new InvalidObjectException("Invalid WeekFields" + e.getMessage());
    }

    public g dayOfWeek() {
        return this.f21279a;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WeekFields) == true) goto L8;
        return false;
    L8:
        if (hashCode() != r5.hashCode()) goto L11;
        return true;
    L11:
        return false;
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("WeekFields[");
        r5.append(this.firstDayOfWeek);
        r5.append(',');
        return j0.n(r5, this.minimalDays, ']');
    }

    public g weekBasedYear() {
        return this.e;
    }

    public g weekOfMonth() {
        return this.f21280b;
    }

    public g weekOfWeekBasedYear() {
        return this.d;
    }

    public g weekOfYear() {
        return this.f21281c;
    }

    public static WeekFields of(DayOfWeek r5, int r10) {
        String r11 = r5.toString() + r10;
        ConcurrentHashMap r12 = f;
        WeekFields r13 = (WeekFields) r12.get(r11);
        if (r13 != null) goto L6;
        r12.putIfAbsent(r11, new WeekFields(r5, r10));
        return (WeekFields) r12.get(r11);
    L6:
        return r13;
    }
}
