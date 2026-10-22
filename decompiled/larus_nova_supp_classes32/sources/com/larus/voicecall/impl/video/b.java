package com.larus.voicecall.impl.video;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final List<a> a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "BrushPath(dotList=" + this.a + ')';
    }

    public b(Object r2) {
        ArrayList r3 = new ArrayList();
        Intrinsics.checkNotNullParameter(r3, "dotList");
        this.a = r3;
    }
}
