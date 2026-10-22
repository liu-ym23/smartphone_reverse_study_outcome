package org.threeten.bp;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class Clock$OffsetClock extends a implements Serializable {
    private static final long serialVersionUID = 2007484719125426256L;
    private final a baseClock;
    private final Duration offset;

    public Clock$OffsetClock(a r5, Duration r10) {
        this.baseClock = r5;
        this.offset = r10;
    }

    @Override // org.threeten.bp.a
    public boolean equals(Object r5) {
        if ((r5 instanceof Clock$OffsetClock) == false) goto L10;
        Clock$OffsetClock r10 = (Clock$OffsetClock) r5;
        if (this.baseClock.equals(r10.baseClock) == true) goto L7;
        return false;
    L7:
        if (this.offset.equals(r10.offset) == false) goto L12;
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
        return this.offset.hashCode() ^ r5;
    }

    @Override // org.threeten.bp.a
    public Instant instant() {
        return this.baseClock.instant().plus(this.offset);
    }

    @Override // org.threeten.bp.a
    public long millis() {
        return jm.c.r(this.baseClock.millis(), this.offset.toMillis());
    }

    public String toString() {
        return "OffsetClock[" + this.baseClock + "," + this.offset + "]";
    }

    @Override // org.threeten.bp.a
    public a withZone(ZoneId r5) {
        if (r5.equals(this.baseClock.getZone()) == false) goto L6;
        return this;
    L6:
        return new Clock$OffsetClock(this.baseClock.withZone(r5), this.offset);
    }
}
