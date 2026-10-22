package com.lark.kmp.storage.kv;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final a a;
    public final com.lark.kmp.storage.c b;
    public final List<? extends b> c;
    public final Mode d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Mode r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "KVStorageConfig(kvRepoFactory=" + this.a + ", spaceResolver=" + this.b + ", provider=" + this.c + ", mode=" + this.d + ')';
    }

    public d(a r2, com.lark.kmp.storage.c r3, List<? extends b> r4, Mode r5) {
        Intrinsics.checkNotNullParameter(r2, "kvRepoFactory");
        Intrinsics.checkNotNullParameter(r3, "spaceResolver");
        Intrinsics.checkNotNullParameter(r4, "provider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
