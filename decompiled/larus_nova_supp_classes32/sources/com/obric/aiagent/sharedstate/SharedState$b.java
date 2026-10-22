package com.obric.aiagent.sharedstate;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SharedState$b {
    public final long a;
    public final List<String> b;
    public final StateChangeListener c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SharedState$b) == true) goto L8;
        return false;
    L8:
        SharedState$b r9 = (SharedState$b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "PendingRegistration(id=" + this.a + ", keys=" + this.b + ", observer=" + this.c + ')';
    }

    public SharedState$b(long r2, List<String> r4, StateChangeListener r5) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        Intrinsics.checkNotNullParameter(r5, "observer");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
