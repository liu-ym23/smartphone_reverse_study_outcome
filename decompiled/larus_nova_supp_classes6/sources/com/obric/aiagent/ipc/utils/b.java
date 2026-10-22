package com.obric.aiagent.ipc.utils;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public final List<IPCAnomalyType> a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return "IPCAnomalyDecision(anomalyTypes=" + this.a + ", windowCount=" + this.b + ')';
    }

    public b(List<? extends IPCAnomalyType> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "anomalyTypes");
        this.a = r2;
        this.b = r3;
    }
}
