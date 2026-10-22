package com.larus.contextwindow.impl.data;

import com.larus.contextwindow.api.ContextWindowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final ContextWindowMode a;
    public final Long b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Long r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ContextWindowModelContext(mode=" + this.a + ", currentModelTotal=" + this.b + ')';
    }

    public c(ContextWindowMode r2, Long r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.a = r2;
        this.b = r3;
    }
}
