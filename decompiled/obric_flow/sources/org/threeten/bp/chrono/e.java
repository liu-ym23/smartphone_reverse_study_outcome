package org.threeten.bp.chrono;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements org.threeten.bp.temporal.f {
    public e() {
    }

    public static e between(b r5, b r10) {
        jm.c.p(r5, "startDateInclusive");
        jm.c.p(r10, "endDateExclusive");
        return r5.until(r10);
    }

    public abstract i getChronology();

    public boolean isNegative() {
        Iterator r5 = getUnits().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (get((org.threeten.bp.temporal.j) r5.next()) >= 0) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean isZero() {
        Iterator r5 = getUnits().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (get((org.threeten.bp.temporal.j) r5.next()) == 0) goto L4;
        return false;
    L9:
        return true;
    }

    public abstract e multipliedBy(int r5);

    public e negated() {
        return multipliedBy(-1);
    }
}
