package com.obric.assistant.state.impl.multitask.consumer;

import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class InteractionProjectionServiceImpl$d {
    public final ForegroundInteractionPhase a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InteractionProjectionServiceImpl$d) == true) goto L8;
        return false;
    L8:
        InteractionProjectionServiceImpl$d r6 = (InteractionProjectionServiceImpl$d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "PhaseOverride(phase=" + this.a + ", sessionId=" + this.b + ')';
    }

    public InteractionProjectionServiceImpl$d(ForegroundInteractionPhase r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "phase");
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        this.a = r2;
        this.b = r3;
    }
}
