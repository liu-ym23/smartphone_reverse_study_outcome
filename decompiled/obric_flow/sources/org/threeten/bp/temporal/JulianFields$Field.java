package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes3.dex */
final enum JulianFields$Field extends Enum<JulianFields$Field> implements g {
    public static final JulianFields$Field JULIAN_DAY = null;
    public static final JulianFields$Field MODIFIED_JULIAN_DAY = null;
    public static final JulianFields$Field RATA_DIE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JulianFields$Field[] f21278a = null;
    private final j baseUnit;
    private final String name;
    private final long offset;
    private final ValueRange range;
    private final j rangeUnit;

    static {
        ChronoUnit r10 = ChronoUnit.DAYS;
        ChronoUnit r11 = ChronoUnit.FOREVER;
        JulianFields$Field r12 = new JulianFields$Field("JULIAN_DAY", 0, "JulianDay", r10, r11, 2440588);
        JULIAN_DAY = r12;
        JulianFields$Field r13 = new JulianFields$Field("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", r10, r11, 40587);
        MODIFIED_JULIAN_DAY = r13;
        JulianFields$Field r14 = new JulianFields$Field("RATA_DIE", 2, "RataDie", r10, r11, 719163);
        RATA_DIE = r14;
        f21278a = new JulianFields$Field[]{r12, r13, r14};
    }

    public JulianFields$Field(String r5, int r10, String r11, ChronoUnit r12, ChronoUnit r13, long r14) {
        super(r5, r10);
        this.name = r11;
        this.baseUnit = r12;
        this.rangeUnit = r13;
        this.range = ValueRange.of((-365243219162L) + r14, 365241780471L + r14);
        this.offset = r14;
    }

    public static JulianFields$Field valueOf(String r5) {
        return (JulianFields$Field) Enum.valueOf(JulianFields$Field.class, r5);
    }

    public static JulianFields$Field[] values() {
        return (JulianFields$Field[]) f21278a.clone();
    }

    @Override // org.threeten.bp.temporal.g
    public <R extends c> R adjustInto(R r5, long r10) {
        if (range().isValidValue(r10) == false) goto L7;
        return (R) r5.with(ChronoField.EPOCH_DAY, jm.c.w(r10, this.offset));
    L7:
        throw new DateTimeException("Invalid value: " + this.name + " " + r10);
    }

    public j getBaseUnit() {
        return this.baseUnit;
    }

    public String getDisplayName(Locale r5) {
        jm.c.p(r5, "locale");
        return toString();
    }

    @Override // org.threeten.bp.temporal.g
    public long getFrom(d r5) {
        return r5.getLong(ChronoField.EPOCH_DAY) + this.offset;
    }

    public j getRangeUnit() {
        return this.rangeUnit;
    }

    @Override // org.threeten.bp.temporal.g
    public boolean isDateBased() {
        return true;
    }

    @Override // org.threeten.bp.temporal.g
    public boolean isSupportedBy(d r5) {
        return r5.isSupported(ChronoField.EPOCH_DAY);
    }

    @Override // org.threeten.bp.temporal.g
    public boolean isTimeBased() {
        return false;
    }

    @Override // org.threeten.bp.temporal.g
    public ValueRange range() {
        return this.range;
    }

    @Override // org.threeten.bp.temporal.g
    public ValueRange rangeRefinedBy(d r5) {
        if (isSupportedBy(r5) == false) goto L7;
        return range();
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
    }

    @Override // org.threeten.bp.temporal.g
    public d resolve(Map<g, Long> r5, d r10, ResolverStyle r11) {
        long r12 = r5.remove(this).longValue();
        return org.threeten.bp.chrono.i.from(r10).dateEpochDay(jm.c.w(r12, this.offset));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
