package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes3.dex */
final class ChronoPeriodImpl extends e implements Serializable {
    private static final long serialVersionUID = 275618735781L;
    private final i chronology;
    private final int days;
    private final int months;
    private final int years;

    public ChronoPeriodImpl(i r5, int r10, int r11, int r12) {
        this.chronology = r5;
        this.years = r10;
        this.months = r11;
        this.days = r12;
    }

    @Override // org.threeten.bp.temporal.f
    public org.threeten.bp.temporal.c addTo(org.threeten.bp.temporal.c r5) {
        jm.c.p(r5, "temporal");
        i r10 = (i) r5.query(org.threeten.bp.temporal.h.f21287b);
        if (r10 != null) goto L5;
    L9:
        int r11 = this.years;
        if (r11 == 0) goto L12;
        r5 = r5.plus(r11, ChronoUnit.YEARS);
    L12:
        int r12 = this.months;
        if (r12 == 0) goto L15;
        r5 = r5.plus(r12, ChronoUnit.MONTHS);
    L15:
        int r13 = this.days;
        if (r13 != 0) goto L18;
        return r5;
    L18:
        return r5.plus(r13, ChronoUnit.DAYS);
    L5:
        if (this.chronology.equals(r10) == true) goto L9;
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + r10.getId());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChronoPeriodImpl) == false) goto L18;
        ChronoPeriodImpl r10 = (ChronoPeriodImpl) r5;
        if (this.years != r10.years) goto L17;
        if (this.months != r10.months) goto L17;
        if (this.days != r10.days) goto L17;
        if (this.chronology.equals(r10.chronology) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    @Override // org.threeten.bp.temporal.f
    public long get(org.threeten.bp.temporal.j r5) {
        if (r5 != ChronoUnit.YEARS) goto L8;
        int r10 = this.years;
    L6:
        return r10;
    L8:
        if (r5 != ChronoUnit.MONTHS) goto L11;
        r10 = this.months;
        goto L6
    L11:
        if (r5 != ChronoUnit.DAYS) goto L14;
        r10 = this.days;
        goto L6
    L14:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r5);
    }

    @Override // org.threeten.bp.chrono.e
    public i getChronology() {
        return this.chronology;
    }

    @Override // org.threeten.bp.temporal.f
    public List<org.threeten.bp.temporal.j> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new org.threeten.bp.temporal.j[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int hashCode() {
        int r5 = this.chronology.hashCode();
        int r10 = Integer.rotateLeft(this.years, 16) + r5;
        return (Integer.rotateLeft(this.months, 8) + r10) + this.days;
    }

    public e minus(org.threeten.bp.temporal.f r10) {
        if ((r10 instanceof ChronoPeriodImpl) == false) goto L9;
        ChronoPeriodImpl r5 = (ChronoPeriodImpl) r10;
        if (r5.getChronology().equals(getChronology()) == false) goto L9;
        return new ChronoPeriodImpl(this.chronology, jm.c.v(this.years, r5.years), jm.c.v(this.months, r5.months), jm.c.v(this.days, r5.days));
    L9:
        throw new DateTimeException("Unable to subtract amount: " + r10);
    }

    @Override // org.threeten.bp.chrono.e
    public e multipliedBy(int r5) {
        return new ChronoPeriodImpl(this.chronology, jm.c.s(this.years, r5), jm.c.s(this.months, r5), jm.c.s(this.days, r5));
    }

    public e normalized() {
        i r5 = this.chronology;
        ChronoField r10 = ChronoField.MONTH_OF_YEAR;
        if (r5.range(r10).isFixed() == false) goto L6;
        long r11 = (this.chronology.range(r10).getMaximum() - this.chronology.range(r10).getMinimum()) + 1;
        long r12 = (((long) this.years) * r11) + ((long) this.months);
        int r13 = jm.c.x(r12 / r11);
        int r14 = jm.c.x(r12 % r11);
        return new ChronoPeriodImpl(this.chronology, r13, r14, this.days);
    L6:
        return this;
    }

    public e plus(org.threeten.bp.temporal.f r10) {
        if ((r10 instanceof ChronoPeriodImpl) == false) goto L9;
        ChronoPeriodImpl r5 = (ChronoPeriodImpl) r10;
        if (r5.getChronology().equals(getChronology()) == false) goto L9;
        return new ChronoPeriodImpl(this.chronology, jm.c.q(this.years, r5.years), jm.c.q(this.months, r5.months), jm.c.q(this.days, r5.days));
    L9:
        throw new DateTimeException("Unable to add amount: " + r10);
    }

    @Override // org.threeten.bp.temporal.f
    public org.threeten.bp.temporal.c subtractFrom(org.threeten.bp.temporal.c r5) {
        jm.c.p(r5, "temporal");
        i r10 = (i) r5.query(org.threeten.bp.temporal.h.f21287b);
        if (r10 != null) goto L5;
    L9:
        int r11 = this.years;
        if (r11 == 0) goto L12;
        r5 = r5.minus(r11, ChronoUnit.YEARS);
    L12:
        int r12 = this.months;
        if (r12 == 0) goto L15;
        r5 = r5.minus(r12, ChronoUnit.MONTHS);
    L15:
        int r13 = this.days;
        if (r13 != 0) goto L18;
        return r5;
    L18:
        return r5.minus(r13, ChronoUnit.DAYS);
    L5:
        if (this.chronology.equals(r10) == true) goto L9;
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + r10.getId());
    }

    public String toString() {
        if (isZero() == true) goto L5;
        StringBuilder r5 = new StringBuilder();
        r5.append(this.chronology);
        r5.append(" P");
        int r10 = this.years;
        if (r10 == 0) goto L9;
        r5.append(r10);
        r5.append('Y');
    L9:
        int r11 = this.months;
        if (r11 == 0) goto L12;
        r5.append(r11);
        r5.append('M');
    L12:
        int r12 = this.days;
        if (r12 == 0) goto L16;
        r5.append(r12);
        r5.append('D');
    L16:
        return r5.toString();
    L5:
        return this.chronology + " P0D";
    }
}
