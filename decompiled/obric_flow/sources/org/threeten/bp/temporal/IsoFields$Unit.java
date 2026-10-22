package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

/* JADX INFO: loaded from: classes3.dex */
final enum IsoFields$Unit extends Enum<IsoFields$Unit> implements j {
    public static final IsoFields$Unit QUARTER_YEARS = null;
    public static final IsoFields$Unit WEEK_BASED_YEARS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IsoFields$Unit[] f21277a = null;
    private final Duration duration;
    private final String name;

    static {
        IsoFields$Unit r5 = new IsoFields$Unit("WEEK_BASED_YEARS", 0, "WeekBasedYears", Duration.ofSeconds(31556952));
        WEEK_BASED_YEARS = r5;
        IsoFields$Unit r10 = new IsoFields$Unit("QUARTER_YEARS", 1, "QuarterYears", Duration.ofSeconds(7889238));
        QUARTER_YEARS = r10;
        f21277a = new IsoFields$Unit[]{r5, r10};
    }

    public IsoFields$Unit(String r5, int r10, String r11, Duration r12) {
        super(r5, r10);
        this.name = r11;
        this.duration = r12;
    }

    public static IsoFields$Unit valueOf(String r5) {
        return (IsoFields$Unit) Enum.valueOf(IsoFields$Unit.class, r5);
    }

    public static IsoFields$Unit[] values() {
        return (IsoFields$Unit[]) f21277a.clone();
    }

    @Override // org.threeten.bp.temporal.j
    public <R extends c> R addTo(R r5, long r10) {
        int r11 = a.f21282a[ordinal()];
        if (r11 != 1) goto L5;
        g r12 = b.f21285c;
        return (R) r5.with(r12, jm.c.r(r5.get(r12), r10));
    L5:
        if (r11 != 2) goto L9;
        return (R) r5.plus(r10 / 256, ChronoUnit.YEARS).plus((r10 % 256) * 3, ChronoUnit.MONTHS);
    L9:
        throw new IllegalStateException("Unreachable");
    }

    @Override // org.threeten.bp.temporal.j
    public long between(c r5, c r10) {
        int r11 = a.f21282a[ordinal()];
        if (r11 != 1) goto L5;
        g r12 = b.f21285c;
        return jm.c.w(r10.getLong(r12), r5.getLong(r12));
    L5:
        if (r11 != 2) goto L9;
        return r5.until(r10, ChronoUnit.MONTHS) / 3;
    L9:
        throw new IllegalStateException("Unreachable");
    }

    @Override // org.threeten.bp.temporal.j
    public Duration getDuration() {
        return this.duration;
    }

    @Override // org.threeten.bp.temporal.j
    public boolean isDateBased() {
        return true;
    }

    @Override // org.threeten.bp.temporal.j
    public boolean isDurationEstimated() {
        return true;
    }

    @Override // org.threeten.bp.temporal.j
    public boolean isSupportedBy(c r5) {
        return r5.isSupported(ChronoField.EPOCH_DAY);
    }

    @Override // org.threeten.bp.temporal.j
    public boolean isTimeBased() {
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
