package com.larus.bmhome.social.page.datasource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e<Key> {
    public final Key a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Key r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowPagingRequest(offset=" + this.a + ", pageSize=" + this.b + ')';
    }

    public e() {
        this.a = null;
        this.b = 0;
    }
}
