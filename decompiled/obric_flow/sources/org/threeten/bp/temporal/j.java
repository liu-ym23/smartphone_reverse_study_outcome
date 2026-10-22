package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

/* JADX INFO: loaded from: classes3.dex */
public interface j {
    c addTo(c r5, long r10);

    long between(c r5, c r10);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(c r5);

    boolean isTimeBased();
}
