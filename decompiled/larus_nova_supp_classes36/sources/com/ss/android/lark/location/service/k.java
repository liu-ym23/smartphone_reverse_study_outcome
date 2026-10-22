package com.ss.android.lark.location.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k {
    public final MapSource a;
    public final SearchResultErrorCode b;
    public final Object c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "SearchResultError(source=" + this.a + ", errorCode=" + this.b + ", rawErrorCode=" + this.c + ')';
    }

    public k(MapSource r5, SearchResultErrorCode r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "errorCode");
        Intrinsics.checkNotNull(Integer.valueOf(r7), "null cannot be cast to non-null type kotlin.Any");
        Integer r8 = Integer.valueOf(r7);
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "errorCode");
        Intrinsics.checkNotNullParameter(r8, "rawErrorCode");
        this.a = r5;
        this.b = r6;
        this.c = r8;
    }
}
