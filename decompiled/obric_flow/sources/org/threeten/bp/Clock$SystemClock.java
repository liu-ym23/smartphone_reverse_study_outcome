package org.threeten.bp;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
final class Clock$SystemClock extends a implements Serializable {
    private static final long serialVersionUID = 6740630888130243051L;
    private final ZoneId zone;

    public Clock$SystemClock(ZoneId r5) {
        this.zone = r5;
    }

    @Override // org.threeten.bp.a
    public boolean equals(Object r5) {
        if ((r5 instanceof Clock$SystemClock) == true) goto L5;
        return false;
    L5:
        return this.zone.equals(((Clock$SystemClock) r5).zone);
    }

    @Override // org.threeten.bp.a
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // org.threeten.bp.a
    public int hashCode() {
        return this.zone.hashCode() + 1;
    }

    @Override // org.threeten.bp.a
    public Instant instant() {
        return Instant.ofEpochMilli(millis());
    }

    @Override // org.threeten.bp.a
    public long millis() {
        return System.currentTimeMillis();
    }

    public String toString() {
        return "SystemClock[" + this.zone + "]";
    }

    @Override // org.threeten.bp.a
    public a withZone(ZoneId r5) {
        if (r5.equals(this.zone) == false) goto L6;
        return this;
    L6:
        return new Clock$SystemClock(r5);
    }
}
