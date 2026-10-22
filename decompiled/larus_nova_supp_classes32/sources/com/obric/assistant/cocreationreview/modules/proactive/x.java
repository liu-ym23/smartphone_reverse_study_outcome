package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.g5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x {
    public final long a;
    public final g5 b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof x) == true) goto L8;
        return false;
    L8:
        x r9 = (x) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ProactiveLoadTicket(sequence=" + this.a + ", request=" + this.b + ')';
    }

    public x(long r2, g5 r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        this.a = r2;
        this.b = r4;
    }
}
