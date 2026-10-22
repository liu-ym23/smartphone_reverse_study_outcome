package com.larus.dora.impl.resource;

import com.larus.dora.api.DoraEnableScope;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final DoraEnableScope a;
    public final Map<String, n> b;

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
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "DoraDeviceResourceGrant(scope=" + this.a + ", artifacts=" + this.b + ')';
    }

    public c(DoraEnableScope r2, Map<String, n> r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "artifacts");
        this.a = r2;
        this.b = r3;
    }
}
