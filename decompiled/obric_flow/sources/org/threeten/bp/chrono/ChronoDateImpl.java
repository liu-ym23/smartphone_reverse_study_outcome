package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.chrono.b;
import org.threeten.bp.temporal.ChronoUnit;

/* JADX INFO: loaded from: classes3.dex */
abstract class ChronoDateImpl<D extends b> extends b implements Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public ChronoDateImpl() {
    }

    @Override // org.threeten.bp.chrono.b
    public c atTime(LocalTime r5) {
        return ChronoLocalDateTimeImpl.of(this, r5);
    }

    @Override // org.threeten.bp.temporal.d
    public abstract /* synthetic */ long getLong(org.threeten.bp.temporal.g r5);

    public ChronoDateImpl<D> minusDays(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ChronoDateImpl<D> this = plusDays(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusDays(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ChronoDateImpl<D> minusMonths(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ChronoDateImpl<D> this = plusMonths(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMonths(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ChronoDateImpl<D> minusWeeks(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ChronoDateImpl<D> this = plusWeeks(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusWeeks(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public ChronoDateImpl<D> minusYears(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        ChronoDateImpl<D> this = plusYears(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusYears(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public abstract ChronoDateImpl<D> plusDays(long r5);

    public abstract ChronoDateImpl<D> plusMonths(long r5);

    public ChronoDateImpl<D> plusWeeks(long r5) {
        return plusDays(jm.c.t(7, r5));
    }

    public abstract ChronoDateImpl<D> plusYears(long r5);

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        b r11 = getChronology().date(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L7;
        return LocalDate.from(this).until(r11, r10);
    L7:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public ChronoDateImpl<D> plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L23;
        switch(a.f21167a[((ChronoUnit) r10).ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        throw new DateTimeException(r10 + " not valid for chronology " + getChronology().getId());
    L9:
        return plusYears(jm.c.t(1000, r5));
    L11:
        return plusYears(jm.c.t(100, r5));
    L13:
        return plusYears(jm.c.t(10, r5));
    L15:
        return plusYears(r5);
    L17:
        return plusMonths(r5);
    L19:
        return plusDays(jm.c.t(7, r5));
    L21:
        return plusDays(r5);
    L23:
        return (ChronoDateImpl) getChronology().ensureChronoLocalDate(r10.addTo(this, r5));
    }

    @Override // org.threeten.bp.chrono.b
    public e until(b r5) {
        throw new UnsupportedOperationException("Not supported in ThreeTen backport");
    }
}
