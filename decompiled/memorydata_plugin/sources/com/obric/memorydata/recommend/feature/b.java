package com.obric.memorydata.recommend.feature;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, d2 = {"resolveScreenObservationRestoreAction", "Lcom/obric/memorydata/recommend/feature/ScreenObservationRestoreAction;", "savedRestoreTime", "", "currentTime", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final ScreenObservationRestoreAction a(long r2, long r4) {
        if (r2 > 0) goto L6;
        return ScreenObservationRestoreAction.NONE;
    L6:
        if (r2 <= r4) goto L9;
        return ScreenObservationRestoreAction.RESCHEDULE;
    L9:
        return ScreenObservationRestoreAction.RESTORE;
    }
}
