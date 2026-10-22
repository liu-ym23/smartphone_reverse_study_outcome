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
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends fv.b implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ca.d f21172a = null;

    static {
        f21172a = new ca.d(29);
    }

    public g() {
    }

    public static g from(org.threeten.bp.temporal.d r5) {
        jm.c.p(r5, "temporal");
        if ((r5 instanceof g) == true) goto L5;
        i r10 = (i) r5.query(org.threeten.bp.temporal.h.f21287b);
        if (r10 == null) goto L11;
        return r10.zonedDateTime(r5);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoZonedDateTime: " + r5.getClass());
    L5:
        return (g) r5;
    }

    public static Comparator<g> timeLineOrder() {
        return f21172a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r5) {
        return compareTo((g) r5);
    }

    public String format(org.threeten.bp.format.b r5) {
        jm.c.p(r5, "formatter");
        return r5.a(this);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        int r10 = f.f21171a[((ChronoField) r5).ordinal()];
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L11;
        return toLocalDateTime().get(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Field too large for an int: ", r5));
    L15:
        return super.get(r5);
    }

    public i getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        int r10 = f.f21171a[((ChronoField) r5).ordinal()];
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L11;
        return toLocalDateTime().getLong(r5);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        return toEpochSecond();
    L15:
        return r5.getFrom(this);
    }

    public abstract ZoneOffset getOffset();

    public abstract ZoneId getZone();

    public boolean isAfter(g r5) {
        long r10 = toEpochSecond();
        long r11 = r5.toEpochSecond();
        if (r10 > r11) goto L9;
        if (r10 == r11) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() <= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(g r5) {
        long r10 = toEpochSecond();
        long r11 = r5.toEpochSecond();
        if (r10 < r11) goto L9;
        if (r10 == r11) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() >= r5.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(g r5) {
        if (toEpochSecond() == r5.toEpochSecond()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalTime().getNano() != r5.toLocalTime().getNano()) goto L7;
        return true;
    }

    @Override // fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    /* JADX INFO: renamed from: plus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1666plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 == org.threeten.bp.temporal.h.f21286a) goto L30;
        if (r5 == org.threeten.bp.temporal.h.d) goto L30;
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L12;
        return (R) toLocalDate().getChronology();
    L12:
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L16;
        return (R) ChronoUnit.NANOS;
    L16:
        if (r5 != org.threeten.bp.temporal.h.e) goto L20;
        return (R) getOffset();
    L20:
        if (r5 != org.threeten.bp.temporal.h.f) goto L24;
        return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
    L24:
        if (r5 != org.threeten.bp.temporal.h.g) goto L28;
        return (R) toLocalTime();
    L28:
        return (R) super.query(r5);
    L30:
        return (R) getZone();
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L14;
        if (r5 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r5 == ChronoField.OFFSET_SECONDS) goto L12;
        return toLocalDateTime().range(r5);
    L12:
        return r5.range();
    L14:
        return r5.rangeRefinedBy(this);
    }

    public long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) getOffset().getTotalSeconds());
    }

    public Instant toInstant() {
        return Instant.ofEpochSecond(toEpochSecond(), toLocalTime().getNano());
    }

    public b toLocalDate() {
        return toLocalDateTime().toLocalDate();
    }

    public abstract c toLocalDateTime();

    public LocalTime toLocalTime() {
        return toLocalDateTime().toLocalTime();
    }

    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public abstract g withZoneSameInstant(ZoneId r5);

    public abstract g withZoneSameLocal(ZoneId r5);

    public int compareTo(g r5) {
        int r10 = jm.c.j(toEpochSecond(), r5.toEpochSecond());
        if (r10 != 0) goto L12;
        int r11 = toLocalTime().getNano() - r5.toLocalTime().getNano();
        if (r11 != 0) goto L13;
        int r12 = toLocalDateTime().compareTo(r5.toLocalDateTime());
        if (r12 != 0) goto L14;
        int r13 = getZone().getId().compareTo(r5.getZone().getId());
        if (r13 == 0) goto L11;
        return r13;
    L11:
        return toLocalDate().getChronology().compareTo(r5.toLocalDate().getChronology());
    L14:
        return r12;
    L13:
        return r11;
    L12:
        return r10;
    }

    /* JADX INFO: renamed from: minus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1665minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    public g plus(org.threeten.bp.temporal.f r5) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r5.addTo(this));
    }

    public g with(org.threeten.bp.temporal.e r5) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r5.adjustInto(this));
    }

    public g minus(org.threeten.bp.temporal.f r5) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(r5.subtractFrom(this));
    }

    @Override // fv.b, org.threeten.bp.temporal.c
    public g minus(long r5, org.threeten.bp.temporal.j r10) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(r5, r10));
    }
}
