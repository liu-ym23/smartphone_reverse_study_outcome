package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c1 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c1) == true) goto L8;
        return false;
    L8:
        c1 r6 = (c1) r5;
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
        return "FeedbackConfig(baseUrl=" + this.a + ", sourceLogin=" + this.b + ", sourceSetting=" + this.c + ", sourcePayment=" + this.d + ')';
    }

    public c1(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "baseUrl");
        Intrinsics.checkNotNullParameter(r3, "sourceLogin");
        Intrinsics.checkNotNullParameter(r4, "sourceSetting");
        Intrinsics.checkNotNullParameter(r5, "sourcePayment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
