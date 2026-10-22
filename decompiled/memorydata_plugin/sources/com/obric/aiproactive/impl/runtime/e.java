package com.obric.aiproactive.impl.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a0\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0000¨\u0006\f"}, d2 = {"resolveProactiveRecommendationEnabled", "", "ready", "proactiveAgentEnabled", "wakeUpPreferenceEnabled", "resolveProactiveDbPreparationEligible", "shouldNotifyProactiveRecommendationListeners", "forceNotify", "oldEnabled", "enabled", "oldDbPreparationEligible", "dbPreparationEligible", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class e {
    public static final boolean a(boolean r0, boolean r1) {
        if (r0 == false) goto L5;
        if (r1 == false) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2) {
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        if (r2 == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2, boolean r3, boolean r4) {
        if (r0 == true) goto L7;
        if (r1 != r2) goto L7;
        if (r3 != r4) goto L7;
        return false;
    L7:
        return true;
    }
}
