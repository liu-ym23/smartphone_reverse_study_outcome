package com.obric.assistant.state.impl.multitask.consumer;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricTaskFlowPowerResolver$b {
    public final AssistantAliveReason a;
    public final boolean b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricTaskFlowPowerResolver$b) == true) goto L8;
        return false;
    L8:
        ObricTaskFlowPowerResolver$b r6 = (ObricTaskFlowPowerResolver$b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "Mapping(reason=" + this.a + ", active=" + this.b + ')';
    }

    public ObricTaskFlowPowerResolver$b(AssistantAliveReason r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.REASON);
        this.a = r2;
        this.b = r3;
    }
}
