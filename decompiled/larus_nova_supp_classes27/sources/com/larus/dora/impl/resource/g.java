package com.larus.dora.impl.resource;

import com.larus.dora.api.DoraEnableScope;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g {
    public static final Set<DoraEnableScope> c = null;
    public final Map<DoraEnableScope, c> a;
    public final Set<DoraEnableScope> b;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
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
        return "DoraFeatureResourceConfigSnapshot(grants=" + this.a + ", invalidScopes=" + this.b + ')';
    }

    static {
        c = SetsKt.setOf(new DoraEnableScope[]{DoraEnableScope.G1, DoraEnableScope.G2});
    }

    public final Set<DoraEnableScope> a() {
        return SetsKt.minus(SetsKt.minus(c, this.a.keySet()), this.b);
    }

    public g(Map<DoraEnableScope, c> r2, Set<? extends DoraEnableScope> r3) {
        Intrinsics.checkNotNullParameter(r2, "grants");
        Intrinsics.checkNotNullParameter(r3, "invalidScopes");
        this.a = r2;
        this.b = r3;
    }
}
