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
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
public final class Year extends DefaultInterfaceTemporalAccessor implements Serializable, Comparable<Year>, Temporal, TemporalAdjuster {
    public static final TemporalQuery<Year> FROM = null;
    public static final int MAX_VALUE = 999999999;
    public static final int MIN_VALUE = -999999999;
    private static final DateTimeFormatter PARSER = null;
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;

    /* JADX INFO: renamed from: org.threeten.bp.Year$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.YEARS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L23:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L37:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L25:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L10:
            int[] r3 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r3;
            r3[ChronoField.YEAR_OF_ERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L35:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
            return;
        }
    }

    static {
        FROM = new AnonymousClass1();
        PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
    }

    private Year(int r1) {
        this.year = r1;
    }

    public static Year from(TemporalAccessor r3) {
        TemporalAccessor r4 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Year.class) == true) goto L5;
        if (IsoChronology.INSTANCE.equals(Chronology.from(r4)) == true) goto L9;
        r4 = LocalDate.from(r4);     // Catch: DateTimeException -> L11
    L9:
        return of(r4.get(ChronoField.YEAR));
    L12:
        throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + r4 + ", type " + r4.getClass().getName());
    L5:
        return (Year) ZeusTransformUtils.preCheckCast(r4, Year.class, "com.obric.memorydata.plugin");
    }

    public static boolean isLeap(long r4) {
        if ((3 & r4) == 0) goto L5;
    L9:
        return false;
    L5:
        if ((r4 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r4 % 400) != 0) goto L9;
        goto L8
    }

    public static Year now() {
        return now(Clock.systemDefaultZone());
    }

    public static Year now(Clock r0) {
        return of(LocalDate.now(r0).getYear());
    }

    public static Year now(ZoneId r0) {
        return now(Clock.system(r0));
    }

    public static Year of(int r3) {
        ChronoField.YEAR.checkValidValue(r3);
        return new Year(r3);
    }

    public static Year parse(CharSequence r2) {
        return parse((CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin"), PARSER);
    }

    public static Year parse(CharSequence r2, DateTimeFormatter r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        Jdk8Methods.requireNonNull(r3, "formatter");
        return (Year) ZeusTransformUtils.preCheckCast(r3.parse(r4, FROM), Year.class, "com.obric.memorydata.plugin");
    }

    static Year readExternal(DataInput r2) {
        return of(((DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.memorydata.plugin")).readInt());
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin");
        if (Chronology.from(r5).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r5.with(ChronoField.YEAR, this.year);
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int r1) {
        return LocalDate.ofYearDay(this.year, r1);
    }

    public YearMonth atMonth(int r1) {
        return YearMonth.of(this.year, r1);
    }

    public YearMonth atMonth(Month r1) {
        return YearMonth.of(this.year, r1);
    }

    public LocalDate atMonthDay(MonthDay r1) {
        return r1.atYear(this.year);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Year r3) {
        return compareTo2((Year) ZeusTransformUtils.preCheckCast(r3, Year.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Year r1) {
        return this.year - r1.year;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Year.class) == true) goto L8;
        return false;
    L8:
        if (this.year != ((Year) ZeusTransformUtils.preCheckCast(r5, Year.class, "com.obric.memorydata.plugin")).year) goto L11;
        return true;
    L11:
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

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == false) goto L25;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[((ChronoField) ZeusTransformUtils.preCheckCast(r5, ChronoField.class, "com.obric.memorydata.plugin")).ordinal()];
        int r1 = 1;
        if (r0 != 1) goto L7;
        int r3 = this.year;
        if (r3 >= 1) goto L23;
        r3 = 1 - r3;
    L23:
        return r3;
    L7:
        if (r0 == 2) goto L18;
        if (r0 != 3) goto L16;
        if (this.year >= 1) goto L14;
        r1 = 0;
    L14:
        return r1;
    L16:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r5);
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

    public boolean isAfter(Year r1) {
        if (this.year <= r1.year) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(Year r1) {
        if (this.year >= r1.year) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLeap() {
        return isLeap(this.year);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == true) goto L5;
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

    public boolean isSupported(TemporalUnit r4) {
        TemporalUnit r5 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoUnit.class) == true) goto L5;
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

    public boolean isValidMonthDay(MonthDay r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.isValidYear(this.year) == false) goto L6;
        return true;
    }

    public int length() {
        if (isLeap() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year minus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (r3 != Long.MIN_VALUE) goto L5;
        Year this = plus(Long.MAX_VALUE, r6);
        long r4 = 1;
    L7:
        return this.plus(r4, r6);
    L5:
        r4 = -r3;
        goto L7
    }

    public Year minus(TemporalAmount r3) {
        return (Year) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).subtractFrom(this), Year.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal minus(long r3, TemporalUnit r5) {
        return minus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* synthetic */ Temporal m3219minus(TemporalAmount r3) {
        return minus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public Year minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        Year this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year plus(long r4, TemporalUnit r6) {
        TemporalUnit r7 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r6, TemporalUnit.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ChronoUnit.class) == false) goto L27;
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r7, ChronoUnit.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L21;
        if (r0 == 4) goto L19;
        if (r0 != 5) goto L17;
        return with(ChronoField.ERA, Jdk8Methods.safeAdd(getLong(ChronoField.ERA), r4));
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r7);
    L19:
        return plusYears(Jdk8Methods.safeMultiply(r4, 1000));
    L21:
        return plusYears(Jdk8Methods.safeMultiply(r4, 100));
    L23:
        return plusYears(Jdk8Methods.safeMultiply(r4, 10));
    L25:
        return plusYears(r4);
    L27:
        return (Year) ZeusTransformUtils.preCheckCast(r7.addTo(this, r4), Year.class, "com.obric.memorydata.plugin");
    }

    public Year plus(TemporalAmount r3) {
        return (Year) ZeusTransformUtils.preCheckCast(((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin")).addTo(this), Year.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* synthetic */ Temporal m3220plus(TemporalAmount r3) {
        return plus((TemporalAmount) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAmount.class, "com.obric.memorydata.plugin"));
    }

    public Year plusYears(long r4) {
        if (r4 != 0) goto L6;
        return this;
    L6:
        return of(ChronoField.YEAR.checkValidIntValue(((long) this.year) + r4));
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<R> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.chronology()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r4 != TemporalQueries.precision()) goto L11;
        return (R) ChronoUnit.YEARS;
    L11:
        if (r4 != TemporalQueries.localDate()) goto L13;
        return null;
    L13:
        if (r4 != TemporalQueries.localTime()) goto L15;
        return null;
    L15:
        if (r4 != TemporalQueries.zone()) goto L17;
        return null;
    L17:
        if (r4 != TemporalQueries.zoneId()) goto L19;
        return null;
    L19:
        if (r4 != TemporalQueries.offset()) goto L22;
        return null;
    L22:
        return (R) super.query(r4);
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (r4 != ChronoField.YEAR_OF_ERA) goto L11;
        if (this.year > 0) goto L7;
        long r2 = 1000000000;
    L9:
        return ValueRange.of(1, r2);
    L7:
        r2 = 999999999;
        goto L9
    L11:
        return super.range(r4);
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r7, TemporalUnit r8) {
        Temporal r9 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r7, Temporal.class, "com.obric.memorydata.plugin");
        TemporalUnit r10 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r8, TemporalUnit.class, "com.obric.memorydata.plugin");
        Year r11 = from(r9);
        if (ZeusTransformUtils.instanceOf(r10, ChronoUnit.class) == false) goto L25;
        long r2 = ((long) r11.year) - ((long) this.year);
        int r0 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r10, ChronoUnit.class, "com.obric.memorydata.plugin")).ordinal()];
        if (r0 != 1) goto L7;
        return r2;
    L7:
        if (r0 != 2) goto L9;
        long r6 = 10;
    L20:
        return r2 / r6;
    L9:
        if (r0 != 3) goto L11;
        r6 = 100;
        goto L20
    L11:
        if (r0 != 4) goto L13;
        r6 = 1000;
        goto L20
    L13:
        if (r0 != 5) goto L17;
        return r11.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
    L17:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    L25:
        return r10.between(this, r11);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalAdjuster r3) {
        return (Year) ZeusTransformUtils.preCheckCast(((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin")).adjustInto(this), Year.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public Year with(TemporalField r5, long r6) {
        TemporalField r7 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r5, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ChronoField.class) == false) goto L25;
        ChronoField r0 = (ChronoField) ZeusTransformUtils.preCheckCast(r7, ChronoField.class, "com.obric.memorydata.plugin");
        r0.checkValidValue(r6);
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$temporal$ChronoField[r0.ordinal()];
        if (r1 == 1) goto L20;
        if (r1 == 2) goto L18;
        if (r1 != 3) goto L16;
        if (getLong(ChronoField.ERA) != r6) goto L14;
        return this;
    L14:
        return of(1 - this.year);
    L16:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r7);
    L18:
        return of((int) r6);
    L20:
        if (this.year >= 1) goto L23;
        r6 = 1 - r6;
    L23:
        return of((int) r6);
    L25:
        return (Year) ZeusTransformUtils.preCheckCast(r7.adjustInto(this, r6), Year.class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalAdjuster r3) {
        return with((TemporalAdjuster) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAdjuster.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal with(TemporalField r3, long r4) {
        return with((TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin"), r4);
    }

    void writeExternal(DataOutput r3) {
        ((DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.memorydata.plugin")).writeInt(this.year);
    }
}
