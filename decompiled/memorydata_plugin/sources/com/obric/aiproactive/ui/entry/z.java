package com.obric.aiproactive.ui.entry;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, d2 = {"resolveSensingEventsDayEmissionDecision", "Lcom/obric/aiproactive/ui/entry/SensingEventsDayEmissionDecision;", "subscribedDayAnchorMillis", "", "currentDayAnchorMillis", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class z {
    public static final SensingEventsDayEmissionDecision a(long r0, long r2) {
        if (r0 != r2) goto L6;
        return SensingEventsDayEmissionDecision.DELIVER;
    L6:
        return SensingEventsDayEmissionDecision.RESTART;
    }
}
