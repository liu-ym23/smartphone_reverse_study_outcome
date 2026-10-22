package com.obric.aiproactive.ui.entry;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000\u001a*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"MAX_COLLAPSE_MEASUREMENT_RETRY_COUNT", "", "COLLAPSE_MEASUREMENT_RETRY_DELAY_MS", "", "shouldRunCollapseEvaluation", "", "lifecycleStarted", "screenInteractive", "resolveCollapseMeasurementDecision", "Lcom/obric/aiproactive/ui/entry/CollapseMeasurementDecision;", "availableHeight", "childCount", "retryCount", "maxRetryCount", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class l {
    public static final d a(int r0, int r1, int r2, int r3) {
        if (r0 <= 0) goto L7;
        if (r1 <= 0) goto L7;
        return new d(CollapseMeasurementAction.EVALUATE_NOW, 0);
    L7:
        if (r2 < r3) goto L11;
        return new d(CollapseMeasurementAction.FORCE_ENABLE_COLLAPSE, r3);
    L11:
        return new d(CollapseMeasurementAction.RETRY, r2 + 1);
    }

    public static /* synthetic */ d a(int r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 8) == 0) goto L6;
        r3 = 3;
    L6:
        return a(r0, r1, r2, r3);
    }

    public static final boolean a(boolean r0, boolean r1) {
        if (r0 == false) goto L5;
        if (r1 == false) goto L5;
        return true;
    L5:
        return false;
    }
}
