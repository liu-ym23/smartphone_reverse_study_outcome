package com.bytedance.android.ec.core.arch.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<A> {
    public final A a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((f) r10).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        A r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "StateTuple1(a=" + this.a + ")";
    }

    public f(A r1) {
        this.a = r1;
    }
}
