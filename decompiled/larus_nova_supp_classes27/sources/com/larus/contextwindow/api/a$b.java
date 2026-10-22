package com.larus.contextwindow.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a$b implements a {
    public final ContextWindowSnapshot a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a$b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((a$b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Visible(snapshot=" + this.a + ')';
    }

    public a$b(ContextWindowSnapshot r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        this.a = r2;
    }
}
