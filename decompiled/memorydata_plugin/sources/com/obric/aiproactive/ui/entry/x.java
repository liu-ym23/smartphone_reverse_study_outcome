package com.obric.aiproactive.ui.entry;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u000eR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/aiproactive/ui/entry/SensingEventsDayCollectorCoordinator;", "", "<init>", "()V", "activeDayAnchorMillis", "", "Ljava/lang/Long;", "tryStart", "", "dayAnchorMillis", "onEmission", "Lcom/obric/aiproactive/ui/entry/SensingEventsDayEmissionDecision;", "currentDayAnchorMillis", "onCollectorStopped", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f6641a;

    public x() {
    }

    public final void a() {
        this.f6641a = null;
    }

    public final boolean a(long r2) {
        if (this.f6641a == null) goto L6;
        return false;
    L6:
        this.f6641a = Long.valueOf(r2);
        return true;
    }

    public final SensingEventsDayEmissionDecision b(long r3) {
        Long r0 = this.f6641a;
        if (r0 == null) goto L9;
        SensingEventsDayEmissionDecision r4 = z.a(r0.longValue(), r3);
        if (r4 != SensingEventsDayEmissionDecision.RESTART) goto L7;
        this.f6641a = null;
    L7:
        return r4;
    L9:
        return SensingEventsDayEmissionDecision.IGNORE;
    }
}
