package com.larus.dora.impl.serviceimpl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class AbilityService$b {
    public final int a;
    public final int b;
    public final int c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AbilityService$b) == true) goto L8;
        return false;
    L8:
        AbilityService$b r6 = (AbilityService$b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "RtcChannelConfigSnapshot(channelID=" + this.a + ", localPort=" + this.b + ", targetPort=" + this.c + ", hostAddress=" + this.d + ')';
    }

    public AbilityService$b(int r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "hostAddress");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
