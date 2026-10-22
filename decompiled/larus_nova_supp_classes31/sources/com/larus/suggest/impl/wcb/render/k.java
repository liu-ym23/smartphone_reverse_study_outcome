package com.larus.suggest.impl.wcb.render;

import com.larus.suggest.impl.wcb.policy.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public final com.larus.suggest.impl.wcb.request.f a;
    public final jx9.a b;
    public final a0 c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "WcbRenderContext(snapshot=" + this.a + ", traceData=" + this.b + ", decision=" + this.c + ')';
    }

    public k(com.larus.suggest.impl.wcb.request.f r2, jx9.a r3, a0 r4) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        Intrinsics.checkNotNullParameter(r3, "traceData");
        Intrinsics.checkNotNullParameter(r4, "decision");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
