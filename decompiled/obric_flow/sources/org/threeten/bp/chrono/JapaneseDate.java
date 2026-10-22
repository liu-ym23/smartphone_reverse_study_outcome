package org.threeten.bp.chrono;

import ai.j0;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> implements Serializable {
    static final LocalDate MIN_DATE = null;
    private static final long serialVersionUID = -305327627230580483L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient JapaneseEra f21160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f21161c;
    private final LocalDate isoDate;

    static {
        MIN_DATE = LocalDate.of(1873, 1, 1);
    }

    public JapaneseDate(LocalDate r5) {
        if (r5.isBefore(MIN_DATE) == true) goto L7;
        JapaneseEra r10 = JapaneseEra.from(r5);
        this.f21160b = r10;
        this.f21161c = r5.getYear() - (r10.startDate().getYear() - 1);
        this.isoDate = r5;
        return;
    L7:
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    public static JapaneseDate from(org.threeten.bp.temporal.d r5) {
        return JapaneseChronology.INSTANCE.date(r5);
    }

    public static JapaneseDate now() {
        return now(org.threeten.bp.a.systemDefaultZone());
    }

    public static JapaneseDate of(JapaneseEra r5, int r10, int r11, int r12) {
        jm.c.p(r5, "era");
        if (r10 < 1) goto L13;
        LocalDate r13 = r5.startDate();
        LocalDate r14 = r5.endDate();
        LocalDate r15 = LocalDate.of((r13.getYear() - 1) + r10, r11, r12);
        if (r15.isBefore(r13) == true) goto L11;
        if (r15.isAfter(r14) == true) goto L11;
        return new JapaneseDate(r5, r10, r15);
    L11:
        throw new DateTimeException("Requested date is outside bounds of era " + r5);
    L13:
        throw new DateTimeException(j0.g(r10, "Invalid YearOfEra: "));
    }

    public static JapaneseDate ofYearDay(JapaneseEra r5, int r10, int r11) {
        jm.c.p(r5, "era");
        if (r10 < 1) goto L20;
        LocalDate r12 = r5.startDate();
        LocalDate r13 = r5.endDate();
        if (r10 != 1) goto L11;
        r11 = r11 + (r12.getDayOfYear() - 1);
        if (r11 <= r12.lengthOfYear()) goto L11;
        throw new DateTimeException("DayOfYear exceeds maximum allowed in the first year of era " + r5);
    L11:
        LocalDate r14 = LocalDate.ofYearDay((r12.getYear() - 1) + r10, r11);
        if (r14.isBefore(r12) == true) goto L18;
        if (r14.isAfter(r13) == true) goto L18;
        return new JapaneseDate(r5, r10, r14);
    L18:
        throw new DateTimeException("Requested date is outside bounds of era " + r5);
    L20:
        throw new DateTimeException(j0.g(r10, "Invalid YearOfEra: "));
    }

    public static b readExternal(DataInput r5) throws IOException {
        int r10 = r5.readInt();
        byte r11 = r5.readByte();
        byte r12 = r5.readByte();
        return JapaneseChronology.INSTANCE.date(r10, r11, r12);
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        JapaneseEra r10 = JapaneseEra.from(this.isoDate);
        this.f21160b = r10;
        this.f21161c = this.isoDate.getYear() - (r10.startDate().getYear() - 1);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public final ValueRange a(int r5) {
        Calendar r10 = Calendar.getInstance(JapaneseChronology.LOCALE);
        r10.set(0, this.f21160b.getValue() + 2);
        r10.set(this.f21161c, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return ValueRange.of(r10.getActualMinimum(r5), r10.getActualMaximum(r5));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b
    public final c atTime(LocalTime r5) {
        return super.atTime(r5);
    }

    public final long b() {
        if (this.f21161c != 1) goto L7;
        return (this.isoDate.getDayOfYear() - this.f21160b.startDate().getDayOfYear()) + 1;
    L7:
        return this.isoDate.getDayOfYear();
    }

    public final JapaneseDate c(LocalDate r5) {
        if (r5.equals(this.isoDate) == false) goto L6;
        return this;
    L6:
        return new JapaneseDate(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JapaneseDate) == true) goto L8;
        return false;
    L8:
        return this.isoDate.equals(((JapaneseDate) r5).isoDate);
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
        if ((r5 instanceof ChronoField) == false) goto L17;
        switch(m.f21179a[((ChronoField) r5).ordinal()]) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        return this.isoDate.getLong(r5);
    L9:
        return this.f21160b.getValue();
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L13:
        return this.f21161c;
    L15:
        return b();
    L17:
        return r5.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.b
    public int hashCode() {
        int r5 = getChronology().getId().hashCode();
        return this.isoDate.hashCode() ^ r5;
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) goto L5;
        return false;
    L5:
        if (r5 != ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) goto L7;
        return false;
    L7:
        if (r5 != ChronoField.ALIGNED_WEEK_OF_MONTH) goto L9;
        return false;
    L9:
        if (r5 != ChronoField.ALIGNED_WEEK_OF_YEAR) goto L12;
        return false;
    L12:
        return super.isSupported(r5);
    }

    @Override // org.threeten.bp.chrono.b
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // org.threeten.bp.chrono.b
    public int lengthOfYear() {
        Calendar r5 = Calendar.getInstance(JapaneseChronology.LOCALE);
        r5.set(0, this.f21160b.getValue() + 2);
        r5.set(this.f21161c, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return r5.getActualMaximum(6);
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
        if ((r5 instanceof ChronoField) == false) goto L19;
        if (isSupported(r5) == false) goto L17;
        ChronoField r10 = (ChronoField) r5;
        int r11 = m.f21179a[r10.ordinal()];
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L13;
        return getChronology().range(r10);
    L13:
        return a(1);
    L15:
        return a(6);
    L17:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L19:
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

    public static JapaneseDate now(ZoneId r5) {
        return now(org.threeten.bp.a.system(r5));
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseChronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseEra getEra() {
        return this.f21160b;
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
    public JapaneseDate plusDays(long r5) {
        return c(this.isoDate.plusDays(r5));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public JapaneseDate plusMonths(long r5) {
        return c(this.isoDate.plusMonths(r5));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public JapaneseDate plusYears(long r5) {
        return c(this.isoDate.plusYears(r5));
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

    public static JapaneseDate now(org.threeten.bp.a r5) {
        return new JapaneseDate(LocalDate.now(r5));
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
    public JapaneseDate minus(org.threeten.bp.temporal.f r5) {
        return (JapaneseDate) super.minus(r5);
    }

    @Override // org.threeten.bp.chrono.b
    /* JADX INFO: renamed from: plus */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c mo1649plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public JapaneseDate with(org.threeten.bp.temporal.e r5) {
        return (JapaneseDate) super.with(r5);
    }

    @Override // org.threeten.bp.chrono.b, fv.b, org.threeten.bp.temporal.c
    public JapaneseDate minus(long r5, org.threeten.bp.temporal.j r10) {
        return (JapaneseDate) super.minus(r5, r10);
    }

    @Override // org.threeten.bp.chrono.b
    public JapaneseDate plus(org.threeten.bp.temporal.f r5) {
        return (JapaneseDate) super.plus(r5);
    }

    @Override // org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public JapaneseDate with(org.threeten.bp.temporal.g r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L25;
        ChronoField r5 = (ChronoField) r10;
        if (getLong(r5) != r11) goto L7;
        return this;
    L7:
        int[] r12 = m.f21179a;
        int r13 = r12[r5.ordinal()];
        if (r13 == 1) goto L12;
        if (r13 == 2) goto L12;
        if (r13 == 7) goto L12;
    L17:
        return c(this.isoDate.with(r10, r11));
    L12:
        int r14 = getChronology().range(r5).checkValidIntValue(r11, r5);
        int r15 = r12[r5.ordinal()];
        if (r15 == 1) goto L23;
        if (r15 == 2) goto L20;
        if (r15 != 7) goto L17;
        JapaneseEra r16 = JapaneseEra.of(r14);
        int r17 = this.f21161c;
        int r18 = JapaneseChronology.INSTANCE.prolepticYear(r16, r17);
        return c(this.isoDate.withYear(r18));
    L20:
        JapaneseEra r19 = getEra();
        int r20 = JapaneseChronology.INSTANCE.prolepticYear(r19, r14);
        return c(this.isoDate.withYear(r20));
    L23:
        return c(this.isoDate.plusDays(((long) r14) - b()));
    L25:
        return (JapaneseDate) r10.adjustInto(this, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.b, org.threeten.bp.temporal.c
    public JapaneseDate plus(long r5, org.threeten.bp.temporal.j r10) {
        return (JapaneseDate) super.plus(r5, r10);
    }

    public JapaneseDate(JapaneseEra r5, int r10, LocalDate r11) {
        if (r11.isBefore(MIN_DATE) == true) goto L7;
        this.f21160b = r5;
        this.f21161c = r10;
        this.isoDate = r11;
        return;
    L7:
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    public static JapaneseDate of(int r5, int r10, int r11) {
        return new JapaneseDate(LocalDate.of(r5, r10, r11));
    }
}
