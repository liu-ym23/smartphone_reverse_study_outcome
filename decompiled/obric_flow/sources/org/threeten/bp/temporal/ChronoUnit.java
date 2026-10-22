package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

/* JADX INFO: loaded from: classes3.dex */
public final enum ChronoUnit extends Enum<ChronoUnit> implements j {
    public static final ChronoUnit CENTURIES = null;
    public static final ChronoUnit DAYS = null;
    public static final ChronoUnit DECADES = null;
    public static final ChronoUnit ERAS = null;
    public static final ChronoUnit FOREVER = null;
    public static final ChronoUnit HALF_DAYS = null;
    public static final ChronoUnit HOURS = null;
    public static final ChronoUnit MICROS = null;
    public static final ChronoUnit MILLENNIA = null;
    public static final ChronoUnit MILLIS = null;
    public static final ChronoUnit MINUTES = null;
    public static final ChronoUnit MONTHS = null;
    public static final ChronoUnit NANOS = null;
    public static final ChronoUnit SECONDS = null;
    public static final ChronoUnit WEEKS = null;
    public static final ChronoUnit YEARS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChronoUnit[] f21274a = null;
    private final Duration duration;
    private final String name;

    static {
        ChronoUnit r5 = new ChronoUnit("NANOS", 0, "Nanos", Duration.ofNanos(1));
        NANOS = r5;
        ChronoUnit r10 = new ChronoUnit("MICROS", 1, "Micros", Duration.ofNanos(1000));
        MICROS = r10;
        ChronoUnit r11 = new ChronoUnit("MILLIS", 2, "Millis", Duration.ofNanos(1000000));
        MILLIS = r11;
        ChronoUnit r12 = new ChronoUnit("SECONDS", 3, "Seconds", Duration.ofSeconds(1));
        SECONDS = r12;
        ChronoUnit r13 = new ChronoUnit("MINUTES", 4, "Minutes", Duration.ofSeconds(60));
        MINUTES = r13;
        ChronoUnit r14 = new ChronoUnit("HOURS", 5, "Hours", Duration.ofSeconds(3600));
        HOURS = r14;
        ChronoUnit r15 = new ChronoUnit("HALF_DAYS", 6, "HalfDays", Duration.ofSeconds(43200));
        HALF_DAYS = r15;
        ChronoUnit r16 = new ChronoUnit("DAYS", 7, "Days", Duration.ofSeconds(86400));
        DAYS = r16;
        ChronoUnit r17 = new ChronoUnit("WEEKS", 8, "Weeks", Duration.ofSeconds(604800));
        WEEKS = r17;
        ChronoUnit r18 = new ChronoUnit("MONTHS", 9, "Months", Duration.ofSeconds(2629746));
        MONTHS = r18;
        ChronoUnit r19 = new ChronoUnit("YEARS", 10, "Years", Duration.ofSeconds(31556952));
        YEARS = r19;
        ChronoUnit r110 = new ChronoUnit("DECADES", 11, "Decades", Duration.ofSeconds(315569520));
        DECADES = r110;
        ChronoUnit r111 = new ChronoUnit("CENTURIES", 12, "Centuries", Duration.ofSeconds(3155695200L));
        CENTURIES = r111;
        ChronoUnit r112 = new ChronoUnit("MILLENNIA", 13, "Millennia", Duration.ofSeconds(31556952000L));
        MILLENNIA = r112;
        ChronoUnit r113 = new ChronoUnit("ERAS", 14, "Eras", Duration.ofSeconds(31556952000000000L));
        ERAS = r113;
        ChronoUnit r114 = new ChronoUnit("FOREVER", 15, "Forever", Duration.ofSeconds(Long.MAX_VALUE, 999999999));
        FOREVER = r114;
        f21274a = new ChronoUnit[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114};
    }

    public ChronoUnit(String r5, int r10, String r11, Duration r12) {
        super(r5, r10);
        this.name = r11;
        this.duration = r12;
    }

    public static ChronoUnit valueOf(String r5) {
        return (ChronoUnit) Enum.valueOf(ChronoUnit.class, r5);
    }

    public static ChronoUnit[] values() {
        return (ChronoUnit[]) f21274a.clone();
    }

    @Override // org.threeten.bp.temporal.j
    public <R extends c> R addTo(R r5, long r10) {
        return (R) r5.plus(r10, this);
    }

    @Override // org.threeten.bp.temporal.j
    public long between(c r5, c r10) {
        return r5.until(r10, this);
    }

    @Override // org.threeten.bp.temporal.j
    public Duration getDuration() {
        return this.duration;
    }

    @Override // org.threeten.bp.temporal.j
    public boolean isDateBased() {
        if (compareTo(DAYS) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this == FOREVER) goto L7;
        return true;
    }

    @Override // org.threeten.bp.temporal.j
    public boolean isDurationEstimated() {
        if (isDateBased() == false) goto L5;
    L8:
        return true;
    L5:
        if (this == FOREVER) goto L8;
        return false;
    }

    @Override // org.threeten.bp.temporal.j
    public boolean isSupportedBy(c r10) {
        if (this != FOREVER) goto L6;
        return false;
    L6:
        if ((r10 instanceof org.threeten.bp.chrono.b) == false) goto L10;
        return isDateBased();
    L10:
        if ((r10 instanceof org.threeten.bp.chrono.c) == false) goto L12;
    L21:
        return true;
    L12:
        if ((r10 instanceof org.threeten.bp.chrono.g) == true) goto L21;
        r10.plus(1, this);     // Catch: RuntimeException -> L17
        return true;
    L22:
        r10.plus(-1, this);     // Catch: RuntimeException -> L20
        return true;
    L20:
        return false;
    }

    @Override // org.threeten.bp.temporal.j
    public boolean isTimeBased() {
        if (compareTo(DAYS) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
