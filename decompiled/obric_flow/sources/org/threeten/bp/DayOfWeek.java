package org.threeten.bp;

import ai.j0;
import java.util.Locale;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.format.s;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes3.dex */
public final enum DayOfWeek extends Enum<DayOfWeek> implements org.threeten.bp.temporal.d, org.threeten.bp.temporal.e {
    public static final DayOfWeek FRIDAY = null;
    public static final org.threeten.bp.temporal.i FROM = null;
    public static final DayOfWeek MONDAY = null;
    public static final DayOfWeek SATURDAY = null;
    public static final DayOfWeek SUNDAY = null;
    public static final DayOfWeek THURSDAY = null;
    public static final DayOfWeek TUESDAY = null;
    public static final DayOfWeek WEDNESDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DayOfWeek[] f21117a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ DayOfWeek[] f21118b = null;

    static {
        DayOfWeek r5 = new DayOfWeek("MONDAY", 0);
        MONDAY = r5;
        DayOfWeek r10 = new DayOfWeek("TUESDAY", 1);
        TUESDAY = r10;
        DayOfWeek r11 = new DayOfWeek("WEDNESDAY", 2);
        WEDNESDAY = r11;
        DayOfWeek r12 = new DayOfWeek("THURSDAY", 3);
        THURSDAY = r12;
        DayOfWeek r13 = new DayOfWeek("FRIDAY", 4);
        FRIDAY = r13;
        DayOfWeek r14 = new DayOfWeek("SATURDAY", 5);
        SATURDAY = r14;
        DayOfWeek r15 = new DayOfWeek("SUNDAY", 6);
        SUNDAY = r15;
        f21118b = new DayOfWeek[]{r5, r10, r11, r12, r13, r14, r15};
        FROM = new wc.f(13);
        f21117a = values();
    }

    public static DayOfWeek from(org.threeten.bp.temporal.d r5) {
        if ((r5 instanceof DayOfWeek) == true) goto L5;
        return of(r5.get(ChronoField.DAY_OF_WEEK));
    L8:
        e = move-exception;
        throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + r5 + ", type " + r5.getClass().getName(), e);
    L5:
        return (DayOfWeek) r5;
    }

    public static DayOfWeek of(int r5) {
        if (r5 < 1) goto L9;
        if (r5 > 7) goto L9;
        return f21117a[r5 - 1];
    L9:
        throw new DateTimeException(j0.g(r5, "Invalid value for DayOfWeek: "));
    }

    public static DayOfWeek valueOf(String r5) {
        return (DayOfWeek) Enum.valueOf(DayOfWeek.class, r5);
    }

    public static DayOfWeek[] values() {
        return (DayOfWeek[]) f21118b.clone();
    }

    @Override // org.threeten.bp.temporal.e
    public org.threeten.bp.temporal.c adjustInto(org.threeten.bp.temporal.c r5) {
        return r5.with(ChronoField.DAY_OF_WEEK, getValue());
    }

    @Override // org.threeten.bp.temporal.d
    public int get(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.DAY_OF_WEEK) goto L7;
        return getValue();
    L7:
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    public String getDisplayName(TextStyle r5, Locale r10) {
        s r11 = new s();
        r11.i(ChronoField.DAY_OF_WEEK, r5);
        return r11.q(r10).a(this);
    }

    @Override // org.threeten.bp.temporal.d
    public long getLong(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.DAY_OF_WEEK) goto L7;
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
        if (r5 == ChronoField.DAY_OF_WEEK) goto L7;
        return false;
    L7:
        return true;
    }

    public DayOfWeek minus(long r5) {
        return plus(-(r5 % 7));
    }

    public DayOfWeek plus(long r5) {
        int r10 = ((int) (r5 % 7)) + 7;
        int r11 = (r10 + ordinal()) % 7;
        return f21117a[r11];
    }

    @Override // org.threeten.bp.temporal.d
    public <R> R query(org.threeten.bp.temporal.i r5) {
        if (r5 != org.threeten.bp.temporal.h.f21288c) goto L7;
        return (R) ChronoUnit.DAYS;
    L7:
        if (r5 != org.threeten.bp.temporal.h.f) goto L9;
        return null;
    L9:
        if (r5 != org.threeten.bp.temporal.h.g) goto L11;
        return null;
    L11:
        if (r5 != org.threeten.bp.temporal.h.f21287b) goto L13;
        return null;
    L13:
        if (r5 != org.threeten.bp.temporal.h.d) goto L15;
        return null;
    L15:
        if (r5 != org.threeten.bp.temporal.h.f21286a) goto L17;
        return null;
    L17:
        if (r5 != org.threeten.bp.temporal.h.e) goto L20;
        return null;
    L20:
        return (R) r5.d(this);
    }

    @Override // org.threeten.bp.temporal.d
    public ValueRange range(org.threeten.bp.temporal.g r5) {
        if (r5 != ChronoField.DAY_OF_WEEK) goto L7;
        return r5.range();
    L7:
        if ((r5 instanceof ChronoField) == true) goto L11;
        return r5.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException(kotlin.collections.a.h("Unsupported field: ", r5));
    }
}
