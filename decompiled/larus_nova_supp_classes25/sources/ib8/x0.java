package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x0 {
    public final String a;
    public final String b;

    public x0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r6 = (x0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        return "TopHeadRenderInfo(title=" + this.a + ", icon=" + this.b + ')';
    }

    public /* synthetic */ x0(int r1) {
        this("", "");
    }

    public x0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "icon");
        this.a = r2;
        this.b = r3;
    }
}
