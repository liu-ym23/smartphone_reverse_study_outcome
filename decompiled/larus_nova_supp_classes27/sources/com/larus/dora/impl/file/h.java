package com.larus.dora.impl.file;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public final DoraFileFetchTask a;
    public final DoraFileStreamingSinkReason b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "DoraFileStreamingSinkTaskWrapper(task=" + this.a + ", reason=" + this.b + ')';
    }

    public h(DoraFileFetchTask r2, DoraFileStreamingSinkReason r3) {
        Intrinsics.checkNotNullParameter(r2, "task");
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a = r2;
        this.b = r3;
    }
}
