package com.larus.dora.impl.serviceimpl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AbilityService$c {
    public final List<AbilityService$b> a;
    public final AbilityService.RtcTransport b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AbilityService$c) == true) goto L8;
        return false;
    L8:
        AbilityService$c r6 = (AbilityService$c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "RtcChannelSnapshot(configs=" + this.a + ", transport=" + this.b + ')';
    }

    public AbilityService$c(List<AbilityService$b> r2, AbilityService.RtcTransport r3) {
        Intrinsics.checkNotNullParameter(r2, "configs");
        Intrinsics.checkNotNullParameter(r3, "transport");
        this.a = r2;
        this.b = r3;
    }
}
