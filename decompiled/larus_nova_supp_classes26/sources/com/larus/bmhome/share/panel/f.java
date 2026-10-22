package com.larus.bmhome.share.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final String a;
    public final String b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "ManualImageMetadataInfo(produceId=" + this.a + ", produceIdType=" + this.b + ", messageCount=" + this.c + ')';
    }

    public f(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "produceId");
        Intrinsics.checkNotNullParameter(r3, "produceIdType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
