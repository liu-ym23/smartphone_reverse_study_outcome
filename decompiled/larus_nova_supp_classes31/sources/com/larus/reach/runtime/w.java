package com.larus.reach.runtime;

import com.larus.reach.api.ReachRequestSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w {
    public final Integer a;
    public final ns9.m b;
    public final ReachRequestSource c;

    /* JADX WARN: Multi-variable type inference failed */
    public w() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ns9.m r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.c.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachNotifyInput(cmdType=" + this.a + ", reachNotify=" + this.b + ", requestSource=" + this.c + ')';
    }

    public /* synthetic */ w(Integer r3, ns9.m r4, int r5) {
        ReachRequestSource r1 = null;
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r1 = ReachRequestSource.SERVER_CMD;
    L11:
        this(r3, r4, r1);
    }

    public w(Integer r2, ns9.m r3, ReachRequestSource r4) {
        Intrinsics.checkNotNullParameter(r4, "requestSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
