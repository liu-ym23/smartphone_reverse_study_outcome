package com.larus.avlink.gallery.storage;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public final Set<String> a;
    public final Set<String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
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
        return "ProtectedPaths(exactPaths=" + this.a + ", directoryPaths=" + this.b + ')';
    }

    public n(Set<String> r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "exactPaths");
        Intrinsics.checkNotNullParameter(r3, "directoryPaths");
        this.a = r2;
        this.b = r3;
    }
}
