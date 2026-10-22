package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class x {
    public static final x b = null;
    public final String a;

    public static final class a {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof x) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((x) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    static {
        b = new x("unknown");
    }

    public final String toString() {
        return this.a;
    }

    public x(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a = r2;
    }
}
