package com.larus.voicecall.impl;

import com.larus.audio.call.mgr.StateTriggerEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 {
    public final String a;
    public final StateTriggerEvent.Error b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r6 = (c0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        return "RealtimeRetryRequest(callId=" + this.a + ", errorEvent=" + this.b + ')';
    }

    public c0(String r2, StateTriggerEvent.Error r3) {
        Intrinsics.checkNotNullParameter(r2, "callId");
        Intrinsics.checkNotNullParameter(r3, "errorEvent");
        this.a = r2;
        this.b = r3;
    }
}
