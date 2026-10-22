package org.threeten.bp;

import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes8.dex */
public final enum Month extends Enum<Month> implements TemporalAccessor, TemporalAdjuster {
    private static final /* synthetic */ Month[] $VALUES = null;
    public static final Month APRIL = null;
    public static final Month AUGUST = null;
    public static final Month DECEMBER = null;
    private static final Month[] ENUMS = null;
    public static final Month FEBRUARY = null;
    public static final TemporalQuery<Month> FROM = null;
    public static final Month JANUARY = null;
    public static final Month JULY = null;
    public static final Month JUNE = null;
    public static final Month MARCH = null;
    public static final Month MAY = null;
    public static final Month NOVEMBER = null;
    public static final Month OCTOBER = null;
    public static final Month SEPTEMBER = null;

    /* JADX INFO: renamed from: org.threeten.bp.Month$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$Month = null;

        static {
            int[] r0 = new int[Month.values().length];
            $SwitchMap$org$threeten$bp$Month = r0;
            r0[Month.FEBRUARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            $SwitchMap$org$threeten$bp$Month[Month.APRIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$org$threeten$bp$Month[Month.JUNE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            $SwitchMap$org$threeten$bp$Month[Month.SEPTEMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$org$threeten$bp$Month[Month.NOVEMBER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            $SwitchMap$org$threeten$bp$Month[Month.JANUARY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$org$threeten$bp$Month[Month.MARCH.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$org$threeten$bp$Month[Month.MAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            $SwitchMap$org$threeten$bp$Month[Month.JULY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            $SwitchMap$org$threeten$bp$Month[Month.AUGUST.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            $SwitchMap$org$threeten$bp$Month[Month.OCTOBER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$org$threeten$bp$Month[Month.DECEMBER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    static {
        Month r0 = new Month("JANUARY", 0);
        JANUARY = r0;
        Month r1 = new Month("FEBRUARY", 1);
        FEBRUARY = r1;
        Month r3 = new Month("MARCH", 2);
        MARCH = r3;
        Month r5 = new Month("APRIL", 3);
        APRIL = r5;
        Month r7 = new Month("MAY", 4);
        MAY = r7;
        Month r9 = new Month("JUNE", 5);
        JUNE = r9;
        Month r11 = new Month("JULY", 6);
        JULY = r11;
        Month r13 = new Month("AUGUST", 7);
        AUGUST = r13;
        Month r15 = new Month("SEPTEMBER", 8);
        SEPTEMBER = r15;
        Month r14 = new Month("OCTOBER", 9);
        OCTOBER = r14;
        Month r12 = new Month("NOVEMBER", 10);
        NOVEMBER = r12;
        Month r10 = new Month("DECEMBER", 11);
        DECEMBER = r10;
        $VALUES = new Month[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        FROM = new AnonymousClass1();
        ENUMS = values();
    }

    private Month(String r1, int r2) {
        super(r1, r2);
    }

    public static Month from(TemporalAccessor r4) {
        TemporalAccessor r5 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAccessor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Month.class) == true) goto L5;
    L11:
        e = move-exception;
        throw new DateTimeException("Unable to obtain Month from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName(), e);
    L7:
        if (IsoChronology.INSTANCE.equals(Chronology.from(r5)) == true) goto L9;
        r5 = LocalDate.from(r5);     // Catch: DateTimeException -> L11
    L9:
        return of(r5.get(ChronoField.MONTH_OF_YEAR));
    L5:
        return (Month) ZeusTransformUtils.preCheckCast(r5, Month.class, "com.obric.memorydata.plugin");
    }

    public static Month of(int r3) {
        if (r3 < 1) goto L9;
        if (r3 > 12) goto L9;
        return ENUMS[r3 - 1];
    L9:
        throw new DateTimeException("Invalid value for MonthOfYear: " + r3);
    }

    public static Month valueOf(String r2) {
        return (Month) ZeusTransformUtils.preCheckCast(Enum.valueOf(Month.class, r2), Month.class, "com.obric.memorydata.plugin");
    }

    public static Month[] values() {
        return (Month[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Month[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.memorydata.plugin");
        if (Chronology.from(r5).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r5.with(ChronoField.MONTH_OF_YEAR, getValue());
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public int firstDayOfYear(boolean r2) {
        switch(AnonymousClass2.$SwitchMap$org$threeten$bp$Month[ordinal()]) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L5;
        };
    L16:
        return 1;
    L26:
        return 32;
    L5:
        return (r2 ? 1 : 0) + 335;
    L7:
        return (r2 ? 1 : 0) + 274;
    L9:
        return (r2 ? 1 : 0) + Constants.UPLOAD_DISASTER_DROP;
    L11:
        return (r2 ? 1 : 0) + 182;
    L13:
        return (r2 ? 1 : 0) + 121;
    L15:
        return (r2 ? 1 : 0) + 60;
    L19:
        return (r2 ? 1 : 0) + 305;
    L21:
        return (r2 ? 1 : 0) + 244;
    L23:
        return (r2 ? 1 : 0) + 152;
    L25:
        return (r2 ? 1 : 0) + 91;
    }

    public Month firstMonthOfQuarter() {
        return ENUMS[(ordinal() / 3) * 3];
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (r5 != ChronoField.MONTH_OF_YEAR) goto L7;
        return getValue();
    L7:
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    public String getDisplayName(TextStyle r3, Locale r4) {
        return new DateTimeFormatterBuilder().appendText(ChronoField.MONTH_OF_YEAR, r3).toFormatter(r4).format(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (r4 != ChronoField.MONTH_OF_YEAR) goto L7;
        return getValue();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L11;
        return r4.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ChronoField.class) == true) goto L5;
        if (r5 == null) goto L14;
        if (r5.isSupportedBy(this) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r5 != ChronoField.MONTH_OF_YEAR) goto L8;
        return true;
    L8:
        return false;
    }

    public int length(boolean r2) {
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$Month[ordinal()];
        if (r1 != 1) goto L5;
        if (r2 == false) goto L18;
        return 29;
    L18:
        return 28;
    L5:
        if (r1 != 2) goto L7;
        return 30;
    L7:
        if (r1 != 3) goto L9;
        return 30;
    L9:
        if (r1 != 4) goto L11;
        return 30;
    L11:
        if (r1 == 5) goto L23;
        return 31;
    L23:
        return 30;
    }

    public int maxLength() {
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$Month[ordinal()];
        if (r1 != 1) goto L5;
        return 29;
    L5:
        if (r1 != 2) goto L7;
        return 30;
    L7:
        if (r1 != 3) goto L9;
        return 30;
    L9:
        if (r1 != 4) goto L11;
        return 30;
    L11:
        if (r1 == 5) goto L20;
        return 31;
    L20:
        return 30;
    }

    public int minLength() {
        int r1 = AnonymousClass2.$SwitchMap$org$threeten$bp$Month[ordinal()];
        if (r1 != 1) goto L5;
        return 28;
    L5:
        if (r1 != 2) goto L7;
        return 30;
    L7:
        if (r1 != 3) goto L9;
        return 30;
    L9:
        if (r1 != 4) goto L11;
        return 30;
    L11:
        if (r1 == 5) goto L20;
        return 31;
    L20:
        return 30;
    }

    public Month minus(long r3) {
        return plus(-(r3 % 12));
    }

    public Month plus(long r3) {
        return ENUMS[(ordinal() + (((int) (r3 % 12)) + 12)) % 12];
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<Chronology> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.memorydata.plugin");
        if (r4 != TemporalQueries.chronology()) goto L7;
        return (R) IsoChronology.INSTANCE;
    L7:
        if (r4 != TemporalQueries.precision()) goto L11;
        return (R) ChronoUnit.MONTHS;
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
        return (R) r4.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.memorydata.plugin");
        if (r4 != ChronoField.MONTH_OF_YEAR) goto L7;
        return r4.range();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == true) goto L11;
        return r4.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    }
}
