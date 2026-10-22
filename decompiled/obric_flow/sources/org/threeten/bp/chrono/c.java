package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends fv.b implements org.threeten.bp.temporal.e, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ca.d f21169a = null;

    static {
        f21169a = new ca.d(28);
    }

    public c() {
    }

    public static c from(org.threeten.bp.temporal.d r5) {
        jm.c.p(r5, "temporal");
        if ((r5 instanceof c) == true) goto L5;
        i r10 = (i) r5.query(org.threeten.bp.temporal.h.f21287b);
        if (r10 == null) goto L11;
        return r10.localDateTime(r5);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoLocalDateTime: " + r5.getClass());
    L5:
        return (c) r5;
    }

    public static Comparator<c> timeLineOrder() {
        return f21169a;
    }

    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    public abstract g atZone(ZoneId r5);

    public /* bridge */ /* synthetic */ int compareTo(Object r5) {
        return compareTo((c) r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        if (compareTo((c) r5) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public String format(org.threeten.bp.format.b r5) {
        jm.c.p(r5, "formatter");
        return r5.a(this);
    }

    public i getChronology() {
        return toLocalDate().getChronology();
    }

    public int hashCode() {
        int r5 = toLocalDate().hashCode();
        return toLocalTime().hashCode() ^ r5;
    }

    public boolean isAfter(c r5) {
        long r10 = toLocalDate().toEpochDay();
        long r11 = r5.toLocalDate().toEpochDay();
        if (r10 > r11) goto L9;
        if (r10 == r11) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().toNanoOfDay() <= r5.toLocalTime().toNanoOfDay()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(c r5) {
        long r10 = toLocalDate().toEpochDay();
        long r11 = r5.toLocalDate().toEpochDay();
        if (r10 < r11) goto L9;
        if (r10 == r11) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().toNanoOfDay() >= r5.toLocalTime().toNanoOfDay()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(c r5) {
        if (toLocalTime().toNanoOfDay() == r5.toLocalTime().toNanoOfDay()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalDate().toEpochDay() != r5.toLocalDate().toEpochDay()) goto L7;
        return true;
    }

    @Override // fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    /* JADX INFO: renamed from: plus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1651plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L7;
        return (R) getChronology();
    L7:
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L11;
        return (R) ChronoUnit.NANOS;
    L11:
        if (r5 != org.threeten.bp.temporal.h.f) goto L15;
        return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
    L15:
        if (r5 != org.threeten.bp.temporal.h.g) goto L19;
        return (R) toLocalTime();
    L19:
        if (r5 != org.threeten.bp.temporal.h.d) goto L21;
        return null;
    L21:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L23;
        return null;
    L23:
        if (r5 != org.threeten.bp.temporal.h.e) goto L26;
        return null;
    L26:
        return (R) super.query(r5);
    }

    public long toEpochSecond(ZoneOffset r5) {
        jm.c.p(r5, "offset");
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) r5.getTotalSeconds());
    }

    public Instant toInstant(ZoneOffset r5) {
        return Instant.ofEpochSecond(toEpochSecond(r5), toLocalTime().getNano());
    }

    public abstract b toLocalDate();

    public abstract LocalTime toLocalTime();

    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }

    public int compareTo(c r5) {
        int r10 = toLocalDate().compareTo(r5.toLocalDate());
        if (r10 != 0) goto L8;
        int r11 = toLocalTime().compareTo2(r5.toLocalTime());
        if (r11 == 0) goto L7;
        return r11;
    L7:
        return getChronology().compareTo(r5.getChronology());
    L8:
        return r10;
    }

    /* JADX INFO: renamed from: minus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1650minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    public c plus(org.threeten.bp.temporal.f r5) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(r5.addTo(this));
    }

    public c minus(org.threeten.bp.temporal.f r5) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(r5.subtractFrom(this));
    }

    @Override // fv.b, org.threeten.bp.temporal.c
    public c minus(long r5, org.threeten.bp.temporal.j r10) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(r5, r10));
    }
}
