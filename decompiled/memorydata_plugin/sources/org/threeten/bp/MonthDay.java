package org.threeten.bp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
public final class MonthDay extends DefaultInterfaceTemporalAccessor implements Serializable, Comparable<MonthDay>, TemporalAccessor, TemporalAdjuster {
    public static final TemporalQuery<MonthDay> FROM = null;
    private static final DateTimeFormatter PARSER = null;
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    /* JADX INFO: renamed from: org.threeten.bp.MonthDay$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        FROM = new AnonymousClass1();
        PARSER = new DateTimeFormatterBuilder().appendLiteral("--").appendValue(ChronoField.MONTH_OF_YEAR, 2).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH, 2).toFormatter();
    }

    private MonthDay(int r1, int r2) {
        this.month = r1;
        this.day = r2;
    }

    public static MonthDay from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, MonthDay.class) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(Chronology.from(r4)) == true) goto L9;
        r4 = LocalDate.from(r4);     // Catch: DateTimeException -> L11
    L9:
        return of(r4.get(ChronoField.MONTH_OF_YEAR), r4.get(ChronoField.DAY_OF_MONTH));
    L12:
        throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + r4 + ", type " + r4.getClass().getName());
    L5:
        return (MonthDay) ZeusTransformUtils.preCheckCast(r4, MonthDay.class, "com.obric.memorydata.plugin");
    }

    public static MonthDay now() {
        return now(Clock.systemDefaultZone());
    }

    public static MonthDay now(Clock r1) {
        LocalDate r2 = LocalDate.now(r1);
        return of(r2.getMonth(), r2.getDayOfMonth());
    }

    public static MonthDay now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static MonthDay of(int r0, int r1) {
        return of(Month.of(r0), r1);
    }

    public static MonthDay of(Month r3, int r4) {
        Jdk8Methods.requireNonNull(r3, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(r4);
        if (r4 > r3.maxLength()) goto L7;
        return new MonthDay(r3.getValue(), r4);
    L7:
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + r4 + " is not valid for month " + r3.name());
    }

    public static MonthDay parse(CharSequence r2) {
        return parse((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), PARSER);
    }

    public static MonthDay parse(CharSequence r2, DateTimeFormatter r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r3, "formatter");
        return (MonthDay) ZeusTransformUtils.preCheckCast(r3.parse(r4, FROM), MonthDay.class, "com.obric.memorydata.plugin");
    }

    static MonthDay readExternal(DataInput r2) {
        DataInput r3 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.memorydata.plugin");
        return of(r3.readByte(), r3.readByte());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 64, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r6) {
        Temporal r7 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r6, Temporal.class, "com.obric.memorydata.plugin");
        if (Chronology.from(r7).equals(IsoChronology.INSTANCE) == false) goto L7;
        Temporal r8 = r7.with(ChronoField.MONTH_OF_YEAR, this.month);
        return r8.with(ChronoField.DAY_OF_MONTH, Math.min(r8.range(ChronoField.DAY_OF_MONTH).getMaximum(), this.day));
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atYear(int r3) {
        int r0 = this.month;
        if (isValidYear(r3) == false) goto L5;
        int r2 = this.day;
    L7:
        return LocalDate.of(r3, r0, r2);
    L5:
        r2 = 28;
        goto L7
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(MonthDay r3) {
        return compareTo2((MonthDay) ZeusTransformUtils.preCheckCast(r3, MonthDay.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MonthDay r3) {
        int r0 = this.month - r3.month;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return this.day - r3.day;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MonthDay.class) == false) goto L14;
        MonthDay r6 = (MonthDay) ZeusTransformUtils.preCheckCast(r5, MonthDay.class, "com.obric.memorydata.plugin");
        if (this.month != r6.month) goto L13;
        if (this.day != r6.day) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String format(DateTimeFormatter r2) {
        Jdk8Methods.requireNonNull(r2, "formatter");
        return r2.format(this);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L15;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r0 != 1) goto L7;
        int r3 = this.day;
    L10:
        return r3;
    L7:
        if (r0 != 2) goto L12;
        r3 = this.month;
        goto L10
    L12:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
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

    public boolean isAfter(MonthDay r1) {
        if (compareTo2(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(MonthDay r1) {
        if (compareTo2(r1) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == true) goto L5;
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

    public boolean isValidYear(int r4) {
        if (this.day == 29) goto L5;
    L9:
        boolean r3 = false;
    L11:
        return !r3;
    L5:
        if (this.month != 2) goto L9;
        if (Year.isLeap(r4) == true) goto L9;
        r3 = true;
        goto L11
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<R> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.chronology()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        return (R) super.query(r4);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r8) {
        TemporalField r9 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r8, TemporalField.class, "com.obric.memorydata.plugin");
        if (r9 != ChronoField.MONTH_OF_YEAR) goto L7;
        return r9.range();
    L7:
        if (r9 != ChronoField.DAY_OF_MONTH) goto L11;
        return ValueRange.of(1, getMonth().minLength(), getMonth().maxLength());
    L11:
        return super.range(r9);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(10).append("--");
        if (this.month >= 10) goto L5;
        String r2 = "0";
    L6:
        StringBuilder r1 = r0.append(r2).append(this.month);
        if (this.day >= 10) goto L9;
        String r3 = "-0";
    L11:
        return r1.append(r3).append(this.day).toString();
    L9:
        r3 = "-";
        goto L11
    L5:
        r2 = "";
        goto L6
    }

    public MonthDay with(Month r3) {
        Jdk8Methods.requireNonNull(r3, "month");
        if (r3.getValue() != this.month) goto L5;
        return this;
    L5:
        int r2 = Math.min(this.day, r3.maxLength());
        return new MonthDay(r3.getValue(), r2);
    }

    public MonthDay withDayOfMonth(int r2) {
        if (r2 != this.day) goto L6;
        return this;
    L6:
        return of(this.month, r2);
    }

    public MonthDay withMonth(int r1) {
        return with(Month.of(r1));
    }

    void writeExternal(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin");
        r4.writeByte(this.month);
        r4.writeByte(this.day);
    }
}
