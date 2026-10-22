package org.threeten.bp;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class Clock$TickClock extends a implements Serializable {
    private static final long serialVersionUID = 6504659149906368850L;
    private final a baseClock;
    private final long tickNanos;

    public Clock$TickClock(a r5, long r10) {
        this.baseClock = r5;
        this.tickNanos = r10;
    }

    @Override // org.threeten.bp.a
    public boolean equals(Object r5) {
        if ((r5 instanceof Clock$TickClock) == false) goto L10;
        Clock$TickClock r10 = (Clock$TickClock) r5;
        if (this.baseClock.equals(r10.baseClock) == true) goto L7;
        return false;
    L7:
        if (this.tickNanos != r10.tickNanos) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // org.threeten.bp.a
    public ZoneId getZone() {
        return this.baseClock.getZone();
    }

    @Override // org.threeten.bp.a
    public int hashCode() {
        int r5 = this.baseClock.hashCode();
        long r10 = this.tickNanos;
        return ((int) (r10 ^ (r10 >>> 32))) ^ r5;
    }

    @Override // org.threeten.bp.a
    public Instant instant() {
        if ((this.tickNanos % 1000000) != 0) goto L6;
        long r5 = this.baseClock.millis();
        return Instant.ofEpochMilli(r5 - jm.c.o(r5, this.tickNanos / 1000000));
    L6:
        Instant r10 = this.baseClock.instant();
        return r10.minusNanos(jm.c.o(r10.getNano(), this.tickNanos));
    }

    @Override // org.threeten.bp.a
    public long millis() {
        long r5 = this.baseClock.millis();
        return r5 - jm.c.o(r5, this.tickNanos / 1000000);
    }

    public String toString() {
        return "TickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
    }

    @Override // org.threeten.bp.a
    public a withZone(ZoneId r5) {
        if (r5.equals(this.baseClock.getZone()) == false) goto L6;
        return this;
    L6:
        return new Clock$TickClock(this.baseClock.withZone(r5), this.tickNanos);
    }
}
