package org.threeten.bp;

import androidx.room.writer.DaoWriter;
import com.bytedance.keva.KevaImpl;
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
public final class YearMonth extends fv.c implements org.threeten.bp.temporal.c, org.threeten.bp.temporal.e, Comparable<YearMonth>, Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final org.threeten.bp.format.b f21128a = null;
    private static final long serialVersionUID = 4183400860270640070L;
    private final int month;
    private final int year;

    static {
        FROM = new s6.b(14);
        s r5 = new s();
        r5.m(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD);
        r5.c('-');
        r5.l(ChronoField.MONTH_OF_YEAR, 2);
        f21128a = r5.p();
    }

    public YearMonth(int r5, int r10) {
        this.year = r5;
        this.month = r10;
    }

    public static YearMonth from(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof YearMonth) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(org.threeten.bp.chrono.i.from(r5)) == true) goto L9;
        r5 = LocalDate.from(r5);     // Catch: DateTimeException -> L11
    L9:
        return of(r5.get(ChronoField.YEAR), r5.get(ChronoField.MONTH_OF_YEAR));
    L12:
        throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    L5:
        return (YearMonth) r5;
    }

    public static YearMonth now() {
        return now(a.systemDefaultZone());
    }

    public static YearMonth of(int r5, Month r10) {
        jm.c.p(r10, "month");
        return of(r5, r10.getValue());
    }

    public static YearMonth parse(CharSequence r5) {
        return parse(r5, f21128a);
    }

    public static YearMonth readExternal(DataInput r5) throws IOException {
        return of(r5.readInt(), r5.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 68, this);
    }

    public final long a() {
        return (((long) this.year) * 12) + ((long) (this.month - 1));
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        if (org.threeten.bp.chrono.i.from(r5).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r5.with(ChronoField.PROLEPTIC_MONTH, a());
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int r5) {
        return LocalDate.of(this.year, this.month, r5);
    }

    public LocalDate atEndOfMonth() {
        return LocalDate.of(this.year, this.month, lengthOfMonth());
    }

    public final YearMonth b(int r5, int r10) {
        if (this.year != r5) goto L8;
        if (this.month != r10) goto L8;
        return this;
    L8:
        return new YearMonth(r5, r10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(YearMonth r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof YearMonth) == false) goto L14;
        YearMonth r10 = (YearMonth) r5;
        if (this.year != r10.year) goto L13;
        if (this.month != r10.month) goto L13;
        return true;
    L13:
        return false;
    L14:
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
        if ((r5 instanceof ChronoField) == false) goto L33;
        int r10 = l.f21268a[((ChronoField) r5).ordinal()];
        int r11 = 1;
        if (r10 != 1) goto L7;
        int r12 = this.month;
    L23:
        return r12;
    L7:
        if (r10 == 2) goto L30;
        if (r10 != 3) goto L11;
        int r13 = this.year;
        if (r13 >= 1) goto L28;
        r13 = 1 - r13;
    L28:
        return r13;
    L11:
        if (r10 != 4) goto L13;
        r12 = this.year;
        goto L23
    L13:
        if (r10 != 5) goto L20;
        if (this.year >= 1) goto L18;
        r11 = 0;
    L18:
        return r11;
    L20:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L30:
        return a();
    L33:
        return r5.getFrom(this);
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public int hashCode() {
        int r5 = this.year;
        return (this.month << 27) ^ r5;
    }

    public boolean isAfter(YearMonth r5) {
        if (compareTo2(r5) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(YearMonth r5) {
        if (compareTo2(r5) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 == null) goto L22;
        if (r5.isSupportedBy(this) == false) goto L22;
        return true;
    L22:
        return false;
    L5:
        if (r5 != ChronoField.YEAR) goto L7;
        return true;
    L7:
        if (r5 != ChronoField.MONTH_OF_YEAR) goto L9;
        return true;
    L9:
        if (r5 != ChronoField.PROLEPTIC_MONTH) goto L11;
        return true;
    L11:
        if (r5 != ChronoField.YEAR_OF_ERA) goto L13;
        return true;
    L13:
        if (r5 != ChronoField.ERA) goto L16;
        return true;
    L16:
        return false;
    }

    public boolean isValidDay(int r5) {
        if (r5 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r5 > lengthOfMonth()) goto L7;
        return true;
    }

    public int lengthOfMonth() {
        return getMonth().length(isLeapYear());
    }

    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c minus(long r5, org.threeten.bp.temporal.j r10) {
        return minus(r5, r10);
    }

    public YearMonth minusMonths(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        YearMonth this = plusMonths(Long.MAX_VALUE);
        long r10 = 1;
    L7:
        return this.plusMonths(r10);
    L6:
        r10 = -r5;
        goto L7
    }

    public YearMonth minusYears(long r5) {
        if (r5 != Long.MIN_VALUE) goto L6;
        YearMonth this = plusYears(Long.MAX_VALUE);
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

    public YearMonth plusMonths(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        long r5 = ((((long) this.year) * 12) + ((long) (this.month - 1))) + r10;
        return b(ChronoField.YEAR.checkValidIntValue(jm.c.l(r5, 12)), jm.c.n(12, r5) + 1);
    }

    public YearMonth plusYears(long r5) {
        if (r5 != 0) goto L6;
        return this;
    L6:
        return b(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r5), this.month);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L11;
        return (R) ChronoUnit.MONTHS;
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
        if (getYear() > 0) goto L8;
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
        int r5 = Math.abs(this.year);
        StringBuilder r10 = new StringBuilder(9);
        if (r5 >= 1000) goto L8;
        int r11 = this.year;
        if (r11 >= 0) goto L7;
        r10.append(r11 - 10000);
        r10.deleteCharAt(1);
    L10:
        if (this.month >= 10) goto L12;
        String r12 = "-0";
    L13:
        r10.append(r12);
        r10.append(this.month);
        return r10.toString();
    L12:
        r12 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        goto L13
    L7:
        r10.append(r11 + KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r10.deleteCharAt(0);
        goto L10
    L8:
        r10.append(this.year);
        goto L10
    }

    @Override // org.threeten.bp.temporal.c
    public long until(org.threeten.bp.temporal.c r5, org.threeten.bp.temporal.j r10) {
        YearMonth r11 = from(r5);
        if ((r10 instanceof ChronoUnit) == false) goto L19;
        long r12 = r11.a() - a();
        switch(l.f21269b[((ChronoUnit) r10).ordinal()]) {
            case 1: goto L20;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r13 = ChronoField.ERA;
        return r11.getLong(r13) - getLong(r13);
    L20:
        return r12;
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L11:
        return r12 / 12000;
    L13:
        return r12 / 1200;
    L15:
        return r12 / 120;
    L17:
        return r12 / 12;
    L19:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.e r5) {
        return with(r5);
    }

    public YearMonth withMonth(int r5) {
        ChronoField.MONTH_OF_YEAR.checkValidValue(r5);
        return b(this.year, r5);
    }

    public YearMonth withYear(int r5) {
        ChronoField.YEAR.checkValidValue(r5);
        return b(r5, this.month);
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeInt(this.year);
        r5.writeByte(this.month);
    }

    public static YearMonth now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static YearMonth parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (YearMonth) r10.c(r5, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(YearMonth r5) {
        int r10 = this.year - r5.year;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        return this.month - r5.month;
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1663minus(org.threeten.bp.temporal.f r5) {
        return minus(r5);
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c m1664plus(org.threeten.bp.temporal.f r5) {
        return plus(r5);
    }

    @Override // org.threeten.bp.temporal.c
    public /* bridge */ /* synthetic */ org.threeten.bp.temporal.c with(org.threeten.bp.temporal.g r5, long r10) {
        return with(r5, r10);
    }

    public static YearMonth now(a r5) {
        LocalDate r10 = LocalDate.now(r5);
        return of(r10.getYear(), r10.getMonth());
    }

    public static YearMonth of(int r5, int r10) {
        ChronoField.YEAR.checkValidValue(r5);
        ChronoField.MONTH_OF_YEAR.checkValidValue(r10);
        return new YearMonth(r5, r10);
    }

    public YearMonth minus(org.threeten.bp.temporal.f r5) {
        return (YearMonth) r5.subtractFrom(this);
    }

    public YearMonth plus(org.threeten.bp.temporal.f r5) {
        return (YearMonth) r5.addTo(this);
    }

    @Override // org.threeten.bp.temporal.c
    public YearMonth with(org.threeten.bp.temporal.e r5) {
        return (YearMonth) r5.adjustInto(this);
    }

    public boolean isSupported(org.threeten.bp.temporal.j r5) {
        if ((r5 instanceof ChronoUnit) == true) goto L5;
        if (r5 == null) goto L24;
        if (r5.isSupportedBy(this) == false) goto L24;
        return true;
    L24:
        return false;
    L5:
        if (r5 != ChronoUnit.MONTHS) goto L7;
        return true;
    L7:
        if (r5 != ChronoUnit.YEARS) goto L9;
        return true;
    L9:
        if (r5 != ChronoUnit.DECADES) goto L11;
        return true;
    L11:
        if (r5 != ChronoUnit.CENTURIES) goto L13;
        return true;
    L13:
        if (r5 != ChronoUnit.MILLENNIA) goto L15;
        return true;
    L15:
        if (r5 != ChronoUnit.ERAS) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // org.threeten.bp.temporal.c
    public YearMonth minus(long r5, org.threeten.bp.temporal.j r10) {
        if (r5 != Long.MIN_VALUE) goto L6;
        YearMonth this = plus(Long.MAX_VALUE, r10);
        long r11 = 1;
    L7:
        return this.plus(r11, r10);
    L6:
        r11 = -r5;
        goto L7
    }

    @Override // org.threeten.bp.temporal.c
    public YearMonth plus(long r5, org.threeten.bp.temporal.j r10) {
        if ((r10 instanceof ChronoUnit) == false) goto L21;
        switch(l.f21269b[((ChronoUnit) r10).ordinal()]) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        ChronoField r11 = ChronoField.ERA;
        return with(r11, jm.c.r(getLong(r11), r5));
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L11:
        return plusYears(jm.c.t(1000, r5));
    L13:
        return plusYears(jm.c.t(100, r5));
    L15:
        return plusYears(jm.c.t(10, r5));
    L17:
        return plusYears(r5);
    L19:
        return plusMonths(r5);
    L21:
        return (YearMonth) r10.addTo(this, r5);
    }

    @Override // org.threeten.bp.temporal.c
    public YearMonth with(org.threeten.bp.temporal.g r5, long r10) {
        if ((r5 instanceof ChronoField) == false) goto L33;
        ChronoField r11 = (ChronoField) r5;
        r11.checkValidValue(r10);
        int r12 = l.f21268a[r11.ordinal()];
        if (r12 == 1) goto L31;
        if (r12 == 2) goto L29;
        if (r12 == 3) goto L24;
        if (r12 == 4) goto L22;
        if (r12 != 5) goto L20;
        if (getLong(ChronoField.ERA) != r10) goto L18;
        return this;
    L18:
        return withYear(1 - this.year);
    L20:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L22:
        return withYear((int) r10);
    L24:
        if (this.year >= 1) goto L27;
        r10 = 1 - r10;
    L27:
        return withYear((int) r10);
    L29:
        return plusMonths(r10 - getLong(ChronoField.PROLEPTIC_MONTH));
    L31:
        return withMonth((int) r10);
    L33:
        return (YearMonth) r5.adjustInto(this, r10);
    }
}
