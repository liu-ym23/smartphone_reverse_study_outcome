package org.threeten.bp.temporal;

import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes8.dex */
public interface TemporalField {
    <R extends Temporal> R adjustInto(R r1, long r2);

    long getFrom(TemporalAccessor r1);

    boolean isDateBased();

    boolean isSupportedBy(TemporalAccessor r1);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(TemporalAccessor r1);

    TemporalAccessor resolve(Map<TemporalField, Long> r1, TemporalAccessor r2, ResolverStyle r3);
}
