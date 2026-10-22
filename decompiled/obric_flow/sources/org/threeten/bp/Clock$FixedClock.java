package org.threeten.bp;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class Clock$FixedClock extends a implements Serializable {
    private static final long serialVersionUID = 7430389292664866958L;
    private final Instant instant;
    private final ZoneId zone;

    public Clock$FixedClock(Instant r5, ZoneId r10) {
        this.instant = r5;
        this.zone = r10;
    }

    @Override // org.threeten.bp.a
    public boolean equals(Object r5) {
        if ((r5 instanceof Clock$FixedClock) == false) goto L10;
        Clock$FixedClock r10 = (Clock$FixedClock) r5;
        if (this.instant.equals(r10.instant) == true) goto L7;
        return false;
    L7:
        if (this.zone.equals(r10.zone) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // org.threeten.bp.a
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // org.threeten.bp.a
    public int hashCode() {
        int r5 = this.instant.hashCode();
        return this.zone.hashCode() ^ r5;
    }

    @Override // org.threeten.bp.a
    public Instant instant() {
        return this.instant;
    }

    @Override // org.threeten.bp.a
    public long millis() {
        return this.instant.toEpochMilli();
    }

    public String toString() {
        return "FixedClock[" + this.instant + "," + this.zone + "]";
    }

    @Override // org.threeten.bp.a
    public a withZone(ZoneId r5) {
        if (r5.equals(this.zone) == false) goto L6;
        return this;
    L6:
        return new Clock$FixedClock(this.instant, r5);
    }
}
