package com.larus.voicecall.impl;

import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public StateTriggerEvent.Error a;

    public d() {
    }

    public final StateTriggerEvent.Error a(AVKitDuplexState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        StateTriggerEvent.Error r4 = f0.a(r3);
        if (r4 != null) goto L7;
        this.a = null;
        return null;
    L7:
        if (r4 != this.a) goto L9;
        return null;
    L9:
        this.a = r4;
        return r4;
    }
}
