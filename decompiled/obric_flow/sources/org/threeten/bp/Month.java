package org.threeten.bp;

import ai.j0;
import java.util.Locale;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.format.s;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final enum Month extends Enum<Month> implements org.threeten.bp.temporal.d, org.threeten.bp.temporal.e {
    public static final Month APRIL = null;
    public static final Month AUGUST = null;
    public static final Month DECEMBER = null;
    public static final Month FEBRUARY = null;
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final Month JANUARY = null;
    public static final Month JULY = null;
    public static final Month JUNE = null;
    public static final Month MARCH = null;
    public static final Month MAY = null;
    public static final Month NOVEMBER = null;
    public static final Month OCTOBER = null;
    public static final Month SEPTEMBER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Month[] f21122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Month[] f21123b = null;

    static {
        Month r5 = new Month("JANUARY", 0);
        JANUARY = r5;
        Month r10 = new Month("FEBRUARY", 1);
        FEBRUARY = r10;
        Month r11 = new Month("MARCH", 2);
        MARCH = r11;
        Month r12 = new Month("APRIL", 3);
        APRIL = r12;
        Month r13 = new Month("MAY", 4);
        MAY = r13;
        Month r14 = new Month("JUNE", 5);
        JUNE = r14;
        Month r15 = new Month("JULY", 6);
        JULY = r15;
        Month r16 = new Month("AUGUST", 7);
        AUGUST = r16;
        Month r17 = new Month("SEPTEMBER", 8);
        SEPTEMBER = r17;
        Month r18 = new Month("OCTOBER", 9);
        OCTOBER = r18;
        Month r19 = new Month("NOVEMBER", 10);
        NOVEMBER = r19;
        Month r110 = new Month("DECEMBER", 11);
        DECEMBER = r110;
        f21123b = new Month[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
        FROM = new com.lynx.tasm.utils.c(14);
        f21122a = values();
    }

    public static Month from(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof Month) == true) goto L5;
    L9:
        e = move-exception;
        throw new DateTimeException("Unable to obtain Month from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName(), e);
    L7:
        if (IsoChronology.INSTANCE.equals(org.threeten.bp.chrono.i.from(r5)) == true) goto L11;
        r5 = LocalDate.from(r5);     // Catch: DateTimeException -> L9
    L11:
        return of(r5.get(ChronoField.MONTH_OF_YEAR));
    L5:
        return (Month) r5;
    }

    public static Month of(int r5) {
        if (r5 < 1) goto L9;
        if (r5 > 12) goto L9;
        return f21122a[r5 - 1];
    L9:
        throw new DateTimeException(j0.g(r5, "Invalid value for MonthOfYear: "));
    }

    public static Month valueOf(String r5) {
        return (Month) Enum.valueOf(Month.class, r5);
    }

    public static Month[] values() {
        return (Month[]) f21123b.clone();
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        if (org.threeten.bp.chrono.i.from(r5).equals(IsoChronology.INSTANCE) == false) goto L7;
        return r5.with(ChronoField.MONTH_OF_YEAR, getValue());
    L7:
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public int firstDayOfYear(boolean r5) {
        switch(g.f21262a[ordinal()]) {
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
        return (r5 ? 1 : 0) + 335;
    L7:
        return (r5 ? 1 : 0) + 274;
    L9:
        return (r5 ? 1 : 0) + 213;
    L11:
        return (r5 ? 1 : 0) + 182;
    L13:
        return (r5 ? 1 : 0) + 121;
    L15:
        return (r5 ? 1 : 0) + 60;
    L19:
        return (r5 ? 1 : 0) + 305;
    L21:
        return (r5 ? 1 : 0) + 244;
    L23:
        return (r5 ? 1 : 0) + 152;
    L25:
        return (r5 ? 1 : 0) + 91;
    }

    public Month firstMonthOfQuarter() {
        int r5 = (ordinal() / 3) * 3;
        return f21122a[r5];
    }

    @Override // org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.MONTH_OF_YEAR) goto L7;
        return getValue();
    L7:
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    public String getDisplayName(TextStyle r5, Locale r10) {
        s r11 = new s();
        r11.i(ChronoField.MONTH_OF_YEAR, r5);
        return r11.q(r10).a(this);
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.MONTH_OF_YEAR) goto L7;
        return getValue();
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return r5.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }

    public int getValue() {
        return ordinal() + 1;
    }

    @Override // org.threeten.bp.temporal.d
    public boolean isSupported(org.threeten.bp.temporal.g r5) {
        if ((r5 instanceof ChronoField) == true) goto L5;
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5.isSupportedBy(this) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (r5 == ChronoField.MONTH_OF_YEAR) goto L7;
        return false;
    L7:
        return true;
    }

    public int length(boolean r5) {
        int r10 = g.f21262a[ordinal()];
        if (r10 != 1) goto L5;
        if (r5 == false) goto L18;
        return 29;
    L18:
        return 28;
    L5:
        if (r10 != 2) goto L7;
        return 30;
    L7:
        if (r10 != 3) goto L9;
        return 30;
    L9:
        if (r10 != 4) goto L11;
        return 30;
    L11:
        if (r10 == 5) goto L23;
        return 31;
    L23:
        return 30;
    }

    public int maxLength() {
        int r5 = g.f21262a[ordinal()];
        if (r5 != 1) goto L5;
        return 29;
    L5:
        if (r5 != 2) goto L7;
        return 30;
    L7:
        if (r5 != 3) goto L9;
        return 30;
    L9:
        if (r5 != 4) goto L11;
        return 30;
    L11:
        if (r5 == 5) goto L20;
        return 31;
    L20:
        return 30;
    }

    public int minLength() {
        int r5 = g.f21262a[ordinal()];
        if (r5 != 1) goto L5;
        return 28;
    L5:
        if (r5 != 2) goto L7;
        return 30;
    L7:
        if (r5 != 3) goto L9;
        return 30;
    L9:
        if (r5 != 4) goto L11;
        return 30;
    L11:
        if (r5 == 5) goto L20;
        return 31;
    L20:
        return 30;
    }

    public Month minus(long r5) {
        return plus(-(r5 % 12));
    }

    public Month plus(long r5) {
        int r10 = ((int) (r5 % 12)) + 12;
        int r11 = (r10 + ordinal()) % 12;
        return f21122a[r11];
    }

    @Override // org.threeten.bp.temporal.d
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
        return (R) r5.d(this);
    }

    @Override // org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.MONTH_OF_YEAR) goto L7;
        return r5.range();
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return r5.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }
}
