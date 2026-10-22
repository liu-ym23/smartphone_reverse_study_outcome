package com.larus.bmhome.chat.larkforward;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public e0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
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
        return "FlowLarkToDoubaoTrackParams(larkFirstScene=" + this.a + ", larkSecondScene=" + this.b + ", currentModule=" + this.c + ", enterMethod=" + this.d + ')';
    }

    public /* synthetic */ e0(int r1) {
        this("", "", "", "");
    }

    public e0(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "larkFirstScene");
        Intrinsics.checkNotNullParameter(r3, "larkSecondScene");
        Intrinsics.checkNotNullParameter(r4, "currentModule");
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
