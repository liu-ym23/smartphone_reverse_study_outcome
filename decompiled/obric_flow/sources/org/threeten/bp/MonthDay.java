package org.threeten.bp;

import ai.j0;
import androidx.room.writer.DaoWriter;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.s;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final class MonthDay extends fv.c implements org.threeten.bp.temporal.e, Comparable<MonthDay>, Serializable {
    public static final org.threeten.bp.temporal.i FROM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final org.threeten.bp.format.b f21124a = null;
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    static {
        FROM = new f9.a(14);
        s r5 = new s();
        r5.d("--");
        r5.l(ChronoField.MONTH_OF_YEAR, 2);
        r5.c('-');
        r5.l(ChronoField.DAY_OF_MONTH, 2);
        f21124a = r5.p();
    }

    public MonthDay(int r5, int r10) {
        this.month = r5;
        this.day = r10;
    }

    public static MonthDay from(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof MonthDay) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(org.threeten.bp.chrono.i.from(r5)) == true) goto L9;
        r5 = LocalDate.from(r5);     // Catch: DateTimeException -> L11
    L9:
        return of(r5.get(ChronoField.MONTH_OF_YEAR), r5.get(ChronoField.DAY_OF_MONTH));
    L12:
        throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName());
    L5:
        return (MonthDay) r5;
    }

    public static MonthDay now() {
        return now(a.systemDefaultZone());
    }

    public static MonthDay of(Month r5, int r10) {
        jm.c.p(r5, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(r10);
        if (r10 <= r5.maxLength()) goto L5;
        StringBuilder r11 = j0.s(r10, "Illegal value for DayOfMonth field, value ", " is not valid for month ");
        r11.append(r5.name());
        throw new DateTimeException(r11.toString());
    L5:
        return new MonthDay(r5.getValue(), r10);
    }

    public static MonthDay parse(CharSequence r5) {
        return parse(r5, f21124a);
    }

    public static MonthDay readExternal(DataInput r5) throws IOException {
        return of(r5.readByte(), r5.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 64, this);
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r10) {
        if (org.threeten.bp.chrono.i.from(r10).equals(IsoChronology.INSTANCE) == false) goto L7;
        org.threeten.bp.temporal.c r11 = r10.with(ChronoField.MONTH_OF_YEAR, this.month);
        ChronoField r5 = ChronoField.DAY_OF_MONTH;
        return r11.with(r5, Math.min(r11.range(r5).getMaximum(), this.day));
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atYear(int r5) {
        int r10 = this.month;
        if (isValidYear(r5) == false) goto L5;
        int r11 = this.day;
    L7:
        return LocalDate.of(r5, r10, r11);
    L5:
        r11 = 28;
        goto L7
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MonthDay r5) {
        return compareTo2(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MonthDay) == false) goto L14;
        MonthDay r10 = (MonthDay) r5;
        if (this.month != r10.month) goto L13;
        if (this.day != r10.day) goto L13;
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

    public int getDayOfMonth() {
        return this.day;
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == false) goto L15;
        int r10 = h.f21263a[((ChronoField) r5).ordinal()];
        if (r10 != 1) goto L7;
        int r11 = this.day;
    L10:
        return r11;
    L7:
        if (r10 != 2) goto L12;
        r11 = this.month;
        goto L10
    L12:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    L15:
        return r5.getFrom(this);
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    public boolean isAfter(MonthDay r5) {
        if (compareTo2(r5) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(MonthDay r5) {
        if (compareTo2(r5) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 == null) goto L16;
        if (r5.isSupportedBy(this) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (r5 != ChronoField.MONTH_OF_YEAR) goto L7;
        return true;
    L7:
        if (r5 != ChronoField.DAY_OF_MONTH) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isValidYear(int r5) {
        if (this.day == 29) goto L5;
    L9:
        boolean r10 = false;
    L11:
        return !r10;
    L5:
        if (this.month != 2) goto L9;
        if (Year.isLeap(r5) == true) goto L9;
        r10 = true;
        goto L11
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        return (R) super.query(r5);
    }

    @Override // fv.c, org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r10) {
        if (r10 != ChronoField.MONTH_OF_YEAR) goto L7;
        return r10.range();
    L7:
        if (r10 != ChronoField.DAY_OF_MONTH) goto L11;
        return ValueRange.of(1, getMonth().minLength(), getMonth().maxLength());
    L11:
        return super.range(r10);
    }

    public String toString() {
        StringBuilder r5 = androidx.constraintlayout.motion.widget.a.x(10, "--");
        if (this.month >= 10) goto L5;
        String r10 = "0";
    L6:
        r5.append(r10);
        r5.append(this.month);
        if (this.day >= 10) goto L9;
        String r11 = "-0";
    L10:
        r5.append(r11);
        r5.append(this.day);
        return r5.toString();
    L9:
        r11 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
        goto L10
    L5:
        r10 = "";
        goto L6
    }

    public MonthDay with(Month r5) {
        jm.c.p(r5, "month");
        if (r5.getValue() != this.month) goto L5;
        return this;
    L5:
        int r10 = Math.min(this.day, r5.maxLength());
        return new MonthDay(r5.getValue(), r10);
    }

    public MonthDay withDayOfMonth(int r5) {
        if (r5 != this.day) goto L6;
        return this;
    L6:
        return of(this.month, r5);
    }

    public MonthDay withMonth(int r5) {
        return with(Month.of(r5));
    }

    public void writeExternal(DataOutput r5) throws IOException {
        r5.writeByte(this.month);
        r5.writeByte(this.day);
    }

    public static MonthDay now(ZoneId r5) {
        return now(a.system(r5));
    }

    public static MonthDay parse(CharSequence r5, org.threeten.bp.format.b r10) {
        jm.c.p(r10, "formatter");
        return (MonthDay) r10.c(r5, FROM);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MonthDay r5) {
        int r10 = this.month - r5.month;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        return this.day - r5.day;
    }

    public static MonthDay now(a r5) {
        LocalDate r10 = LocalDate.now(r5);
        return of(r10.getMonth(), r10.getDayOfMonth());
    }

    public static MonthDay of(int r5, int r10) {
        return of(Month.of(r5), r10);
    }
}
