package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.format.s;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class Year extends fv.c implements org.threeten.bp.temporal.c, org.threeten.bp.temporal.e, Comparable<Year>, Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final int MAX_VALUE = 999999999;
    public static final int MIN_VALUE = -999999999;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final org.threeten.bp.format.b f21127a = null;
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;

    static {
        FROM = new r9.c(14);
        s r5 = new s();
        r5.m(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD);
        f21127a = r5.p();
    }

    public Year(int r5) {
        this.year = r5;
    }

    public static Year from(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof Year) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(org.threeten.bp.chrono.i.from(r5)) == true) goto L9;
        r5 = LocalDate.from(r5);     // Catch: DateTimeException -> L11
    L9:
        return of(r5.get(ChronoField.YEAR));
    L12:
        throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    L5:
        return (Year) r5;
    }

    public static boolean isLeap(long r5) {
        if ((3 & r5) == 0) goto L5;
    L9:
        return false;
    L5:
        if ((r5 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r5 % 400) != 0) goto L9;
        goto L8
    }

    public static Year now() {
        return now(a.systemDefaultZone());
    }

    public static Year of(int r5) {
        ChronoField.YEAR.checkValidValue(r5);
        return new Year(r5);
    }

    public static Year parse(CharSequence r5) {
        return parse(r5, f21127a);
    }

    public static Year readExternal(DataInput r5) throws IOException {
        return of(r5.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        if (org.threeten.bp.chrono.i.from(r5).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r5.with(ChronoField.YEAR, this.year);
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int r5) {
        return LocalDate.ofYearDay(this.year, r5);
    }

    public YearMonth atMonth(Month r5) {
        return YearMonth.of(this.year, r5);
    }

    public LocalDate atMonthDay(MonthDay r5) {
        return r5.atYear(this.year);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Year r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Year) == true) goto L8;
        return false;
    L8:
        if (this.year != ((Year) r5).year) goto L11;
        return true;
    L11:
        return false;
    }

    public String format(org.threeten.bp.format.b r5) {
        jm.c.p(r5, "formatter");
        return r5.a(this);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L25;
        int r10 = k.f21266a[((ChronoField) r5).ordinal()];
        int r11 = 1;
        if (r10 != 1) goto L7;
        int r12 = this.year;
        if (r12 >= 1) goto L23;
        r12 = 1 - r12;
    L23:
        return r12;
    L7:
        if (r10 == 2) goto L18;
        if (r10 != 3) goto L16;
        if (this.year >= 1) goto L14;
        r11 = 0;
    L14:
        return r11;
    L16:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L18:
        return this.year;
    L25:
        return r5.getFrom(this);
    }

    public int getValue() {
        return this.year;
    }

    public int hashCode() {
        return this.year;
    }

    public boolean isAfter(Year r5) {
        if (this.year <= r5.year) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Year r5) {
        if (this.year >= r5.year) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 == null) goto L18;
        if (r5.isSupportedBy(this) == false) goto L18;
        return true;
    L18:
        return false;
    L5:
        if (r5 != ChronoField.YEAR) goto L7;
        return true;
    L7:
        if (r5 != ChronoField.YEAR_OF_ERA) goto L9;
        return true;
    L9:
        if (r5 != ChronoField.ERA) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isValidMonthDay(MonthDay r5) {
        if (r5 != null) goto L4;
    L6:
        return false;
    L4:
        if (r5.isValidYear(this.year) == false) goto L6;
        return true;
    }

    public int length() {
        if (isLeap() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public Year minusYears(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Year this = plusYears(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusYears(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c plus(long r5, org.threeten.bp.temporal.j r10) {
        return plus(r5, r10);
    }

    public Year plusYears(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return of(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r5));
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L11;
        return (R) ChronoUnit.YEARS;
    L11:
        if (r5 != org.threeten.bp.temporal.h.f) goto L13;
        return null;
    L13:
        if (r5 != org.threeten.bp.temporal.h.g) goto L15;
        return null;
    L15:
        if (r5 != org.threeten.bp.temporal.h.d) goto L17;
        return null;
    L17:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L19;
        return null;
    L19:
        if (r5 != org.threeten.bp.temporal.h.e) goto L22;
        return null;
    L22:
        return (R) super.query(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.YEAR_OF_ERA) goto L11;
        if (this.year > 0) goto L8;
        long r10 = 1000000000;
    L9:
        return ValueRange.of(1, r10);
    L8:
        r10 = 999999999;
        goto L9
    L11:
        return super.range(r5);
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        Year r11 = from(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L25;
        long r12 = ((long) r11.year) - ((long) this.year);
        int r13 = k.f21267b[((ChronoUnit) r10).ordinal()];
        if (r13 != 1) goto L7;
        return r12;
    L7:
        if (r13 == 2) goto L23;
        if (r13 == 3) goto L21;
        if (r13 == 4) goto L19;
        if (r13 != 5) goto L17;
        ChronoField r14 = ChronoField.ERA;
        return r11.getLong(r14) - getLong(r14);
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L19:
        return r12 / 1000;
    L21:
        return r12 / 100;
    L23:
        return r12 / 10;
    L25:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeInt(this.year);
    }

    public static Year now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static Year parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (Year) r10.c(r5, FROM);
    }

    public YearMonth atMonth(int r5) {
        return YearMonth.of(this.year, r5);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Year r5) {
        return this.year - r5.year;
    }

    public boolean isLeap() {
        return isLeap(this.year);
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1661minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1662plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static Year now(a r5) {
        return of(LocalDate.now(r5).getYear());
    }

    public Year minus(org.threeten.bp.temporal.f r5) {
        return (Year) r5.subtractFrom(this);
    }

    public Year plus(org.threeten.bp.temporal.f r5) {
        return (Year) r5.addTo(this);
    }

    @Override // org.threeten.bp.temporal.c
    public Year with(org.threeten.bp.temporal.e r5) {
        return (Year) r5.adjustInto(this);
    }

    public boolean isSupported(org.threeten.bp.temporal.j r5) {
        if ((r5 instanceof ChronoUnit) == true) goto L5;
        if (r5 == null) goto L22;
        if (r5.isSupportedBy(this) == false) goto L22;
        return true;
    L22:
        return false;
    L5:
        if (r5 != ChronoUnit.YEARS) goto L7;
        return true;
    L7:
        if (r5 != ChronoUnit.DECADES) goto L9;
        return true;
    L9:
        if (r5 != ChronoUnit.CENTURIES) goto L11;
        return true;
    L11:
        if (r5 != ChronoUnit.MILLENNIA) goto L13;
        return true;
    L13:
        if (r5 != ChronoUnit.ERAS) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // org.threeten.bp.temporal.c
    public Year minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        Year this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public Year plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L27;
        int r11 = k.f21267b[((ChronoUnit) r10).ordinal()];
        if (r11 == 1) goto L25;
        if (r11 == 2) goto L23;
        if (r11 == 3) goto L21;
        if (r11 == 4) goto L19;
        if (r11 != 5) goto L17;
        ChronoField r12 = ChronoField.ERA;
        return with(r12, jm.c.r(getLong(r12), r5));
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L19:
        return plusYears(jm.c.t(1000, r5));
    L21:
        return plusYears(jm.c.t(100, r5));
    L23:
        return plusYears(jm.c.t(10, r5));
    L25:
        return plusYears(r5);
    L27:
        return (Year) r10.addTo(this, r5);
    }

    @Override // org.threeten.bp.temporal.c
    public Year with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L25;
        ChronoField r11 = (ChronoField) r5;
        r11.checkValidValue(r10);
        int r12 = k.f21266a[r11.ordinal()];
        if (r12 == 1) goto L20;
        if (r12 == 2) goto L18;
        if (r12 != 3) goto L16;
        if (getLong(ChronoField.ERA) != r10) goto L14;
        return this;
    L14:
        return of(1 - this.year);
    L16:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L18:
        return of((int) r10);
    L20:
        if (this.year >= 1) goto L23;
        r10 = 1 - r10;
    L23:
        return of((int) r10);
    L25:
        return (Year) r5.adjustInto(this, r10);
    }
}
