package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class MinguoDate extends ChronoDateImpl<MinguoDate> implements Serializable {
    private static final long serialVersionUID = 1300372329181994526L;
    private final LocalDate isoDate;

    public MinguoDate(LocalDate r5) {
        jm.c.p(r5, "date");
        this.isoDate = r5;
    }

    public static MinguoDate from(org.threeten.bp.temporal.d r5) {
        return MinguoChronology.INSTANCE.date(r5);
    }

    public static MinguoDate now() {
        return now(org.threeten.bp.a.systemDefaultZone());
    }

    public static MinguoDate of(int r5, int r10, int r11) {
        return MinguoChronology.INSTANCE.date(r5, r10, r11);
    }

    public static b readExternal(DataInput r5) throws IOException {
        int r10 = r5.readInt();
        byte r11 = r5.readByte();
        byte r12 = r5.readByte();
        return MinguoChronology.INSTANCE.date(r10, r11, r12);
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    public final int a() {
        return this.isoDate.getYear() - 1911;
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b
    public final c atTime(LocalTime r5) {
        return super.atTime(r5);
    }

    public final MinguoDate b(LocalDate r5) {
        if (r5.equals(this.isoDate) == false) goto L6;
        return this;
    L6:
        return new MinguoDate(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MinguoDate) == true) goto L8;
        return false;
    L8:
        return this.isoDate.equals(((MinguoDate) r5).isoDate);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ i getChronology() {
        return getChronology();
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ j getEra() {
        return getEra();
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L31;
        int r10 = o.f21181a[((ChronoField) r5).ordinal()];
        int r11 = 1;
        if (r10 != 4) goto L7;
        int r12 = a();
        if (r12 >= 1) goto L29;
        r12 = 1 - r12;
    L29:
        return r12;
    L7:
        if (r10 == 5) goto L23;
        if (r10 == 6) goto L21;
        if (r10 == 7) goto L15;
        return this.isoDate.getLong(r5);
    L15:
        if (a() >= 1) goto L19;
        r11 = 0;
    L19:
        return r11;
    L21:
        return a();
    L23:
        return ((((long) a()) * 12) + ((long) this.isoDate.getMonthValue())) - 1;
    L31:
        return r5.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.b
    public int hashCode() {
        int r5 = getChronology().getId().hashCode();
        return this.isoDate.hashCode() ^ r5;
    }

    @Override // org.threeten.bp.chrono.b
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ ChronoDateImpl plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusDays(long r5) {
        return plusDays(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusMonths(long r5) {
        return plusMonths(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusYears(long r5) {
        return plusYears(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L27;
        if (isSupported(r5) == false) goto L25;
        ChronoField r10 = (ChronoField) r5;
        int r11 = o.f21181a[r10.ordinal()];
        if (r11 == 1) goto L23;
        if (r11 == 2) goto L23;
        if (r11 == 3) goto L23;
        if (r11 != 4) goto L15;
        ValueRange r12 = ChronoField.YEAR.range();
        if (a() > 0) goto L19;
        long r13 = (-r12.getMinimum()) + 1912;
    L21:
        return ValueRange.of(1, r13);
    L19:
        r13 = r12.getMaximum() - 1911;
        goto L21
    L15:
        return getChronology().range(r10);
    L23:
        return this.isoDate.range(r5);
    L25:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L27:
        return r5.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.b
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        return super.until(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeInt(get(ChronoField.YEAR));
        r5.writeByte(get(ChronoField.MONTH_OF_YEAR));
        r5.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public static MinguoDate now(ZoneId r5) {
        return now(org.threeten.bp.a.system(r5));
    }

    @Override // org.threeten.bp.chrono.b
    public MinguoChronology getChronology() {
        return MinguoChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.b
    public MinguoEra getEra() {
        return (MinguoEra) super.getEra();
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ b minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public MinguoDate plusDays(long r5) {
        return b(this.isoDate.plusDays(r5));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public MinguoDate plusMonths(long r5) {
        return b(this.isoDate.plusMonths(r5));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public MinguoDate plusYears(long r5) {
        return b(this.isoDate.plusYears(r5));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b
    public e until(b r5) {
        Period r10 = this.isoDate.until(r5);
        return getChronology().period(r10.getYears(), r10.getMonths(), r10.getDays());
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ b with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static MinguoDate now(org.threeten.bp.a r5) {
        return new MinguoDate(LocalDate.now(r5));
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public /* bridge */ /* synthetic */ b plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    @Override // org.threeten.bp.chrono.b
    /* JADX INFO: renamed from: minus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1648minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public MinguoDate minus(org.threeten.bp.temporal.f r5) {
        return (MinguoDate) super.minus(r5);
    }

    @Override // org.threeten.bp.chrono.b
    /* JADX INFO: renamed from: plus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1649plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public MinguoDate with(org.threeten.bp.temporal.e r5) {
        return (MinguoDate) super.with(r5);
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public MinguoDate minus(long r5, org.threeten.bp.temporal.j r10) {
        return (MinguoDate) super.minus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public MinguoDate plus(org.threeten.bp.temporal.f r5) {
        return (MinguoDate) super.plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public MinguoDate with(org.threeten.bp.temporal.g r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L33;
        ChronoField r5 = (ChronoField) r10;
        if (getLong(r5) != r11) goto L7;
        return this;
    L7:
        int[] r12 = o.f21181a;
        int r13 = r12[r5.ordinal()];
        if (r13 != 4) goto L10;
    L16:
        int r14 = getChronology().range(r5).checkValidIntValue(r11, r5);
        int r15 = r12[r5.ordinal()];
        if (r15 == 4) goto L26;
        if (r15 == 6) goto L25;
        if (r15 == 7) goto L23;
    L21:
        return b(this.isoDate.with(r10, r11));
    L23:
        return b(this.isoDate.withYear(1912 - a()));
    L25:
        return b(this.isoDate.withYear(r14 + 1911));
    L26:
        LocalDate r16 = this.isoDate;
        if (a() < 1) goto L29;
        int r17 = r14 + 1911;
    L31:
        return b(r16.withYear(r17));
    L29:
        r17 = 1912 - r14;
        goto L31
    L10:
        if (r13 == 5) goto L14;
        if (r13 == 6) goto L16;
        if (r13 == 7) goto L16;
    L14:
        getChronology().range(r5).checkValidValue(r11, r5);
        return plusMonths(r11 - (((((long) a()) * 12) + ((long) this.isoDate.getMonthValue())) - 1));
    L33:
        return (MinguoDate) r10.adjustInto(this, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public MinguoDate plus(long r5, org.threeten.bp.temporal.j r10) {
        return (MinguoDate) super.plus(r5, r10);
    }
}
