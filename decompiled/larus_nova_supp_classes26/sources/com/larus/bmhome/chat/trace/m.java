package com.larus.bmhome.chat.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public String a;
    public String b;

    public m() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        return "ChatControlTraceInfo(beforeEditMsg=" + this.a + ", afterEditMsg=" + this.b + ')';
    }

    public m(int r2) {
        Intrinsics.checkNotNullParameter("", "beforeEditMsg");
        Intrinsics.checkNotNullParameter("", "afterEditMsg");
        this.a = "";
        this.b = "";
    }
}
