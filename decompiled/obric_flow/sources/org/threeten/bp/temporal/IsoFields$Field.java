package org.threeten.bp.temporal;

import ai.j0;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes3.dex */
abstract enum IsoFields$Field extends Enum<IsoFields$Field> implements g {
    public static final IsoFields$Field DAY_OF_QUARTER = null;
    public static final IsoFields$Field QUARTER_OF_YEAR = null;
    public static final IsoFields$Field WEEK_BASED_YEAR = null;
    public static final IsoFields$Field WEEK_OF_WEEK_BASED_YEAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f21275a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ IsoFields$Field[] f21276b = null;

    static {
        final String r5 = "DAY_OF_QUARTER";
        final int r10 = 0;
        IsoFields$Field r11 = new AnonymousClass1(r5, r10);
        DAY_OF_QUARTER = r11;
        final String r12 = "QUARTER_OF_YEAR";
        final int r13 = 1;
        IsoFields$Field r14 = new AnonymousClass2(r12, r13);
        QUARTER_OF_YEAR = r14;
        final String r15 = "WEEK_OF_WEEK_BASED_YEAR";
        final int r16 = 2;
        IsoFields$Field r17 = new AnonymousClass3(r15, r16);
        WEEK_OF_WEEK_BASED_YEAR = r17;
        final String r18 = "WEEK_BASED_YEAR";
        final int r19 = 3;
        IsoFields$Field r20 = new AnonymousClass4(r18, r19);
        WEEK_BASED_YEAR = r20;
        f21276b = new IsoFields$Field[]{r11, r14, r17, r20};
        f21275a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public IsoFields$Field(String r5, int r10, a r11) {
        super(r5, r10);
    }

    public static int a(LocalDate r5) {
        int r10 = r5.getYear();
        int r11 = r5.getDayOfYear();
        if (r11 > 3) goto L8;
        if ((r11 - r5.getDayOfWeek().ordinal()) < (-2)) goto L14;
        return r10;
    L14:
        return r10 - 1;
    L8:
        if (r11 >= 363) goto L10;
        return r10;
    L10:
        if ((((r11 - 363) - (r5.isLeapYear() ? 1 : 0)) - r5.getDayOfWeek().ordinal()) >= 0) goto L12;
        return r10;
    L12:
        return r10 + 1;
    }

    public static boolean access$100(d r5) {
        return org.threeten.bp.chrono.i.from(r5).equals(IsoChronology.INSTANCE);
    }

    public static /* synthetic */ int[] access$200() {
        return f21275a;
    }

    public static ValueRange access$300(LocalDate r5) {
        return ValueRange.of(1, b(a(r5)));
    }

    public static int access$400(LocalDate r10) {
        int r5 = r10.getDayOfWeek().ordinal();
        int r11 = 1;
        int r12 = r10.getDayOfYear() - 1;
        int r13 = (3 - r5) + r12;
        int r14 = r13 - ((r13 / 7) * 7);
        int r15 = r14 - 3;
        if (r15 >= (-3)) goto L5;
        r15 = r14 + 4;
    L5:
        if (r12 < r15) goto L17;
        int r16 = j0.c(r12, r15, 7, 1);
        if (r16 != 53) goto L14;
        if (r15 == (-3)) goto L14;
        if (r15 != (-2)) goto L16;
        if (r10.isLeapYear() == true) goto L14;
    L16:
        return r11;
    L14:
        r11 = r16;
        goto L16
    L17:
        return (int) ValueRange.of(1, b(a(r10.withDayOfYear(180).minusYears(1)))).getMaximum();
    }

    public static /* synthetic */ int access$500(LocalDate r5) {
        return a(r5);
    }

    public static /* synthetic */ int access$600(int r5) {
        return b(r5);
    }

    public static int b(int r5) {
        LocalDate r10 = LocalDate.of(r5, 1, 1);
        if (r10.getDayOfWeek() != DayOfWeek.THURSDAY) goto L5;
        return 53;
    L5:
        if (r10.getDayOfWeek() == DayOfWeek.WEDNESDAY) goto L7;
        return 52;
    L7:
        if (r10.isLeapYear() == true) goto L14;
        return 52;
    L14:
        return 53;
    }

    public static IsoFields$Field valueOf(String r5) {
        return (IsoFields$Field) Enum.valueOf(IsoFields$Field.class, r5);
    }

    public static IsoFields$Field[] values() {
        return (IsoFields$Field[]) f21276b.clone();
    }

    @Override // org.threeten.bp.temporal.g
    public abstract /* synthetic */ c adjustInto(c r5, long r10);

    public abstract /* synthetic */ j getBaseUnit();

    public String getDisplayName(Locale r5) {
        jm.c.p(r5, "locale");
        return toString();
    }

    @Override // org.threeten.bp.temporal.g
    public abstract /* synthetic */ long getFrom(d r5);

    public abstract /* synthetic */ j getRangeUnit();

    @Override // org.threeten.bp.temporal.g
    public boolean isDateBased() {
        return true;
    }

    @Override // org.threeten.bp.temporal.g
    public abstract /* synthetic */ boolean isSupportedBy(d r5);

    @Override // org.threeten.bp.temporal.g
    public boolean isTimeBased() {
        return false;
    }

    @Override // org.threeten.bp.temporal.g
    public abstract /* synthetic */ ValueRange range();

    @Override // org.threeten.bp.temporal.g
    public abstract /* synthetic */ ValueRange rangeRefinedBy(d r5);

    @Override // org.threeten.bp.temporal.g
    public d resolve(Map<g, Long> r5, d r10, ResolverStyle r11) {
        return null;
    }
}
