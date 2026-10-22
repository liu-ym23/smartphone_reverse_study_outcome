package org.threeten.bp.temporal;

/* JADX INFO: loaded from: classes8.dex */
public interface Temporal extends TemporalAccessor {
    Temporal minus(long r1, TemporalUnit r3);

    Temporal plus(long r1, TemporalUnit r3);

    long until(Temporal r1, TemporalUnit r2);

    Temporal with(TemporalAdjuster r1);

    Temporal with(TemporalField r1, long r2);
}
