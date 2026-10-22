package com.lark.kmp.rustclient.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a<Resp> {
    public final com.lark.kmp.rustclient.api.model.c<Resp> a;
    public final com.lark.kmp.rustclient.api.model.j b;
    public final String c;
    public final Long d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChainInput(request=" + this.a + ", scopePayload=" + this.b + ", requestUidInstant=" + this.c + ", requestUserContainerIdInstant=" + this.d + ')';
    }

    public a(com.lark.kmp.rustclient.api.model.c<Resp> r2, com.lark.kmp.rustclient.api.model.j r3, String r4, Long r5) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "scopePayload");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
