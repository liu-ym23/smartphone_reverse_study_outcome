package org.threeten.bp.temporal;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface TemporalAmount {
    Temporal addTo(Temporal r1);

    long get(TemporalUnit r1);

    List<TemporalUnit> getUnits();

    Temporal subtractFrom(Temporal r1);
}
