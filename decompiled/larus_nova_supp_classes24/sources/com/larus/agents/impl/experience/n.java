package com.larus.agents.impl.experience;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class n {
    public final t a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        return "WorkExperienceDetail(summary=" + this.a + ", details=" + this.b + ", fullContent=" + this.c + ')';
    }

    public n(t r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "summary");
        Intrinsics.checkNotNullParameter(r3, "details");
        Intrinsics.checkNotNullParameter(r4, "fullContent");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
