package org.threeten.bp;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public a() {
    }

    public static a fixed(Instant r5, ZoneId r10) {
        jm.c.p(r5, "fixedInstant");
        jm.c.p(r10, "zone");
        return new Clock$FixedClock(r5, r10);
    }

    public static a offset(a r5, Duration r10) {
        jm.c.p(r5, "baseClock");
        jm.c.p(r10, "offsetDuration");
        if (r10.equals(Duration.ZERO) == false) goto L6;
        return r5;
    L6:
        return new Clock$OffsetClock(r5, r10);
    }

    public static a system(ZoneId r5) {
        jm.c.p(r5, "zone");
        return new Clock$SystemClock(r5);
    }

    public static a systemDefaultZone() {
        return new Clock$SystemClock(ZoneId.systemDefault());
    }

    public static a systemUTC() {
        return new Clock$SystemClock(ZoneOffset.UTC);
    }

    public static a tick(a r10, Duration r11) {
        jm.c.p(r10, "baseClock");
        jm.c.p(r11, "tickDuration");
        if (r11.isNegative() == true) goto L17;
        long r5 = r11.toNanos();
        if ((r5 % 1000000) == 0) goto L10;
        if ((1000000000 % r5) == 0) goto L10;
        throw new IllegalArgumentException("Invalid tick duration");
    L10:
        if (r5 > 1) goto L13;
        return r10;
    L13:
        return new Clock$TickClock(r10, r5);
    L17:
        throw new IllegalArgumentException("Tick duration must not be negative");
    }

    public static a tickMinutes(ZoneId r5) {
        return new Clock$TickClock(system(r5), 60000000000L);
    }

    public static a tickSeconds(ZoneId r5) {
        return new Clock$TickClock(system(r5), 1000000000);
    }

    public abstract boolean equals(Object r5);

    public abstract ZoneId getZone();

    public abstract int hashCode();

    public abstract Instant instant();

    public abstract long millis();

    public abstract a withZone(ZoneId r5);
}
