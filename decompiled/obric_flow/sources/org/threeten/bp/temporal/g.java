package org.threeten.bp.temporal;

import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes3.dex */
public interface g {
    c adjustInto(c r5, long r10);

    long getFrom(d r5);

    boolean isDateBased();

    boolean isSupportedBy(d r5);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(d r5);

    d resolve(Map r5, d r10, ResolverStyle r11);
}
