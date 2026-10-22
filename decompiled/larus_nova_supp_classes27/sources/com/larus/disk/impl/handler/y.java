package com.larus.disk.impl.handler;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y {
    public final Map<String, String> a;
    public final Map<String, List<String>> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof y) == true) goto L8;
        return false;
    L8:
        y r6 = (y) r5;
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
        return "OfflineResourceCleanTargets(groups=" + this.a + ", channels=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(Map<String, String> r2, Map<String, ? extends List<String>> r3) {
        Intrinsics.checkNotNullParameter(r2, "groups");
        Intrinsics.checkNotNullParameter(r3, "channels");
        this.a = r2;
        this.b = r3;
    }
}
