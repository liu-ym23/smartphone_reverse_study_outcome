package com.larus.dora.impl.resource;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class o {
    public final m a;
    public final Set<String> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
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
        return "DoraResourceArtifactState(identity=" + this.a + ", files=" + this.b + ')';
    }

    public final m a() {
        return this.a;
    }

    public o(m r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "identity");
        Intrinsics.checkNotNullParameter(r3, "files");
        this.a = r2;
        this.b = r3;
    }
}
