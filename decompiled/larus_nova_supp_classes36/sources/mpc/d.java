package mpc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public d() {
        this(0);
    }

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
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "ForwardToDoubaoTrackParams(larkFirstScene=" + this.a + ", larkSecondScene=" + this.b + ", currentModule=" + this.c + ", enterMethod=" + this.d + ')';
    }

    public d(int r2) {
        Intrinsics.checkNotNullParameter("", "larkFirstScene");
        Intrinsics.checkNotNullParameter("", "larkSecondScene");
        Intrinsics.checkNotNullParameter("", "currentModule");
        Intrinsics.checkNotNullParameter("", "enterMethod");
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
    }
}
