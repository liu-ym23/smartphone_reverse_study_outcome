package org.threeten.bp.chrono;

import androidx.room.writer.DaoWriter;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends fv.b implements org.threeten.bp.temporal.e, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ca.d f21168a = null;

    static {
        f21168a = new ca.d(27);
    }

    public b() {
    }

    public static b from(org.threeten.bp.temporal.d r5) {
        jm.c.p(r5, "temporal");
        if ((r5 instanceof b) == true) goto L5;
        i r10 = (i) r5.query(org.threeten.bp.temporal.h.f21287b);
        if (r10 == null) goto L11;
        return r10.date(r5);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoLocalDate: " + r5.getClass());
    L5:
        return (b) r5;
    }

    public static Comparator<b> timeLineOrder() {
        return f21168a;
    }

    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public abstract c atTime(LocalTime r5);

    public /* bridge */ /* synthetic */ int compareTo(Object r5) {
        return compareTo((b) r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        if (compareTo((b) r5) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public String format(org.threeten.bp.format.b r5) {
        jm.c.p(r5, "formatter");
        return r5.a(this);
    }

    public abstract i getChronology();

    public j getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    public int hashCode() {
        long r5 = toEpochDay();
        return getChronology().hashCode() ^ ((int) (r5 ^ (r5 >>> 32)));
    }

    public boolean isAfter(b r5) {
        if (toEpochDay() <= r5.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(b r5) {
        if (toEpochDay() >= r5.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqual(b r5) {
        if (toEpochDay() != r5.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r5.isDateBased();
    }

    public abstract int lengthOfMonth();

    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public abstract b plus(long r5, org.threeten.bp.temporal.j r10);

    /* JADX INFO: renamed from: plus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1649plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L7;
        return (R) getChronology();
    L7:
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L11;
        return (R) ChronoUnit.DAYS;
    L11:
        if (r5 != org.threeten.bp.temporal.h.f) goto L15;
        return (R) LocalDate.ofEpochDay(toEpochDay());
    L15:
        if (r5 != org.threeten.bp.temporal.h.g) goto L17;
        return null;
    L17:
        if (r5 != org.threeten.bp.temporal.h.d) goto L19;
        return null;
    L19:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L21;
        return null;
    L21:
        if (r5 != org.threeten.bp.temporal.h.e) goto L24;
        return null;
    L24:
        return (R) super.query(r5);
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    public String toString() {
        long r5 = getLong(ChronoField.YEAR_OF_ERA);
        long r10 = getLong(ChronoField.MONTH_OF_YEAR);
        long r11 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder r12 = new StringBuilder(30);
        r12.append(getChronology().toString());
        r12.append(" ");
        r12.append(getEra());
        r12.append(" ");
        r12.append(r5);
        String r13 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        if (r10 >= 10) goto L5;
        String r14 = "-0";
    L6:
        r12.append(r14);
        r12.append(r10);
        if (r11 >= 10) goto L9;
        r13 = "-0";
    L9:
        r12.append(r13);
        r12.append(r11);
        return r12.toString();
    L5:
        r14 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        goto L6
    }

    public abstract e until(b r5);

    public abstract b with(org.threeten.bp.temporal.g r5, long r10);

    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public int compareTo(b r5) {
        int r10 = jm.c.j(toEpochDay(), r5.toEpochDay());
        if (r10 == 0) goto L5;
        return r10;
    L5:
        return getChronology().compareTo(r5.getChronology());
    }

    /* JADX INFO: renamed from: minus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1648minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    public b plus(org.threeten.bp.temporal.f r5) {
        return getChronology().ensureChronoLocalDate(r5.addTo(this));
    }

    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public b minus(org.threeten.bp.temporal.f r5) {
        return getChronology().ensureChronoLocalDate(r5.subtractFrom(this));
    }

    public b with(org.threeten.bp.temporal.e r5) {
        return getChronology().ensureChronoLocalDate(r5.adjustInto(this));
    }

    public boolean isSupported(org.threeten.bp.temporal.j r5) {
        if ((r5 instanceof ChronoUnit) == true) goto L5;
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r5.isDateBased();
    }

    @Override // fv.b, org.threeten.bp.temporal.c
    public b minus(long r5, org.threeten.bp.temporal.j r10) {
        return getChronology().ensureChronoLocalDate(super.minus(r5, r10));
    }
}
